package Entities;

public class Medecin{
        private int numero;

        private String nomMedecin;

        public Medecin(){}

        public Medecin(int unNum,String unNom)
        {
            numero= unNum;
            nomMedecin = unNom;

        }


    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNomMedecin() {
        return nomMedecin;
    }

    public void setNomMedecin(String nomMedecin) {
        this.nomMedecin = nomMedecin;
    }
}
