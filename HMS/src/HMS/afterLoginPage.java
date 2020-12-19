package HMS;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class afterLoginPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					afterLoginPage frame = new afterLoginPage();
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
	public afterLoginPage() {
		setBackground(new Color(240, 240, 240));
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 664);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 127));
		panel.setBounds(0, 0, 761, 625);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menu");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		lblNewLabel.setBounds(254, 28, 189, 47);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\My Softwares\\Eclipse\\Icon and images for project\\128-128-6595d2c267c26c4edc2fc7173b41b4fc-doctor.png"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(57, 103, 132, 145);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon("E:\\My Softwares\\Eclipse\\Icon and images for project\\doctor.png"));
		lblNewLabel_2.setBounds(287, 103, 132, 145);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("E:\\My Softwares\\Eclipse\\Icon and images for project\\hospital.png"));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(537, 103, 132, 145);
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Patients");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PatientPanel().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton.setBounds(57, 259, 132, 47);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Doctors");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new doctorpanel().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(0, 0, 255));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_1.setBounds(287, 259, 132, 47);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Floor info");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new floor().setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setForeground(new Color(0, 0, 255));
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_2.setBounds(502, 259, 189, 47);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setIcon(new ImageIcon("E:\\My Softwares\\Eclipse\\Icon and images for project\\appointment.png"));
		lblNewLabel_4.setBounds(146, 384, 132, 145);
		panel.add(lblNewLabel_4);
		
		JButton btnNewButton_3 = new JButton("OPD/Appoinment");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new	opd().setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setForeground(new Color(0, 0, 255));
		btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_3.setBounds(116, 530, 194, 47);
		panel.add(btnNewButton_3);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("E:\\My Softwares\\Eclipse\\Icon and images for project\\hospital-bed.png"));
		lblNewLabel_5.setBounds(443, 384, 132, 145);
		panel.add(lblNewLabel_5);
		
		JButton btnNewButton_4 = new JButton("Admission/Discharge");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new	admipanel().setVisible(true);
					dispose();
			}
		});
		btnNewButton_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_4.setForeground(new Color(0, 0, 255));
		btnNewButton_4.setBounds(408, 530, 215, 47);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Logout");
		btnNewButton_5.setIcon(new ImageIcon("E:\\My Softwares\\Eclipse\\Icon and images for project\\exit.png"));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Login().setVisible(true);
				dispose();
			}
		});
		btnNewButton_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_5.setBackground(Color.RED);
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.setBounds(599, 11, 152, 64);
		panel.add(btnNewButton_5);
	}
}
