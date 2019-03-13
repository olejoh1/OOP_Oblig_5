package no.hiof.olehj.oblig5.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class TVSerie implements Comparable<TVSerie> {




    private String title;
    private String beskrielse;
    private LocalDate utgivelsesdato;
    private int episodes;
    private ArrayList<Episode> episoder = new ArrayList<Episode>();
    private double gjennomsnittligSpilletid;
    private int antallSesonger;


    public TVSerie(String title, String beskrielse, LocalDate utgivelsesdato, int episodes) {
        this.title = title;
        this.beskrielse = beskrielse;
        this.utgivelsesdato = utgivelsesdato;
        this.episodes = episodes;
    }

    public String getTitle() {
        return title;
    }

    public String getBeskrielse() {
        return beskrielse;
    }

    public LocalDate getUtgivelsesdato() {
        return utgivelsesdato;
    }

    public int getEpisodes() {
        return episodes;
    }

    public ArrayList<Episode> hentEpisodeISesong(int sesong){
        ArrayList<Episode> episoderISesong = new ArrayList<>();
        for(Episode episode : episoder){
            if(episode.getSeason() == sesong){
                episoderISesong.add(episode);
            }
        }
        return episoderISesong;
    }

    public int getAntallSesonger() {
        antallSesonger = 0;
        for( int i = 0; i < episoder.size(); i++){
            if(antallSesonger <= episoder.get(i).getSeason()){
                antallSesonger = episoder.get(i).getSeason();
            }
        }
        return antallSesonger;
    }


    public void leggTilEpisode(Episode episode){

        getAntallSesonger();
        int sesongNR = antallSesonger + 1;
        if(antallSesonger >= episode.getSeason()){
            episoder.add(episode);
        }
        else if(sesongNR == episode.getSeason()){
            episoder.add(episode);
        }
        else {
            System.out.println("Beklager serien her ikke nåd denne sesongen enda");
        }
        this.oppdaterGjennomsnittligSpilletid();
    }


    public List<Episode> getEpisoder(){
        return episoder;
    }


    public double getGjennomsnittligSpilletid() {
        oppdaterGjennomsnittligSpilletid();
        return gjennomsnittligSpilletid;
    }


    private double oppdaterGjennomsnittligSpilletid(){
        double sum = 0;
        for(Episode episode : episoder) {
            sum = sum + episode.getLength();
        }
        gjennomsnittligSpilletid = sum/episoder.size();

        return gjennomsnittligSpilletid;
    }

    //---Oppgave 10---
    public void hentRollebesetning(){

        for(Episode episode : episoder){
            if(episode.getRoller() != null) {
                System.out.println("\n" + episode.getRoller());
            }
        }

    }


    @Override
    public int compareTo(TVSerie other){
        return this.getTitle().compareTo(other.getTitle());
    }

    @Override
    public String toString() {
        return "TVSerie{" +
                "title='" + title + '\'' +
                ", beskrielse='" + beskrielse + '\'' +
                ", utgivelsesdato=" + utgivelsesdato +
                ", episodes=" + episodes +
                ", episoder=" + episoder +
                '}';
    }

}
