package no.hiof.olehj.oblig5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import no.hiof.olehj.oblig5.data.DataHandler;

import java.io.IOException;
import java.util.Optional;

public class MainJavaFX extends Application{

    private Stage primaryStage;

    private static MainJavaFX minApplikasjon;

    public MainJavaFX(){
        minApplikasjon = this;
    }

    @Override
    public void start(Stage primaryStage){
        this.primaryStage = primaryStage;

        gaaTilHovedScene();
    }

    public void gaaTilHovedScene(){
        try{
            FXMLLoader fxmlInnlaster = new FXMLLoader();
            fxmlInnlaster.setLocation(getClass().getResource("view/Filmer.fxml"));
            Parent hovedLayout = fxmlInnlaster.load();

            Scene hovedScene = new Scene(hovedLayout, 803, 441);


            primaryStage.setScene(hovedScene);
            primaryStage.setTitle("Film Liste");
            primaryStage.show();
        }
        catch (IOException ioexc){
            System.out.println(ioexc.getMessage());
        }

    }

    public void gaaTilEdit(){
        try{
            FXMLLoader fxmlInnlaster = new FXMLLoader();
            fxmlInnlaster.setLocation(getClass().getResource("view/Rediger.fxml"));
            Parent hovedLayout = fxmlInnlaster.load();

            Scene hovedScene = new Scene(hovedLayout,338,400);

            primaryStage.setScene(hovedScene);
            primaryStage.setTitle("Rediger");
        }
        catch (IOException ioexc){
            System.out.println(ioexc.getMessage());
        }

    }

    public void gaaTilNy(){
        try{
            FXMLLoader fxmlInnlaster = new FXMLLoader();
            fxmlInnlaster.setLocation(getClass().getResource("view/NyFilm.fxml"));
            Parent hovedLayout = fxmlInnlaster.load();

            Scene hovedScene = new Scene(hovedLayout,338,400);

            primaryStage.setScene(hovedScene);
            primaryStage.setTitle("Ny Film");
        }
        catch (IOException ioexc){
            System.out.println(ioexc.getMessage());
        }

    }

    public static MainJavaFX getInstance(){
        return minApplikasjon;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override

    public void stop(){

        Alert shutdown = new Alert(Alert.AlertType.CONFIRMATION);
        shutdown.setTitle("Shutdown");
        shutdown.setHeaderText("Ready to shutdown");
        shutdown.setContentText("Vil du lagre endringene du har gjort?");

        ButtonType confirm = new ButtonType("Ja");
        ButtonType cancel = new ButtonType("Nei");

        shutdown.getButtonTypes().setAll(confirm, cancel);

        Optional<ButtonType> lagre = shutdown.showAndWait();

        if(lagre.get() == confirm){
            System.out.println("Lagret");
            DataHandler.skrivTilFil();
        }


    }
}
