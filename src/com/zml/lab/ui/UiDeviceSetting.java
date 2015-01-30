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
import com.zml.lab.base.BaseMessage;
import com.zml.lab.base.BaseUi;
import com.zml.lab.base.C;
import com.zml.lab.view.CustomGallery;

public class UiDeviceSetting extends BaseUi {

    private LinearLayout mGalleryLy;
    private CustomGallery mGalleryFlow;
    private ListView mListView;
    private List<Map<String, Object>> mListData;

    public int packetType = 1003;
    public int node_id = 4;
    public int cmd = 1;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAbContentView(R.layout.ui_device_setting);
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
        Bundle b=getIntent().getExtras();
        int key = b.getInt("key");
        int[] arrayOfInt = {
                R.drawable.controller_820,
        };
        String[] arrayOfString = {
                "���ƹ���",
        };
        switch(key) {
        case 0:
            arrayOfInt[0] = R.drawable.room_820;
            arrayOfString[0] = "820ʵ����";
            break;
        case 1:
            arrayOfInt[0] = R.drawable.controller_820;
            arrayOfString[0] = "���ƹ���";
            break;
        case 2:
            arrayOfInt[0] = R.drawable.controller_820;
            arrayOfString[0] = "���ƹ���";
            break;
        case 3:
            arrayOfInt[0] = R.drawable.controller_820;
            arrayOfString[0] = "���ƹ���";
            break;
        default:
            break;
        }

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
        map.put("itemsTitle", "�ƹ�");
        map.put("itemsText", "820ʵ����1�ŵƹ�");
        map.put("itemsCheck", false);
        mListData.add(map);
        
        //1
        map = new HashMap<String, Object>();
        map.put("itemsIcon", R.drawable.device_curtain);
        map.put("itemsTitle", "����");
        map.put("itemsText", "820ʵ����1�Ŵ���");
        map.put("itemsCheck", false);
        mListData.add(map);
        
        //2
        map = new HashMap<String, Object>();
        map.put("itemsIcon", R.drawable.device_door);
        map.put("itemsTitle", "����");
        map.put("itemsText", "820ʵ����1������");
        map.put("itemsCheck", false);
        mListData.add(map);
        
        //����SimpleAdapter������������
        CheckListViewAdapter simpleAdapter = new CheckListViewAdapter(this, mListData, R.layout.list_items_button,
                    new String[] {"itemsIcon", "itemsTitle","itemsText","itemsCheck" }, new int[] {
                            R.id.itemsIcon, R.id.itemsTitle,R.id.itemsText,R.id.mSliderBtn});
        mListView.setAdapter(simpleAdapter);
        
        //item������¼�
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
                toast("�������Ѿ����յ��������");
        }
    }
    

    @Override
    public void initTitle() {
//      this.setTitleText(R.string.app_name);
        this.setLogo(R.drawable.button_selector_back);
        super.initTitle();
  }
}
