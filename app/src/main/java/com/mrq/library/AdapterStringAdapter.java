package com.mrq.library;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.mrq.library.FastScroll.SectionTitleProvider;

import java.util.ArrayList;

public class AdapterStringAdapter extends RecyclerView.Adapter<AdapterStringAdapter.AdapterStringViewHolder>
        implements SectionTitleProvider {

    private static Context mContext;
    private ArrayList<String> list;

    public AdapterStringAdapter(ArrayList<String> list, Context mContext) {
        this.list = list;
        AdapterStringAdapter.mContext = mContext;
    }

    @NonNull
    @Override
    public AdapterStringViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new AdapterStringViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterStringViewHolder holder, final int position) {
        final String model = list.get(position);
        holder.bind(model);
    }

    @Override
    public int getItemCount() {
        return (list != null ? list.size() : 0);
    }

    private String getData(int position) {
        return list.get(position);
    }

    @Override
    public String getSectionTitle(int position) {
        return getData(position).substring(0, 1);
    }

    static class AdapterStringViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_title;

        private AdapterStringViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_title = itemView.findViewById(android.R.id.text1);

        }

        private void bind(String model) {
            tv_title.setText(model);
        }
    }

}