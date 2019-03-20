package no.hiof.olehj.oblig5.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import no.hiof.olehj.oblig5.MainJavaFX;
import no.hiof.olehj.oblig5.data.DataHandler;
import no.hiof.olehj.oblig5.model.Film;

import java.io.File;
import java.util.ArrayList;

public class FilmController {

    private static int filmRemember;

    private String image;

    private ObservableList<Film> listeMedFilmer;

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
    private ImageView filmBilde;

    @FXML
    public void initialize() {

        filmListe.setItems(DataHandler.hentFilmData());

        filmListe.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Film>() {
            @Override
            public void changed(ObservableValue<? extends Film> observableValue, Film forrigeFilm, Film nyFilm) {
                tittelLabel.setText(nyFilm.getTitle());
                filmBeskrivelse.setText(nyFilm.getBeskrivelse());
                filmUtgivelsesdato.setText(String.valueOf(nyFilm.getUtgivelsesdato()));

                if(nyFilm.getBilde() == "no_image"){
                    image = "https://www.losriosriverrunners.com/uploads/thumb_image_not_available.png";
                }
                else if(nyFilm.getBilde() != "no_image"){
                    image = "https://image.tmdb.org/t/p/w500" + nyFilm.getBilde();
                }

                filmBilde.setImage( new Image(image));
                filmSpilletid.setText(nyFilm.getLength() + " timer");
                filmRemember = filmListe.getSelectionModel().getSelectedIndex();
                System.out.println(filmRemember);
            }

        });


        filmListe.getSelectionModel().select(0);
    }

    public void nyFilm(ActionEvent actionEvent) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                MainJavaFX minApplikasjon = MainJavaFX.getInstance();

                minApplikasjon.gaaTilNy();
            }
        };
        r.run();
    }

    public void slettFilm(ActionEvent actionEvent) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                DataHandler.slettFilm(FilmController.getFilmRemember());
            }
        };
        r.run();
    }

    public void redigerFilm(ActionEvent actionEvent) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                MainJavaFX minApplikasjon = MainJavaFX.getInstance();

                minApplikasjon.gaaTilEdit();
            }
        };
        r.run();
    }

    public static int getFilmRemember() {
        return filmRemember;
    }

    public void sorterAr(ActionEvent actionEvent) {
        DataHandler.SortByYear();
    }

    public void sorterAlfabetisk(ActionEvent actionEvent) {
        DataHandler.SortByAlfa();
    }
}