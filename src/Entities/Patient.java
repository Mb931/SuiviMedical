package Entities;

public class Patient{
    private int numero;

    private String nomPatient;

    public Patient(){}

    public Patient(int unNum,String unNom)
    {
        setNumero(unNum);
        setNomPatient(unNom);

    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNomPatient() {
        return nomPatient;
    }

    public void setNomPatient(String nomPatient) {
        this.nomPatient = nomPatient;
    }
}
