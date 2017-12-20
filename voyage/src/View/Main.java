package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JInternalFrame;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mysql.jdbc.Statement;

import ModulController.Chauffeur;
import ModulController.CongeDate;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class Main {
	
	private static Vector<Vector<Object>> data;
	private static ArrayList<Integer> colmunIds;
	private JFrame frameGrandFatherContainer;
	private JPanel panelAutocarSideButton;
	private JLabel lblChauffeur;
	private Color menuColorDefault;
	private JPanel panelAgenceSideButton;
	private JLabel lblAutocar;
	private JPanel panelChauffeurSideButton;
	private JLabel lblAgence;
	private JPanel panelChauffeurMainContent;
	private JTable tableChauffeurHistory;
	private JTable tableChauffeur;
	private JPanel panelAutocarMainContent;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JLabel lblAutocar_1;
	private JTable table_1;
	private JTable table_3;
	private JPanel panelAgenceMainContent;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JLabel label_1;
	private JTable table_5;
	private Connection c;
	private Statement st;
	private ResultSet rs;
	private JScrollPane scrollPaneChauffeurTable;
	private JTextField txtFieldMatriculeChauffeur;
	private JTextField txtFieldNomChauffeur;
	private TableModel myModel;
	private JButton btnChauffeurModifier;
	private Component btnChauffeurSupprimer;
	private Component btnChauffeurAjouter;
	private JToggleButton tglbtnCongeChauffeur;
	private JScrollPane scrollPaneChauffeurHistoriqueTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frameGrandFatherContainer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		makeDBConnection();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameGrandFatherContainer = new JFrame();
		frameGrandFatherContainer.setBounds(100, 100, 773, 503);
		frameGrandFatherContainer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameGrandFatherContainer.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		frameGrandFatherContainer.setResizable(false);
		JPanel frameFatherContainer = new JPanel();
		frameGrandFatherContainer.getContentPane().add(frameFatherContainer);
		frameFatherContainer.setLayout(null);
		
		JPanel panelSideLayoutContainer = new JPanel();
		panelSideLayoutContainer.setBounds(0, 0, 199, 474);
		panelSideLayoutContainer.setBackground(new Color(0, 0, 25));
		frameFatherContainer.add(panelSideLayoutContainer);
		panelSideLayoutContainer.setLayout(null);
		menuColorDefault=new Color(05, 05, 30);
		panelAutocarSideButton = new JPanel();
		panelAutocarSideButton.setBackground(menuColorDefault);
		panelAutocarSideButton.setBounds(0, 163, 199, 43);
		
		panelSideLayoutContainer.add(panelAutocarSideButton);
		panelAutocarSideButton.setLayout(null);
		
		lblChauffeur = new JLabel("Chauffeur");
		lblChauffeur.setBounds(0, 0, 199, 43);
		panelAutocarSideButton.add(lblChauffeur);
		lblChauffeur.setHorizontalTextPosition(SwingConstants.CENTER);
		lblChauffeur.setHorizontalAlignment(SwingConstants.CENTER);
		lblChauffeur.setForeground(Color.WHITE);
		lblChauffeur.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 22));
		
		panelAutocarSideButton.addMouseListener(new java.awt.event.MouseAdapter() {
			
			
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	panelAutocarSideButton.setBackground(Color.WHITE);
		    	lblChauffeur.setForeground(Color.BLACK);
		    	
		    	
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	panelAutocarSideButton.setBackground(menuColorDefault);
		    	lblChauffeur.setForeground(Color.WHITE);
		    	
		    }
		    @Override
		    public void mouseClicked(MouseEvent arg0) {
		    	panelAgenceMainContent.setVisible(false);
		    	panelAutocarMainContent.setVisible(false);
		    	panelChauffeurMainContent.setVisible(true);
		    }
		    
		});
		panelAgenceSideButton = new JPanel();
		panelAgenceSideButton.setLayout(null);
		panelAgenceSideButton.setBackground(menuColorDefault);
		panelAgenceSideButton.setBounds(0, 209, 199, 43);
		panelSideLayoutContainer.add(panelAgenceSideButton);
		panelAgenceSideButton.addMouseListener(new java.awt.event.MouseAdapter() {
			
			
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	panelAgenceSideButton.setBackground(Color.WHITE);
		    	lblAutocar.setForeground(Color.BLACK);
		    	
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	panelAgenceSideButton.setBackground(menuColorDefault);
		    	lblAutocar.setForeground(Color.WHITE);
		    	
		    }
		    @Override
		    public void mouseClicked(MouseEvent arg0) {
		    	panelAgenceMainContent.setVisible(false);
		    	panelAutocarMainContent.setVisible(true);
		    	panelChauffeurMainContent.setVisible(false);

		    }
		});
		
		lblAutocar = new JLabel("AutoCar");
		lblAutocar.setBounds(0, 0, 199, 43);
		panelAgenceSideButton.add(lblAutocar);
		lblAutocar.setForeground(Color.WHITE);
		lblAutocar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutocar.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAutocar.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 22));
		
		panelChauffeurSideButton = new JPanel();
		panelChauffeurSideButton.setLayout(null);
		panelChauffeurSideButton.setBackground(menuColorDefault);
		panelChauffeurSideButton.setBounds(0, 255, 199, 43);
		panelSideLayoutContainer.add(panelChauffeurSideButton);
		
		panelChauffeurSideButton.addMouseListener(new java.awt.event.MouseAdapter() {
			
			
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	panelChauffeurSideButton.setBackground(Color.WHITE);
		    	lblAgence.setForeground(Color.BLACK);
		    	
		    	
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	panelChauffeurSideButton.setBackground(menuColorDefault);
		    	lblAgence.setForeground(Color.WHITE);
		    	
		    }
		    
		    @Override
		    public void mouseClicked(MouseEvent arg0) {
		    	panelAgenceMainContent.setVisible(true);
		    	panelAutocarMainContent.setVisible(false);
		    	panelChauffeurMainContent.setVisible(false);

		    }
		      
		});
		
		lblAgence = new JLabel("Agence");
		lblAgence.setBounds(0, 0, 199, 43);
		panelChauffeurSideButton.add(lblAgence);
		lblAgence.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAgence.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgence.setForeground(Color.WHITE);
		lblAgence.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 22));
		
		JPanel panelContentLayoutContainer = new JPanel();
		panelContentLayoutContainer.setBounds(198, 0, 569, 474);
		panelContentLayoutContainer.setBackground(new Color(0, 0, 20));

		frameFatherContainer.add(panelContentLayoutContainer);
		panelContentLayoutContainer.setLayout(null);
		
		panelChauffeurMainContent = new JPanel();
		panelChauffeurMainContent.setBorder(null);
		panelChauffeurMainContent.setBounds(10, 11, 549, 452);
		panelChauffeurMainContent.setBackground(menuColorDefault);
		panelContentLayoutContainer.add(panelChauffeurMainContent);
		panelChauffeurMainContent.setLayout(null);
		
		btnChauffeurAjouter = new JButton("Ajouter");
		btnChauffeurAjouter.setEnabled(false);
		
		btnChauffeurAjouter.setBounds(10, 340, 89, 23);
		panelChauffeurMainContent.add(btnChauffeurAjouter);
		
		btnChauffeurSupprimer = new JButton("Supprimer");
		btnChauffeurSupprimer.setEnabled(false);
		btnChauffeurSupprimer.setBounds(235, 340, 89, 23);
		panelChauffeurMainContent.add(btnChauffeurSupprimer);
		
		btnChauffeurModifier = new JButton("Modifier");
		btnChauffeurModifier.setEnabled(false);
		btnChauffeurModifier.setBounds(450, 340, 89, 23);
		panelChauffeurMainContent.add(btnChauffeurModifier);
		
		JLabel labelChauffeurTitle = new JLabel("Chauffeur");
		labelChauffeurTitle.setHorizontalTextPosition(SwingConstants.CENTER);
		labelChauffeurTitle.setHorizontalAlignment(SwingConstants.CENTER);
		labelChauffeurTitle.setForeground(Color.WHITE);
		labelChauffeurTitle.setFont(new Font("Segoe UI Semilight", Font.BOLD, 26));
		labelChauffeurTitle.setBounds(0, 0, 549, 43);
		panelChauffeurMainContent.add(labelChauffeurTitle);
		
		scrollPaneChauffeurHistoriqueTable = new JScrollPane();
		scrollPaneChauffeurHistoriqueTable.setBackground(Color.WHITE);
		scrollPaneChauffeurHistoriqueTable.setBounds(341, 54, 198, 275);
		panelChauffeurMainContent.add(scrollPaneChauffeurHistoriqueTable);
		
		tableChauffeurHistory = new JTable();
		tableChauffeurHistory.setBounds(342, 54, 197, 275);
		scrollPaneChauffeurHistoriqueTable.setViewportView(tableChauffeurHistory);
		
		scrollPaneChauffeurTable = new JScrollPane();
		scrollPaneChauffeurTable.setBackground(Color.WHITE);
		scrollPaneChauffeurTable.setBounds(10, 54, 330, 275);
		panelChauffeurMainContent.add(scrollPaneChauffeurTable);
		
		tableChauffeur = new JTable();
		tableChauffeur.setBackground(Color.WHITE);
		scrollPaneChauffeurTable.setViewportView(tableChauffeur);
		tableChauffeur.getSelectionModel().addListSelectionListener(new ListSelectionListener(){

			public void valueChanged(ListSelectionEvent arg0) {
				btnChauffeurModifier.setEnabled(true);
				btnChauffeurSupprimer.setEnabled(true);
				int indexSelected=tableChauffeur.getSelectedRow();
				if(((DefaultTableModel)tableChauffeur.getModel()).getColumnCount()>=1 && indexSelected>0) {
					String matricule= (String) ((DefaultTableModel)tableChauffeur.getModel()).getValueAt(indexSelected, 0);
					String nom= (String) ((DefaultTableModel)tableChauffeur.getModel()).getValueAt(indexSelected, 1);
					boolean conge= (Boolean) ((DefaultTableModel)tableChauffeur.getModel()).getValueAt(indexSelected, 2);
					
					txtFieldMatriculeChauffeur.setText(matricule);
					txtFieldNomChauffeur.setText(nom);
					tglbtnCongeChauffeur.setSelected(conge);
				}
				
			}
	    });
		colmunIds=new ArrayList<Integer>();
		btnChauffeurAjouter.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseClicked(MouseEvent e) {
				if(txtFieldNomChauffeur.getText().trim().length()>0 && txtFieldMatriculeChauffeur.getText().trim().length()>0) {
					Chauffeur.ajouter(c, new Chauffeur(txtFieldMatriculeChauffeur.getText(), txtFieldNomChauffeur.getText(),tglbtnCongeChauffeur.isSelected()));
					showChauffeurTables();
					txtFieldNomChauffeur.setText("");
					txtFieldMatriculeChauffeur.setText("");
					chauffeurTableClearSelection();
					
				}
				
				
			}
		});
		
		btnChauffeurModifier.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseClicked(MouseEvent e) {
				if(txtFieldNomChauffeur.getText().trim().length()>0 && txtFieldMatriculeChauffeur.getText().trim().length()>0) {
					
					//Chauffeur.Modifier(c, new Chauffeur(txtMatricule.getText(), txtNom.getText(),tglbtnConge.isSelected()));
					int indexSelected=tableChauffeur.getSelectedRow();
					//éChauffeur.supprimer(c, colmunIds.get(indexSelected));
					Chauffeur.modifier(c, new Chauffeur(txtFieldMatriculeChauffeur.getText(), txtFieldNomChauffeur.getText(),tglbtnCongeChauffeur.isSelected(), colmunIds.get(indexSelected)));
					showChauffeurTables();
					txtFieldNomChauffeur.setText("");
					txtFieldMatriculeChauffeur.setText("");
					chauffeurTableClearSelection();
					
				}
				
				
			}
		});
		txtFieldMatriculeChauffeur = new JTextField();
		txtFieldMatriculeChauffeur.setToolTipText("Matricule ici");
		txtFieldMatriculeChauffeur.setBounds(10, 396, 89, 23);
		txtFieldMatriculeChauffeur.addKeyListener(new KeyListener() {
			
			public void keyTyped(KeyEvent arg0) {
				System.out.println("txtNom");
				if(txtFieldNomChauffeur.getText().trim().length()>0 && txtFieldMatriculeChauffeur.getText().trim().length()>0){
					btnChauffeurAjouter.setEnabled(true);
				}else {
					btnChauffeurAjouter.setEnabled(false);
				}
				
			}
			
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void keyPressed(KeyEvent arg0) {
				
				
			}
		});
		panelChauffeurMainContent.add(txtFieldMatriculeChauffeur);
		txtFieldMatriculeChauffeur.setColumns(10);
		
		txtFieldNomChauffeur = new JTextField();
		txtFieldNomChauffeur.setToolTipText("Nom ici");
		txtFieldNomChauffeur.setColumns(10);
		txtFieldNomChauffeur.setBounds(109, 396, 89, 23);
		txtFieldNomChauffeur.addKeyListener(new KeyListener() {
			
			public void keyTyped(KeyEvent arg0) {
				System.out.println("txtNom");
				if(txtFieldNomChauffeur.getText().trim().length()>0 && txtFieldMatriculeChauffeur.getText().trim().length()>0) {
					btnChauffeurAjouter.setEnabled(true);
				}else {
					btnChauffeurAjouter.setEnabled(false);
				}
				
			}
			
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void keyPressed(KeyEvent arg0) {
				
				
			}
		});

		panelChauffeurMainContent.add(txtFieldNomChauffeur);
		
		tglbtnCongeChauffeur = new JToggleButton("conge");
		tglbtnCongeChauffeur.setBounds(209, 396, 75, 23);
		panelChauffeurMainContent.add(tglbtnCongeChauffeur);
		
		panelAutocarMainContent = new JPanel();
		panelAutocarMainContent.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		panelAutocarMainContent.setLayout(null);
		panelAutocarMainContent.setBackground(new Color(5, 5, 30));
		panelAutocarMainContent.setBounds(10, 11, 549, 452);
		panelContentLayoutContainer.add(panelAutocarMainContent);
		
		button = new JButton("Ajouter");
		button.setBounds(10, 396, 89, 23);
		panelAutocarMainContent.add(button);
		
		button_1 = new JButton("Supprimer");
		button_1.setEnabled(false);
		button_1.setBounds(155, 396, 89, 23);
		panelAutocarMainContent.add(button_1);
		
		button_2 = new JButton("Modifier");
		button_2.setEnabled(false);
		button_2.setBounds(305, 396, 89, 23);
		panelAutocarMainContent.add(button_2);
		
		button_3 = new JButton("Histoire");
		button_3.setEnabled(false);
		button_3.setBounds(450, 396, 89, 23);
		panelAutocarMainContent.add(button_3);
		
		lblAutocar_1 = new JLabel("Autocar");
		lblAutocar_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAutocar_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutocar_1.setForeground(Color.WHITE);
		lblAutocar_1.setFont(new Font("Segoe UI Semilight", Font.BOLD, 26));
		lblAutocar_1.setBounds(0, 0, 549, 43);
		panelAutocarMainContent.add(lblAutocar_1);
		
		table_1 = new JTable();
		table_1.setBounds(342, 54, 197, 275);
		panelAutocarMainContent.add(table_1);
		
		table_3 = new JTable();
		table_3.setBounds(10, 54, 330, 275);
		panelAutocarMainContent.add(table_3);
		
		panelAgenceMainContent = new JPanel();
		panelAgenceMainContent.setLayout(null);
		panelAgenceMainContent.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		panelAgenceMainContent.setBackground(new Color(5, 5, 30));
		panelAgenceMainContent.setBounds(10, 11, 549, 452);
		panelContentLayoutContainer.add(panelAgenceMainContent);
		
		button_4 = new JButton("Ajouter");
		button_4.setBounds(10, 396, 89, 23);
		panelAgenceMainContent.add(button_4);
		
		button_5 = new JButton("Supprimer");
		button_5.setEnabled(false);
		button_5.setBounds(155, 396, 89, 23);
		panelAgenceMainContent.add(button_5);
		
		button_6 = new JButton("Modifier");
		button_6.setEnabled(false);
		button_6.setBounds(305, 396, 89, 23);
		panelAgenceMainContent.add(button_6);
		
		button_7 = new JButton("Histoire");
		button_7.setEnabled(false);
		button_7.setBounds(450, 396, 89, 23);
		panelAgenceMainContent.add(button_7);
		
		label_1 = new JLabel("Agence");
		label_1.setHorizontalTextPosition(SwingConstants.CENTER);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Segoe UI Semilight", Font.BOLD, 26));
		label_1.setBounds(0, 0, 549, 43);
		panelAgenceMainContent.add(label_1);
		
		table_5 = new JTable();
		table_5.setBounds(10, 54, 529, 275);
		panelAgenceMainContent.add(table_5);

		btnChauffeurSupprimer.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseClicked(MouseEvent e) {
				int indexSelected=tableChauffeur.getSelectedRow();
				//System.out.println(data.get(indexSelected));
				String matricule= (String) ((DefaultTableModel)tableChauffeur.getModel()).getValueAt(indexSelected, 0);
				String nom= (String) ((DefaultTableModel)tableChauffeur.getModel()).getValueAt(indexSelected, 1);
				boolean conge= (Boolean) ((DefaultTableModel)tableChauffeur.getModel()).getValueAt(indexSelected, 2);
				Chauffeur.supprimer(c, new Chauffeur(matricule, nom,conge));
				showChauffeurTables();
				chauffeurTableClearSelection();
			}
		});
		
		showChauffeurTables();
	}
	
	public static DefaultTableModel buildTableModel(ResultSet rs)
	        throws SQLException {
		
	    ResultSetMetaData metaData = rs.getMetaData();

	    // names of columns
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 1; column <= columnCount; column++){
	    	if(column == 2){
	    		System.out.println("column"+column);
        	}else {
        		columnNames.add(metaData.getColumnName(column));
	        	System.out.print(metaData.getColumnName(column)+" ");
        	}
	        
	    }
	    
	    System.out.println();

	    // data of the table
	     data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex =1; columnIndex <= columnCount; columnIndex++) {
	        	if(columnIndex == 1){
		    		System.out.println("column"+columnIndex);
	        		colmunIds.add(Integer.valueOf((Integer) (rs.getObject(columnIndex))));
	        	}else {
	        		vector.add(rs.getObject(columnIndex));
		            System.out.print(rs.getObject(columnIndex)+" ");	
	        	}
	            
	        }
	        System.out.println();
	        data.add(vector);
	    }
	    System.out.println(data.toString());
	    System.out.println(columnNames.toString());
	    return new DefaultTableModel(data, columnNames);

	}
	
	private void makeDBConnection() {
		try {
			// load database driver
			Class.forName("org.gjt.mm.mysql.Driver");
			System.out.println("chargemet reussi !!");
			
			// establish database connection
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/voyage","root","");
			st = (Statement) c.createStatement();
				
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Faild to load the driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Faild to establish database connection");
			e.printStackTrace();
		}	
		
	}
	
	public void showChauffeurTables() {
		try {
			//System.out.println("rs.toString()="+rs.toString());
			myModel= buildTableModel(Chauffeur.selectAll(c, st));
			tableChauffeur.setModel(myModel);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	// role :en :clear selected chauffeur table row and set all chauffeur buttons to default
	void chauffeurTableClearSelection(){
		tableChauffeur.clearSelection();
		btnChauffeurAjouter.setEnabled(false);
		btnChauffeurModifier.setEnabled(false);
		btnChauffeurSupprimer.setEnabled(false);
	}
}
