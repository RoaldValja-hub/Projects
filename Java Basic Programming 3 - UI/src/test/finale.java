package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Color.*;
import java.util.Arrays;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class finale extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField textField;
	private String [] display = new String[100];
	private int index=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					finale frame = new finale();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void addToDisplay(String s){
		try{
			int r = Integer.parseInt(s);
			try{
				int g = Integer.parseInt(display[index-1]);
				display[index-1]=display[index-1]+s;
			} catch(Exception e2){
				display[index]=s;
				index++;
			}
		}catch(Exception e){
			display[index]=s;
			index++;
		}
	}
	
	private static void getComp(Stack<String> ops, Stack<Double> vals){
		String op = ops.pop();
		if(op.equals("+")){
			vals.push(vals.pop() + vals.pop());
		} else if(op.equals("-")){
			vals.push(vals.pop() - vals.pop());
		} else if(op.equals("*")){
			vals.push(vals.pop() * vals.pop());
		} else if(op.equals("/")){
			vals.push(vals.pop() / vals.pop());
		}
	}
	
	private Double calculate(){
		Stack<String> ops = new Stack<String>();
		Stack<Double> vals = new Stack<Double>();
		for(int i = 0; i <(index); i++){
			String s = display[(index-1)-i];
			if(s.equals(")")){
				
			} else if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
				ops.push(s);
			} else if(s.equals("(")){
				getComp(ops, vals);
			} else{
				vals.push(Double.parseDouble(s));
			}
		}
		getComp(ops, vals);
		return vals.pop();
	}
	
	/**
	 * Create the frame.
	 */
	public finale() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(52, 56, 377, 22);
		textField.setBackground(Color.WHITE);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "7");
				addToDisplay("7");
			}
		});
		btn7.setBounds(52, 107, 50, 25);
		contentPane.add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "8");
				addToDisplay("8");
			}
		});
		btn8.setBounds(123, 107, 50, 25);
		contentPane.add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "9");
				addToDisplay("9");
			}
		});
		btn9.setBounds(191, 107, 50, 25);
		contentPane.add(btn9);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "4");
				addToDisplay("4");
			}
		});
		btn4.setBounds(52, 145, 50, 25);
		contentPane.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "5");
				addToDisplay("5");
			}
		});
		btn5.setBounds(123, 145, 50, 25);
		contentPane.add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "6");
				addToDisplay("6");
			}
		});
		btn6.setBounds(191, 145, 50, 25);
		contentPane.add(btn6);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "1");
				addToDisplay("1");
			}
		});
		btn1.setBounds(52, 183, 50, 25);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "2");
				addToDisplay("2");
			}
		});
		btn2.setBounds(123, 183, 50, 25);
		contentPane.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "3");
				addToDisplay("3");
			}
		});
		btn3.setBounds(191, 183, 50, 25);
		contentPane.add(btn3);
		
		JButton btnE = new JButton("E");
		btnE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnE.setBounds(52, 221, 50, 25);
		contentPane.add(btnE);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "0");
				addToDisplay("0");
			}
		});
		btn0.setBounds(123, 221, 50, 25);
		contentPane.add(btn0);
		
		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				Arrays.fill(display, null);
				display = new String[100];
				index = 0;
			}
		});
		btnC.setBounds(191, 221, 50, 25);
		contentPane.add(btnC);
		
		JButton btnAdd = new JButton("+");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "+");
				addToDisplay("+");
			}
		});
		btnAdd.setBounds(264, 107, 50, 25);
		contentPane.add(btnAdd);
		
		JButton btnEnter = new JButton("=");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double res = calculate();
				textField.setText(textField.getText()+"="+res);
			}
		});
		btnEnter.setBounds(52, 261, 189, 25);
		contentPane.add(btnEnter);
		
		JButton btnsub = new JButton("-");
		btnsub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "-");
				addToDisplay("-");
			}
		});
		btnsub.setBounds(264, 145, 50, 25);
		contentPane.add(btnsub);
		
		JButton btnMul = new JButton("*");
		btnMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "*");
				addToDisplay("*");
			}
		});
		btnMul.setBounds(264, 183, 50, 25);
		contentPane.add(btnMul);
		
		JButton btnDiv = new JButton("/");
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "/");
				addToDisplay("/");
			}
		});
		btnDiv.setBounds(264, 221, 50, 25);
		contentPane.add(btnDiv);
		
		JButton btnForward = new JButton("(");
		btnForward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "(");
				addToDisplay("(");
			}
		});
		btnForward.setBounds(326, 107, 50, 25);
		contentPane.add(btnForward);
		
		JButton btnBackward = new JButton(")");
		btnBackward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + ")");
				addToDisplay(")");
			}
		});
		btnBackward.setBounds(326, 145, 50, 25);
		contentPane.add(btnBackward);
	}

}
