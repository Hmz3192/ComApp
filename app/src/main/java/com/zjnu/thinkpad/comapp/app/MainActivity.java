package com.zjnu.thinkpad.comapp.app;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.zjnu.thinkpad.comapp.R;
import com.zjnu.thinkpad.comapp.customer.fragment.ContactFragment;
import com.zjnu.thinkpad.comapp.customer.fragment.CustomerFragment;
import com.zjnu.thinkpad.comapp.customer.fragment.KeyFragment;
import com.zjnu.thinkpad.comapp.customer.fragment.MykeyFragment;
import com.zjnu.thinkpad.comapp.customer.fragment.UserFragment;
import com.zjnu.thinkpad.myapplication.android.CaptureActivity;

import butterknife.ButterKnife;

public class MainActivity extends FragmentActivity {

    private FrameLayout frame_layout;
    private RadioButton rb_mykey;
    private RadioButton rb_key;
    private RadioButton rb_customer;
    private RadioButton rb_user;
    private RadioButton rb_contact;
    private RadioGroup or_main;
    private KeyFragment keyFragment;
    private MykeyFragment mykeyFragment;
    private ContactFragment contactFragment;
    private UserFragment userFragment;
    private CustomerFragment customerFragment;
    private TextView tv_sao;
    private static final int REQUEST_CODE_SCAN = 0x0000;
    private static final String DECODED_CONTENT_KEY = "codedContent";
    private static final String DECODED_BITMAP_KEY = "codedBitmap";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initListener();
        ButterKnife.inject(this);
    }

    private void initView() {
        frame_layout = (FrameLayout) findViewById(R.id.frame_layout);
        rb_mykey = (RadioButton) findViewById(R.id.rb_mykey);
        rb_key = (RadioButton) findViewById(R.id.rb_key);
        rb_customer = (RadioButton) findViewById(R.id.rb_customer);
        rb_user = (RadioButton) findViewById(R.id.rb_user);
        rb_contact = (RadioButton) findViewById(R.id.rb_contact);
        or_main = (RadioGroup) findViewById(R.id.or_main);
        tv_sao = (TextView) findViewById(R.id.tv_sao);


        tv_sao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,
                        CaptureActivity.class);
                startActivityForResult(intent, REQUEST_CODE_SCAN);
            }
        });
    }

    private void initListener() {


        //RadioGroup的选择事件
        or_main.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                Fragment fragment = null;
                switch (checkedId) {
                    /*我的钥匙*/
                    case R.id.rb_mykey:
                        fragment = keyFragment;

                        break;
                    /*通行证*/
                    case R.id.rb_key:
                        fragment = mykeyFragment;
                        break;
                    // 我的访客
                    case R.id.rb_customer:
                        fragment = customerFragment;
                        break;

                    // 用户
                    case R.id.rb_user:
                        fragment = userFragment;
                        break;

                    // 联系
                    case R.id.rb_contact:
                        fragment = contactFragment;
                        break;
                }

                // 实现fragment切换的方法
                switchFragment(fragment);


            }
        });
        or_main.check(R.id.rb_mykey);

    }

    public void switchFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit();
    }


    private void initData() {
        // 创建fragment对象
        keyFragment = new KeyFragment();
        mykeyFragment = new MykeyFragment();
        contactFragment = new ContactFragment();
        userFragment = new UserFragment();
        customerFragment = new CustomerFragment();

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_SCAN && resultCode == RESULT_OK) {
            if (data != null) {

                String content = data.getStringExtra(DECODED_CONTENT_KEY);
                Bitmap bitmap = data.getParcelableExtra(DECODED_BITMAP_KEY);
                Toast.makeText(this, "解码结果： \n" + content, Toast.LENGTH_SHORT).show();

            }
        }
    }
}
