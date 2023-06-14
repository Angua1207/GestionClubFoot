package GUI;

import Entrainement.Entrainement;
import Singleton.Club;
import personne.intervenant.Employé;
import personne.intervenant.Joueur;
import Entrainement.*;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClubFootball extends JFrame
{
    private JPanel MainPanel;
    private JTable tableJoueurs;
    private JPanel JPanelConnexion;
    private JButton loginButton;
    private JButton ajouterEntraineurButton;
    private JButton ajouterJoueurButton;
    private JButton nouvelEntrainementButton;
    private JButton logoutButton;
    private JButton licencierEmployéButton;
    private JButton licencierJoueurButton;
    private JPanel JPanelEntCollectif;
    private JPanel JPanelEntSolo;
    private JPanel JPanelIntervenant;
    private JPanel JPanelLicensiement;
    private JTable tableEmployés;
    private JTable tableEntSolo;
    private JTable tableEntColl;
    private static Employé employeLogg = null;

    public ClubFootball()
    {
        //setSize(1000,1000);
        setTitle("Gestion Club Foot JAVA");
        setContentPane(MainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        // Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

        String[] columnNamesJoueur = {"Nom","Prénom","Date De Naissance","Numero","Poste","Salaire"};
        Object [][] dataJou = {};
        DefaultTableModel modeljoueur = new DefaultTableModel(dataJou,columnNamesJoueur);
        tableJoueurs.setModel(modeljoueur);
        RemplirTableJoueur();

        String[] columnNamesEnt = {"Nom","Prénom","Date De Naissance","Numero","Fonction"};
        Object [][] dataEnt = {};
        DefaultTableModel modelentraineur = new DefaultTableModel(dataEnt,columnNamesEnt);
        tableEmployés.setModel(modelentraineur);
        RemplirTableEmploye();

        String[] columnNamesEntSolo = {"Date","Duree","Entraineur","Description"};
        Object [][] dataEntsolo = {};
        DefaultTableModel modelentsolo = new DefaultTableModel(dataEntsolo,columnNamesEntSolo);
        tableEntSolo.setModel(modelentsolo);
        RemplirTableEntSolo();

        String[] columnNamesEntColl = {"Date","Duree","Entraineur","Joueur","Description"};
        Object [][] dataEntColl = {};
        DefaultTableModel modelentcoll = new DefaultTableModel(dataEntColl,columnNamesEntColl);
        tableEntColl.setModel(modelentcoll);
        RemplirTableEntColl();



        nouvelEntrainementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(employeLogg != null &&  (employeLogg.getFonction().equals(Employé.ENTRAINEURPHYS)||employeLogg.getFonction().equals(Employé.ENTRAINEURTECH)) ){
                    JDialogEntrainement dialog = new JDialogEntrainement(ClubFootball.this,"Entrainement",true);
                    dialog.setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Un Entraineur doit etre connecter", "Entrainement", JOptionPane.ERROR_MESSAGE);
                }


            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(employeLogg == null){
                    JDialogConnexion dialog = new JDialogConnexion(ClubFootball.this, "Login", true);
                    dialog.setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Deja Connecté","Login", JOptionPane.ERROR_MESSAGE);
                }
                if(employeLogg!= null){
                    setTitle("Gestion Club Foot "+ "Monsieur " + employeLogg.getNom() + " "+ employeLogg.getPrenom() );
                }
            }
        });
        ajouterEntraineurButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(employeLogg == null || employeLogg.getFonction()!= Employé.ADMINISTRATIF)
                {
                    JOptionPane.showMessageDialog(null,"Pas possible si ce n'est pas un Admin","Ajouter Entraineur",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                JDialogEntraineur dialog = new JDialogEntraineur(ClubFootball.this,"Ajouter Entraineur", true);
                dialog.setVisible(true);
            }
        });
        ajouterJoueurButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(employeLogg == null || employeLogg.getFonction()!= Employé.ADMINISTRATIF)
                {
                    JOptionPane.showMessageDialog(null,"Pas possible si ce n'est pas un Admin","Ajouter Entraineur",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                JDialogJoueur dialog = new JDialogJoueur(ClubFootball.this,"Ajouter Joueur", true);
                dialog.setVisible(true);

            }
        });
        licencierEmployéButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(employeLogg==null || employeLogg.getFonction() != Employé.ADMINISTRATIF){
                    JOptionPane.showMessageDialog(null,"Pas possible si ce n'est pas un Admin","Ajouter Entraineur",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int selectedRow = tableEmployés.getSelectedRow();
                if(selectedRow >=0)
                {
                    Employé emp = Club.getInstance().getEmployes().get(selectedRow);
                    Club.getInstance().removeEmploye(emp);
                    RemplirTableEmploye();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Veuillez selectionner l'entraineur","Erreur",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        licencierJoueurButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(employeLogg==null || employeLogg.getFonction() != Employé.ADMINISTRATIF){
                    JOptionPane.showMessageDialog(null,"Pas possible si ce n'est pas un Admin","Ajouter Entraineur",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int selectedRow = tableJoueurs.getSelectedRow();
                if(selectedRow >=0)
                {
                    Joueur j = Club.getInstance().getJoueurs().get(selectedRow);
                    Club.getInstance().removeJoueur(j);
                    RemplirTableJoueur();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Veuillez selectionner le joueur","Erreur",JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(employeLogg != null){
                    JOptionPane.showMessageDialog(null,"Au revoir Monsieur "+ employeLogg.getNom()+" "+ employeLogg.getPrenom());
                    employeLogg = null;
                    setTitle("Gestion Club Foot JAVA");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Pas encore connecté","Logout", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    public void AjouterJoueur(Joueur j1)
    {
        int num = 0;
        for(Joueur j2 : Club.getInstance().getJoueurs()){
            if(j1.getNumId() == j2.getNumId()){
                num = 1;
            }
        }
        if (num != 0){
            JOptionPane.showMessageDialog(null,"Numero deja attribuer","Erreur",JOptionPane.ERROR_MESSAGE);
            return;
        }
        Club.getInstance().addJoueur(j1);
        RemplirTableJoueur();
    }
    public void RemplirTableJoueur(){
        DefaultTableModel modelJoueur = (DefaultTableModel) tableJoueurs.getModel();
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
    public void AjouterEmploye(Employé e){
        Club.getInstance().addEmploye(e);
        RemplirTableEmploye();
    }
    public void RemplirTableEmploye(){
        DefaultTableModel modelentraineur = (DefaultTableModel) tableEmployés.getModel();
        modelentraineur.setRowCount(0);
        for(Employé e : Club.getInstance().getEmployes()){
            Object[] rowData = {
                    e.getNom(),
                    e.getPrenom(),
                    e.getDateNaissance(),
                    e.getNumId(),
                    e.getFonction(),
            };
            modelentraineur.addRow(rowData);
        }

    }
    public void AjouterEntrainementSolo (EntrainementSolo e){
        Club.getInstance().addEntrainementSolo(e);
        RemplirTableEntSolo();
    }
    public void RemplirTableEntSolo(){
        DefaultTableModel modelentrainementsolo = (DefaultTableModel) tableEntSolo.getModel();
        for(EntrainementSolo e : Club.getInstance().getEntrainementSolos()){
            Object[] rowData = {
                    e.getDate(),
                    e.getDuree(),
                    e.getEntraineur().getNom(),
                    e.getJoueur().getNom(),
                    e.getDescription(),
            };
            modelentrainementsolo.addRow(rowData);
        }
    }
    public void AjouterEntrainementColl (EntrainementCollectif e){
        Club.getInstance().addEntrainementCollectif(e);
        RemplirTableEntColl();
    }
    public void RemplirTableEntColl(){
        DefaultTableModel modelentrainementcoll = (DefaultTableModel) tableEntColl.getModel();
        for(EntrainementCollectif e : Club.getInstance().getEntrainementCollectifs()){
            Object[] rowData = {
                    e.getDate(),
                    e.getDuree(),
                    e.getEntraineur().getNom(),
                    e.getDescription(),
            };
            modelentrainementcoll.addRow(rowData);
        }
    }

    public static Employé getEmployeLogg() {
        return employeLogg;
    }
    public static void setEmployeLogg(Employé e){
        employeLogg = e;
    }

    public static void main(String[] args)
    {
        ClubFootball clubfoot = new ClubFootball();
        clubfoot.setLocationRelativeTo(null);
        clubfoot.pack();
        clubfoot.setVisible(true);
       // clubfoot.setSize(500,500);

    }


}
