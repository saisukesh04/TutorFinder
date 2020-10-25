package com.vithack.tutorfinder.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vithack.tutorfinder.R;

import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder>{

    private Context context;
    private List<Post> listData;

    public FeedAdapter(List<Post> listData){
        this.listData = listData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.feed_card_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post temp = listData.get(position);
        holder.name_text_card.setText(temp.getPostby_id());
        holder.deadline_text_card.setText(temp.getDeadline());
        holder.subject_text_card.setText(temp.getSubject());
        holder.class_text_card.setText(temp.getClasses());
        holder.medium_text_card.setText(temp.getMedium());
        holder.salary_text_card.setText(temp.getSalary());
        holder.location_text_card.setText(temp.getLocation());
        holder.pref_uni_text_card.setText(temp.getP_university());
    }

    @Override
    public int getItemCount() {
        return listData != null ? listData.size(): 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView name_text_card, deadline_text_card, subject_text_card, class_text_card, medium_text_card, salary_text_card;
        private TextView location_text_card, pref_uni_text_card;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name_text_card = itemView.findViewById(R.id.name_text_card);
            deadline_text_card = itemView.findViewById(R.id.deadline_text_card);
            subject_text_card = itemView.findViewById(R.id.subject_text_card);
            class_text_card = itemView.findViewById(R.id.class_text_card);
            medium_text_card = itemView.findViewById(R.id.medium_text_card);
            salary_text_card = itemView.findViewById(R.id.salary_text_card);
            location_text_card = itemView.findViewById(R.id.location_text_card);
            pref_uni_text_card = itemView.findViewById(R.id.pref_uni_text_card);
        }
    }
}
