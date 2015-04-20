package com.zms.netstate;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    private TextView textShow;
    private Button btnGet;
    public static final String CONNECTIVITY_CHANGE_ACTION = "android.net.conn.CONNECTIVITY_CHANGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerDateTransReceiver();

        textShow = (TextView) findViewById(R.id.textShow);
        btnGet = (Button) findViewById(R.id.btnGet);
        btnGet.setOnClickListener(new MyOnClickListener());
    }

    private void registerDateTransReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(CONNECTIVITY_CHANGE_ACTION);
        filter.setPriority(1000);
        registerReceiver(new NetChangeReceiver(), filter);
    }

    private int getNetworkType() {
        ConnectivityManager connectMgr = (ConnectivityManager) this
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo info = connectMgr.getActiveNetworkInfo();
        if (info != null) {
            return info.getType();
        } else {
            return -1;
        }
    }

    private class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnGet:
                    int netType = getNetworkType();
                    if (netType == ConnectivityManager.TYPE_WIFI) {
                        textShow.setText("Wi-Fi");
                    } else if (netType == ConnectivityManager.TYPE_MOBILE) {
                        textShow.setText("Mobile");
                    } else {
                        textShow.setText("None");
                    }

                    break;
            }
        }
    }

}
