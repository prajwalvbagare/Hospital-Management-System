package HMS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;

public class addPatient extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField contactNo;
	private JTextField age;
	private JTextField address;
	private JRadioButton male;
	private JRadioButton female;
	private JRadioButton other;
	private JComboBox bloodGroup;
	
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addPatient frame = new addPatient();
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
	public addPatient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 651);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(224, 255, 255));
		panel.setBounds(0, 0, 776, 612);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(135, 100, 94, 23);
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Contact NO");
		lblNewLabel_2.setBounds(135, 158, 134, 23);
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBackground(SystemColor.menu);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Age");
		lblNewLabel_3.setBounds(135, 235, 94, 23);
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Gender");
		lblNewLabel_4.setBounds(135, 319, 94, 23);
		lblNewLabel_4.setForeground(Color.BLUE);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Blood Group");
		lblNewLabel_5.setBounds(135, 384, 134, 23);
		lblNewLabel_5.setForeground(Color.BLUE);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Address");
		lblNewLabel_6.setBounds(135, 456, 94, 23);
		lblNewLabel_6.setForeground(Color.BLUE);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("Clear");
		btnNewButton.setBounds(47, 530, 134, 45);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				name.setText("");
				contactNo.setText("");
				age.setText("");
				buttonGroup.clearSelection();
				bloodGroup.setSelectedIndex(0);
				address.setText("");
				name.requestFocus();
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel.add(btnNewButton);
		
		JButton save = new JButton("Save");
		save.setBounds(326, 530, 134, 45);
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String a=name.getText();
				String b=contactNo.getText();
				String c=age.getText();
				String d=address.getText();
				if(a.isEmpty()||b.isEmpty()||c.isEmpty()||d.isEmpty()) {

					JOptionPane.showMessageDialog(null,"Please fill all details");
				}
				else
				{
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "root");	
					PreparedStatement stmt=con.prepareStatement("insert into patient(name,contactNo,age,gender,bloodGroup,address)values(?,?,?,?,?,?)");
					stmt.setString(1,name.getText());
					stmt.setString(2,contactNo.getText());
					stmt.setString(3,age.getText());
					stmt.setString(4,buttonGroup.getSelection().getActionCommand());
					stmt.setString(5,(String)bloodGroup.getSelectedItem());
					stmt.setString(6,address.getText());
					
					stmt.executeUpdate();
						JOptionPane.showMessageDialog(null,"Patient added");
						con.close();
						new addPatient().setVisible(true);
						dispose();
				}
				catch(Exception e) {
					System.out.println(e);
					JOptionPane.showMessageDialog(null,"Enter the proper details");
				}
				}
			}
		});
		save.setForeground(Color.BLUE);
		save.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel.add(save);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBounds(612, 530, 112, 45);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    new	PatientPanel().setVisible(true);
			dispose();
			}
		});
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel.add(btnNewButton_1);
		
		name = new JTextField();
		name.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode()==KeyEvent.VK_DOWN) {
					contactNo.requestFocus();
				}
			}
		});
		name.setBounds(376, 98, 241, 32);
		panel.add(name);
		name.setColumns(10);
		
		contactNo = new JTextField();
		contactNo.addKeyListener(new KeyAdapter() {
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
		contactNo.setBounds(376, 156, 241, 32);
		panel.add(contactNo);
		contactNo.setColumns(10);
		
		age = new JTextField();
		age.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode()==KeyEvent.VK_DOWN) {
					address.requestFocus();
				}
				if(evt.getKeyCode()==KeyEvent.VK_UP) {
					contactNo.requestFocus();
				}
			}
		});
		age.setBounds(376, 233, 241, 32);
		panel.add(age);
		age.setColumns(10);
		
		address = new JTextField();
		address.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode()==KeyEvent.VK_UP) {
					age.requestFocus();
				}
			}
		});
		address.setBounds(302, 453, 407, 34);
		panel.add(address);
		address.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 11, 776, 31);
		panel_1.setBackground(new Color(0, 153, 255));
		panel.add(panel_1);
		
		JLabel lblNewLabel_7 = new JLabel("Patient's Entry");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_7.setForeground(Color.WHITE);
		panel_1.add(lblNewLabel_7);
		
		bloodGroup = new JComboBox();
		bloodGroup.setBounds(376, 379, 153, 32);
		bloodGroup.setBackground(Color.WHITE);
		bloodGroup.setFont(new Font("Times New Roman", Font.BOLD, 20));
		bloodGroup.setForeground(new Color(0, 0, 255));
		bloodGroup.setModel(new DefaultComboBoxModel(new String[] {"A+", "O+", "B+", "AB+", "A-", "O-", "B-", "AB-"}));
		panel.add(bloodGroup);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(375, 297, 301, 45);
		panel_2.setBackground(new Color(224, 255, 255));
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		male = new JRadioButton("Male");
		buttonGroup.add(male);
		male.setActionCommand("Male");
		male.setBounds(6, 15, 66, 23);
		panel_2.add(male);
		
		female = new JRadioButton("Female");
		female.setActionCommand("Female");
		buttonGroup.add(female);
		female.setBounds(107, 15, 80, 23);
		panel_2.add(female);
		
		other = new JRadioButton("Other");
		buttonGroup.add(other);
		other.setActionCommand("Other");
		other.setBounds(217, 15, 66, 23);
		panel_2.add(other);
		
		JLabel lblNewLabel = new JLabel("Enter Patient Details");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(135, 53, 163, 36);
		panel.add(lblNewLabel);
		
		
	}

}
