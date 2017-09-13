package com.zjnu.thinkpad.comapp.customer.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zjnu.thinkpad.comapp.R;
import com.zjnu.thinkpad.comapp.customer.adapter.CustomerAdapter;

/**
 * User--Hu mingzhi on 2017/8/30.
 * Created by ThinKPad
 */

public class CustomerFragment extends BaseFragment {
    private RecyclerView recyclerview2;
    private CustomerAdapter adapter;
    @Override
    public View initView() {
        View view = View.inflate(mcontext, R.layout.fragment_customer, null);
        recyclerview2 = view.findViewById(R.id.recyclerview2);
        return view ;
    }


    @Override
    public void initData() {
        super.initData();
        procssData();
    }
    private void procssData() {
        //设置适配器
        adapter = new CustomerAdapter(mcontext);
        GridLayoutManager manager = new GridLayoutManager(mcontext, 1);
        recyclerview2.setAdapter(adapter);
        /*设置布局管理者*/
        recyclerview2.setLayoutManager(manager);

    }

}
