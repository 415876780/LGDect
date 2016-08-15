package ccnu.com.listener;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
/*
 * 查看词典界面监听器
 * */
public class MyTreeSelectionListener implements TreeSelectionListener {
	private JTextArea textArea;
	private JTree tree;
	private Scanner sc=null;
	public MyTreeSelectionListener(JTree t,JTextArea a){
		this.tree=t;
		this.textArea=a;
	}
	
	@Override
	public void valueChanged(TreeSelectionEvent e) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree
				.getLastSelectedPathComponent();
		StringBuffer sb = new StringBuffer();
		if (selectedNode.toString().equals("成语词典")) {
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
		if (selectedNode.toString().equals("一类常用词典")) {
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
		if (selectedNode.toString().equals("二类常用词典")) {
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
		if (selectedNode.toString().equals("一类常用字典")) {
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
		if (selectedNode.toString().equals("二类常用字典")) {
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
			
		}
	}
}
