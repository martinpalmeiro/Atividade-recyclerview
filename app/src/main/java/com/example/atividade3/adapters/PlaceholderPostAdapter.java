package com.example.atividade3.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.atividade3.R;
import com.example.atividade3.model.PlaceholderPost;

import java.util.List;

public class PlaceholderPostAdapter extends RecyclerView.Adapter<PlaceholderPostAdapter.ViewHolder>{

    private List<PlaceholderPost> dados;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }

    public PlaceholderPostAdapter(List<PlaceholderPost> placeholdersPost) {
        this.dados = placeholdersPost;
    }

    @NonNull
    @Override
    public PlaceholderPostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.placeholder_post_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceholderPostAdapter.ViewHolder holder, int position) {
        PlaceholderPost placeholder = dados.get(position);
        TextView tv = holder.view.findViewById(R.id.tvPlaceholderPostTitulo);
        tv.setText(placeholder.getTitle());
        tv = holder.view.findViewById(R.id.tvPlaceholderPostUserId);
        tv.setText(""+placeholder.getUser_id());
        tv = holder.view.findViewById(R.id.tvPlaceholderPostBody);
        tv.setText(""+placeholder.getBody());
    }

    @Override
    public int getItemCount() {
        return dados.size();
    }
}
