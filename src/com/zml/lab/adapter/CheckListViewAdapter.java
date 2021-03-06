package com.zml.lab.adapter;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.zml.lab.ui.UiDeviceSetting;
import com.zml.lab.view.SwitchButton;


public class CheckListViewAdapter extends BaseAdapter {

    private Context mContext;
    //单行的布局
    private int mResource;
    //列表展现的数据
    private List<? extends Map<String, ?>> mData;
    //Map中的key
    private String[] mFrom;
    //view的id
    private int[] mTo;
    
    public CheckListViewAdapter(Context context, List<? extends Map<String, ?>> data,
            int resource, String[] from, int[] to){
         mContext = context;
         mData = data;
         mResource = resource;
         mFrom = from;
         mTo = to;
    }   
    
    @Override
    public int getCount() {
        return mData.size();
    }
    
    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position){
      return position;
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
          final ViewHolder holder;
          if(convertView == null){
              //使用自定义的list_items作为Layout
              convertView = LayoutInflater.from(mContext).inflate(mResource, parent, false);
              //使用减少findView的次数
              holder = new ViewHolder();
              holder.itemsIcon = ((ImageView) convertView.findViewById(mTo[0]));
              holder.itemsTitle = ((TextView) convertView.findViewById(mTo[1]));
              holder.itemsText = ((TextView) convertView.findViewById(mTo[2]));
              holder.itemsCheck = ((SwitchButton) convertView.findViewById(mTo[3])) ;
              //设置标记
              convertView.setTag(holder);
          }else{
              holder = (ViewHolder) convertView.getTag();
          }
          //设置数据
          final Map<String, ?> dataSet = mData.get(position);
          if (dataSet == null) {
              return null;
          }
          //获取该行数据
          final Object data0 = dataSet.get(mFrom[0]);
          final Object data1 = dataSet.get(mFrom[1]);
          final Object data2 = dataSet.get(mFrom[2]);
          final Object data3 = dataSet.get(mFrom[3]);
          //设置数据到View
          holder.itemsIcon.setBackgroundResource((Integer)data0);
          holder.itemsTitle.setText(data1.toString());
          holder.itemsText.setText(data2.toString());
          holder.itemsCheck.setChecked((Boolean)data3);

          final int p = position;
          
          holder.itemsCheck.setOnCheckedChangeListener(new OnCheckedChangeListener() {
              
              @Override
              public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
                  switch(p) {
                  case 0:
                      ((UiDeviceSetting)mContext).packetType = 1006;
                      ((UiDeviceSetting)mContext).node_id = 6;
                      ((UiDeviceSetting)mContext).cmd = 1;
                      break;
                  case 1:
                      ((UiDeviceSetting)mContext).packetType = 1005;
                      ((UiDeviceSetting)mContext).node_id = 5;
                      ((UiDeviceSetting)mContext).cmd = 1;
                      break;
                  case 2:
                      ((UiDeviceSetting)mContext).packetType = 1003;
                      ((UiDeviceSetting)mContext).node_id = 4;
                      ((UiDeviceSetting)mContext).cmd = 1;
                      break;
                  default:
                      break;
                  }
                  if(isChecked){ 
                      ((UiDeviceSetting)mContext).cmd = 1;
                  }else{ 
                      ((UiDeviceSetting)mContext).cmd = 2;
                  }
                  
                  if(!isChecked && p == 2) {
                      return;
                  }
                  ((UiDeviceSetting)mContext).doTaskOperate();
                  Log.e("zml", isChecked+"isChecked");
                  Log.e("zml", p+"p");
              }
          });
          return convertView;
    }
}
