package Fenetre;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;

public class test {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 687, 358);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(328, 122, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNomDutilisateur = new JLabel("Nom d'utilisateur :");
		lblNomDutilisateur.setBounds(205, 125, 97, 14);
		frame.getContentPane().add(lblNomDutilisateur);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(328, 153, 86, 20);
		frame.getContentPane().add(textField_1);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setBounds(205, 156, 97, 14);
		frame.getContentPane().add(lblMotDePasse);
		
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ConnexionClick.clicked();
			}
		});
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnConnexion.setBounds(263, 198, 89, 23);
		frame.getContentPane().add(btnConnexion);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		chckbxNewCheckBox.setBounds(451, 215, 97, 23);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		//JLabel label2 = new JLabel("..");
		//label2.setBounds(280, 250, 46, 14);
		//frame.getContentPane().add(label2);
	}
}
