package no.hiof.olehj.oblig5.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import no.hiof.olehj.oblig5.model.Film;

import java.time.LocalDate;
import java.util.Collections;

public class DataHandler {

    private final static ObservableList<Film> filmListe = FXCollections.observableArrayList();
    private final static ObservableList<String> filmTitler = FXCollections.observableArrayList();

    public static ObservableList<Film> hentFilmData(){
        if(filmListe.isEmpty()){
            Film hobbit = new Film("Hobbit","Si-Fi",3,LocalDate.of(2012,11,28));
            Film birdBox = new Film("Bird Box","Horror",1.5,LocalDate.of(2018,11,12));
            Film theRoom = new Film("The Room","Humor",1.5,LocalDate.of(2003,06,27));
            Film test1 = new Film("test1","test1",0,LocalDate.now());
            Film test2 = new Film("test2","test2",0,LocalDate.now());
            filmListe.addAll(hobbit, birdBox, theRoom,test1,test2);
        }

        Collections.sort(filmListe);

        return filmListe;
    }

    public static ObservableList<String> hentFilmTitler(){
        for(int i =0; i < filmListe.size(); i++){
            filmTitler.add(filmListe.get(i).getTitle());
        }

        return filmTitler;
    }

    public static void leggTilFim(Film nyFilm){
        filmListe.add(nyFilm);
    }

    public static void slettFilm(int filmRemember){
        filmListe.remove(filmRemember);
    }
}
