package HMS;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class viewadmission extends JFrame {

	private JPanel contentPane;
	private JTextField aId;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewadmission frame = new viewadmission();
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
	public viewadmission() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1348, 597);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 1332, 573);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("To delete records ");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(59, 376, 149, 23);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Admission ID");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(59, 420, 175, 23);
		panel.add(lblNewLabel_1);
		
		aId = new JTextField();
		aId.setColumns(10);
		aId.setBounds(264, 423, 86, 23);
		panel.add(aId);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a=aId.getText();
				if(a.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Enter the Admission ID");
				}
				else
				{  
					int action=JOptionPane.showConfirmDialog(null,"Do you really want to delete","Delete",JOptionPane.YES_NO_OPTION);
					if (action==0) {
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "root");	
						PreparedStatement stmt=con.prepareStatement("delete from admission where aId=?");  
						stmt.setString(1,aId.getText());  
						  
						int i=stmt.executeUpdate();  
						System.out.println(i+" records deleted");
						con.close();
			           aId.setText(null);
					}catch(Exception elem){
						System.out.println(elem);
					}
				}
				}
				refreshtable();
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton.setBounds(410, 423, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_2.setForeground(new Color(0, 0, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new admipanel().setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(711, 423, 89, 23);
		panel.add(btnNewButton_2);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(0, 153, 255));
		panel_1_1.setBounds(0, 11, 1332, 52);
		panel.add(panel_1_1);
		
		JLabel lblNewLabel_7 = new JLabel("Patient Addmission");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(598, 11, 154, 30);
		panel_1_1.add(lblNewLabel_7);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 89, 1282, 228);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"PatientID", "AdmissionID", "Name", "Age", "Gender", "Reason", "Date_Time", "FloorNo", "ward", "Nurse_on_day_Duty", "Nurse_on_night_duty"
			}
		));
		scrollPane.setViewportView(table);
		
		refreshtable();
	}

	protected void refreshtable() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "root");	
									
			PreparedStatement stmt=con.prepareStatement("Select f.floorNumber as FloorNO,aId as AdmissionID,p.patientId as PatientID,name as Name,age as Age,gender as Gender,reason as Reason,timestamp as Date_Time,ward as Ward,nurseDayDuty as Nurse_on_day_Duty,nurseNightDuty as Nurse_on_night_Duty from patient p inner join admission as a on p.patientId=a.patientId inner join floordetails as f on a.floorNumber=f.floorNumber");

			ResultSet rs =stmt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception exe) {
			System.out.println(exe);
		}
	}

}
