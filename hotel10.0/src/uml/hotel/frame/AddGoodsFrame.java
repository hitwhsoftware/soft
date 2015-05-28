package uml.hotel.frame;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;





import uml.hotel.control.GoodsControl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;


public class AddGoodsFrame {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddGoodsFrame window = new AddGoodsFrame();
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
	public AddGoodsFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u589E\u52A0\u5546\u54C1");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.NORTH);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		frame.getContentPane().add(layeredPane_1, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("\u5546\u54C1\u7F16\u53F7");
		lblNewLabel.setBounds(92, 64, 54, 15);
		layeredPane_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5546\u54C1\u540D\u79F0");
		lblNewLabel_1.setBounds(92, 103, 54, 15);
		layeredPane_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5355\u4EF7");
		lblNewLabel_2.setBounds(92, 148, 54, 15);
		layeredPane_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u5E93\u5B58\u91CF");
		lblNewLabel_3.setBounds(92, 197, 54, 15);
		layeredPane_1.add(lblNewLabel_3);
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u8981\u589E\u52A0\u7684\u5546\u54C1\u4FE1\u606F\uFF1A");
		label.setBounds(92, 23, 227, 15);
		layeredPane_1.add(label);
		
		textField = new JTextField();
		textField.setBounds(203, 61, 66, 21);
		layeredPane_1.add(textField);
		textField.setColumns(10);
		//JTextField.setText(String.valueOf(3));
		
		textField_1 = new JTextField();
		textField_1.setBounds(203, 100, 66, 21);
		layeredPane_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(203, 145, 66, 21);
		layeredPane_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(203, 194, 66, 21);
		layeredPane_1.add(textField_3);
		textField_3.setColumns(10);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.setBackground(Color.GRAY);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//new UmlGoodsDAO(new UmlGoo);
				
				GoodsControl goodsControl = new GoodsControl();
				goodsControl.saveGoods(Integer.parseInt(textField.getText()), textField_1.getText(),Float.parseFloat(textField_2.getText()),Integer.parseInt(textField_3.getText()));
				frame.dispose();
		
			}
		});
		button.setBounds(203, 228, 93, 23);
		layeredPane_1.add(button);
		
		JButton button_1 = new JButton("\u53D6\u6D88");
		button_1.setBackground(Color.GRAY);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		button_1.setBounds(331, 228, 93, 23);
		layeredPane_1.add(button_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 434, 261);
		layeredPane_1.add(panel);
	}

	public JFrame getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}
}
