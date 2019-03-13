package no.hiof.olehj.oblig5.model;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Produksjon {

    private String title, beskrivelse;
    private double length;
    private LocalDate utgivelsesdato;
    private Person regissor;
    private ArrayList<Rolle> roller = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public double getLength() {
        return length;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public LocalDate getUtgivelsesdato() {
        return utgivelsesdato;
    }

    public Person getRegissor() {
        return regissor;
    }

    public ArrayList<Rolle> getRoller() {
        return roller;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public void setUtgivelsesdato(LocalDate utgivelsesdato) {
        this.utgivelsesdato = utgivelsesdato;
    }

    public void setRegissor(Person regissor) {
        this.regissor = regissor;
    }

    public Produksjon(String title, String beskrivelse, double length, LocalDate utgivelsesdato) {
        this.title = title;
        this.beskrivelse = beskrivelse;
        this.length = length;
        this.utgivelsesdato = utgivelsesdato;
    }

    public Produksjon(String title, double length) {
        this.title = title;
        this.length = length;
    }

    public void leggTilEnRolle(Rolle enRolle){

        roller.add(enRolle);

    }

    public void leggTilMangeRoller(ArrayList<Rolle> flereRoller){

        for(int i = 0; i < flereRoller.size(); i++){
            roller.add(flereRoller.get(i));
        }

    }

    @Override
    public String toString(){
        return "Produksjon: Tittel=" + title + ", Lengde=" + length + ", Utgivelsesdato=" + utgivelsesdato + ", Regissør=" + regissor;
    }

}
