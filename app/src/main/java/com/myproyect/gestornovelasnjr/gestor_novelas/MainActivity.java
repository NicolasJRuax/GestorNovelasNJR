package com.myproyect.gestornovelasnjr.gestor_novelas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.myproyect.gestionnovelas.R;
import com.myproyect.gestornovelasnjr.gestor_novelas.Novelas.Novel;
import com.myproyect.gestornovelasnjr.gestor_novelas.Novelas.NovelAdapter;
import com.myproyect.gestornovelasnjr.gestor_novelas.Novelas.NovelViewModel;

public class MainActivity extends AppCompatActivity implements NovelAdapter.OnDeleteClickListener {

    private Button buttonAddBook;
    private RecyclerView recyclerView;
    private NovelViewModel novelViewModel;
    private NovelAdapter novelAdapter;

    private void showAddNovelDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_add_novel, null);
        builder.setView(dialogView);

        EditText editTextTitle = dialogView.findViewById(R.id.editTextTitle);
        EditText editTextAuthor = dialogView.findViewById(R.id.editTextAuthor);
        EditText editTextYear = dialogView.findViewById(R.id.editTextYear);
        EditText editTextSynopsis = dialogView.findViewById(R.id.editTextSynopsis);

        builder.setPositiveButton("Agregar", (dialog, which) -> {
            String title = editTextTitle.getText().toString();
            String author = editTextAuthor.getText().toString();
            int year;
            try {
                year = Integer.parseInt(editTextYear.getText().toString());
            } catch (NumberFormatException e) {
                Toast.makeText(MainActivity.this, "Año inválido", Toast.LENGTH_SHORT).show();
                return;
            }
            String synopsis = editTextSynopsis.getText().toString();

            if (!title.isEmpty() && !author.isEmpty() && year > 0 && !synopsis.isEmpty()) {
                Novel novel = new Novel(title, author, year, synopsis);
                novelViewModel.insert(novel);
                Toast.makeText(MainActivity.this, "Novela añadida", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            } else {
                Toast.makeText(MainActivity.this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Cancelar", (dialog, which) -> dialog.dismiss());

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAddBook = findViewById(R.id.buttonAddBook);
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        novelAdapter = new NovelAdapter(this, this);
        recyclerView.setAdapter(novelAdapter);

        novelViewModel = new ViewModelProvider(this).get(NovelViewModel.class);

        novelViewModel.getAllNovels().observe(this, novels -> novelAdapter.setNovels(novels));

        buttonAddBook.setOnClickListener(v -> showAddNovelDialog());
    }

    @Override
    public void onDeleteClick(Novel novel) {
        new AlertDialog.Builder(this)
                .setTitle("Eliminar Novela")
                .setMessage("¿Estás seguro de que deseas eliminar esta novela?")
                .setPositiveButton("Sí", (dialog, which) -> {
                    novelViewModel.delete(novel);
                    Toast.makeText(this, "Novela eliminada", Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton("No", null)
                .show();
    }
}