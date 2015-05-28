package proj.dor.dormitoryUI;

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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.border.TitledBorder;

import proj.dor.control.checkDomitoryControl;
import proj.dor.model.Checkdormitory;

import java.awt.Font;
import javax.swing.UIManager;

public class DomitoryInforUI {

	private JFrame frame;
	private JTable table;
	int reserId = 0;
	String dorId = null;
	int reserID = 0;
	int roomId  = 0;
	private JTable table_1;
	private JTextField textField_2;
	private Component warn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DomitoryInforUI window = new DomitoryInforUI();
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
	public DomitoryInforUI() {
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
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u5BBF\u820D\u4E3A\u751F\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 55, 740, 377);
		panel.add(scrollPane);
		
		JButton button_1 = new JButton("\u67E5\u770B\u5BBF\u820D\u536B\u751F\u4FE1\u606F");
		button_1.setFont(new Font("华文楷体", Font.PLAIN, 14));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//CusLoginGUI cusLoginGUI = new CusLoginGUI();
				//cusPhone = cusLoginGUI.returnCusPhone();
				dorId = textField_2.getText();
				if(dorId.length() < 1)
				{
					JOptionPane.showMessageDialog(warn, "\n 请输入宿舍号！\n" +
							"","", JOptionPane.PLAIN_MESSAGE);
				}
				else
				{
					
				
				List listDor = checkDomitoryControl.getCheckDomitory().findDormitory(dorId);
				/*
				 * 宿舍卫生信息
				 */
				Object[][] object=new Object[listDor.size()][7];
				for(int i=0; i<listDor.size(); i++){
						object[i][0]=( (Checkdormitory)listDor.get(i)).getDorId();
						object[i][1]=( (Checkdormitory)listDor.get(i)).getIsquilt();
						object[i][2]=( (Checkdormitory)listDor.get(i)).getIsgarbage();
						object[i][3]=( (Checkdormitory)listDor.get(i)).getIsdesk();
						object[i][4]=( (Checkdormitory)listDor.get(i)).getIsbalcony();
						object[i][5]=( (Checkdormitory)listDor.get(i)).getScore();
						object[i][6]=( (Checkdormitory)listDor.get(i)).getRemark();
				}
				table.setModel(new DefaultTableModel(object,
						new String[] {"宿舍号", "被子是否叠", "垃圾是否倒", "桌子是否整洁", "阳台是否整洁", "得分", "备注"}));
				}
			}
		});
		button_1.setBackground(Color.GRAY);
		button_1.setBounds(338, 16, 161, 29);
		panel.add(button_1);
		
		/*
		 * 当前预约
		 */
		List listDor = checkDomitoryControl.getCheckDomitory().findAllCheck();
		table = new JTable();
		Object[][] object=new Object[listDor.size()][7];
		for(int i=0; i<listDor.size(); i++){
				object[i][0]=( (Checkdormitory)listDor.get(i)).getDorId();
				object[i][1]=( (Checkdormitory)listDor.get(i)).getIsquilt();
				object[i][2]=( (Checkdormitory)listDor.get(i)).getIsgarbage();
				object[i][3]=( (Checkdormitory)listDor.get(i)).getIsdesk();
				object[i][4]=( (Checkdormitory)listDor.get(i)).getIsbalcony();
				object[i][5]=( (Checkdormitory)listDor.get(i)).getScore();
				object[i][6]=( (Checkdormitory)listDor.get(i)).getRemark();
		}
		table.setModel(new DefaultTableModel(object,
				new String[] {"宿舍号", "被子是否叠", "垃圾是否倒", "桌子是否整洁", "阳台是否整洁", "得分", "备注"}));
		scrollPane.setViewportView(table);


	
	JLabel label_2 = new JLabel("\u8BF7\u8F93\u5165\u5BBF\u820D\u53F7\uFF1A");
	label_2.setFont(new Font("华文楷体", Font.PLAIN, 15));
	label_2.setBounds(20, 17, 118, 27);
	panel.add(label_2);
	
	textField_2 = new JTextField();
	textField_2.setBounds(140, 20, 161, 21);
	panel.add(textField_2);
	textField_2.setColumns(10);
	
	JButton button = new JButton("\u9000\u51FA");
	button.setBackground(Color.GRAY);
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			closeThis();
		}
	});
	button.setBounds(579, 16, 93, 29);
	panel.add(button);

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
