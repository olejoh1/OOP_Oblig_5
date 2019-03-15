package no.hiof.olehj.oblig5.model;

import java.time.LocalDate;

public class Film extends Produksjon implements Comparable<Film>{

    private String bilde;

    public Film(String title, String beskrivelse, double length, LocalDate utgivelsesdato, String bilde) {
        super(title, beskrivelse, length, utgivelsesdato);
        this.bilde = bilde;
    }

    public Film(String title, double length) {
        super(title, length);
    }

    @Override
    public int compareTo(Film other){
        return this.getTitle().compareTo(other.getTitle());
    }

    @Override
    public String toString(){
        return getTitle();
    }
}
