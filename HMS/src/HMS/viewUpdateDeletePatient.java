package HMS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class viewUpdateDeletePatient extends JFrame {

	private JPanel contentPane;
	private JTextField pID;
	private JTextField name;
	private JTextField conNo;
	private JTextField age;
	private JTextField address;
	private JTextField gender;
	private JTextField bloodGroup;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewUpdateDeletePatient frame = new viewUpdateDeletePatient();
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
	public viewUpdateDeletePatient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 889, 671);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(224, 255, 255));
		panel.setBounds(0, 0, 873, 632);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 21, 873, 31);
		panel_1.setBackground(new Color(0, 153, 255));
		panel.add(panel_1);
		
		JLabel lblNewLabel_7 = new JLabel("Patient's Details");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_7);
		
		JLabel lblEnterPatientId = new JLabel("Enter Patient ID");
		lblEnterPatientId.setForeground(Color.BLUE);
		lblEnterPatientId.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblEnterPatientId.setBounds(66, 76, 146, 23);
		panel.add(lblEnterPatientId);
		
		pID = new JTextField();
		pID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode()==KeyEvent.VK_DOWN) {
					name.requestFocus();
				}

			}
		});
		pID.setColumns(10);
		pID.setBounds(307, 74, 241, 32);
		panel.add(pID);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(66, 136, 94, 23);
		panel.add(lblNewLabel_1);
		
		name = new JTextField();
		name.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode()==KeyEvent.VK_DOWN) {
					conNo.requestFocus();
				}
				if(evt.getKeyCode()==KeyEvent.VK_UP) {
					pID.requestFocus();
				}
			}
		});
		name.setColumns(10);
		name.setBounds(307, 134, 241, 32);
		panel.add(name);
		
		JLabel lblNewLabel_2 = new JLabel("Contact NO");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setBackground(SystemColor.menu);
		lblNewLabel_2.setBounds(66, 201, 94, 23);
		panel.add(lblNewLabel_2);
		
		conNo = new JTextField();
		conNo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode()==KeyEvent.VK_DOWN) {
					age.requestFocus();
				}
				if(evt.getKeyCode()==KeyEvent.VK_UP) {
					name.requestFocus();
				}
			}
		});
		conNo.setColumns(10);
		conNo.setBounds(307, 193, 241, 32);
		panel.add(conNo);
		
		JLabel lblNewLabel_3 = new JLabel("Age");
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(66, 265, 94, 23);
		panel.add(lblNewLabel_3);
		
		age = new JTextField();
		age.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode()==KeyEvent.VK_DOWN) {
					gender.requestFocus();
				}
				if(evt.getKeyCode()==KeyEvent.VK_UP) {
					conNo.requestFocus();
				}
			}
		});
		age.setColumns(10);
		age.setBounds(307, 256, 241, 32);
		panel.add(age);
		
		JLabel lblNewLabel_4 = new JLabel("Gender");
		lblNewLabel_4.setForeground(Color.BLUE);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(66, 336, 94, 23);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Blood Group");
		lblNewLabel_5.setForeground(Color.BLUE);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(66, 414, 134, 23);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Address");
		lblNewLabel_6.setForeground(Color.BLUE);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(66, 487, 94, 23);
		panel.add(lblNewLabel_6);
		
		address = new JTextField();
		address.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode()==KeyEvent.VK_UP) {
					bloodGroup.requestFocus();
				}
			}
		});
		address.setColumns(10);
		address.setBounds(233, 476, 407, 34);
		panel.add(address);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
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
						name.setText(rs.getString("name"));
						conNo.setText(rs.getString("contactNo"));
						age.setText(rs.getString("age"));
					    gender.setText(rs.getString("gender"));
                    	bloodGroup.setText(rs.getString("bloodGroup"));
						address.setText(rs.getString("address"));
                        pID.setEditable(false);
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
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton.setIcon(new ImageIcon("E:\\My Softwares\\Eclipse\\Icon and images for project\\search.png"));
		btnNewButton.setBounds(672, 79, 146, 34);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a=pID.getText();
				String b=name.getText();
				String c=conNo.getText();
				String d=age.getText();
				String ele=gender.getText();
				String f=bloodGroup.getText();
				String g=address.getText();
				
				if(a.isEmpty()||b.isEmpty()||c.isEmpty()||d.isEmpty()||ele.isEmpty()||f.isEmpty()||g.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Please fill all details");
				}
				else
				{
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "root");	
					PreparedStatement stmt=con.prepareStatement("update patient set name = ?, contactNo = ?,age = ?,gender = ?, bloodGroup = ?, address = ? where patientId = ?");
					stmt.setString(1,name.getText());
					stmt.setString(2,conNo.getText());
					stmt.setString(3,age.getText());
				    stmt.setString(4,gender.getText());
			        stmt.setString(5,bloodGroup.getText());
					stmt.setString(6,address.getText());
					stmt.setString(7,pID.getText());

					
					
					stmt.executeUpdate();
						JOptionPane.showMessageDialog(null,"patient details updated");
						con.close();
						new	PatientPanel().setVisible(true);
						dispose();
				}
				catch(Exception exce) {
					System.out.println(exce);
					JOptionPane.showMessageDialog(null,"Enter the proper details");
				}
				}
			}
		});
		btnNewButton_1.setForeground(new Color(0, 0, 255));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_1.setBounds(66, 563, 119, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a=pID.getText();
				if(a.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Enter the Patient ID");
				}
				else
				{  
					int action=JOptionPane.showConfirmDialog(null,"Do you really want to delete","Delete",JOptionPane.YES_NO_OPTION);
					if (action==0) {
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "root");	
						PreparedStatement stmt=con.prepareStatement("delete from patient where patientId=?");  
						stmt.setString(1,pID.getText());  
						  
						int i=stmt.executeUpdate();  
						System.out.println(i+" records deleted");
						JOptionPane.showMessageDialog(null,"Patient record deleted");
						con.close();
						
                        new	PatientPanel().setVisible(true);
						dispose();
						
					}catch(Exception elem){
						System.out.println(elem);
						JOptionPane.showMessageDialog(null,"Cannot delete patient:Patient has appoinment or is Amitted to delete clear it there");
					}
				}
				}
			}
		});
		btnNewButton_2.setForeground(new Color(0, 0, 255));
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_2.setBounds(392, 563, 101, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new	PatientPanel().setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_3.setForeground(new Color(0, 0, 255));
		btnNewButton_3.setBounds(694, 563, 94, 23);
		panel.add(btnNewButton_3);
		
		gender = new JTextField();
		gender.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode()==KeyEvent.VK_DOWN) {
					bloodGroup.requestFocus();
				}
				if(evt.getKeyCode()==KeyEvent.VK_UP) {
					age.requestFocus();
				}
			}
		});
		gender.setBounds(307, 334, 241, 32);
		panel.add(gender);
		gender.setColumns(10);
		
		bloodGroup = new JTextField();
		bloodGroup.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode()==KeyEvent.VK_DOWN) {
					address.requestFocus();
				}
				if(evt.getKeyCode()==KeyEvent.VK_UP) {
					gender.requestFocus();
				}
			}
		});
		bloodGroup.setBounds(307, 412, 241, 32);
		panel.add(bloodGroup);
		bloodGroup.setColumns(10);
		
		JButton clear = new JButton("Clear");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new viewUpdateDeletePatient().setVisible(true);
				dispose();
			}
		});
		clear.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		clear.setForeground(new Color(0, 0, 255));
		clear.setBounds(672, 143, 89, 23);
		panel.add(clear);
	}
}
