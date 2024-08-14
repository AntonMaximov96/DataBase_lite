package com.example.database_lite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private Context context;
    private List<ItemList> items;
    private List<Person> userListPerson;

    public MyAdapter(Context context) {
        this.context = context;

    }

        public MyAdapter(Context context, List<ItemList> items) {
        this.context = context;
        this.items = items;
    }
    public void setUserList(List<Person> userListPerson) {
        this.userListPerson = userListPerson;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false));
//        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.name_guest.setText(items.get(position).getName_guest());
        holder.people_number.setText(String.valueOf(items.get(position).getPeople_number()));


    }

    @Override
    public int getItemCount() {
//        if (userListPerson == null || userListPerson.size() == 0)
//            return 0;
//        else
//            return userListPerson.size();
        return items.size();
    }
}
