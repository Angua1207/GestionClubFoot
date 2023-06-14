package GUI;

import personne.intervenant.Employé;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class JDialogEntraineur extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textFieldNom;
    private JTextField textFieldPrenom;
    private JTextField textFieldDateNai;
    private JTextField textFieldLogin;
    private JRadioButton adminRadioButton;
    private JRadioButton entraineurTechRadioButton;
    private JRadioButton entraineurPhyRadioButton;
    private JPasswordField passwordField1;
    private ClubFootball clubFootball;


    public JDialogEntraineur() {
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

    public JDialogEntraineur(Frame owner, String title, boolean modal) {
        super(owner, modal);
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
                String login = textFieldLogin.getText();
                String mdp = passwordField1.getText();
                System.out.println(mdp);
                if(nom.isEmpty()|| prenom.isEmpty()||dateNaissanceStr.isEmpty()||login.isEmpty()||mdp.isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Veuillez Remplir tout les champs","Erreur",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    if(adminRadioButton.isSelected()){
                        Employé emp = new Employé(nom,prenom,datenaissance,1,login,Employé.ADMINISTRATIF);
                        emp.setMotdepasse(mdp);
                        System.out.println(emp.getMotdepasse());
                        clubFootball.AjouterEmploye(emp);
                    }
                    if(entraineurPhyRadioButton.isSelected()){
                        Employé emp = new Employé(nom,prenom,datenaissance,1,login,Employé.ENTRAINEURPHYS);
                        emp.setMotdepasse(mdp);
                        System.out.println(emp.getMotdepasse());
                        clubFootball.AjouterEmploye(emp);
                    }
                    if(entraineurTechRadioButton.isSelected()){
                        Employé emp = new Employé(nom,prenom,datenaissance,1,login,Employé.ENTRAINEURTECH);
                        emp.setMotdepasse(mdp);
                        System.out.println(emp.getMotdepasse());
                        clubFootball.AjouterEmploye(emp);
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
        JDialogEntraineur dialog = new JDialogEntraineur(null,"Ajouter Entraineur",true);
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
