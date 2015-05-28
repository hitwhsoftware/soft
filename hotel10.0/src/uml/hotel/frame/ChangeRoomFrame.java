package uml.hotel.frame;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import uml.hotel.control.CustomerControl;
import uml.hotel.control.CustomerRoomControl;
import uml.hotel.control.RoomControl;
import uml.hotel.model.UmlCustomerRoom;
import uml.hotel.model.UmlRoom;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Timestamp;

import javax.swing.JPanel;

import java.awt.Color;

public class ChangeRoomFrame {

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
					ChangeRoomFrame window = new ChangeRoomFrame();
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
	public ChangeRoomFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 264, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		JButton button = new JButton("\u6362\u623F");
		button.setBackground(Color.GRAY);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int bookid = 0;
				//int type = 0;
				String	phone = null;
				Timestamp starTime = null;
				int NUM1 = Integer.parseInt(textField.getText());//房号
				int NUM2 = Integer.parseInt(textField_1.getText());//xinfanghao
				//type=Integer.parseInt(textField_2.getText());//类型
				int str8 =NUM2/100;
				int str9 =NUM1/100;
				int LL=0;
				for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(NUM2).size(); i++){				
					   LL=((UmlRoom) RoomControl.getRoomControl().findRoom(NUM2).get(i)).getIsLodge(); 
                }	
				if(((NUM2>=101&NUM2<=112)|(NUM2>=201&NUM2<=212)|(NUM2>=301&NUM2<=312)|(NUM2>=401&NUM2<=412))&LL==0){
				for(int i= 0 ; i<CustomerRoomControl.getCustomerRoomControl().findCustomerRoom(NUM1).size(); i++){
				phone=( (UmlCustomerRoom) CustomerRoomControl.getCustomerRoomControl().findCustomerRoom(NUM1).get(i)).getCusPhone();
				bookid=( (UmlCustomerRoom) CustomerRoomControl.getCustomerRoomControl().findCustomerRoom(NUM1).get(i)).getBookId();
				starTime= (  (UmlCustomerRoom) CustomerRoomControl.getCustomerRoomControl().findCustomerRoom(NUM1).get(i)).getStartTime() ;
				CustomerRoomControl.getCustomerRoomControl().deleteCustomerRoom(NUM1);
				}
	
				CustomerRoomControl.getCustomerRoomControl(). saveCustomerRoom(bookid,NUM2,phone,starTime,null,1,null);
		    	RoomControl.getRoomControl(). deleteroom(NUM1);
		    	RoomControl.getRoomControl(). saveRoom(NUM1,str9,0);
		    	RoomControl.getRoomControl(). deleteroom(NUM2);
		      	RoomControl.getRoomControl(). saveRoom(NUM2,str8,1);
		    	JOptionPane.showMessageDialog(frame, "\n 换房成功\n" +"","", JOptionPane.PLAIN_MESSAGE);
		    	frame.dispose();}
				else{
					JOptionPane.showMessageDialog(frame, "\n 换房失败\n" +"","", JOptionPane.PLAIN_MESSAGE);
				}

			}
		});
		button.setBounds(10, 217, 93, 23);
		layeredPane.add(button);
		
		JButton button_1 = new JButton("\u53D6\u6D88");
		button_1.setBackground(Color.GRAY);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    	frame.dispose();
			}
		});
		button_1.setBounds(145, 217, 93, 23);
		layeredPane.add(button_1);
		
		JLabel label = new JLabel("\u539F\u623F\u53F7");
		label.setBounds(25, 74, 54, 15);
		layeredPane.add(label);
		
		JLabel label_1 = new JLabel("\u65B0\u623F\u53F7");
		label_1.setBounds(25, 149, 54, 15);
		layeredPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(128, 71, 66, 21);
		layeredPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(128, 146, 66, 21);
		layeredPane.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 248, 262);
		layeredPane.add(panel);
	}

	public JFrame getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}
}
