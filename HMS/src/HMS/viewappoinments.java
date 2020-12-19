package HMS;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class viewappoinments extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewappoinments frame = new viewappoinments();
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
	public viewappoinments() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1141, 612);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1125, 573);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 74, 1074, 257);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("View");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "root");	
											
					//PreparedStatement stmt=con.prepareStatement("SELECT P.patientId,p.name AS pname,p.gender AS pgender,p.age as page,d.name as dname,specialization,opdID,a.patientId,symptoms,date,time FROM patient as p INNER JOIN opd as a on p.patientId=a.patientId INNER JOIN doctor as d on d.doctorId=a.doctorid");
					PreparedStatement stmt=con.prepareStatement("Select  * from opd");
					ResultSet rs =stmt.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch(Exception exe) {
					System.out.println(exe);
				}
			}
		});
		btnNewButton_1.setBounds(59, 342, 89, 23);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("To delete records ");
		lblNewLabel.setBounds(59, 376, 149, 23);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter patient ID");
		lblNewLabel_1.setBounds(59, 420, 149, 23);
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(229, 420, 86, 23);
		textField.setColumns(10);
		panel.add(textField);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.setBounds(410, 423, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			new opd().setVisible(true);
			dispose();
			}
		});
		btnNewButton_2.setBounds(711, 423, 89, 23);
		panel.add(btnNewButton_2);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(0, 153, 255));
		panel_1_1.setBounds(0, 11, 1125, 52);
		panel.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Patient Addmission");
		lblNewLabel_7.setBounds(503, 11, 154, 30);
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_1_1.add(lblNewLabel_7);
	}
}
