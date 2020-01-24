package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.GregorianCalendar;


import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calendar extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textYear;
	DefaultTableModel model;
	GregorianCalendar cal = new GregorianCalendar();
	JLabel label;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calendar frame = new Calendar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void updateMonth(){
		String month = cal.getDisplayName(GregorianCalendar.MONTH, GregorianCalendar.LONG, Locale.US);
		int year = cal.get(GregorianCalendar.YEAR);
		label.setText(month + " " + year);
		int startDay = cal.get(GregorianCalendar.DAY_OF_WEEK);
		int numberOfDays = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		int weeks = cal.getActualMaximum(GregorianCalendar.WEEK_OF_MONTH);
		model.setRowCount(0);
		model.setRowCount(weeks+2);
		int i = startDay-1;
		for(int day=1; day<=numberOfDays; day++){
			model.setValueAt(day, i/7, i%7);
			i = i + 1;
		}
	}

	/**
	 * Create the frame.
	 */
	public Calendar() {
		
		/*textField = new JTextField();
		getContentPane().add(textField, BorderLayout.CENTER);
		textField.setColumns(10);*/
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String [] calendarDays = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
		//String data[][] = {{"", "", "", "", "", "", ""},{"", "", "", "", "", "", ""},{"", "", "", "", "", "", ""},{"", "", "", "", "", "", ""},{"", "", "", "", "", "", ""}};
		//table = new JTable(data,calendarDays);
		
		
		
		
		
		/*DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(new Object[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"});*/
		
		
		
		
		
		textYear = new JTextField();
		textYear.setBounds(169, 100, 165, 22);
		contentPane.add(textYear);
		textYear.setColumns(10);
		
		
		
		final JComboBox comboBox = new JComboBox();
		final String [] mnths = new String[]{"-- Choose --", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		comboBox.setModel(new DefaultComboBoxModel(mnths));
		comboBox.setBounds(169, 64, 165, 22);
		contentPane.add(comboBox);
		
		JLabel lblChooseMonth = new JLabel("Choose Month");
		lblChooseMonth.setLabelFor(comboBox);
		lblChooseMonth.setBounds(68, 67, 89, 16);
		contentPane.add(lblChooseMonth);
		
		JLabel lblEnterYear = new JLabel("Enter Year");
		lblEnterYear.setLabelFor(textYear);
		lblEnterYear.setBounds(68, 103, 89, 16);
		contentPane.add(lblEnterYear);
		

		JButton btnShowCalendar = new JButton("Show Calendar");
		btnShowCalendar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int year;
					int month=-1;
					String monthS;
					year = Integer.parseInt(textYear.getText());
					monthS = comboBox.getSelectedItem().toString();
					int ind = -2;
					for(String mnt:mnths){
						ind++;
						if(mnt.equals(monthS) && ind>=0){
							month=ind;
						}
					}
					if(month>=0){
						cal.set(year, month, 1, 0, 0, 0);
						updateMonth();
					}
				}
				catch(Exception jje){
					
				}
			}
		});
		btnShowCalendar.setBounds(493, 99, 127, 25);
		contentPane.add(btnShowCalendar);
		
		cal.set(2017, 9, 1, 0, 0, 0);
		label = new JLabel();
		label.setBounds(350, 108, 110, 16);
		contentPane.add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		

		String [] columns = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
		model = new DefaultTableModel(null, columns);
		JTable table = new JTable(model);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 137, 608, 303);
		contentPane.add(scrollPane);
		//scrollPane.setColumnHeaderView(table);
		
		
		this.updateMonth();
		
		
	}
}
