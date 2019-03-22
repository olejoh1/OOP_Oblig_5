package no.hiof.olehj.oblig5.model;

import java.time.LocalDate;

/** Representerer Film.
 * @author olehj
 * @version 1.0
 * @since 1.0
 */

public class Film extends Produksjon implements Comparable<Film>{

    private String bilde;

    /** Lager en film med spesifike verdier.
     * @param title Filmen sin titel.
     * @param beskrivelse Beskrivelse av filmen.
     * @param length Lengden til filmen.
     * @param utgivelsesdato Naar filmen er utgitt.
     * @param bilde Poster til filmen.
     */

    public Film(String title, String beskrivelse, double length, LocalDate utgivelsesdato, String bilde) {
        super(title, beskrivelse, length, utgivelsesdato);
        this.bilde = bilde;
    }

    /** Lager en film med spesifike verdier.
     * @param title Filmen sin titel.
     * @param length Lengden til filmen.
     */

    public Film(String title, double length) {
        super(title, length);
    }

    /** Henter posteren til filmen.
     * @return En String med nettverkskoden til bildet.
     */

    public String getBilde() {
        return bilde;
    }

    /** Sammenligner film titler mot hverandre.
     * @param other Film som skal sammenlignes.
     * @return En int verdi som bestemmer om filmen sin tittel kommer alfabetisk etter eller før den andre filmen.
     */

    @Override
    public int compareTo(Film other){
        return this.getTitle().compareTo(other.getTitle());
    }

    /** En toString for fremvisning av en film.
     * @return Returnerer titelen til filmen.
     */

    @Override
    public String toString(){
        return getTitle();
    }
}
