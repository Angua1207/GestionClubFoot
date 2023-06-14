package GUI;

import personne.intervenant.Joueur;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import Singleton.Club;

public class JDialogJoueur extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textFieldNom;
    private JTextField textFieldPrenom;
    private JTextField textFieldDateNai;
    private JTextField textFieldNumero;
    private JTextField textFieldSalaire;
    private JRadioButton gardienRadioButton;
    private JRadioButton millieuRadioButton;
    private JRadioButton attaquantRadioButton;
    private JRadioButton defenseurRadioButton;
    private ButtonGroup buttonGroupPoste;
    private ClubFootball clubFootball;


    public JDialogJoueur() {
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

    public JDialogJoueur(Frame owner, String title, boolean modal) {
        super(owner,modal);
        setTitle(title);
        setContentPane(contentPane);
        pack();
        this.clubFootball = (ClubFootball) owner;



        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            String nom = textFieldNom.getText();
            String prenom = textFieldPrenom.getText();
            String dateNaissanceStr = textFieldDateNai.getText();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate datenaissance = LocalDate.parse(dateNaissanceStr, formatter);
            String salaire = textFieldSalaire.getText();
            String numero = textFieldNumero.getText();
            float sal = Float.parseFloat(salaire);
            int num = Integer.parseInt(numero);

            if(nom.isEmpty()|| prenom.isEmpty()||dateNaissanceStr.isEmpty()||salaire.isEmpty()||numero.isEmpty())
            {
                JOptionPane.showMessageDialog(null,"Veuillez Remplir tout les champs","Erreur",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                if(attaquantRadioButton.isSelected()){
                    Joueur joueur = new Joueur(nom,prenom,datenaissance,num, Joueur.Poste.ATTAQUANT,sal);
                    clubFootball.AjouterJoueur(joueur);
                }
                if(millieuRadioButton.isSelected()){
                    Joueur joueur = new Joueur(nom,prenom,datenaissance,num, Joueur.Poste.MILIEU,sal);
                    clubFootball.AjouterJoueur(joueur);
                }
                if(defenseurRadioButton.isSelected()){
                    Joueur joueur = new Joueur(nom,prenom,datenaissance,num, Joueur.Poste.DEFENSEUR,sal);
                    clubFootball.AjouterJoueur(joueur);
                }
                if(gardienRadioButton.isSelected()){
                    Joueur joueur = new Joueur(nom,prenom,datenaissance,num, Joueur.Poste.GARDIEN,sal);
                    clubFootball.AjouterJoueur(joueur);
                }
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

    public static void main(String[] args) {
        JDialogJoueur dialog = new JDialogJoueur(null,"Ajouter Joueur",true);
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
