package com.example.database_lite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
//    private List<ItemList> items;
    private List<Person> userListPerson;

    public MyAdapter(Context context) {
        this.context = context;

    }

//    public MyAdapter(Context context, List<ItemList> items) {
//        this.context = context;
//        this.items = items;
//    }

    public void setUserList(List<Person> userListPerson) {
        this.userListPerson = userListPerson;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.name_guest.setText(this.userListPerson.get(position).name);
        holder.people_number.setText(this.userListPerson.get(position).age);

//        holder.name_guest.setText(items.get(position).getName_guest());
//        holder.people_number.setText(String.valueOf(items.get(position).getPeople_number()));


    }

    @Override
    public int getItemCount() {
//        if (userListPerson == null || userListPerson.size() == 0)
//            return 0;
//        else
//            return userListPerson.size();
        return this.userListPerson.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name_guest, people_number;

        public MyViewHolder(View view) {
            super(view);
            name_guest = itemView.findViewById(R.id.name_guest);
            people_number = itemView.findViewById(R.id.people_number);

        }
    }
}
