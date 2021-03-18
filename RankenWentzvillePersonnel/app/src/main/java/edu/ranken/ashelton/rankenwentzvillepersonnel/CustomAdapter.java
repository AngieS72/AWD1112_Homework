package edu.ranken.ashelton.rankenwentzvillepersonnel;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    List<Personnel> PersonnelList;
    Context context;

    //  Constructor
    public CustomAdapter(List<Personnel> PersonnelList, Context context)
    {
        this.PersonnelList = PersonnelList;
        this.context = context;
    }

    // Create new views (invoked by the layoutManager manager)
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.onepersonnel, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    // Replace the contents of a view (invoked by the layoutManager manager)
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        holder.tvRVFirstName.setText(PersonnelList.get(position).getFirstName());
        holder.tvRVLastName.setText(PersonnelList.get(position).getLastName());
        holder.tvRVDivision.setText(PersonnelList.get(position).getDivision());
        Glide.with(this.context).load(PersonnelList.get(position).getTheImage()).into(holder.ivPersonnel);
        holder.parentLayout.setOnClickListener(v -> {
            Intent intent = new Intent(context, AddPersonnel.class);
            intent.putExtra("id", PersonnelList.get(position).getId());
            context.startActivity(intent);
        });
    }

    // Return the size of your dataset (invoked by the layoutManager manager)
    @Override
    public int getItemCount() {
        return PersonnelList.size();
    }

    /*
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView ivPersonnel;
        TextView tvRVFirstName;
        TextView tvRVLastName;
        TextView tvRVDivision;
        ConstraintLayout parentLayout;

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            // Define click listener for the ViewHolder's View
            ivPersonnel     = itemView.findViewById(R.id.ivPersonnel);
            tvRVFirstName   = itemView.findViewById(R.id.tvRVFirstName);
            tvRVLastName    = itemView.findViewById(R.id.tvRVLastName);
            tvRVDivision      = itemView.findViewById(R.id.tvRVDivision);
            parentLayout    = itemView.findViewById(R.id.onePersonnelLayout);
        }
    }
}

