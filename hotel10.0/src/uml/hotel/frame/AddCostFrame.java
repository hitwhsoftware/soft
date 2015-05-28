package uml.hotel.frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;

import uml.hotel.control.GoodsControl;
import uml.hotel.control.RoomControl;
import uml.hotel.control.RoomGoodsControl;
import uml.hotel.model.UmlGoods;
import uml.hotel.model.UmlRoom;
import uml.hotel.model.UmlRoomGoods;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Color;
import javax.swing.JPanel;

public class AddCostFrame {

	private JFrame frame;
	private JTable table;
	private JTable table_2;
	private JTextField textField_1;
	private JTable table_1;
	private JTextField textField;
	private JTextField textField_2;

	int RID;//选择增加消费的房间号
	int GID;//选择消费的商品编号
	int GNum;//选择消费该商品的数量
	int TPrice;//
	int totalPrice ;//计算顾客消费总价
	int[] Num=new int[11];
	float Price;
	int[] thisGID=new int[11];//从数据库中获取库存中的商品编号
	String[] thisGName=new String[11];//从数据库中获取库存中的商品名字
	float[] thisGPrice=new float[11];//从数据库中获取该商品的价格
	int[] thisGNum=new int[11];//从数据库中获取该商品的库存量
	private final JPanel panel = new JPanel();
	/**
	 * Launch the application.
	 */
	
	public Component getFrame(){
		return frame;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCostFrame window = new AddCostFrame();
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
	public AddCostFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u589E\u52A0\u6D88\u8D39");
		frame.setBounds(100, 100, 631, 458);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBackground(Color.WHITE);
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("\u9009\u62E9\u6D88\u8D39\u9879\u76EE\uFF1A");
		lblNewLabel.setBounds(32, 22, 91, 15);
		layeredPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5F53\u524D\u5DF2\u6D88\u8D39\uFF1A");
		lblNewLabel_1.setBounds(384, 22, 79, 15);
		layeredPane.add(lblNewLabel_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"\u9879\u76EE", "\u5355\u4EF7", "\u6570\u91CF", "\u5C0F\u8BA1"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Float.class, Integer.class, Float.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(85);
		table.getColumnModel().getColumn(0).setMinWidth(20);
		table.setBounds(384, 64, 207, 160);
		layeredPane.add(table);

	

		JLabel label = new JLabel("\u9879\u76EE");
		label.setBounds(384, 47, 54, 15);
		layeredPane.add(label);
		
		JLabel lblNewLabel_2 = new JLabel("\u5355\u4EF7");
		lblNewLabel_2.setBounds(448, 47, 54, 15);
		layeredPane.add(lblNewLabel_2);
		
		JLabel label_1 = new JLabel("\u6570\u91CF");
		label_1.setBounds(493, 47, 54, 15);
		layeredPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u5C0F\u8BA1");
		label_2.setBounds(545, 47, 54, 15);
		layeredPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u5546\u54C1\u7F16\u53F7\uFF1A");
		label_3.setBounds(31, 86, 69, 15);
		layeredPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u6570\u91CF\uFF1A");
		label_4.setBounds(32, 121, 54, 15);
		layeredPane.add(label_4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(96, 118, 66, 21);
		layeredPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.setBackground(Color.GRAY);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				 RID = Integer.parseInt(textField_2.getText());
				 GID = Integer.parseInt(textField.getText());
				 GNum = Integer.parseInt(textField_1.getText());

				 RoomGoodsControl.getRoomGoodsControl().saveRoomGoods(2015, RID,GID,GNum,totalPrice,"无");
				  
				for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(RID).size(); i++){				
					TPrice=( (  (UmlRoom) RoomControl.getRoomControl().findRoom(RID).get(i)).getTypeId())*100 ; 
				}
				

				if(GID==1001){
					for(int i= 0 ; i<RoomGoodsControl.getRoomGoodsControl().findRoomGoods(RID).size(); i++){				
						Num[0] =( (  (UmlRoomGoods) RoomGoodsControl.getRoomGoodsControl().findRoomGoods(RID).get(i)).getGoodNum()) ; 
					}
				}
		
				else if(GID==1002){	
					for(int i= 0 ; i<RoomGoodsControl.getRoomGoodsControl().findRoomGoods(RID).size(); i++){
						Num[1] =( (  (UmlRoomGoods) RoomGoodsControl.getRoomGoodsControl().findRoomGoods(RID).get(i)).getGoodNum()) ; 
					}			
				}
				
				else if(GID==1003){	
					for(int i= 0 ; i<RoomGoodsControl.getRoomGoodsControl().findRoomGoods(RID).size(); i++){
						Num[2] =( (  (UmlRoomGoods) RoomGoodsControl.getRoomGoodsControl().findRoomGoods(RID).get(i)).getGoodNum()) ; 
					}			
				}
				
				else if(GID==1004){	
					for(int i= 0 ; i<RoomGoodsControl.getRoomGoodsControl().findRoomGoods(RID).size(); i++){
						Num[3] =( (  (UmlRoomGoods) RoomGoodsControl.getRoomGoodsControl().findRoomGoods(RID).get(i)).getGoodNum()) ; 
					}			
				}
				
				else if(GID==1005){	
					for(int i= 0 ; i<RoomGoodsControl.getRoomGoodsControl().findRoomGoods(RID).size(); i++){
						Num[4] =( (  (UmlRoomGoods) RoomGoodsControl.getRoomGoodsControl().findRoomGoods(RID).get(i)).getGoodNum()) ; 
					}			
				}
				    totalPrice = Num[0]*5 + Num[1]*3 + Num[2]*5 + Num[3]*7 + Num[4]*5;
				    RoomGoodsControl.getRoomGoodsControl().saveRoomGoods(2015, RID,GID,GNum,totalPrice,"总价");
				    
					table_2 = new JTable();
					table_2.setModel(new DefaultTableModel(
						new Object[][] {
							{"房间", TPrice, 1, TPrice},
							{"方便面", 5, Num[0], Num[0]*5},
							{"矿泉水", 3, Num[1], Num[1]*3},
							{"牛奶", 5, Num[2], Num[2]*5},
							{"红牛", 7, Num[3], Num[3]*7},
							{"加多宝", 5, Num[4], Num[4]*5},
							{null, null, null, null},
							{null, null, null, null},
							{null, null, null, null},
							{null, null, null, null},
						},
						new String[] {
							"\u9879\u76EE", "\u5355\u4EF7", "\u6570\u91CF", "\u5C0F\u8BA1"
						}
					) {
						Class[] columnTypes = new Class[] {
							String.class, Float.class, Integer.class, Float.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					});
					table_2.getColumnModel().getColumn(0).setPreferredWidth(85);
					table_2.getColumnModel().getColumn(0).setMinWidth(20);
					table_2.setBounds(384, 64, 208, 160);
					layeredPane.add(table_2);
			}
		});
		button.setBounds(101, 159, 91, 28);
		layeredPane.add(button);
		JLabel label_5 = new JLabel("\u53EF\u6D88\u8D39\u9879\u76EE\uFF1A");
		label_5.setBounds(32, 209, 91, 15);
		layeredPane.add(label_5);
		
	
		for(int i= 0 ; i<GoodsControl.getGoodsControl().findGoods(1001).size(); i++){
			thisGID[0] = (  (UmlGoods) GoodsControl.getGoodsControl().findGoods(1001).get(i)).getGoodId(); 
			thisGName[0] = (  (UmlGoods) GoodsControl.getGoodsControl().findGoods(1001).get(i)).getGoodName();
			thisGPrice[0] = (  (UmlGoods) GoodsControl.getGoodsControl().findGoods(1001).get(i)).getGoodPrice();
			thisGNum[0] = (  (UmlGoods) GoodsControl.getGoodsControl().findGoods(1001).get(i)).getGoodNum(); 
		}
		
		for(int i= 0 ; i<GoodsControl.getGoodsControl().findGoods(1002).size(); i++){
			thisGID[1] = (  (UmlGoods) GoodsControl.getGoodsControl().findGoods(1002).get(i)).getGoodId(); 
			thisGName[1] = (  (UmlGoods) GoodsControl.getGoodsControl().findGoods(1002).get(i)).getGoodName();
			thisGPrice[1] = (  (UmlGoods) GoodsControl.getGoodsControl().findGoods(1002).get(i)).getGoodPrice();
			thisGNum[1] = (  (UmlGoods) GoodsControl.getGoodsControl().findGoods(1002).get(i)).getGoodNum(); 
		}
		
		for(int i= 0 ; i<GoodsControl.getGoodsControl().findGoods(1003).size(); i++){
			thisGID[2] = (  (UmlGoods) GoodsControl.getGoodsControl().findGoods(1003).get(i)).getGoodId(); 
			thisGName[2] = (  (UmlGoods) GoodsControl.getGoodsControl().findGoods(1003).get(i)).getGoodName();
			thisGPrice[2] = (  (UmlGoods) GoodsControl.getGoodsControl().findGoods(1003).get(i)).getGoodPrice();
			thisGNum[2] = (  (UmlGoods) GoodsControl.getGoodsControl().findGoods(1003).get(i)).getGoodNum(); 
		}
		
		for(int i= 0 ; i<GoodsControl.getGoodsControl().findGoods(1004).size(); i++){
			thisGID[3] = (  (UmlGoods) GoodsControl.getGoodsControl().findGoods(1004).get(i)).getGoodId(); 
			thisGName[3] = (  (UmlGoods) GoodsControl.getGoodsControl().findGoods(1004).get(i)).getGoodName();
			thisGPrice[3] = (  (UmlGoods) GoodsControl.getGoodsControl().findGoods(1004).get(i)).getGoodPrice();
			thisGNum[3] = (  (UmlGoods) GoodsControl.getGoodsControl().findGoods(1004).get(i)).getGoodNum(); 
		}
		
		for(int i= 0 ; i<GoodsControl.getGoodsControl().findGoods(1005).size(); i++){
			thisGID[4] = (  (UmlGoods) GoodsControl.getGoodsControl().findGoods(1005).get(i)).getGoodId(); 
			thisGName[4] = (  (UmlGoods) GoodsControl.getGoodsControl().findGoods(1005).get(i)).getGoodName();
			thisGPrice[4] = (  (UmlGoods) GoodsControl.getGoodsControl().findGoods(1005).get(i)).getGoodPrice();
			thisGNum[4] = (  (UmlGoods) GoodsControl.getGoodsControl().findGoods(1005).get(i)).getGoodNum(); 
		}
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{thisGID[0], thisGName[0], thisGPrice[0], thisGNum[0]},
				{thisGID[1], thisGName[1], thisGPrice[1], thisGNum[1]},
				{thisGID[2], thisGName[2], thisGPrice[2], thisGNum[2]},
				{thisGID[3], thisGName[3], thisGPrice[3], thisGNum[3]},
				{thisGID[4], thisGName[4], thisGPrice[4], thisGNum[4]},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"\u5546\u54C1\u7F16\u53F7", "\u5546\u54C1", "\u5355\u4EF7", "\u5269\u4F59\u5E93\u5B58"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Float.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_1.getColumnModel().getColumn(0).setPreferredWidth(129);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(131);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(128);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(106);
		table_1.setBounds(32, 248, 246, 162);
		layeredPane.add(table_1);
		
		JLabel label_6 = new JLabel("\u9879\u76EE");
		label_6.setBounds(96, 234, 54, 15);
		layeredPane.add(label_6);
		
		JLabel label_7 = new JLabel("\u5355\u4EF7\uFF08\u5143\uFF09");
		label_7.setBounds(162, 234, 69, 15);
		layeredPane.add(label_7);
		
		JLabel label_8 = new JLabel("\u5E93\u5B58");
		label_8.setBounds(235, 234, 54, 15);
		layeredPane.add(label_8);
		
		JButton btnNewButton = new JButton("\u9000\u51FA");
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(418, 303, 133, 63);
		layeredPane.add(btnNewButton);
		
		JLabel label_9 = new JLabel("\u5546\u54C1\u7F16\u53F7");
		label_9.setBounds(32, 234, 54, 15);
		layeredPane.add(label_9);
		
		textField = new JTextField();
		textField.setBounds(98, 83, 66, 21);
		layeredPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u623F\u95F4\uFF1A");
		lblNewLabel_3.setBounds(32, 47, 54, 15);
		layeredPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(96, 47, 66, 21);
		layeredPane.add(textField_2);
		textField_2.setColumns(10);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 615, 420);
		layeredPane.add(panel);
	}
}