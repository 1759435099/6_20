package com.example.a6_4.daohang;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a6_4.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DaoHangAdapter extends RecyclerView.Adapter<DaoHangAdapter.ViewHolder> {

    private List<DaoHang> mDaoHang;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView dayu;
        TextView title_1,title_2;

        @SuppressLint("ResourceType")
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dayu = itemView.findViewById(R.drawable.dayu);
            title_1 = itemView.findViewById(R.id.title_1);
            title_2 = itemView.findViewById(R.id.title_2);
        }
    }

    public DaoHangAdapter(List<DaoHang> DaoHang) {
        mDaoHang = DaoHang;
    }

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kefu,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        DaoHang daoHang = mDaoHang.get(position);
        holder.title_1.setText(daoHang.getTitle_1());
        holder.title_2.setText(daoHang.getTitle_2());
    }

    @Override
    public int getItemCount() {
        return mDaoHang.size();
    }
}
