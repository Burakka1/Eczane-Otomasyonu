package eczaneotomasyon;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Helpers.DBConnection;

import javax.swing.JTabbedPane;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Eczaciarayuzz extends JFrame {

	private JPanel contentPane;
	private JTextField tfrecete;
	private JScrollPane screcete;
	private JTable tbrecete;
	private Object[]  receteData=null;
	private DefaultTableModel recetemodel=null;
	private DefaultTableModel stokmodel=null;
	private Object[] stokData=null;
	private DBConnection conn=new DBConnection();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eczaciarayuzz frame = new Eczaciarayuzz();
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
	public int top;
	private JTable tbstok;
	private JTextField tfbarkod;
	private JTextField tfurunadi;
	private JTextField tfetkinmadde;
	private JTextField tfkullanimyasi;
	private JTextField tfilacturu;
	private JTextField tffiyat;
	private JTextField tfilacadet;
	public Eczaciarayuzz() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1140, 804);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 255, 255));
		tabbedPane.setFont(new Font("Monospaced", Font.PLAIN, 15));
		tabbedPane.setBounds(0, 0, 1124, 765);
		contentPane.add(tabbedPane);
		stokmodel=new DefaultTableModel();
		Object[] stok =new Object[7];
		stok[0]="Barkod Numarası";
		stok[1]="Ürün Adı";
		stok[2]="Etkin Maddesi";
		stok[3]="Kullanım Yaşı";
		stok[4]="İlaç Türü";
		stok[5]="Fiyat";
		stok[6]="İlaç Adeti";
		stokmodel.setColumnIdentifiers(stok);
		stokData=new Object[7];
		
		
		recetemodel=new DefaultTableModel();
		Object[] recete=new Object[7];
		recete[6]="Fiyat";
		recete[5]="Kimlik Numarası";
		recete[0]="Barkod Numarası";
		recete[1]="Ürün Adı";
		recete[2]="Etkin Maddesi";
		recete[3]="Kullanım Yaşı";
		recete[4]="İlaç Türü";
		recetemodel.setColumnIdentifiers(recete);
		receteData=new Object[7];
		
		
				try {
			
			Connection con=conn.connDb();
			Statement st=con.createStatement();
			ResultSet rs =st.executeQuery("SELECT * FROM ilaclar_stok");
			while(rs.next())
			{
			stok[0]=rs.getString("Barkod");
			stok[1]=rs.getString("Urunadi");
			stok[2]=rs.getString("Etkinmadde");
			stok[3]=rs.getString("Kullanimyasi");
			stok[4]=rs.getString("Ilacturu");
			stok[5]=rs.getString("Fiyat");
			stok[6]=rs.getString("IlacAdet");
			stokmodel.addRow(stok);
			}
			st.close();
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 222, 179));
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 222, 179));
		tabbedPane.addTab("İlaç Stok", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scstok = new JScrollPane();
		
		scstok.setBounds(10, 36, 729, 500);
		panel_1.add(scstok);
		
		tbstok = new JTable(stokmodel);
		scstok.setViewportView(tbstok);
		
		JLabel lblNewLabel = new JLabel("Stok Durumu");
		lblNewLabel.setFont(new Font("Monospaced", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 11, 103, 14);
		panel_1.add(lblNewLabel);
		
		tfbarkod = new JTextField();
		tfbarkod.setBounds(854, 36, 174, 20);
		panel_1.add(tfbarkod);
		tfbarkod.setColumns(10);
		
		tfurunadi = new JTextField();
		tfurunadi.setColumns(10);
		tfurunadi.setBounds(854, 73, 174, 20);
		panel_1.add(tfurunadi);
		
		tfetkinmadde = new JTextField();
		tfetkinmadde.setColumns(10);
		tfetkinmadde.setBounds(854, 114, 174, 20);
		panel_1.add(tfetkinmadde);
		
		tfkullanimyasi = new JTextField();
		tfkullanimyasi.setColumns(10);
		tfkullanimyasi.setBounds(854, 156, 174, 20);
		panel_1.add(tfkullanimyasi);
		
		tfilacturu = new JTextField();
		tfilacturu.setBounds(854, 198, 174, 20);
		panel_1.add(tfilacturu);
		tfilacturu.setColumns(10);
		
		tffiyat = new JTextField();
		tffiyat.setColumns(10);
		tffiyat.setBounds(854, 240, 174, 20);
		panel_1.add(tffiyat);
		
		tfilacadet = new JTextField();
		tfilacadet.setColumns(10);
		tfilacadet.setBounds(854, 282, 174, 20);
		panel_1.add(tfilacadet);
		
		tbstok.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfbarkod.setText((String) stokmodel.getValueAt(tbstok.getSelectedRow(),0));
				tfurunadi.setText((String) stokmodel.getValueAt(tbstok.getSelectedRow(),1));
				tfetkinmadde.setText((String) stokmodel.getValueAt(tbstok.getSelectedRow(),2));
				tfkullanimyasi.setText((String) stokmodel.getValueAt(tbstok.getSelectedRow(),3));
				tfilacturu.setText((String) stokmodel.getValueAt(tbstok.getSelectedRow(),4));
				tffiyat.setText((String) stokmodel.getValueAt(tbstok.getSelectedRow(),5));
				tfilacadet.setText((String) stokmodel.getValueAt(tbstok.getSelectedRow(),6));
			}
		});
		JButton btnekle = new JButton("Ekle");
		btnekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tfbarkod.getText().length()!=0 && tfurunadi.getText().length()!=0 && tffiyat.getText().length()!=0)
				{
				try {
				Statement st = null;
				
				Connection con=conn.connDb();
				st = con.createStatement();
				String sqlQuery="INSERT INTO ilaclar (Barkod, Urunadi, Etkinmadde, Kullanimyasi, Ilacturu, Fiyat) VALUES ('"+tfbarkod.getText()+"','"+tfurunadi.getText()+"','"+tfetkinmadde.getText()+"','"+tfkullanimyasi.getText()+"','"+tfilacturu.getText()+"','"+tffiyat.getText()+"')";
				st.executeUpdate(sqlQuery);
				JOptionPane.showMessageDialog(null, "Ekleme İşlemi Başarıyla Gerçekleşmiştir.");
				}
				catch(SQLException e1){
					e1.printStackTrace();
					
				}
				try {
					Statement st = null;
					recetemodel.setRowCount(0);
					Connection con=conn.connDb();
					st = con.createStatement();
					
				String sqlQuery="INSERT INTO stogagelenilaclar(Urunadi,IlacAdet) VALUES ('"+tfurunadi.getText()+"','"+tfilacadet.getText()+"')";
					st.executeUpdate(sqlQuery);
				
				}
				catch(SQLException e1){
					e1.printStackTrace();
					
				}
				dispose();
				Eczaciarayuzz f =new Eczaciarayuzz();
				f.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Lütfen Zorunlu Alanları Doldurunuz.");
				}
			}
		});
		btnekle.setBounds(780, 326, 89, 23);
		panel_1.add(btnekle);
		
		JLabel lblNewLabel_1 = new JLabel("Barkod:");
		lblNewLabel_1.setBounds(762, 37, 46, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Ürün Adı:");
		lblNewLabel_3.setBounds(762, 76, 64, 14);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("Etkin Madde:");
		lblNewLabel_1_1.setBounds(762, 117, 89, 14);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Kullanım Yaşı:");
		lblNewLabel_1_2.setBounds(762, 159, 95, 14);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("İlaç Türü:");
		lblNewLabel_1_3.setBounds(762, 201, 64, 14);
		panel_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Fiyat:");
		lblNewLabel_1_4.setBounds(762, 243, 46, 14);
		panel_1.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("İlaç Adeti:");
		lblNewLabel_1_5.setBounds(762, 285, 64, 14);
		panel_1.add(lblNewLabel_1_5);
		
		JButton btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Statement st = null;
					
					Connection con=conn.connDb();
					st = con.createStatement();
					if(tfbarkod.getText().length()!=0) {
					String sqlQuery="DELETE FROM ilaclar WHERE Barkod="+tfbarkod.getText();
					st.executeUpdate(sqlQuery);
					JOptionPane.showMessageDialog(null, "Silme İşlemi Başarıyla Gerçekleşmiştir.");
					dispose();
					Eczaciarayuzz f =new Eczaciarayuzz();
					f.setVisible(true);
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "Lütfen bir ilaç seçiniz.");
					}
				
					
					}
					catch(SQLException e1){
						e1.printStackTrace();
						
					}
				try {
					Statement st = null;
					
					Connection con=conn.connDb();
					st = con.createStatement();
					String sqlQuery="DELETE FROM stogagelenilaclar WHERE Urunadi='"+tfurunadi.getText()+"'";
					st.executeUpdate(sqlQuery);
					
					
					
					}
					catch(SQLException e1){
						e1.printStackTrace();
						
					}
			
			}
		});
		btnSil.setBounds(884, 326, 89, 23);
		panel_1.add(btnSil);
		
		JButton btnGuncelle = new JButton("Güncelle");
		btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Statement st = null;
					
					Connection con=conn.connDb();
					st = con.createStatement();
					String sqlQuery="UPDATE ilaclar SET Barkod='"+tfbarkod.getText()+"',Urunadi='"+tfurunadi.getText()+"',Etkinmadde='"+tfetkinmadde.getText()+"',Kullanimyasi='"+tfkullanimyasi.getText()+"',Ilacturu='"+tfilacturu.getText()+"',Fiyat='"+tffiyat.getText()+"' WHERE Barkod="+tfbarkod.getText();
					st.executeUpdate(sqlQuery);
					JOptionPane.showMessageDialog(null, "Güncelleme İşlemi Başarıyla Gerçekleşmiştir.");
					
					
					}
					catch(SQLException e1){
						e1.printStackTrace();
						
					}
				try {
					Statement st = null;
					
					Connection con=conn.connDb();
					st = con.createStatement();
					String sqlQuery="UPDATE stogagelenilaclar SET Urunadi='"+tfurunadi.getText()+"',IlacAdet='"+tfilacadet.getText()+"' WHERE Urunadi='"+tfurunadi.getText()+"'";
					st.executeUpdate(sqlQuery);
					
					
					
					
					}
					catch(SQLException e1){
						e1.printStackTrace();
						
					}
				dispose();
				Eczaciarayuzz f =new Eczaciarayuzz();
				f.setVisible(true);
				
				  
			}
		});
		btnGuncelle.setBounds(986, 326, 89, 23);
		panel_1.add(btnGuncelle);
		
		JLabel lblNewLabel_4 = new JLabel("*");
		lblNewLabel_4.setBounds(1038, 37, 46, 14);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("*");
		lblNewLabel_4_1.setBounds(1038, 76, 46, 14);
		panel_1.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("*");
		lblNewLabel_4_2.setBounds(1038, 243, 46, 14);
		panel_1.add(lblNewLabel_4_2);
		tabbedPane.addTab("Reçete Sorgula", null, panel, null);
		panel.setLayout(null);
		JLabel lblfiyat = new JLabel("0");
		lblfiyat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblfiyat.setBounds(1004, 609, 46, 14);
		panel.add(lblfiyat);
		
		tfrecete = new JTextField();
		
		tfrecete.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				
							
				try {
					Statement st = null;
					recetemodel.setRowCount(0);
					Connection con=conn.connDb();
					st = con.createStatement();
					
					ResultSet rs =st.executeQuery("SELECT * FROM ilaclar_recete WHERE ReceteID LIKE '%"+tfrecete.getText()+"'");
					

					while(rs.next())
					{
						
						recete[0]=rs.getString("Barkod");
						recete[1]=rs.getString("Urunadi");
						recete[2]=rs.getString("Etkinmadde");
						recete[3]=rs.getString("Kullanimyasi");
						recete[4]=rs.getString("Ilacturu");
						recete[5]=rs.getString("HastaTc");
						recete[6]=rs.getString("Fiyat");
						
						top+=rs.getInt("Fiyat");
						recetemodel.addRow(recete);
				 lblfiyat.setText(""+top);
					
								
					}
				
				
				
					
					if(tfrecete.getText().length()==0)
					{
						recetemodel.setRowCount(0);
						top=0;
						lblfiyat.setText(""+top);
					}
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		tfrecete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfrecete.setForeground(Color.BLACK);
		tfrecete.setBounds(10, 33, 153, 28);
		panel.add(tfrecete);
		tfrecete.setColumns(10);
		
		screcete = new JScrollPane();
		screcete.addMouseListener(new MouseAdapter() {
			
		});
		screcete.setBounds(10, 84, 1099, 488);
		panel.add(screcete);
		
		
		
		
		tbrecete = new JTable(recetemodel);
		tbrecete.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		screcete.setViewportView(tbrecete);
		
		JLabel lbldenecekFiyat = new JLabel("Ödenecek Fiyat:");
		lbldenecekFiyat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbldenecekFiyat.setBounds(885, 607, 109, 19);
		panel.add(lbldenecekFiyat);
		
		JButton btnsatisiyap = new JButton("Satışı Yap");
		btnsatisiyap.setFont(new Font("Monospaced", Font.PLAIN, 15));
		btnsatisiyap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tfrecete.getText().length()>0) {
				JOptionPane.showMessageDialog(null, "Satış Başarıyla Gerçekleşmiştir.");
				tfrecete.setText(null);
				top=0;
				lblfiyat.setText(""+top);
				
				}
				else {
					JOptionPane.showMessageDialog(null, "Lütfen Geçerli Bir Reçete Numarası Giriniz.");
				}
			}
			
		});
		btnsatisiyap.setBounds(885, 637, 202, 44);
		panel.add(btnsatisiyap);
		
		JLabel lblNewLabel_2 = new JLabel("TL");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(1047, 609, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_5 = new JLabel("Reçete Numarası");
		lblNewLabel_5.setFont(new Font("Monospaced", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(10, 11, 144, 14);
		panel.add(lblNewLabel_5);
		
		
		
	}
}
