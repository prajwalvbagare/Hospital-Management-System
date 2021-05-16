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

public class opd extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					opd frame = new opd();
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
	public opd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 891, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 875, 449);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 153, 255));
		panel_1.setBounds(0, 28, 875, 58);
		panel.add(panel_1);
		
		JLabel lblDoctorPannel = new JLabel("Appoinment Panel");
		lblDoctorPannel.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctorPannel.setForeground(Color.WHITE);
		lblDoctorPannel.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lblDoctorPannel.setBounds(300, 11, 260, 38);
		panel_1.add(lblDoctorPannel);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(0, 153, 255));
		panel_1_1.setBounds(0, 143, 233, 306);
		panel.add(panel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setBounds(23, 65, 177, 44);
		panel_1_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("to");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(90, 113, 46, 33);
		panel_1_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Appoinment Panel");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(10, 157, 213, 28);
		panel_1_1.add(lblNewLabel_3);
		
		JButton btnSetAppoinment = new JButton("Set Appoinment");
		btnSetAppoinment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new	stap().setVisible(true);
				setVisible(false);
				}
		});
		btnSetAppoinment.setForeground(Color.BLUE);
		btnSetAppoinment.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSetAppoinment.setBounds(357, 136, 233, 53);
		panel.add(btnSetAppoinment);
		
		JButton btnNewButton_1 = new JButton("Update/Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new	udap().setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_1.setBounds(357, 244, 233, 53);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("View All Appoinments");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new viewappoinments().setVisible(true);
					dispose();
			}
		});
		btnNewButton_2.setForeground(Color.BLUE);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_2.setBounds(357, 340, 233, 53);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				new	homepage().setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton.setBounds(683, 385, 89, 23);
		panel.add(btnNewButton);
	}

}
