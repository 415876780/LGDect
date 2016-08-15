package ccnu.com.listener;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
/*
 * �޸Ĵʵ������
 * */
public class ChangeTextAreaListener implements ActionListener {
	private JComboBox comboBox;
	private Scanner sc=null;
	private JPanel panel_6;
	private JTextField textField;
	private CardLayout cd=null;
	private JPanel panel_1;
	
	public ChangeTextAreaListener(JComboBox comboBox, 
			JPanel panel_6, JTextField textField, CardLayout cd, JPanel panel_1) {
		super();
		this.comboBox = comboBox;
		this.panel_6 = panel_6;
		this.textField = textField;
		this.cd = cd;
		this.panel_1 = panel_1;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(!textField.getText().matches("[\\u4E00-\\u9FA5]*")){
			JOptionPane.showMessageDialog(null, "�����뺺����صĴʣ�");
			textField.setText("");
		}else{
			changeTextArea_add();
		}
		
	}
	public void changeTextArea_add() {
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
				StringBuffer sb = new StringBuffer();
				FileWriter writer = null;
				try {
					if (comboBox.getSelectedItem().toString().equals("����")) {
						writer = new FileWriter(new File("./ccnu_dict/idiom_dict.txt"),true);
						sc = new Scanner(new File("./ccnu_dict/idiom_dict.txt"),
								"utf-8");
					}
					
					
					if (comboBox.getSelectedItem().toString().equals("�´�")) {
						
						writer = new FileWriter(new File("./ccnu_dict/new_words.txt"),true);
						sc = new Scanner(new File("./ccnu_dict/new_words.txt"),
								"utf-8");
						
					}

					while (sc.hasNextLine()) {
						sb.append(sc.nextLine().trim() + "\n");
					}
					
					String text = textField.getText().trim();
					if("".equals(text)){
						JOptionPane.showMessageDialog(null, "������������");
					}
					//����ʵ��������������
					if (sb.toString().contains(text)){
						int n = JOptionPane.showConfirmDialog(null, comboBox.getSelectedItem().toString()+"����"+text+"����ʣ��Ƿ�鿴��", "",JOptionPane.YES_NO_OPTION);
						if(n==0){
							cd.show(panel_1, "name_739509034703691");
						}else{
							textField.setText("");
						}
					}else{
						panel_6.setVisible(true);
						writer.write(text+"\n");
					}
					sc.close();
					writer.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				super.done();
			}

		}.execute();
	}

}
