package no.hiof.olehj.oblig5.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.util.Callback;
import no.hiof.olehj.oblig5.MainJavaFX;
import no.hiof.olehj.oblig5.data.DataHandler;
import no.hiof.olehj.oblig5.model.Film;

import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;

public class FilmController {

    private static int filmRemember;

    private static int arTall = 0;

    private static int alfaTall = 0;

    private String image;

    private static ObservableList<Film> listeMedFilmer = DataHandler.hentFilmData();

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

        filmListe.setCellFactory(new Callback<ListView<Film>, ListCell<Film>>() {
            @Override
            public ListCell<Film> call(ListView<Film> filmListView) {
                return new FilmCelle();
            }
        });

        filmListe.getSelectionModel().select(0);
    }

    private static class FilmCelle extends ListCell<Film> {
        @Override
        protected void updateItem(Film enFilm, boolean empty){
            super.updateItem(enFilm, empty);

            if(empty || enFilm == null){
                setText(null);
            }
            else {
                setText(enFilm.getTitle() + "-" + enFilm.getUtgivelsesdato().getYear());
            }
        }
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

                Alert slett = new Alert(Alert.AlertType.CONFIRMATION);
                slett.setTitle("Slett Film");
                slett.setHeaderText("Vil du slette filmen?");
                slett.setContentText("Vil du slette " + DataHandler.hentFilmData().get(filmRemember).getTitle());

                ButtonType slettKnapp = new ButtonType("Slett");
                ButtonType slettAll = new ButtonType("Slett Alle");
                ButtonType cancel = new ButtonType("cancel");

                slett.getButtonTypes().setAll(slettKnapp,slettAll,cancel);

                Optional<ButtonType> result = slett.showAndWait();

                if (result.get() == slettKnapp){
                    listeMedFilmer.remove(FilmController.getFilmRemember());

                    filmListe.setItems(listeMedFilmer);
                }
                else if(result.get() == slettAll){
                    Alert sure = new Alert(Alert.AlertType.CONFIRMATION);
                    sure.setTitle("Slett Film");
                    sure.setHeaderText("Vil du slette filmen?");
                    sure.setContentText("Vil du slette alle filmen?");

                    ButtonType comfirm = new ButtonType("Comfirm");

                    sure.getButtonTypes().setAll(comfirm,cancel);

                    Optional<ButtonType> result2 = sure.showAndWait();

                    if(result2.get() == comfirm){
                        Alert last = new Alert(Alert.AlertType.CONFIRMATION);
                        sure.setTitle("Slett Film");
                        sure.setHeaderText("Er du helt sikker?");
                        sure.setContentText("Er du helt sikker?");

                        ButtonType deleteAll = new ButtonType("Yes");

                        last.getButtonTypes().setAll(deleteAll,cancel);

                        Optional<ButtonType> result3 = last.showAndWait();

                        if(result3.get() == deleteAll){
                            listeMedFilmer.removeAll(listeMedFilmer);

                            filmListe.setItems(listeMedFilmer);
                        }
                    }
                }




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

    public static ObservableList<Film> getListeMedFilmer(){
        return listeMedFilmer;
    }

    public void sorterAr(ActionEvent actionEvent) {
        if(arTall == 0) {
            Collections.sort(listeMedFilmer, new Comparator<Film>() {
                @Override
                public int compare(Film a, Film b) {
                    return a.getUtgivelsesdato().compareTo(b.getUtgivelsesdato());
                }
            });
            arTall++;
        }
        else if(arTall == 1){
            Collections.reverse(listeMedFilmer);
            arTall--;
        }

        filmListe.setItems(listeMedFilmer);

        alfaTall = 0;
    }

    public void sorterAlfabetisk(ActionEvent actionEvent) {
        if(alfaTall == 0){
            Collections.sort(listeMedFilmer);
            alfaTall++;
        }
        else if(alfaTall == 1){
            Collections.reverse(listeMedFilmer);
            alfaTall--;
        }

        filmListe.setItems(listeMedFilmer);

        arTall = 0;
    }
}

