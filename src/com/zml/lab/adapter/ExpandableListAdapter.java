package com.zml.lab.adapter;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private List<Map> mChildListData;
    private Context mContext;
    private List<Map> mGroupListData;

    public ExpandableListAdapter(List<Map> paramList1, List<Map> paramList2, Context paramContext) {
        this.mGroupListData = paramList1;
        this.mChildListData = paramList2;
        this.mContext = paramContext;
    }

    public void changeData(List<Map> paramList1, List<Map> paramList2) {
        this.mGroupListData = paramList1;
        this.mChildListData = paramList2;
        notifyDataSetChanged();
    }

    @Override
    public Object getChild(int arg0, int arg1) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getChildId(int arg0, int arg1) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getChildView(int arg0, int arg1, boolean arg2, View arg3,
            ViewGroup arg4) {
        return null;
//        return makeChildView((Map)this.mChildListData.get(arg1), arg3, arg0, arg1);
    }

    @Override
    public int getChildrenCount(int arg0) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Object getGroup(int arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getGroupCount() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public long getGroupId(int arg0) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getGroupView(int arg0, boolean arg1, View arg2, ViewGroup arg3) {
        return null;
//        return makeGroupView((Map)this.mGroupListData.get(arg0), arg2, arg1, arg0);
    }

    @Override
    public boolean hasStableIds() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isChildSelectable(int arg0, int arg1) {
        // TODO Auto-generated method stub
        return false;
    }

//    private void initTaskAvailableStatus(Map paramMap1, Map paramMap2, ViewHolder paramViewHolder) {
//        String str1 = null;
//        String str2 = null;
//        String str3 = null;
//        if (paramMap1 != null) {
//            str1 = String.valueOf(paramMap1.get("T_TASK_SENSOR_ID"));
//            str2 = String.valueOf(paramMap1.get("T_TASK_AVAILABLE"));
//            str3 = String.valueOf(paramMap1.get("T_TASK_TIMER_AVAILABLE"));
//      }
//      if (StringUtil.isNullOrEmpty(str1))
//        str1 = "-1";
//      String str4 = null;
//      String str5 = null;
//      if (paramMap2 != null)
//      {
//        str4 = String.valueOf(paramMap2.get("T_TASK_AVAILABLE"));
//        str5 = String.valueOf(paramMap2.get("T_TASK_TIMER_AVAILABLE"));
//      }
//      if ("1".equals(str2))
//        if ("-1".equals(str1))
//        {
//          paramViewHolder.taskAutoOpen.setImageResource(2130837878);
//          if (!"1".equals(str3))
//            break label243;
//          paramViewHolder.taskTimerOpen.setImageResource(2130837894);
//          label148: if (!"1".equals(str4))
//            break label267;
//          if (!"-1".equals(str1))
//            break label255;
//          paramViewHolder.taskAutoClose.setImageResource(2130837878);
//          label177: if (!"1".equals(str5))
//            break label301;
//          paramViewHolder.taskTimerClose.setImageResource(2130837894);
//        }
//      while (true)
//      {
//        return;
//        paramViewHolder.taskAutoOpen.setImageResource(2130837880);
//        break;
//        if ("-1".equals(str1))
//        {
//          paramViewHolder.taskAutoOpen.setImageResource(2130837877);
//          break;
//        }
//        paramViewHolder.taskAutoOpen.setImageResource(2130837879);
//        break;
//        label243: paramViewHolder.taskTimerOpen.setImageResource(2130837893);
//        break label148;
//        label255: paramViewHolder.taskAutoClose.setImageResource(2130837880);
//        break label177;
//        label267: if ("-1".equals(str1))
//        {
//          paramViewHolder.taskAutoClose.setImageResource(2130837877);
//          break label177;
//        }
//        paramViewHolder.taskAutoClose.setImageResource(2130837879);
//        break label177;
//        label301: paramViewHolder.taskTimerClose.setImageResource(2130837893);
//      }
//    }

//    private View makeChildView(Map paramMap, View paramView, int paramInt1, int paramInt2) {
//        Map localMap1 = (Map)paramMap.get("2");
//        Map localMap2 = (Map)paramMap.get("3");
//        String str = null;
//        if (localMap1 != null)
//            str = String.valueOf(localMap1.get("T_DEVICE_EP_NAME"));
//        if (StringUtil.isNullOrEmpty(str)) {
//            StringBuilder localStringBuilder = new StringBuilder(String.valueOf(this.mContext.getString(2131427434)));
//            paramInt2++;
//            str = paramInt2;
//        }
//        ViewHolder localViewHolder;
//        if (paramView == null) {
//            localViewHolder = new ViewHolder();
//            paramView = View.inflate(this.mContext, 2130903143, null);
//            localViewHolder.nameLayout = ((LinearLayout)paramView.findViewById(2131231116));
//            localViewHolder.valueLayout = ((LinearLayout)paramView.findViewById(2131231117));
//            localViewHolder.nameTextView = ((TextView)paramView.findViewById(2131230811));
//            localViewHolder.taskAutoOpen = ((ImageView)paramView.findViewById(2131231118));
//            localViewHolder.taskAutoClose = ((ImageView)paramView.findViewById(2131231119));
//            localViewHolder.taskTimerOpen = ((ImageView)paramView.findViewById(2131231120));
//            localViewHolder.taskTimerClose = ((ImageView)paramView.findViewById(2131231121));
//            paramView.setTag(localViewHolder);
//        }
//        while (true) {
//            localViewHolder.nameTextView.setText(str);
//            initTaskAvailableStatus(localMap1, localMap2, localViewHolder);
//            paramView.setTag(2131230816, Integer.valueOf(paramInt1));
//            paramView.setTag(2131230817, Integer.valueOf(paramInt2));
//            return paramView;
//            localViewHolder = (ViewHolder)paramView.getTag();
//        }
//    }
//
//    private View makeGroupView(Map paramMap, View paramView, boolean paramBoolean, int paramInt)
//    {
//        String str1 = String.valueOf(paramMap.get("T_AREA_NAME"));
//        String str2 = String.valueOf(paramMap.get("T_DEVICE_NAME"));
//        String str3 = String.valueOf(paramMap.get("T_DEVICE_TYPE"));
//        int i = DeviceTool.getDevDefaultIcon(str3, String.valueOf(paramMap.get("T_DEVICE_CATEGORY")));
//        Map localMap1 = (Map)paramMap.get("T_DEVICE_DATA");
//        Map localMap2 = null;
//        Map localMap3 = null;
//        if (localMap1 != null)
//        {
//            Map localMap4 = MapListTool.getFirstElement(localMap1);
//            if (localMap4 != null)
//            {
//                localMap2 = (Map)localMap4.get("2");
//                localMap3 = (Map)localMap4.get("3");
//            }
//        }
//        ViewHolder localViewHolder;
//        if (paramView == null)
//        {
//            localViewHolder = new ViewHolder();
//            paramView = View.inflate(this.mContext, 2130903145, null);
//            localViewHolder.devIconImageView = ((ImageView)paramView.findViewById(2131230810));
//            localViewHolder.nameTextView = ((TextView)paramView.findViewById(2131230811));
//            localViewHolder.areaTextView = ((TextView)paramView.findViewById(2131230812));
//            localViewHolder.taskAutoOpen = ((ImageView)paramView.findViewById(2131231118));
//            localViewHolder.taskAutoClose = ((ImageView)paramView.findViewById(2131231119));
//            localViewHolder.taskTimerOpen = ((ImageView)paramView.findViewById(2131231120));
//            localViewHolder.taskTimerClose = ((ImageView)paramView.findViewById(2131231121));
//            paramView.setTag(localViewHolder);
//            if (!DeviceTool.isMutiCtrlDevByType(str3))
//                break label385;
//            if (!paramBoolean)
//                break label372;
//            localViewHolder.taskTimerOpen.setImageResource(2130837914);
//            label271: localViewHolder.taskAutoOpen.setImageResource(0);
//            localViewHolder.taskAutoClose.setImageResource(0);
//            localViewHolder.taskTimerClose.setImageResource(0);
//        }
//        while (true)
//        {
//            localViewHolder.devIconImageView.setImageResource(i);
//            localViewHolder.nameTextView.setText(str2);
//            localViewHolder.areaTextView.setText(str1);
//            Integer localInteger1 = Integer.valueOf(paramInt);
//            paramView.setTag(2131230816, localInteger1);
//            Integer localInteger2 = Integer.valueOf(-2);
//            paramView.setTag(2131230817, localInteger2);
//            return paramView;
//            localViewHolder = (ViewHolder)paramView.getTag();
//            break;
//            label372: localViewHolder.taskTimerOpen.setImageResource(2130837915);
//            break label271;
//            label385: initTaskAvailableStatus(localMap2, localMap3, localViewHolder);
//        }
//    }
}
