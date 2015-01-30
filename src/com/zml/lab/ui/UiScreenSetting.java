package com.zml.lab.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.zml.lab.adapter.CheckListViewAdapter;
import com.zml.lab.adapter.GalleryAdapter;
import com.zml.lab.base.BaseMessage;
import com.zml.lab.base.BaseUi;
import com.zml.lab.base.C;
import com.zml.lab.view.CustomGallery;

public class UiScreenSetting extends BaseUi {
    
    private LinearLayout mGalleryLy;
    private CustomGallery mGalleryFlow;
    private ListView mListView;
    private List<Map<String, Object>> mListData;

    public int packetType = 1003;
    public int node_id = 4;
    public int cmd = 1;
    
    private List<Map> mData;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAbContentView(R.layout.ui_scene_setting);
        init();
    }
    
    private void init() {
        initListView();
        initGallery();
        logoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    
    private void initGallery() {
        this.mGalleryLy = (LinearLayout) this.findViewById(R.id.include_gallery);
        this.mGalleryFlow = (CustomGallery) mGalleryLy.findViewById(R.id.gallery);
        this.mData = new ArrayList<Map>();
        int[] arrayOfInt = {
                R.drawable.room_820,
        };
        String[] arrayOfString = {
                "820实验室"
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
        map.put("itemsTitle", "灯光");
        map.put("itemsText", "820实验室1号灯光");
        map.put("itemsCheck", false);
        mListData.add(map);
        
        //1
        map = new HashMap<String, Object>();
        map.put("itemsIcon", R.drawable.device_curtain);
        map.put("itemsTitle", "窗帘");
        map.put("itemsText", "820实验室1号窗帘");
        map.put("itemsCheck", false);
        mListData.add(map);
        
        //2
        map = new HashMap<String, Object>();
        map.put("itemsIcon", R.drawable.device_door);
        map.put("itemsTitle", "门锁");
        map.put("itemsText", "820实验室1号门锁");
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
    
    public void doTaskOperate() {
        HashMap<String, String> urlParams = new HashMap<String, String>();
        urlParams.put("packetType", packetType+"");
        urlParams.put("node_id", node_id+"");
        urlParams.put("cmd", cmd+"");
        try {
            this.doTaskAsync(C.task.operate, C.api.operate, urlParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // async task callback methods
    @Override
    public void onTaskComplete(int taskId, BaseMessage message) {
        super.onTaskComplete(taskId, message);
        switch (taskId) {
            case C.task.operate:
                toast("服务器已经接收到您的命令！");
        }
    }
    
    @Override
    public void initTitle() {
//      this.setTitleText(R.string.app_name);
        this.setLogo(R.drawable.button_selector_back);
        super.initTitle();
  }
}
