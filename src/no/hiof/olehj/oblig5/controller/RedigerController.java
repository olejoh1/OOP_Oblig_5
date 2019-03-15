package no.hiof.olehj.oblig5.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import no.hiof.olehj.oblig5.MainJavaFX;
import no.hiof.olehj.oblig5.data.DataHandler;
import no.hiof.olehj.oblig5.model.Film;

import java.io.File;
import java.time.LocalDate;



public class RedigerController {

    private int filmRemember = FilmController.getFilmRemember();

    private Film film;

    @FXML
    private TextArea filmTittel;

    @FXML
    private TextArea filmBeskrivelse;

    @FXML
    private DatePicker filmUtgivelsesdato;

    @FXML
    private TextField filmSpilletid;

    @FXML
    public void initialize(){

        film = DataHandler.hentFilmData().get(filmRemember);

        filmTittel.setText(film.getTitle());
        filmBeskrivelse.setText(film.getBeskrivelse());
        filmUtgivelsesdato.setValue(film.getUtgivelsesdato());
        filmSpilletid.setText(String.valueOf(film.getLength()));



    }


    public void cancelEdit(ActionEvent actionEvent) {

        MainJavaFX minApplikasjon = MainJavaFX.getInstance();

        minApplikasjon.gaaTilHovedScene();

    }

    public void filmRediger(ActionEvent actionEvent) {

        String tittelEdit = filmTittel.getText();
        String beskrivelseEdit = filmBeskrivelse.getText();
        LocalDate utgivelsesdatoEdit = filmUtgivelsesdato.getValue();
        double lengthEdit = Double.valueOf(filmSpilletid.getText());


        System.out.println(tittelEdit);
        System.out.println(beskrivelseEdit);
        System.out.println(utgivelsesdatoEdit);
        System.out.println(lengthEdit);

        film.setTitle(tittelEdit);
        film.setBeskrivelse(beskrivelseEdit);
        film.setLength(lengthEdit);
        film.setUtgivelsesdato(utgivelsesdatoEdit);

        MainJavaFX minApplikasjon = MainJavaFX.getInstance();

        minApplikasjon.gaaTilHovedScene();


    }
}
