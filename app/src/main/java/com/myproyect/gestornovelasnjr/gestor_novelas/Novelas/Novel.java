package com.myproyect.gestornovelasnjr.gestor_novelas.Novelas;

import com.google.firebase.firestore.Exclude;
import com.google.firebase.firestore.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Novel {
    private String id;        // ID del documento en Firestore
    private String title;     // Título de la novela
    private String author;    // Autor de la novela
    private int year;         // Año de publicación
    private String synopsis;  // Sinopsis de la novela
    private boolean favorite; // Estado de favorito

    // Constructor vacío requerido para Firestore
    public Novel() {}

    public Novel(String title, String author, int year, String synopsis) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.synopsis = synopsis;
        this.favorite = false; // Por defecto, no es favorito
    }

    // Getters y Setters

    // ID del documento (no se almacena en Firestore)
    @Exclude
    public String getId() {
        return id;
    }

    @Exclude
    public void setId(String id) {
        this.id = id;
    }

    // Campo 'favorite'
    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    // Otros getters y setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
}
