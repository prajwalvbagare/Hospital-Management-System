package HMS;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class viewDoctor extends JFrame {

	private JPanel contentPane;
	private JTextField dId;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewDoctor frame = new viewDoctor();
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
	public viewDoctor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 861, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 844, 392);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("To delete records ");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(27, 280, 149, 23);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Doctor ID");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(27, 349, 149, 23);
		panel.add(lblNewLabel_1);
		
		dId = new JTextField();
		dId.setColumns(10);
		dId.setBounds(197, 349, 86, 23);
		panel.add(dId);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String a=dId.getText();
				if(a.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Enter the Doctor ID");
				}
				else
				{  
					int action=JOptionPane.showConfirmDialog(null,"Do you really want to delete","Delete",JOptionPane.YES_NO_OPTION);
					if (action==0) {
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "root");	
						PreparedStatement stmt=con.prepareStatement("delete from doctor where doctorId=?");  
						stmt.setString(1,dId.getText());  
						  
						int i=stmt.executeUpdate();  
						System.out.println(i+" records deleted");
						con.close();
						dId.setText(null);
						
					}catch(Exception elem){
						System.out.println(elem);
						JOptionPane.showMessageDialog(null,"Cannot delete doctor:Doctor has appoinment(s), to delete clear the appoinment");
					}
				}
				}
				refreshtable();
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton.setBounds(378, 352, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_2.setForeground(new Color(0, 0, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new doctorpanel().setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(679, 352, 89, 23);
		panel.add(btnNewButton_2);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(0, 153, 255));
		panel_1_1.setBounds(0, 0, 844, 48);
		panel.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Doctor's Details");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(327, 11, 188, 24);
		panel_1_1.add(lblNewLabel_7);
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 59, 777, 151);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"D_ID", "Name", "Specialization", "Gender", "Age", "Contact_No"
			}
		));
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		
		refreshtable();
		
	}

	protected void refreshtable() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "root");	
									
			PreparedStatement stmt=con.prepareStatement("Select doctorId as Doctor_ID,name as Name,specialization as Specialization,gender as Gender,age as Age,contactNo as Contact_No from doctor");

			ResultSet rs =stmt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception exe) {
			System.out.println(exe);
		}
	}

}
