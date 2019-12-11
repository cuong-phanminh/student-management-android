package com.example.studentmanagement;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ArrayViewHolder> {
    List<String> data = new ArrayList<>();

    @NonNull
    @Override
    public ArrayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.content_main,parent,false);

        return new ArrayViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArrayViewHolder holder, int position) {
        holder.tvTitle.setText( data.get(position));
    }

    @Override
    public int getItemCount() {
       return data.size();
    }

    class ArrayViewHolder extends RecyclerView.ViewHolder{

        TextView tvTitle;

        public ArrayViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.txtTitle);
        }
    }


    }
