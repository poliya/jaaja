package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mysql.jdbc.Statement;


import java.awt.Component;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JScrollPane;

public class MainPage {

	private static Vector<Vector<Object>> data;
	private JFrame frame;
	private JTable table;
	private Connection c;
	private Statement st;
	private JButton btnSupprimer;
	private JButton btnHistoire;
	private JButton btnModifier;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage window = new MainPage();
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
	public MainPage() {
		makeDBConnection();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(new Dimension(900, 500));
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, "name_9555613410781");
		
		// panelAutoCar 	
		JPanel panelAutoCar = new JPanel();
		tabbedPane.addTab("AutoCar", null, panelAutoCar, null);
		panelAutoCar.setLayout(null);
		
		JLabel labelAutoCar = new JLabel("AutoCars Gestion");
		labelAutoCar.setBounds(366, 5, 156, 64);
		labelAutoCar.setAlignmentY(Component.TOP_ALIGNMENT);
		labelAutoCar.setHorizontalTextPosition(SwingConstants.CENTER);
		labelAutoCar.setHorizontalAlignment(SwingConstants.CENTER);
		labelAutoCar.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		labelAutoCar.setBorder(new EmptyBorder(20, 0, 20, 0));
		panelAutoCar.add(labelAutoCar);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnAjouter.setBounds(34, 409, 89, 23);
		panelAutoCar.add(btnAjouter);
		
		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(143, 409, 89, 23);
		panelAutoCar.add(btnSupprimer);
		btnSupprimer.setEnabled(false);
		
		btnModifier = new JButton("Modifier");
		btnModifier.setBounds(250, 409, 89, 23);
		panelAutoCar.add(btnModifier);
		btnModifier.setEnabled(false);
		
		btnHistoire = new JButton("Histoire");
		btnHistoire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnHistoire.setBounds(355, 409, 89, 23);
		panelAutoCar.add(btnHistoire);
		btnHistoire.setEnabled(false);
		ResultSet rs=null;
		table=new JTable();
		try {
			rs=st.executeQuery("select * from autocar");
			System.out.println("rs.toString()="+rs.toString());
			table.setModel(buildTableModel(rs));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 2, 2);
		panelAutoCar.add(scrollPane);
		
		
		
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setLocation(44, 56);
		table.setSize(800, 201);
		table.setBackground(Color.WHITE);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setBackground(Color.white);
		table.setRowHeight(30);
		panelAutoCar.add(table);
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){

			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				btnSupprimer.setEnabled(true);
				btnHistoire.setEnabled(true);
				btnModifier.setEnabled(true);
				btnSupprimer.setEnabled(true);
				int indexSelected=table.getSelectedRow();
				System.out.println(data.get(indexSelected));
				
			}
	    });
		System.out.println(table.getSize().toString());
		
		// panelLignes 
		JPanel panelLignes = new JPanel();
		tabbedPane.addTab("Ligne", null, panelLignes, null);
		panelLignes.setLayout(new BorderLayout(0, 0));
		
		JLabel labelLignes = new JLabel("Lignes Gestion");
		labelLignes.setHorizontalTextPosition(SwingConstants.CENTER);
		labelLignes.setHorizontalAlignment(SwingConstants.CENTER);
		labelLignes.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		labelLignes.setBorder(new EmptyBorder(20, 0, 20, 0));
		panelLignes.add(labelLignes, BorderLayout.NORTH);
		
		
		// panelAgence 	
		JPanel panelAgence = new JPanel();
		tabbedPane.addTab("Agence", null, panelAgence, null);
		panelAgence.setLayout(new BorderLayout(0, 0));
		
		JLabel labelAgence = new JLabel("Agence Gestion");
		labelAgence.setHorizontalTextPosition(SwingConstants.CENTER);
		labelAgence.setHorizontalAlignment(SwingConstants.CENTER);
		labelAgence.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		labelAgence.setBorder(new EmptyBorder(20, 0, 20, 0));
		panelAgence.add(labelAgence, BorderLayout.NORTH);
		
		// panelAgence 	
		JPanel panelChauffeur = new JPanel();
		tabbedPane.addTab("Chauffeur", null, panelChauffeur, null);
		panelChauffeur.setLayout(new BorderLayout(0, 0));
		
		JLabel labelChauffeur = new JLabel("Chauffeur Gestion");
		labelChauffeur.setHorizontalTextPosition(SwingConstants.CENTER);
		labelChauffeur.setHorizontalAlignment(SwingConstants.CENTER);
		labelChauffeur.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		labelChauffeur.setBorder(new EmptyBorder(20, 0, 20, 0));
		panelChauffeur.add(labelChauffeur, BorderLayout.NORTH);
		
		
		frame.setVisible(true);
		try {
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static DefaultTableModel buildTableModel(ResultSet rs)
	        throws SQLException {

	    ResultSetMetaData metaData = rs.getMetaData();

	    // names of columns
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 2; column <= columnCount; column++){
	    	
	        columnNames.add(metaData.getColumnName(column));
	        System.out.print(metaData.getColumnName(column)+" ");
	    }
	    System.out.println();

	    // data of the table
	     data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex =2; columnIndex <= columnCount; columnIndex++) {
	            vector.add(rs.getObject(columnIndex));
	            System.out.print(rs.getObject(columnIndex)+" ");
	        }
	        System.out.println();
	        data.add(vector);
	    }

	    return new DefaultTableModel(data, columnNames);

	}
	private void makeDBConnection() {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			System.out.println("chargemet reussi !!");
			
			// Etablir la connection
			try {
				c = DriverManager.getConnection("jdbc:mysql://localhost:3306/voyage","root","");
				st = (Statement) c.createStatement();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
