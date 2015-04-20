package com.zms.netstate;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * Created by AlexZhou on 2015/4/20.
 * 15:58
 */
public class NetChangeReceiver extends BroadcastReceiver {

    public static final String CONNECTIVITY_CHANGE_ACTION = "android.net.conn.CONNECTIVITY_CHANGE";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (TextUtils.equals(action, CONNECTIVITY_CHANGE_ACTION)) {

            Toast.makeText(context, "网络状态变化", Toast.LENGTH_SHORT).show();
        }

    }
}
