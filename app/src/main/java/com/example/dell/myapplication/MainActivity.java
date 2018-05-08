package com.example.dell.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.dell.myapplication.db.userinfom;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtn;
    private Button mBtn1;
    private Button mBtn2;
    private Button mBtn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        DBHelper.initDb(this);

    }

    private void initView() {
        mBtn = (Button) findViewById(R.id.btn);
        mBtn1 = (Button) findViewById(R.id.btn1);
        mBtn2 = (Button) findViewById(R.id.btn2);
        mBtn3 = (Button) findViewById(R.id.btn3);

        mBtn.setOnClickListener(this);
        mBtn1.setOnClickListener(this);
        mBtn2.setOnClickListener(this);
        mBtn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                userinfom userinfom = new userinfom();
                userinfom.setDate("asdioahsd");
                userinfom.setIsreight(true);
                userinfom.setName("小明");
                DBHelper.getDaoSession().getUserinfomDao().insert(userinfom);
                break;
            case R.id.btn1:

                break;
            case R.id.btn2:

                break;
            case R.id.btn3:
                List<com.example.dell.myapplication.db.userinfom> all =
                        DBHelper.getDaoSession().getUserinfomDao().loadAll();
                for (int i = 0; i < all.size(); i++) {
                    com.example.dell.myapplication.db.userinfom userinfom1 = all.get(i);
                    Log.e("yfl", "onClick: "+userinfom1.getName() );
                }
                break;
        }
    }
}
