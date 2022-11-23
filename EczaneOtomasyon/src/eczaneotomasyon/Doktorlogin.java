package eczaneotomasyon;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import Helpers.*;
import eczaneotomasyon.*;
import java.awt.Color;


public class Doktorlogin extends JFrame {

	private JPanel contentPane;
	private JTextField tfeposta;
	private JPasswordField tfparola;
	private DBConnection conn=new DBConnection();
	private JLabel image;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Doktorlogin frame = new Doktorlogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Doktorlogin() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbeposta = new JLabel("E-Posta:");
		lbeposta.setForeground(Color.WHITE);
		lbeposta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbeposta.setBounds(87, 88, 60, 21);
		contentPane.add(lbeposta);
		
		JLabel lbparola = new JLabel("Parola:");
		lbparola.setForeground(Color.WHITE);
		lbparola.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbparola.setBounds(87, 157, 66, 14);
		contentPane.add(lbparola);
		
		tfeposta = new JTextField();
		tfeposta.setBounds(157, 88, 194, 20);
		contentPane.add(tfeposta);
		tfeposta.setColumns(10);
		
		tfparola = new JPasswordField();
		tfparola.setBounds(157, 156, 194, 20);
		contentPane.add(tfparola);
		
		JButton btnlogin = new JButton("Giriş Yap");
		btnlogin.setToolTipText("");
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfeposta.getText().length()==0 || tfparola.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Lütfen tüm alanları doldurunuz!");
				}
				else {
					try {
						Connection con=conn.connDb();
						Statement st=con.createStatement();
						ResultSet rs =st.executeQuery("SELECT * FROM doktor");
						while(rs.next()) {
							if(tfeposta.getText().equals(rs.getString("EPosta"))&& tfparola.getText().equals(rs.getString("Sifre"))) {
								
								dispose();
								Doktorarayuz giris = new Doktorarayuz();
								giris.setVisible(true);
								
								
							}
							
							else {
								JOptionPane.showMessageDialog(null, "Yanlış e-posta ya da şifre girdiniz.");
							}
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnlogin.setBounds(211, 205, 89, 23);
		contentPane.add(btnlogin);
		
		image = new JLabel("");
		image.setBounds(0, 0, 434, 261);
		contentPane.add(image);
Image doktor= new ImageIcon(this.getClass().getResource("/doktorlogin.jpg")).getImage();
		
		image.setIcon(new ImageIcon(doktor));
	}
}

