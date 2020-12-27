package HMS;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class floor extends JFrame {

	private JPanel contentPane;
	public JTable table;
	private JTextField fno;
	private JTextField lno;
	private JTextField dayduty;
	private JTextField nightduty;
	private JTextField wards;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					floor frame = new floor();
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
	public floor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 892, 465);
		contentPane = new JPanel();
	
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(253, 245, 230));
		panel.setBounds(0, 0, 876, 426);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(253, 245, 230));
		scrollPane.setBounds(39, 109, 803, 88);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					int row =table.getSelectedRow();
					String fn=(table.getModel().getValueAt(row, 0)).toString();
					
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "root");
						PreparedStatement stmt=con.prepareStatement("Select * from floorDetails where floorNumber=?");
						stmt.setString(1,fn);
						ResultSet rs =stmt.executeQuery();
						
						while(rs.next()) {
							fno.setText(rs.getString("floorNumber"));
							lno.setText(rs.getString("contactNo"));
							dayduty.setText(rs.getString("nurseDayDuty"));
							nightduty.setText(rs.getString("nurseNightDuty"));
							wards.setText(rs.getString("no_wards"));
							fno.setEditable(false);
						}
						con.close();
				}catch(Exception elx) {
					
				}
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"FloorNo", "  Landline_Number", "  Nurse_on_Day_duty", "Nurse_on_Night_duty", "No_of_wards"
			}
		));
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 153, 255));
		panel_1.setBounds(10, 11, 856, 43);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Floor Details");
		lblNewLabel_7.setBounds(373, 11, 114, 24);
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_7);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "root");	
					PreparedStatement stmt=con.prepareStatement("update floorDetails set contactNo = ?, nurseDayDuty = ?,nurseNightDuty = ?,no_wards = ? where floorNumber = ?");
					stmt.setString(1,lno.getText());
					stmt.setString(2,dayduty.getText());
				    stmt.setString(3,nightduty.getText());
			        stmt.setString(4,wards.getText());
					stmt.setString(5,fno.getText());
					
					
					stmt.executeUpdate();
						con.close();
						viewtable();
				}
				catch(Exception exce) {
					System.out.println(exce);
					JOptionPane.showMessageDialog(null,"Enter the proper details");
				}
			}
		});
		btnUpdate.setForeground(Color.BLUE);
		btnUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnUpdate.setBounds(366, 363, 126, 33);
		panel.add(btnUpdate);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new	homepage().setVisible(true);
				dispose();
			}
		});
		btnBack.setForeground(Color.BLUE);
		btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnBack.setBounds(687, 363, 89, 33);
		panel.add(btnBack);
		
		fno = new JTextField();
		fno.setBounds(39, 316, 86, 20);
		panel.add(fno);
		fno.setColumns(10);
		
		lno = new JTextField();
		lno.setBounds(200, 316, 86, 20);
		panel.add(lno);
		lno.setColumns(10);
		
		dayduty = new JTextField();
		dayduty.setBounds(358, 316, 86, 20);
		panel.add(dayduty);
		dayduty.setColumns(10);
		
		nightduty = new JTextField();
		nightduty.setBounds(516, 316, 86, 20);
		panel.add(nightduty);
		nightduty.setColumns(10);
		
		wards = new JTextField();
		wards.setBounds(669, 316, 86, 20);
		panel.add(wards);
		wards.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Floor Number");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(39, 275, 86, 14);
		panel.add(lblNewLabel);
		
		JLabel lblLandlineNo = new JLabel("Landline NO");
		lblLandlineNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLandlineNo.setBounds(200, 275, 86, 14);
		panel.add(lblLandlineNo);
		
		JLabel lblDayDuty = new JLabel("Day duty");
		lblDayDuty.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDayDuty.setBounds(358, 275, 86, 14);
		panel.add(lblDayDuty);
		
		JLabel lblNightDuty = new JLabel("Night duty");
		lblNightDuty.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNightDuty.setBounds(516, 275, 86, 14);
		panel.add(lblNightDuty);
		
		JLabel lblWards = new JLabel("wards");
		lblWards.setBounds(669, 275, 86, 14);
		panel.add(lblWards);
		
		viewtable();
		
	}

	protected void viewtable() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "root");	
									
			PreparedStatement stmt=con.prepareStatement("Select floorNumber as FloorNo,contactNo as LandLine_Number,nurseDayDuty as Nurse_on_Day_duty,nurseNightDuty as Nurse_on_Night_duty,no_wards as No_of_wards from floorDetails");

			ResultSet rs =stmt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			con.close();
		}catch(Exception exe) {
			System.out.println(exe);
		}
	}
}
