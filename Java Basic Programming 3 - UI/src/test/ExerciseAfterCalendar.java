package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExerciseAfterCalendar extends JFrame {

	private JPanel contentPane;
	private JPanel contentPane2;
	private JTextField txtMessage;
	private JFrame frame2;
	private JLabel lable;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExerciseAfterCalendar frame = new ExerciseAfterCalendar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void nextWindow(){
		frame2 = new JFrame();
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setBounds(150, 150, 300, 200);
		frame2.setVisible(true);
		String message = txtMessage.getText();
		lblNewLabel = new JLabel();
		lblNewLabel.setBounds(10, 10, 56, 16);
		contentPane2 = new JPanel();
		contentPane2.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane2);
		contentPane2.setLayout(null);
		contentPane2.add(lblNewLabel);
		
	}
	private String message;
	/**
	 * Create the frame.
	 */
	public ExerciseAfterCalendar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		txtMessage = new JTextField();
		txtMessage.setBounds(135, 56, 116, 22);
		contentPane.add(txtMessage);
		txtMessage.setColumns(10);
		
		JButton btnWindow = new JButton("Click me!");
		btnWindow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nextWindow();
				message = txtMessage.getText();
			}
		});
		btnWindow.setBounds(146, 142, 97, 25);
		contentPane.add(btnWindow);
		
		
		
		
	}

}
