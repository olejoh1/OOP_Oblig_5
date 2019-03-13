package no.hiof.olehj.oblig5.model;

public class Person {

    private String fornavn;
    private String etternavn;
    private int alder;

    public String getFornavn() {
        return fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public int getAlder() {
        return alder;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public void setAlder(int alder) {
        this.alder = alder;
    }

    public Person(String fornavn, String etternavn, int alder) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.alder = alder;
    }

    public String getFullNavn(){
        return getFornavn() + " " + getEtternavn();
    }

    @Override
    public String toString(){
        return "Person: Fornavn=" + fornavn + ", Etternavn=" + etternavn + ", Alder=" + alder;
    }
}
