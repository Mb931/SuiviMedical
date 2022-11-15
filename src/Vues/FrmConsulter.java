package Vues;

import Controlers.CtrlConsultation;
import Controlers.CtrlMedicament;
import Tools.ModelJTable;
import Entities.Consultation;
import Entities.Medicament;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrmConsulter extends JFrame
{
    private JPanel pnlRoot;
    private JLabel lblTitre;
    private JLabel lblConsultations;
    private JTable tblConsultations;
    private JLabel lblMedicaments;
    private JTable tblMedicaments;

    private ModelJTable modelJTable;



    CtrlConsultation ctrlConsultation;
    CtrlMedicament ctrlMedicament;
    public FrmConsulter()
    {
        this.setTitle("Consulter");
        this.setContentPane(pnlRoot);
        this.pack();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                super.windowOpened(e);
                // A vous de jouer
                ctrlConsultation = new CtrlConsultation();
               modelJTable = new ModelJTable();
               modelJTable.loadDatasConsultation(ctrlConsultation.GetAllConsultations());
               tblConsultations.setModel(modelJTable);

            }
        });

            tblConsultations.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                // A vous de jouer
                int numMedicament = Integer.parseInt(tblMedicaments.getValueAt(tblMedicaments.getSelectedRow(), 0).toString());
                ctrlMedicament = new CtrlMedicament();
                modelJTable = new ModelJTable();
                modelJTable.loadDatasMedicament(ctrlMedicament.GetAllMedicamentsByIdConsultations(numMedicament));
                tblMedicaments.setModel(modelJTable);
            }
        });
    }
}
