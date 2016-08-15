package ccnu.com.org;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class One extends JFrame {
	private Calc calc=null;
	private JPanel contentPane;
	public static boolean flag=false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					One frame = new One();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public One() {
		calc= new Calc();
		setTitle("\u8BED\u8A00\u6587\u5B57\u4F7F\u7528\u6C34\u5E73\u8BC4\u4EF7\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btnNewButton = new JButton("\u624B\u52A8\u8F93\u5165");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Manual frame = new Manual(calc);
							frame.setVisible(true);
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton.setBounds(153, 81, 134, 47);
		contentPane.add(btnNewButton);
		JButton button = new JButton("\u7F51\u4E0A\u67E5\u627E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Net frame = new Net(calc);
							frame.setVisible(true);
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		button.setBounds(153, 150, 134, 47);
		contentPane.add(button);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 424, 21);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u8BBE\u7F6E");
		menuBar.add(mnNewMenu);
		
		JMenuItem menuItem_1 = new JMenuItem("\u6DFB\u52A0\u8BCD\u8BED");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Setting frame = new Setting(null);
							frame.setVisible(true);
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		mnNewMenu.add(menuItem_1);
		JMenuItem menuItem_2 = new JMenuItem("\u67E5\u770B\u8BCD\u5178");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							
							Check frame = new Check();
							frame.setVisible(true);
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		mnNewMenu.add(menuItem_2);
		JMenuItem menuItem = new JMenuItem("\u5E2E\u52A9");
		mnNewMenu.add(menuItem);
		setLocation(700, 300);
	}
}
