package no.hiof.olehj.oblig5.model;

import java.time.LocalDate;
import java.util.ArrayList;

/** Representerer Produksjon.
 * @author olehj
 * @version 1.0
 * @since 1.0
 */

public abstract class Produksjon {

    private String title, beskrivelse;
    private double length;
    private LocalDate utgivelsesdato;
    private Person regissor;
    private ArrayList<Rolle> roller = new ArrayList<>();

    /** Henter titelen til Produksjon.
     * @return En String med navnet.
     */

    public String getTitle() {
        return title;
    }

    /** Henter lengden til Produksjon.
     * @return En double med lengden.
     */

    public double getLength() {
        return length;
    }

    /** Hneter beskrivelsen av produksjon.
     * @return En String med beskrivelsen.
     */

    public String getBeskrivelse() {
        return beskrivelse;
    }

    /** Henter utgivelsesdatoen til Produksjon.
     * @return En LocalDate med datoen.
     */

    public LocalDate getUtgivelsesdato() {
        return utgivelsesdato;
    }

    /** Henter Regissor til Peroduksjon.
     * @return En Person med navn til regissor.
     */

    public Person getRegissor() {
        return regissor;
    }

    /** Henter alle rollene fra Produksjon.
     * @return En liste med alle rollene.
     */

    public ArrayList<Rolle> getRoller() {
        return roller;
    }

    /** Setter titlene til Produksjon.
     * @param title En String med Produksjon sin titel.
     */

    public void setTitle(String title) {
        this.title = title;
    }

    /** Setter lengden til Produksjon.
     * @param length En double med verdien for lengden.
     */

    public void setLength(double length) {
        this.length = length;
    }

    /** Setter beskrivelse til Produksjon.
     * @param beskrivelse En String som inneholder beskrivelsen.
     */

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    /** Setter utgivelsesdatoen til Produksjon.
     * @param utgivelsesdato En LocalDate som inneholder datoen.
     */

    public void setUtgivelsesdato(LocalDate utgivelsesdato) {
        this.utgivelsesdato = utgivelsesdato;
    }

    /** Setter regissoreren til Produksjon.
     * @param regissor En Person som inneholder navnet til reggissor.
     */

    public void setRegissor(Person regissor) {
        this.regissor = regissor;
    }

    /** Lager en Produksjon med spesifike verdier.
     * @param title Filmen sin titel.
     * @param beskrivelse Beskrivelse av filmen.
     * @param length Lengden til filmen.
     * @param utgivelsesdato Naar filmen er utgitt.
     */

    public Produksjon(String title, String beskrivelse, double length, LocalDate utgivelsesdato) {
        this.title = title;
        this.beskrivelse = beskrivelse;
        this.length = length;
        this.utgivelsesdato = utgivelsesdato;
    }

    /** Lager en Produksjon med spesifike verdier.
     * @param title Filmen sin titel.
     * @param length Lengden til filmen.
     */

    public Produksjon(String title, double length) {
        this.title = title;
        this.length = length;
    }

    /** Legger til en rolle i listen roller.
     * @param enRolle En Rolle som inneholder karakteren og skuespiller.
     */

    public void leggTilEnRolle(Rolle enRolle){

        roller.add(enRolle);

    }

    /** Legger til en liste med roller til listen roller.
     * @param flereRoller En liste med roller.
     */

    public void leggTilMangeRoller(ArrayList<Rolle> flereRoller){

        for(int i = 0; i < flereRoller.size(); i++){
            roller.add(flereRoller.get(i));
        }

    }

    /** En toString for fremvisning av Produksjon.
     * @return Returnerer titelen, lengden, utgivelsesdato og regissoren til Produksjon.
     */

    @Override
    public String toString(){
        return "Produksjon: Tittel=" + title + ", Lengde=" + length + ", Utgivelsesdato=" + utgivelsesdato + ", Regissør=" + regissor;
    }

}
