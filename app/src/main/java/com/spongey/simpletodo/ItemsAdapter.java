package com.spongey.simpletodo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// Responsible for displaying data from the model into a single row in the recyclerview at a time
public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {

    public interface  OnLongClickListener{
        void onItemLongClicked(int position);
    }

    List<String> items;
    OnLongClickListener longClickListener;

    public ItemsAdapter(List<String> items, OnLongClickListener longClickListener) {
        this.items = items;
        this.longClickListener = longClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Use  layout inflater  to inflate the view
        View todoView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1,
                parent, false);
        // wrap it  inside a ViewHolder and return it
        return new ViewHolder(todoView);
    }

    // Responsible for binding data to a particular view  holder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Grab the item at the position
        String item = items.get(position);

        // Bind the item into the specific view holder
        holder.bind(item);
    }

    // Tells the recycler view how many items are in the list
    @Override
    public int getItemCount() {
        return items.size();
    }

    // Container to provide easy access  to views  that represent each of the rows in teh list

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvItem;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItem = itemView.findViewById(android.R.id.text1);
        }

        // Responsible for updating teh view in the view holder with its data
        public void bind(String item) {
            tvItem.setText(item);
            tvItem.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    // Notifying the listener which position on the recyclerview was long clicked
                    longClickListener.onItemLongClicked(getAdapterPosition());
                    return true;
                }
            });
        }
    }
}
