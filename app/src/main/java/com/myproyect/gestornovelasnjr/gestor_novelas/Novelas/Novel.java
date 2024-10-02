package com.myproyect.gestornovelasnjr.gestor_novelas.Novelas;


import com.google.firebase.firestore.Exclude;

public class Novel {
    @Exclude
    private String id; // Excluir este campo si no lo necesitas en Firestore

    private String title;
    private String author;
    private int year;
    private String synopsis;

    // Constructor vacío para Firestore
    public Novel() {}

    public Novel(String title, String author, int year, String synopsis) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.synopsis = synopsis;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getYear() { return year; }
    public String getSynopsis() { return synopsis; }
}
