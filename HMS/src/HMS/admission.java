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
import javax.swing.DefaultComboBoxModel;
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
	private JTextField adDate;
	private JTextField adTime;
	
	

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
		lblNewLabel.setBounds(42, 78, 102, 25);
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel.add(lblNewLabel);
		
		pID = new JTextField();
		pID.setBackground(Color.WHITE);
		pID.setBounds(154, 83, 102, 20);
		panel.add(pID);
		pID.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Floor No");
		lblNewLabel_1.setBounds(42, 213, 102, 25);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		panel.add(lblNewLabel_1);
		
		floorno = new JComboBox();
		floorno.setBounds(221, 214, 63, 20);
		floorno.setBackground(Color.WHITE);
		floorno.setFont(new Font("Times New Roman", Font.BOLD, 22));
		floorno.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		panel.add(floorno);
		
		JLabel lblNewLabel_2 = new JLabel("Reason");
		lblNewLabel_2.setBounds(42, 331, 102, 25);
		lblNewLabel_2.setForeground(new Color(0, 0, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel.add(lblNewLabel_2);
		
		reason = new JTextField();
		reason.setBounds(221, 334, 365, 25);
		panel.add(reason);
		reason.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Ward type");
		lblNewLabel_3.setBounds(42, 272, 102, 32);
		lblNewLabel_3.setForeground(new Color(0, 0, 255));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(221, 272, 344, 34);
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
		
		JLabel lblNewLabel_4 = new JLabel("Date");
		lblNewLabel_4.setBounds(42, 388, 86, 25);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_4.setForeground(new Color(0, 0, 255));
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Time");
		lblNewLabel_5.setBounds(42, 438, 86, 32);
		lblNewLabel_5.setForeground(new Color(0, 0, 255));
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel.add(lblNewLabel_5);
		
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
		btnNewButton_3.setBounds(392, 78, 89, 25);
		panel.add(btnNewButton_3);
		
		JLabel lblNewLabel_5_1 = new JLabel("\r\nName");
		lblNewLabel_5_1.setBounds(42, 128, 63, 23);
		lblNewLabel_5_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_5_1.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		panel.add(lblNewLabel_5_1);
		
		name = new JTextField();
		name.setBounds(148, 132, 206, 20);
		name.setColumns(10);
		name.setBackground(Color.WHITE);
		panel.add(name);
		
		JLabel lblNewLabel_9 = new JLabel("Gender");
		lblNewLabel_9.setBounds(400, 124, 70, 33);
		lblNewLabel_9.setForeground(new Color(0, 0, 255));
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel.add(lblNewLabel_9);
		
		gender = new JTextField();
		gender.setBounds(498, 132, 86, 20);
		gender.setColumns(10);
		gender.setBackground(Color.WHITE);
		panel.add(gender);
		
		JLabel lblNewLabel_6 = new JLabel("Age");
		lblNewLabel_6.setBounds(626, 129, 63, 23);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setForeground(new Color(0, 0, 255));
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel.add(lblNewLabel_6);
		
		age = new JTextField();
		age.setBounds(724, 132, 70, 20);
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
		lblNewLabel_8_1.setBounds(42, 175, 365, 27);
		panel.add(lblNewLabel_8_1);
		
		adDate = new JTextField();
		adDate.setBounds(221, 393, 133, 20);
		panel.add(adDate);
		adDate.setColumns(10);
		
		adTime = new JTextField();
		adTime.setBounds(221, 447, 133, 20);
		panel.add(adTime);
		adTime.setColumns(10);
		
		
	}

}
