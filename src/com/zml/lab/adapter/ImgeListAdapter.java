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

public class ImgeListAdapter extends BaseAdapter {

    private Context mContext;
    //xml转View对象
    private LayoutInflater mInflater;
    //单行的布�?
    private int mResource;
    //列表展现的数�?
    private List mData;
    //Map中的key
    private String[] mFrom;
    //view的id
    private int[] mTo;
//    private AbImageDownloadQueue mAbImageDownloadQueue = null;
    
    public ImgeListAdapter(Context context, List data,
            int resource, String[] from, int[] to){
        this.mContext = context;
        this.mData = data;
        this.mResource = resource;
        this.mFrom = from;
        this.mTo = to;
        //用于将xml转为View
        this.mInflater = LayoutInflater.from(mContext);
//        this.mAbImageDownloadQueue = AbImageDownloadQueue.getInstance();
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int arg0) {
        return mData.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        return arg0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final ViewHolder holder;
        if(convertView == null){
             //使用自定义的list_items作为Layout
             convertView = mInflater.inflate(mResource, parent, false);
             //减少findView的次�?
             holder = new ViewHolder();
             //初始化布�?��的元�?
             holder.itemsIcon = ((ImageView) convertView.findViewById(mTo[0]));
             holder.itemsTitle = ((TextView) convertView.findViewById(mTo[1]));
             holder.itemsText = ((TextView) convertView.findViewById(mTo[2]));
             convertView.setTag(holder);
        }else{
             holder = (ViewHolder) convertView.getTag();
        }
      //获取该行的数�?
        final Map<String, Object>  obj = (Map<String, Object>)mData.get(position);
        holder.itemsIcon.setBackgroundResource((Integer)obj.get("itemsIcon"));
        holder.itemsTitle.setText((String)obj.get("itemsTitle"));
        holder.itemsText.setText((String)obj.get("itemsText"));
//        holder.itemsBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //showInfo();
//            }
//        });
        return convertView;
    }
}
