package HMS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;

public class udap extends JFrame {

	private JPanel contentPane;
	private JTextField patId;
	private JTextField symp;
	private JTextField date;
	private JTextField time;
	private JTextField opdId;
	private JTextField pName;
	private JTextField pgender;
	private JTextField page;
	private JTextField dName;
	private JTextField spec;
	private JTextField docId;
	private JComboBox doctors1;

	  private void Fillcombobox()
	    {
	    	try {
	    		Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "root");	
				PreparedStatement stmt=con.prepareStatement("Select * from doctor");
				ResultSet rs =stmt.executeQuery();
				
				while(rs.next()) {
					String Name=rs.getString("name");
				//	String did=rs.getString("doctorId");
					doctors1.addItem(Name);
				}
				con.close();
	    	}
	    	catch(Exception elem) {
	    		JOptionPane.showMessageDialog(null,elem);
	    	}
	    }
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					udap frame = new udap();
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
	public udap() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 931, 605);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 915, 566);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 153, 255));
		panel_1.setBounds(0, 11, 916, 47);
		panel.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Appoinment");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(407, 11, 96, 24);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Patient ID");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(705, 162, 100, 23);
		panel.add(lblNewLabel_2);
		
		patId = new JTextField();
		patId.setColumns(10);
		patId.setBounds(804, 162, 86, 20);
		panel.add(patId);
		
		JLabel lblNewLabel_1_1 = new JLabel("Consulting Doctor");
		lblNewLabel_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(380, 232, 181, 23);
		panel.add(lblNewLabel_1_1);
		
		doctors1 = new JComboBox();
		doctors1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "root");
					PreparedStatement stmt=con.prepareStatement("Select * from doctor where name=?");
					stmt.setString(1,(String)doctors1.getSelectedItem());
					ResultSet rs =stmt.executeQuery();
					
					while(rs.next()) {
						dName.setText(rs.getString("name"));
						spec.setText(rs.getString("specialization"));
						docId.setText(rs.getString("doctorId"));
						
						dName.setEditable(false);
						spec.setEditable(false);
						docId.setEditable(false);
					}
					con.close();
				}
				catch(Exception ele)
				{
					
				}
			}
		});
		doctors1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		doctors1.setForeground(new Color(0, 0, 255));
		doctors1.setModel(new DefaultComboBoxModel(new String[] {"Change Doctor"}));
		doctors1.setBounds(645, 346, 214, 33);
		panel.add(doctors1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Symptoms");
		lblNewLabel_2_1.setForeground(Color.BLUE);
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(44, 362, 94, 23);
		panel.add(lblNewLabel_2_1);
		
		symp = new JTextField();
		symp.setColumns(10);
		symp.setBounds(198, 366, 86, 20);
		panel.add(symp);
		
		JLabel lblNewLabel_3 = new JLabel("Date and time");
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(44, 411, 144, 38);
		panel.add(lblNewLabel_3);
		
		date = new JTextField();
		date.setColumns(10);
		date.setBounds(198, 423, 86, 20);
		panel.add(date);
		
		time = new JTextField();
		time.setColumns(10);
		time.setBounds(332, 423, 86, 20);
		panel.add(time);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String a=opdId.getText();
				String b=symp.getText();
				String c=date.getText();
				String d=time.getText();
				
				if(a.isEmpty()||b.isEmpty()||c.isEmpty()||d.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Please fill all details");
				}
				else
				{
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "root");	
					PreparedStatement stmt=con.prepareStatement("update opd set doctorID = ?,symptoms = ?,date = ?,time = ? where patientId = ? and opdID=?");
					stmt.setString(1,docId.getText());
					stmt.setString(2,symp.getText());
					stmt.setString(3,date.getText());
				    stmt.setString(4,time.getText());
			        stmt.setString(5,patId.getText());
					stmt.setString(6,opdId.getText());

					
					stmt.executeUpdate();
						JOptionPane.showMessageDialog(null,"Appoinment details updated");
						con.close();
						new	opd().setVisible(true);
						dispose();
				}
				catch(Exception exce) {
					System.out.println(exce);
					JOptionPane.showMessageDialog(null,"Enter the proper details");
				}
				}
			}
		});
		btnUpdate.setForeground(Color.BLUE);
		btnUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnUpdate.setBounds(26, 496, 162, 33);
		panel.add(btnUpdate);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//setVisible(false);
				new	opd().setVisible(true);
					setVisible(false);
			}
		});
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_1.setBounds(753, 496, 112, 33);
		panel.add(btnNewButton_1);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String a=opdId.getText();
				if(a.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Enter the OPD ID");
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
						JOptionPane.showMessageDialog(null,"Appoiment cancelled");
						con.close();
						
                        //setVisible(false);
						new	opd().setVisible(true);
						dispose();
						
					}catch(Exception elem){
						System.out.println(elem);
						JOptionPane.showMessageDialog(null,elem);
					}
				}
				}
			}
		});
		btnDelete.setForeground(Color.BLUE);
		btnDelete.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnDelete.setBounds(405, 496, 162, 33);
		panel.add(btnDelete);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String a=opdId.getText();
				if(a.isEmpty()) {
					JOptionPane.showMessageDialog(null,"OPD ID cannot be blank! Enter the OPD ID");
				}
				else {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "root");	
					PreparedStatement stmt=con.prepareStatement("SELECT p.patientId,p.name AS pname,p.gender AS pgender,p.age as page,d.doctorId,d.name as dname,specialization,opdID,symptoms,date,time FROM patient as p INNER JOIN opd as a on p.patientId=a.patientId INNER JOIN doctor as d on d.doctorId=a.doctorid where opdID=?");
					stmt.setString(1,opdId.getText());

					ResultSet rs =stmt.executeQuery();
					
					if(rs.next()) {
						patId.setText(rs.getString("p.patientId"));
						pName.setText(rs.getString("pname"));
						pgender.setText(rs.getString("pgender"));
						page.setText(rs.getString("page"));
						opdId.setText(rs.getString("opdID"));
						dName.setText(rs.getString("dname"));
					    spec.setText(rs.getString("specialization"));
                    	docId.setText(rs.getString("d.doctorId"));
						symp.setText(rs.getString("symptoms"));
						date.setText(rs.getString("date"));
						time.setText(rs.getString("time"));
						
                        patId.setEditable(false);
                        pName.setEditable(false);
                        pgender.setEditable(false);
                        page.setEditable(false);
                        opdId.setEditable(false);
                        dName.setEditable(false);
                        spec.setEditable(false);
                        docId.setEditable(false);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Patient details not found in Appoinment enter the proper ID");
							
					}
					con.close();
				}
				catch(Exception exc) {
					System.out.println(exc);
					JOptionPane.showMessageDialog(null,exc);
				}
			}
			}
		});
		btnSearch.setIcon(new ImageIcon("D:\\My Softwares\\Eclipse\\Icon and images for project\\search.png"));
		btnSearch.setForeground(Color.BLUE);
		btnSearch.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSearch.setBounds(550, 92, 146, 34);
		panel.add(btnSearch);
		
		JLabel lblNewLabel_1 = new JLabel("Enter OPD ID");
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(44, 102, 119, 16);
		panel.add(lblNewLabel_1);
		
		opdId = new JTextField();
		opdId.setBounds(198, 102, 78, 20);
		panel.add(opdId);
		opdId.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\r\nName");
		lblNewLabel_5.setForeground(Color.BLUE);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(48, 158, 63, 23);
		panel.add(lblNewLabel_5);
		
		pName = new JTextField();
		pName.setColumns(10);
		pName.setBackground(Color.WHITE);
		pName.setBounds(121, 162, 206, 20);
		panel.add(pName);
		
		JLabel lblNewLabel_9 = new JLabel("Gender");
		lblNewLabel_9.setForeground(Color.BLUE);
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(353, 158, 70, 33);
		panel.add(lblNewLabel_9);
		
		pgender = new JTextField();
		pgender.setColumns(10);
		pgender.setBackground(Color.WHITE);
		pgender.setBounds(429, 162, 86, 20);
		panel.add(pgender);
		
		JLabel lblNewLabel_6 = new JLabel("Age");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setForeground(Color.BLUE);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(525, 159, 63, 23);
		panel.add(lblNewLabel_6);
		
		page = new JTextField();
		page.setColumns(10);
		page.setBounds(610, 162, 70, 20);
		panel.add(page);
		
		JLabel lblNewLabel_7 = new JLabel("Name");
		lblNewLabel_7.setForeground(Color.BLUE);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(44, 268, 63, 33);
		panel.add(lblNewLabel_7);
		
		dName = new JTextField();
		dName.setColumns(10);
		dName.setBackground(Color.WHITE);
		dName.setBounds(121, 277, 206, 20);
		panel.add(dName);
		
		JLabel lblNewLabel_8 = new JLabel("Specialization\r\n");
		lblNewLabel_8.setForeground(Color.BLUE);
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(353, 274, 124, 20);
		panel.add(lblNewLabel_8);
		
		spec = new JTextField();
		spec.setColumns(10);
		spec.setBackground(Color.WHITE);
		spec.setBounds(502, 277, 144, 20);
		panel.add(spec);
		
		JLabel lblNewLabel_11 = new JLabel("ID");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setForeground(Color.BLUE);
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_11.setBounds(676, 274, 57, 20);
		panel.add(lblNewLabel_11);
		
		docId = new JTextField();
		docId.setColumns(10);
		docId.setBounds(753, 277, 70, 20);
		panel.add(docId);
		
		JLabel lblNewLabel_4 = new JLabel("Doctors available");
		lblNewLabel_4.setForeground(Color.BLUE);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(676, 312, 144, 23);
		panel.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Clear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new	udap().setVisible(true);
				setVisible(false);
				//dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setBounds(759, 94, 106, 30);
		panel.add(btnNewButton);
		
		Fillcombobox();
	}

}
