package uml.hotel.frame;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Timestamp;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import uml.hotel.control.CustomerRoomControl;
import uml.hotel.control.RoomControl;
import uml.hotel.control.RoomGoodsControl;
import uml.hotel.model.UmlCustomerRoom;
import uml.hotel.model.UmlRoom;
import uml.hotel.model.UmlRoomGoods;
import java.awt.Color;


public class CheckoutFrame extends JFrame {
	private JFrame frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	int TID;
	float goodscost;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckoutFrame frame1 = new CheckoutFrame();
					frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CheckoutFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 469, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);
		
		textField = new JTextField();
		textField.setBounds(10, 41, 73, 21);
		layeredPane.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u623F\u95F4\u53F7");
		label.setBounds(10, 16, 84, 15);
		layeredPane.add(label);
		
		table = new JTable();

		table.setRowHeight(30);
		table.setBounds(10, 121, 433, 158);
		layeredPane.add(table);
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s;
				s=textField.getText();
				Integer n=Integer.parseInt(textField.getText());
			

				for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(n).size(); i++){				
				   TID=( (UmlRoom) RoomControl.getRoomControl().findRoom(n).get(i)).getTypeId() ; 
				
				  

				}	

				
				
				
				for(int i= 0 ; i<RoomGoodsControl.getRoomGoodsControl().findRoomGoods(n).size(); i++){				
				  goodscost=( (UmlRoomGoods) RoomGoodsControl.getRoomGoodsControl().findRoomGoods(n).get(i)).getIsSettle() ; 
				  System.out.println(goodscost);
				 

				}
				 
				  
				
				 for(int i= 0 ; i<CustomerRoomControl.getCustomerRoomControl().findCustomerRoom(n).size(); i++){				
					 Timestamp starTime= (  (UmlCustomerRoom) CustomerRoomControl.getCustomerRoomControl().findCustomerRoom(n).get(i)).getStartTime() ;
					 
					 Timestamp	 endTime = new Timestamp(System.currentTimeMillis()); 
					 System.out.println(starTime);
					 System.out.println(endTime);
				   long _starTime =  ((java.sql.Timestamp) starTime).getTime();
			       long _endTime = ((java.sql.Timestamp) endTime).getTime();   
			       System.out.println(_starTime);
					  System.out.println(_endTime);
			       
			       
			       long days = (long) ((_endTime-_starTime)/(  1000 * 3600 * 24)+1);
			       System.out.println(days);
			 
			       float cost=TID*100*days;
			       float total=cost+goodscost;
			       //table.fireTableChanged();
					table.setModel(new DefaultTableModel(
							new Object[][] {
								{"房间类型", TID},
								{"入住天数", days},
								{"物品消费", goodscost},
								{"房间费用", cost},
								{"总费用", total},
							},
							new String[] {
								"New column", "New column"
							}
						));
				
				//	RoomControl.getRoomControl(). deleteroom(n);
			     
				}	 
			}
		});
		btnNewButton.setBounds(112, 40, 93, 23);
		layeredPane.add(btnNewButton);
		
		JLabel label_1 = new JLabel("\u6D88\u8D39\u4FE1\u606F");
		label_1.setBounds(10, 87, 73, 15);
		layeredPane.add(label_1);
		
		
		
		JButton btnNewButton_1 = new JButton("\u7ED3\u8D26");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer n=Integer.parseInt(textField.getText());
				RoomControl.getRoomControl(). deleteroom(n);
			 	RoomControl.getRoomControl(). saveRoom(n,TID,0);
			 	 CustomerRoomControl.getCustomerRoomControl().deleteCustomerRoom(n);
				dispose();
			}
		});
		btnNewButton_1.setBounds(206, 289, 93, 23);
		layeredPane.add(btnNewButton_1);
		
		JButton button = new JButton("\u53D6\u6D88");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setBounds(340, 289, 93, 23);
		layeredPane.add(button);
		
	}
	public void setFrame(JFrame frame){
		this.frame = frame;
	}
	public JFrame getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}
}

