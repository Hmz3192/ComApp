package com.zjnu.thinkpad.comapp.customer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.zjnu.thinkpad.comapp.R;

/**
 * User--Hu mingzhi on 2017/9/13.
 * Created by ThinKPad
 */

public class CustomerListAdapter extends RecyclerView.Adapter  {
    private final Context mcontext;
    public CustomerListAdapter(Context mcontext) {
        this.mcontext = mcontext;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(mcontext, R.layout.customer_rv_list, null));

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
            initView(itemView);
        }

        private void initView(View itemView) {

        }
    }
}
