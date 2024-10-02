package com.myproyect.gestornovelasnjr.gestor_novelas.Novelas;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AlertDialog;

import com.myproyect.gestionnovelas.R;

import java.util.ArrayList;
import java.util.List;

public class NovelAdapter extends RecyclerView.Adapter<NovelAdapter.NovelHolder> {
    private List<Novel> novels = new ArrayList<>();
    private OnDeleteClickListener deleteListener;
    private Context context;

    public NovelAdapter(Context context, OnDeleteClickListener deleteListener) {
        this.context = context;
        this.deleteListener = deleteListener;
    }

    @NonNull
    @Override
    public NovelHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_novel, parent, false);
        return new NovelHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NovelHolder holder, int position) {
        Novel currentNovel = novels.get(position);
        holder.textViewTitle.setText(currentNovel.getTitle());
        holder.textViewAuthor.setText(currentNovel.getAuthor());

        holder.buttonDelete.setOnClickListener(v -> deleteListener.onDeleteClick(currentNovel));

        // Botón de ver detalles
        holder.buttonDetails.setOnClickListener(v -> {
            new AlertDialog.Builder(context)
                    .setTitle(currentNovel.getTitle())
                    .setMessage("Autor: " + currentNovel.getAuthor() + "\nFecha de Lanzamiento: " + currentNovel.getYear() + "\nSinopsis: " + currentNovel.getSynopsis())
                    .setPositiveButton("Cerrar", null)
                    .show();
        });

        // Botón de favorito
        holder.buttonFavorite.setOnClickListener(v -> {
            // Aquí puedes agregar lógica para manejar favoritos
            Toast.makeText(context, currentNovel.getTitle() + " añadido a favoritos", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return novels.size();
    }

    public void setNovels(List<Novel> novels) {
        this.novels = novels;
        notifyDataSetChanged();
    }

    class NovelHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle;
        private TextView textViewAuthor;
        private ImageButton buttonDelete;
        private ImageButton buttonFavorite;
        private ImageButton buttonDetails;

        public NovelHolder(View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewAuthor = itemView.findViewById(R.id.textViewAuthor);
            buttonDelete = itemView.findViewById(R.id.buttonDelete);
            buttonFavorite = itemView.findViewById(R.id.buttonFavorite);
            buttonDetails = itemView.findViewById(R.id.buttonDetails);
        }
    }

    public interface OnDeleteClickListener {
        void onDeleteClick(Novel novel);
    }
}