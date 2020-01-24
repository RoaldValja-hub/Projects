package test;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.Box;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class test {

	private JFrame frame;
	private JTextField txtOp2;
	private JLabel lblOp2;
	private JButton btnAdd;
	private JButton btnSub;
	private JButton btnMul;
	private JButton btnDiv;
	private JButton btnMod;
	private JTextField txtOp1;
	private JTextField txtAnswer;
	private JLabel lblAnswer;
	private JButton btnClear;
	private JButton btnExit;
	private JButton btnPow;
	
	private float number1;
	private float number2;
	private boolean condition;
	private float answer;
	private JButton btnSwitch;
	private String operation = "+";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
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
	public test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblOp1 = new JLabel("Op 1");
		lblOp1.setBounds(23, 55, 56, 16);
		frame.getContentPane().add(lblOp1);
		
		txtOp1 = new JTextField();
		txtOp1.setColumns(10);
		txtOp1.setBounds(70, 52, 164, 22);
		frame.getContentPane().add(txtOp1);
		
		txtOp2 = new JTextField();
		txtOp2.setBounds(70, 82, 164, 22);
		frame.getContentPane().add(txtOp2);
		txtOp2.setColumns(10);
		
		lblOp2 = new JLabel("Op 2");
		lblOp2.setBounds(23, 85, 56, 16);
		frame.getContentPane().add(lblOp2);
		
		btnAdd = new JButton("+");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				String op1Str = txtOp1.getText();
				String op2Str = txtOp2.getText();
				int op1Int = Integer.parseInt(op1Str);
				int op2Int = Integer.parseInt(op2Str);
				int answer2 = op1Int + op2Int;
				
				txtAnswer.setText(String.valueOf(answer2));
				*/
				//teachers solution
				
				condition = true;
				txtAnswer.setBackground(Color.WHITE);
				answer = 0;
				try{
					number1 = Float.valueOf(txtOp1.getText());
				} catch(Exception ex){
					txtOp1.setBackground(Color.RED);
				}
				try{
					number2 = Float.valueOf(txtOp2.getText());
				} catch(Exception ex){
					txtOp1.setBackground(Color.RED);
					condition = false;
				}
				if(condition){
					try{
						answer = number1 + number2;
						txtOp1.setBackground(Color.WHITE);
						txtOp2.setBackground(Color.WHITE);
					}catch(Exception ex){
						
					}
				}
				operation = "+";
				txtAnswer.setText(Float.toString(answer));
			}
		});
		btnAdd.setBounds(23, 114, 97, 25);
		frame.getContentPane().add(btnAdd);
		
		btnSub = new JButton("-");
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				String op1Str = txtOp1.getText();
				String op2Str = txtOp2.getText();
				int op1Int = Integer.parseInt(op1Str);
				int op2Int = Integer.parseInt(op2Str);
				int answer2 = op1Int - op2Int;
				
				txtAnswer.setText(String.valueOf(answer2));
				*/
				condition = true;
				txtAnswer.setBackground(Color.WHITE);
				answer = 0;
				try{
					number1 = Float.valueOf(txtOp1.getText());
				} catch(Exception ex){
					txtOp1.setBackground(Color.RED);
				}
				try{
					number2 = Float.valueOf(txtOp2.getText());
				} catch(Exception ex){
					txtOp1.setBackground(Color.RED);
					condition = false;
				}
				if(condition){
					try{
						answer = number1 - number2;
						txtOp1.setBackground(Color.WHITE);
						txtOp2.setBackground(Color.WHITE);
					}catch(Exception ex){
						
					}
				}
				operation = "-";
				txtAnswer.setText(Float.toString(answer));
			}
		});
		btnSub.setBounds(138, 114, 97, 25);
		frame.getContentPane().add(btnSub);
		
		btnMul = new JButton("*");
		btnMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				String op1Str = txtOp1.getText();
				String op2Str = txtOp2.getText();
				int op1Int = Integer.parseInt(op1Str);
				int op2Int = Integer.parseInt(op2Str);
				int answer2 = op1Int * op2Int;
				
				txtAnswer.setText(String.valueOf(answer2));
				*/
				condition = true;
				txtAnswer.setBackground(Color.WHITE);
				answer = 0;
				try{
					number1 = Float.valueOf(txtOp1.getText());
				} catch(Exception ex){
					txtOp1.setBackground(Color.RED);
				}
				try{
					number2 = Float.valueOf(txtOp2.getText());
				} catch(Exception ex){
					txtOp1.setBackground(Color.RED);
					condition = false;
				}
				if(condition){
					try{
						answer = number1 * number2;
						txtOp1.setBackground(Color.WHITE);
						txtOp2.setBackground(Color.WHITE);
					}catch(Exception ex){
						
					}
				}
				operation = "*";
				txtAnswer.setText(Float.toString(answer));
			}
		});
		btnMul.setBounds(23, 152, 97, 25);
		frame.getContentPane().add(btnMul);
		
		btnDiv = new JButton("/");
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				String op1Str = txtOp1.getText();
				String op2Str = txtOp2.getText();
				int op1Int = Integer.parseInt(op1Str);
				int op2Int = Integer.parseInt(op2Str);
				int answer2 = op1Int / op2Int;
				
				txtAnswer.setText(String.valueOf(answer2));
				*/
				condition = true;
				txtAnswer.setBackground(Color.WHITE);
				answer = 0;
				try{
					number1 = Float.valueOf(txtOp1.getText());
				} catch(Exception ex){
					txtOp1.setBackground(Color.RED);
				}
				try{
					number2 = Float.valueOf(txtOp2.getText());
					if(number2 == 0){
						txtOp2.setBackground(Color.RED);
						condition=false;
						JOptionPane.showMessageDialog(txtOp2, "Can't divide by 0");
					}
				} catch(Exception ex){
					txtOp1.setBackground(Color.RED);
					condition = false;
				}
				if(condition){
					try{
						answer = number1 / number2;
						txtOp1.setBackground(Color.WHITE);
						txtOp2.setBackground(Color.WHITE);
					}catch(Exception ex){
						
					}
				}
				operation = "/";
				txtAnswer.setText(Float.toString(answer));
			}
		});
		btnDiv.setBounds(138, 152, 97, 25);
		frame.getContentPane().add(btnDiv);
		
		btnMod = new JButton("%");
		btnMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				String op1Str = txtOp1.getText();
				String op2Str = txtOp2.getText();
				int op1Int = Integer.parseInt(op1Str);
				int op2Int = Integer.parseInt(op2Str);
				int answer2 = op1Int % op2Int;
				
				txtAnswer.setText(String.valueOf(answer2));
				*/
				
				condition = true;
				txtAnswer.setBackground(Color.WHITE);
				answer = 0;
				try{
					number1 = Float.valueOf(txtOp1.getText());
				} catch(Exception ex){
					txtOp1.setBackground(Color.RED);
				}
				try{
					number2 = Float.valueOf(txtOp2.getText());
				} catch(Exception ex){
					txtOp1.setBackground(Color.RED);
					condition = false;
				}
				if(condition){
					try{
						answer = number1 % number2;
						txtOp1.setBackground(Color.WHITE);
						txtOp2.setBackground(Color.WHITE);
					}catch(Exception ex){
						
					}
				}
				operation = "%";
				txtAnswer.setText(Float.toString(answer));
			}
		});
		btnMod.setBounds(23, 190, 97, 25);
		frame.getContentPane().add(btnMod);
		
		txtAnswer = new JTextField();
		txtAnswer.setEditable(false);
		txtAnswer.setColumns(10);
		txtAnswer.setBounds(310, 115, 164, 40);
		frame.getContentPane().add(txtAnswer);
		
		lblAnswer = new JLabel("Answer");
		lblAnswer.setBounds(310, 88, 56, 16);
		frame.getContentPane().add(lblAnswer);
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtAnswer.setText(null);
				txtOp1.setText(null);
				txtOp2.setText(null);
				txtAnswer.setBackground(Color.WHITE);
				txtOp1.setBackground(Color.WHITE);
				txtOp2.setBackground(Color.WHITE);
			}
		});
		btnClear.setBounds(405, 51, 69, 25);
		frame.getContentPane().add(btnClear);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING", 
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
					System.exit(0);
				} else {
					// no option
				}
			}
		});
		btnExit.setBounds(405, 301, 69, 25);
		frame.getContentPane().add(btnExit);
		
		btnPow = new JButton("Pow");
		btnPow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				String op1Str = txtOp1.getText();
				String op2Str = txtOp2.getText();
				double op1Int = Double.parseDouble(op1Str);
				double op2Int = Double.parseDouble(op2Str);
				double answer2 = Math.pow(op1Int, op2Int);
				
				txtAnswer.setText(String.valueOf(answer2));
				*/
				condition = true;
				txtAnswer.setBackground(Color.WHITE);
				answer = 0;
				try{
					number1 = Float.valueOf(txtOp1.getText());
				} catch(Exception ex){
					txtOp1.setBackground(Color.RED);
				}
				try{
					number2 = Float.valueOf(txtOp2.getText());
				} catch(Exception ex){
					txtOp1.setBackground(Color.RED);
					condition = false;
				}
				if(condition){
					try{
						double answer3 = Math.pow(number1, number2);
						answer = (float)answer3;
						txtOp1.setBackground(Color.WHITE);
						txtOp2.setBackground(Color.WHITE);
					}catch(Exception ex){
						
					}
				}
				operation = "Pow";
				txtAnswer.setText(Float.toString(answer));
			}
		});
		btnPow.setBounds(138, 190, 97, 25);
		frame.getContentPane().add(btnPow);
		
		btnSwitch = new JButton("Switch");
		btnSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String op1 = txtOp1.getText();
				String op2 = txtOp2.getText();
				txtOp1.setText(op2);
				txtOp2.setText(op1);
				switch(operation){
					case "+":
						btnAdd.doClick();
						break;
					case "-":
						btnSub.doClick();
						break;
					case "*":
						btnMul.doClick();
						break;
					case "/":
						btnDiv.doClick();
						break;
					case "%":
						btnMod.doClick();
						break;
					case "Pow":
						btnPow.doClick();
						break;
					default: 
						btnClear.doClick();
						break;
				}
				
			}
		});
		btnSwitch.setBounds(310, 51, 83, 25);
		frame.getContentPane().add(btnSwitch);
	}
}
