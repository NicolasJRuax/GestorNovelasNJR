package com.myproyect.gestornovelasnjr.gestor_novelas.Novelas;


import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.firestore.CollectionReference;
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

        novelCollection.get().addOnCompleteListener(task -> {
            if (task.isSuccessful() && task.getResult() != null) {
                List<Novel> novels = new ArrayList<>();
                for (com.google.firebase.firestore.DocumentSnapshot document : task.getResult().getDocuments()) {
                    Novel novel = document.toObject(Novel.class);
                    novels.add(novel);
                }
                novelsLiveData.setValue(novels);
            } else {
                Log.e("Firestore", "Error getting novels: ", task.getException());
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
        novelCollection.whereEqualTo("title", novel.getTitle())
                .get().addOnSuccessListener(querySnapshot -> {
                    for (com.google.firebase.firestore.DocumentSnapshot doc : querySnapshot.getDocuments()) {
                        novelCollection.document(doc.getId()).delete();
                    }
                }).addOnFailureListener(e -> Log.e("Firestore", "Error deleting novel", e));
    }
}
