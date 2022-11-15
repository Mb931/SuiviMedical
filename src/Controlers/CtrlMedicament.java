package Controlers;

import Entities.Consultation;
import Entities.Medicament;
import Tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlMedicament
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlMedicament() {
        cnx = ConnexionBDD.getCnx();
    }

    public ArrayList<Medicament> GetAllMedicamentsByIdConsultations(int idConsultation)
    {
        ArrayList<Medicament> lesMedicaments = new ArrayList<>();
        try {
            ps = cnx.prepareStatement("SELECT idMedoc, nomMedoc, prixMedoc FROM medicament, prescrire Where idMedoc=numMedoc AND numConsult = ?");
            ps.setInt(1, idConsultation);
            rs = ps.executeQuery();
            while (rs.next()) {
                Medicament medicament = new Medicament(rs.getInt("idMedoc"), rs.getString("nomMedoc"),rs.getDouble("prixMedoc"));
                lesMedicaments.add(medicament);
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlMedicament.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesMedicaments;
    }
    public ArrayList<Medicament> getAllMedicaments()
    {
        ArrayList<Medicament> toutMedicament = new ArrayList<>();
        try {
            ps = cnx.prepareStatement("Select idMedoc, nomMedoc, prixMedoc,quantite from medicament, prescrire where idMedoc=numMedoc");
            rs = ps.executeQuery();
            while (rs.next()) {
                Medicament medicament = new Medicament(rs.getInt("idMedoc"), rs.getString("nomMedoc"),rs.getDouble("prixMedoc"), rs.getInt("quantite"));
                toutMedicament.add(medicament);
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlMedicament.class.getName()).log(Level.SEVERE, null, ex);
        }
        return toutMedicament;

    }
}
