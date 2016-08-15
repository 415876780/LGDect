package ccnu.com.UI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;


import ccnu.com.listener.ChangeTextAreaListener;
import ccnu.com.listener.ChangeWeightListener;
import ccnu.com.listener.CheckListener;
import ccnu.com.listener.FileChooserListener;
import ccnu.com.listener.InputURLListener;
import ccnu.com.listener.MyTreeSelectionListener;
import ccnu.com.listener.SearchWordListener;
import ccnu.com.org.Calc;

import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JTextArea;
import javax.swing.JMenuItem;
public class Main extends JFrame {

	private JPanel contentPane;
	CardLayout cd=null;
	CardLayout cd1=null;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_17;
	private JTextField textField_8;
	private JTextPane textPane1;
	private JTextPane textPane;
	private JLabel lblNewLabel_13;
	private Calc calc =null;
	private JLabel lblNewLabel_9;
	private JLabel label_3;
	private JLabel lblNewLabel_7;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_p5;
	private JLabel label_p4;
	private JLabel label_p3;
	private JLabel label_p2;
	private JLabel label_p1;
	private Scanner sc;
	private JTextArea textArea;
	private JComboBox comboBox_1;
	private JTextField textField_9;
	final JPanel panel_1 = new JPanel();
	private JComboBox comboBox;
	private JPanel panel_6;
	private JLabel label_j5;
	private JLabel label_j4;
	private JLabel label_j3;
	private JLabel label_j2;
	private JLabel label_j1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		calc= new Calc();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 872, 772);
		textArea = new JTextArea();
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnOk = new JMenu("\u8BBE\u7F6E");
		menuBar.add(mnOk);
		comboBox_1 = new JComboBox();
		JMenuItem mntmNewMenuItem = new JMenuItem("\u6DFB\u52A0\u8BCD");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cd.show(panel_1, "name_739502831980707");
			}
		});

		mnOk.add(mntmNewMenuItem);
		
		JMenuItem menuItem = new JMenuItem("\u67E5\u770B\u8BCD\u5178");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cd.show(panel_1, "name_739509034703691");
			}
		});
	
		mnOk.add(menuItem);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel(){			
			public void paintComponent(Graphics g) {
			int x=0,y=0;
			super.paintComponent(g);
			ImageIcon img = new ImageIcon("112.jpg");
			g.drawImage(img.getImage(), x, y, getSize().width,getSize().height,this);
			
	     }
};
		panel.setBackground(new Color(224, 255, 255));
		
		JSeparator separator_1 = new JSeparator();
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE)
				.addComponent(separator_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE))
		);
		cd = new CardLayout(0, 0);
		panel_1.setLayout(cd);
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5, "name_780864702942915");
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
		);
		
		JPanel panel_7 = new JPanel();
		tabbedPane.addTab("本地选择", null, panel_7, null);
		
		JLabel lblNewLabel_6 = new JLabel("\u9009\u62E9\u672C\u5730\u6587\u4EF6\uFF1A");
		JLabel lblNewLabel_16 = new JLabel(" \u8F93\u5165\u9875\u9762\u7F51\u5740\uFF1A");
		lblNewLabel_16.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 14));
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("宋体", Font.PLAIN, 14));
		textField_7.setColumns(10);
		textPane1 = new JTextPane();
		textField_17 = new JTextField();
		textField_17.setFont(new Font("宋体", Font.PLAIN, 14));
		textField_17.setColumns(10);
		JButton btnNewButton_1 = new JButton("\u786E\u5B9A");
		
		JButton btnNewButton_11 = new JButton("\u786E\u5B9A");
		btnNewButton_11.setFont(new Font("宋体", Font.PLAIN, 14));
		//网络获取
		
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 14));
		
		JSeparator separator_5 = new JSeparator();
		JSeparator separator_15 = new JSeparator();
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		JTabbedPane tabbedPane_11 = new JTabbedPane(JTabbedPane.TOP);
		
		JSeparator separator_7 = new JSeparator();
		JSeparator separator_17 = new JSeparator();
		
		JButton button = new JButton("\u786E\u5B9A");
		//本地选择
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String content = textPane.getText();
				if("".equals(content)){
					JOptionPane.showMessageDialog(null, "请先输入内容");
				}else{
					manual_evaluate(content);
				}
			}
		});
		JButton button11 = new JButton("\u786E\u5B9A");
		
		JButton button_1 = new JButton("\u53D6\u6D88");
		JButton button_12 = new JButton("\u53D6\u6D88");
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_7 = new GroupLayout(panel_7);
		gl_panel_7.setHorizontalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_7.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 529, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tabbedPane_1, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE))
						.addComponent(separator_5, GroupLayout.DEFAULT_SIZE, 821, Short.MAX_VALUE)
						.addGroup(gl_panel_7.createSequentialGroup()
							.addComponent(lblNewLabel_6)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_7, GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton_1))
						.addGroup(Alignment.TRAILING, gl_panel_7.createSequentialGroup()
							.addComponent(button_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button)
							.addGap(28))
						.addComponent(separator_7, GroupLayout.DEFAULT_SIZE, 821, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_7.setVerticalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_7.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_5, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_7.createParallelGroup(Alignment.LEADING, false)
						.addComponent(tabbedPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(separator_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_7.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		
		JPanel panel_9 = new JPanel();
		tabbedPane_1.addTab("评价", null, panel_9, null);
		
		lblNewLabel_7 = new JLabel("\u4E00\u7C7B\u5E38\u7528\u8BCD\u4F7F\u7528\u6570\u76EE\uFF1A");
		lblNewLabel_7.setFont(new Font("宋体", Font.PLAIN, 14));
		
		label_3 = new JLabel("\u4E8C\u7C7B\u5E38\u7528\u8BCD\u4F7F\u7528\u6570\u76EE\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 14));
		
		label_5 = new JLabel("\u4E00\u7C7B\u5E38\u7528\u5B57\u4F7F\u7528\u6570\u76EE\uFF1A");
		label_5.setFont(new Font("宋体", Font.PLAIN, 14));
		
		label_6 = new JLabel("\u4E8C\u7C7B\u5E38\u7528\u5B57\u4F7F\u7528\u6570\u76EE\uFF1A");
		label_6.setFont(new Font("宋体", Font.PLAIN, 14));
		
		label_7 = new JLabel("      \u6210\u8BED\u4F7F\u7528\u6570\u76EE\uFF1A");
		label_7.setFont(new Font("宋体", Font.PLAIN, 14));
		
		JSeparator separator_6 = new JSeparator();
		JSeparator separator_16 = new JSeparator();
		
		JLabel label_12 = new JLabel("\u7EFC\u5408\u8BC4\u4EF7\uFF1A");
		label_12.setFont(new Font("宋体", Font.PLAIN, 18));
		
		lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setFont(new Font("宋体", Font.PLAIN, 24));
		
		label_p1 = new JLabel("");
		
		label_p2 = new JLabel("");
		
		label_p3 = new JLabel("");
		
		label_p4 = new JLabel("");
		
		label_p5 = new JLabel("");
		GroupLayout gl_panel_9 = new GroupLayout(panel_9);
		gl_panel_9.setHorizontalGroup(
			gl_panel_9.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_9.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_9.createParallelGroup(Alignment.LEADING)
						.addComponent(separator_6, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
						.addGroup(gl_panel_9.createSequentialGroup()
							.addGroup(gl_panel_9.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(label_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(label_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(label_6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(label_7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_9.createParallelGroup(Alignment.LEADING)
								.addComponent(label_p5)
								.addComponent(label_p4)
								.addComponent(label_p3)
								.addComponent(label_p2)
								.addComponent(label_p1)))
						.addGroup(gl_panel_9.createSequentialGroup()
							.addComponent(label_12)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_9)))
					.addContainerGap())
		);
		gl_panel_9.setVerticalGroup(
			gl_panel_9.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_9.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_9.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_7)
						.addComponent(label_p1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_9.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_p2))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_9.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_p3))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_9.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_p4))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_9.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_p5))
					.addGap(18)
					.addComponent(separator_6, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addGap(63)
					.addGroup(gl_panel_9.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_12)
						.addComponent(lblNewLabel_9))
					.addContainerGap(186, Short.MAX_VALUE))
		);
		panel_9.setLayout(gl_panel_9);
		panel_7.setLayout(gl_panel_7);
		
		JPanel panel_8 = new JPanel();
		tabbedPane.addTab("网页获取", null, panel_8, null);
		
		JLabel lblNewLabel_10 = new JLabel("\u7F51  \u5740\uFF1A");
		lblNewLabel_10.setFont(new Font("宋体", Font.PLAIN, 14));
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("宋体", Font.PLAIN, 14));
		textField_8.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("\u786E\u5B9A");
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 14));
		
		JSeparator separator_8 = new JSeparator();
		
		JTextPane textPane_1 = new JTextPane();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panel_8 = new GroupLayout(panel_8);
		gl_panel_8.setHorizontalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_8.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_8.createSequentialGroup()
							.addGroup(gl_panel_8.createParallelGroup(Alignment.LEADING)
								.addComponent(separator_15, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 821, Short.MAX_VALUE)
								.addGroup(Alignment.TRAILING, gl_panel_8.createSequentialGroup()
									.addComponent(lblNewLabel_16)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField_17, GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnNewButton_11))
								.addGroup(gl_panel_8.createSequentialGroup()
									.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 529, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
									.addComponent(tabbedPane_11, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE))
								.addComponent(separator_17, GroupLayout.DEFAULT_SIZE, 821, Short.MAX_VALUE))
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panel_8.createSequentialGroup()
							.addComponent(button_12)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button11)
							.addGap(28))))
		);
		gl_panel_8.setVerticalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_8.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_16)
						.addComponent(textField_17, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_11))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_15, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_8.createParallelGroup(Alignment.LEADING, false)
						.addComponent(tabbedPane_11, 0, 0, Short.MAX_VALUE)
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(separator_17, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel_8.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_12)
						.addComponent(button11))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		
		scrollPane_1.setViewportView(textPane1);
			
			JPanel panel_10 = new JPanel();
			tabbedPane_11.addTab("评价", null, panel_10, null);
			
			JLabel lblNewLabel_11 = new JLabel("\u4E00\u7C7B\u5E38\u7528\u8BCD\u4F7F\u7528\u6570\u76EE\uFF1A");
			lblNewLabel_11.setFont(new Font("宋体", Font.PLAIN, 14));
			
			JLabel label_4 = new JLabel("\u4E8C\u7C7B\u5E38\u7528\u8BCD\u4F7F\u7528\u6570\u76EE\uFF1A");
			label_4.setFont(new Font("宋体", Font.PLAIN, 14));
			
			JLabel label_13 = new JLabel("\u4E00\u7C7B\u5E38\u7528\u5B57\u4F7F\u7528\u6570\u76EE\uFF1A");
			label_13.setFont(new Font("宋体", Font.PLAIN, 14));
			
			JLabel label_14 = new JLabel("\u4E8C\u7C7B\u5E38\u7528\u5B57\u4F7F\u7528\u6570\u76EE\uFF1A");
			label_14.setFont(new Font("宋体", Font.PLAIN, 14));
			
			JLabel label_15 = new JLabel("      \u6210\u8BED\u4F7F\u7528\u6570\u76EE\uFF1A");
			label_15.setFont(new Font("宋体", Font.PLAIN, 14));
			
			JSeparator separator_9 = new JSeparator();
			
			JLabel lblNewLabel_12 = new JLabel("\u7EFC\u5408\u8BC4\u4EF7\uFF1A");
			lblNewLabel_12.setFont(new Font("宋体", Font.PLAIN, 18));
			
			lblNewLabel_13 = new JLabel("");
			lblNewLabel_13.setFont(new Font("宋体", Font.PLAIN, 24));
			
			label_j1 = new JLabel("");
			
			label_j2 = new JLabel("");
			
			label_j3 = new JLabel("");
			
			label_j4 = new JLabel("");
			
			label_j5 = new JLabel("");
			GroupLayout gl_panel_10 = new GroupLayout(panel_10);
			gl_panel_10.setHorizontalGroup(
				gl_panel_10.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_10.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_10.createParallelGroup(Alignment.LEADING)
							.addComponent(separator_9, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
							.addGroup(gl_panel_10.createSequentialGroup()
								.addGroup(gl_panel_10.createParallelGroup(Alignment.LEADING, false)
									.addComponent(label_15, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGroup(gl_panel_10.createSequentialGroup()
										.addComponent(label_14, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGap(6))
									.addComponent(label_13, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(label_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblNewLabel_11, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGap(18)
								.addGroup(gl_panel_10.createParallelGroup(Alignment.LEADING)
									.addComponent(label_j3, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
									.addComponent(label_j4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(label_j5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(label_j1, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
									.addComponent(label_j2, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)))
							.addGroup(gl_panel_10.createSequentialGroup()
								.addComponent(lblNewLabel_12)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblNewLabel_13)))
						.addContainerGap())
			);
			gl_panel_10.setVerticalGroup(
				gl_panel_10.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_10.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_10.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_11)
							.addComponent(label_j1))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel_10.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_j2))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel_10.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_13, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_j3))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel_10.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_14, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_j4))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel_10.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_15, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_j5))
						.addGap(18)
						.addComponent(separator_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(67)
						.addGroup(gl_panel_10.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_12)
							.addComponent(lblNewLabel_13))
						.addContainerGap(182, Short.MAX_VALUE))
			);
			panel_10.setLayout(gl_panel_10);
		panel_8.setLayout(gl_panel_8);
		panel_5.setLayout(gl_panel_5);
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, "name_739502831980707");
		
		JLabel label = new JLabel("\u6DFB\u52A0\u65B0\u8BCD");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		JSeparator separator = new JSeparator();
		panel_6 = new JPanel();
		panel_6.setVisible(false);
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u6210\u8BED", "\u65B0\u8BCD"}));
		
		textField = new JTextField();
		textField.setColumns(10);
		
        textField_1 = new JTextField();
		
		textField_1.setText(Calc.getWs_1()+"");
		textField_1.setColumns(10);
		textField_1.addFocusListener(new CheckListener(textField_1));
		
		textField_2 = new JTextField();
		textField_2.setText(Calc.getWs_2()+"");
		textField_2.setColumns(10);
		textField_2.addFocusListener(new CheckListener(textField_2));
		
		textField_3 = new JTextField();
		textField_3.setText(Calc.getW1()+"");
		textField_3.setColumns(10);
		textField_3.addFocusListener(new CheckListener(textField_3));
		
		textField_4 = new JTextField();
		textField_4.setText(Calc.getW2()+"");
		textField_4.setColumns(10);
		textField_4.addFocusListener(new CheckListener(textField_4));
		
		textField_5 = new JTextField();
		textField_5.setText(Calc.getW3()+"");
		textField_5.setColumns(10);
		textField_5.addFocusListener(new CheckListener(textField_5));
		textField_6 = new JTextField();
		textField_6.setBounds(93, 2, 114, 23);
		panel_6.add(textField_6);
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ChangeTextAreaListener( comboBox,
				 panel_6,  textField,  cd,  panel_1));
		
		JSeparator separator_2 = new JSeparator();
		
		JLabel lblNewLabel = new JLabel("\u4FEE\u6539\u6743\u91CD");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JSeparator separator_3 = new JSeparator();
		
		JPanel panel_4 = new JPanel();
		
		JSeparator separator_4 = new JSeparator();
		
		JButton button_2 = new JButton("\u5E94\u7528");
		button_2.addActionListener(new ChangeWeightListener(textField_1,textField_2,textField_3,textField_4,textField_5,textField_6));
		
		JButton button_3 = new JButton("\u53D6\u6D88");
		
		JButton button_4 = new JButton("\u8FD4\u56DE");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cd.show(panel_1, "name_780864702942915");
			}
		});
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
							.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE)
							.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
								.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
									.addComponent(separator_2, GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE)
									.addComponent(separator_3, GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE)
									.addComponent(separator, GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE))
								.addContainerGap())
							.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
								.addComponent(label, GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
								.addGap(104))
							.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnNewButton)
								.addContainerGap(524, Short.MAX_VALUE))
							.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
								.addComponent(lblNewLabel)
								.addContainerGap(764, Short.MAX_VALUE))
							.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
								.addComponent(button_2)
								.addGap(24))
							.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
								.addComponent(separator_4, GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE)
								.addContainerGap()))
						.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
							.addComponent(button_4)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button_3)
							.addGap(29))))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(5)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_3, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(button_2)
					.addGap(18)
					.addComponent(separator_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_4)
						.addComponent(button_3))
					.addContainerGap(120, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel("\u4E00\u7C7B\u5E38\u7528\u8BCD\uFF1A");
		
		JLabel lblNewLabel_2 = new JLabel("\u4E8C\u7C7B\u5E38\u7528\u8BCD\uFF1A");
		
		JLabel lblNewLabel_3 = new JLabel("\u4E00\u7C7B\u5E38\u7528\u5B57\uFF1A");
		
		JLabel lblNewLabel_4 = new JLabel("\u4E8C\u7C7B\u5E38\u7528\u5B57\uFF1A");
		
		JLabel lblNewLabel_5 = new JLabel("\u6210      \u8BED\uFF1A");
		
		
		
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_5)
								.addComponent(lblNewLabel_4))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(505, Short.MAX_VALUE))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		panel_6.setLayout(null);
		
		JLabel label_2 = new JLabel("\u65B0      \u8BCD\uFF1A");
		label_2.setBounds(0, 0, 79, 26);
		panel_6.add(label_2);
		
		
		textField_6.setColumns(10);
		panel_4.setLayout(gl_panel_4);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, "name_739509034703691");
		
		JLabel label_1 = new JLabel("\u67E5\u627E\u8BCD\u8BED\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 14));
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		
		
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"\u6210\u8BED\u8BCD\u5178", "\u4E00\u7C7B\u5E38\u7528\u8BCD\u5178", "\u4E8C\u7C7B\u5E38\u7528\u8BCD\u5178", "\u4E00\u7C7B\u5E38\u7528\u5B57\u5178", "\u4E8C\u7C7B\u5E38\u7528\u5B57\u5178"}));
		
		JButton btnNewButton_3 = new JButton("\u786E\u5B9A");
		btnNewButton_3.addActionListener(new SearchWordListener(comboBox_1, textField_9,
				panel_1, textArea, cd));
		
		JButton button_5 = new JButton("\u53D6\u6D88");
		
		JSeparator separator_10 = new JSeparator();
		
		final JTree tree = new JTree();
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("\u8BCD\u5178") {
				{
					getContentPane().add(new DefaultMutableTreeNode("\u6210\u8BED\u8BCD\u5178"));
					getContentPane().add(new DefaultMutableTreeNode("\u4E00\u7C7B\u5E38\u7528\u8BCD\u5178"));
					getContentPane().add(new DefaultMutableTreeNode("\u4E8C\u7C7B\u5E38\u7528\u8BCD\u5178"));
					getContentPane().add(new DefaultMutableTreeNode("\u4E00\u7C7B\u5E38\u7528\u5B57\u5178"));
					getContentPane().add(new DefaultMutableTreeNode("\u4E8C\u7C7B\u5E38\u7528\u5B57\u5178"));
				}
			}
		));
		tree.addTreeSelectionListener(new MyTreeSelectionListener(tree,textArea) );
		tree.setFont(new Font("宋体", Font.PLAIN, 14));

		//tree.setRootVisible(false);
		JScrollPane scrollPane_2 = new JScrollPane();
		
		JSeparator separator_11 = new JSeparator();
		
		JButton button_6 = new JButton("\u8FD4\u56DE");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cd.show(panel_1, "name_780864702942915");
			}
		});
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(20)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(button_5, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(11)
							.addComponent(separator_10, GroupLayout.DEFAULT_SIZE, 825, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_panel_3.createSequentialGroup()
							.addContainerGap()
							.addComponent(tree, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addContainerGap()
							.addComponent(separator_11, GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addContainerGap()
							.addComponent(button_6, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_5)
						.addComponent(btnNewButton_3))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(separator_10, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(tree, GroupLayout.PREFERRED_SIZE, 466, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(12)
							.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 464, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(separator_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(button_6)
					.addGap(24))
		);
		
		scrollPane_2.setViewportView(textArea);
		panel_3.setLayout(gl_panel_3);
		contentPane.setLayout(gl_contentPane);
		btnNewButton_11.addActionListener(new InputURLListener(textField_17, textPane1,
				lblNewLabel_13, label_j5, label_j2,
				label_j1, label_j4, label_j3, calc));
		btnNewButton_1.addActionListener(new FileChooserListener(textField_7,textPane,this));
	}
	
	public void  manual_evaluate(final String content) {
		new SwingWorker<String, String>(){
			private int pos;
			private javax.swing.text.Document doc=null;
			@Override
			protected void process(List<String> chunks) {
				// TODO Auto-generated method stub
				StyleContext sc = new StyleContext();
				Style s = sc.addStyle(null, null);
		        StyleConstants.setForeground(s, Color.RED);
		        StyleConstants.setBackground(s, Color.WHITE);
				lblNewLabel_9.setText(chunks.get(0));
				for(int i=1;i<chunks.size();i++){
					 pos = content.indexOf(chunks.get(i));
		                while (-1 != pos)
		                {
		                    try {
								doc.remove(pos, chunks.get(i).length());
								doc.insertString(pos, chunks.get(i), s);
							} catch (BadLocationException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
		                    pos = content.indexOf(chunks.get(i), pos + 1);
		                }
				}
				super.process(chunks);
			}
			@Override
			protected void done() {
				// TODO Auto-generated method stub
				try {
					String str= get();
					System.out.println(str);
					String arr[]=str.split("\t");
					System.out.println(arr[1]);
					
					label_p1.setText(arr[1]);
					System.out.println(arr[2]);
					label_p2.setText(arr[2]);
					System.out.println(arr[3]);
					label_p3.setText(arr[3]);
					System.out.println(arr[4]);
					label_p4.setText(arr[4]);
					label_p5.setText(arr[0]);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				super.done();
			}
			@Override
			protected String doInBackground() throws Exception {
				// TODO Auto-generated method stub
				System.out.println(content);
				calc.parserNew(content);
				doc= textPane.getDocument();
				System.out.println(doc.toString());
				//publish 是直接将值传递给process（）方法执行
				publish(calc.getCulture_score()+"");
				Set<String> idiom = calc.getIdiom();
				for(String word:idiom){
					publish(word);
				}
				//return 给done（），在done（）中可以调用get（）方法得到这里返回的值
				return calc.getSb().toString();
			}
			
		}.execute();
	}

}
