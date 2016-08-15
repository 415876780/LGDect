package ccnu.com.org;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTree;
import javax.swing.SwingWorker;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;

import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Check extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTree tree;
	private Scanner sc;
	private JTextArea textArea;
	private JComboBox comboBox;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public Check() {
		setTitle("Check");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 701, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JSeparator separator = new JSeparator();

		tree = new JTree();
		tree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("JTree") {
			{
				
				add(new DefaultMutableTreeNode("\u6210\u8BED"));
				add(
						new DefaultMutableTreeNode(
								"\u5E38\u7528\u8BCD\u4E00\u7C7B"));
				add(
						new DefaultMutableTreeNode(
								"\u5E38\u7528\u8BCD\u4E8C\u7C7B"));
				add(
						new DefaultMutableTreeNode(
								"\u5E38\u7528\u5B57\u4E00\u7C7B"));
				add(
						new DefaultMutableTreeNode(
								"\u5E38\u7528\u5B57\u4E8C\u7C7B"));
			}
		}));
		tree.addTreeSelectionListener(new TreeSelectionListener() {

			@Override
			public void valueChanged(TreeSelectionEvent e) {
				// TODO Auto-generated method stub
				DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree
						.getLastSelectedPathComponent();
				StringBuffer sb = new StringBuffer();
				if (selectedNode.toString().equals("成语")) {
					try {
						sc = new Scanner(new File("./ccnu_dict/idiom_dict.txt"),
								"utf-8");
						while (sc.hasNextLine()) {
							sb.append(sc.nextLine().trim() + "\n");
						}
						sc.close();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
				if (selectedNode.toString().equals("常用词一类")) {
					try {
						sc = new Scanner(new File("./ccnu_dict/common_words_1"),
								"utf-8");
						while (sc.hasNextLine()) {
							sb.append(sc.nextLine().trim() + "\n");
						}
						sc.close();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (selectedNode.toString().equals("常用词二类")) {
					try {
						sc = new Scanner(new File("./ccnu_dict/common_words_2"),
								"utf-8");
						while (sc.hasNextLine()) {
							sb.append(sc.nextLine().trim() + "\n");
						}
						sc.close();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (selectedNode.toString().equals("常用字一类")) {
					try {
						sc = new Scanner(new File("./ccnu_dict/common_word_1"),
								"utf-8");
						while (sc.hasNextLine()) {
							sb.append(sc.nextLine().trim() + "\n");
						}
						sc.close();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (selectedNode.toString().equals("常用字二类")) {
					try {
						sc = new Scanner(new File("./ccnu_dict/common_word_2"),
								"utf-8");
						while (sc.hasNextLine()) {
							sb.append(sc.nextLine().trim() + "\n");
						}
						sc.close();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (!sb.toString().equals("")) {

					textArea.setText(sb.toString());
					/*
					 * textArea.requestFocus(); //获得焦点
					 * textArea.setSelectionStart(100);
					 * textArea.setSelectionEnd(102);
					 */
				}
			}
		});
		tree.setFont(new Font("宋体", Font.PLAIN, 14));

		tree.setRootVisible(false);

		JLabel lblNewLabel = new JLabel("       \u67E5\u627E\u8BCD\u8BED:");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));

		textField = new JTextField();
		textField.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();

		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {
				"\u6210\u8BED\u8BCD\u5178", "\u5E38\u7528\u8BCD\u4E00\u7C7B",
				"\u5E38\u7528\u8BCD\u4E8C\u7C7B",
				"\u5E38\u7528\u5B57\u4E00\u7C7B",
				"\u5E38\u7528\u5B57\u4E8C\u7C7B" }));

		btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeTextArea();
			}
		});
		
		btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(tree, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
							.addComponent(btnNewButton_1))
						.addComponent(separator, GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(tree, GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)))
		);

		textArea = new JTextArea();
		textArea.setFont(new Font("宋体", Font.PLAIN, 14));
		textArea.setSelectionStart(10);
		scrollPane.setViewportView(textArea);
		contentPane.setLayout(gl_contentPane);
		setLocation(700, 300);
	}

	public void changeTextArea() {
		new SwingWorker<String, String>() {

			@Override
			protected String doInBackground() throws Exception {
				// TODO Auto-generated method stub

				return null;
			}

			@Override
			protected void process(List<String> chunks) {
				// TODO Auto-generated method stub
				super.process(chunks);
			}

			@Override
			protected void done() {
				// TODO Auto-generated method stub
				System.out.println(comboBox.getSelectedItem().toString());
				StringBuffer sb = new StringBuffer();

				try {
					if (comboBox.getSelectedItem().toString().equals("成语词典")) {
						sc = new Scanner(new File("./ccnu_dict/idiom_dict.txt"),
								"utf-8");
					}
					if (comboBox.getSelectedItem().toString().equals("常用词一类")) {
						sc = new Scanner(new File("./ccnu_dict/common_words_1"),
								"utf-8");
					}
					if (comboBox.getSelectedItem().toString().equals("常用词二类")) {
						sc = new Scanner(new File("./ccnu_dict/common_words_2"),
								"utf-8");
					}
					if (comboBox.getSelectedItem().toString().equals("常用字一类")) {
						sc = new Scanner(new File("./ccnu_dict/common_word_1"),
								"utf-8");
					}
					if (comboBox.getSelectedItem().toString().equals("常用字二类")) {
						sc = new Scanner(new File("./ccnu_dict/common_word_2"),
								"utf-8");
					}

					while (sc.hasNextLine()) {
						sb.append(sc.nextLine().trim() + "\n");
					}
					
					String text = textField.getText().trim();
					if(!sb.toString().contains("")){
						JOptionPane.showMessageDialog(null, "请先输入内容");
					}
					textArea.requestFocus(); // 获得焦点
					// textArea.setSelectionStart(6);
					// textArea.setSelectionEnd(10);
					textArea.setSelectionStart(sb.toString().indexOf(text));
					textArea.setSelectionEnd(sb.toString().indexOf(text)
							+ text.length());
					sc.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if (comboBox.getSelectedIndex() == 1) {

				}
				super.done();
			}

		}.execute();
	}
}
