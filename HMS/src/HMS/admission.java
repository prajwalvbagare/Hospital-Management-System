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
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;

public class admission extends JFrame{
	
    int hour,seconds,minutes;
	
	private JPanel contentPane;
	private JTextField pID;
	private JTextField reason;
	private JTextField name;
	private JTextField gender;
	private JTextField age;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton general;
	private JRadioButton special;
	private JRadioButton semigeneral;
	private JComboBox floorno;
	private JTextField ID;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admission frame = new admission();
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
	public admission() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 856, 598);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 182, 193));
		panel.setBounds(0, 0, 840, 559);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Patient ID");
		lblNewLabel.setBounds(42, 95, 102, 25);
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel.add(lblNewLabel);
		
		pID = new JTextField();
		pID.setBackground(Color.WHITE);
		pID.setBounds(154, 100, 102, 20);
		panel.add(pID);
		pID.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Floor No");
		lblNewLabel_1.setBounds(40, 277, 102, 25);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		panel.add(lblNewLabel_1);
		
		floorno = new JComboBox();
		floorno.setBounds(219, 278, 63, 20);
		floorno.setBackground(Color.WHITE);
		floorno.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel.add(floorno);
		
		JLabel lblNewLabel_2 = new JLabel("Reason");
		lblNewLabel_2.setBounds(40, 395, 102, 25);
		lblNewLabel_2.setForeground(new Color(0, 0, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel.add(lblNewLabel_2);
		
		reason = new JTextField();
		reason.setBounds(219, 398, 365, 25);
		panel.add(reason);
		reason.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Ward type");
		lblNewLabel_3.setBounds(40, 336, 102, 32);
		lblNewLabel_3.setForeground(new Color(0, 0, 255));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(219, 336, 344, 34);
		panel_1.setBackground(new Color(255, 182, 193));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		general = new JRadioButton("General");
		general.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		buttonGroup.add(general);
		general.setActionCommand("General");
		general.setForeground(new Color(0, 0, 255));
		general.setBackground(new Color(255, 182, 193));
		general.setBounds(6, 7, 76, 23);
		panel_1.add(general);
		
		special = new JRadioButton("Special");
		special.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		buttonGroup.add(special);
		special.setActionCommand("Special");
		special.setForeground(new Color(0, 0, 255));
		special.setBackground(new Color(255, 182, 193));
		special.setBounds(246, 7, 76, 23);
		panel_1.add(special);
		
		semigeneral = new JRadioButton("Semi General");
		semigeneral.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		buttonGroup.add(semigeneral);
		semigeneral.setActionCommand("Semi_General");
		semigeneral.setForeground(new Color(0, 0, 255));
		semigeneral.setBackground(new Color(255, 182, 193));
		semigeneral.setBounds(105, 7, 109, 23);
		panel_1.add(semigeneral);
		
		JButton btnNewButton = new JButton("Clear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new	admission().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setBounds(42, 507, 89, 32);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Admit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String a=pID.getText();
				String b=reason.getText();
			//	String c=adDate.getText();
			//	String d=adTime.getText();
				if(a.isEmpty()||b.isEmpty()) {

					JOptionPane.showMessageDialog(null,"Please fill all details");
				}
				else
				{
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "root");	
					PreparedStatement stmt=con.prepareStatement("insert into admission(aId,patientId,floorNumber,reason,ward)values(null,?,?,?,?)");
					stmt.setString(1,pID.getText());
					stmt.setString(2,(String)floorno.getSelectedItem());
					stmt.setString(3,reason.getText());
					stmt.setString(4,buttonGroup.getSelection().getActionCommand());
				//	stmt.setString(5,adDate.getText());
				//	stmt.setString(6,adTime.getText());
					
					
					stmt.executeUpdate();
						JOptionPane.showMessageDialog(null,"Patient admitted");
						con.close();
						new admission().setVisible(true);
						dispose();
				}
				catch(Exception p) {
					System.out.println(p);
					JOptionPane.showMessageDialog(null,"Enter the proper details");
				}
				}
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_1.setForeground(new Color(0, 0, 255));
		btnNewButton_1.setBounds(392, 507, 89, 32);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_2.setForeground(new Color(0, 0, 255));
		btnNewButton_2.setBounds(685, 507, 89, 32);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new	admipanel().setVisible(true);
				dispose();
			}
		});
		panel.add(btnNewButton_2);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(0, 0, 840, 37);
		panel_1_1.setBackground(new Color(0, 153, 255));
		panel.add(panel_1_1);
		
		JLabel lblNewLabel_7 = new JLabel("Patient Addmission");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_1_1.add(lblNewLabel_7);
		
		JButton btnNewButton_3 = new JButton("Search");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
						age.setText(rs.getString("age"));
					    gender.setText(rs.getString("gender"));
               		    name.setEditable(false);
                        gender.setEditable(false);
                        age.setEditable(false);
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
		btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_3.setForeground(new Color(0, 0, 255));
		btnNewButton_3.setBounds(392, 95, 89, 25);
		panel.add(btnNewButton_3);
		
		JLabel lblNewLabel_5_1 = new JLabel("\r\nName");
		lblNewLabel_5_1.setBounds(42, 165, 63, 23);
		lblNewLabel_5_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_5_1.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		panel.add(lblNewLabel_5_1);
		
		name = new JTextField();
		name.setBounds(148, 169, 206, 20);
		name.setColumns(10);
		name.setBackground(Color.WHITE);
		panel.add(name);
		
		JLabel lblNewLabel_9 = new JLabel("Gender");
		lblNewLabel_9.setBounds(400, 161, 70, 33);
		lblNewLabel_9.setForeground(new Color(0, 0, 255));
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel.add(lblNewLabel_9);
		
		gender = new JTextField();
		gender.setBounds(498, 169, 86, 20);
		gender.setColumns(10);
		gender.setBackground(Color.WHITE);
		panel.add(gender);
		
		JLabel lblNewLabel_6 = new JLabel("Age");
		lblNewLabel_6.setBounds(626, 166, 63, 23);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setForeground(new Color(0, 0, 255));
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel.add(lblNewLabel_6);
		
		age = new JTextField();
		age.setBounds(724, 169, 70, 20);
		age.setColumns(10);
		panel.add(age);
		
		JLabel lblNewLabel_8 = new JLabel("Patient Details");
		lblNewLabel_8.setBounds(340, 48, 165, 27);
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_8.setForeground(Color.BLACK);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_8_1 = new JLabel("Fill the details for admission of patient");
		lblNewLabel_8_1.setBackground(new Color(0, 0, 255));
		lblNewLabel_8_1.setForeground(Color.BLACK);
		lblNewLabel_8_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_8_1.setBounds(40, 239, 365, 27);
		panel.add(lblNewLabel_8_1);
		
		ID = new JTextField();
		ID.setHorizontalAlignment(SwingConstants.CENTER);
		ID.setForeground(Color.BLUE);
		ID.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		ID.setColumns(10);
		ID.setBackground(Color.WHITE);
		ID.setBounds(154, 48, 41, 35);
		panel.add(ID);
		
		Fillcombo();
		viewID();
	}
	private void viewID() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "root");	
			PreparedStatement smt=con.prepareStatement("SELECT auto_increment FROM information_schema.TABLES WHERE TABLE_SCHEMA=\"hms\" AND TABLE_NAME=\"admission\"");
			ResultSet rs=smt.executeQuery();
			if(rs.next()) {
                     ID.setText(rs.getString("auto_increment"));
                     ID.setEditable(false);
			}
		}catch(Exception exe)
		{
			System.out.println(exe);
		}
	}

	private void Fillcombo()
    {
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "root");	
			PreparedStatement stmt=con.prepareStatement("Select * from floorDetails");
			ResultSet rs =stmt.executeQuery();
			
			while(rs.next()) {
				String Name=rs.getString("floorNumber");
				floorno.addItem(Name);
			}
			con.close();
    	}
    	catch(Exception elem) {
    		JOptionPane.showMessageDialog(null,elem);
    	}
    }
}
