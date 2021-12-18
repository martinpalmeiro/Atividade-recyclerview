package com.example.atividade3.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.atividade3.R;
import com.example.atividade3.model.PlaceholderAlbum;
import com.example.atividade3.model.PlaceholderPost;

import java.util.List;

public class PlaceholderAlbumAdapter extends RecyclerView.Adapter<PlaceholderAlbumAdapter.ViewHolder>{

    private List<PlaceholderAlbum> dados;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }

    public PlaceholderAlbumAdapter(List<PlaceholderAlbum> placeholdersAlbum) {
        this.dados = placeholdersAlbum;
    }

    @NonNull
    @Override
    public PlaceholderAlbumAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.placeholder_album_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceholderAlbumAdapter.ViewHolder holder, int position) {
        PlaceholderAlbum placeholder = dados.get(position);
        TextView tv = holder.view.findViewById(R.id.tvPlaceholderAlbumTitulo);
        tv.setText(placeholder.getTitle());
        tv = holder.view.findViewById(R.id.tvPlaceholderAlbumUserId);
        tv.setText(""+placeholder.getUser_id());
    }

    @Override
    public int getItemCount() {
        return dados.size();
    }
}