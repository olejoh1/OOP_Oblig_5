package no.hiof.olehj.oblig5.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/** Representerer TVSerie.
 * @author olehj
 * @version 1.0
 * @since 1.0
 */

public class TVSerie implements Comparable<TVSerie> {




    private String title;
    private String beskrielse;
    private LocalDate utgivelsesdato;
    private int episodes;
    private ArrayList<Episode> episoder = new ArrayList<Episode>();
    private double gjennomsnittligSpilletid;
    private int antallSesonger;

    /** Lager en TvSerie med spesifike verdier.
     * @param title Navnet på Serien.
     * @param beskrielse Beskrivelse av Serien.
     * @param utgivelsesdato Naar Serien først ble vist på Tv.
     * @param episodes Hvor mange episoder Serien har.
     */

    public TVSerie(String title, String beskrielse, LocalDate utgivelsesdato, int episodes) {
        this.title = title;
        this.beskrielse = beskrielse;
        this.utgivelsesdato = utgivelsesdato;
        this.episodes = episodes;
    }

    /** Henter titelen til Serien.
     * @return En String med titelen til Serien.
     */

    public String getTitle() {
        return title;
    }

    /** Henter beskrivelsen av serien.
     * @return En String med beskrivelsen av Serien.
     */

    public String getBeskrielse() {
        return beskrielse;
    }

    /** Henter utgivelsesdatoen til Serien.
     * @return En LocalDate med utgivelsesdato.
     */

    public LocalDate getUtgivelsesdato() {
        return utgivelsesdato;
    }

    /** Henter antall episoder i Serien.
     * @return En int med antall episoder
     */

    public int getEpisodes() {
        return episodes;
    }

    /** Henter episoder fra en betemt sesong.
     * @param sesong Veriden for hvilken sesong vi vil hente episoder fra.
     * @return En liste med alle episodene i den spesifike sesongen.
     */

    public ArrayList<Episode> hentEpisodeISesong(int sesong){
        ArrayList<Episode> episoderISesong = new ArrayList<>();
        for(Episode episode : episoder){
            if(episode.getSeason() == sesong){
                episoderISesong.add(episode);
            }
        }
        return episoderISesong;
    }

    /** Henter hvor mange sesonger det er i Serien.
     * @return En int med hvor mange sesonger.
     */

    public int getAntallSesonger() {
        antallSesonger = 0;
        for( int i = 0; i < episoder.size(); i++){
            if(antallSesonger <= episoder.get(i).getSeason()){
                antallSesonger = episoder.get(i).getSeason();
            }
        }
        return antallSesonger;
    }

    /** Legger til en episode i Serie.
     * @param episode Episoden vi oonsker å legge til i serien.
     */

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

    /** Henter alle episoder i Serien.
     * @return En liste med alle episoder i Serien.
     */

    public List<Episode> getEpisoder(){
        return episoder;
    }

    /** Henter gjennosnittet av spilletiden til Serien.
     * @return En Double med gjennomsnittlig spilletid.
     */

    public double getGjennomsnittligSpilletid() {
        oppdaterGjennomsnittligSpilletid();
        return gjennomsnittligSpilletid;
    }

    /** Oppdaterer gjennomsnittligSpilletid.
     * @return EN Double med gjennomsnittligSpilletid.
     */

    private double oppdaterGjennomsnittligSpilletid(){
        double sum = 0;
        for(Episode episode : episoder) {
            sum = sum + episode.getLength();
        }
        gjennomsnittligSpilletid = sum/episoder.size();

        return gjennomsnittligSpilletid;
    }

    /**
     * Skriver ut alle rollene i Serien.
     */

    public void hentRollebesetning(){

        for(Episode episode : episoder){
            if(episode.getRoller() != null) {
                System.out.println("\n" + episode.getRoller());
            }
        }

    }

    /** Sammenligner en serie sin titel mot en annen.
     * @param other Serie som skal sammenlignes.
     * @return En int med verdi som bestemmer om titelen kommer alfabetisk etter eller før den andre.
     */

    @Override
    public int compareTo(TVSerie other){
        return this.getTitle().compareTo(other.getTitle());
    }

    /** En toString for fremvisning av Serien.
     * @return Returnerer String av titelen til Serien, beskrivelsen til serien, LocalDate av utgivelsesdato,
     * int av antall episoder og en liste med alle episoder i Serien.
     */

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
