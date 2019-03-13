package no.hiof.olehj.oblig5.model;

import java.time.LocalDate;
import java.util.Comparator;

public class Episode extends Produksjon implements Comparable<Episode>{
    private int episodenummer;
    private int season;



    public Episode(int episodenummer, int season, String title, double length) {
        super(title, length);
        this.episodenummer = episodenummer;
        this.season = season;
    }

    public Episode(int episodenummer, int season, String title, String beskrivelse, double length, LocalDate utgivelsesdato) {
        super(title, beskrivelse, length, utgivelsesdato);
        this.episodenummer = episodenummer;
        this.season = season;
    }

    public int getEpisodenummer() {
        return episodenummer;
    }

    public int getSeason() {
        return season;
    }


    @Override
    public int compareTo(Episode other) {
        return Comparator.comparing(Episode::getSeason).thenComparing(Episode::getEpisodenummer).compare(this, other);
    }

    @Override
    public String toString() {
        return "Episode{" +
                "episodenummer=" + episodenummer +
                ", season=" + season +
                ", title='" + getTitle() + '\'' +
                ", length=" + getLength() +
                '}';
    }
}
