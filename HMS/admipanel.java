package HMS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class admipanel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admipanel frame = new admipanel();
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
	public admipanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 757, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 0, 741, 420);
		contentPane.add(contentPane_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 153, 255));
		panel.setBounds(0, 24, 741, 58);
		contentPane_1.add(panel);
		
		JLabel lblAdmissionPannel = new JLabel("Admission Panel");
		lblAdmissionPannel.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmissionPannel.setForeground(Color.WHITE);
		lblAdmissionPannel.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lblAdmissionPannel.setBounds(256, 11, 260, 38);
		panel.add(lblAdmissionPannel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 153, 255));
		panel_1.setBounds(0, 114, 197, 306);
		contentPane_1.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setBounds(10, 67, 177, 44);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("to");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(71, 113, 46, 33);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Admission Panel");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(10, 157, 177, 28);
		panel_1.add(lblNewLabel_3);
		
		JButton btnAdmitPatient = new JButton("Admit Patient");
		btnAdmitPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new	admission().setVisible(true);
				dispose();
			}
		});
		btnAdmitPatient.setForeground(Color.BLUE);
		btnAdmitPatient.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnAdmitPatient.setBounds(296, 116, 233, 53);
		contentPane_1.add(btnAdmitPatient);
		
		JButton btnNewButton_1 = new JButton("View all Admissions");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new viewadmission().setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_1.setBounds(296, 299, 233, 53);
		contentPane_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update/Discharge");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new upordischarge().setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setForeground(Color.BLUE);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_2.setBounds(296, 206, 233, 46);
		contentPane_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new	homepage().setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setForeground(Color.BLUE);
		btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_3.setBounds(579, 364, 129, 33);
		contentPane_1.add(btnNewButton_3);
		
		
	}
}
