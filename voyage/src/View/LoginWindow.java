package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.SwingConstants;

public class LoginWindow {

	private JFrame frame;
	private JPanel panel;
	private JTextField textField_1;
	private JLabel lblLogin;
	private JTextField textField;
	private JLabel lblPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow window = new LoginWindow();
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
	public LoginWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(1, 0, 426, 261);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblLogin = new JLabel("Login");
		lblLogin.setBounds(149, 105, 46, 14);
		panel.add(lblLogin);
		
		JLabel label = new JLabel("Gestion Voyages");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setBounds(0, 0, 426, 129);
		label.setToolTipText("");
		label.setFont(new Font("Yu Gothic Light", Font.PLAIN, 28));
		panel.add(label);
		
		textField_1 = new JTextField();
		textField_1.setBounds(148, 121, 133, 20);
		textField_1.setColumns(10);
		panel.add(textField_1);
		
		JButton btnConnecter = new JButton("connecter");
		btnConnecter.setBounds(158, 186, 108, 32);
		btnConnecter.setAlignmentY(0.0f);
		panel.add(btnConnecter);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(148, 156, 133, 20);
		panel.add(textField);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(149, 140, 46, 14);
		panel.add(lblPassword);
		btnConnecter.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new MainPage();
				frame.dispose();
			}
		});
	}
}
