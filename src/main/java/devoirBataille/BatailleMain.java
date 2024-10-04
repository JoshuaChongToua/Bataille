package devoirBataille;

import java.util.ArrayList;
import java.util.Objects;

public class BatailleMain {
    public static void main(String[] args) throws InterruptedException {
        Joueur j1 = new Joueur("Joueur1");
        Joueur j2 = new Joueur("Joueur2");
        Carte cartes = new Carte();
        ArrayList<Carte> paquet = cartes.creationPaquet();

        cartes.melange(paquet);
        cartes.distribution(j1,j2,paquet);

        //Pour Test Bataille
//        Carte deux = new Carte(2, "coeur");
//        Carte deux2 = new Carte(2, "pique");
//        Carte sept = new Carte(7, "trefle");
//        Carte roi = new Carte(13, "carreau");
//        j1.ajouterCarte(deux);
//        j1.ajouterCarte(sept);
//        j2.ajouterCarte(deux2);
//        j2.ajouterCarte(roi);

        while (!(j1.getCartes().isEmpty())  && !(j2.getCartes().isEmpty()) ) {
            ArrayList<Carte> table = new ArrayList<>();
            Carte carteJ1 = j1.tireUneCarte();
            Carte carteJ2 = j2.tireUneCarte();
            table.add(carteJ1);
            table.add(carteJ2);
            System.out.println("J1 : "+ carteJ1.toString());
            System.out.println("J2 : "+ carteJ2.toString());
            if (Objects.equals(cartes.comparateur(carteJ1, carteJ2), "j1")) {
                System.out.println(j1.getNom()+" remporte la manche");
                for(Carte carte:table) {
                    j1.ajouterCarte(carte);
                }
                System.out.println("Score j1 : "+j1.getScore());
            }
            else if (Objects.equals(cartes.comparateur(carteJ1, carteJ2), "egalite")) {
                System.out.println("!!! BATAILLE !!!");
                Carte carteEgaliteJ1 = j1.tireUneCarte();
                Carte carteEgaliteJ2 = j2.tireUneCarte();
                table.add(carteEgaliteJ1);
                table.add(carteEgaliteJ2);
                System.out.println("J1 : "+ carteEgaliteJ1.toString());
                System.out.println("J2 : "+ carteEgaliteJ2.toString());
                if (Objects.equals(cartes.comparateur(carteEgaliteJ1, carteEgaliteJ2), "j1")) {
                    System.out.println(j1.getNom()+" remporte la manche");
                    for(Carte carte:table) {
                        j1.ajouterCarte(carte);
                    }
                    System.out.println("Score j1 : "+j1.getScore());
                }
                else {
                    System.out.println(j2.getNom()+" remporte la manche");
                    for(Carte carte:table) {
                        j2.ajouterCarte(carte);
                    }
                    System.out.println("Score j2 : "+j2.getScore());
                }
            }
            else {
                System.out.println(j2.getNom()+" remporte la manche");
                for(Carte carte:table) {
                    j2.ajouterCarte(carte);
                }
                System.out.println("Score j2 : "+j2.getScore());
            }
            table.clear();
            System.out.println("-----------------------------------");

            Thread.sleep(2000);

        }

        if (j1.getScore() > j2.getScore()) {
            System.out.println(j1.getNom()+" Gagne la partie");
        }
        else {
            System.out.println(j2.getNom()+" Gagne la partie");
        }

    }
}
