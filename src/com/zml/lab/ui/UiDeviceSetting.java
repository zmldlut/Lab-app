package com.zml.lab.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.zml.lab.adapter.CheckListViewAdapter;
import com.zml.lab.adapter.GalleryAdapter;
import com.zml.lab.base.BaseUi;
import com.zml.lab.view.CustomGallery;

public class UiDeviceSetting extends BaseUi {
    
    private LinearLayout mGalleryLy;
    private CustomGallery mGalleryFlow;
    private ListView mListView;
    private List<Map<String, Object>> mListData;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAbContentView(R.layout.ui_device_setting);
        init();
    }
    
    private void init() {
        initListView();
        initGallery();
    }
    
    private void initGallery() {
        this.mGalleryLy = (LinearLayout) this.findViewById(R.id.include_gallery);
        this.mGalleryFlow = (CustomGallery) mGalleryLy.findViewById(R.id.gallery);
        int[] arrayOfInt = {
                R.drawable.monitor_ip,
                R.drawable.monitor_dvr,
                R.drawable.monitor_cloud
        };
        String[] arrayOfString = {
                "IP摄像头",
                "硬盘摄像头",
                "云摄像头"
        };
        GalleryAdapter localImageAdapter = new GalleryAdapter(this, arrayOfInt, arrayOfString);
        localImageAdapter.createImageViews();
        this.mGalleryFlow.setAdapter(localImageAdapter);
        localImageAdapter.notifyDataSetChanged();
    }

    private void initListView() {
        this.mListView = (ListView) this.findViewById(R.id.listView_share);
        this.mListData = new ArrayList<Map<String, Object>> ();
        Map<String, Object> map = new HashMap<String, Object>();
        
        //0
        map = new HashMap<String, Object>();
        map.put("itemsIcon", R.drawable.device_light);
        map.put("itemsTitle", "item1");
        map.put("itemsText", "item1...");
        map.put("itemsCheck", false);
        mListData.add(map);
        
        //1
        map = new HashMap<String, Object>();
        map.put("itemsIcon", R.drawable.device_curtain);
        map.put("itemsTitle", "item2");
        map.put("itemsText", "item2...");
        map.put("itemsCheck", true);
        mListData.add(map);
        
        //2
        map = new HashMap<String, Object>();
        map.put("itemsIcon", R.drawable.device_door);
        map.put("itemsTitle", "item3");
        map.put("itemsText", "item3...");
        map.put("itemsCheck", true);
        mListData.add(map);
        
        //够造SimpleAdapter对象，适配数据
        CheckListViewAdapter simpleAdapter = new CheckListViewAdapter(this, mListData, R.layout.list_items_button,
                    new String[] {"itemsIcon", "itemsTitle","itemsText","itemsCheck" }, new int[] {
                            R.id.itemsIcon, R.id.itemsTitle,R.id.itemsText,R.id.mSliderBtn});
        mListView.setAdapter(simpleAdapter);
        
        //item被点击事件
        mListView.setOnItemClickListener(new OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {
            }
        });
    }
}
