package devoirBataille;

import java.util.ArrayList;

public class Joueur {
    private ArrayList<Carte> cartes = new ArrayList<>();
    private String nom;

    public Joueur(String nom) {
        this.nom = nom;
    }

    public Carte tireUneCarte() {
        Carte carte = this.cartes.getFirst();
        this.cartes.remove(carte);

        return carte;
    }

    public void ajouterCarte(Carte carte) {
        this.cartes.add(carte);
    }

    public void afficherPaquet() {
        for (Carte carte : this.cartes) {
            System.out.println(carte.getValue() + " de " + carte.getCouleur());
        }
    }
    public int getScore() {
        return cartes.size();
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Carte> getCartes() {
        return cartes;
    }

    public void setCartes(ArrayList<Carte> cartes) {
        this.cartes = cartes;
    }



}
