package uml.hotel.frame;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;

import javax.swing.JTextPane;

import java.awt.SystemColor;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import uml.hotel.control.AdminControl;
import uml.hotel.model.UmlAdmin;
import uml.hotel.model.UmlCustomerRoom;

import java.awt.Color;
import javax.swing.JPanel;


public class LoginFrame {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame window = new LoginFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u524D\u53F0\u767B\u5F55");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon icon1 = new ImageIcon("1.jpg");
		JLayeredPane layeredPane = new JLayeredPane();
		
		layeredPane.setToolTipText("");
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(173, 84, 174, 22);
		layeredPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(173, 140, 174, 22);
		layeredPane.add(textField_1);
		
		JButton button = new JButton("\u767B\u5F55");
		button.setBackground(Color.GRAY);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = textField.getText();//·¿ºÅ
				String num2 = textField_1.getText();//·¿ºÅ
				String num3 = null;
				for(int i= 0 ; i<AdminControl.getAdminControl().findAdmin(num).size(); i++){
					num3=( (UmlAdmin) AdminControl.getAdminControl().findAdmin(num).get(i)).getAdminPwd();
					System.out.print(num3);
					System.out.print(num2);
				}
				if(num2.equals(num3)){
				frame.dispose();
				mainFrame mUI = new mainFrame();
				mUI.getFrame().setVisible(true);}
				else{
					JOptionPane.showMessageDialog(frame, "\n ÃÜÂë´íÎó\n" +"","", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		button.setBounds(104, 203, 93, 23);
		layeredPane.add(button);
		
		JButton button_1 = new JButton("\u9000\u51FA");
		button_1.setBackground(Color.GRAY);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_1.setBounds(254, 203, 93, 23);
		layeredPane.add(button_1);
		
		JLabel lblNewLabel = new JLabel("UML\u9152\u5E97\u524D\u53F0\u767B\u5F55");
		lblNewLabel.setForeground(new Color(102, 153, 255));
		lblNewLabel.setFont(new Font("ËÎÌå", Font.PLAIN, 24));
		lblNewLabel.setBounds(126, 10, 188, 39);
		layeredPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u8D26\u53F7\uFF1A");
		lblNewLabel_1.setFont(new Font("ËÎÌå", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(90, 79, 68, 36);
		layeredPane.add(lblNewLabel_1);
		
		JLabel label = new JLabel("\u5BC6\u7801\uFF1A");
		label.setFont(new Font("ËÎÌå", Font.PLAIN, 19));
		label.setBounds(90, 130, 68, 36);
		layeredPane.add(label);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 434, 262);
		layeredPane.add(panel);
	}
}
