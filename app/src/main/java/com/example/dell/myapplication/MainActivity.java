package com.example.dell.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.dell.myapplication.db.userinfom;
import com.example.dell.myapplication.db.userinfomDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
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

    int a = 0;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                userinfom userinfom = new userinfom();
                userinfom.setDate(++a + "");
                userinfom.setIsreight(true);
                userinfom.setName("小明");
                ArrayList<UserData> userData1 = new ArrayList<>();
                int b = 5;
                for (int i = 0; i < b; i++) {
                    UserData userData = new UserData();
                    userData.setId("" + i);
                    userData.setData("" + i);
                    userData.setTime("" + i);
                    userData1.add(userData);
                }
                userinfom.setMDatas(userData1);
                DBHelper.getDaoSession().getUserinfomDao().insert(userinfom);
                break;
            case R.id.btn1:
                DBHelper.getDaoSession().getUserinfomDao().deleteAll();

                break;
            case R.id.btn2:
                userinfomDao dao = DBHelper.getDaoSession().getUserinfomDao();
                com.example.dell.myapplication.db.userinfom unique = dao.queryBuilder().where(userinfomDao.Properties.Date.eq("" + a)).unique();
                if (unique == null) {
                    return;
                }
                ArrayList<UserData> userData2 = new ArrayList<>();
                UserData userData = new UserData();

                userData.setId("小敏感和");
                userData.setData("小敏感和");
                userData.setTime("小敏感和");
                userData2.add(userData);
                com.example.dell.myapplication.db.userinfom userinfom1 = new userinfom();
                userinfom1 = unique;
                userinfom1.setMDatas(userData2);
                DBHelper.getDaoSession().getUserinfomDao().update(userinfom1);
                break;
            case R.id.btn3:
                List<com.example.dell.myapplication.db.userinfom> all =
                        DBHelper.getDaoSession().getUserinfomDao().loadAll();
                for (int i = 0; i < all.size(); i++) {
                    com.example.dell.myapplication.db.userinfom userinfom3 = all.get(i);
                    Log.d("yfl", "onClick: " + userinfom3.getName() + userinfom3.getDate());
                    List<UserData> mDatas = userinfom3.getMDatas();
                    for (int i1 = 0; i1 < mDatas.size(); i1++) {
                        UserData userData23 = mDatas.get(i1);
                        Log.d("yfl", "onClick: " + userData23.getData() + "/////" + userData23.getId());
                    }
                }
                break;
        }
    }
}
