package com.example.zll.jingdongdome.ui.myhome.adapter;

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
import com.example.zll.jingdongdome.bean.HomePageBean;
import com.example.zll.jingdongdome.inter.OnIteamClick;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by zll on 2018/6/7.
 */

public class HomePageFenleiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<CatagoryBean.DataBean> list;
    private Context context;
    private LayoutInflater inflater;
    private OnIteamClick onIteamClick;

    public void setHomepageIteam(OnIteamClick onIteamClick) {
        this.onIteamClick = onIteamClick;
    }

    public HomePageFenleiAdapter(List<CatagoryBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
        inflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= inflater.inflate(R.layout.zijiatu,null);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
           ViewHolder holder1= (ViewHolder) holder;
           holder1.tuisdv.setImageURI(list.get(position).getIcon());
           holder1.name.setText(list.get(position).getName());
           holder1.ll.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                if (onIteamClick!=null){
                    onIteamClick.setIteamLinstent(position);
                }
               }
           });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView tuisdv;
        private final TextView name;
        private final LinearLayout ll;

        public ViewHolder(View itemView) {
            super(itemView);
            tuisdv = itemView.findViewById(R.id.home_tui_sdv);
            name = itemView.findViewById(R.id.title);
            ll = itemView.findViewById(R.id.ll);
        }
    }
}
