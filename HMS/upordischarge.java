package HMS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

public class upordischarge extends JFrame {

	private JPanel contentPane;
	private JTextField pId;
	private JTextField name;
	private JTextField gender;
	private JTextField age;
	private JTextField reason;
	private JTextField date;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField ward;
	private JTextField floor;
	private JTextField aId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					upordischarge frame = new upordischarge();
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
	public upordischarge() {
		setBackground(new Color(210, 180, 140));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 664);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(210, 180, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(0, 0, 809, 625);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Patient ID");
		lblNewLabel.setBackground(new Color(210, 180, 140));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(52, 165, 102, 25);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_8 = new JLabel("Patient Details");
		lblNewLabel_8.setBackground(new Color(210, 180, 140));
		lblNewLabel_8.setForeground(Color.BLACK);
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(350, 48, 165, 27);
		panel.add(lblNewLabel_8);
		
		pId = new JTextField();
		pId.setColumns(10);
		pId.setBackground(Color.WHITE);
		pId.setBounds(231, 170, 88, 20);
		panel.add(pId);
		
		JButton btnNewButton_3 = new JButton("Search");
		btnNewButton_3.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_3.setIcon(new ImageIcon("D:\\My Softwares\\Eclipse\\Icon and images for project\\search.png"));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
						String a=aId.getText();
				if(a.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Admission ID cannot be blank! Enter the Admission ID");
				}
				else {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "root");	
					PreparedStatement stmt=con.prepareStatement("select p.patientId,name,gender,age,aId,floorNumber,ward,reason,timestamp from patient as p inner join admission as ad on p.patientId=ad.patientId where aId=?");
					stmt.setString(1,aId.getText());

					ResultSet rs =stmt.executeQuery();
					
					if(rs.next()) {
						pId.setText(rs.getString("p.patientId"));
						name.setText(rs.getString("name"));
						gender.setText(rs.getString("gender"));
						age.setText(rs.getString("age"));
						reason.setText(rs.getString("reason"));
						ward.setText(rs.getString("ward"));
						floor.setText(rs.getString("floorNumber"));
					    aId.setText(rs.getString("aid"));
						date.setText(rs.getString("timestamp"));
						
                        pId.setEditable(false);
                        aId.setEditable(false);
                        name.setEditable(false);
                        gender.setEditable(false);
                        age.setEditable(false);
                        date.setEditable(false);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Patient details not found in Admission record! Enter the proper ID");
							
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
		btnNewButton_3.setForeground(Color.BLUE);
		btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_3.setBounds(402, 103, 108, 25);
		panel.add(btnNewButton_3);
		
		JLabel lblNewLabel_5_1 = new JLabel("\r\nName");
		lblNewLabel_5_1.setBackground(new Color(210, 180, 140));
		lblNewLabel_5_1.setForeground(Color.BLUE);
		lblNewLabel_5_1.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblNewLabel_5_1.setBounds(52, 217, 63, 23);
		panel.add(lblNewLabel_5_1);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBackground(Color.WHITE);
		name.setBounds(231, 221, 206, 20);
		panel.add(name);
		
		JLabel lblNewLabel_9 = new JLabel("Gender");
		lblNewLabel_9.setBackground(new Color(210, 180, 140));
		lblNewLabel_9.setForeground(Color.BLUE);
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_9.setBounds(447, 213, 63, 33);
		panel.add(lblNewLabel_9);
		
		gender = new JTextField();
		gender.setColumns(10);
		gender.setBackground(Color.WHITE);
		gender.setBounds(530, 221, 86, 20);
		panel.add(gender);
		
		JLabel lblNewLabel_6 = new JLabel("Age");
		lblNewLabel_6.setBackground(new Color(210, 180, 140));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setForeground(Color.BLUE);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(626, 218, 63, 23);
		panel.add(lblNewLabel_6);
		
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(699, 221, 70, 20);
		panel.add(age);
		
		JLabel lblNewLabel_1 = new JLabel("Floor No");
		lblNewLabel_1.setBackground(new Color(210, 180, 140));
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(52, 312, 102, 25);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Ward type");
		lblNewLabel_3.setBackground(new Color(210, 180, 140));
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(52, 371, 102, 32);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Reason");
		lblNewLabel_2.setBackground(new Color(210, 180, 140));
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(52, 430, 102, 25);
		panel.add(lblNewLabel_2);
		
		reason = new JTextField();
		reason.setColumns(10);
		reason.setBounds(231, 433, 365, 25);
		panel.add(reason);
		
		JLabel lblNewLabel_4 = new JLabel("Date of admission");
		lblNewLabel_4.setBackground(new Color(210, 180, 140));
		lblNewLabel_4.setForeground(Color.BLUE);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(52, 487, 149, 25);
		panel.add(lblNewLabel_4);
		
		date = new JTextField();
		date.setColumns(10);
		date.setBounds(233, 492, 204, 20);
		panel.add(date);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a=aId.getText();
				String b=floor.getText();
				String c=ward.getText();
				String d=reason.getText();
				String ele=date.getText();
				
				if(a.isEmpty()||b.isEmpty()||c.isEmpty()||d.isEmpty()||ele.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Please fill all details");
				}
				else
				{
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "root");	
					PreparedStatement stmt=con.prepareStatement("update admission set floorNumber =?, reason = ?, ward = ? where aId = ?");
					stmt.setString(1,floor.getText());
					stmt.setString(2,reason.getText());
					stmt.setString(3,ward.getText());
			        stmt.setString(4,aId.getText());
					
					stmt.executeUpdate();
						JOptionPane.showMessageDialog(null,"Admission details updated");
						con.close();
						new	upordischarge().setVisible(true);
						dispose();
				}
				catch(Exception exce) {
					System.out.println(exce);
					JOptionPane.showMessageDialog(null,"Enter the proper details");
				}
				}
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.setBounds(52, 571, 89, 32);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Discharge");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a=aId.getText();
				if(a.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Enter the admission ID");
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
						JOptionPane.showMessageDialog(null,"Patient Discharged");
						con.close();
						new	upordischarge().setVisible(true);
						dispose();
						
					}catch(Exception elem){
						System.out.println(elem);
					}
				}
				}
			}
		});
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_1.setBounds(364, 571, 127, 32);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new admipanel().setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setForeground(Color.BLUE);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_2.setBounds(695, 571, 89, 32);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel_8_1 = new JLabel("To update the details for admission of patient");
		lblNewLabel_8_1.setForeground(Color.BLACK);
		lblNewLabel_8_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_8_1.setBackground(new Color(210, 180, 140));
		lblNewLabel_8_1.setBounds(52, 274, 365, 27);
		panel.add(lblNewLabel_8_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(0, 153, 255));
		panel_1_1.setBounds(0, 0, 862, 37);
		panel.add(panel_1_1);
		
		JLabel lblNewLabel_7 = new JLabel("Update/Discharge");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_1_1.add(lblNewLabel_7);
		
		JButton clear = new JButton("Clear");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new upordischarge().setVisible(true);
				dispose();
			}
		});
		clear.setForeground(Color.BLUE);
		clear.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		clear.setBounds(682, 103, 102, 25);
		panel.add(clear);
		
		ward = new JTextField();
		ward.setBounds(231, 380, 206, 20);
		panel.add(ward);
		ward.setColumns(10);
		
		floor = new JTextField();
		floor.setBounds(233, 312, 86, 20);
		panel.add(floor);
		floor.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Admission ID");
		lblNewLabel_10.setForeground(new Color(0, 0, 255));
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_10.setBounds(52, 103, 149, 27);
		panel.add(lblNewLabel_10);
		
		aId = new JTextField();
		aId.setBounds(231, 108, 86, 20);
		panel.add(aId);
		aId.setColumns(10);
	}
}
