package apserver;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.border.BevelBorder;
import com.swtdesigner.SwingResourceManager;
import java.awt.*;
import javax.swing.*;

public class watcher extends JFrame {

	private JTextArea status;
	final JLabel sensor1;
	Graphics g;

	
	socket s=new socket();
	Reader reader=new Reader();
	/**
	 * Launch the application
	 * @param args
	 */
	
	
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					watcher frame = new watcher();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame
	 */
	public watcher() {
		super();
		setTitle("2");
		getContentPane().setLayout(null);
		setBounds(100, 100, 1024, 768);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		status = new JTextArea();
		status.setBackground(Color.LIGHT_GRAY);
		status.setInheritsPopupMenu(true);
		status.setLineWrap(true);
		status.setBounds(0, 71, 146, 625);
		getContentPane().add(status);

		final JLabel label = new JLabel();
		label.setForeground(new Color(0, 0, 255));
		label.setFont(new Font("", Font.PLAIN, 20));
		label.setText("東南科技大學校園平面圖--監聽8082");
		label.setBounds(0, 0, 1016, 65);
		getContentPane().add(label);
		
		sensor1 =new JLabel();
		
		
		sensor1.setIcon(new ImageIcon(".\\imgs\\green.jpg"));	
		sensor1.setText("sensor1");
		sensor1.setBounds(220, 142, 146, 74);
		getContentPane().add(sensor1);
		
		final JLabel map = new JLabel(new ImageIcon(".\\imgs\\map.jpg"));

		map.setText("東南校區平面圖");
		map.setBounds(152, 71, 762, 500);
		getContentPane().add(map);
		
	
		
		reader.start(); // 檢查是否有資料
	
	}
	
/**
 * 檢查是否有資料
 * */
	 class  Reader extends Thread{
		int i=0;
		public void run(){	
			try{
				while(true){ 	
                     System.out.println("i= "+i);
                     if(s.getRecive().length()>0){
                    	 String data=status.getText()+'\n'+s.getRecive();
                    	 status.setText(data);
                    	 sensor1.setIcon(new ImageIcon(".\\imgs\\red.jpg"));	
                    	 sensor1.setText("危險");
                    	 //System.out.println("危險");
                     }else{
                    	 sensor1.setIcon(new ImageIcon(".\\imgs\\green.jpg"));	
                    	 sensor1.setText("安全");
                    	 //System.out.println("安全");
                     }
				 i++;
				 sleep(500);	
				}
			}catch(Exception e){
				 System.out.println("Reader() fail..");
			}
		}
	}

}
