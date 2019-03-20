package no.hiof.olehj.oblig5.data;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import no.hiof.olehj.oblig5.model.Film;

import java.io.*;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;

public class DataHandler {

    private static int arTall =0;

    private static int alfaTall=0;

    private final static ObservableList<Film> filmListe = FXCollections.observableArrayList();

    public static ObservableList<Film> hentFilmData(){

        File kilde = new File("filmer_1000.csv");

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(kilde))){
            String linje;

            while((linje = bufferedReader.readLine()) != null){
                String[] deler = linje.split(";");

                Film nyFilm = new Film(deler[0],deler[1],Double.valueOf(deler[2]),LocalDate.parse(deler[3]),deler[4]);

                filmListe.add(nyFilm);
            }

        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

        if(filmListe.isEmpty()){
            Film hobbit = new Film("Hobbit","Si-Fi",3,LocalDate.of(2012,11,28),"Dosen't have a picture");
            Film birdBox = new Film("Bird Box","Horror",1.5,LocalDate.of(2018,11,12),"Dosen't have a picture");
            Film theRoom = new Film("The Room","Humor",1.5,LocalDate.of(2003,06,27),"Dosen't have a picture");
            Film test1 = new Film("test1","test1",0,LocalDate.of(1999,06,27),"Dosen't have a picture");
            Film test2 = new Film("test2","test2",0,LocalDate.of(1978,06,27),"Dosen't have a picture");
            filmListe.addAll(hobbit, birdBox, theRoom,test1,test2);
        }

        return filmListe;
    }

    public static void leggTilFim(Film nyFilm){
        filmListe.add(nyFilm);
    }

    public static void slettFilm(int filmRemember){
        filmListe.remove(filmRemember);
    }

    public static void SortByYear(){
        if(arTall == 0) {
            Collections.sort(filmListe, new Comparator<Film>() {
                @Override
                public int compare(Film a, Film b) {
                    return a.getUtgivelsesdato().compareTo(b.getUtgivelsesdato());
                }
            });
            arTall++;
        }
        else if(arTall == 1){
            Collections.reverse(filmListe);
            arTall--;
        }

        alfaTall = 0;
    }

    public static void SortByAlfa(){
        if(alfaTall == 0){
            Collections.sort(filmListe);
            alfaTall++;
        }
        else if(alfaTall == 1){
            Collections.reverse(filmListe);
            alfaTall--;
        }
        arTall = 0;
    }
}
