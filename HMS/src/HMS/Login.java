package HMS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField usernameTextField;
	private JPasswordField passwordTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 767, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel username = new JLabel("Username");
		username.setBounds(326, 205, 75, 19);
		username.setFont(new Font("Times New Roman", Font.BOLD, 17));
		contentPane.add(username);
		
		JLabel password = new JLabel("Password");
		password.setBounds(326, 268, 75, 18);
		password.setFont(new Font("Times New Roman", Font.BOLD, 17));
		contentPane.add(password);
		
		usernameTextField = new JTextField();
		usernameTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode()==KeyEvent.VK_DOWN) {
					passwordTextField.requestFocus();
				}
			}
		});
		usernameTextField.setBounds(456, 204, 178, 20);
		contentPane.add(usernameTextField);
		usernameTextField.setColumns(10);
		
		passwordTextField = new JPasswordField();
		passwordTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				
				if(evt.getKeyCode()==KeyEvent.VK_UP) {
					usernameTextField.requestFocus();
				}
				
				else if(evt.getKeyCode()==KeyEvent.VK_ENTER) {
                    try {
					
					String un =usernameTextField.getText();
					String pass=String.valueOf(passwordTextField.getPassword());
					
					if(un.isEmpty() || pass.isEmpty()){
						JOptionPane.showMessageDialog(null,"Username or password cannot be empty");
					}
					else {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "root");	
											
					PreparedStatement stmt=con.prepareStatement("Select username, password from login where username=? and password=?");
					stmt.setString(1,un);
					stmt.setString(2,pass);

					ResultSet rs =stmt.executeQuery();
					if(rs.next())
					{
						
						homepage sec=new homepage();
						sec.setVisible(true);
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null,"Inocrrect Username or Password");
					}
						con.close();
					}
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null,e);
				}
            }
			}
		});
		passwordTextField.setBounds(456, 266, 178, 20);
		contentPane.add(passwordTextField);
		
		JButton loginButton = new JButton("Login");
		loginButton.setForeground(Color.BLACK);
		loginButton.setBackground(Color.WHITE);
		loginButton.setBounds(251, 364, 107, 23);
		loginButton.setIcon(new ImageIcon("E:\\My Softwares\\Eclipse\\Icon and images for project\\login.png"));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				try {
					
					String un =usernameTextField.getText();
					String pass=String.valueOf(passwordTextField.getPassword());
					
					if(un.isEmpty() || pass.isEmpty()){
						JOptionPane.showMessageDialog(null,"Username or password cannot be empty");
					}
					else {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "root");	
											
					PreparedStatement stmt=con.prepareStatement("Select username, password from login where username=? and password=?");
					stmt.setString(1,un);
					stmt.setString(2,pass);

					ResultSet rs =stmt.executeQuery();
					if(rs.next())
					{
						
						homepage sec=new homepage();
						sec.setVisible(true);
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null,"Inocrrect Username or Password");
					}
						con.close();
					}
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null,e);
				}
			}
		});
		loginButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		contentPane.add(loginButton);
		
		JLabel lblNewLabel_1 = new JLabel("Login Page");
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1.setBounds(268, 53, 150, 44);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon("E:\\My Softwares\\Eclipse\\Icon and images for project\\Close.png"));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnNewButton.setBounds(567, 365, 114, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("E:\\My Softwares\\Eclipse\\Icon and images for project\\login Background test.png"));
		lblNewLabel.setBounds(0, 0, 751, 441);
		contentPane.add(lblNewLabel);
	}
}
