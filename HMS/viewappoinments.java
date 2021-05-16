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
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;

public class viewappoinments extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField opdId;
	
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
		setBounds(100, 100, 1141, 558);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1125, 519);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 74, 1074, 211);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"  PID", "  OPD_ID", "P_Age", "P_Gender", "D_Name", "Specialization", "Symptoms", "Date", "Time"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("To delete records ");
		lblNewLabel.setBounds(59, 376, 149, 23);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter OPD ID");
		lblNewLabel_1.setBounds(59, 420, 149, 23);
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel.add(lblNewLabel_1);
		
		opdId = new JTextField();
		opdId.setBounds(229, 420, 86, 23);
		opdId.setColumns(10);
		panel.add(opdId);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a=opdId.getText();
				if(a.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Enter the Appointment ID");
				}
				else
				{  
					int action=JOptionPane.showConfirmDialog(null,"Do you really want to delete","Delete",JOptionPane.YES_NO_OPTION);
					if (action==0) {
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "root");	
						PreparedStatement stmt=con.prepareStatement("delete from opd where opdID=?");  
						stmt.setString(1,opdId.getText());  
						  
						int i=stmt.executeUpdate();  
						System.out.println(i+" records deleted");
						con.close();
						opdId.setText(null);
						
					}catch(Exception elem){
						System.out.println(elem);
						JOptionPane.showMessageDialog(null,elem);
					}
				}
				}
				refreshtable();
			}
		});
		btnNewButton.setBounds(410, 423, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_2.setForeground(new Color(0, 0, 255));
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
		
		JLabel lblNewLabel_7 = new JLabel("Patient Appoinment");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(476, 11, 181, 30);
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_1_1.add(lblNewLabel_7);
		
		refreshtable();
		
	}

	protected void refreshtable() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "root");	
									
			PreparedStatement stmt=con.prepareStatement("select opdID as OPD_ID,p.patientId as Patient_ID,p.name as Patient_Name,p.age as Patient_Age,p.gender as Patient_Gender,symptoms as Symptoms,d.name as Doctor_Name,specialization as Specialization,date as Date,time as Time from patient as p inner join opd on p.patientId=opd.patientId inner join doctor as d on opd.doctorId=d.doctorId");
			//PreparedStatement stmt=con.prepareStatement("Select  * from opd");
			ResultSet rs =stmt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception exe) {
			System.out.println(exe);
		}
	}
}
