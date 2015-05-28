package proj.dor.dormitoryUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import proj.dor.control.checkDomitoryControl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckDomitoryUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	
	private String dorId;
	private String isquilt;
	private String isgarbage;
	private String isdesk;
	private String isbalcony;
	private String score;
	private String remark;
	private String checkDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckDomitoryUI window = new CheckDomitoryUI();
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
	public CheckDomitoryUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 377, 468);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("\u5BBF\u820D\u53F7\uFF1A");
		label.setBounds(33, 38, 73, 24);
		panel.add(label);
		
		textField = new JTextField();
		textField.setBounds(132, 40, 88, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u88AB\u5B50\u662F\u5426\u53E0\uFF1A");
		label_1.setBounds(33, 72, 93, 21);
		panel.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(132, 72, 66, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("\u5783\u573E\u662F\u5426\u5012\uFF1A");
		label_2.setBounds(33, 103, 113, 21);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("\u684C\u5B50\u662F\u5426\u6574\u6D01\uFF1A");
		label_3.setBounds(33, 137, 113, 15);
		panel.add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(132, 103, 66, 21);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(132, 134, 66, 21);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_4 = new JLabel("\u9633\u53F0\u662F\u5426\u6574\u6D01\uFF1A");
		label_4.setBounds(33, 168, 113, 15);
		panel.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(132, 165, 66, 21);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel label_5 = new JLabel("\u5F97\u5206\uFF1A");
		label_5.setBounds(33, 193, 54, 15);
		panel.add(label_5);
		
		textField_5 = new JTextField();
		textField_5.setBounds(132, 194, 66, 21);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton = new JButton("\u4FDD\u5B58");
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dorId = textField.getText();
				isquilt = textField_1.getText();
				isgarbage = textField_2.getText();
				isdesk   = textField_3.getText();
				isbalcony = textField_4.getText();
				score     = textField_5.getText();
				remark    = textField_6.getText();
				SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				 Date now   = new Date();
				 checkDate  = sdf.format( now );
				checkDomitoryControl.getCheckDomitory().saveCheckDormitory(dorId, isquilt, isgarbage, isdesk, isbalcony,checkDate, score, remark);
			}
		});
		btnNewButton.setBounds(258, 381, 93, 38);
		panel.add(btnNewButton);
		
		JLabel label_6 = new JLabel("\u5907\u6CE8\uFF1A");
		label_6.setBounds(33, 222, 54, 15);
		panel.add(label_6);
		
		textField_6 = new JTextField();
		textField_6.setBounds(132, 225, 177, 111);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u67E5\u770B\u5BBF\u820D\u536B\u751F\u4FE1\u606F");
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DomitoryInforUI domitoryInfUI = new DomitoryInforUI();
				domitoryInfUI.getFrame().setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(94, 381, 154, 38);
		panel.add(btnNewButton_1);
	}
	public void closeThis(){
		frame.dispose();
	}
}
