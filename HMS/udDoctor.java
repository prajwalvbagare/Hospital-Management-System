package HMS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
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

public class udDoctor extends JFrame {

	private JPanel contentPane;
	private JTextField dId;
	private JTextField name;
	private JTextField contactNo;
	private JTextField gender;
	private JTextField spec;
	private JTextField age;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					udDoctor frame = new udDoctor();
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
	public udDoctor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 869, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(211, 211, 211));
		panel.setBounds(0, 0, 853, 521);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 153, 255));
		panel_1.setBounds(0, 11, 853, 37);
		panel.add(panel_1);
		
		JLabel lblNewLabel_7 = new JLabel("Doctor's Entry");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_7);
		
		JLabel lblEnterDoctorId = new JLabel("Enter Doctor ID");
		lblEnterDoctorId.setForeground(Color.BLUE);
		lblEnterDoctorId.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblEnterDoctorId.setBounds(108, 103, 127, 23);
		panel.add(lblEnterDoctorId);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(108, 161, 94, 23);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Contact NO");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setBackground(SystemColor.menu);
		lblNewLabel_2.setBounds(108, 219, 94, 23);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Gender");
		lblNewLabel_4.setForeground(Color.BLUE);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(108, 276, 94, 23);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Doctor Speclization");
		lblNewLabel_5.setForeground(Color.BLUE);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(103, 329, 189, 23);
		panel.add(lblNewLabel_5);
		
		dId = new JTextField();
		dId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode()==KeyEvent.VK_DOWN) {
					name.requestFocus();
				}
			}
			
		});
		dId.setColumns(10);
		dId.setBounds(348, 101, 241, 32);
		panel.add(dId);
		
		name = new JTextField();
		name.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode()==KeyEvent.VK_DOWN) {
					contactNo.requestFocus();
				}
				if(evt.getKeyCode()==KeyEvent.VK_UP) {
					dId.requestFocus();
				}
			}
		});
		name.setColumns(10);
		name.setBounds(348, 159, 241, 32);
		panel.add(name);
		
		contactNo = new JTextField();
		contactNo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode()==KeyEvent.VK_DOWN) {
					gender.requestFocus();
				}
				if(evt.getKeyCode()==KeyEvent.VK_UP) {
					name.requestFocus();
				}
			}
		});
		contactNo.setColumns(10);
		contactNo.setBounds(348, 217, 241, 32);
		panel.add(contactNo);
		
		gender = new JTextField();
		gender.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode()==KeyEvent.VK_DOWN) {
					spec.requestFocus();
				}
				if(evt.getKeyCode()==KeyEvent.VK_UP) {
					contactNo.requestFocus();
				}
			}
		});
		gender.setColumns(10);
		gender.setBounds(348, 274, 241, 32);
		panel.add(gender);
		
		spec = new JTextField();
		spec.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode()==KeyEvent.VK_DOWN) {
					age.requestFocus();
				}
				
				if(evt.getKeyCode()==KeyEvent.VK_UP) {
					gender.requestFocus();
				}
			}
		});
		spec.setColumns(10);
		spec.setBounds(348, 327, 241, 32);
		panel.add(spec);
		
		JButton search = new JButton("Search");
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String did=dId.getText();
				if(did.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Doctor ID cannot be blank! Enter the Doctor ID");
				}
				else {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "root");	
					PreparedStatement stmt=con.prepareStatement("Select * from doctor where doctorId=?");
					stmt.setString(1,did);

					ResultSet rs =stmt.executeQuery();
					
					if(rs.next()) {
						name.setText(rs.getString("name"));
						contactNo.setText(rs.getString("contactNo"));
					    gender.setText(rs.getString("gender"));
                        spec.setText(rs.getString("specialization"));
					    age.setText(rs.getString("age"));
                        dId.setEditable(false);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Doctor details not found enter the proper ID");
							
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
		search.setIcon(new ImageIcon("D:\\My Softwares\\Eclipse\\Icon and images for project\\search.png"));
		search.setForeground(Color.BLUE);
		search.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		search.setBounds(658, 103, 146, 34);
		panel.add(search);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String a=dId.getText();
				String b=name.getText();
				String c=contactNo.getText();
				String ele=gender.getText();
				String s=spec.getText();
				
				if(a.isEmpty()||b.isEmpty()||c.isEmpty()||ele.isEmpty()||s.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Please fill all details");
				}
				else
				{
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "root");	
					PreparedStatement stmt=con.prepareStatement("update doctor set name = ?, contactNo = ?,gender = ?,specialization = ?,age=? where doctorId = ?");
					stmt.setString(1,name.getText());
					stmt.setString(2,contactNo.getText());
				    stmt.setString(3,gender.getText());
			        stmt.setString(4, spec.getText());
					stmt.setString(5,age.getText());
                    stmt.setString(6,dId.getText());
					
					
					stmt.executeUpdate();
						JOptionPane.showMessageDialog(null,"Doctor details updated");
						con.close();
						new	doctorpanel().setVisible(true);
						dispose();

				}
				catch(Exception exce) {
					System.out.println(exce);
					JOptionPane.showMessageDialog(null,"Enter the proper details");
				}
				}
			}
		});
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_1.setBounds(62, 467, 119, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
						JOptionPane.showMessageDialog(null,"Doctor record deleted");
						con.close();
						new	doctorpanel().setVisible(true);
						dispose();
						
					}catch(Exception elem){
						System.out.println(elem);
						JOptionPane.showMessageDialog(null,"Doctor has appoinment clear the appoinment");
					}
				}
				}
			}
		});
		btnNewButton_2.setForeground(Color.BLUE);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_2.setBounds(372, 470, 101, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new	doctorpanel().setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_3.setForeground(Color.BLUE);
		btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_3.setBounds(684, 470, 94, 23);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton = new JButton("Clear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new udDoctor().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setBounds(689, 161, 89, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Age");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(105, 384, 94, 31);
		panel.add(lblNewLabel);
		
		age = new JTextField();
		age.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode()==KeyEvent.VK_UP) {
					spec.requestFocus();
				}
			}
		});
		age.setColumns(10);
		age.setBackground(Color.WHITE);
		age.setBounds(348, 387, 105, 31);
		panel.add(age);
	}
}
