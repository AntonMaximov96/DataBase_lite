package com.example.database_lite;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView name_guest, people_number;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        name_guest = itemView.findViewById(R.id.name_guest);
        people_number = itemView.findViewById(R.id.people_number);
    }
}
