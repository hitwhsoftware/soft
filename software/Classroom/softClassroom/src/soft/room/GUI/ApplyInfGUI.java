package soft.room.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import soft.room.control.ApplyRoomControl;
import soft.room.control.ClassroomControl;
import soft.room.model.Applyroom;
import soft.room.model.Classroom;
import javax.swing.UIManager;

public class ApplyInfGUI {

	private JFrame frame;
	private JTable table;
	private JTextField textField;
	int applyId = 0;
	String applyName = null;
	//int reserID = 0;
	String classroomId  = null;
	private JTable table_1;
	private JTextField textField_1;
	private JTextField textField_2;
	private Component warn;
	JComboBox<String> comboBox = new JComboBox<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplyInfGUI window = new ApplyInfGUI();
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
	public ApplyInfGUI() {
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
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u5F53\u524D\u7533\u8BF7", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 55, 740, 155);
		panel.add(scrollPane);
		
		JButton button_1 = new JButton("\u67E5\u770B\u7533\u8BF7\u4FE1\u606F");
		button_1.setFont(new Font("华文楷体", Font.PLAIN, 14));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//CusLoginGUI cusLoginGUI = new CusLoginGUI();
				//cusPhone = cusLoginGUI.returnCusPhone();
				applyName = textField_2.getText();
				if(applyName.length() < 1)
				{
					JOptionPane.showMessageDialog(warn, "\n 请输入申请人姓名！\n" +
							"","", JOptionPane.PLAIN_MESSAGE);
				}
				else
				{
					
				
				List listcurrentReser = ApplyRoomControl.getApplayRoomControl().UserApply(applyName);
				/*
				 * 当前预约
				 */
				Object[][] object=new Object[listcurrentReser.size()][7];
				for(int i=0; i<listcurrentReser.size(); i++){
					if(( (Applyroom)listcurrentReser.get(i) ).getIsdispose() == 0)
					{
						object[i][0]=( (Applyroom)listcurrentReser.get(i) ).getApplyId();
						object[i][1]=( (Applyroom)listcurrentReser.get(i) ).getApplyName();
						object[i][2]=( (Applyroom)listcurrentReser.get(i) ).getClassroomId();
						object[i][3]=( (Applyroom)listcurrentReser.get(i) ).getApplyStartTime();
						object[i][4]=( (Applyroom)listcurrentReser.get(i) ).getApplyEndTime();
						object[i][5]=( (Applyroom)listcurrentReser.get(i) ).getApplyReason();
						object[i][6]=( (Applyroom)listcurrentReser.get(i) ).getRemark();
					}
					
				}
				table.setModel(new DefaultTableModel(object,
						new String[] {"申请单号", "申请人姓名", "教室号", "开始使用时间", "结束使用时间", "申请用途", "备注"}));
				/*
				 * 历史预约
				 */
				Object[][] object_1=new Object[listcurrentReser.size()][7];
				for(int i=0; i<listcurrentReser.size(); i++){
					if(( (Applyroom)listcurrentReser.get(i) ).getIsdispose() == 1)
					{
						object_1[i][0]=( (Applyroom)listcurrentReser.get(i) ).getApplyId();
						object_1[i][1]=( (Applyroom)listcurrentReser.get(i) ).getApplyName();
						object_1[i][2]=( (Applyroom)listcurrentReser.get(i) ).getClassroomId();
						object_1[i][3]=( (Applyroom)listcurrentReser.get(i) ).getApplyStartTime();
						object_1[i][4]=( (Applyroom)listcurrentReser.get(i) ).getApplyEndTime();
						object_1[i][5]=( (Applyroom)listcurrentReser.get(i) ).getApplyReason();
						object_1[i][6]=( (Applyroom)listcurrentReser.get(i) ).getRemark();
					}
					
				}
				table_1.setModel(new DefaultTableModel(object_1,
						new String[] {"申请单号", "申请人姓名", "教室号", "开始使用时间", "结束使用时间", "申请用途", "备注"}));
				}
			}
		});
		button_1.setBackground(Color.GRAY);
		button_1.setBounds(486, 19, 125, 28);
		panel.add(button_1);
		
		/*
		 * 当前预约
		 */
		List listcurrentReser = ApplyRoomControl.getApplayRoomControl().currentApply();
		table = new JTable();
		Object[][] object=new Object[listcurrentReser.size()][7];
		for(int i=0; i<listcurrentReser.size(); i++){
			if(( (Applyroom)listcurrentReser.get(i) ).getIsdispose() == 0)
			{
				object[i][0]=( (Applyroom)listcurrentReser.get(i) ).getApplyId();
				object[i][1]=( (Applyroom)listcurrentReser.get(i) ).getApplyName();
				object[i][2]=( (Applyroom)listcurrentReser.get(i) ).getClassroomId();
				object[i][3]=( (Applyroom)listcurrentReser.get(i) ).getApplyStartTime();
				object[i][4]=( (Applyroom)listcurrentReser.get(i) ).getApplyEndTime();
				object[i][5]=( (Applyroom)listcurrentReser.get(i) ).getApplyReason();
				object[i][6]=( (Applyroom)listcurrentReser.get(i) ).getRemark();
			}
			
		}
		table.setModel(new DefaultTableModel(object,
				new String[] {"申请单号", "申请人姓名", "教室号", "开始使用时间", "结束使用时间", "申请用途", "备注"}));
		scrollPane.setViewportView(table);

		textField = new JTextField();
		textField.setBounds(79, 227, 110, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		
		JLabel lblNewLabel = new JLabel("\u7533\u8BF7\u5355\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("华文楷体", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 224, 78, 27);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u53D6\u6D88\u7533\u8BF7");
		btnNewButton.setFont(new Font("华文楷体", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * 取消申请
				 */
				
				if(textField.getText().length() < 1)
				{
					JOptionPane.showMessageDialog(warn, "\n 请输入申请号！\n" +
							"","", JOptionPane.PLAIN_MESSAGE);
				}
				else
				{
					applyId = Integer.parseInt(textField.getText());
					
					if(ApplyRoomControl.getApplayRoomControl().CancelApply(applyId))
					{
//						/*
//						 * 当前预约
//						 */
//						List listAllReser = ReservationControl.getReservationControl().showCurrentReser();
//						table = new JTable();
//						Object[][] object=new Object[listAllReser.size()][7];
//						for(int i=0; i<listAllReser.size(); i++){
//							if(( (UmlReservation)listAllReser.get(i) ).getIsSettle() == 0)
//							{
//								object[i][0]=( (UmlReservation)listAllReser.get(i) ).getReserId();
//								object[i][1]=( (UmlReservation)listAllReser.get(i) ).getRoomId();
//								object[i][2]=( (UmlReservation)listAllReser.get(i) ).getCusPhone();
//								object[i][3]=( (UmlReservation)listAllReser.get(i) ).getRstartTime();
//								object[i][4]=( (UmlReservation)listAllReser.get(i) ).getRendTime();
//								object[i][5]=( (UmlReservation)listAllReser.get(i) ).getReserTime();
//								object[i][6]=( (UmlReservation)listAllReser.get(i) ).getRemark();
//							}
//							
//						}
//						table.setModel(new DefaultTableModel(object,
//								new String[] {"\u9884\u5B9A\u5355\u53F7", "\u623F\u95F4\u53F7", "\u987E\u5BA2\u7535\u8BDD", "\u9884\u8BA1\u5F00\u59CB\u5165\u4F4F\u65F6\u95F4", "\u9884\u8BA1\u9000\u623F\u65F6\u95F4", "\u8BA2\u5355\u65E5\u671F", "\u5907\u6CE8"}));
//						/*
//						 * 历史预约
//						 */
//						List listHistoryReser = ReservationControl.getReservationControl().showHistoryReser();
//						table_1 = new JTable();
//						Object[][] object_1=new Object[listHistoryReser.size()][7];
//						for(int i=0; i<listHistoryReser.size(); i++){
//							if(( (UmlReservation)listHistoryReser.get(i) ).getIsSettle() == 1)
//							{
//								object_1[i][0]=( (UmlReservation)listHistoryReser.get(i) ).getReserId();
//								object_1[i][1]=( (UmlReservation)listHistoryReser.get(i) ).getRoomId();
//								object_1[i][2]=( (UmlReservation)listHistoryReser.get(i) ).getCusPhone();
//								object_1[i][3]=( (UmlReservation)listHistoryReser.get(i) ).getRstartTime();
//								object_1[i][4]=( (UmlReservation)listHistoryReser.get(i) ).getRendTime();
//								object_1[i][5]=( (UmlReservation)listHistoryReser.get(i) ).getReserTime();
//								object_1[i][6]=( (UmlReservation)listHistoryReser.get(i) ).getRemark();
//							}
//							
//						}
//						table_1.setModel(new DefaultTableModel(object_1,
//								new String[] {"\u9884\u5B9A\u5355\u53F7", "\u623F\u95F4\u53F7", "\u987E\u5BA2\u7535\u8BDD", "\u9884\u8BA1\u5F00\u59CB\u5165\u4F4F\u65F6\u95F4", "\u9884\u8BA1\u9000\u623F\u65F6\u95F4", "\u8BA2\u5355\u65E5\u671F", "\u5907\u6CE8"}));
//
						JOptionPane.showMessageDialog(warn, "\n 取消申请成功！\n" +
								"","", JOptionPane.PLAIN_MESSAGE);
						
					}
					else
					{
						JOptionPane.showMessageDialog(warn, "\n 取消申请失败！\n" +
								"","", JOptionPane.PLAIN_MESSAGE);
					}
				}
				

				
				
				
			}
		});
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setBounds(199, 226, 98, 23);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u5386\u53F2\u7533\u8BF7", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(0, 261, 740, 171);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 22, 740, 149);
		panel_1.add(scrollPane_2);
		
		/*
		 * 历史预约
		 */
		List listHistoryApply = ApplyRoomControl.getApplayRoomControl().historyApply();
		table_1 = new JTable();
		Object[][] object_1=new Object[listHistoryApply.size()][7];
		for(int i=0; i<listHistoryApply.size(); i++){
			if(( (Applyroom)listHistoryApply.get(i) ).getIsdispose() == 1)
			{
				object_1[i][0]=( (Applyroom)listHistoryApply.get(i) ).getApplyId();
				object_1[i][1]=( (Applyroom)listHistoryApply.get(i) ).getApplyName();
				object_1[i][2]=( (Applyroom)listHistoryApply.get(i) ).getClassroomId();
				object_1[i][3]=( (Applyroom)listHistoryApply.get(i) ).getApplyStartTime();
				object_1[i][4]=( (Applyroom)listHistoryApply.get(i) ).getApplyEndTime();
				object_1[i][5]=( (Applyroom)listHistoryApply.get(i) ).getApplyReason();
				object_1[i][6]=( (Applyroom)listHistoryApply.get(i) ).getRemark();
			}
			
		}
		table_1.setModel(new DefaultTableModel(object_1,
				new String[] {"申请单号", "申请人姓名", "教室号", "开始使用时间", "结束使用时间", "申请用途", "备注"}));
	scrollPane_2.setViewportView(table_1);
	
	JLabel label = new JLabel("\u7533\u8BF7\u5355\u53F7\uFF1A");
	label.setFont(new Font("华文楷体", Font.PLAIN, 14));
	label.setBounds(315, 230, 78, 15);
	panel.add(label);
	
	textField_1 = new JTextField();
	textField_1.setBounds(382, 227, 89, 21);
	panel.add(textField_1);
	textField_1.setColumns(10);
	
	JLabel label_1 = new JLabel("\u6559\u5BA4\u53F7\uFF1A");
	label_1.setFont(new Font("华文楷体", Font.PLAIN, 14));
	label_1.setBounds(479, 230, 56, 15);
	panel.add(label_1);
	
	JButton button = new JButton("\u786E\u5B9A\u66F4\u6362");
	button.setFont(new Font("华文楷体", Font.PLAIN, 14));
	button.setBackground(Color.GRAY);
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			/*
			 * 换教室
			 */
			classroomId = comboBox.getSelectedItem().toString();
			String reser = null;
			if(classroomId.length() < 1)
			{
				JOptionPane.showMessageDialog(warn, "\n 请输入教室号！\n" +
						"","", JOptionPane.PLAIN_MESSAGE);
			}else
			if(textField_1.getText().length() < 1)
			{
				JOptionPane.showMessageDialog(warn, "\n 请输入申请单号！\n" +
						"","", JOptionPane.PLAIN_MESSAGE);
			}
			else
			{
				applyId = Integer.parseInt(textField_1.getText());
				if(ApplyRoomControl.getApplayRoomControl().changeClassroom(applyId, classroomId))
				{
					JOptionPane.showMessageDialog(warn, "\n 更换教室成功！\n" +
							"","", JOptionPane.PLAIN_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(warn, "\n 更换教室失败！\n" +
							"","", JOptionPane.PLAIN_MESSAGE);
				}
			}
			
		}
	});
	button.setBounds(635, 227, 93, 23);
	panel.add(button);
	
	
	comboBox.setBackground(Color.GRAY);
	comboBox.setBounds(534, 227, 80, 21);
	panel.add(comboBox);
	List listroomId = ClassroomControl.getClassroomControl().getClassroomId();
	for(int i = 0; i < listroomId.size(); i++)
	{
		comboBox.addItem( ((Classroom)listroomId.get(i)).getClassroomId());
	}
	
	
	JLabel label_2 = new JLabel("\u8BF7\u8F93\u5165\u7533\u8BF7\u4EBA\u59D3\u540D\uFF1A");
	label_2.setFont(new Font("华文楷体", Font.PLAIN, 15));
	label_2.setBounds(57, 17, 142, 27);
	panel.add(label_2);
	
	textField_2 = new JTextField();
	textField_2.setBounds(211, 20, 203, 21);
	panel.add(textField_2);
	textField_2.setColumns(10);
	

	}
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
