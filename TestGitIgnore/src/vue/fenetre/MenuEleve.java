package vue.fenetre;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import modele.base.dao.Personne;

import org.apache.log4j.LogManager;

import controleur.connexion.Onlinote;


public class MenuEleve {
    
    /**
     * Log4j logger
     */
    static org.apache.log4j.Logger log4j =  LogManager.getLogger(ConnexionGUI.class.getName());
	
	private JPanel menu = null;
	private JLabel lblAccueil = null;
	private JLabel lblNotes = null;
	private JLabel lblEmploiDuTemps = null;
	private JLabel lblMessagerie = null;
	private Personne eleve = null;
	
	public MenuEleve (String ongletEC, Personne personne) {
	    
	    eleve = personne;
	    
	    ImageIcon tabImg[] = getImg();
	    

		
		menu = new JPanel();
		menu.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		menu.setSize(new Dimension(153, 267));
		menu.setLayout(null);
		
	    addAccueil(tabImg[0]);
        addNotes(tabImg[1]);
        addMsg(tabImg[2]);
        addEmploiDuTemps(tabImg[3]);
        addDeconnexion(tabImg[4]);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(15, 58, 125, 63);
		menu.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel1 = new JPanel();
		panel.add(panel1);
		panel1.setLayout(new BorderLayout(0, 0));
		panel1.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		
		
		JLabel lblNomEleve = new JLabel(personne.getNom() + " " + personne.getPrenom());
		lblNomEleve.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.add(lblNomEleve);
		
		
		JLabel lblEleve = new JLabel();
		lblEleve.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.add(lblEleve, BorderLayout.NORTH);
		
		lblEleve.setFont(new Font("Times new roman", Font.PLAIN, 14));
		lblEleve.setText("Elève :");

	}
	
	public JPanel getMenu() {
		return menu;
	}
	

	
	private ImageIcon[] getImg() {
	    
	       java.net.URL imgURLAccueil, imgURLNotes, imgURLSchedule, imgURLOff, imgURLMsg;
	        ImageIcon imgAccueil = null;
	        ImageIcon imgNotes = null;
	        ImageIcon imgSchedule = null;
	        ImageIcon imgOff = null;
	        ImageIcon imgMsg = null;
	        try {
	            imgURLAccueil = new java.net.URL("file:img/homeBlack.png");
	            imgAccueil = new ImageIcon(new ImageIcon(imgURLAccueil).getImage().getScaledInstance(24, 24, Image.SCALE_DEFAULT));
	            imgURLNotes = new java.net.URL("file:img/notesBlack.png");
	            imgNotes = new ImageIcon(new ImageIcon(imgURLNotes).getImage().getScaledInstance(24, 24, Image.SCALE_DEFAULT));
	            imgURLSchedule = new java.net.URL("file:img/clockBlack.png");
	            imgSchedule = new ImageIcon(new ImageIcon(imgURLSchedule).getImage().getScaledInstance(24, 24, Image.SCALE_DEFAULT));
	            imgURLOff = new java.net.URL("file:img/offBlack.png");
	            imgOff = new ImageIcon(new ImageIcon(imgURLOff).getImage().getScaledInstance(24, 24, Image.SCALE_DEFAULT));
	            imgURLMsg = new java.net.URL("file:img/msgBlack.png");
	            imgMsg = new ImageIcon(new ImageIcon(imgURLMsg).getImage().getScaledInstance(24, 24, Image.SCALE_DEFAULT));
	        } catch (MalformedURLException e) {
	            
	            log4j.info(e.getMessage(), e);
	        }
	        
	        ImageIcon tabImg[] ={imgAccueil, imgNotes, imgMsg, imgSchedule, imgOff};
            return tabImg;

	}
	
	private void addDeconnexion (ImageIcon tabImg) {
    	JLabel lblDeconnexion = new JLabel();
        JLabel lblIconDeconnexion = new JLabel(tabImg);
        lblDeconnexion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblIconDeconnexion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblIconDeconnexion.setBounds(5, 214, 29, 53);
        lblDeconnexion.setBounds(45, 230, 96, 17);
        lblDeconnexion.setFont(new Font("Times new roman", Font.PLAIN, 14));
        lblDeconnexion.setText("Deconnexion");
        lblDeconnexion.addMouseListener(new MouseAdapter() {  
            
            public void mouseClicked(MouseEvent e) {  
                
                 FenetreEleve.maFenetreEleve.dispose();
                 Onlinote.relancer();
    
            }  
        });
        menu.add(lblIconDeconnexion);
        menu.add(lblDeconnexion);
	}
	private void addAccueil (ImageIcon tabImg) {
        JLabel lblIconAccueil = new JLabel(tabImg);
        lblAccueil = new JLabel();
        lblIconAccueil.setBounds(5, 4, 29, 53);
        lblAccueil.setBounds(44, 4, 50, 53);
        lblAccueil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblIconAccueil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblAccueil.setFont(new Font("Times new roman", Font.BOLD, 14));
        lblAccueil.setText("Accueil");
        lblAccueil.addMouseListener(new MouseAdapter() {  
            public void mouseClicked(MouseEvent e) {  
                 switchOnglet("Accueil", eleve);
            }  
        });
        lblIconAccueil.addMouseListener(new MouseAdapter() {  
            public void mouseClicked(MouseEvent e) {  
                switchOnglet("Accueil", eleve);
           }  
        });

        menu.add(lblIconAccueil);
        menu.add(lblAccueil);
	}
	
	
	private void addNotes(ImageIcon tabImg) {
	    lblNotes = new JLabel();
        JLabel lblIconNotes = new JLabel(tabImg);
        lblIconNotes.setBounds(5, 119, 29, 53);
        lblNotes.setBounds(45, 136, 50, 17);
        lblNotes.setFont(new Font("Times new roman", Font.PLAIN, 14));
        lblNotes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblIconNotes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblNotes.setText("Notes");
        
        lblNotes.addMouseListener(new MouseAdapter()  {  
            public void mouseClicked(MouseEvent e) {  
                 switchOnglet("Notes", eleve);
            }  
        });
        lblIconNotes.addMouseListener(new MouseAdapter()  {  
            public void mouseClicked(MouseEvent e) {  
                switchOnglet("Notes", eleve);
           }  
        });
        menu.add(lblIconNotes);
        menu.add(lblNotes);
	}
	
	private void addEmploiDuTemps(ImageIcon tabImg) { 
        lblEmploiDuTemps = new JLabel();
        JLabel lblIconEmploiDuTemps = new JLabel(tabImg);
        lblEmploiDuTemps.addMouseListener(new MouseAdapter() {  
            public void mouseClicked(MouseEvent e) {  
                 switchOnglet("Emploi du temps", eleve);
            }  
        });
        lblIconEmploiDuTemps.addMouseListener(new MouseAdapter() {  
            public void mouseClicked(MouseEvent e) {  
                switchOnglet("Emploi du temps", eleve);
           }  
        });
        lblIconEmploiDuTemps.setBounds(5, 179, 29, 53);
        lblEmploiDuTemps.setBounds(44, 198, 110, 17);
        lblEmploiDuTemps.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblIconEmploiDuTemps.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblEmploiDuTemps.setText("Emploi du temps");
        lblEmploiDuTemps.setFont(new Font("Times new roman", Font.PLAIN, 14));
        menu.add(lblIconEmploiDuTemps);
        menu.add(lblEmploiDuTemps);
	}
	
	private void addMsg(ImageIcon tabImg) { 
    	lblMessagerie = new JLabel();
        JLabel lblIconMessagerie = new JLabel(tabImg);
        lblIconMessagerie.setBounds(5, 150, 29, 53);
        lblMessagerie.setBounds(44, 165, 96, 17);
        lblMessagerie.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblIconMessagerie.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblMessagerie.setText("Messagerie");
        lblMessagerie.setFont(new Font("Times new roman", Font.PLAIN, 14));
        lblMessagerie.addMouseListener(new MouseAdapter() {  
            public void mouseClicked(MouseEvent e) {  
                 switchOnglet("Messagerie", eleve);
            }  
        });
        menu.add(lblIconMessagerie);
        menu.add(lblMessagerie);
	}
	
   private void switchOnglet(String onglet, Personne personne) {
       viderGras();
       FenetreEleve.changeMenu();
        
        switch(onglet) {
            case "Accueil" :
                
                remplirFenetre("Bienvenue sur l'application Onlinote","");
                FenetreEleve.panelCenter = new JPanel(new BorderLayout());
                
                lblAccueil.setFont(new Font("Times new roman", Font.BOLD, 14));
                FenetreEleve.maFenetreEleve.getContentPane().validate();
                
               break;
            case "Notes" :
                remplirFenetre("Onlinote - Notes","");
                FenetreEleve.panelCenter = new JPanel(new BorderLayout());
                
                JPanel mesNotes = new Notes(personne.getIdPersonne()).getNotes();
                mesNotes.setBorder(BorderFactory.createEmptyBorder(0,30,30,30));
                FenetreEleve.panelCenter.add(mesNotes, BorderLayout.CENTER);
                FenetreEleve.maFenetreEleve.getContentPane().add(FenetreEleve.panelCenter, BorderLayout.CENTER);
                lblNotes.setFont(new Font("Times new roman", Font.BOLD, 14));
                FenetreEleve.maFenetreEleve.validate();
                
                
                break;
            case "Emploi du temps" :
                
                remplirFenetre("Onlinote - Emploi du temps","");
                FenetreEleve.panelCenter = new JPanel(new BorderLayout());
                
                JPanel monEDT = new EmploiDuTemps(personne.getIdPersonne()).getEDT();
                monEDT.setBorder(BorderFactory.createEmptyBorder(0,30,30,30));
                FenetreEleve.panelCenter.add(monEDT);
  
                FenetreEleve.maFenetreEleve.getContentPane().add(FenetreEleve.panelCenter, BorderLayout.CENTER);
                lblEmploiDuTemps.setFont(new Font("Times new roman", Font.BOLD, 14));
                FenetreEleve.maFenetreEleve.validate();
                break;
                
            case "Messagerie" :
                remplirFenetre("Onlinote - Messagerie", "");
                FenetreEleve.panelCenter = new JPanel(new BorderLayout());
                
                
                JPanel maMessagerie = new Messagerie(personne).getMess();
                maMessagerie.setBorder(BorderFactory.createEmptyBorder(0,30,30,30));
                FenetreEleve.panelCenter.add(maMessagerie);
                
                lblMessagerie.setFont(new Font("Times new roman", Font.BOLD, 14));
                FenetreEleve.maFenetreEleve.getContentPane().add(FenetreEleve.panelCenter, BorderLayout.CENTER);
                FenetreEleve.maFenetreEleve.validate();
                break;
                
            default : 
                
                break;
        }
    }
   
   private void viderGras () {
       lblAccueil.setFont(new Font("Times new roman", Font.PLAIN, 14));
       lblNotes.setFont(new Font("Times new roman", Font.PLAIN, 14));
       lblEmploiDuTemps.setFont(new Font("Times new roman", Font.PLAIN, 14));
       lblMessagerie.setFont(new Font("Times new roman", Font.PLAIN, 14));
       
   }
   
   private void remplirFenetre(String titre, String desc) {
       FenetreEleve.panelTop = new JPanel(new BorderLayout());
       JPanel panelTopGauche = new JPanel(new BorderLayout());
       JPanel panelTopCentre = new JPanel(new BorderLayout());
       
       JLabel lblApplicationOnlinote = new JLabel(titre);
       lblApplicationOnlinote.setVerticalAlignment(SwingConstants.TOP);
       lblApplicationOnlinote.setFont(new Font("Times new roman", Font.PLAIN, 32));
       lblApplicationOnlinote.setHorizontalAlignment(SwingConstants.CENTER);
       
       
       JLabel lblDetails1 = new JLabel(desc);
       lblDetails1.setHorizontalAlignment(SwingConstants.CENTER);
       lblDetails1.setFont(new Font("Times new roman", Font.PLAIN, 12));
       JLabel lblVide = new JLabel(" ");
       lblVide.setHorizontalAlignment(SwingConstants.CENTER);
       
       
       java.net.URL imgURLAccueil = null;
       try {
           imgURLAccueil = new java.net.URL("file:img/gard.png");
       } catch (MalformedURLException e) {
           // TODO Auto-generated catch block
           log4j.error("image existe pas");

       }
       ImageIcon imgAccueil = new ImageIcon(new ImageIcon(imgURLAccueil).getImage().getScaledInstance(100, 50, Image.SCALE_DEFAULT));
       
       JLabel lblImgAccueil= new JLabel(imgAccueil);
       lblImgAccueil.setBounds(0,0,100,100);
       panelTopGauche.add(lblImgAccueil, BorderLayout.CENTER);
       
       panelTopGauche.setBounds(0,0,100,100);
       
       panelTopCentre.add(lblApplicationOnlinote, BorderLayout.NORTH);
       panelTopCentre.add(lblVide, BorderLayout.CENTER);
       panelTopCentre.add(lblDetails1, BorderLayout.SOUTH);
       
       FenetreEleve.panelTop.add(panelTopGauche);
       FenetreEleve.panelTop.add(panelTopCentre);
       
       
       FenetreEleve.maFenetreEleve.getContentPane().add(FenetreEleve.panelTop, BorderLayout.NORTH);
   }

}
