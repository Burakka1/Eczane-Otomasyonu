package eczaneotomasyon;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class IlkEkran extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IlkEkran frame = new IlkEkran();
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
	public IlkEkran() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 308);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Image doktor= new ImageIcon(this.getClass().getResource("/Doktor.png")).getImage();
		JButton btndoktorlogin = new JButton("Doktor");
		btndoktorlogin.setForeground(Color.WHITE);
		btndoktorlogin.setBackground(Color.WHITE);
		btndoktorlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			Doktorlogin giris = new Doktorlogin();
			giris.setVisible(true);
			
			}
		});
		btndoktorlogin.setIcon(new ImageIcon(doktor));
		btndoktorlogin.setBounds(76, 67, 98, 101);
		contentPane.add(btndoktorlogin);
		
		JLabel lbdoktorlogin = new JLabel("Doktor Girişi");
		lbdoktorlogin.setBounds(86, 179, 76, 21);
		contentPane.add(lbdoktorlogin);
		Image eczaci= new ImageIcon(this.getClass().getResource("/Eczaci.png")).getImage();
		JButton btneczacilogin = new JButton("New button");
		btneczacilogin.setForeground(Color.WHITE);
		btneczacilogin.setBackground(Color.WHITE);
		btneczacilogin.setIcon(new ImageIcon(eczaci));

		btneczacilogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Eczacilogin giris = new Eczacilogin();
				giris.setVisible(true);
			}
		});
		btneczacilogin.setBounds(274, 67, 98, 101);
		contentPane.add(btneczacilogin);
		
		JLabel lbeczacilogin = new JLabel("Eczacı Girişi");
		lbeczacilogin.setBounds(284, 182, 75, 14);
		contentPane.add(lbeczacilogin);
		
		JLabel image = new JLabel("");
		image.setBounds(0, 0, 440, 269);
		contentPane.add(image);
		Image ilkekran= new ImageIcon(this.getClass().getResource("/ilk.jpg")).getImage();
		
		image.setIcon(new ImageIcon(ilkekran));
		
		
	
		
	}
}
