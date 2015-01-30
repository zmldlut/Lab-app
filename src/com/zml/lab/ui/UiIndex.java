package com.zml.lab.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.zml.lab.adapter.GridViewAdapter;
import com.zml.lab.base.BaseUi;

public class UiIndex extends BaseUi {

    private GridView mGridView;
    private List<Map<String, Object>> mData;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAbContentView(R.layout.ui_index);
        init();
    }

    private void init() {
        mData = new ArrayList<Map<String, Object>>();
        String [] texts = {
                this.getString(R.string.main_home_scene),
//                this.getString(R.string.main_home_room),
                this.getString(R.string.main_home_devices),
//                this.getString(R.string.main_home_monitor),
                this.getString(R.string.main_home_system),
                this.getString(R.string.main_home_more),
        };
        int [] imgs = {
                R.drawable.main_home_scene,
//                R.drawable.main_home_room,
                R.drawable.main_home_devices,
//                R.drawable.main_home_monitor,
                R.drawable.main_home_system,
                R.drawable.main_home_more,
        };
        Map<String, Object> map;
        for(int i=0; i < texts.length; i++) {
            map = new HashMap<String, Object>();
            map.put("itemsIcon", imgs[i]);
            map.put("itemsText", texts[i]);
            mData.add(map);
        }
        
        mGridView = (GridView) findViewById(R.id.gridView_main);
        mGridView.setAdapter(new GridViewAdapter(this, mData, R.layout.general_griditem, mGridView));
        doGridViewClick();
    }
    
    private void doGridViewClick()
    {
        this.mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {
                Bundle bundle = new Bundle();
                
                switch (paramAnonymousInt) {
                case 0:
                    bundle.putInt("key", 0);
                    forward(UiDeviceSetting.class, bundle);
                    break;
                case 1:
                    bundle.putInt("key", 1);
                    forward(UiDeviceSetting.class, bundle);
                    break;
                case 2:
                    bundle.putInt("key", 2);
                    forward(UiDeviceSetting.class, bundle);
                    break;
                case 3:
                    bundle.putInt("key", 3);
                    forward(UiDeviceSetting.class, bundle);
                    break;
                default:
                    break;
                }
            }
      });
    }
    
    @Override
    public void forward (Class<?> classObj) {
        Intent intent = new Intent();
        intent.setClass(this, classObj);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        this.startActivity(intent);
    }
    @Override
    public void forward (Class<?> classObj, Bundle params) {
        Intent intent = new Intent();
        intent.setClass(this, classObj);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtras(params);
        this.startActivity(intent);
    }
}
