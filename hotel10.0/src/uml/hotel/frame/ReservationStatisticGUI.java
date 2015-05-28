package uml.hotel.frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;







import uml.hotel.control.ReservationControl;
import uml.hotel.dao.UmlRoomDAO;
import uml.hotel.model.UmlReservation;
import uml.hotel.model.UmlRoom;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;

import java.awt.Font;

public class ReservationStatisticGUI {

	private JFrame frame;
	private JTable table;
	private JTextField textField;
	int reserId = 0;
	String cusPhone = null;
	int reserID = 0;
	int roomId;
	private JTable table_1;
	private JTextField textField_1;
	private JTextField textField_2;
	private Component warn;
	JComboBox<Integer> comboBox = new JComboBox<Integer>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservationStatisticGUI window = new ReservationStatisticGUI();
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
	public ReservationStatisticGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 759, 471);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u5F53\u524D\u9884\u7EA6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 55, 740, 155);
		panel.add(scrollPane);
		
		JButton button_1 = new JButton("\u67E5\u770B\u9884\u5B9A\u4FE1\u606F");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//CusLoginGUI cusLoginGUI = new CusLoginGUI();
				//cusPhone = cusLoginGUI.returnCusPhone();
				cusPhone = textField_2.getText();
				List listReser = ReservationControl.getReservationControl().showReser(cusPhone);
				/*
				 * 当前预约
				 */
				Object[][] object=new Object[listReser.size()][7];
				for(int i=0; i<listReser.size(); i++){
					if(( (UmlReservation)listReser.get(i) ).getIsSettle() == 0)
					{
						object[i][0]=( (UmlReservation)listReser.get(i) ).getReserId();
						object[i][1]=( (UmlReservation)listReser.get(i) ).getRoomId();
						object[i][2]=( (UmlReservation)listReser.get(i) ).getCusPhone();
						object[i][3]=( (UmlReservation)listReser.get(i) ).getRstartTime();
						object[i][4]=( (UmlReservation)listReser.get(i) ).getRendTime();
						object[i][5]=( (UmlReservation)listReser.get(i) ).getReserTime();
						object[i][6]=( (UmlReservation)listReser.get(i) ).getRemark();
					}
					
				}
				table.setModel(new DefaultTableModel(object,
						new String[] {"\u9884\u5B9A\u5355\u53F7", "\u623F\u95F4\u53F7", "\u987E\u5BA2\u7535\u8BDD", "\u9884\u8BA1\u5F00\u59CB\u5165\u4F4F\u65F6\u95F4", "\u9884\u8BA1\u9000\u623F\u65F6\u95F4", "\u8BA2\u5355\u65E5\u671F", "\u5907\u6CE8"}));
				/*
				 * 历史预约
				 */
				Object[][] object_1=new Object[listReser.size()][7];
				for(int i=0; i<listReser.size(); i++){
					if(( (UmlReservation)listReser.get(i) ).getIsSettle() == 1)
					{
						object_1[i][0]=( (UmlReservation)listReser.get(i) ).getReserId();
						object_1[i][1]=( (UmlReservation)listReser.get(i) ).getRoomId();
						object_1[i][2]=( (UmlReservation)listReser.get(i) ).getCusPhone();
						object_1[i][3]=( (UmlReservation)listReser.get(i) ).getRstartTime();
						object_1[i][4]=( (UmlReservation)listReser.get(i) ).getRendTime();
						object_1[i][5]=( (UmlReservation)listReser.get(i) ).getReserTime();
						object_1[i][6]=( (UmlReservation)listReser.get(i) ).getRemark();
					}
					
				}
				table_1.setModel(new DefaultTableModel(object_1,
						new String[] {"\u9884\u5B9A\u5355\u53F7", "\u623F\u95F4\u53F7", "\u987E\u5BA2\u7535\u8BDD", "\u9884\u8BA1\u5F00\u59CB\u5165\u4F4F\u65F6\u95F4", "\u9884\u8BA1\u9000\u623F\u65F6\u95F4", "\u8BA2\u5355\u65E5\u671F", "\u5907\u6CE8"}));
				
			}
		});
		button_1.setBackground(Color.GRAY);
		button_1.setBounds(486, 19, 125, 28);
		panel.add(button_1);
		
		table = new JTable();
		scrollPane.setViewportView(table);
//		table = new JTable();
//		table.setModel(new DefaultTableModel(
//			new Object[][] {Invoice.getInvoiceLines().size()][4];
//					for(int i = 0)
//				{null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null},
//			},
//			new String[] {
//				"\u9884\u5B9A\u5355\u53F7", "\u623F\u95F4\u53F7", "\u987E\u5BA2\u7535\u8BDD", "\u9884\u8BA1\u5F00\u59CB\u5165\u4F4F\u65F6\u95F4", "\u9884\u8BA1\u9000\u623F\u65F6\u95F4", "\u8BA2\u5355\u65E5\u671F", "\u5907\u6CE8"
//			}
//		));
//		table.getColumnModel().getColumn(0).setPreferredWidth(79);
//		table.getColumnModel().getColumn(3).setPreferredWidth(110);
//		table.getColumnModel().getColumn(4).setPreferredWidth(115);
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.setBounds(79, 227, 110, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		
		JLabel lblNewLabel = new JLabel("\u9884\u5B9A\u5355\u53F7\uFF1A");
		lblNewLabel.setBounds(10, 224, 78, 27);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u53D6\u6D88\u9884\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * 取消订单
				 */
				reserId = Integer.parseInt(textField.getText());
				if(ReservationControl.getReservationControl().cancleReser(reserId))
				{
					JOptionPane.showMessageDialog(warn, "\n 取消订单成功！\n" +
							"","", JOptionPane.PLAIN_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(warn, "\n 取消订单失败！\n" +
							"","", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setBounds(199, 226, 89, 23);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u5386\u53F2\u9884\u7EA6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(0, 261, 740, 171);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 22, 740, 149);
		panel_1.add(scrollPane_2);
		
		table_1 = new JTable();
		
		
	
	scrollPane_2.setViewportView(table_1);
	
	JLabel label = new JLabel("\u9884\u5B9A\u5355\u53F7\uFF1A");
	label.setBounds(315, 230, 78, 15);
	panel.add(label);
	
	textField_1 = new JTextField();
	textField_1.setBounds(382, 227, 89, 21);
	panel.add(textField_1);
	textField_1.setColumns(10);
	
	JLabel label_1 = new JLabel("\u623F\u95F4\u53F7\uFF1A");
	label_1.setBounds(481, 230, 54, 15);
	panel.add(label_1);
	
	JButton button = new JButton("\u786E\u5B9A\u66F4\u6362");
	button.setBackground(Color.GRAY);
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			/*
			 * 换房
			 */
			String s = comboBox.getSelectedItem().toString();
			roomId = Integer.parseInt(s);
			reserID = Integer.parseInt(textField_1.getText());
			if(ReservationControl.getReservationControl().changeRoom(reserID, roomId))
			{
				JOptionPane.showMessageDialog(warn, "\n 更换房间成功！\n" +
						"","", JOptionPane.PLAIN_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(warn, "\n 更换房间失败！\n" +
						"","", JOptionPane.PLAIN_MESSAGE);
			}
		}
	});
	button.setBounds(635, 227, 93, 23);
	panel.add(button);
	
	
	comboBox.setBackground(Color.GRAY);
	comboBox.setBounds(534, 227, 80, 21);
	panel.add(comboBox);
	List list = new UmlRoomDAO().findAll();
	for(int i = 0; i < list.size(); i++)
	{
		comboBox.addItem( ((UmlRoom)list.get(i)).getRoomId());
	}
	
	
	JLabel label_2 = new JLabel("\u8BF7\u8F93\u5165\u624B\u673A\u53F7\uFF1A");
	label_2.setFont(new Font("华文楷体", Font.PLAIN, 15));
	label_2.setBounds(81, 17, 118, 27);
	panel.add(label_2);
	
	textField_2 = new JTextField();
	textField_2.setBounds(211, 20, 203, 21);
	panel.add(textField_2);
	textField_2.setColumns(10);
	
	JButton button_2 = new JButton("\u53D6\u6D88");
	button_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		   	frame.dispose();
		}
	});
	button_2.setBackground(Color.GRAY);
	button_2.setBounds(635, 19, 93, 26);
	panel.add(button_2);
	
//	JButton button_1 = new JButton("\u67E5\u770B\u9884\u5B9A\u4FE1\u606F");
//	button_1.addActionListener(new ActionListener() {
//		public void actionPerformed(ActionEvent e) {
//			//CusLoginGUI cusLoginGUI = new CusLoginGUI();
//			//cusPhone = cusLoginGUI.returnCusPhone();
//			cusPhone = textField_2.getText();
//			List listReser = ReservationControl.getReservationControl().showReser(cusPhone);
//			
//			
//		}
//	});
//	button_1.setBackground(Color.GRAY);
//	button_1.setBounds(486, 19, 125, 28);
//	panel.add(button_1);

	}
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
