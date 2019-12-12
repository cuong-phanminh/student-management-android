package com.example.studentmanagement;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ArrayViewHolder> {
    public static List<Student>  data = new ArrayList<>();

    @NonNull
    @Override
    public ArrayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.iterm_main, parent, false);

        return new ArrayViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArrayViewHolder holder, int position) {
        holder.tvName.setText("Name:"+data.get(position).getStudentName() + "");
        holder.tvID.setText("ID:"+data.get(position).getStudentID() + "");

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ArrayViewHolder extends RecyclerView.ViewHolder {

        TextView tvID, tvName;

        public ArrayViewHolder(@NonNull View itemView) {
            super(itemView);
            tvID = itemView.findViewById(R.id.txtID);
            tvName = itemView.findViewById(R.id.txtName);
        }
    }


}
