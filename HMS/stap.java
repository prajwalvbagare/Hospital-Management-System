package HMS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class stap extends JFrame {

	private JPanel contentPane;
	private JTextField pID;
	private JTextField symptoms;
	private JTextField date;
	private JTextField time;
	private JTextField dName;
	private JTextField pName;
	private JTextField pGender;
	private JTextField dSpec;
	private JTextField age;
	private JTextField docId;
	private JComboBox doctors;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stap frame = new stap();
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
	public stap() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 912, 683);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 255, 255));
		panel.setBounds(0, 0, 896, 644);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 11, 896, 47);
		panel_1.setBackground(new Color(0, 153, 255));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Appoinment");
		lblNewLabel.setBounds(355, 11, 142, 24);
		panel_1.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("Enter the Follwing Deatils");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(49, 375, 220, 54);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Patient ID");
		lblNewLabel_2.setBounds(49, 134, 94, 23);
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Consulting Doctor");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(392, 288, 181, 23);
		lblNewLabel_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 21));
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Symptoms");
		lblNewLabel_2_1.setBounds(49, 440, 94, 23);
		lblNewLabel_2_1.setForeground(Color.BLUE);
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("Date and time");
		lblNewLabel_3.setBounds(49, 485, 144, 38);
		lblNewLabel_3.setForeground(new Color(0, 0, 255));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel.add(lblNewLabel_3);
		
		pID = new JTextField();
		pID.setBounds(187, 138, 86, 20);
		panel.add(pID);
		pID.setColumns(10);
		
		doctors = new JComboBox();
		doctors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "root");
					PreparedStatement stmt=con.prepareStatement("Select * from doctor where name=?");
					stmt.setString(1,(String)doctors.getSelectedItem());
					ResultSet rs =stmt.executeQuery();
					
					while(rs.next()) {
						dName.setText(rs.getString("name"));
						dSpec.setText(rs.getString("specialization"));
						docId.setText(rs.getString("doctorId"));
						
						dName.setEditable(false);
						dSpec.setEditable(false);
						docId.setEditable(false);
					}
					con.close();
				}
				catch(Exception ele)
				{
					
				}
			}
		});
		doctors.setForeground(new Color(0, 0, 255));
		doctors.setFont(new Font("Times New Roman", Font.BOLD, 20));
		doctors.setModel(new DefaultComboBoxModel(new String[] {"Doctors"}));
		doctors.setBounds(83, 278, 234, 33);
		panel.add(doctors);
		
		symptoms = new JTextField();
		symptoms.setBounds(187, 444, 206, 20);
		panel.add(symptoms);
		symptoms.setColumns(10);
		
		date = new JTextField();
		date.setBounds(187, 497, 86, 20);
		panel.add(date);
		date.setColumns(10);
		
		time = new JTextField();
		time.setBounds(307, 497, 86, 20);
		panel.add(time);
		time.setColumns(10);
		
		JButton btnNewButton = new JButton("Set appoinment");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String a=pID.getText();
				String b=docId.getText();
				String c=symptoms.getText();
				String d=date.getText();
				String e=time.getText();
				if(a.isEmpty()||b.isEmpty()||c.isEmpty()||d.isEmpty()||e.isEmpty()) {

					JOptionPane.showMessageDialog(null,"Please fill all details");
				}
				else
				{
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "root");	
					PreparedStatement stmt=con.prepareStatement("insert into opd(opdID,patientId,doctorId,symptoms,date,time)values(null,?,?,?,?,?)");
					stmt.setString(1,pID.getText());
					stmt.setString(2,docId.getText());
					stmt.setString(3,symptoms.getText());
					stmt.setString(4,date.getText());
					stmt.setString(5,time.getText());
					
					
					stmt.executeUpdate();
						JOptionPane.showMessageDialog(null,"Apoinment fixed");
						con.close();
						new stap().setVisible(true);
						dispose();
				}
				catch(Exception p) {
					System.out.println(p);
					JOptionPane.showMessageDialog(null,"Enter the proper details");
				}
				}
			}
		});
		btnNewButton.setBounds(392, 569, 162, 33);
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBounds(754, 569, 112, 33);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new	opd().setVisible(true);
					setVisible(false);
			}
		});
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel.add(btnNewButton_1);
		
		dName = new JTextField();
		dName.setBackground(Color.WHITE);
		dName.setBounds(187, 340, 206, 20);
		panel.add(dName);
		dName.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Doctors available");
		lblNewLabel_4.setBounds(131, 243, 144, 23);
		lblNewLabel_4.setForeground(new Color(0, 0, 255));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\r\nName");
		lblNewLabel_5.setBounds(49, 185, 63, 23);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblNewLabel_5.setForeground(new Color(0, 0, 255));
		panel.add(lblNewLabel_5);
		
		pName = new JTextField();
		pName.setBackground(Color.WHITE);
		pName.setBounds(187, 189, 206, 20);
		panel.add(pName);
		pName.setColumns(10);
		
		JButton Search = new JButton("Search");
		Search.setIcon(new ImageIcon("D:\\My Softwares\\Eclipse\\Icon and images for project\\search.png"));
		Search.setHorizontalAlignment(SwingConstants.LEFT);
		Search.setBounds(355, 134, 112, 24);
		Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pid=pID.getText();
				if(pid.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Patient ID cannot be blank! Enter the Patient ID");
				}
				else {
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "root");	
					PreparedStatement stmt=con.prepareStatement("Select * from patient where patientId=?");
					stmt.setString(1,pid);

					ResultSet rs =stmt.executeQuery();
					
					if(rs.next()) {
						pName.setText(rs.getString("name"));
						age.setText(rs.getString("age"));
					    pGender.setText(rs.getString("gender"));
                        pID.setEditable(false);
                        pName.setEditable(false);
                        pGender.setEditable(false);
                        age.setEditable(false);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Patient details not found enter the proper ID");
							
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
		Search.setForeground(new Color(0, 0, 255));
		Search.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel.add(Search);
		
		pGender = new JTextField();
		pGender.setBackground(Color.WHITE);
		pGender.setBounds(537, 189, 86, 20);
		panel.add(pGender);
		pGender.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Age");
		lblNewLabel_6.setForeground(new Color(0, 0, 255));
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(707, 186, 63, 23);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Name");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_7.setForeground(new Color(0, 0, 255));
		lblNewLabel_7.setBounds(49, 331, 63, 33);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Specialization\r\n");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_8.setForeground(new Color(0, 0, 255));
		lblNewLabel_8.setBounds(419, 338, 100, 20);
		panel.add(lblNewLabel_8);
		
		dSpec = new JTextField();
		dSpec.setBackground(Color.WHITE);
		dSpec.setBounds(537, 340, 144, 20);
		panel.add(dSpec);
		dSpec.setColumns(10);
		
		age = new JTextField();
		age.setBounds(796, 189, 70, 20);
		panel.add(age);
		age.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Gender");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_9.setForeground(new Color(0, 0, 255));
		lblNewLabel_9.setBounds(439, 181, 70, 33);
		panel.add(lblNewLabel_9);
		
		docId = new JTextField();
		docId.setBounds(796, 340, 70, 20);
		panel.add(docId);
		docId.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("ID");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setForeground(new Color(0, 0, 255));
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_11.setBounds(713, 337, 57, 20);
		panel.add(lblNewLabel_11);
		
		JButton clear = new JButton("Clear");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new	stap().setVisible(true);
				dispose();
			}
		});
		clear.setForeground(new Color(0, 0, 255));
		clear.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		clear.setBounds(49, 577, 89, 23);
		panel.add(clear);
		
		JLabel lblNewLabel_1_2 = new JLabel("Patient Deatils");
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(48, 69, 159, 54);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_10 = new JLabel("yyyy/mm/dd");
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_10.setBounds(187, 472, 86, 23);
		panel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_10_1 = new JLabel("HH:MM:SS");
		lblNewLabel_10_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_10_1.setBounds(307, 472, 86, 23);
		panel.add(lblNewLabel_10_1);
		
		Fillcombo();
	}
	private void Fillcombo()
    {
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "root");	
			PreparedStatement stmt=con.prepareStatement("Select * from doctor");
			ResultSet rs =stmt.executeQuery();
			
			while(rs.next()) {
				String Name=rs.getString("name");
				doctors.addItem(Name);
			}
			con.close();
    	}
    	catch(Exception elem) {
    		JOptionPane.showMessageDialog(null,elem);
    	}
    }
}
