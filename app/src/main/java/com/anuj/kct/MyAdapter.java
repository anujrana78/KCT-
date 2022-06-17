package com.anuj.kct;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class MyAdapter extends FirebaseRecyclerAdapter<Students,MyAdapter.myviewholder> {

    public MyAdapter(@NonNull FirebaseRecyclerOptions<Students> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull Students model) {
       holder.name.setText(model.getFullname());
        holder.symbol.setText(model.getSymbol());
        holder.faculty.setText(model.getFaculty());


    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder{
        TextView name,email,password,symbol,faculty;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.textViewFullnameDisplay);
            email = (TextView) itemView.findViewById(R.id.textViewEmail);
            password = (TextView) itemView.findViewById(R.id.textViewPassword);
            symbol = (TextView) itemView.findViewById(R.id.textViewSymbol);
            faculty = (TextView) itemView.findViewById(R.id.textViewFaculty);


        }
    }
}
