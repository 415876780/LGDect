package ccnu.com.listener;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

public class SearchWordListener implements ActionListener {

	private JComboBox comboBox_1;
	private JTextField textField_9;
	private JPanel panel_1;
	private JTextArea textArea;
	private CardLayout cd;
	public SearchWordListener(JComboBox comboBox_1, JTextField textField_9,
			JPanel panel_1, JTextArea textArea, CardLayout cd) {
		this.comboBox_1 = comboBox_1;
		this.textField_9 = textField_9;
		this.panel_1 = panel_1;
		this.textArea = textArea;
		this.cd = cd;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		changeTextArea();
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
				System.out.println(comboBox_1.getSelectedItem().toString());
				StringBuffer sb = new StringBuffer();
				Scanner sc = null;
				try {
					if (comboBox_1.getSelectedItem().toString().equals("����ʵ�")) {
						sc = new Scanner(new File("./ccnu_dict/idiom_dict.txt"),
								"utf-8");
					}
					if (comboBox_1.getSelectedItem().toString().equals("һ�ೣ�ôʵ�")) {
						sc = new Scanner(new File("./ccnu_dict/common_words_1"),
								"utf-8");
					}
					if (comboBox_1.getSelectedItem().toString().equals("���ೣ�ôʵ�")) {
						sc = new Scanner(new File("./ccnu_dict/common_words_2"),
								"utf-8");
					}
					if (comboBox_1.getSelectedItem().toString().equals("һ�ೣ���ֵ�")) {
						sc = new Scanner(new File("./ccnu_dict/common_word_1"),
								"utf-8");
					}
					if (comboBox_1.getSelectedItem().toString().equals("���ೣ���ֵ�")) {
						sc = new Scanner(new File("./ccnu_dict/common_word_2"),
								"utf-8");
					}

					while (sc.hasNextLine()) {
						sb.append(sc.nextLine().trim() + "\n");
					}
					
					String text = textField_9.getText().trim();
					if("".equals(text)){
						JOptionPane.showMessageDialog(null, "������������");
					}
					if(!sb.toString().contains(text)){
						int n = JOptionPane.showConfirmDialog(null, comboBox_1.getSelectedItem().toString()+"��û��"+text+"����ʣ��Ƿ�ѡ����ӣ�", "",JOptionPane.YES_NO_OPTION);
						if(n==0){
							cd.show(panel_1, "name_739502831980707");
						}
					}
					textArea.requestFocus(); // ��ý���
					// textArea.setSelectionStart(6);
					// textArea.setSelectionEnd(10);
					textArea.setText(sb.toString());
					textArea.setSelectionStart(sb.toString().indexOf(text));
					textArea.setSelectionEnd(sb.toString().indexOf(text)
							+ text.length());
					sc.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				super.done();
			}

		}.execute();
	}


}
