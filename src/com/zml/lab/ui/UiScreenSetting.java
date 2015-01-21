package com.zml.lab.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.zml.lab.adapter.GalleryAdapter;
import com.zml.lab.base.BaseUi;
import com.zml.lab.view.CustomGallery;

public class UiScreenSetting extends BaseUi {
    
    private LinearLayout mGalleryLy;
    private CustomGallery mGalleryFlow;
    
    private List<Map> mData;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAbContentView(R.layout.ui_scene_setting);
        init();
    }
    
    private void init() {
        this.mGalleryLy = (LinearLayout) this.findViewById(R.id.include_gallery);
        this.mGalleryFlow = (CustomGallery) mGalleryLy.findViewById(R.id.gallery);
        this.mData = new ArrayList<Map>();
        int[] arrayOfInt = {
                R.drawable.monitor_ip,
                R.drawable.monitor_dvr,
                R.drawable.monitor_cloud
        };
        String[] arrayOfString = {
                "IPÉãÏñÍ·",
                "Ó²ÅÌÉãÏñÍ·",
                "ÔÆÉãÏñÍ·"
        };
        GalleryAdapter localImageAdapter = new GalleryAdapter(this, arrayOfInt, arrayOfString);
        localImageAdapter.createImageViews();
        this.mGalleryFlow.setAdapter(localImageAdapter);
        localImageAdapter.notifyDataSetChanged();
    }
}
