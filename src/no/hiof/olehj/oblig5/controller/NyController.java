package no.hiof.olehj.oblig5.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import no.hiof.olehj.oblig5.MainJavaFX;
import no.hiof.olehj.oblig5.data.DataHandler;
import no.hiof.olehj.oblig5.model.Film;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class NyController {

    @FXML
    private TextArea filmTittel;

    @FXML
    private TextArea filmBeskrivelse;

    @FXML
    private DatePicker filmUtgivelsesdato;

    @FXML
    private TextField filmSpilletid;



    public void cancelNy(ActionEvent actionEvent) {
        MainJavaFX minApplikasjon = MainJavaFX.getInstance();

        minApplikasjon.gaaTilHovedScene();
    }

    public void filmNy(ActionEvent actionEvent) {

        String nyFilmTittel = filmTittel.getText();
        String nyFilmBeskrivelse = filmBeskrivelse.getText();
        LocalDate nyFilmUtgivelsesdato = filmUtgivelsesdato.getValue();
        int nyFilmSpilletid = Integer.valueOf(filmSpilletid.getText());

        Film nyFilm = new Film(nyFilmTittel,nyFilmBeskrivelse,nyFilmSpilletid,nyFilmUtgivelsesdato);

        DataHandler.leggTilFim(nyFilm);

        MainJavaFX minApplikasjon = MainJavaFX.getInstance();

        minApplikasjon.gaaTilHovedScene();
    }
}
