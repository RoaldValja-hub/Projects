package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class Authenticator extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	private String UsernameCorrect = "Roald";
	private char[] PasswordCorrect = {'v','ä','l','j','a'};
	private Authenticator frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Authenticator frame = new Authenticator();
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
	public Authenticator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(24, 32, 69, 16);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(24, 61, 56, 16);
		contentPane.add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(105, 29, 116, 22);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtUsername.getText().equals(UsernameCorrect)&& Arrays.equals(passwordField.getPassword(), PasswordCorrect)){
					JOptionPane.showMessageDialog(frame, "Successful login");
				} else {
					JOptionPane.showMessageDialog(frame, "Invalid username or password");
				}
			}
		});
		btnLogin.setBounds(207, 114, 97, 25);
		contentPane.add(btnLogin);
		
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(105, 58, 116, 22);
		contentPane.add(passwordField);
		final char deffer = passwordField.getEchoChar();
		
		JCheckBox chckbxVisible = new JCheckBox("Visible");
		chckbxVisible.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxVisible.isSelected()){
					passwordField.setEchoChar((char) 0);
				} else {
					passwordField.setEchoChar(deffer);
				}
			}
		});
		chckbxVisible.setBounds(260, 57, 113, 25);
		contentPane.add(chckbxVisible);
		
		
	}
}
