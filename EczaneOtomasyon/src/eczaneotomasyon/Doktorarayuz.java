package eczaneotomasyon;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.x.protobuf.MysqlxCrud.Update;


import Helpers.*;
import eczaneotomasyon.*;

import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;

public class Doktorarayuz extends JFrame {

	private JPanel contentPane;
	private JTextField tfhasta;
	private JScrollPane sc_hastalar;
	private JTable tb_hastalar;
	private DefaultTableModel doctormodel=null;
	private Object[] doctorData=null;
	private DefaultTableModel ilacmodel=null;
	private Object[]  ilacData=null;
	private Object[]  receteData=null;
	private DefaultTableModel recetemodel=null;
	private DefaultTableModel receteSQLmodel=null;
	
	private JPanel panel_1;
	private JTable tb_ilacyaz;
	private JTextField tfilacara;
	private JTextField tfreceteno;
	private JTable tbreceteno;
	private JTable tbrecete;
	 public int receteid;
	private DBConnection conn=new DBConnection();
	public void showuser() {
try {
			
			Connection con=conn.connDb();
			Statement st=con.createStatement();
			ResultSet rs =st.executeQuery("SELECT * FROM recete");
			while(rs.next())
			{
			receteData[0]=rs.getString("Barkod");
			receteData[1]=rs.getString("Urunadi");
			receteData[2]=rs.getString("Etkinmadde");
			receteData[3]=rs.getString("Kullanimyasi");
			receteData[4]=rs.getString("Ilacturu");
			receteData[5]=rs.getString("HastaTc");
			receteSQLmodel.addRow(receteData);
			}
			st.close();
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			

			

			public void run() {
				try {
					Doktorarayuz frame = new Doktorarayuz();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	String hasta[]=new String[5];
	String recetest[]=new String[6];
	public Doktorarayuz() throws SQLException {
		setResizable(false);
		doctormodel=new DefaultTableModel();
		Object[] colHastaAdi=new Object[5];
		colHastaAdi[0]="Kimlik Numarası";
		colHastaAdi[1]="İsim";
		colHastaAdi[2]="Soyisim";
		colHastaAdi[3]="Sigorta Türü";
		colHastaAdi[4]="Doğum Tarihi";
		doctormodel.setColumnIdentifiers(colHastaAdi);
		doctorData=new Object[6];
try {
			
			Connection con=conn.connDb();
			Statement st=con.createStatement();
			ResultSet rs =st.executeQuery("SELECT * FROM hasta");
			while(rs.next())
			{
			doctorData[0]=rs.getString("HastaTc");
			doctorData[1]=rs.getString("İsim");
			doctorData[2]=rs.getString("Soyisim");
			doctorData[3]=rs.getString("SigortaTuru");
			doctorData[4]=rs.getString("DogumTarihi");
			
			doctormodel.addRow(doctorData);
			}
			st.close();
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ilacmodel=new DefaultTableModel();
		Object[] ilaclar=new Object[5];
		ilaclar[0]="Barkod Numarası";
		ilaclar[1]="Ürün Adı";
		ilaclar[2]="Etkin Maddesi";
		ilaclar[3]="Kullanım Yaşı";
		ilaclar[4]="İlaç Türü";
		ilacmodel.setColumnIdentifiers(ilaclar);
		ilacData=new Object[6];
		
		recetemodel=new DefaultTableModel();
		receteSQLmodel=new DefaultTableModel();
		Object[] recete=new Object[6];
		recete[5]="Kimlik Numarası";
		recete[0]="Barkod Numarası";
		recete[1]="Ürün Adı";
		recete[2]="Etkin Maddesi";
		recete[3]="Kullanım Yaşı";
		recete[4]="İlaç Türü";
		receteSQLmodel.setColumnIdentifiers(recete);
		recetemodel.setColumnIdentifiers(recete);
		receteData=new Object[6];
		
	   

try {
			
			Connection con=conn.connDb();
			Statement st=con.createStatement();
			ResultSet rs =st.executeQuery("SELECT * FROM recete");
			while(rs.next())
			{
			receteData[0]=rs.getString("Barkod");
			receteData[1]=rs.getString("Urunadi");
			receteData[2]=rs.getString("Etkinmadde");
			receteData[3]=rs.getString("Kullanimyasi");
			receteData[4]=rs.getString("Ilacturu");
			receteData[5]=rs.getString("HastaTc");
			receteSQLmodel.addRow(receteData);
			}
			st.close();
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			
			Connection con=conn.connDb();
			Statement st=con.createStatement();
			ResultSet rs =st.executeQuery("SELECT * FROM ilaclar");
			while(rs.next())
			{
			ilacData[0]=rs.getString("Barkod");
			ilacData[1]=rs.getString("Urunadi");
			ilacData[2]=rs.getString("Etkinmadde");
			ilacData[3]=rs.getString("Kullanimyasi");
			ilacData[4]=rs.getString("Ilacturu");
			ilacmodel.addRow(ilacData);
			}
			st.close();
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		setForeground(Color.LIGHT_GRAY);
		setBackground(Color.WHITE);
		setFont(new Font("Dialog", Font.PLAIN, 16));
		setOpacity(1.0f);
		setType(Type.POPUP);
		setTitle("Doktor Arayüzü");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1140, 804);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(SystemColor.textText);
		tabbedPane.setFont(new Font("Monospaced", Font.PLAIN, 15));
		tabbedPane.setBackground(new Color(255, 255, 255));
		tabbedPane.setBounds(0, 0, 1124, 765);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 224, 230));
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				receteSQLmodel.setRowCount(0);
				}
		});
		tabbedPane.addTab("Hastalar", null, panel, "");
		panel.setLayout(null);
		
		tfhasta = new JTextField();
		tfhasta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				doctormodel.setRowCount(0);
				Connection con=conn.connDb();
				Statement st = null;
				
				try {
					st = con.createStatement();
					ResultSet rs =st.executeQuery("SELECT * FROM Hasta WHERE (İsim) LIKE '"+tfhasta.getText()+"%'");
					while(rs.next())
					{
						hasta[0]=rs.getString("HastaTc");
						hasta[1]=rs.getString("İsim");
						hasta[2]=rs.getString("Soyisim");
						hasta[3]=rs.getString("SigortaTuru");
						hasta[4]=rs.getString("DogumTarihi");
						
								doctormodel.addRow(hasta);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		tfhasta.setBackground(new Color(255, 255, 255));
		tfhasta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfhasta.setText(null);
				tfhasta.setForeground(SystemColor.textText);
			}
		});
		tfhasta.setForeground(new Color(192, 192, 192));
		tfhasta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfhasta.setText(" Hasta Adı");
		tfhasta.setToolTipText("");
		tfhasta.setBounds(10, 28, 186, 27);
		
		panel.add(tfhasta);
		tfhasta.setColumns(10);
		
		sc_hastalar = new JScrollPane();
		sc_hastalar.setBounds(10, 66, 1099, 595);
		panel.add(sc_hastalar);
		
		tb_hastalar = new JTable(doctormodel);
		tb_hastalar.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		sc_hastalar.setViewportView(tb_hastalar);
		
		JButton btnsec = new JButton("Seç");
		btnsec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
try {
					
					Connection con=conn.connDb();
					Statement st=con.createStatement();
					ResultSet rs =st.executeQuery("SELECT * FROM hasta where ID='"+(tb_hastalar.getSelectedRow()+1)+"' ");
					while(rs.next())
					{
					
					doctorData[0]="";
					doctorData[1]="";
					doctorData[2]="";
					doctorData[3]="";
					doctorData[4]="";
					
					doctorData[5]=rs.getString("HastaTc");
					recetemodel.addRow(doctorData);
					
					}
					recetemodel.setRowCount(0); 
				}
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnsec.setBounds(505, 692, 89, 27);
		panel.add(btnsec);
		tabbedPane.setForegroundAt(0, new Color(0, 0, 0));
		tabbedPane.setBackgroundAt(0, new Color(255, 255, 255));
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(176, 224, 230));
		panel_1.addMouseListener(new MouseAdapter() {
			
		});
		panel_1.setForeground(SystemColor.activeCaption);
		tabbedPane.addTab("İlaç Yaz", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane sc_ilacyaz = new JScrollPane();
		sc_ilacyaz.setBounds(10, 94, 1099, 251);
		panel_1.add(sc_ilacyaz);
		
		tb_ilacyaz = new JTable(ilacmodel);
		tb_ilacyaz.setToolTipText("");
		tb_ilacyaz.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		sc_ilacyaz.setViewportView(tb_ilacyaz);
		
		tfilacara = new JTextField();
		tfilacara.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				ilacmodel.setRowCount(0);
				Connection con=conn.connDb();
				Statement st = null;
				try {
					st = con.createStatement();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					ResultSet rs =st.executeQuery("SELECT * FROM ilaclar WHERE (UrunAdi) LIKE '"+tfilacara.getText()+"%'");
					while(rs.next())
					{
						ilacData[0]=rs.getString("Barkod");
						ilacData[1]=rs.getString("Urunadi");
						ilacData[2]=rs.getString("Etkinmadde");
						ilacData[3]=rs.getString("Kullanimyasi");
						ilacData[4]=rs.getString("Ilacturu");
						ilacmodel.addRow(ilacData);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		tfilacara.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfilacara.setText(null);
				tfilacara.setForeground(SystemColor.textText);
			}
		});
		tfilacara.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfilacara.setText(" İlaç Ara");
		tfilacara.setForeground(Color.LIGHT_GRAY);
		tfilacara.setBounds(10, 27, 175, 26);
		panel_1.add(tfilacara);
		tfilacara.setColumns(10);
		
		JButton btnreceteyeekle = new JButton("Reçeteye Ekle");
		btnreceteyeekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				                   
				try {
					
					Connection con=conn.connDb();
					Statement st=con.createStatement();
					ResultSet rs =st.executeQuery("SELECT * FROM ilaclar where ID='"+(tb_ilacyaz.getSelectedRow()+1)+"'");
					while(rs.next())
					{
					
					ilacData[0]=rs.getString("Barkod");
					ilacData[1]=rs.getString("Urunadi");
					ilacData[2]=rs.getString("Etkinmadde");
					ilacData[3]=rs.getString("Kullanimyasi");
					ilacData[4]=rs.getString("Ilacturu");
					ilacData[5]=doctorData[5];
					recetemodel.addRow(ilacData);
					}
				}
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnreceteyeekle.setBounds(459, 356, 125, 23);
		panel_1.add(btnreceteyeekle);
		
		JButton btnilacsil = new JButton("İlaç Sil");
		btnilacsil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int secilen =tbrecete.getSelectedRow();
			if(secilen>-1) {recetemodel.removeRow(secilen);
			}
			}
		});
		btnilacsil.setBounds(391, 696, 112, 23);
		panel_1.add(btnilacsil);
		
		JScrollPane screcete = new JScrollPane();
		screcete.setBounds(10, 415, 1099, 258);
		panel_1.add(screcete);
		
		tbrecete = new JTable(recetemodel);
		screcete.setViewportView(tbrecete);
		
		JLabel lbilaclar = new JLabel("İlaçlar");
		lbilaclar.setFont(new Font("Monospaced", Font.PLAIN, 15));
		lbilaclar.setBounds(10, 69, 76, 14);
		panel_1.add(lbilaclar);
		
		JLabel lbrecete = new JLabel("Reçete");
		lbrecete.setFont(new Font("Monospaced", Font.PLAIN, 15));
		lbrecete.setBounds(10, 390, 76, 14);
		panel_1.add(lbrecete);
		
		JButton btnNewButton = new JButton("Reçeteyi Yazdır");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				receteSQLmodel.setRowCount(0);
				DefaultTableModel model=(DefaultTableModel) tbrecete.getModel();
				try {
					
					
					Connection con=conn.connDb();
					Statement st=con.createStatement();
					ResultSet rs =st.executeQuery("SELECT * FROM recete");
					
					while(rs.next())
					{
						receteid=rs.getInt("ReceteID");
					}
					receteid++;
						
					
					for(int i=0;i<model.getRowCount();i++) {
					
						int Barkod = Integer.valueOf(model.getValueAt(i, 0).toString());
						String Urunadi = model.getValueAt(i, 1).toString();
						String Etkinmadde = model.getValueAt(i, 2).toString();
						int Kullanimyasi = Integer.valueOf(model.getValueAt(i, 3).toString());
						String Ilacturu = model.getValueAt(i, 4).toString();
						int HastaTc = Integer.valueOf(model.getValueAt(i, 5).toString());
						String sqlQuery="INSERT INTO recete (Barkod, Urunadi, Etkinmadde, Kullanimyasi, Ilacturu, ReceteID,HastaTc) VALUES ("+Barkod+",'"+Urunadi+"','"+Etkinmadde+"','"+Kullanimyasi+"','"+Ilacturu+"','"+receteid+"','"+HastaTc+"')";
						st.executeUpdate(sqlQuery);
						
					}
					int[] rowsInserted=st.executeBatch();
					JOptionPane.showMessageDialog(null, "Reçete başarıyla yazdırılmıştır."
							+ "Reçete numaranız= "+receteid);
					
				
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			
				
				
			}
		});
		btnNewButton.setBounds(565, 696, 137, 23);
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(176, 224, 230));
		panel_2.addMouseListener(new MouseAdapter() {
			
		});
	
		tabbedPane.addTab("Reçete Sorgula", null, panel_2, null);
		panel_2.setLayout(null);
		
		tfreceteno = new JTextField();
		tfreceteno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				
				receteSQLmodel.setRowCount(0);
				if(tfreceteno.getText().length()>0)
				try {
					Statement st = null;
					receteSQLmodel.setRowCount(0);
					Connection con=conn.connDb();
					st = con.createStatement();
					ResultSet rs =st.executeQuery("SELECT * FROM recete WHERE ReceteID LIKE '"+tfreceteno.getText()+"%'");

					while(rs.next())
					{
						
						recetest[0]=rs.getString("Barkod");
						recetest[1]=rs.getString("Urunadi");
						recetest[2]=rs.getString("Etkinmadde");
						recetest[3]=rs.getString("Kullanimyasi");
						recetest[4]=rs.getString("Ilacturu");
						recetest[5]=rs.getString("HastaTc");
						receteSQLmodel.addRow(recetest);
						
								
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		tfreceteno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfreceteno.setText(null);
				tfreceteno.setForeground(SystemColor.textText);
			}
		});
		tfreceteno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfreceteno.setText(" Reçete No");
		tfreceteno.setForeground(Color.LIGHT_GRAY);
		tfreceteno.setBounds(10, 11, 128, 25);
		panel_2.add(tfreceteno);
		tfreceteno.setColumns(10);
		
		JScrollPane screceteno = new JScrollPane();
		screceteno.setBounds(10, 43, 1099, 660);
		panel_2.add(screceteno);
		
		tbreceteno = new JTable(receteSQLmodel);
		screceteno.setViewportView(tbreceteno);
	}
}
