package uml.hotel.frame;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;





import uml.hotel.control.CustomerControl;
import uml.hotel.control.RoomControl;
import uml.hotel.dao.UmlCustomerDAO;
import uml.hotel.model.UmlCustomer;
import uml.hotel.control.CustomerRoomControl;
import uml.hotel.dao.UmlCustomerRoomDAO;
import uml.hotel.model.UmlCustomerRoom;
import java.awt.Color;
import javax.swing.JPanel;
public class liveFrame {

	private JFrame frame;
	protected Component liveFrame;
	protected JEditorPane liveFrame1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					liveFrame window = new liveFrame();
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
	public liveFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u5BA2\u6237\u5F00\u5355");
		frame.setBounds(100, 100, 339, 370);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBackground(new Color(144, 238, 144));
		layeredPane.setForeground(new Color(144, 238, 144));
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		JButton button = new JButton("\u786E\u8BA4");
		button.setBackground(Color.GRAY);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			

		
				@SuppressWarnings("unused")
				String str = textField.getText();//姓名
				String str1 = textField_1.getText();//身份证

				String str4 = textField_4.getText();//电话
				String str5 = textField_5.getText();//性别
			//	int str6 = Integer.parseInt(textField_6.getText());//订单号
				int str7 = Integer.parseInt(textField_7.getText());//房号
				int str8 =str7/100;

				
				if(str1.length()==18&str4.length()==11&str.length()>0&textField_7.getText()!=null)
				{
				Timestamp d = new Timestamp(System.currentTimeMillis()); 
		    	CustomerControl.getCustomerControl(). saveCustomer(str,str4,str1,str5,null,null,null);
		    	CustomerRoomControl.getCustomerRoomControl(). saveCustomerRoom(null,str7,str4,d,d,1,null);
		    	RoomControl.getRoomControl(). deleteroom(str7);
		    	RoomControl.getRoomControl(). saveRoom(str7,str8,1);
		    	frame.dispose();
				}
				else{
					JOptionPane.showMessageDialog(liveFrame, "\n 请输入正确的信息\n" +"","", JOptionPane.PLAIN_MESSAGE);
				}
			
		    	
				//	AdminControl.getAdminControl(). saveAdmin(100,"hello","hihihihi",2);
				//  AdminControl.getAdminControl(). deleteAdmin("hello");
					
		//			String STR100 ="hello";
		//			AdminControl.getAdminControl().findAdmin(STR100);
		//		    for(int i= 0 ; i<AdminControl.getAdminControl().findAdmin(STR100).size(); i++){
		//	    int AdminId=	(  (UmlAdmin) AdminControl.getAdminControl().findAdmin(STR100).get(i)).getAdminId();
		//		String AdminPwd =(  (UmlAdmin) AdminControl.getAdminControl().findAdmin(STR100).get(i)).getAdminPwd();
		//		    }
					
			//		AuthorityControl.getAuthorityControl(). saveAuthority(3,"hello");
		//		AuthorityControl.getAuthorityControl().deleteAuthority(2);
		//			CustomerControl.getCustomerControl(). saveCustomer(null,null,hihihi,hihihi,hihihi,hihihi,hihihi,12345,123,null,null, null);

				//	CustomerControl.getCustomerControl().deleteCustomer("PHONE");
				
	
				

				
	

				

				
	
				

				
			//	if(textField_7.getText().length()!=18){
			//		JOptionPane.showMessageDialog(liveFrame, "\n 请输入正确的天数\n" +
			//				"","", JOptionPane.PLAIN_MESSAGE);
			//	}
			//	else{
			//	}
			}
		});
		button.setBounds(35, 286, 64, 23);
		layeredPane.add(button);
		
		JLabel label = new JLabel("\u987E\u5BA2\u59D3\u540D");
		label.setBounds(45, 79, 64, 21);
		layeredPane.add(label);
		
		JLabel label_1 = new JLabel("\u8054\u7CFB\u7535\u8BDD");
		label_1.setBounds(45, 166, 64, 21);
		layeredPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7");
		label_2.setBounds(45, 121, 64, 21);
		layeredPane.add(label_2);
		
		JLabel label_5 = new JLabel("\u6027\u522B");
		label_5.setBounds(45, 212, 65, 21);
		layeredPane.add(label_5);
		
		JButton button_1 = new JButton("\u53D6\u6D88");
		button_1.setBackground(Color.GRAY);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
			}
		});
		button_1.setBounds(178, 286, 71, 23);
		layeredPane.add(button_1);
		
		textField = new JTextField();
		textField.setBounds(141, 79, 106, 21);
		layeredPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(141, 121, 106, 21);
		layeredPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(141, 166, 106, 21);
		layeredPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(141, 212, 106, 21);
		layeredPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_7 = new JTextField();
	
		textField_7.setBounds(141, 36, 66, 23);
		layeredPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel label_6 = new JLabel("\u623F\u53F7");
		label_6.setBounds(45, 40, 54, 15);
		layeredPane.add(label_6);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 323, 332);
		layeredPane.add(panel);
	}

	public JFrame getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}
}