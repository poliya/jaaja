package View;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JButton;
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
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mysql.jdbc.Statement;

import ModulController.AutoCar;
import ModulController.Chauffeur;
import ModulController.Ligne;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class Main {
	
	private static Vector<Vector<Object>> data;
	private static ArrayList<Integer> colmunIds;
	private JPanel frameFatherContainer;
	private JFrame frameGrandFatherContainer;
	private Color menuColorDefault;
	private JLabel lblAutocar_1;
	private JLabel label_1;
	private Connection c;
	private Statement st;
	private JPanel panelSideLayoutContainer;
	private JPanel panelContentLayoutContainer;
	
//chauffeuur
	private JPanel panelChauffeurSideButton;
	private JPanel panelChauffeurMainContent;
	private JTable tableChauffeurHistory;
	private JTable tableChauffeur;
	private JLabel labelSideChauffeurTitle;
	private JScrollPane scrollPaneChauffeurTable;
	private JTextField txtFieldMatriculeChauffeur;
	private JTextField txtFieldNomChauffeur;
	private TableModel myModel;
	private JButton btnChauffeurModifier;
	private Component btnChauffeurSupprimer;
	private Component btnChauffeurAjouter;
	private JToggleButton tglbtnCongeChauffeur;
	private JScrollPane scrollPaneChauffeurHistoriqueTable;
    //autocar
	private JTable tableAutocarHistory;
	private JPanel panelAutocarMainContent;
	private JPanel panelAutocarSideButton;
	private JTextField txtFieldNumimmatriculAutocar;
	private JTextField txtFieldEtatAutocar;
	private JScrollPane scrollPaneAutocarHistoriqueTable;
	private JScrollPane scrollPaneAutocarTable;
	private JButton btnAutocarModifier;
	private Component btnAutocarSupprimer;
	private Component btnAutocarAjouter;
	private JTable tableAutocar;
	private JLabel labelSideCarTitle;

	//Agence
	private JButton btnAgenceModifier;
	private Component btnAgenceAjouter;
	private JTable tableAgence;
	private JPanel panelAgenceSideButton;
	private JPanel panelAgenceMainContent;
	private JLabel labelSideAgenceTitle;
	private JTextField txtFieldNomAgence;
	private JTextField txtFieldVilleAgence;
	private JScrollPane scrollPanAgenceTable;
	//end
//ligne
	private JButton btnLigneModifier;
	private Component btnLigneAjouter;
	private JTable tableLigne;
	private JPanel panelLigneSideButton;
	private JPanel panelLigneMainContent;
	private JLabel labelSideLigneTitle;
	private JTextField txtFieldheureRetourLigne;
	private JTextField txtFieldheuredallerLigne;
	private JTextField txtFieldKilometrageLigne;
	private JTextField txtFielddureereposLigne;
	private JTextField txtFielddureeimmobiliLigne;
	private JTextField txtFieldIdLigne;
	private JScrollPane scrollPanLigneTable;
	private JScrollPane scrollPaneLigneHistoriqueTable;
	private JTextField textField;
	/**
	 * 
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
	public Main(){
		makeDBConnection();
		initialize();
	}

	void definingColorObjects(){
		menuColorDefault=new Color(05, 05, 30);
	}
	
	void setFrameGrandFatherContainer() {
		frameGrandFatherContainer = new JFrame();
		frameGrandFatherContainer.setBounds(100, 100, 773, 503);
		frameGrandFatherContainer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameGrandFatherContainer.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		frameGrandFatherContainer.setResizable(false);
	}
	
	void setFrameFatherContainer() {
		frameFatherContainer = new JPanel();
		frameGrandFatherContainer.getContentPane().add(frameFatherContainer);
		frameFatherContainer.setLayout(null);
	}
	
	//	opening -> Left Layout
	void setPanelSideLayoutContainer() {
		
		panelSideLayoutContainer = new JPanel();
		panelSideLayoutContainer.setBounds(0, 0, 199, 474);
		panelSideLayoutContainer.setBackground(new Color(0, 0, 25));
		frameFatherContainer.add(panelSideLayoutContainer);
		panelSideLayoutContainer.setLayout(null);
		
		panelAutocarSideButton = new JPanel();
		panelAutocarSideButton.setBackground(menuColorDefault);
		panelAutocarSideButton.setBounds(0, 163, 199, 43);
		panelSideLayoutContainer.add(panelAutocarSideButton);
		panelAutocarSideButton.setLayout(null);
		
		labelSideChauffeurTitle = new JLabel("Chauffeur");
		labelSideChauffeurTitle.setBounds(0, 0, 199, 43);
		panelAutocarSideButton.add(labelSideChauffeurTitle);
		labelSideChauffeurTitle.setHorizontalTextPosition(SwingConstants.CENTER);
		labelSideChauffeurTitle.setHorizontalAlignment(SwingConstants.CENTER);
		labelSideChauffeurTitle.setForeground(Color.WHITE);
		labelSideChauffeurTitle.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 22));
		
		panelAutocarSideButton.addMouseListener(new java.awt.event.MouseAdapter() {
			
			
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	panelAutocarSideButton.setBackground(Color.WHITE);
		    	labelSideChauffeurTitle.setForeground(Color.BLACK);
		    	
		    	
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	panelAutocarSideButton.setBackground(menuColorDefault);
		    	labelSideChauffeurTitle.setForeground(Color.WHITE);
		    	
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
		    	labelSideCarTitle.setForeground(Color.BLACK);
		    	
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	panelAgenceSideButton.setBackground(menuColorDefault);
		    	labelSideCarTitle.setForeground(Color.WHITE);
		    	
		    }
		    @Override
		    public void mouseClicked(MouseEvent arg0) {
		    	panelAgenceMainContent.setVisible(false);
		    	panelAutocarMainContent.setVisible(true);
		    	panelChauffeurMainContent.setVisible(false);

		    }
		});
		
		labelSideCarTitle = new JLabel("AutoCar");
		labelSideCarTitle.setBounds(0, 0, 199, 43);
		panelAgenceSideButton.add(labelSideCarTitle);
		labelSideCarTitle.setForeground(Color.WHITE);
		labelSideCarTitle.setHorizontalAlignment(SwingConstants.CENTER);
		labelSideCarTitle.setHorizontalTextPosition(SwingConstants.CENTER);
		labelSideCarTitle.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 22));
		
		panelChauffeurSideButton = new JPanel();
		panelChauffeurSideButton.setLayout(null);
		panelChauffeurSideButton.setBackground(menuColorDefault);
		panelChauffeurSideButton.setBounds(0, 255, 199, 43);
		panelSideLayoutContainer.add(panelChauffeurSideButton);
		//panel chaufeur
		panelChauffeurSideButton.addMouseListener(new java.awt.event.MouseAdapter() {
			
			
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	panelChauffeurSideButton.setBackground(Color.WHITE);
		    	labelSideAgenceTitle.setForeground(Color.BLACK);
		    	
		    	
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	panelChauffeurSideButton.setBackground(menuColorDefault);
		    	labelSideAgenceTitle.setForeground(Color.WHITE);
		    	
		    }
		    
		    @Override
		    public void mouseClicked(MouseEvent arg0) {
		    	panelAgenceMainContent.setVisible(true);
		    	panelAutocarMainContent.setVisible(false);
		    	panelChauffeurMainContent.setVisible(false);

		    }
		      
		});
		//panel autocar

		
		labelSideAgenceTitle = new JLabel("Agence");
		labelSideAgenceTitle.setBounds(0, 0, 199, 43);
		panelChauffeurSideButton.add(labelSideAgenceTitle);
		labelSideAgenceTitle.setHorizontalTextPosition(SwingConstants.CENTER);
		labelSideAgenceTitle.setHorizontalAlignment(SwingConstants.CENTER);
		labelSideAgenceTitle.setForeground(Color.WHITE);
		labelSideAgenceTitle.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 22));
		
		
	}
	
	// 	closing -> Left Layout 
	
	//	opening -> Right Layout//////////////////////////////////////////////////////////////////////////////////////////////
	void setPanelContentLayoutContainer() {
		// 	TODO :don't touch ,this auto-generate code
		// TODO :ne pas toucher its the general layout 
		panelContentLayoutContainer = new JPanel();
		panelContentLayoutContainer.setBounds(198, 0, 569, 474);
		panelContentLayoutContainer.setBackground(new Color(0, 0, 20));
		frameFatherContainer.add(panelContentLayoutContainer);
		panelContentLayoutContainer.setLayout(null);
		//end of it
		//executer ici les fonctions
		setPanelChauffeurMainContent();
		setPanelAutocarMainContent();
		setPanelAgenceMainContent();
		setPaneligneMainContent();
		
	}
	void setPanelChauffeurMainContent() {
		panelChauffeurMainContent = new JPanel();
		panelChauffeurMainContent.setBorder(new LineBorder(Color.WHITE, 1, true));
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
		scrollPaneChauffeurHistoriqueTable.setBounds(341, 99, 198, 230);
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
		//btnChauffeurModifier
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
		
		textField = new JTextField();
		textField.setBounds(412, 52, 86, 20);
		panelChauffeurMainContent.add(textField);
		textField.setColumns(10);
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
	///////////////////////////////////////////////////***********************panel aotocar start
	void setPanelAutocarMainContent() {
		panelAutocarMainContent = new JPanel();
		panelAutocarMainContent.setBorder(new LineBorder(Color.WHITE, 1, true));
		panelAutocarMainContent.setBounds(10, 11, 549, 452);
		panelAutocarMainContent.setBackground(menuColorDefault);
		panelContentLayoutContainer.add(panelAutocarMainContent);
		panelAutocarMainContent.setLayout(null);
		
		btnAutocarAjouter = new JButton("Ajouter");
		btnAutocarAjouter.setEnabled(false);
		
		btnAutocarAjouter.setBounds(10, 340, 89, 23);
		panelAutocarMainContent.add(btnAutocarAjouter);
		
		btnAutocarSupprimer = new JButton("Supprimer");
		btnAutocarSupprimer.setEnabled(false);
		btnAutocarSupprimer.setBounds(235, 340, 89, 23);
		panelAutocarMainContent.add(btnAutocarSupprimer);
		
		btnAutocarModifier = new JButton("Modifier");
		btnAutocarModifier.setEnabled(false);
		btnAutocarModifier.setBounds(450, 340, 89, 23);
		panelAutocarMainContent.add(btnAutocarModifier);
		
		JLabel labelAutocarTitle = new JLabel("Autocar");
		labelAutocarTitle.setHorizontalTextPosition(SwingConstants.CENTER);
		labelAutocarTitle.setHorizontalAlignment(SwingConstants.CENTER);
		labelAutocarTitle.setForeground(Color.WHITE);
		labelAutocarTitle.setFont(new Font("Segoe UI Semilight", Font.BOLD, 26));
		labelAutocarTitle.setBounds(0, 0, 549, 43);
		panelAutocarMainContent.add(labelAutocarTitle);
		
		scrollPaneAutocarHistoriqueTable = new JScrollPane();
		scrollPaneAutocarHistoriqueTable.setBackground(Color.WHITE);
		scrollPaneAutocarHistoriqueTable.setBounds(341, 54, 198, 275);
		panelAutocarMainContent.add(scrollPaneAutocarHistoriqueTable);
		
		tableAutocarHistory = new JTable();
		tableAutocarHistory.setBounds(342, 54, 197, 275);
		scrollPaneAutocarHistoriqueTable.setViewportView(tableAutocarHistory);
		
		scrollPaneAutocarTable = new JScrollPane();
		scrollPaneAutocarTable.setBackground(Color.WHITE);
		scrollPaneAutocarTable.setBounds(10, 54, 330, 275);
		panelAutocarMainContent.add(scrollPaneAutocarTable);
		tableAutocar = new JTable();
		tableAutocar.setBackground(Color.WHITE);
		scrollPaneAutocarTable.setViewportView(tableAutocar);
		tableAutocar.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent arg0) {
				btnAutocarModifier.setEnabled(true);
				btnAutocarSupprimer.setEnabled(true);
				int indexSelected=tableAutocar.getSelectedRow();
				if(((DefaultTableModel)tableAutocar.getModel()).getColumnCount()>=1 && indexSelected>0) {
					String matricule= (String) ((DefaultTableModel)tableAutocar.getModel()).getValueAt(indexSelected, 0);
					String nom= (String) ((DefaultTableModel)tableAutocar.getModel()).getValueAt(indexSelected, 1);
					boolean conge= (Boolean) ((DefaultTableModel)tableAutocar.getModel()).getValueAt(indexSelected, 2);
					
					txtFieldEtatAutocar.setText(matricule);
					txtFieldNumimmatriculAutocar.setText(nom);
				}
				
			}
	    });
		
		colmunIds=new ArrayList<Integer>();
		btnAutocarAjouter.addMouseListener(new MouseListener() {
			
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
				if(txtFieldNumimmatriculAutocar.getText().trim().length()>0 && txtFieldEtatAutocar.getText().trim().length()>0) {
					showAutocarTables();
					txtFieldNumimmatriculAutocar.setText("");
					txtFieldEtatAutocar.setText("");
					AutoCarTableClearSelection();
					
				}
				
				
			}
		});
		//btnAutocarModifier
		btnAutocarModifier.addMouseListener(new MouseListener() {
			
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
				if(txtFieldNumimmatriculAutocar.getText().trim().length()>0 && txtFieldEtatAutocar.getText().trim().length()>0) {
					
					//AutoCar.Modifier(c, new AutoCar(txtMatricule.getText(), txtNom.getText(),tglbtnConge.isSelected()));
					int indexSelected=tableAutocar.getSelectedRow();
					//éAutoCar.supprimer(c, colmunIds.get(indexSelected));
					AutoCar.modifier(c, new AutoCar("null", Integer.valueOf(txtFieldNumimmatriculAutocar.getText(), colmunIds.get(indexSelected)));
					showAutocarTables();
					txtFieldNumimmatriculAutocar.setText("");
					txtFieldEtatAutocar.setText("");
					AutoCarTableClearSelection();
					
				}
				
				
			}
		});
		txtFieldEtatAutocar = new JTextField();
		txtFieldEtatAutocar.setToolTipText("Matricule ici");
		txtFieldEtatAutocar.setBounds(10, 396, 89, 23);
		txtFieldEtatAutocar.addKeyListener(new KeyListener() {
			
			public void keyTyped(KeyEvent arg0) {
				System.out.println("txtNom");
				if(txtFieldNumimmatriculAutocar.getText().trim().length()>0 && txtFieldEtatAutocar.getText().trim().length()>0){
					btnAutocarAjouter.setEnabled(true);
				}else {
					btnAutocarAjouter.setEnabled(false);
				}
				
			}
			
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void keyPressed(KeyEvent arg0) {
				
				
			}
		});
		panelAutocarMainContent.add(txtFieldEtatAutocar);
		txtFieldEtatAutocar.setColumns(10);
		
		txtFieldNumimmatriculAutocar = new JTextField();
		txtFieldNumimmatriculAutocar.setToolTipText("Nom ici");
		txtFieldNumimmatriculAutocar.setColumns(10);
		txtFieldNumimmatriculAutocar.setBounds(109, 396, 89, 23);
		txtFieldNumimmatriculAutocar.addKeyListener(new KeyListener() {
			
			public void keyTyped(KeyEvent arg0) {
				System.out.println("txtNom");
				if(txtFieldEtatAutocar.getText().trim().length()>0 && txtFieldEtatAutocar.getText().trim().length()>0) {
					btnAutocarAjouter.setEnabled(true);
				}else {
					btnAutocarAjouter.setEnabled(false);
				}
				
			}
			
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void keyPressed(KeyEvent arg0) {
				
				
			}
		});

		panelAutocarMainContent.add(txtFieldNumimmatriculAutocar);
		
		
		btnAutocarSupprimer.addMouseListener(new MouseListener() {
			
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
				int indexSelected=tableAutocar.getSelectedRow();
				//System.out.println(data.get(indexSelected));
				String matricule= (String) ((DefaultTableModel)tableAutocar.getModel()).getValueAt(indexSelected, 0);
				String nom= (String) ((DefaultTableModel)tableAutocar.getModel()).getValueAt(indexSelected, 1);
				boolean conge= (Boolean) ((DefaultTableModel)tableAutocar.getModel()).getValueAt(indexSelected, 2);
				AutoCar.supprimer(c, new AutoCar(nImmatriculation,etat));
				showAutocarTables();
				AutoCarTableClearSelection();
			}
		});

	showAutocarTables();
	}
	

	//end of aotocar table
	///////////////////////////////////////////////////***********************panel Ligne start
	void setPaneligneMainContent() {
		panelLigneMainContent = new JPanel();
		panelLigneMainContent.setBorder(new LineBorder(Color.WHITE, 1, true));
		panelLigneMainContent.setBounds(10, 11, 549, 452);
		panelLigneMainContent.setBackground(menuColorDefault);
		panelContentLayoutContainer.add(panelLigneMainContent);
		panelLigneMainContent.setLayout(null);
		
		btnLigneAjouter = new JButton("Ajouter");
		btnLigneAjouter.setEnabled(false);
		
		btnLigneAjouter.setBounds(10, 340, 89, 23);
		panelLigneMainContent.add(btnLigneAjouter);
		
	
		panelLigneMainContent.add(btnAutocarSupprimer);
		
		btnLigneModifier = new JButton("Modifier");
		btnLigneModifier.setEnabled(false);
		btnLigneModifier.setBounds(450, 340, 89, 23);
		panelLigneMainContent.add(btnLigneModifier);
		
		JLabel labelLigneTitle = new JLabel("Ligne");
		labelLigneTitle.setHorizontalTextPosition(SwingConstants.CENTER);
		labelLigneTitle.setHorizontalAlignment(SwingConstants.CENTER);
		labelLigneTitle.setForeground(Color.WHITE);
		labelLigneTitle.setFont(new Font("Segoe UI Semilight", Font.BOLD, 26));
		labelLigneTitle.setBounds(0, 0, 549, 43);
		panelLigneMainContent.add(labelLigneTitle);
		
		scrollPaneLigneHistoriqueTable = new JScrollPane();
		scrollPaneLigneHistoriqueTable.setBackground(Color.WHITE);
		scrollPaneLigneHistoriqueTable.setBounds(341, 54, 198, 275);
		panelLigneMainContent.add(scrollPaneLigneHistoriqueTable);
		
		tableligneHistory = new JTable();
		tableligneHistory.setBounds(342, 54, 197, 275);
		scrollPaneLigneHistoriqueTable.setViewportView(tableligneHistory);
		
		scrollPanLigneTable = new JScrollPane();
		scrollPanLigneTable.setBackground(Color.WHITE);
		scrollPanLigneTable.setBounds(10, 54, 330, 275);
		panelLigneMainContent.add(scrollPanLigneTable);
		tableLigne = new JTable();
		tableLigne.setBackground(Color.WHITE);
		scrollPanLigneTable.setViewportView(tableLigne);
		tableLigne.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent arg0) {
				btnLigneModifier.setEnabled(true);
				int indexSelected=tableLigne.getSelectedRow();
				if(((DefaultTableModel)tableLigne.getModel()).getColumnCount()>=1 && indexSelected>0) {
					String matricule= (String) ((DefaultTableModel)tableLigne.getModel()).getValueAt(indexSelected, 0);
					String nom= (String) ((DefaultTableModel)tableLigne.getModel()).getValueAt(indexSelected, 1);
					boolean conge= (Boolean) ((DefaultTableModel)tableLigne.getModel()).getValueAt(indexSelected, 2);
					
					txtFieldheureRetourLigne.setText(matricule);
					txtFieldIdLigne.setText(nom);
				}
				
			}
	    });
		
		colmunIds=new ArrayList<Integer>();
		btnLigneAjouter.addMouseListener(new MouseListener() {
			
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
				if(txtFieldIdLigne.getText().trim().length()>0 
				&& txtFieldheureRetourLigne.getText().trim().length()>0
				&& txtFieldKilometrageLigne.getText().trim().length()>0
				&& txtFielddureeimmobiliLigne.getText().trim().length()>0
				&& txtFieldheuredallerLigne.getText().trim().length()>0) {
					Ligne.ajouter(c, new Ligne(txtFieldheureRetourLigne.getText(), txtFieldIdLigne.getText()));
					showLigneTables();
					txtFieldIdLigne.setText("");
					txtFieldheureRetourLigne.setText("");
					LingneTableClearSelection();
					
				}
				
				
			}
		});
		//btnLigneModifier
		btnLigneModifier.addMouseListener(new MouseListener() {
			
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
				if(txtFieldIdLigne.getText().trim().length()>0 && txtFieldheureRetourLigne.getText().trim().length()>0) {
					
					//Ligne.Modifier(c, new Ligne(txtMatricule.getText(), txtNom.getText(),tglbtnConge.isSelected()));
					int indexSelected=tableLigne.getSelectedRow();
					//éLigne.supprimer(c, colmunIds.get(indexSelected));
					showLigneTables();
					txtFieldIdLigne.setText("");
					txtFieldheureRetourLigne.setText("");
					LingneTableClearSelection();
					
				}
				
				
			}
		});
		txtFieldheureRetourLigne = new JTextField();
		txtFieldheureRetourLigne.setToolTipText("Matricule ici");
		txtFieldheureRetourLigne.setBounds(10, 396, 89, 23);
		txtFieldheureRetourLigne.addKeyListener(new KeyListener() {
			
			public void keyTyped(KeyEvent arg0) {
				System.out.println("txtNom");
				if(txtFieldIdLigne.getText().trim().length()>0 && txtFieldheureRetourLigne.getText().trim().length()>0){
					btnLigneAjouter.setEnabled(true);
				}else {
					btnLigneAjouter.setEnabled(false);
				}
				
			}
			
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void keyPressed(KeyEvent arg0) {
				
				
			}
		});
		panelLigneMainContent.add(txtFieldheureRetourLigne);
		txtFieldheureRetourLigne.setColumns(10);
		
		txtFieldIdLigne = new JTextField();
		txtFieldIdLigne.setToolTipText("Nom ici");
		txtFieldIdLigne.setColumns(10);
		txtFieldIdLigne.setBounds(109, 396, 89, 23);
		txtFieldIdLigne.addKeyListener(new KeyListener() {
			
			public void keyTyped(KeyEvent arg0) {
				System.out.println("txtNom");
				if(txtFieldheureRetourLigne.getText().trim().length()>0 && txtFieldheureRetourLigne.getText().trim().length()>0) {
					btnLigneAjouter.setEnabled(true);
				}else {
					btnLigneAjouter.setEnabled(false);
				}
				
			}
			
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void keyPressed(KeyEvent arg0) {
				
				
			}
		});

		panelLigneMainContent.add(txtFieldIdLigne);
		
		
	
	showLigneTables();
	}
	
	
	///////////////////////******************************************agenceSetpann*************************/////////////
	void setPanelAgenceMainContent() {
		panelAgenceMainContent = new JPanel();
	panelAgenceMainContent.setBorder(new LineBorder(Color.WHITE, 1, true));
	panelAgenceMainContent.setBounds(10, 11, 549, 452);
	panelAgenceMainContent.setBackground(menuColorDefault);
	panelContentLayoutContainer.add(panelAgenceMainContent);
	panelAgenceMainContent.setLayout(null);
	
	btnAgenceAjouter = new JButton("Ajouter");
	btnAgenceAjouter.setEnabled(false);
	
	btnAgenceAjouter.setBounds(10, 340, 89, 23);
	panelAgenceMainContent.add(btnAgenceAjouter);
	
	btnAutocarSupprimer = new JButton("Supprimer");
	btnAutocarSupprimer.setEnabled(false);
	btnAutocarSupprimer.setBounds(235, 340, 89, 23);
	panelAgenceMainContent.add(btnAutocarSupprimer);
	
	btnAgenceModifier = new JButton("Modifier");
	btnAgenceModifier.setEnabled(false);
	btnAgenceModifier.setBounds(450, 340, 89, 23);
	panelAgenceMainContent.add(btnAgenceModifier);
	
	JLabel labelAgenceTitle = new JLabel("Agence");
	labelAgenceTitle.setHorizontalTextPosition(SwingConstants.CENTER);
	labelAgenceTitle.setHorizontalAlignment(SwingConstants.CENTER);
	labelAgenceTitle.setForeground(Color.WHITE);
	labelAgenceTitle.setFont(new Font("Segoe UI Semilight", Font.BOLD, 26));
	labelAgenceTitle.setBounds(0, 0, 549, 43);
	panelAgenceMainContent.add(labelAgenceTitle);
	
	
	scrollPanAgenceTable = new JScrollPane();
	scrollPanAgenceTable.setBackground(Color.WHITE);
	scrollPanAgenceTable.setBounds(10, 54, 330, 275);
	panelAgenceMainContent.add(scrollPanAgenceTable);
	tableAgence = new JTable();
	tableAgence.setBackground(Color.WHITE);
	scrollPanAgenceTable.setViewportView(tableAgence);
	tableAgence.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
		public void valueChanged(ListSelectionEvent arg0) {
			btnAgenceModifier.setEnabled(true);
			int indexSelected=tableAgence.getSelectedRow();
			if(((DefaultTableModel)tableAgence.getModel()).getColumnCount()>=1 && indexSelected>0) {
				String matricule= (String) ((DefaultTableModel)tableAgence.getModel()).getValueAt(indexSelected, 0);
				String nom= (String) ((DefaultTableModel)tableAgence.getModel()).getValueAt(indexSelected, 1);
				boolean conge= (Boolean) ((DefaultTableModel)tableAgence.getModel()).getValueAt(indexSelected, 2);
				
				txtFieldVilleAgence.setText(matricule);
				txtFieldNomAgence.setText(nom);
			}
			
		}
    });
	
	colmunIds=new ArrayList<Integer>();
	btnAgenceAjouter.addMouseListener(new MouseListener() {
		
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
			if(txtFieldNomAgence.getText().trim().length()>0 && txtFieldVilleAgence.getText().trim().length()>0) {
				Agence.ajouter(c, new Agence(txtFieldVilleAgence.getText(), txtFieldNomAgence.getText(),tglbtnCongeAgence.isSelected()));
				showAgenceTables();
				txtFieldNomAgence.setText("");
				txtFieldVilleAgence.setText("");
				AgenceTableClearSelection();
				
			}
			
			
		}
	});
	//btnAgenceModifier
	btnAgenceModifier.addMouseListener(new MouseListener() {
		
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
			if(txtFieldNomAgence.getText().trim().length()>0 && txtFieldVilleAgence.getText().trim().length()>0) {
				
				//Agence.Modifier(c, new Agence(txtMatricule.getText(), txtNom.getText(),tglbtnConge.isSelected()));
				int indexSelected=tableAgence.getSelectedRow();
				//éAgence.supprimer(c, colmunIds.get(indexSelected));
				Agence.modifier(c, new Agence(txtFieldVilleAgence.getText(), txtFieldNomAgence.getText(), colmunIds.get(indexSelected)));
				showAgenceTables();
				txtFieldNomAgence.setText("");
				txtFieldVilleAgence.setText("");
				AgenceTableClearSelection();
				
			}
			
			
		}
	});
	txtFieldVilleAgence = new JTextField();
	txtFieldVilleAgence.setToolTipText("Matricule ici");
	txtFieldVilleAgence.setBounds(10, 396, 89, 23);
	txtFieldVilleAgence.addKeyListener(new KeyListener() {
		
		public void keyTyped(KeyEvent arg0) {
			System.out.println("txtNom");
			if(txtFieldNomAgence.getText().trim().length()>0 && txtFieldVilleAgence.getText().trim().length()>0){
				btnAgenceAjouter.setEnabled(true);
			}else {
				btnAgenceAjouter.setEnabled(false);
			}
			
		}
		
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		public void keyPressed(KeyEvent arg0) {
			
			
		}
	});
	panelAgenceMainContent.add(txtFieldVilleAgence);
	txtFieldVilleAgence.setColumns(10);
	
	txtFieldNomAgence = new JTextField();
	txtFieldNomAgence.setToolTipText("Nom ici");
	txtFieldNomAgence.setColumns(10);
	txtFieldNomAgence.setBounds(109, 396, 89, 23);
	txtFieldNomAgence.addKeyListener(new KeyListener() {
		
		public void keyTyped(KeyEvent arg0) {
			System.out.println("txtNom");
			if(txtFieldVilleAgence.getText().trim().length()>0 && txtFieldVilleAgence.getText().trim().length()>0) {
				btnAgenceAjouter.setEnabled(true);
			}else {
				btnAgenceAjouter.setEnabled(false);
			}
			
		}
		
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		public void keyPressed(KeyEvent arg0) {
			
			
		}
	});

	panelAgenceMainContent.add(txtFieldNomAgence);
	
	

showAgenceTables();
}

	

	///////////////////////////////////////////////////////////////////*****************//////////////////////////////////
	//void setPanelChauffeurMainContent() {}
	// 	closing -> Right Layout 
	
	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		definingColorObjects();
		
		// TODO :don't touch, this auto generated code
		setFrameGrandFatherContainer();
		setFrameFatherContainer();
		
		// role : en:set and display Side Layout elements
		// role : fr:mettre et afficher Menu Layout elements
		setPanelSideLayoutContainer();
		
		// role : en:set and display Content Layout elements
		// role : fr:mettre et afficher jTable(center) Layout elements
		setPanelContentLayoutContainer();
		

	}
	
	// role : en: transform ResultSet into DefaultTableModel
	public static DefaultTableModel buildTableModel(ResultSet rs)
	        throws SQLException {
		
	    ResultSetMetaData metaData = rs.getMetaData();

	    // names of columns
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 1; column <= columnCount; column++){
	    	if(column == 1){
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
	// role :en :establish connection with the database
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
	
	// role :en :display chauffeur table content from database in chauffeur table
	//affichage table chauffeur
	//SOS////////////SOS////////////////////////////////////////////**********//////////////////////////////
	public void showChauffeurTables() {
		try {
			myModel= buildTableModel(Chauffeur.selectAll(c, st));
			tableChauffeur.setModel(myModel);			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
///autocar show table
	public void showAutocarTables() {
		try {
			myModel= buildTableModel(AutoCar.selectAll(c, st));
			tableAutocar.setModel(myModel);			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	////agence table
	public void showAgenceTables() {
		try {
			myModel= buildTableModel(Agence.selectAll(c, st));
			tableAgence.setModel(myModel);			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
////Ligne Show  table
	public void showLigneTables() {
		try {
			myModel= buildTableModel(Ligne.selectAll(c, st));
			tableLigne.setModel(myModel);			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	// role :en :clear selected chauffeur table row and set all chauffeur buttons to default
	// LE ROLE/ KATRED LES BUTTON PAR DEFAUT 
	////////////////////// aji hena//////////////////////////////////////////////////////////////////////
	void chauffeurTableClearSelection(){
		tableChauffeur.clearSelection();
		btnChauffeurAjouter.setEnabled(false);
		btnChauffeurModifier.setEnabled(false);
		btnChauffeurSupprimer.setEnabled(false);
	}
////autocar enabled button/////////////////////////////
	void AutoCarTableClearSelection(){
		tableAutocar.clearSelection();
		btnAutocarAjouter.setEnabled(false);
		btnAutocarModifier.setEnabled(false);
		btnAutocarSupprimer.setEnabled(false);
	}
////Agennce enabled button/////////////////////////////

	void AgenceTableClearSelection(){
		tableAgence.clearSelection();
		btnAgenceAjouter.setEnabled(false);
		btnAgenceModifier.setEnabled(false);
	}
////LIgne enabled button/////////////////////////////

	void LingneTableClearSelection(){
		tableLigne.clearSelection();
		btnLigneAjouter.setEnabled(false);
		btnLigneModifier.setEnabled(false);
	}
}
