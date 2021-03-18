package edu.ranken.jpscott.presidents;

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
    List<President> presidentList;
    Context context;

    //  Constructor
    public CustomAdapter(List<President> presidentList, Context context) 
	{
        this.presidentList = presidentList;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(parent.getContext())
                                  .inflate(R.layout.onepresident, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        holder.tvRVFirstName.setText(presidentList.get(position).getFirstName());
        holder.tvRVLastName.setText(presidentList.get(position).getLastName());
        holder.tvRVServed.setText(presidentList.get(position).getServed());
        Glide.with(this.context).load(presidentList.get(position).getTheImage()).into(holder.ivPresident);
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AddPresident.class);
                intent.putExtra("id", presidentList.get(position).getId());
                context.startActivity(intent);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return presidentList.size();
    }

    /*
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView ivPresident;
        TextView tvRVFirstName;
        TextView tvRVLastName;
        TextView tvRVServed;
        ConstraintLayout parentLayout;

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            // Define click listener for the ViewHolder's View
            ivPresident     = itemView.findViewById(R.id.ivPresident);
            tvRVFirstName   = itemView.findViewById(R.id.tvRVFirstName);
            tvRVLastName    = itemView.findViewById(R.id.tvRVLastName);
            tvRVServed      = itemView.findViewById(R.id.tvRVServed);
            parentLayout    = itemView.findViewById(R.id.onelinepresident);
        }
    }
}
