package vue.fenetre;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modele.vue.dao.DAOVueClasse;
import modele.vue.dao.DAOVueCours;
import modele.vue.dao.DAOVueMessage;

import org.apache.log4j.LogManager;

import vue.tools.ModelTableEdt;
import controleur.administration.GestionClasse;
import controleur.cours.GestionCours;

public class CadreGestionEdt {
    
    private static JPanel panelCadre = null;
    private static Calendar c = null;
    private static String dt = null;
    private static SimpleDateFormat sdf = null;
    private static int ideleve = 0;
    int row = 0;
    int column = 0;
    static String nomClasse = null;
 
    private static JPanel eDT = new JPanel(new BorderLayout());
    public CadreGestionEdt() {
            
        
        panelCadre = new JPanel(new BorderLayout());
        JPanel panelTop = new JPanel();
        
        
        
        
        panelCadre.add(panelTop, BorderLayout.NORTH);        
        GridBagLayout gblpanelTop = new GridBagLayout();
        gblpanelTop.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 30};
        gblpanelTop.rowHeights = new int[]{0, 0, 30};
        gblpanelTop.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
        gblpanelTop.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        panelTop.setLayout(gblpanelTop);
        
        JLabel lblNewLabel = new JLabel("6ieme");
        GridBagConstraints gbclblNewLabel = new GridBagConstraints();
        gbclblNewLabel.insets = new Insets(0, 0, 0, 5);
        gbclblNewLabel.gridx = 1;
        gbclblNewLabel.gridy = 1;
        panelTop.add(lblNewLabel, gbclblNewLabel);
        
        JComboBox<String> comboBox = new JComboBox<String>();
        GridBagConstraints gbccomboBox = new GridBagConstraints();
        gbccomboBox.insets = new Insets(0, 0, 0, 5);
        gbccomboBox.fill = GridBagConstraints.HORIZONTAL;
        gbccomboBox.gridx = 2;
        gbccomboBox.gridy = 1;
        panelTop.add(comboBox, gbccomboBox);
        
        JLabel lblieme = new JLabel("5ieme");
        GridBagConstraints gbclblieme = new GridBagConstraints();
        gbclblieme.insets = new Insets(0, 0, 0, 5);
        gbclblieme.anchor = GridBagConstraints.EAST;
        gbclblieme.gridx = 3;
        gbclblieme.gridy = 1;
        panelTop.add(lblieme, gbclblieme);
        
        JComboBox<String> comboBox1 = new JComboBox<String>();
        GridBagConstraints gbccomboBox1 = new GridBagConstraints();
        gbccomboBox1.insets = new Insets(0, 0, 0, 5);
        gbccomboBox1.fill = GridBagConstraints.HORIZONTAL;
        gbccomboBox1.gridx = 4;
        gbccomboBox1.gridy = 1;
        panelTop.add(comboBox1, gbccomboBox1);
        
        JLabel lblieme1 = new JLabel("4ieme");
        GridBagConstraints gbclblieme1 = new GridBagConstraints();
        gbclblieme1.insets = new Insets(0, 0, 0, 5);
        gbclblieme1.anchor = GridBagConstraints.EAST;
        gbclblieme1.gridx = 5;
        gbclblieme1.gridy = 1;
        panelTop.add(lblieme1, gbclblieme1);
        
        final JComboBox<String> comboBox2 = new JComboBox<String>();
        GridBagConstraints gbccomboBox2 = new GridBagConstraints();
        gbccomboBox2.insets = new Insets(0, 0, 0, 5);
        gbccomboBox2.fill = GridBagConstraints.HORIZONTAL;
        gbccomboBox2.gridx = 6;
        gbccomboBox2.gridy = 1;
        panelTop.add(comboBox2, gbccomboBox2);
        
        JLabel lblNewLabel1 = new JLabel("3ieme");
        GridBagConstraints gbclblNewLabel1 = new GridBagConstraints();
        gbclblNewLabel1.insets = new Insets(0, 0, 0, 5);
        gbclblNewLabel1.anchor = GridBagConstraints.EAST;
        gbclblNewLabel1.gridx = 7;
        gbclblNewLabel1.gridy = 1;
        panelTop.add(lblNewLabel1, gbclblNewLabel1);
        
        final JComboBox<String> comboBox3 = new JComboBox<String>();
        GridBagConstraints gbccomboBox3 = new GridBagConstraints();
        gbccomboBox3.fill = GridBagConstraints.HORIZONTAL;
        gbccomboBox3.gridx = 8;
        gbccomboBox3.gridy = 1;
        panelTop.add(comboBox3, gbccomboBox3);
        
        GestionClasse gestionnaireClasse = new GestionClasse();
        
        List<DAOVueClasse> sixieme = gestionnaireClasse.getClasses(6);
        List<DAOVueClasse> cinquieme = gestionnaireClasse.getClasses(5);
        List<DAOVueClasse> quatrieme = gestionnaireClasse.getClasses(4);
        List<DAOVueClasse> troisieme = gestionnaireClasse.getClasses(3);
        
        for (int i = 0; i<sixieme.size(); ++i) {
            comboBox.addItem(sixieme.get(i).getNomClasse());
        }
        for (int i = 0; i<cinquieme.size(); ++i) {
            comboBox1.addItem(cinquieme.get(i).getNomClasse());
        }
        for (int i = 0; i<quatrieme.size(); ++i) {
            comboBox2.addItem(quatrieme.get(i).getNomClasse());
        }
        for (int i = 0; i<troisieme.size(); ++i) {
            comboBox3.addItem(troisieme.get(i).getNomClasse());
        }
        
        comboBox3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (comboBox3.getSelectedItem() != null) {
                    
                    CreerEdt(comboBox3.getSelectedItem().toString());
                    
                }
            }
        });
        comboBox2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (comboBox2.getSelectedItem() != null) {
                    
                    CreerEdt(comboBox2.getSelectedItem().toString());
                    
                }
            }
        });
        
        
        
    }
    
    
    
    
    
    public JPanel getCadreGestionEdT() {
        return panelCadre;
    }
    
    public static void CreerEdt(String nomClass) {
        if (eDT != null) {
            eDT.removeAll();
        }
        nomClasse = nomClass;
        GestionClasse gestionnaireClasse = new GestionClasse();
        ideleve = gestionnaireClasse.getIdEleveFromClass(nomClass);
        genereEmploiDuTemps();
        panelCadre.add(eDT, BorderLayout.CENTER);
        panelCadre.repaint();
        panelCadre.revalidate();
    }
    
    public static void genereEmploiDuTemps() {
        
        /**
         * Log4j logger
         */
        
        
        
        org.apache.log4j.Logger log4j =  LogManager.getLogger(ConnexionGUI.class.getName());
               
        
        List<String> heures = new ArrayList<String>();
        heures.add("8h00 - 9h00");
        heures.add("9h00 - 10h00");
        heures.add("10h00 - 11h00");
        heures.add("11h00 - 12h00");
        heures.add("12h00 - 13h00");
        heures.add("13h00 - 14h00");
        heures.add("14h00 - 15h00");
        heures.add("15h00 - 16h00");
        heures.add("16h00 - 17h00");
        heures.add("17h00 - 18h00");
        
        
        

        c = Calendar.getInstance();
        dt = c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.DATE);
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            c.setTime(sdf.parse(dt));
            dt = sdf.format(c.getTime());
        } catch (ParseException e) {
            log4j.info(e.getMessage());
        }
        
        
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        
        while (dayOfWeek != 2) {
            c.add(Calendar.DATE, -1);
            dt = sdf.format(c.getTime());
            dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        }
        
        


        
        
        ModelTableEdt model = new ModelTableEdt();
        final JTable table = new JTable(model);
        table.setRowHeight(100);
        table.setCellSelectionEnabled(true);
        ListSelectionModel cellSelectionModel = table.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        
        JScrollPane panelScrollTable = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        GestionCours gestionnaireCours = new GestionCours();
        
        
        
        
        final List<String> dateCours = new ArrayList<String>();
        
        for (int i = 0; i < 5;++i) {
            dateCours.add(dt);
            c.add(Calendar.DATE, 1);
            dt = sdf.format(c.getTime());
        }
        
        int h = 8;
        
        JPanel panelTop = new JPanel(new BorderLayout());
        
        JButton droite = new JButton(">");
        droite.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                
                c.add(Calendar.DATE, 2);
                dt = sdf.format(c.getTime());
                
                modifEdt();
                
                
            }
        });
        JButton gauche = new JButton("<");
        gauche.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                
                c.add(Calendar.DATE, -12);
                dt = sdf.format(c.getTime());
                
                modifEdt();
                
                
            }
        });
        
        final List<DAOVueCours> coursLundi = new ArrayList<DAOVueCours>();
        final List<DAOVueCours> coursMardi = new ArrayList<DAOVueCours>();
        final List<DAOVueCours> coursMercredi = new ArrayList<DAOVueCours>();
        final List<DAOVueCours> coursJeudi = new ArrayList<DAOVueCours>();
        final List<DAOVueCours> coursVendredi = new ArrayList<DAOVueCours>();
        
        JLabel centre = new JLabel("Semaine du : " + dateCours.get(0) + " au : " + dateCours.get(4));
        centre.setHorizontalAlignment(SwingConstants.CENTER);
        
        panelTop.add(droite, BorderLayout.EAST);
        panelTop.add(gauche, BorderLayout.WEST);
        panelTop.add(centre, BorderLayout.CENTER);
        
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table.rowAtPoint(evt.getPoint());
                int col = table.columnAtPoint(evt.getPoint());
                String heure = null;
                DAOVueCours coursSelected = null;
                if (row >= 0 && col > 0) {
                    
                    
                    switch(row) {
                    case 0 :
                        heure = "08:00:00";
                        break;
                    case 1 :
                        heure = "09:00:00";
                        break;
                    case 2 :
                        heure = "10:00:00";
                        break;
                    case 3 :
                        heure = "11:00:00";
                        break;
                    case 4 :
                        heure = "12:00:00";
                        break;
                    case 5 :
                        heure = "13:00:00";
                        break;
                    case 6 :
                        heure = "14:00:00";
                        break;
                    case 7 :
                        heure = "15:00:00";
                        break;
                    case 8 :
                        heure = "16:00:00";
                        break;
                    case 9 :
                        heure = "17:00:00";
                        break;
                    }
                    
                    
                    switch (col) {
                    case 1 :
                        coursSelected = coursLundi.get(row);
                        if (coursSelected.getMatiere() == null) {
                            NouveauCours.creerNouveauCours(dateCours.get(col-1) + " " + heure, nomClasse);
                        }
                        
                        
                        break;
                    case 2 :
                        coursSelected = coursMardi.get(row);
                        if (coursSelected.getMatiere() == null) {
                            NouveauCours.creerNouveauCours(dateCours.get(col-1) + " " + heure, nomClasse);
                        }
                        break;
                    case 3 :
                        coursSelected = coursMercredi.get(row);
                        if (coursSelected.getMatiere() == null) {
                            NouveauCours.creerNouveauCours(dateCours.get(col-1) + " " + heure, nomClasse);
                        }
                        break;
                    case 4 :
                        coursSelected = coursJeudi.get(row);
                        if (coursSelected.getMatiere() == null) {
                            NouveauCours.creerNouveauCours(dateCours.get(col-1) + " " + heure, nomClasse);
                        }
                        break;
                    case 5 :
                        coursSelected = coursVendredi.get(row);
                        if (coursSelected.getMatiere() == null) {
                            NouveauCours.creerNouveauCours(dateCours.get(col-1) + " " + heure, nomClasse);
                        }
                        break;
                        
                    
                    }
                }
            }
        });
        
        for (int i=0; i < 10 ;++i) {
            
            if (h== 8 || h == 9) {
                coursLundi.add(gestionnaireCours.getCours(ideleve, dateCours.get(0) + " 0" + h + ":00:02"));
                coursMardi.add(gestionnaireCours.getCours(ideleve, dateCours.get(1)  + " 0" + h + ":00:02"));
                coursMercredi.add(gestionnaireCours.getCours(ideleve, dateCours.get(2) + " 0" + h + ":00:02"));
                coursJeudi.add(gestionnaireCours.getCours(ideleve, dateCours.get(3) + " 0" + h + ":00:02"));
                coursVendredi.add(gestionnaireCours.getCours(ideleve, dateCours.get(4) + " 0" + h + ":00:02"));
            } else {
                coursLundi.add(gestionnaireCours.getCours(ideleve, dateCours.get(0) +" " + h + ":00:02"));
                coursMardi.add(gestionnaireCours.getCours(ideleve, dateCours.get(1) +" " + h + ":00:02"));
                coursMercredi.add(gestionnaireCours.getCours(ideleve, dateCours.get(2) +" " + h + ":00:02"));
                coursJeudi.add(gestionnaireCours.getCours(ideleve, dateCours.get(3) +" "+ h + ":00:02"));
                coursVendredi.add(gestionnaireCours.getCours(ideleve, dateCours.get(4) +" " + h + ":00:02"));
            }

            h = h+1;
        }
        
        model.updateTableData(heures, coursLundi, coursMardi, coursMercredi, coursJeudi, coursVendredi);
        
        eDT.add(panelScrollTable, BorderLayout.CENTER);
        eDT.add(panelTop, BorderLayout.NORTH);

    }
    
    public static void modifEdt() {
        
        eDT.removeAll();
        
        List<String> heures = new ArrayList<String>();
        heures.add("8h00 - 9h00");
        heures.add("9h00 - 10h00");
        heures.add("10h00 - 11h00");
        heures.add("11h00 - 12h00");
        heures.add("12h00 - 13h00");
        heures.add("13h00 - 14h00");
        heures.add("14h00 - 15h00");
        heures.add("15h00 - 16h00");
        heures.add("16h00 - 17h00");
        heures.add("17h00 - 18h00");
               
        
        
        
        ModelTableEdt model = new ModelTableEdt();
        final JTable table = new JTable(model);
        table.setRowHeight(100);
        table.setCellSelectionEnabled(true);
        ListSelectionModel cellSelectionModel = table.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getSelectionModel().addListSelectionListener(new MsgTableSelectionListenerEdT());
        JScrollPane panelScrollTable = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        GestionCours gestionnaireCours = new GestionCours();
        
        
        
        
        final List<String> dateCours = new ArrayList<String>();
        
        for (int i = 0; i < 5;++i) {
            dateCours.add(dt);
            c.add(Calendar.DATE, 1);
            dt = sdf.format(c.getTime());
        }
        
        int h = 8;
        
        JPanel panelTop = new JPanel(new BorderLayout());
        
        JButton droite = new JButton(">");
        droite.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                c.add(Calendar.DATE, 2);
                dt = sdf.format(c.getTime());
                
                modifEdt();
                
            }
        });
        JButton gauche = new JButton("<");
        gauche.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                c.add(Calendar.DATE, -12);
                dt = sdf.format(c.getTime());
                
                modifEdt();
                
            }
        });
        
        JLabel centre = new JLabel("Semaine du : " + dateCours.get(0) + " au : " + dateCours.get(4));
        centre.setHorizontalAlignment(SwingConstants.CENTER);
        
        panelTop.add(droite, BorderLayout.EAST);
        panelTop.add(gauche, BorderLayout.WEST);
        panelTop.add(centre, BorderLayout.CENTER);
        
        final List<DAOVueCours> coursLundi = new ArrayList<DAOVueCours>();
        final List<DAOVueCours> coursMardi = new ArrayList<DAOVueCours>();
        final List<DAOVueCours> coursMercredi = new ArrayList<DAOVueCours>();
        final List<DAOVueCours> coursJeudi = new ArrayList<DAOVueCours>();
        final List<DAOVueCours> coursVendredi = new ArrayList<DAOVueCours>();
        
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table.rowAtPoint(evt.getPoint());
                int col = table.columnAtPoint(evt.getPoint());
                String heure = null;
                DAOVueCours coursSelected = null;
                if (row >= 0 && col > 0) {
                    
                    
                    switch(row) {
                    case 0 :
                        heure = "08:00:00";
                        break;
                    case 1 :
                        heure = "09:00:00";
                        break;
                    case 2 :
                        heure = "10:00:00";
                        break;
                    case 3 :
                        heure = "11:00:00";
                        break;
                    case 4 :
                        heure = "12:00:00";
                        break;
                    case 5 :
                        heure = "13:00:00";
                        break;
                    case 6 :
                        heure = "14:00:00";
                        break;
                    case 7 :
                        heure = "15:00:00";
                        break;
                    case 8 :
                        heure = "16:00:00";
                        break;
                    case 9 :
                        heure = "17:00:00";
                        break;
                    }
                    
                    
                    switch (col) {
                    case 1 :
                        coursSelected = coursLundi.get(row);
                        if (coursSelected.getMatiere() == null) {
                            NouveauCours.creerNouveauCours(dateCours.get(col-1) + " " + heure, nomClasse);
                        }
                        
                        
                        break;
                    case 2 :
                        coursSelected = coursMardi.get(row);
                        if (coursSelected.getMatiere() == null) {
                            NouveauCours.creerNouveauCours(dateCours.get(col-1) + " " + heure, nomClasse);
                        }
                        break;
                    case 3 :
                        coursSelected = coursMercredi.get(row);
                        if (coursSelected.getMatiere() == null) {
                            NouveauCours.creerNouveauCours(dateCours.get(col-1) + " " + heure, nomClasse);
                        }
                        break;
                    case 4 :
                        coursSelected = coursJeudi.get(row);
                        if (coursSelected.getMatiere() == null) {
                            NouveauCours.creerNouveauCours(dateCours.get(col-1) + " " + heure, nomClasse);
                        }
                        break;
                    case 5 :
                        coursSelected = coursVendredi.get(row);
                        if (coursSelected.getMatiere() == null) {
                            NouveauCours.creerNouveauCours(dateCours.get(col-1) + " " + heure, nomClasse);
                        }
                        break;
                        
                    
                    }
                }
            }
        });

        for (int i=0; i < 10 ;++i) {
            
            if (h== 8 || h == 9) {
                coursLundi.add(gestionnaireCours.getCours(ideleve, dateCours.get(0) + " 0" + h + ":00:02"));
                coursMardi.add(gestionnaireCours.getCours(ideleve, dateCours.get(1)  + " 0" + h + ":00:02"));
                coursMercredi.add(gestionnaireCours.getCours(ideleve, dateCours.get(2) + " 0" + h + ":00:02"));
                coursJeudi.add(gestionnaireCours.getCours(ideleve, dateCours.get(3) + " 0" + h + ":00:02"));
                coursVendredi.add(gestionnaireCours.getCours(ideleve, dateCours.get(4) + " 0" + h + ":00:02"));
            } else {
                coursLundi.add(gestionnaireCours.getCours(ideleve, dateCours.get(0) +" " + h + ":00:02"));
                coursMardi.add(gestionnaireCours.getCours(ideleve, dateCours.get(1) +" " + h + ":00:02"));
                coursMercredi.add(gestionnaireCours.getCours(ideleve, dateCours.get(2) +" " + h + ":00:02"));
                coursJeudi.add(gestionnaireCours.getCours(ideleve, dateCours.get(3) +" "+ h + ":00:02"));
                coursVendredi.add(gestionnaireCours.getCours(ideleve, dateCours.get(4) +" " + h + ":00:02"));
            }

            h = h+1;
        }
        
        model.updateTableData(heures, coursLundi, coursMardi, coursMercredi, coursJeudi, coursVendredi);
        
        eDT.add(panelScrollTable, BorderLayout.CENTER);
        eDT.add(panelTop, BorderLayout.NORTH);
        eDT.repaint();
        eDT.revalidate();
    }

}

class MsgTableSelectionListenerEdT  implements ListSelectionListener {
    @Override
        public void valueChanged(ListSelectionEvent selectionEvent) {
        if (selectionEvent.getValueIsAdjusting()) {
            return;
        }
       
        ListSelectionModel selectEvent = (ListSelectionModel) selectionEvent.getSource();
       
        if (!selectEvent.isSelectionEmpty()) {
               
                int indexMsgSelected = selectEvent.getMaxSelectionIndex();

                /*DAOVueCours msgSelected = coursLundi.get(indexMsgSelected);
                
                NouveauMessage.creerNouveauMessage(user, true, msgSelected.getDestinataires(), msgSelected.getObjet(), msgSelected.getContenu());
                */       
                
               
               
        }
    }
}