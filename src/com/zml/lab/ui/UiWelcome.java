package com.zml.lab.ui;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;

public class UiWelcome extends Activity {

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            startActivity(new Intent(UiWelcome.this,UiLogin.class));
            finish();
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImageView view = new ImageView(UiWelcome.this);
        view.setBackgroundResource(R.drawable.pc_welcome);
        setContentView(view, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Message msg = new Message();
                msg.what = 1;
                handler.sendMessage(msg);
            }
        }, 1000*1);
    }

}
