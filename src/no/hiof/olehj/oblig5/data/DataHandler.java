package no.hiof.olehj.oblig5.data;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import no.hiof.olehj.oblig5.model.Film;

import java.io.*;
import java.time.LocalDate;

public class DataHandler {

    private final static ObservableList<Film> filmListe = FXCollections.observableArrayList();

    public static ObservableList<Film> hentFilmData(){

        File kilde = new File("filmer_1000.csv");
        if(filmListe.size() == 0) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(kilde))) {
                String linje;

                while ((linje = bufferedReader.readLine()) != null) {
                    String[] deler = linje.split(";");

                    Film nyFilm = new Film(deler[0], deler[1], Double.valueOf(deler[2]), LocalDate.parse(deler[3]), deler[4]);

                    filmListe.add(nyFilm);
                }

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

            if (filmListe.isEmpty()) {
                Film hobbit = new Film("Hobbit", "Si-Fi", 3, LocalDate.of(2012, 11, 28), "no_image");
                Film birdBox = new Film("Bird Box", "Horror", 1.5, LocalDate.of(2018, 11, 12), "no_image");
                Film theRoom = new Film("The Room", "Humor", 1.5, LocalDate.of(2003, 06, 27), "no_image");
                Film test1 = new Film("test1", "test1", 0, LocalDate.of(1999, 06, 27), "no_image");
                Film test2 = new Film("test2", "test2", 0, LocalDate.of(1978, 06, 27), "no_image");
                filmListe.addAll(hobbit, birdBox, theRoom, test1, test2);
            }

        }
        return filmListe;
    }

    public static void skrivTilFil(){

        File kilde = new File("filmer_1000.csv");

        try(BufferedWriter bufretSkriver = new BufferedWriter(new FileWriter(kilde))){

            for(Film skrivFilm : filmListe) {

                bufretSkriver.write(skrivFilm.getTitle() + ";" + skrivFilm.getBeskrivelse() + ";" + skrivFilm.getLength() + ";" + skrivFilm.getUtgivelsesdato() + ";" + skrivFilm.getBilde());

                bufretSkriver.newLine();
            }

        }
        catch (FileNotFoundException fnfe){
            System.out.println(fnfe.getMessage());
        }
        catch (IOException ioexc){
            System.out.println(ioexc.getLocalizedMessage());
        }



    }

}
