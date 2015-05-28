package uml.hotel.frame;

import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTabbedPane;
import javax.swing.Icon;
import javax.swing.JLabel;

import uml.hotel.control.RoomControl;
import uml.hotel.model.UmlRoom;
import java.awt.Color;
import java.awt.SystemColor;


public class mainFrame {

	private static  JFrame frame;
	private int exam = 1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainFrame window = new mainFrame();
					window.frame.setVisible(true);
					ImageIcon img = new ImageIcon("4.jpg");// 这是背景图片
					JLabel imgLabel = new JLabel(img);// 将背景图放在标签里。

					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		

		frame = new JFrame();
		frame.setTitle("235\u9152\u5E97\u524D\u53F0\u7BA1\u7406");
		frame.setBounds(100, 100, 689, 461);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		
		
		
		  ImageIcon icon50 = new ImageIcon("8.jpg");
	
		JButton button = new JButton(icon50);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReservationGUI reservationGUI = new ReservationGUI();
				reservationGUI.getFrame().setVisible(true);
				
			}
		});
		button.setBounds(44, 0, 70, 70);
		layeredPane.add(button);
		  ImageIcon icon51 = new ImageIcon("5.jpg");
		JButton button_1 = new JButton(icon51);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				liveFrame liveFrame = new liveFrame();
			  		liveFrame.getFrame().setVisible(true);
			}
		});
		button_1.setBounds(138, 0, 70, 70);
		layeredPane.add(button_1);
		  ImageIcon icon52 = new ImageIcon("6.jpg");
		JButton button_2 = new JButton(icon52);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCostFrame AddCostFrame = new AddCostFrame();
				AddCostFrame.getFrame().setVisible(true);
			}
		});
		button_2.setBounds(337, 0, 70, 70);
		layeredPane.add(button_2);
		ImageIcon icon511 = new ImageIcon("10.jpg");
		JButton button_4 = new JButton(icon511);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
				ChangeRoomFrame.getFrame().setVisible(true);
			}
		});
		button_4.setBounds(232, 0, 70, 70);
		layeredPane.add(button_4);
		
		JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP);
		tab.setBounds(44, 70, 503, 343);
		layeredPane.add(tab);
		  final JPanel p2 = new JPanel();
		  final JPanel p3 = new JPanel();
		  final JPanel p4 = new JPanel();
		  
		  final JPanel p1 = new JPanel();
		  tab.add(p1,"单人间");
		  p1.setLayout(null);
		  
		  ImageIcon icon1 = new ImageIcon("2.jpg");
//			  JButton button_6 = new JButton(icon1);
//			 button_6.addActionListener(new ActionListener() {
//				  
//			  	public void actionPerformed(ActionEvent e) {
//			  		liveFrame liveFrame = new liveFrame();
//			  		liveFrame.getFrame().setVisible(true);
//			  	}
//			  });
//			  button_6.setBounds(35, 36, 84, 59);
//			  p1.add(button_6);
			  
		  ImageIcon icon5 = new ImageIcon("3.jpg");
		  JButton button_5 = new JButton(icon5);
		  button_5.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		
		  		 for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(101).size(); i++){
		  			 int b =0;
		  			  b = ((UmlRoom) RoomControl.getRoomControl().findRoom(101).get(i)).getIsLodge();

	  				   if(b==1)
	  				   {	  					
	  					  ImageIcon icon1 = new ImageIcon("1.jpg");
	  					  JButton button_6 = new JButton(icon1);
	  					 button_6.addActionListener(new ActionListener() {
	  						  
	  					  	public void actionPerformed(ActionEvent e) {
	  					  	ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
	  						ChangeRoomFrame.getFrame().setVisible(true);
	  					
	  					  	}
	  					  });
	  					  button_6.setBounds(35, 36, 84, 59);
	  					  p1.add(button_6);
	  				    }
	  				   else {	  				
	  					 ImageIcon icon1 = new ImageIcon("2.jpg");
	  					  JButton button_6 = new JButton(icon1);
	  					 button_6.addActionListener(new ActionListener() {
	  						  
	  					  	public void actionPerformed(ActionEvent e) {
	  					  		liveFrame liveFrame = new liveFrame();
	  					  		liveFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					  button_6.setBounds(35, 36, 84, 59);
	  					  p1.add(button_6);
	  				   }
	  	      }
		  		
		  		 
		  		 
		  		 
		  		 for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(102).size(); i++){
		  			 int b = ((UmlRoom) RoomControl.getRoomControl().findRoom(102).get(i)).getIsLodge();
					   
	  				   if(b==1)
	  				   {	  					
	  					  ImageIcon icon = new ImageIcon("1.jpg");
	  					  JButton button_7 = new JButton(icon);
	  					  button_7.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  	ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
	  						ChangeRoomFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					  button_7.setBounds(149, 36, 84, 59);
	  					  p1.add(button_7);
	  				    }
	  				   else{	  				
	  					 ImageIcon icon = new ImageIcon("2.jpg");
	  					  JButton button_7 = new JButton(icon);
	  					  button_7.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  		liveFrame liveFrame = new liveFrame();
	  					  		liveFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					  button_7.setBounds(149, 36, 84, 59);
	  					  p1.add(button_7);
	  				   }
	  				
	  	      }
		  		 
		  		 
		  		 
		  		 for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(103).size(); i++){
		  			 int b = ((UmlRoom) RoomControl.getRoomControl().findRoom(103).get(i)).getIsLodge();
					   
	  				   if(b==1)
	  				   {	  					
	  					  ImageIcon icon1 = new ImageIcon("1.jpg");
	  					  
	  					  JButton button_8 = new JButton(icon1);
	  					  button_8.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  	ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
	  						ChangeRoomFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					  button_8.setBounds(259, 36, 84, 59);
	  					  p1.add(button_8);
	  				    }
	  				   else{	  				
	  					 ImageIcon icon1 = new ImageIcon("2.jpg");
	  					  JButton button_8 = new JButton(icon1);
	  					  button_8.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  		liveFrame liveFrame = new liveFrame();
	  					  		liveFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					  button_8.setBounds(259, 36, 84, 59);
	  					  p1.add(button_8);
	  				   }
	  	      }
		  		 
		  		 
		  		 
		  		 
		  		 for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(104).size(); i++){
		  			 int b = ((UmlRoom) RoomControl.getRoomControl().findRoom(104).get(i)).getIsLodge();
					   
	  				   if(b==1)
	  				   {	  					
	  					  ImageIcon icon1 = new ImageIcon("1.jpg");
	  					  JButton button_9 = new JButton(icon1);
	  					  button_9.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  	ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
	  						ChangeRoomFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					  button_9.setBounds(368, 36, 84, 59);
	  					  p1.add(button_9);
	  				    }
	  				   else{	  				
	  					 ImageIcon icon1 = new ImageIcon("2.jpg");
	  					  JButton button_9 = new JButton(icon1);
	  					  button_9.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  		liveFrame liveFrame = new liveFrame();
	  					  		liveFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					  button_9.setBounds(368, 36, 84, 59);
	  					  p1.add(button_9);
	  				   }
	  	      }
		  		 
		  		 
		  		 
		  		 
		  		 
		  		 for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(105).size(); i++){
		  			 int b = ((UmlRoom) RoomControl.getRoomControl().findRoom(105).get(i)).getIsLodge();
					   
	  				   if(b==1)
	  				   {	  					
	  					  ImageIcon icon1 = new ImageIcon("1.jpg");
	  					  JButton button_13 = new JButton(icon1);
	  					  button_13.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  	ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
	  						ChangeRoomFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					  button_13.setBounds(35, 132, 84, 59);
	  					  p1.add(button_13);
	  				    }
	  				   else if (b!=1){	  				
	  					 ImageIcon icon1 = new ImageIcon("2.jpg");
	  					  JButton button_13 = new JButton(icon1);
	  					  button_13.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  		liveFrame liveFrame = new liveFrame();
	  					  		liveFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					  button_13.setBounds(35, 132, 84, 59);
	  					  p1.add(button_13);
	  				   }
	  	      }
		  		 
		  		 
		  		 
		  		 
		  		 for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(106).size(); i++){
		  			 int b = ((UmlRoom) RoomControl.getRoomControl().findRoom(106).get(i)).getIsLodge();
					   
	  				   if(b==1)
	  				   {	  					
	  					  ImageIcon icon1 = new ImageIcon("1.jpg");
	  					  JButton button_12 = new JButton(icon1);
	  					  button_12.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  	ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
	  						ChangeRoomFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					  button_12.setBounds(149, 132, 84, 59);
	  					  p1.add(button_12);
	  					  
	  				    }
	  				   else {	  				
	  					 ImageIcon icon1 = new ImageIcon("2.jpg");
	  				
	  					  JButton button_12 = new JButton(icon1);
	  					  button_12.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  		liveFrame liveFrame = new liveFrame();
	  					  		liveFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					  button_12.setBounds(149, 132, 84, 59);
	  					  p1.add(button_12);
	  					  
	  				   }
	  	      }
		  		 
		  		 
		  		 
		  		 
		  		 for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(107).size(); i++){
		  			 int b = ((UmlRoom) RoomControl.getRoomControl().findRoom(107).get(i)).getIsLodge();
					   
	  				   if(b==1)
	  				   {	  					
	  					  ImageIcon icon1 = new ImageIcon("1.jpg");
	  					  JButton button_11 = new JButton(icon1);
	  					  button_11.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  	ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
	  						ChangeRoomFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					  button_11.setBounds(259, 132, 84, 59);
	  					  p1.add(button_11);
	  				    }
	  				   else{	  				
	  					 ImageIcon icon1 = new ImageIcon("2.jpg");
	  					  JButton button_11 = new JButton(icon1);
	  					  button_11.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  		liveFrame liveFrame = new liveFrame();
	  					  		liveFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					  button_11.setBounds(259, 132, 84, 59);
	  					  p1.add(button_11);
	  				   }
	  	      }
		  		 
		  		 
		  		 
		  		 
		  		 for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(108).size(); i++){
		  			 int b = ((UmlRoom) RoomControl.getRoomControl().findRoom(108).get(i)).getIsLodge();
					   
	  				   if(b==1)
	  				   {	  					
	  					  ImageIcon icon1 = new ImageIcon("1.jpg");
	  					  
	  					  JButton button_10 = new JButton(icon1);
	  					  button_10.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  	ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
	  						ChangeRoomFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					  button_10.setBounds(368, 132, 84, 59);
	  					  p1.add(button_10);
	  				    }
	  				   else{	  				
	  					 ImageIcon icon1 = new ImageIcon("2.jpg");
	  					  
	  					  JButton button_10 = new JButton(icon1);
	  					  button_10.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  		liveFrame liveFrame = new liveFrame();
	  					  		liveFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					  button_10.setBounds(368, 132, 84, 59);
	  					  p1.add(button_10);
	  				   }
	  	      }
		  		 
		  		 
		  		 
		  		 for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(109).size(); i++){
		  			 int b = ((UmlRoom) RoomControl.getRoomControl().findRoom(109).get(i)).getIsLodge();
					   
	  				   if(b==1)
	  				   {	  					
	  					  ImageIcon icon1 = new ImageIcon("1.jpg");
	  					  JButton button_14 = new JButton(icon1);
	  					  button_14.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  	ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
	  						ChangeRoomFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					  button_14.setBounds(35, 223, 84, 59);
	  					  p1.add(button_14);
	  				    }
	  				   else{	  				
	  					 ImageIcon icon1 = new ImageIcon("2.jpg");
	  					  JButton button_14 = new JButton(icon1);
	  					  button_14.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  		liveFrame liveFrame = new liveFrame();
	  					  		liveFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					  button_14.setBounds(35, 223, 84, 59);
	  					  p1.add(button_14);
	  				   }
	  	      }
		  		 
		  		 
		  		 
		  		 
		  		 for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(110).size(); i++){
		  			 int b = ((UmlRoom) RoomControl.getRoomControl().findRoom(110).get(i)).getIsLodge();
					   
	  				   if(b==1)
	  				   {	  					
	  					  ImageIcon icon1 = new ImageIcon("1.jpg");
	  					  JButton button_15 = new JButton(icon1);
	  					  button_15.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  	ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
	  						ChangeRoomFrame.getFrame().setVisible(true);}
	  					  });
	  					  button_15.setBounds(149, 223, 84, 59);
	  					  p1.add(button_15);
	  				    }
	  				   else{	  				
	  					 ImageIcon icon1 = new ImageIcon("2.jpg");
	  					  JButton button_15 = new JButton(icon1);
	  					  button_15.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  		liveFrame liveFrame = new liveFrame();
	  					  		liveFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					  button_15.setBounds(149, 223, 84, 59);
	  					  p1.add(button_15);
	  				   }
	  	      }
		  		 
		  		 
		  		 
		  		 
		  		 for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(111).size(); i++){
		  			 int b = ((UmlRoom) RoomControl.getRoomControl().findRoom(111).get(i)).getIsLodge();
					   
	  				   if(b==1)
	  				   {	  					
	  					  ImageIcon icon1 = new ImageIcon("1.jpg");
	  					  JButton button_16 = new JButton(icon1);
	  					  button_16.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  	ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
	  						ChangeRoomFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					  button_16.setBounds(259, 223, 84, 59);
	  					  p1.add(button_16);
	  				    }
	  				   else{	  				
	  					 ImageIcon icon1 = new ImageIcon("2.jpg");
	  					  JButton button_16 = new JButton(icon1);
	  					  button_16.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  		liveFrame liveFrame = new liveFrame();
	  					  		liveFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					  button_16.setBounds(259, 223, 84, 59);
	  					  p1.add(button_16);
	  				   }
	  	      }
		  		 
		  		 
		  		 
		  		 
		  		 for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(112).size(); i++){
		  			 int b = ((UmlRoom) RoomControl.getRoomControl().findRoom(112).get(i)).getIsLodge();
					   
	  				   if(b==1)
	  				   {	  					
	  					  ImageIcon icon1 = new ImageIcon("1.jpg");
	  					  JButton button_17 = new JButton(icon1);
	  					  button_17.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  	ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
	  						ChangeRoomFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					  button_17.setBounds(368, 223, 84, 59);
	  					  p1.add(button_17);
	  				    }
	  				   else{	  				
	  					 ImageIcon icon1 = new ImageIcon("2.jpg");
	  					  JButton button_17 = new JButton(icon1);
	  					  button_17.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  		liveFrame liveFrame = new liveFrame();
	  					  		liveFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					  button_17.setBounds(368, 223, 84, 59);
	  					  p1.add(button_17);
	  				   }
	  	      }
		  	}
		  });
		  button_5.setBounds(455, 0, 21, 26);
		  p1.add(button_5);
		  
//		  JButton button_6 = new JButton((Icon) null);
//		  button_6.addActionListener(new ActionListener() {
//			  
//		  	public void actionPerformed(ActionEvent e) {
//		  		liveFrame liveFrame = new liveFrame();
//		  		liveFrame.getFrame().setVisible(true);
//		  	}
//		  });
//		  button_6.setBounds(35, 36, 84, 59);
//		  p1.add(button_6);
		  

		
		  


		  
		
		  


		  

		  

		  

		  

		  
		  JLabel label_2 = new JLabel("101");
		  label_2.setBounds(53, 105, 21, 15);
		  p1.add(label_2);
		  
		  JLabel label_3 = new JLabel("102");
		  label_3.setBounds(168, 105, 21, 15);
		  p1.add(label_3);
		  
		  JLabel label_4 = new JLabel("103");
		  label_4.setBounds(279, 105, 21, 15);
		  p1.add(label_4);
		  
		  JLabel label_5 = new JLabel("104");
		  label_5.setBounds(388, 105, 21, 15);
		  p1.add(label_5);
		  
		  JLabel label_6 = new JLabel("105");
		  label_6.setBounds(53, 198, 21, 15);
		  p1.add(label_6);
		  
		  JLabel label_7 = new JLabel("106");
		  label_7.setBounds(168, 198, 21, 15);
		  p1.add(label_7);
		  
		  JLabel label_8 = new JLabel("107");
		  label_8.setBounds(279, 198, 21, 15);
		  p1.add(label_8);
		  
		  JLabel label_9 = new JLabel("108");
		  label_9.setBounds(388, 198, 21, 15);
		  p1.add(label_9);
		  
		  JLabel label_10 = new JLabel("109");
		  label_10.setBounds(53, 289, 21, 15);
		  p1.add(label_10);
		  
		  JLabel label_11 = new JLabel("110");
		  label_11.setBounds(168, 289, 21, 15);
		  p1.add(label_11);
		  
		  JLabel label_12 = new JLabel("111");
		  label_12.setBounds(279, 289, 21, 15);
		  p1.add(label_12);
		  
		  JLabel label_13 = new JLabel("112");
		  label_13.setBounds(388, 289, 21, 15);
		  p1.add(label_13);

		  JButton btnNewButton_14 = new JButton(icon5);
		  btnNewButton_14.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		frame.dispose();
		  	mainFrame mainFrame = new mainFrame();
		  	mainFrame.getFrame().setVisible(true);
		  	}
		  });
		  btnNewButton_14.setBounds(477, 0, 21, 26);
		  p1.add(btnNewButton_14);
		  
		  tab.add(p2,"双人间");
		  p2.setLayout(null);
		
		 /*if(exam == 1)
		 {
			 ImageIcon icon1 = new ImageIcon("1.jpg");
			 JButton btnNewButton_1 = new JButton(icon1);
			 btnNewButton_1.addActionListener(new ActionListener() {
				  	public void actionPerformed(ActionEvent e) {		  		
				  	}
				  });
				  btnNewButton_1.setBounds(23, 29, 84, 59);
				  p2.add(btnNewButton_1);
		 }else{
			 ImageIcon icon1 = new ImageIcon("2.jpg");
			 JButton btnNewButton_1 = new JButton(icon1);
			 btnNewButton_1.addActionListener(new ActionListener() {
				  	public void actionPerformed(ActionEvent e) {		  		
				  	}
				  });
				  btnNewButton_1.setBounds(23, 29, 84, 59);
				  p2.add(btnNewButton_1);
		 }*/
		 // ImageIcon icon1 = new ImageIcon("1.jpg");
		
		  
		  
		 // ImageIcon icon2 = new ImageIcon("2.jpg");
		  

		  
		  
		  
		  
		  
		  
		  

		  
		  ImageIcon icon3 = new ImageIcon("3.jpg");
		  JButton btnNewButton = new JButton(icon3);
		  btnNewButton.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		 for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(201).size(); i++){
		  			 int b = ((UmlRoom) RoomControl.getRoomControl().findRoom(201).get(i)).getIsLodge();
					   
	  				   if(b==1)
	  				   {	  					
	  					  ImageIcon icon1 = new ImageIcon("1.jpg");
	  					  JButton btnNewButton_1 = new JButton(icon1);
	  					btnNewButton_1.addActionListener(new ActionListener() {
	  						  
	  					  	public void actionPerformed(ActionEvent e) {
	  					  	ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
	  						ChangeRoomFrame.getFrame().setVisible(true);
	  					
	  					  	}
	  					  });
	  					btnNewButton_1.setBounds(35, 36, 84, 59);
	  					  p2.add(btnNewButton_1);
	  				    }
	  				   else{	  				
	  					 ImageIcon icon1 = new ImageIcon("2.jpg");
	  					  JButton btnNewButton_1 = new JButton(icon1);
	  					btnNewButton_1.addActionListener(new ActionListener() {
	  						  
	  					  	public void actionPerformed(ActionEvent e) {
	  					  		liveFrame liveFrame = new liveFrame();
	  					  		liveFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					btnNewButton_1.setBounds(35, 36, 84, 59);
	  					  p2.add(btnNewButton_1);
	  				   }
	  	      }
		  		
		  		 for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(202).size(); i++){
		  			 int b = ((UmlRoom) RoomControl.getRoomControl().findRoom(202).get(i)).getIsLodge();
					   
	  				   if(b==1)
	  				   {	  					
	  					  ImageIcon icon1 = new ImageIcon("1.jpg");
	  					  JButton btnNewButton_2 = new JButton(icon1);
	  					btnNewButton_2.addActionListener(new ActionListener() {
	  						  
	  					  	public void actionPerformed(ActionEvent e) {
	  					  	ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
	  						ChangeRoomFrame.getFrame().setVisible(true);
	  					
	  					  	}
	  					  });
	  					btnNewButton_2.setBounds(149, 36, 84, 59);
	  					p2.add(btnNewButton_2);
	  				    }
	  				   else{	  				
	  					 ImageIcon icon1 = new ImageIcon("2.jpg");
	  					  JButton btnNewButton_2 = new JButton(icon1);
	  					btnNewButton_2.addActionListener(new ActionListener() {
	  						  
	  					  	public void actionPerformed(ActionEvent e) {
	  					  		liveFrame liveFrame = new liveFrame();
	  					  		liveFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					btnNewButton_2.setBounds(149, 36, 84, 59);
	  					p2.add(btnNewButton_2);
	  				   }
	  	      }
		  		
		  		 for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(203).size(); i++){
		  			 int b = ((UmlRoom) RoomControl.getRoomControl().findRoom(203).get(i)).getIsLodge();
					   
	  				   if(b==1)
	  				   {	  					
	  					  ImageIcon icon1 = new ImageIcon("1.jpg");
	  					  JButton btnNewButton_3 = new JButton(icon1);
	  					btnNewButton_3.addActionListener(new ActionListener() {
	  						  
	  					  	public void actionPerformed(ActionEvent e) {
	  					  	ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
	  						ChangeRoomFrame.getFrame().setVisible(true);
	  					
	  					  	}
	  					  });
	  					btnNewButton_3.setBounds(259, 36, 84, 59);
	  					p2.add(btnNewButton_3);
	  				    }
	  				   else{	  				
	  					 ImageIcon icon1 = new ImageIcon("2.jpg");
	  					  JButton btnNewButton_3 = new JButton(icon1);
	  					btnNewButton_3.addActionListener(new ActionListener() {
	  						  
	  					  	public void actionPerformed(ActionEvent e) {
	  					  		liveFrame liveFrame = new liveFrame();
	  					  		liveFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					btnNewButton_3.setBounds(259, 36, 84, 59);
	  					p2.add(btnNewButton_3);
	  				   }
	  	      }
		  		 
		  		 for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(204).size(); i++){
		  			 int b = ((UmlRoom) RoomControl.getRoomControl().findRoom(204).get(i)).getIsLodge();
					   
	  				   if(b==1)
	  				   {	  					
	  					  ImageIcon icon1 = new ImageIcon("1.jpg");
	  					  JButton btnNewButton_4 = new JButton(icon1);
	  					btnNewButton_4.addActionListener(new ActionListener() {
	  						  
	  					  	public void actionPerformed(ActionEvent e) {
	  					  	ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
	  						ChangeRoomFrame.getFrame().setVisible(true);
	  					
	  					  	}
	  					  });
	  					btnNewButton_4.setBounds(368, 36, 84, 59);
	  					p2.add(btnNewButton_4);
	  				    }
	  				   else{	  				
	  					 ImageIcon icon1 = new ImageIcon("2.jpg");
	  					  JButton btnNewButton_4 = new JButton(icon1);
	  					btnNewButton_4.addActionListener(new ActionListener() {
	  						  
	  					  	public void actionPerformed(ActionEvent e) {
	  					  		liveFrame liveFrame = new liveFrame();
	  					  		liveFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					btnNewButton_4.setBounds(368, 36, 84, 59);
	  					p2.add(btnNewButton_4);
	  				   }
	  	      }
		  		 
		  		 
		  		 for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(205).size(); i++){
		  			 int b = ((UmlRoom) RoomControl.getRoomControl().findRoom(205).get(i)).getIsLodge();
					   
	  				   if(b==1)
	  				   {	  					
	  					  ImageIcon icon1 = new ImageIcon("1.jpg");
	  					  JButton btnNewButton_5 = new JButton(icon1);
	  					btnNewButton_5.addActionListener(new ActionListener() {
	  						  
	  					  	public void actionPerformed(ActionEvent e) {
	  					  	ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
	  						ChangeRoomFrame.getFrame().setVisible(true);
	  					
	  					  	}
	  					  });
	  					btnNewButton_5.setBounds(35, 132, 84, 59);
	  					p2.add(btnNewButton_5);
	  				    }
	  				   else{	  				
	  					 ImageIcon icon1 = new ImageIcon("2.jpg");
	  					  JButton btnNewButton_5 = new JButton(icon1);
	  					btnNewButton_5.addActionListener(new ActionListener() {
	  						  
	  					  	public void actionPerformed(ActionEvent e) {
	  					  		liveFrame liveFrame = new liveFrame();
	  					  		liveFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					btnNewButton_5.setBounds(35, 132, 84, 59);
	  					p2.add(btnNewButton_5);
	  				   }
	  	      }
		  		 
		  		 
		  		 for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(206).size(); i++){
		  			 int b = ((UmlRoom) RoomControl.getRoomControl().findRoom(206).get(i)).getIsLodge();
					   
	  				   if(b==1)
	  				   {	  					
	  					  ImageIcon icon1 = new ImageIcon("1.jpg");
	  					  JButton btnNewButton_6 = new JButton(icon1);
	  					btnNewButton_6.addActionListener(new ActionListener() {
	  						  
	  					  	public void actionPerformed(ActionEvent e) {
	  					  	ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
	  						ChangeRoomFrame.getFrame().setVisible(true);
	  					
	  					  	}
	  					  });
	  					btnNewButton_6.setBounds(149, 132, 84, 59);
	  					p2.add(btnNewButton_6);
	  				    }
	  				   else{	  				
	  					 ImageIcon icon1 = new ImageIcon("2.jpg");
	  					  JButton btnNewButton_6 = new JButton(icon1);
	  					btnNewButton_6.addActionListener(new ActionListener() {
	  						  
	  					  	public void actionPerformed(ActionEvent e) {
	  					  		liveFrame liveFrame = new liveFrame();
	  					  		liveFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					btnNewButton_6.setBounds(149, 132, 84, 59);
	  					p2.add(btnNewButton_6);
	  				   }
	  	      }
		  		 
		  		 
		  		 
		  		 for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(207).size(); i++){
		  			 int b = ((UmlRoom) RoomControl.getRoomControl().findRoom(207).get(i)).getIsLodge();
					   
	  				   if(b==1)
	  				   {	  					
	  					  ImageIcon icon1 = new ImageIcon("1.jpg");
	  					  JButton btnNewButton_7 = new JButton(icon1);
	  					btnNewButton_7.addActionListener(new ActionListener() {
	  						  
	  					  	public void actionPerformed(ActionEvent e) {
	  					  	ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
	  						ChangeRoomFrame.getFrame().setVisible(true);
	  					
	  					  	}
	  					  });
	  					btnNewButton_7.setBounds(259, 132, 84, 59);
	  					p2.add(btnNewButton_7);
	  				    }
	  				   else{	  				
	  					 ImageIcon icon1 = new ImageIcon("2.jpg");
	  					  JButton btnNewButton_7 = new JButton(icon1);
	  					btnNewButton_7.addActionListener(new ActionListener() {
	  						  
	  					  	public void actionPerformed(ActionEvent e) {
	  					  		liveFrame liveFrame = new liveFrame();
	  					  		liveFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					btnNewButton_7.setBounds(259, 132, 84, 59);
	  					p2.add(btnNewButton_7);
	  				   }
	  	      }
		  		 
		  		 
		  		 
		  		 for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(208).size(); i++){
		  			 int b = ((UmlRoom) RoomControl.getRoomControl().findRoom(208).get(i)).getIsLodge();
					   
	  				   if(b==1)
	  				   {	  					
	  					  ImageIcon icon1 = new ImageIcon("1.jpg");
	  					  JButton btnNewButton_8 = new JButton(icon1);
	  					btnNewButton_8.addActionListener(new ActionListener() {
	  						  
	  					  	public void actionPerformed(ActionEvent e) {
	  					  	ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
	  						ChangeRoomFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					btnNewButton_8.setBounds(368, 132, 84, 59);
	  					p2.add(btnNewButton_8);
	  				    }
	  				   else{	  				
	  					 ImageIcon icon1 = new ImageIcon("2.jpg");
	  					  JButton btnNewButton_8 = new JButton(icon1);
	  					btnNewButton_8.addActionListener(new ActionListener() {
	  						  
	  					  	public void actionPerformed(ActionEvent e) {
	  					  		liveFrame liveFrame = new liveFrame();
	  					  		liveFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					btnNewButton_8.setBounds(368, 132, 84, 59);
	  					p2.add(btnNewButton_8);
	  				   }
	  	      }
		  		 
		  		 
		  		 
		  		 for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(209).size(); i++){
		  			 int b = ((UmlRoom) RoomControl.getRoomControl().findRoom(209).get(i)).getIsLodge();
					   
	  				   if(b==1)
	  				   {	  					
	  					  ImageIcon icon1 = new ImageIcon("1.jpg");
	  					  JButton btnNewButton_9 = new JButton(icon1);
	  					btnNewButton_9.addActionListener(new ActionListener() {
	  						  
	  					  	public void actionPerformed(ActionEvent e) {
	  					  	ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
	  						ChangeRoomFrame.getFrame().setVisible(true);
	  					
	  					  	}
	  					  });
	  					btnNewButton_9.setBounds(35, 223, 84, 59);
	  					p2.add(btnNewButton_9);
	  				    }
	  				   else{	  				
	  					 ImageIcon icon1 = new ImageIcon("2.jpg");
	  					  JButton btnNewButton_9 = new JButton(icon1);
	  					btnNewButton_9.addActionListener(new ActionListener() {
	  						  
	  					  	public void actionPerformed(ActionEvent e) {
	  					  		liveFrame liveFrame = new liveFrame();
	  					  		liveFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					btnNewButton_9.setBounds(35, 223, 84, 59);
	  					p2.add(btnNewButton_9);
	  				   }
	  	      }
		  		 
		  		 
		  		 
		  		 for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(210).size(); i++){
		  			 int b = ((UmlRoom) RoomControl.getRoomControl().findRoom(210).get(i)).getIsLodge();
					   
	  				   if(b==1)
	  				   {	  					
	  					  ImageIcon icon1 = new ImageIcon("1.jpg");
	  					  JButton btnNewButton_10 = new JButton(icon1);
	  					btnNewButton_10.addActionListener(new ActionListener() {
	  						  
	  					  	public void actionPerformed(ActionEvent e) {
	  					  	ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
	  						ChangeRoomFrame.getFrame().setVisible(true);
	  					
	  					  	}
	  					  });
	  					btnNewButton_10.setBounds(149, 223, 84, 59);
	  					p2.add(btnNewButton_10);
	  				    }
	  				   else{	  				
	  					 ImageIcon icon1 = new ImageIcon("2.jpg");
	  					  JButton btnNewButton_10 = new JButton(icon1);
	  					btnNewButton_10.addActionListener(new ActionListener() {
	  						  
	  					  	public void actionPerformed(ActionEvent e) {
	  					  		liveFrame liveFrame = new liveFrame();
	  					  		liveFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					btnNewButton_10.setBounds(149, 223, 84, 59);
	  					p2.add(btnNewButton_10);
	  				   }
	  	      }
		  		 
		  		 
		  		 
		  		 for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(211).size(); i++){
		  			 int b = ((UmlRoom) RoomControl.getRoomControl().findRoom(211).get(i)).getIsLodge();
					   
	  				   if(b==1)
	  				   {	  					
	  					  ImageIcon icon1 = new ImageIcon("1.jpg");
	  					  JButton btnNewButton_11 = new JButton(icon1);
	  					btnNewButton_11.addActionListener(new ActionListener() {
	  						  
	  					  	public void actionPerformed(ActionEvent e) {
	  					  	ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
	  						ChangeRoomFrame.getFrame().setVisible(true);
	  					
	  					  	}
	  					  });
	  					btnNewButton_11.setBounds(259, 223, 84, 59);
	  					p2.add(btnNewButton_11);
	  				    }
	  				   else{	  				
	  					 ImageIcon icon1 = new ImageIcon("2.jpg");
	  					  JButton btnNewButton_11 = new JButton(icon1);
	  					btnNewButton_11.addActionListener(new ActionListener() {
	  						  
	  					  	public void actionPerformed(ActionEvent e) {
	  					  		liveFrame liveFrame = new liveFrame();
	  					  		liveFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					btnNewButton_11.setBounds(259, 223, 84, 59);
	  					p2.add(btnNewButton_11);
	  				   }
	  	      }
		  		 
		  		 
		  		 
		  		 for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(212).size(); i++){
		  			 int b = ((UmlRoom) RoomControl.getRoomControl().findRoom(212).get(i)).getIsLodge();
					   
	  				   if(b==1)
	  				   {	  					
	  					  ImageIcon icon1 = new ImageIcon("1.jpg");
	  					  JButton btnNewButton_12 = new JButton(icon1);
	  					btnNewButton_12.addActionListener(new ActionListener() {
	  						  
	  					  	public void actionPerformed(ActionEvent e) {
	  					  	ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
	  						ChangeRoomFrame.getFrame().setVisible(true);
	  					
	  					  	}
	  					  });
	  					btnNewButton_12.setBounds(368, 223, 84, 59);
	  					p2.add(btnNewButton_12);
	  				    }
	  				   else{	  				
	  					 ImageIcon icon1 = new ImageIcon("2.jpg");
	  					  JButton btnNewButton_12 = new JButton(icon1);
	  					btnNewButton_12.addActionListener(new ActionListener() {
	  						  
	  					  	public void actionPerformed(ActionEvent e) {
	  					  		liveFrame liveFrame = new liveFrame();
	  					  		liveFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					btnNewButton_12.setBounds(368, 223, 84, 59);
	  					p2.add(btnNewButton_12);
	  				   }
	  	      }
		  		
		  	}
		  });
		  btnNewButton.setBounds(455, 0, 21, 26);
		  p2.add(btnNewButton);
		
		  
		  JLabel label = new JLabel("201");
		  label.setBounds(61, 105, 21, 15);
		  p2.add(label);
		  
		  JLabel label_1 = new JLabel("202");
		  label_1.setBounds(176, 105, 21, 15);
		  p2.add(label_1);
		  
		  JLabel label_38 = new JLabel("203");
		  label_38.setBounds(287, 105, 21, 15);
		  p2.add(label_38);
		  
		  JLabel label_39 = new JLabel("204");
		  label_39.setBounds(396, 105, 21, 15);
		  p2.add(label_39);
		  
		  JLabel label_40 = new JLabel("205");
		  label_40.setBounds(61, 198, 21, 15);
		  p2.add(label_40);
		  
		  JLabel label_41 = new JLabel("206");
		  label_41.setBounds(176, 198, 21, 15);
		  p2.add(label_41);
		  
		  JLabel label_42 = new JLabel("207");
		  label_42.setBounds(287, 198, 21, 15);
		  p2.add(label_42);
		  
		  JLabel label_43 = new JLabel("208");
		  label_43.setBounds(396, 198, 21, 15);
		  p2.add(label_43);
		  
		  JLabel label_44 = new JLabel("209");
		  label_44.setBounds(61, 289, 21, 15);
		  p2.add(label_44);
		  
		  JLabel label_45 = new JLabel("210");
		  label_45.setBounds(176, 289, 21, 15);
		  p2.add(label_45);
		  
		  JLabel label_46 = new JLabel("211");
		  label_46.setBounds(287, 289, 21, 15);
		  p2.add(label_46);
		  
		  JLabel label_47 = new JLabel("212");
		  label_47.setBounds(396, 289, 21, 15);
		  p2.add(label_47);
		  
		  JButton btnNewButton_15 = new JButton(icon5);
		  btnNewButton_15.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		frame.dispose();
				  	mainFrame mainFrame = new mainFrame();
				  	mainFrame.getFrame().setVisible(true);
		  	}
		  });
		  btnNewButton_15.setBounds(477, 0, 21, 26);
		  p2.add(btnNewButton_15);
		  
		  
		 
		  
		  tab.add(p3,"豪华间");
		  p3.setLayout(null);
		  
		  ImageIcon icon18 = new ImageIcon("3.jpg");
		  JButton button_18 = new JButton(icon18);
		  button_18.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		 for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(301).size(); i++){
		  			 int b = ((UmlRoom) RoomControl.getRoomControl().findRoom(301).get(i)).getIsLodge();
					   
	  				   if(b==1)
	  				   {	  					
	  					  ImageIcon icon1 = new ImageIcon("1.jpg");
	  					  JButton button_20 = new JButton(icon1);
	  					 button_20.addActionListener(new ActionListener() {
	  						  
	  					  	public void actionPerformed(ActionEvent e) {
	  					  	ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
	  						ChangeRoomFrame.getFrame().setVisible(true);
	  					
	  					  	}
	  					  });
	  					button_20.setBounds(35, 36, 84, 59);
	  					  p3.add(button_20);
	  				    }
	  				   else{	  				
	  					 ImageIcon icon1 = new ImageIcon("2.jpg");
	  					  JButton button_20 = new JButton(icon1);
	  					button_20.addActionListener(new ActionListener() {
	  						  
	  					  	public void actionPerformed(ActionEvent e) {
	  					  		liveFrame liveFrame = new liveFrame();
	  					  		liveFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					button_20.setBounds(35, 36, 84, 59);
	  					p3.add(button_20);
	  				   }
	  	      }
		  		
		  		 
		  		 
		  		 
		  		 for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(302).size(); i++){
		  			 int b = ((UmlRoom) RoomControl.getRoomControl().findRoom(302).get(i)).getIsLodge();
					   
	  				   if(b==1)
	  				   {	  					
	  					  ImageIcon icon = new ImageIcon("1.jpg");
	  					  JButton button_21 = new JButton(icon);
	  					button_21.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  	ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
	  						ChangeRoomFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					button_21.setBounds(149, 36, 84, 59);
	  					p3.add(button_21);
	  				    }
	  				   else{	  				
	  					 ImageIcon icon = new ImageIcon("2.jpg");
	  					  JButton button_21 = new JButton(icon);
	  					button_21.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  		liveFrame liveFrame = new liveFrame();
	  					  		liveFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					button_21.setBounds(149, 36, 84, 59);
	  					p3.add(button_21);
	  				   }
	  				
	  	      }
		  		 
		  		 
		  		 
		  		 for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(303).size(); i++){
		  			 int b = ((UmlRoom) RoomControl.getRoomControl().findRoom(303).get(i)).getIsLodge();
					   
	  				   if(b==1)
	  				   {	  					
	  					  ImageIcon icon1 = new ImageIcon("1.jpg");
	  					  
	  					  JButton button_22 = new JButton(icon1);
	  					button_22.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  	ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
	  						ChangeRoomFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					button_22.setBounds(259, 36, 84, 59);
	  					p3.add(button_22);
	  				    }
	  				   else{	  				
	  					 ImageIcon icon1 = new ImageIcon("2.jpg");
	  					  JButton button_22 = new JButton(icon1);
	  					button_22.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  		liveFrame liveFrame = new liveFrame();
	  					  		liveFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					button_22.setBounds(259, 36, 84, 59);
	  					p3.add(button_22);
	  				   }
	  	      }
		  		 
		  		 
		  		 
		  		 
		  		 for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(304).size(); i++){
		  			 int b = ((UmlRoom) RoomControl.getRoomControl().findRoom(304).get(i)).getIsLodge();
					   
	  				   if(b==1)
	  				   {	  					
	  					  ImageIcon icon1 = new ImageIcon("1.jpg");
	  					  JButton button_23 = new JButton(icon1);
	  					button_23.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  	ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
	  						ChangeRoomFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					button_23.setBounds(368, 36, 84, 59);
	  					p3.add(button_23);
	  				    }
	  				   else{	  				
	  					 ImageIcon icon1 = new ImageIcon("2.jpg");
	  					  JButton button_23 = new JButton(icon1);
	  					button_23.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  		liveFrame liveFrame = new liveFrame();
	  					  		liveFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					button_23.setBounds(368, 36, 84, 59);
	  					p3.add(button_23);
	  				   }
	  	      }
		  		 
		  		 
		  		 
		  		 
		  		 
		  		 for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(305).size(); i++){
		  			 int b = ((UmlRoom) RoomControl.getRoomControl().findRoom(305).get(i)).getIsLodge();
					   
	  				   if(b==1)
	  				   {	  					
	  					  ImageIcon icon1 = new ImageIcon("1.jpg");
	  					  JButton button_27 = new JButton(icon1);
	  					button_27.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  	ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
	  						ChangeRoomFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					button_27.setBounds(35, 132, 84, 59);
	  					p3.add(button_27);
	  				    }
	  				   else if (b!=1){	  				
	  					 ImageIcon icon1 = new ImageIcon("2.jpg");
	  					  JButton button_27 = new JButton(icon1);
	  					button_27.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  		liveFrame liveFrame = new liveFrame();
	  					  		liveFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					button_27.setBounds(35, 132, 84, 59);
	  					p3.add(button_27);
	  				   }
	  	      }
		  		 
		  		 
		  		 
		  		 
		  		 for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(306).size(); i++){
		  			 int b = ((UmlRoom) RoomControl.getRoomControl().findRoom(306).get(i)).getIsLodge();
					   
	  				   if(b==1)
	  				   {	  					
	  					  ImageIcon icon1 = new ImageIcon("1.jpg");
	  					  JButton button_26 = new JButton(icon1);
	  					button_26.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  	ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
	  						ChangeRoomFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					button_26.setBounds(149, 132, 84, 59);
	  					p3.add(button_26);
	  					  
	  				    }
	  				   else {	  				
	  					 ImageIcon icon1 = new ImageIcon("2.jpg");
	  				
	  					  JButton button_26 = new JButton(icon1);
	  					button_26.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  		liveFrame liveFrame = new liveFrame();
	  					  		liveFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					button_26.setBounds(149, 132, 84, 59);
	  					p3.add(button_26);
	  					  
	  				   }
	  	      }
		  		 
		  		 
		  		 
		  		 
		  		 for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(307).size(); i++){
		  			 int b = ((UmlRoom) RoomControl.getRoomControl().findRoom(307).get(i)).getIsLodge();
					   
	  				   if(b==1)
	  				   {	  					
	  					  ImageIcon icon1 = new ImageIcon("1.jpg");
	  					  JButton button_25 = new JButton(icon1);
	  					button_25.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  	ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
	  						ChangeRoomFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					button_25.setBounds(259, 132, 84, 59);
	  					p3.add(button_25);
	  				    }
	  				   else{	  				
	  					 ImageIcon icon1 = new ImageIcon("2.jpg");
	  					  JButton button_25 = new JButton(icon1);
	  					button_25.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  		liveFrame liveFrame = new liveFrame();
	  					  		liveFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					button_25.setBounds(259, 132, 84, 59);
	  					p3.add(button_25);
	  				   }
	  	      }
		  		 
		  		 
		  		 
		  		 
		  		 for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(308).size(); i++){
		  			 int b = ((UmlRoom) RoomControl.getRoomControl().findRoom(308).get(i)).getIsLodge();
					   
	  				   if(b==1)
	  				   {	  					
	  					  ImageIcon icon1 = new ImageIcon("1.jpg");
	  					  
	  					  JButton button_24 = new JButton(icon1);
	  					button_24.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  	ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
	  						ChangeRoomFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					button_24.setBounds(368, 132, 84, 59);
	  					p3.add(button_24);
	  				    }
	  				   else{	  				
	  					 ImageIcon icon1 = new ImageIcon("2.jpg");
	  					  
	  					  JButton button_24 = new JButton(icon1);
	  					button_24.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  		liveFrame liveFrame = new liveFrame();
	  					  		liveFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					button_24.setBounds(368, 132, 84, 59);
	  					p3.add(button_24);
	  				   }
	  	      }
		  		 
		  		 
		  		 
		  		 for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(309).size(); i++){
		  			 int b = ((UmlRoom) RoomControl.getRoomControl().findRoom(309).get(i)).getIsLodge();
					   
	  				   if(b==1)
	  				   {	  					
	  					  ImageIcon icon1 = new ImageIcon("1.jpg");
	  					  JButton button_28 = new JButton(icon1);
	  					button_28.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  	ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
	  						ChangeRoomFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					button_28.setBounds(35, 223, 84, 59);
	  					p3.add(button_28);
	  				    }
	  				   else{	  				
	  					 ImageIcon icon1 = new ImageIcon("2.jpg");
	  					  JButton button_28 = new JButton(icon1);
	  					button_28.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  		liveFrame liveFrame = new liveFrame();
	  					  		liveFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					button_28.setBounds(35, 223, 84, 59);
	  					p3.add(button_28);
	  				   }
	  	      }
		  		 
		  		 
		  		 
		  		 
		  		 for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(310).size(); i++){
		  			 int b = ((UmlRoom) RoomControl.getRoomControl().findRoom(310).get(i)).getIsLodge();
					   
	  				   if(b==1)
	  				   {	  					
	  					  ImageIcon icon1 = new ImageIcon("1.jpg");
	  					  JButton button_29 = new JButton(icon1);
	  					button_29.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  	ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
	  						ChangeRoomFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					button_29.setBounds(149, 223, 84, 59);
	  					p3.add(button_29);
	  				    }
	  				   else{	  				
	  					 ImageIcon icon1 = new ImageIcon("2.jpg");
	  					  JButton button_29 = new JButton(icon1);
	  					button_29.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  		liveFrame liveFrame = new liveFrame();
	  					  		liveFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					button_29.setBounds(149, 223, 84, 59);
	  					p3.add(button_29);
	  				   }
	  	      }
		  		 
		  		 
		  		 
		  		 
		  		 for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(311).size(); i++){
		  			 int b = ((UmlRoom) RoomControl.getRoomControl().findRoom(311).get(i)).getIsLodge();
					   
	  				   if(b==1)
	  				   {	  					
	  					  ImageIcon icon1 = new ImageIcon("1.jpg");
	  					  JButton button_30 = new JButton(icon1);
	  					button_30.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  	ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
	  						ChangeRoomFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					button_30.setBounds(259, 223, 84, 59);
	  					p3.add(button_30);
	  				    }
	  				   else{	  				
	  					 ImageIcon icon1 = new ImageIcon("2.jpg");
	  					  JButton button_30 = new JButton(icon1);
	  					button_30.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  		liveFrame liveFrame = new liveFrame();
	  					  		liveFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					button_30.setBounds(259, 223, 84, 59);
	  					p3.add(button_30);
	  				   }
	  	      }
		  		 
		  		 
		  		 
		  		 
		  		 for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(312).size(); i++){
		  			 int b = ((UmlRoom) RoomControl.getRoomControl().findRoom(312).get(i)).getIsLodge();
					   
	  				   if(b==1)
	  				   {	  					
	  					  ImageIcon icon1 = new ImageIcon("1.jpg");
	  					  JButton button_31 = new JButton(icon1);
	  					button_31.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  	ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
	  						ChangeRoomFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					button_31.setBounds(368, 223, 84, 59);
	  					p3.add(button_31);
	  				    }
	  				   else{	  				
	  					 ImageIcon icon1 = new ImageIcon("2.jpg");
	  					  JButton button_31 = new JButton(icon1);
	  					button_31.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  		liveFrame liveFrame = new liveFrame();
	  					  		liveFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					button_31.setBounds(368, 223, 84, 59);
	  					p3.add(button_31);
	  				   }
	  			 	
	  	      }
		  	}
		  });
		  button_18.setBounds(455, 0, 21, 26);
		  p3.add(button_18);
	
		  
		  JLabel label_14 = new JLabel("301");
		  label_14.setBounds(65, 104, 21, 15);
		  p3.add(label_14);
		  
		  JLabel label_15 = new JLabel("302");
		  label_15.setBounds(180, 104, 21, 15);
		  p3.add(label_15);
		  
		  JLabel label_16 = new JLabel("303");
		  label_16.setBounds(291, 104, 21, 15);
		  p3.add(label_16);
		  
		  JLabel label_17 = new JLabel("304");
		  label_17.setBounds(400, 104, 21, 15);
		  p3.add(label_17);
		  
		  JLabel label_18 = new JLabel("305");
		  label_18.setBounds(65, 197, 21, 15);
		  p3.add(label_18);
		  
		  JLabel label_19 = new JLabel("306");
		  label_19.setBounds(180, 197, 21, 15);
		  p3.add(label_19);
		  
		  JLabel label_20 = new JLabel("307");
		  label_20.setBounds(291, 197, 21, 15);
		  p3.add(label_20);
		  
		  JLabel label_21 = new JLabel("308");
		  label_21.setBounds(400, 197, 21, 15);
		  p3.add(label_21);
		  
		  JLabel label_22 = new JLabel("309");
		  label_22.setBounds(65, 288, 21, 15);
		  p3.add(label_22);
		  
		  JLabel label_23 = new JLabel("310");
		  label_23.setBounds(180, 288, 21, 15);
		  p3.add(label_23);
		  
		  JLabel label_24 = new JLabel("311");
		  label_24.setBounds(291, 288, 21, 15);
		  p3.add(label_24);
		  
		  JLabel label_25 = new JLabel("312");
		  label_25.setBounds(400, 288, 21, 15);
		  p3.add(label_25);
		  
		  JButton btnNewButton_16 = new JButton(icon5);
		  btnNewButton_16.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		frame.dispose();
				  	mainFrame mainFrame = new mainFrame();
				  	mainFrame.getFrame().setVisible(true);
		  	}
		  });
		  btnNewButton_16.setBounds(477, 0, 21, 26);
		  p3.add(btnNewButton_16);
		  tab.add(p4,"贵宾间");
		  p4.setLayout(null);
		  
		  ImageIcon icon19 = new ImageIcon("3.jpg");
		  JButton button_19 = new JButton(icon19);
		  button_19.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		 for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(401).size(); i++){
		  			 int b = ((UmlRoom) RoomControl.getRoomControl().findRoom(401).get(i)).getIsLodge();
					   
	  				   if(b==1)
	  				   {	  					
	  					  ImageIcon icon1 = new ImageIcon("1.jpg");
	  					  JButton button_32 = new JButton(icon1);
	  					button_32.addActionListener(new ActionListener() {
	  						  
	  					  	public void actionPerformed(ActionEvent e) {
	  					  	ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
	  						ChangeRoomFrame.getFrame().setVisible(true);
	  					
	  					  	}
	  					  });
	  					button_32.setBounds(35, 36, 84, 59);
	  					  p4.add(button_32);
	  				    }
	  				   else{	  				
	  					 ImageIcon icon1 = new ImageIcon("2.jpg");
	  					  JButton button_20 = new JButton(icon1);
	  					button_20.addActionListener(new ActionListener() {
	  						  
	  					  	public void actionPerformed(ActionEvent e) {
	  					  		liveFrame liveFrame = new liveFrame();
	  					  		liveFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					button_20.setBounds(35, 36, 84, 59);
	  					p4.add(button_20);
	  				   }
	  	      }
		  		
		  		 
		  		 
		  		 
		  		 for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(402).size(); i++){
		  			 int b = ((UmlRoom) RoomControl.getRoomControl().findRoom(402).get(i)).getIsLodge();
					   
	  				   if(b==1)
	  				   {	  					
	  					  ImageIcon icon = new ImageIcon("1.jpg");
	  					  JButton button_33 = new JButton(icon);
	  					button_33.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  	ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
	  						ChangeRoomFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					button_33.setBounds(149, 36, 84, 59);
	  					p4.add(button_33);
	  				    }
	  				   else{	  				
	  					 ImageIcon icon = new ImageIcon("2.jpg");
	  					  JButton button_33 = new JButton(icon);
	  					button_33.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  		liveFrame liveFrame = new liveFrame();
	  					  		liveFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					button_33.setBounds(149, 36, 84, 59);
	  					p4.add(button_33);
	  				   }
	  				
	  	      }
		  		 
		  		 
		  		 
		  		 for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(403).size(); i++){
		  			 int b = ((UmlRoom) RoomControl.getRoomControl().findRoom(403).get(i)).getIsLodge();
					   
	  				   if(b==1)
	  				   {	  					
	  					  ImageIcon icon1 = new ImageIcon("1.jpg");
	  					  
	  					  JButton button_34 = new JButton(icon1);
	  					button_34.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  	ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
	  						ChangeRoomFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					button_34.setBounds(259, 36, 84, 59);
	  					p4.add(button_34);
	  				    }
	  				   else{	  				
	  					 ImageIcon icon1 = new ImageIcon("2.jpg");
	  					  JButton button_34 = new JButton(icon1);
	  					button_34.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  		liveFrame liveFrame = new liveFrame();
	  					  		liveFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					button_34.setBounds(259, 36, 84, 59);
	  					p4.add(button_34);
	  				   }
	  	      }
		  		 
		  		 
		  		 
		  		 
		  		 for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(404).size(); i++){
		  			 int b = ((UmlRoom) RoomControl.getRoomControl().findRoom(404).get(i)).getIsLodge();
					   
	  				   if(b==1)
	  				   {	  					
	  					  ImageIcon icon1 = new ImageIcon("1.jpg");
	  					  JButton button_35 = new JButton(icon1);
	  					button_35.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  	ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
	  						ChangeRoomFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					button_35.setBounds(368, 36, 84, 59);
	  					p4.add(button_35);
	  				    }
	  				   else{	  				
	  					 ImageIcon icon1 = new ImageIcon("2.jpg");
	  					  JButton button_35 = new JButton(icon1);
	  					button_35.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  		liveFrame liveFrame = new liveFrame();
	  					  		liveFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					button_35.setBounds(368, 36, 84, 59);
	  					p4.add(button_35);
	  				   }
	  	      }
		  		 
		  		 
		  		 
		  		 
		  		 
		  		 for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(405).size(); i++){
		  			 int b = ((UmlRoom) RoomControl.getRoomControl().findRoom(405).get(i)).getIsLodge();
					   
	  				   if(b==1)
	  				   {	  					
	  					  ImageIcon icon1 = new ImageIcon("1.jpg");
	  					  JButton button_39 = new JButton(icon1);
	  					button_39.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  	ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
	  						ChangeRoomFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					button_39.setBounds(35, 132, 84, 59);
	  					p4.add(button_39);
	  				    }
	  				   else if (b!=1){	  				
	  					 ImageIcon icon1 = new ImageIcon("2.jpg");
	  					  JButton button_39 = new JButton(icon1);
	  					button_39.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  		liveFrame liveFrame = new liveFrame();
	  					  		liveFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					button_39.setBounds(35, 132, 84, 59);
	  					p4.add(button_39);
	  				   }
	  	      }
		  		 
		  		 
		  		 
		  		 
		  		 for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(406).size(); i++){
		  			 int b = ((UmlRoom) RoomControl.getRoomControl().findRoom(406).get(i)).getIsLodge();
					   
	  				   if(b==1)
	  				   {	  					
	  					  ImageIcon icon1 = new ImageIcon("1.jpg");
	  					  JButton button_38 = new JButton(icon1);
	  					button_38.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  	ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
	  						ChangeRoomFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					button_38.setBounds(149, 132, 84, 59);
	  					p4.add(button_38);
	  					  
	  				    }
	  				   else {	  				
	  					 ImageIcon icon1 = new ImageIcon("2.jpg");
	  				
	  					  JButton button_38 = new JButton(icon1);
	  					button_38.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  		liveFrame liveFrame = new liveFrame();
	  					  		liveFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					button_38.setBounds(149, 132, 84, 59);
	  					p4.add(button_38);
	  					  
	  				   }
	  	      }
		  		 
		  		 
		  		 
		  		 
		  		 for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(407).size(); i++){
		  			 int b = ((UmlRoom) RoomControl.getRoomControl().findRoom(407).get(i)).getIsLodge();
					   
	  				   if(b==1)
	  				   {	  					
	  					  ImageIcon icon1 = new ImageIcon("1.jpg");
	  					  JButton button_37 = new JButton(icon1);
	  					button_37.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  	ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
	  						ChangeRoomFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					button_37.setBounds(259, 132, 84, 59);
	  					p4.add(button_37);
	  				    }
	  				   else{	  				
	  					 ImageIcon icon1 = new ImageIcon("2.jpg");
	  					  JButton button_37 = new JButton(icon1);
	  					button_37.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  		liveFrame liveFrame = new liveFrame();
	  					  		liveFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					button_37.setBounds(259, 132, 84, 59);
	  					p4.add(button_37);
	  				   }
	  	      }
		  		 
		  		 
		  		 
		  		 
		  		 for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(408).size(); i++){
		  			 int b = ((UmlRoom) RoomControl.getRoomControl().findRoom(408).get(i)).getIsLodge();
					   
	  				   if(b==1)
	  				   {	  					
	  					  ImageIcon icon1 = new ImageIcon("1.jpg");
	  					  
	  					  JButton button_36 = new JButton(icon1);
	  					button_36.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  	ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
	  						ChangeRoomFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					button_36.setBounds(368, 132, 84, 59);
	  					p4.add(button_36);
	  				    }
	  				   else{	  				
	  					 ImageIcon icon1 = new ImageIcon("2.jpg");
	  					  
	  					  JButton button_36 = new JButton(icon1);
	  					button_36.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  		liveFrame liveFrame = new liveFrame();
	  					  		liveFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					button_36.setBounds(368, 132, 84, 59);
	  					p4.add(button_36);
	  				   }
	  	      }
		  		 
		  		 
		  		 
		  		 for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(409).size(); i++){
		  			 int b = ((UmlRoom) RoomControl.getRoomControl().findRoom(409).get(i)).getIsLodge();
					   
	  				   if(b==1)
	  				   {	  					
	  					  ImageIcon icon1 = new ImageIcon("1.jpg");
	  					  JButton button_40 = new JButton(icon1);
	  					button_40.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  	ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
	  						ChangeRoomFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					button_40.setBounds(35, 223, 84, 59);
	  					p4.add(button_40);
	  				    }
	  				   else{	  				
	  					 ImageIcon icon1 = new ImageIcon("2.jpg");
	  					  JButton button_40 = new JButton(icon1);
	  					button_40.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  		liveFrame liveFrame = new liveFrame();
	  					  		liveFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					button_40.setBounds(35, 223, 84, 59);
	  					p4.add(button_40);
	  				   }
	  	      }
		  		 
		  		 
		  		 
		  		 
		  		 for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(410).size(); i++){
		  			 int b = ((UmlRoom) RoomControl.getRoomControl().findRoom(410).get(i)).getIsLodge();
					   
	  				   if(b==1)
	  				   {	  					
	  					  ImageIcon icon1 = new ImageIcon("1.jpg");
	  					  JButton button_41 = new JButton(icon1);
	  					button_41.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  	ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
	  						ChangeRoomFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					button_41.setBounds(149, 223, 84, 59);
	  					p4.add(button_41);
	  				    }
	  				   else{	  				
	  					 ImageIcon icon1 = new ImageIcon("2.jpg");
	  					  JButton button_41 = new JButton(icon1);
	  					button_41.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  		liveFrame liveFrame = new liveFrame();
	  					  		liveFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					button_41.setBounds(149, 223, 84, 59);
	  					p4.add(button_41);
	  				   }
	  	      }
		  		 
		  		 
		  		 
		  		 
		  		 for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(411).size(); i++){
		  			 int b = ((UmlRoom) RoomControl.getRoomControl().findRoom(411).get(i)).getIsLodge();
					   
	  				   if(b==1)
	  				   {	  					
	  					  ImageIcon icon1 = new ImageIcon("1.jpg");
	  					  JButton button_42 = new JButton(icon1);
	  					button_42.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  	ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
	  						ChangeRoomFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					button_42.setBounds(259, 223, 84, 59);
	  					p4.add(button_42);
	  				    }
	  				   else{	  				
	  					 ImageIcon icon1 = new ImageIcon("2.jpg");
	  					  JButton button_42 = new JButton(icon1);
	  					button_42.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  		liveFrame liveFrame = new liveFrame();
	  					  		liveFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					button_42.setBounds(259, 223, 84, 59);
	  					p4.add(button_42);
	  				   }
	  	      }
		  		 
		  		 
		  		 
		  		 
		  		 for(int i= 0 ; i<RoomControl.getRoomControl().findRoom(412).size(); i++){
		  			 int b = ((UmlRoom) RoomControl.getRoomControl().findRoom(412).get(i)).getIsLodge();
					   
	  				   if(b==1)
	  				   {	  					
	  					  ImageIcon icon1 = new ImageIcon("1.jpg");
	  					  JButton button_43 = new JButton(icon1);
	  					button_43.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  	ChangeRoomFrame ChangeRoomFrame = new ChangeRoomFrame();
	  						ChangeRoomFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					button_43.setBounds(368, 223, 84, 59);
	  					p4.add(button_43);
	  				    }
	  				   else{	  				
	  					 ImageIcon icon1 = new ImageIcon("2.jpg");
	  					  JButton button_43 = new JButton(icon1);
	  					button_43.addActionListener(new ActionListener() {
	  					  	public void actionPerformed(ActionEvent e) {
	  					  		liveFrame liveFrame = new liveFrame();
	  					  		liveFrame.getFrame().setVisible(true);
	  					  	}
	  					  });
	  					button_43.setBounds(368, 223, 84, 59);
	  					p4.add(button_43);
	  				   }
	  	      }
		  		
		  }
		  	});
		  button_19.setBounds(455, 0, 21, 26);
		  p4.add(button_19);
		  
		
		  
		  JLabel label_26 = new JLabel("401");
		  label_26.setBounds(64, 106, 21, 15);
		  p4.add(label_26);
		  
		  JLabel label_27 = new JLabel("402");
		  label_27.setBounds(179, 106, 21, 15);
		  p4.add(label_27);
		  
		  JLabel label_28 = new JLabel("403");
		  label_28.setBounds(290, 106, 21, 15);
		  p4.add(label_28);
		  
		  JLabel label_29 = new JLabel("404");
		  label_29.setBounds(399, 106, 21, 15);
		  p4.add(label_29);
		  
		  JLabel label_30 = new JLabel("405");
		  label_30.setBounds(64, 199, 21, 15);
		  p4.add(label_30);
		  
		  JLabel label_31 = new JLabel("406");
		  label_31.setBounds(179, 199, 21, 15);
		  p4.add(label_31);
		  
		  JLabel label_32 = new JLabel("407");
		  label_32.setBounds(290, 199, 21, 15);
		  p4.add(label_32);
		  
		  JLabel label_33 = new JLabel("408");
		  label_33.setBounds(399, 199, 21, 15);
		  p4.add(label_33);
		  
		  JLabel label_34 = new JLabel("409");
		  label_34.setBounds(64, 290, 21, 15);
		  p4.add(label_34);
		  
		  JLabel label_35 = new JLabel("410");
		  label_35.setBounds(179, 290, 21, 15);
		  p4.add(label_35);
		  
		  JLabel label_36 = new JLabel("411");
		  label_36.setBounds(290, 290, 21, 15);
		  p4.add(label_36);
		  
		  JLabel label_37 = new JLabel("412");
		  label_37.setBounds(399, 290, 21, 15);
		  p4.add(label_37);
		  
		  JButton btnNewButton_17 = new JButton(icon5);
		  btnNewButton_17.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		frame.dispose();
				  	mainFrame mainFrame = new mainFrame();
				  	mainFrame.getFrame().setVisible(true);
		  	}
		  });
		  btnNewButton_17.setBounds(475, 0, 23, 26);
		  p4.add(btnNewButton_17);
		  
		  
		  
		  ImageIcon icon15 = new ImageIcon("9.jpg");
		  JButton button_6 = new JButton(icon15);
		  button_6.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
				AddGoodsFrame AddGoodsFrame = new AddGoodsFrame();
				AddGoodsFrame.getFrame().setVisible(true);
		  	}
		  });
		  button_6.setBounds(449, 0, 70, 70);
		  layeredPane.add(button_6);
		  
		  
		  ImageIcon icon25 = new ImageIcon("7.jpg");
		  JButton btnNewButton_13 = new JButton(icon25);
		  btnNewButton_13.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
				CheckoutFrame CheckoutFrame1 = new CheckoutFrame();
				CheckoutFrame1.setVisible(true);
		  	}
		  });
		  btnNewButton_13.setBounds(565, 0, 70, 70);
		  layeredPane.add(btnNewButton_13);
		  
		  JPanel panel = new JPanel();
		  panel.setBackground(Color.WHITE);
		  panel.setBounds(0, 0, 757, 423);
		  layeredPane.add(panel);
		  
		  
		  
	}
	public JFrame getFrame(){
		return frame;
	}
	public void setFrame(JFrame frame){
		this.frame = frame;
	}
}
