package GUI;

import Entrainement.EntrainementSolo;
import Singleton.Club;
import personne.intervenant.Joueur;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class JDialogEntSolo extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textFieldDate;
    private JTextField textFieldDuree;
    private JTextField textFieldDescription;
    private JTable tableJoueur;
    private ClubFootball clubFootball;


    public JDialogEntSolo() {
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

    public JDialogEntSolo(Frame owner, String title, boolean modal) {
        super(owner, modal);
        setTitle(title);
        setContentPane(contentPane);
        pack();
        this.clubFootball = (ClubFootball) owner;

        String[] columnNamesJoueur = {"Nom","Prénom","Date De Naissance","Numero","Poste","Salaire"};
        Object [][] dataJou = {};
        DefaultTableModel modeljoueur = new DefaultTableModel(dataJou,columnNamesJoueur);
        tableJoueur.setModel(modeljoueur);
        RemplirTableJoueur();




        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
                String dateStr = textFieldDate.getText();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate dateEnt = LocalDate.parse(dateStr, formatter);
                String duree = textFieldDuree.getText();
                int dur = Integer.parseInt(duree);
                String desc = textFieldDescription.getText();
                int selectedRow = tableJoueur.getSelectedRow();
                if(selectedRow >=0)
                {
                    Joueur j = Club.getInstance().getJoueurs().get(selectedRow);
                    EntrainementSolo ent = new EntrainementSolo(dateEnt,dur,clubFootball.getEmployeLogg(),desc,j);
                    clubFootball.AjouterEntrainementSolo(ent);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Veuillez selectionner le joueur","Erreur",JOptionPane.ERROR_MESSAGE);
                }

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

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
    public void RemplirTableJoueur(){
        DefaultTableModel modelJoueur = (DefaultTableModel) tableJoueur.getModel();
        modelJoueur.setRowCount(0);
        for(Joueur j1 : Club.getInstance().getJoueurs()){
            Object[] rowData = {
                    j1.getNom(),
                    j1.getPrenom(),
                    j1.getDateNaissance(),
                    j1.getNumId(),
                    j1.getPoste(),
                    j1.getSalaire()
            };
            modelJoueur.addRow(rowData);
        }
    }

    public static void main(String[] args) {
        JDialogEntSolo dialog = new JDialogEntSolo();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
