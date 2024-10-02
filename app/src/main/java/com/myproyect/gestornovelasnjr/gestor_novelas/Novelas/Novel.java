package com.myproyect.gestornovelasnjr.gestor_novelas.Novelas;



import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "novel_table")
public class Novel {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;
    private String author;
    private int year;
    private String synopsis;

    public Novel(String title, String author, int year, String synopsis) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.synopsis = synopsis;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getYear() { return year; }
    public String getSynopsis() { return synopsis; }

    public void setId(int id) { this.id = id; }
}