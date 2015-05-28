package soft.room.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import soft.room.control.ApplyRoomControl;
import soft.room.control.ClassroomControl;
import soft.room.model.Classroom;

public class ApplyGUI {

	private JFrame frame;
	private JTextField textField;
	private DateChooser startDate;
	private DateChooser endDate;
	private JTextField textField_1;
	private JTextField textField_2;
	private Integer applyId;
	private String applyName;
	private String applyReason;
	private String startTime;
	private String endTime;
	private String classroomId;
	private String remark;
	private Component warn;
	
	JComboBox<String> comboBox = new JComboBox<String>();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplyGUI window = new ApplyGUI();
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
	public ApplyGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 341, 462);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("\u7533\u8BF7\u4EBA\u59D3\u540D\uFF1A");
		label.setBounds(10, 32, 84, 26);
		panel.add(label);
		
		textField = new JTextField();
		textField.setBounds(119, 35, 95, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u7533\u8BF7\u6559\u5BA4\u53F7\uFF1A");
		label_1.setBounds(9, 67, 83, 25);
		panel.add(label_1);
		comboBox.setBackground(Color.GRAY);
		
		
		comboBox.setBounds(119, 66, 97, 21);
		panel.add(comboBox);
		List listroomId = ClassroomControl.getClassroomControl().getClassroomId();
		for(int i = 0; i < listroomId.size(); i++)
		{
			comboBox.addItem( ((Classroom)listroomId.get(i)).getClassroomId());
		}
		
		JLabel label_2 = new JLabel("\u5F00\u59CB\u4F7F\u7528\u65F6\u95F4\uFF1A");
		label_2.setBounds(10, 106, 105, 26);
		panel.add(label_2);
		
		startDate = new DateChooser("yyyy-MM-dd");
		startDate.setBounds(119, 108, 100, 24);
		panel.add(startDate);
		
		JLabel label_3 = new JLabel("\u7ED3\u675F\u4F7F\u7528\u65F6\u95F4\uFF1A");
		label_3.setBounds(10, 152, 105, 21);
		panel.add(label_3);
		
		endDate = new DateChooser("yyyy-MM-dd");
		endDate.setBounds(119, 149, 100, 24);
		panel.add(endDate);
		
		JLabel label_4 = new JLabel("\u7533\u8BF7\u76EE\u7684\uFF1A");
		label_4.setBounds(11, 192, 76, 22);
		panel.add(label_4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(119, 194, 162, 67);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_5 = new JLabel("\u5907\u6CE8\uFF1A");
		label_5.setBounds(10, 271, 54, 18);
		panel.add(label_5);
		
		textField_2 = new JTextField();
		textField_2.setBounds(119, 271, 162, 60);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JButton button = new JButton("\u786E\u8BA4\u7533\u8BF7");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				startTime = sdf.format(startDate.getDate().getTime());
				endTime   = sdf.format(endDate.getDate().getTime());
				applyName = textField.getText();
				applyReason = textField_1.getText();
				remark    = textField_2.getText();
				List listapply = ApplyRoomControl.getApplayRoomControl().allApply();
				applyId = 10001 + listapply.size() ;
				classroomId = comboBox.getSelectedItem().toString();
				if(applyName.length() < 1)
				{
					JOptionPane.showMessageDialog(warn, "\n ÇëÊäÈëÐÕÃû£¡\n" +
							"","", JOptionPane.PLAIN_MESSAGE);
				}
				else
				{
					ApplyRoomControl.getApplayRoomControl().saveApplyRoom(applyId, applyName, startTime, endTime, applyReason, classroomId, 0, remark);
				}
			}
		});
		button.setBackground(Color.GRAY);
		button.setBounds(136, 380, 93, 33);
		panel.add(button);
		
		JButton button_1 = new JButton("\u67E5\u770B\u7533\u8BF7\u4FE1\u606F");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ApplyInfGUI applyInfGUI = new ApplyInfGUI();
				applyInfGUI.getFrame().setVisible(true);
			}
		});
		button_1.setBackground(Color.GRAY);
		button_1.setBounds(10, 380, 105, 33);
		panel.add(button_1);
		
		JButton button_2 = new JButton("\u53D6\u6D88");
		button_2.setBackground(Color.GRAY);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeThis();
			}
		});
		button_2.setBounds(247, 380, 68, 33);
		panel.add(button_2);
	}
	public void closeThis(){
		frame.dispose();
	}
}
