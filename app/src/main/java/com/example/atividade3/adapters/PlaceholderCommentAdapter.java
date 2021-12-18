package com.example.atividade3.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.atividade3.R;
import com.example.atividade3.model.PlaceholderComment;

import java.util.List;

public class PlaceholderCommentAdapter extends RecyclerView.Adapter<PlaceholderCommentAdapter.ViewHolder>{

    private List<PlaceholderComment> dados;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }

    public PlaceholderCommentAdapter(List<PlaceholderComment> placeholdersComment) {
        this.dados = placeholdersComment;
    }

    @NonNull
    @Override
    public PlaceholderCommentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewGroup viewGroup;
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.placeholder_comment_layout, parent, false);
        return new PlaceholderCommentAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceholderCommentAdapter.ViewHolder holder, int position) {
        PlaceholderComment placeholder = dados.get(position);
        TextView tv = holder.view.findViewById(R.id.tvPlaceholderCommentName);
        tv.setText(placeholder.getName());
        tv = holder.view.findViewById(R.id.tvPlaceholderCommentPostId);
        tv.setText(""+placeholder.getPost_id());
        tv = holder.view.findViewById(R.id.tvPlaceholderCommentBody);
        tv.setText(""+placeholder.getBody());
    }

    @Override
    public int getItemCount() {
        return dados.size();
    }
}