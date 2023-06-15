package GUI;

import Entrainement.EntrainementCollectif;
import Entrainement.Exercice;
import Singleton.Club;
import personne.intervenant.Employé;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class JDialogEntCollectif extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textFieldDate;
    private JTextField textFieldDescription;
    private JComboBox comboBoxExercice;
    private JButton ajouterButton;
    private JTable tableExercices;
    private JButton retirerButton;
    private ClubFootball clubFootball;

    public int dureetotal;



    public JDialogEntCollectif() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

    }

    public JDialogEntCollectif(Frame owner, String title, boolean modal) {
        super(owner, modal);
        setTitle(title);
        setContentPane(contentPane);
        pack();
        this.clubFootball = (ClubFootball) owner;

        String[] columnNamesExercice = {"Code","Intitule","Description"};
        Object [][] dataEx = {};
        DefaultTableModel modelexercice = new DefaultTableModel(dataEx,columnNamesExercice);
        tableExercices.setModel(modelexercice);

        Club.getInstance().readCSVFile("C:\\Users\\Alexis\\Desktop\\Informatique Bloc 2\\Q2\\Java\\Exercices.csv");
        RemplirComboboxExercice();

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                onOK();
                String dateStr = textFieldDate.getText();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate dateEnt = LocalDate.parse(dateStr, formatter);
                String desc = textFieldDescription.getText();
                ArrayList<Exercice> listentrainement = new ArrayList<>();
                EntrainementCollectif entrainementCollectif = new EntrainementCollectif(dateEnt,dureetotal,clubFootball.getEmployeLogg(),desc,listentrainement);
                /// REPRENDRE TOUT LES OBJETS PRESENT DANS LA TABLE POUR LES AJOUTER A L ENTRAINEMENT
                DefaultTableModel modelex = (DefaultTableModel)  tableExercices.getModel();
                int rowCount = modelex.getRowCount();
                for (int row = 0; row < rowCount; row++) {
                    Object[] rowData = new Object[modelex.getColumnCount()];

                    for (int column = 0; column < modelex.getColumnCount(); column++) {
                        rowData[column] = modelex.getValueAt(row, column);
                    }
                    String code = (String) rowData[0];
                    String intitule = (String) rowData[1];
                    int dureee = (int) rowData[2];

                    Exercice exercice = new Exercice(code, intitule, dureee);
                    entrainementCollectif.addExerciceEnt(exercice);
                }
                clubFootball.AjouterEntrainementColl(entrainementCollectif);



            }
        });
        retirerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel modelex = (DefaultTableModel)  tableExercices.getModel();
                int selectedRow = tableExercices.getSelectedRow();
                if(selectedRow >=0)
                {
                    modelex.removeRow(selectedRow);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Veuillez selectionner l'exercice","Erreur",JOptionPane.ERROR_MESSAGE);
                }


            }
        });
        ajouterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Exercice selectedExercice = (Exercice) comboBoxExercice.getSelectedItem();
                DefaultTableModel modelex = (DefaultTableModel)  tableExercices.getModel();

                int rowCount = modelex.getRowCount();

                //RECHERCHER LES OBJETS PRESENTS DANS LA TABLE POUR ETRE SUR DE PAS AJOUTER LE MEME EXERCICE
                for (int row = 0; row < rowCount; row++) {
                    Object[] rowData = new Object[modelex.getColumnCount()];

                    for (int column = 0; column < modelex.getColumnCount(); column++) {
                        rowData[column] = modelex.getValueAt(row, column);
                    }
                    //Recuperer les infos pour en faire un objet pour pouvoir comparer
                    String code = (String) rowData[0];
                    String intitule = (String) rowData[1];
                    int duree = (int) rowData[2];

                    Exercice exercice = new Exercice(code, intitule, duree);
                    if(selectedExercice.equals(exercice)){
                        JOptionPane.showMessageDialog(null, "Exercice deja choisi","Erreur",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                Object[] rowData = {
                        selectedExercice.getCode(),
                        selectedExercice.getIntitule(),
                        selectedExercice.getDuree(),
                };
                dureetotal += selectedExercice.getDuree();
                if(dureetotal > 120){
                    JOptionPane.showMessageDialog(null, "Entrainement trop long","Erreur",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                modelex.addRow(rowData);
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
    public void RemplirComboboxExercice(){
        DefaultComboBoxModel<Exercice> comboBoxExer = new DefaultComboBoxModel<>();

        for(Exercice e : Club.getInstance().getExercices()){
            comboBoxExer.addElement(e);
        }
        comboBoxExercice.setModel(comboBoxExer);


    }

    public static void main(String[] args) {
        JDialogEntCollectif dialog = new JDialogEntCollectif();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
