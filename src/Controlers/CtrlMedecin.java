package Controlers;

import Entities.Medecin;
import Tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlMedecin
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlMedecin() {
        cnx = ConnexionBDD.getCnx();
    }

    public ArrayList<Medecin> getAllMedecins()
    {
        ArrayList<Medecin> lesMedecins = new ArrayList<>();

        try {
            ps = cnx.prepareStatement("Select idMedecin, nomMedecin from medecin");
            rs = ps.executeQuery();
            while (rs.next()) {
                 Medecin medecin = new Medecin(rs.getInt("idMedecin"),rs.getString("nomMedecin"));
                 lesMedecins.add(medecin);
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlMedecin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesMedecins;
    }

    public int getIdMedecinByName(String nomMed)
    {
        String nomMedecin = "";
        try {
            ps = cnx.prepareStatement("select nomMedecin from medecin WHERE numMedecin= ?");
            ps.setString(1, nomMed);
            rs = ps.executeQuery();
            rs.next();
            nomMedecin = rs.getString("nomPigiste");
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlMedecin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Integer.parseInt(nomMedecin);
    }
}
