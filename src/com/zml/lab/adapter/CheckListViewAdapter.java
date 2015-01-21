package com.zml.lab.adapter;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zml.lab.view.SwitchButton;


public class CheckListViewAdapter extends BaseAdapter {

    private Context mContext;
    //���еĲ���
    private int mResource;
    //�б�չ�ֵ�����
    private List<? extends Map<String, ?>> mData;
    //Map�е�key
    private String[] mFrom;
    //view��id
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
              //ʹ���Զ����list_items��ΪLayout
              convertView = LayoutInflater.from(mContext).inflate(mResource, parent, false);
              //ʹ�ü���findView�Ĵ���
              holder = new ViewHolder();
              holder.itemsIcon = ((ImageView) convertView.findViewById(mTo[0]));
              holder.itemsTitle = ((TextView) convertView.findViewById(mTo[1]));
              holder.itemsText = ((TextView) convertView.findViewById(mTo[2]));
              holder.itemsCheck = ((SwitchButton) convertView.findViewById(mTo[3])) ;
              //���ñ��
              convertView.setTag(holder);
          }else{
              holder = (ViewHolder) convertView.getTag();
          }
          //��������
          final Map<String, ?> dataSet = mData.get(position);
          if (dataSet == null) {
              return null;
          }
          //��ȡ��������
          final Object data0 = dataSet.get(mFrom[0]);
          final Object data1 = dataSet.get(mFrom[1]);
          final Object data2 = dataSet.get(mFrom[2]);
          final Object data3 = dataSet.get(mFrom[3]);
          //�������ݵ�View
          holder.itemsIcon.setBackgroundResource((Integer)data0);
          holder.itemsTitle.setText(data1.toString());
          holder.itemsText.setText(data2.toString());
          holder.itemsCheck.setChecked((Boolean)data3);
//          Log.e("zml", holder.itemsCheck.setChecked((Boolean)data3, false, true)+"");
          return convertView;
    }
}
