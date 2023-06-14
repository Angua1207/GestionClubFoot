package GUI;

import Singleton.Club;
import personne.intervenant.Employé;
import personne.intervenant.Joueur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class JDialogConnexion extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textFieldLogin;
    private JPasswordField passwordFieldMDP;
    private ClubFootball clubFootball;

    public JDialogConnexion(Frame owner, String title, boolean modal) {
        super(owner, modal);
        setTitle(title);
        setContentPane(contentPane);
        pack();
        this.clubFootball = (ClubFootball) owner;
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
                String Login = getTextFieldLogin().getText();
                //String mdp = getPasswordFieldMDP().getText();
                char [] mdp = getPasswordFieldMDP().getPassword();
                System.out.println(mdp);
                Employé employeTrouve = null;
                for(Employé e1 : Club.getInstance().getEmployes()){
                    if(Login.equals(e1.getLogin()))
                    {
                        if(Arrays.equals(mdp,e1.getMotdepasse().toCharArray())){
                            employeTrouve = e1;
                            break;
                        }
                        else{
                            break;
                        }
                    }
                }
                if(employeTrouve != null){
                    JOptionPane.showMessageDialog(null,"Bienvenue Monsieur "+ employeTrouve.getNom()+" "+ employeTrouve.getPrenom());
                    clubFootball.setEmployeLogg(employeTrouve);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Login/MotDePasse incorrect","Erreur", JOptionPane.ERROR_MESSAGE);
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

    public JTextField getTextFieldLogin() {
        return textFieldLogin;
    }

    public JPasswordField getPasswordFieldMDP() {
        return passwordFieldMDP;
    }

    public JDialogConnexion() {
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

    private void onOK() {
        // add your code here
        //afficherDonneeTerminal();
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        JDialogConnexion dialog = new JDialogConnexion();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
    public void afficherDonneeTerminal(){
        String Login = getTextFieldLogin().getText();
        String mdp = getPasswordFieldMDP().getText();
        System.out.println("Login : "+ Login);
        System.out.println("Mot De Passe : " + mdp);
    }
}
