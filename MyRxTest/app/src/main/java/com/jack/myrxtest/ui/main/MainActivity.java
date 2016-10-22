package com.jack.myrxtest.ui.main;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.jack.myrxtest.R;
import com.jack.myrxtest.bean.DataBean;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainConstruct.View{
    private Context mContext=MainActivity.this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void getSuccess(List<DataBean> totalList) {

    }

    @Override
    public void getFailed(String error) {
        Toast.makeText(mContext,error,Toast.LENGTH_SHORT).show();
    }
}
