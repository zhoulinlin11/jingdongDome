package com.example.zll.jingdongdome.ui.catagory.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.zll.jingdongdome.R;
import com.example.zll.jingdongdome.bean.CatagoryBean;
import com.example.zll.jingdongdome.ui.catagory.CatagoryContarct;

import java.util.List;

/**
 * Created by zll on 2018/6/10.
 */

public class CatagoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<CatagoryBean.DataBean> list;
    private Context context;
    private LayoutInflater inflater;


    public CatagoryAdapter(List<CatagoryBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
        inflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.leftitem,null);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1= (ViewHolder) holder;
        holder1.left_name.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView left_name;
        private final LinearLayout ll;
        public ViewHolder(View itemView) {
            super(itemView);
            left_name = itemView.findViewById(R.id.left_name);
             ll = itemView.findViewById(R.id.ll);
        }
    }
}
