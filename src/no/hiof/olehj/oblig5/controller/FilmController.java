package no.hiof.olehj.oblig5.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import no.hiof.olehj.oblig5.MainJavaFX;
import no.hiof.olehj.oblig5.data.DataHandler;
import no.hiof.olehj.oblig5.model.Film;

import java.io.File;

public class FilmController {

    private static int filmRemember;

    @FXML
    private ListView<Film> filmListe;

    @FXML
    private Label tittelLabel;

    @FXML
    private TextArea filmBeskrivelse;

    @FXML
    private TextField filmUtgivelsesdato;

    @FXML
    private TextField filmSpilletid;

    @FXML
    public void initialize(){

        File kilde = new File("filmer_1000.csv");

        filmListe.setItems(DataHandler.hentFilmData(kilde));

        filmListe.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Film>() {
            @Override
            public void changed(ObservableValue<? extends Film> observableValue, Film forrigeFilm, Film nyFilm) {
                tittelLabel.setText(nyFilm.getTitle());
                filmBeskrivelse.setText(nyFilm.getBeskrivelse());
                filmUtgivelsesdato.setText(String.valueOf(nyFilm.getUtgivelsesdato()));
                filmSpilletid.setText(nyFilm.getLength() + " timer");
                filmRemember = filmListe.getSelectionModel().getSelectedIndex();
                System.out.println(filmRemember);
            }

        });


        filmListe.getSelectionModel().select(0);
    }

    public void nyFilm(ActionEvent actionEvent) {
        AnonymousClasses.ny();
    }

    public void slettFilm(ActionEvent actionEvent) {
        AnonymousClasses.slett();
    }

    public void redigerFilm(ActionEvent actionEvent) {
        AnonymousClasses.edit();
    }

    public static int getFilmRemember() {
        return filmRemember;
    }
}

class AnonymousClasses{
    static void edit(){
        MainJavaFX minApplikasjon = MainJavaFX.getInstance();

        minApplikasjon.gaaTilEdit();
    }
    static void ny(){
        MainJavaFX minApplikasjon = MainJavaFX.getInstance();

        minApplikasjon.gaaTilNy();
    }
    static void slett(){
        DataHandler.slettFilm(FilmController.getFilmRemember());
    }
}