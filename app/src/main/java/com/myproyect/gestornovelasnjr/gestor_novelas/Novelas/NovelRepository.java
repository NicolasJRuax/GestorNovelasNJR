package com.myproyect.gestornovelasnjr.gestor_novelas.Novelas;


import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.myproyect.gestornovelasnjr.gestor_novelas.Novelas.Novel;

import java.util.ArrayList;
import java.util.List;

public class NovelRepository {

    private final FirebaseFirestore db = FirebaseFirestore.getInstance();
    private final CollectionReference novelCollection = db.collection("novels");

    public LiveData<List<Novel>> getAllNovels() {
        MutableLiveData<List<Novel>> novelsLiveData = new MutableLiveData<>();

        novelCollection.addSnapshotListener((querySnapshot, e) -> {
            if (e != null) {
                Log.e("Firestore", "Listen failed.", e);
                return;
            }
            if (querySnapshot != null) {
                List<Novel> novels = new ArrayList<>();
                for (DocumentSnapshot document : querySnapshot.getDocuments()) {
                    Novel novel = document.toObject(Novel.class);
                    novel.setId(document.getId()); // Asegúrate de asignar el ID
                    novels.add(novel);
                }
                novelsLiveData.setValue(novels);
            } else {
                Log.d("Firestore", "No data received.");
                novelsLiveData.setValue(new ArrayList<>());
            }
        });

        return novelsLiveData;
    }


    public void insert(Novel novel) {
        novelCollection.add(novel).addOnSuccessListener(documentReference ->
                Log.d("Firestore", "DocumentSnapshot added with ID: " + documentReference.getId())
        ).addOnFailureListener(e ->
                Log.e("Firestore", "Error adding novel", e)
        );
    }

    public void delete(Novel novel) {
        if (novel.getId() != null) {
            novelCollection.document(novel.getId())
                    .delete()
                    .addOnSuccessListener(aVoid -> {
                        Log.d("Firestore", "Novela eliminada con éxito");
                    })
                    .addOnFailureListener(e -> {
                        Log.e("Firestore", "Error al eliminar la novela", e);
                    });
        } else {
            Log.e("Firestore", "No se puede eliminar la novela: ID nulo");
        }
    }

}
