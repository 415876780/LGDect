package ccnu.com.org;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.JTextPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class Manual extends JFrame {
	private JPanel contentPane;
	private JButton btnNewButton;
	private JTextField textField;
	private JButton button_1;
	private JButton button;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_9;
	private JTextPane textPane;
	private Calc calc =null;
	public Calc getCalc() {
		return calc;
	}
	public void setCalc(Calc calc) {
		this.calc = calc;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manual frame = new Manual(null);
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
	public Manual(Calc c) {
		setTitle("\u8BED\u8A00\u6587\u5B57\u4F7F\u7528\u6C34\u5E73\u8BC4\u4EF7\u7CFB\u7EDF");
		this.setCalc(c);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 780, 613);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u914D\u7F6E");
		menuBar.add(mnNewMenu);
		
		JMenuItem menuItem = new JMenuItem("\u8BBE\u7F6E");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnNewMenu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u6DFB\u52A0\u65B0\u8BCD");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							
							Setting frame = new Setting(calc);
							frame.setVisible(true);
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			
			}
		});
		mnNewMenu.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("\u6539\u53D8\u6743\u91CD");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							
							Setting frame = new Setting(calc);
							frame.setVisible(true);
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		mnNewMenu.add(menuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JLabel lblNewLabel = new JLabel(
				"\u9009\u62E9\u672C\u5730\u6587\u4EF6\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		JSeparator separator = new JSeparator();
		JScrollPane scrollPane = new JScrollPane();
		//选择按钮
		btnNewButton = new JButton("\u9009\u62E9");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 14));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 JFileChooser jfc=new JFileChooser();  
			        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  
			        //jfc.showDialog(new JLabel(), "选择");
			        File path=new File(System.getProperty("user.dir"));//注意了，这里重要的一句  
			        jfc.setCurrentDirectory(path); 
			        
			        int i = jfc.showOpenDialog(getContentPane());  //opendialog
			        if(i==JFileChooser.APPROVE_OPTION)  
			        {
			        	File file=jfc.getSelectedFile();  
			        	System.out.println(file.getAbsolutePath());
			        	textField.setText(file.getAbsolutePath());
			        	Scanner sc;
						try {
							sc = new Scanner (file,"gbk");
							StringBuffer sb = new StringBuffer();
				        	 while(sc.hasNext()){
				        		 sb.append(sc.nextLine());
				        	 }
				             textPane.setText(sb.toString());
				             sc.close();
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			        	   
			        }
				
				
			}
		});
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setToolTipText("\u8BC4\u4EF7");
	
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 14));
		textField.setColumns(10);
		
		JSeparator separator_2 = new JSeparator();
		
		button = new JButton("\u53D6\u6D88");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		//确定按钮
		button_1 = new JButton("\u786E\u5B9A");
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String content = textPane.getText();
				if("".equals(content)){
					JOptionPane.showMessageDialog(null, "请先输入内容");
				}else{
					evaluate(content);
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(2)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(separator_2, GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
						.addComponent(separator, GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(485)
					.addComponent(button)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(button_1)
					.addGap(21))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(12)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(14)
							.addComponent(btnNewButton)))
					.addGap(18)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(tabbedPane, 0, 0, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(button, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
						.addComponent(button_1, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)))
		);
		
		textPane = new JTextPane();
		textPane.setFont(new Font("宋体", Font.PLAIN, 14));
		scrollPane.setViewportView(textPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("评价", null, panel, null);

		JLabel lblNewLabel_2 = new JLabel(
				"\u5E38\u7528\u8BCD\u4E00\u7C7B\u6570\u76EE\uFF1A");

		JLabel lblNewLabel_3 = new JLabel(
				"\u5E38\u7528\u8BCD\u4E8C\u7C7B\u6570\u76EE\uFF1A");

		lblNewLabel_4 = new JLabel("");

		lblNewLabel_5 = new JLabel("");

		JLabel label = new JLabel(
				"\u5E38\u7528\u5B57\u4E00\u7C7B\u6570\u76EE\uFF1A");

		lblNewLabel_6 = new JLabel("");

		JLabel label_1 = new JLabel(
				"\u5E38\u7528\u5B57\u4E8C\u7C7B\u6570\u76EE\uFF1A");

		lblNewLabel_7 = new JLabel("");

		JLabel lblNewLabel_8 = new JLabel(
				"\u6210\u8BED\u4F7F\u7528\u6570\u76EE  \uFF1A");

		lblNewLabel_1 = new JLabel("");

		JSeparator separator_1 = new JSeparator();

		JLabel lblNewLabel_10 = new JLabel("\u7EFC\u5408\u8BC4\u4EF7\uFF1A");
		lblNewLabel_10.setFont(new Font("宋体", Font.PLAIN, 14));
		
		lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setFont(new Font("宋体", Font.PLAIN, 30));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_4))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_3)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_5))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_6))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(label_1)
										.addComponent(lblNewLabel_8))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_1)
										.addComponent(lblNewLabel_7)))
								.addComponent(lblNewLabel_10)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(72)
							.addComponent(lblNewLabel_9)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_4))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_5))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(lblNewLabel_6))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(lblNewLabel_7))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_8)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_10)
					.addGap(44)
					.addComponent(lblNewLabel_9)
					.addContainerGap(161, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		setLocation(700, 300);
	}

	public void  evaluate(final String content) {
		new SwingWorker<String, String>(){
			private int pos;
			private Document doc=null;
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
					lblNewLabel_4.setText(arr[1]);
					lblNewLabel_5.setText(arr[2]);
					lblNewLabel_6.setText(arr[3]);
					lblNewLabel_7.setText(arr[4]);
					lblNewLabel_1.setText(arr[0]);
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
	public void display(final Set<String> idiom){
		new SwingWorker<String, String>(){
			@Override
			protected void process(List<String> chunks) {
				// TODO Auto-generated method stub
				super.process(chunks);
			}
			@Override
			protected void done() {
				// TODO Auto-generated method stub
				super.done();
			}
			@Override
			protected String doInBackground() throws Exception {
				// TODO Auto-generated method stub
				
				return null;
			}
		}.execute();;
	}
	
}
