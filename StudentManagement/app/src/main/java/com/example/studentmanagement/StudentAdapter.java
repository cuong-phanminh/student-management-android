package com.example.studentmanagement;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ArrayViewHolder> {
    public static List<Student>  data = new ArrayList<>();

    private OnItemClicked onClick;

    public interface OnItemClicked {
        void onClickDelete(int position);
        void onClickUpdate(int position);
    }

    @NonNull
    @Override
    public ArrayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.iterm_main, parent, false);

        return new ArrayViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArrayViewHolder holder, final int position) {
        holder.tvName.setText("Name:"+data.get(position).getStudentName() + "");

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.onClickDelete(position);
            }
        });
        holder.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.onClickUpdate(position);
            }
        });


    }

    @Override
    public int getItemCount() {
        if (data.size()!=0){
            return data.size();
        }else {
            return 0;
        }


    }

    class ArrayViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        Button btnDelete,btnUpdate;

        public ArrayViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.txtName);
            btnDelete = itemView.findViewById(R.id.btnDelete);
            btnUpdate = itemView.findViewById(R.id.btnUpdate);
        }
    }
    public  void  setOnClick(OnItemClicked onClick) {
        this.onClick = onClick;
    }

}
