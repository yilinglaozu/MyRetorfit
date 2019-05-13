package com.baway.myretorfit.core;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * @author dingtao
 * @date 2019/5/10 11:48
 * qq:1940870847
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initView(savedInstanceState);
    }

    protected abstract int getLayoutId();
    protected abstract void initView(Bundle savedInstanceState);

}
