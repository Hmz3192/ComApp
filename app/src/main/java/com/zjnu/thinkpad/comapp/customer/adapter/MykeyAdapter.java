package com.zjnu.thinkpad.comapp.customer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.kyleduo.switchbutton.SwitchButton;
import com.zjnu.thinkpad.comapp.R;
/**
 * User--Hu mingzhi on 2017/9/11.
 * Created by ThinKPad
 */

public class MykeyAdapter extends RecyclerView.Adapter {
    private final Context mcontext;

    public MykeyAdapter(Context mcontext) {
        this.mcontext = mcontext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(mcontext, R.layout.door_list, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.sb_default.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mcontext, "开启："+ position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 1;
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_door;
        private SwitchButton sb_default;



        public ViewHolder(View itemView) {
            super(itemView);
            initView(itemView);
        }


        private void initView(View itemView) {
            tv_door = itemView.findViewById(R.id.tv_door);
            sb_default = itemView.findViewById(R.id.sb_default);

        }
    }
}
