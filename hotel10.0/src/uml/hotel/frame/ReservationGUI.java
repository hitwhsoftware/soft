package uml.hotel.frame;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import uml.hotel.control.ReservationControl;
import uml.hotel.dao.UmlReservationDAO;
import uml.hotel.dao.UmlRoomDAO;
import uml.hotel.model.UmlRoom;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JComboBox;

public class ReservationGUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_2;
	
	private Component warn;
	DateChooser startDate;
	DateChooser endDate;
	String startTime = null;
	String endTime = null;
	String reserTime = null;
	int roomId = 0;
	String cusPhone = null;
	int reserId = 0;
	String remark = null;
	final JComboBox<Integer> comboBox = new JComboBox<Integer>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservationGUI window = new ReservationGUI();
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
	public ReservationGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 373, 442);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("\u7535\u8BDD\u53F7\uFF1A");
		label.setBounds(10, 27, 54, 15);
		panel.add(label);
		
		textField = new JTextField();
		textField.setBounds(125, 24, 100, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u623F\u95F4\u53F7\uFF1A");
		label_1.setBounds(10, 58, 54, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("\u9884\u8BA1\u5165\u4F4F\u65F6\u95F4\uFF1A");
		label_2.setBounds(10, 94, 108, 15);
		panel.add(label_2);
		
		startDate = new DateChooser("yyyy-MM-dd");
		startDate.setBounds(125, 86, 100, 24);
		panel.add(startDate);
		
		JLabel label_3 = new JLabel("\u9884\u8BA1\u9000\u623F\u65F6\u95F4\uFF1A");
		label_3.setBounds(10, 132, 93, 15);
		panel.add(label_3);
		
		endDate = new DateChooser("yyyy-MM-dd");
		endDate.setBounds(125, 123, 100, 24);
		panel.add(endDate);
		
		JLabel label_4 = new JLabel("\u5907\u6CE8\uFF1A");
		label_4.setBounds(10, 164, 54, 15);
		panel.add(label_4);
		
		
		
		JButton button = new JButton("\u9884\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				if(textField_1.getText().length() < 0)
//				{
//					JOptionPane.showMessageDialog(warn, "\n 请输入房间号！\n" +
//							"","", JOptionPane.PLAIN_MESSAGE);
//				}
				if(textField.getText().length() < 0)
				{
					 JOptionPane.showMessageDialog(warn, "\n 请输入手机号！\n" +
								"","", JOptionPane.PLAIN_MESSAGE);
				}
				SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				 startTime  = sdf.format(startDate.getDate().getTime());
				 endTime    = sdf.format(endDate.getDate().getTime());
				 Date now   = new Date();
				 reserTime  = sdf.format( now );
//				 roomId     = Integer.parseInt(textField_1.getText());
				 //roomId     = 0;
				 cusPhone   = textField.getText();
				 remark     = textField_2.getText();
				 List list  = new UmlReservationDAO().findAll();
				 reserId    = 1001 + list.size();
				 String s = comboBox.getSelectedItem().toString();
					roomId = Integer.parseInt(s);
				 
				 
//				 if(!ReservationControl.getReservationControl().saveReservation(1001, 238, "184", "2015-05-22 17:06:01", "2015-05-28 17:06:01", "2015-05-28 17:06:01", "remark"))
//				 {
//					 JOptionPane.showMessageDialog(warn, "\n 预约失败！\n" +
//								"","", JOptionPane.PLAIN_MESSAGE);
//				 }
				 
					 if(ReservationControl.getReservationControl().saveReservation(reserId, roomId, cusPhone, startTime, endTime, reserTime, remark))
					 {
						 JOptionPane.showMessageDialog(warn, "\n 预约成功！\n" +
									"","", JOptionPane.PLAIN_MESSAGE);
					 }
					 else
					 {
						 JOptionPane.showMessageDialog(warn, "\n 预约失败！\n" +
									"","", JOptionPane.PLAIN_MESSAGE);
					 }
				 
				 
			}
		});
		button.setBackground(Color.GRAY);
		button.setBounds(36, 361, 84, 32);
		panel.add(button);
		
		textField_2 = new JTextField();
		textField_2.setBounds(125, 164, 208, 88);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JButton button_1 = new JButton("\u67E5\u770B\u9884\u5B9A\u4FE1\u606F");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//closeThis();
				ReservationStatisticGUI reservationStatisticGUI = new ReservationStatisticGUI();
				reservationStatisticGUI.getFrame().setVisible(true);
			}
		});
		button_1.setBackground(Color.GRAY);
		button_1.setBounds(136, 362, 114, 31);
		panel.add(button_1);
		
		
		comboBox.setBackground(Color.GRAY);
		comboBox.setBounds(125, 55, 100, 21);
		
		panel.add(comboBox);
		
		JButton btnNewButton = new JButton("取消");
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   	frame.dispose();
			}
		});
		btnNewButton.setBounds(260, 361, 73, 32);
		panel.add(btnNewButton);
		
			List list = new UmlRoomDAO().findAll();
			for(int i = 0; i < list.size(); i++)
			{
				comboBox.addItem( ((UmlRoom)list.get(i)).getRoomId());
			}
			


	}
	
	public void closeThis(){
		frame.dispose();
	}
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
