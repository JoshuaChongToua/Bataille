package devoirBataille;

import java.util.ArrayList;
import java.util.Collections;

public class Carte {
    private static String[] couleurs = {"coeur", "carreau", "pique", "trefle"};
    private static int[] valeurs = {2,3,4,5,6,7,8,9,10,11,12,13,14};
    private int value;
    private String couleur;

    public Carte(int value, String couleur) {
        this.value = value;
        this.couleur = couleur;
    }

    public Carte() {

    }

    public String comparateur(Carte c1, Carte c2) {
        if (c1.getValue() > c2.getValue()) {
            return "j1";
        }
        else if (c1.getValue() == c2.getValue()) {
            return "egalite";
        }
        else {
            return "j2";
        }
    }

    public ArrayList<Carte> creationPaquet(){
        ArrayList<Carte> cartes = new ArrayList<>();
        for (int val : valeurs) {
            for (String couleur : couleurs) {
                Carte carte = new Carte(val,couleur);
                cartes.add(carte);
            }
        }
        return cartes;
    }

    public void afficherPaquet(ArrayList<Carte> cartes) {
        for (Carte carte : cartes) {
            System.out.println(carte);
        }
    }

    public void melange(ArrayList<Carte> cartes) {
        Collections.shuffle(cartes);
    }

    public void distribution(Joueur j1, Joueur j2, ArrayList<Carte> cartes) {
        int tour = 0;
        for (Carte carte : cartes ) {

            if (tour == 0) {
                j1.ajouterCarte(carte);
                tour = 1;
            }
            else {
                j2.ajouterCarte(carte);
                tour = 0;
            }

        }
    }


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public static String[] getCouleurs() {
        return couleurs;
    }

    public static void setCouleurs(String[] couleur) {
        Carte.couleurs = couleur;
    }

    public static int[] getValeurs() {
        return valeurs;
    }

    public static void setValeurs(int[] valeur) {
        Carte.valeurs = valeur;
    }

    @Override
    public String toString() {
        if (value == 11) {
            return "Valet de " + couleur;
        } else if (value == 12) {
            return "Dame de " + couleur;
        } else if (value == 13) {
            return "Roi de " + couleur;
        } else if (value == 14) {
            return "As de " + couleur;
        } else {
            return value + " de " + couleur;
        }
    }
}
