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
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class addDoctor extends JFrame {

	private JPanel contentPane;
	private JTextField dName;
	private JTextField dCNo;
	private JComboBox specialization;
	private JRadioButton male;
	private JRadioButton female;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField age;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addDoctor frame = new addDoctor();
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
	public addDoctor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 747, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 240, 245));
		panel.setBounds(0, 0, 731, 560);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 11, 731, 31);
		panel_1.setBackground(new Color(0, 153, 255));
		panel.add(panel_1);
		
		JLabel lblNewLabel_7 = new JLabel("Doctor's Entry");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(108, 78, 94, 23);
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Contact NO");
		lblNewLabel_2.setBounds(108, 144, 94, 23);
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setBackground(SystemColor.menu);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Gender");
		lblNewLabel_4.setBounds(108, 229, 94, 23);
		lblNewLabel_4.setForeground(Color.BLUE);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Doctor Speclization");
		lblNewLabel_5.setBounds(108, 298, 189, 23);
		lblNewLabel_5.setForeground(Color.BLUE);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel.add(lblNewLabel_5);
		
		JButton clear = new JButton("Clear");
		clear.setBounds(70, 444, 134, 45);
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dName.setText("");
				dCNo.setText("");
				buttonGroup.clearSelection();
				specialization.setSelectedIndex(0);
				age.setText(null);
				dName.requestFocus();
			}
		});
		clear.setForeground(Color.BLUE);
		clear.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel.add(clear);
		
		JButton save = new JButton("Save");
		save.setBounds(342, 444, 134, 45);
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String a=dName.getText();
				String b=dCNo.getText();
				if(a.isEmpty()||b.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Please fill all details");
				}
				else{
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "root");
					PreparedStatement stmt=con.prepareStatement("insert into doctor(doctorId,name,contactNo,gender,specialization,age)values(null,?,?,?,?,?)");
					stmt.setString(1,dName.getText());
					stmt.setString(2,dCNo.getText());
					stmt.setString(3,buttonGroup.getSelection().getActionCommand());
					stmt.setString(4,(String)specialization.getSelectedItem());	
					stmt.setString(5,age.getText());
					
					stmt.executeUpdate();
					JOptionPane.showMessageDialog(null,"Doctor added");
					con.close();
					new	doctorpanel().setVisible(true);
						dispose();
				
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null,"Enter the corect details");
				}}
			}
		});
		save.setForeground(Color.BLUE);
		save.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel.add(save);
		
		JButton back = new JButton("Back");
		back.setBounds(588, 444, 112, 45);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new	doctorpanel().setVisible(true);
					setVisible(false);
			}
		});
		back.setForeground(Color.BLUE);
		back.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel.add(back);
		
		dName = new JTextField();
		dName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode()==KeyEvent.VK_DOWN) {
					dCNo.requestFocus();
				}
			}
		});
		dName.setBounds(371, 76, 241, 32);
		dName.setColumns(10);
		panel.add(dName);
		
		dCNo = new JTextField();
		dCNo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode()==KeyEvent.VK_DOWN) {
					age.requestFocus();
				}
				
				if(evt.getKeyCode()==KeyEvent.VK_UP) {
					dName.requestFocus();
				}
			}
		});
		dCNo.setBounds(371, 142, 241, 32);
		dCNo.setColumns(10);
		panel.add(dCNo);
		
		specialization = new JComboBox();
		specialization.setBounds(371, 296, 241, 32);
		specialization.setModel(new DefaultComboBoxModel(new String[] {"kidney", "general"}));
		specialization.setBackground(Color.WHITE);
		panel.add(specialization);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(371, 215, 241, 37);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		male = new JRadioButton("Male");
		buttonGroup.add(male);
		male.setActionCommand("Male");
		male.setBounds(6, 7, 63, 23);
		panel_2.add(male);
		
		female = new JRadioButton("Female");
		buttonGroup.add(female);
		female.setActionCommand("Female");
		female.setBounds(126, 7, 109, 23);
		panel_2.add(female);
		
		JLabel lblNewLabel = new JLabel("Age");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setBounds(108, 367, 94, 31);
		panel.add(lblNewLabel);
		
		age = new JTextField();
		age.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				
				if(evt.getKeyCode()==KeyEvent.VK_UP) {
					dCNo.requestFocus();
				}
			}
		});
		age.setBackground(Color.WHITE);
		age.setBounds(371, 367, 105, 31);
		panel.add(age);
		age.setColumns(10);
	}
}
