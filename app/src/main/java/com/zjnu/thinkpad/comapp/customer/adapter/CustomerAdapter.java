package com.zjnu.thinkpad.comapp.customer.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zjnu.thinkpad.comapp.R;

/**
 * User--Hu mingzhi on 2017/9/13.
 * Created by ThinKPad
 */

public class CustomerAdapter extends RecyclerView.Adapter {
    private final Context mcontext;
    public CustomerAdapter(Context mcontext) {
        this.mcontext = mcontext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(mcontext, R.layout.customer_list, null));
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
        private TextView door_id;
        private TextView door_date;
        private TextView door_type;
        private ImageView door_list;
        private RecyclerView recyclerview3;
        private CustomerListAdapter adapter;
        private LinearLayout ll_detial;


        public ViewHolder(View itemView) {
            super(itemView);
            initView(itemView);
        }

        private void initView(View itemView) {
            door_id = itemView.findViewById(R.id.door_id);
            door_date = itemView.findViewById(R.id.door_date);
            door_type = itemView.findViewById(R.id.door_type);
            door_list = itemView.findViewById(R.id.door_list);
            recyclerview3 = itemView.findViewById(R.id.recyclerview3);
            ll_detial = itemView.findViewById(R.id.ll_detial);
            door_list.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(ll_detial.getVisibility()!=View.VISIBLE)
                    ll_detial.setVisibility(View.VISIBLE);
                    else
                        ll_detial.setVisibility(View.GONE);
                }
            });
            //设置适配器
            adapter = new CustomerListAdapter(mcontext);
            GridLayoutManager manager = new GridLayoutManager(mcontext, 1);
            recyclerview3.setAdapter(adapter);
             /*设置布局管理者*/
            recyclerview3.setLayoutManager(manager);
        }
    }
}
