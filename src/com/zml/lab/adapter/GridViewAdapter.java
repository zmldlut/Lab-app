package com.zml.lab.adapter;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zml.lab.ui.R;

public class GridViewAdapter extends BaseAdapter {

    private List<Map<String, Object>> mData;
    private Context mContext;
    private int mItemLy;
    private GridView mGridView;

    public GridViewAdapter(Context paramContext, List<Map<String, Object>> paramList, int itemLy, GridView gridView)
    {
        this.mData = paramList;
        this.mContext = paramContext;
        this.mItemLy = itemLy;
        this.mGridView = gridView;
    }

    public List<Map<String, Object>> getListData() {
        return mData;
    }

    public void setListData(List<Map<String, Object>> listData) {
        this.mData = listData;
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
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        ViewHolder holder = null;
        if (paramView == null) {
            holder = new ViewHolder();
            paramView = LayoutInflater.from(mContext).inflate(mItemLy, paramViewGroup , false);
            holder.itemsIcon = ((ImageView)paramView.findViewById(R.id.imageView_grid));
            holder.itemsText = ((TextView)paramView.findViewById(R.id.textView_grid));
            paramView.setTag(holder);
        } else {
            holder = (ViewHolder) paramView.getTag();
        }
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -15 + this.mGridView.getHeight() / 3);
        final Map<String, Object>  obj = (Map<String, Object>)mData.get(paramInt);
        holder.itemsIcon.setBackgroundResource((Integer)obj.get("itemsIcon"));
        holder.itemsIcon.setLayoutParams(localLayoutParams);
        holder.itemsText.setText((String)obj.get("itemsText"));
        return paramView;
    }
}
