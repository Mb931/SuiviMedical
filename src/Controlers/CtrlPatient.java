package Controlers;

import Entities.Consultation;
import Entities.Medecin;
import Entities.Patient;
import Tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlPatient
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlPatient() {
        cnx = ConnexionBDD.getCnx();
    }

    public ArrayList<Patient> getAllPatients()
    {
        ArrayList<Patient> lesPatients = new ArrayList<>();

        try {
            ps = cnx.prepareStatement("Select idPatient, nomPatient from patient");
            rs = ps.executeQuery();
            while (rs.next()) {
                Patient patient = new Patient(rs.getInt("idPatient"),rs.getString("nomPatient"));
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlPatient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesPatients;
    }
    public int getIdPatientByName(String nomPat)
    {

        return 0;
    }
}
