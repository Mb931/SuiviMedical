package Controlers;

import Entities.Consultation;
import Tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlConsultation
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlConsultation() {
        cnx = ConnexionBDD.getCnx();
    }

    public ArrayList<Consultation> GetAllConsultations()
    {
        ArrayList<Consultation> lesConsultations = new ArrayList<>();
        try{
            ps = cnx.prepareStatement("SELECT consultation.idConsult, consultation.dateConsult, patient.nomPatient, medecin.nomMedecin, round(((prescrire.quantite*medicament.prixMedoc)*vignette.tauxRemb),2) as montant FROM consultation, patient, medecin, prescrire, medicament, vignette Where consultation.numPatient = patient.idPatient AND consultation.numMedecin = medecin.idMedecin AND consultation.idConsult = prescrire.numConsult AND prescrire.numMedoc = medicament.idMedoc AND medicament.numVignette = vignette.idVignette");
            rs= ps.executeQuery();
            while (rs.next()){
                Consultation consultation = new Consultation(rs.getInt("consultation.idConsult"), rs.getString("consultation.dateConsult"), rs.getString("patient.nomPatient"), rs.getString("medecin.nomMedecin"),rs.getDouble("montant") );
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlConsultation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesConsultations;
    }
    public int getLastNumberOfConsultation()
    {

        return 0;
    }
    public void InsertConsultation(int idConsult, String dateConsultation, int numPatient,int numMedecin)
    {
        try {
            ps = cnx.prepareStatement("insert into consultation values (?,?,?,?,?)");
            ps.setInt(1, idConsult);
            ps.setInt(2, idConsult);
            ps.setString(3, dateConsultation);
            ps.setInt(4, numPatient);
            ps.setInt(5, numMedecin);
            ps.executeUpdate();
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlConsultation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

