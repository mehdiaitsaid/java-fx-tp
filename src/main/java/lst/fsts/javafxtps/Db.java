package lst.fsts.javafxtps;

import java.util.ArrayList;

public class Db {

    private static int ID = 0;
    private static ArrayList<Etudiant> etudiants =  new ArrayList<Etudiant>();

    public static int getId(){
        return ++ID;
    }

    public static Etudiant addEtudiant(String nom, String prenom, String email, String cne){
        Etudiant  etudiant = new Etudiant( nom,  prenom,  email,  cne,  getId());

        etudiants.add(etudiant);
        return etudiant;
    }
    public static Etudiant updateEtudiant(int id, String nom, String prenom, String email, String cne){

        for (Etudiant etudiant : getAllEtudiants()) {
            if (etudiant.getId() == id) {
                etudiant.setNom(nom);
                etudiant.setPrenom(prenom);
                etudiant.setEmail(email);
                etudiant.setCne(cne);


                return etudiant;
            }
        }

        return  new Etudiant();
    }

    public static Etudiant getEtudiantById(int id){
        for (Etudiant etudiant : getAllEtudiants()) {
            if (etudiant.getId() == id) return  etudiant;
        }
        return  new Etudiant();
    }

    public static ArrayList<Etudiant> deleteEtudiantById(int id){
        etudiants.remove(getEtudiantById(id));
        return  getAllEtudiants();
    }


    public static ArrayList<Etudiant> getAllEtudiants(){
        return etudiants;
    }



}
