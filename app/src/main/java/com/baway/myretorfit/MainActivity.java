package com.baway.myretorfit;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.baway.myretorfit.core.BaseActivity;
import com.baway.myretorfit.entity.Goods;
import com.baway.myretorfit.entity.Result;
import com.baway.myretorfit.entity.User;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {

    @BindView(R.id.login_mobile)
    EditText mMobile;
    @BindView(R.id.login_pas)
    EditText mPassword;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Result<User> result = (Result<User>) msg.obj;
            if (result.getStatus().equals("0000")) {
                Toast.makeText(getBaseContext(), result.getResult().getUserId() + "  " + result.getResult().getNickName(), Toast.LENGTH_LONG).show();

            } else {
                Toast.makeText(getBaseContext(), result.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
    };

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @OnClick({R.id.login_btn, R.id.login_reg,})
    public void click(View v) {
        if (v.getId() == R.id.login_btn) {//点击登录按钮
            final String mobile = mMobile.getText().toString();
            final String password = mPassword.getText().toString();

            if (!StringUtil.isPhone(mobile)) {
                Toast.makeText(this, "请输入正确手机号", Toast.LENGTH_LONG).show();
                return;
            }
            if (password.length() < 6) {
                Toast.makeText(this, "密码最少6位", Toast.LENGTH_LONG).show();
                return;
            }

            final IRequest iRequest = RetrofitUtil.retrofit.create(IRequest.class);
//            iRequest.login(mobile, password).enqueue(new Callback<Result<User>>() {
//                @Override
//                public void onResponse(Call<Result<User>> call, Response<Result<User>> response) {
//                    Message message = handler.obtainMessage();
//                    message.obj = response.body();
//                    handler.sendMessage(message);
//                }
//
//                @Override
//                public void onFailure(Call<Result<User>> call, Throwable t) {
//
//                }
//            });
            iRequest.findCommodityListByLabel(1001, 1,5)
                    .enqueue(new Callback<Result<List<Goods>>>() {
                                 @Override
                                 public void onResponse(Call<Result<List<Goods>>> call, Response<Result<List<Goods>>> response) {
                                    Result result=response.body();
                                     Log.i("LJY",result.getStatus()+result.getMessage());
                                 }

                                 @Override
                                 public void onFailure(Call<Result<List<Goods>>> call, Throwable t) {

                                 }
                             }
                    );


//            登录请求
           /* new Thread(new Runnable() {
                @Override
                public void run() {
                    Message message = handler.obtainMessage();
                    try {
                        message.obj = iRequest.login(mobile,password).execute().body();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    handler.sendMessage(message);

                }
            }).start();*/


        } else if (v.getId() == R.id.login_reg) {//点击注册按钮
        }
    }
}
