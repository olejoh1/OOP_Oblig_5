package no.hiof.olehj.oblig5.model;

import java.time.LocalDate;

public class Film extends Produksjon implements Comparable<Film>{

    public Film(String title, String beskrivelse, double length, LocalDate utgivelsesdato) {
        super(title, beskrivelse, length, utgivelsesdato);
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
