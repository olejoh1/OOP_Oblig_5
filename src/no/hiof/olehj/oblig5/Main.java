package no.hiof.olehj.oblig5;

import no.hiof.olehj.oblig5.model.*;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Random;

public class Main {



    public static void main(String[] args) {


        Random rand = new Random();

        LocalDate date1 = LocalDate.of(2008,1,20);
        TVSerie show = new TVSerie("Breaking Bad", "Crime",date1, 62);
        System.out.println("\n\nSerien som blir brukt er Breaking Bad" +
                "\nPrint av faktaen om serien:" +
                "\nTittel: " + show.getTitle()+
                "\nBeksrivelse: " + show.getBeskrielse() +
                "\nUtgivelsesdato: " + show.getUtgivelsesdato() +
                "\nAntall episoder: " + show.getEpisodes() +
                "\n\n" + show);


        ArrayList<Episode> episoder = (ArrayList<Episode>) show.getEpisoder();


        Film hobbit = new Film("Hobbit", 0);
        Film birdBox = new Film("Bird Box", 0);
        Film theRoom = new Film("The Room", 0);


        hobbit.setUtgivelsesdato(LocalDate.of(2012,11,28));
        hobbit.setBeskrivelse("Si-fi");

        birdBox.setUtgivelsesdato(LocalDate.of(2018,11,12));
        birdBox.setBeskrivelse("Horror");

        theRoom.setUtgivelsesdato(LocalDate.of(2003,06,27));
        theRoom.setBeskrivelse("Humor");


        Person tommyWiseau = new Person("Tommy","Wiseau",696969);
        Person susanneBier = new Person("Susanne","Bier",58);
        Person peterJackson = new Person("Peter","Jackson",57);
        Person vinceGilligan = new Person("Vince","Gilligan",51);
        Person martinFreeman = new Person("Martin","Freeman",47);
        Person bryanCreaston = new Person("Bryan","Creaston",62);
        Person gregSestero = new Person("Gregory","Sestero",40);

        Episode episode1 = new Episode(1, 1, "Pilot", 43.21);
        show.leggTilEpisode(episode1);

        Episode episode2 = new Episode(1, 2, "Cat's in the Bag...", 45.34);
        show.leggTilEpisode(episode2);

        Episode episode3 = new Episode(1, 3, "...And the Bag's in the River", 41.12);
        show.leggTilEpisode(episode3);

        for(int i = 0; i < episoder.size(); i++) {
            System.out.println("\nTittel: " + episoder.get(i).getTitle() + "\nEpisodenummer: " + episoder.get(i).getEpisodenummer() +
                    "\nSesong: " + episoder.get(i).getSeason() + "\nLengde: " + episoder.get(i).getLength() + "min");
        }


        Rolle hovedRolleHobbit = new Rolle("Bilbo","Baggins",martinFreeman);
        hobbit.leggTilEnRolle(hovedRolleHobbit);

        Rolle hovedRolleBreakingBad = new Rolle("Walter","White",bryanCreaston);
        episode1.leggTilEnRolle(hovedRolleBreakingBad);

        Rolle hovedRolleTheRoom = new Rolle("Jonny","?",tommyWiseau);
        Rolle mark = new Rolle("Mark","?",gregSestero);


        for(int i = 0; i < 3; i++){
            for(int j = 1; j < 3; j++){
                double randNR = rand.nextInt(10) + 20;
                Episode episodeRDM = new Episode(j, i, "Random", randNR);
                show.leggTilEpisode(episodeRDM);
                episodeRDM.leggTilEnRolle(hovedRolleBreakingBad);
            }
        }



        Episode episodeFeilSesong = new Episode(1,7,"Random", 0);
        show.leggTilEpisode(episodeFeilSesong);


        Episode episodeRiktigSesong = new Episode(1,6,"Random", 0);
        show.leggTilEpisode(episodeRiktigSesong);


        hobbit.setRegissor(peterJackson);
        theRoom.setRegissor(tommyWiseau);
        episode1.setRegissor(vinceGilligan);

        ArrayList<Rolle> rollerTheRoom = new ArrayList<>();
        rollerTheRoom.add(hovedRolleTheRoom);
        rollerTheRoom.add(mark);

        theRoom.leggTilMangeRoller(rollerTheRoom);

        TVSerie show2 = new TVSerie("Ape","test",date1,0);
        TVSerie show3 = new TVSerie("Ape2","test",date1,0);
        TVSerie show4 = new TVSerie("Demon","test",date1,0);

        ArrayList<TVSerie> serieListe = new ArrayList<>();
        serieListe.add(show);
        serieListe.add(show2);
        serieListe.add(show3);
        serieListe.add(show4);

        Collections.sort(serieListe);

        System.out.println(serieListe);

        Episode episodeTest1 = new Episode(1,1,"test1",0);
        Episode episodeTest2 = new Episode(1,2,"test2",0);
        Episode episodeTest3 = new Episode(1,3,"test3",0);
        Episode episodeTest4 = new Episode(2,1,"test4",0);
        ArrayList<Episode> episodeListe = new ArrayList<>();
        episodeListe.add(episodeTest3);
        episodeListe.add(episodeTest1);
        episodeListe.add(episodeTest2);
        episodeListe.add(episodeTest4);

        Collections.sort(episodeListe);
        System.out.println(episodeListe);

        ArrayList<Film> filmListe = new ArrayList<>();
        filmListe.add(hobbit);
        filmListe.add(birdBox);
        filmListe.add(theRoom);

        Collections.sort(filmListe);

        System.out.println(filmListe);
    }
}
