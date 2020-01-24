package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;

public class Slideshow extends JFrame {

	private JPanel contentPane;
	private int imageID;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Slideshow frame = new Slideshow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void changeImage(boolean forward){
		if(forward){imageID = imageID+1;} else {imageID = imageID-1;}
		
		if(imageID<1) {imageID=5;}
		if(imageID>5) {imageID=1;}
		ImageIcon img = new ImageIcon("D:\\javaprogrammeerimine\\Lõputöö\\UI\\src\\images\\image" + imageID + ".jpg");
		
		Image image = img.getImage();
		Image newimg = image.getScaledInstance(360, 240, java.awt.Image.SCALE_SMOOTH);
		img = new ImageIcon(newimg);
		
		lblNewLabel.setIcon(img);
	}

	/**
	 * Create the frame.
	 */
	public Slideshow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		ActionListener carossell = new ActionListener() {
			public void actionPerformed(ActionEvent e){
				changeImage(true);
			}
		};
		
		final Timer t = new Timer(2000, carossell);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imageID = 1;
				changeImage(true);
			}
		});
		btn1.setBounds(40, 313, 45, 25);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imageID = 2;
				changeImage(true);
			}
		});
		btn2.setBounds(92, 313, 45, 25);
		contentPane.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imageID = 3;
				changeImage(true);
			}
		});
		btn3.setBounds(144, 313, 45, 25);
		contentPane.add(btn3);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imageID = 4;
				changeImage(true);
			}
		});
		btn4.setBounds(196, 313, 45, 25);
		contentPane.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imageID = 5;
				changeImage(true);
			}
		});
		btn5.setBounds(248, 313, 45, 25);
		contentPane.add(btn5);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeImage(true);
			}
		});
		btnNext.setBounds(442, 142, 70, 25);
		contentPane.add(btnNext);
		
		JButton btnLast = new JButton("Last");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeImage(false);
			}
		});
		btnLast.setBounds(442, 104, 70, 25);
		contentPane.add(btnLast);
		
		Border border = BorderFactory.createLineBorder(Color.BLUE, 5);
		 
        // set the border of this component
        
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(40, 36, 360, 240);
		lblNewLabel.setBorder(border);
		contentPane.add(lblNewLabel);
		
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!t.isRunning()){
					t.start();
				}
			}
		});
		btnStart.setBounds(442, 297, 97, 25);
		contentPane.add(btnStart);
		
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(t.isRunning()){
					t.stop();
				}
			}
		});
		btnStop.setBounds(442, 335, 97, 25);
		contentPane.add(btnStop);
		
	}

}
