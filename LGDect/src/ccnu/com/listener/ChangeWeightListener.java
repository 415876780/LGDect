package ccnu.com.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
/*
 * 修改权重监听器
 * */
public class ChangeWeightListener implements ActionListener {

	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	public ChangeWeightListener(JTextField textField_1, JTextField textField_2,
			JTextField textField_3, JTextField textField_4,
			JTextField textField_5,JTextField textField_6) {
		
		this.textField_1 = textField_1;
		this.textField_2 = textField_2;
		this.textField_3 = textField_3;
		this.textField_4 = textField_4;
		this.textField_5 = textField_5;
		this.textField_6 = textField_6;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String ws_1 = textField_1.getText();
		String ws_2 = textField_2.getText();
		String w_1 = textField_3.getText();
		String w_2 = textField_4.getText();
		String w_3 = textField_5.getText();
		String neww = textField_6.getText();
		if ("".equals(ws_1)) {
			JOptionPane.showMessageDialog(null, "一类常用词权重为空，请输入内容！");
		}
		if ("".equals(ws_2)) {
			JOptionPane.showMessageDialog(null, "二类常用词权重为空，请输入内容！");
		}
		if ("".equals(w_1)) {
			JOptionPane.showMessageDialog(null, "一类常用字权重为空，请输入内容！");
		}
		if ("".equals(w_2)) {
			JOptionPane.showMessageDialog(null, "二类常用字权重为空，请输入内容！");
		}
		if ("".equals(w_3)) {
			JOptionPane.showMessageDialog(null, "成语权重为空，请输入内容！");
		}
		if ("".equals(neww)) {
			neww="0";
		}
		if(!"".equals(ws_1)&&!"".equals(ws_2)&&!"".equals(w_1)&&!"".equals(w_2)&&!"".equals(w_3)){
			PrintStream ps = null;
			try {
				ps = new PrintStream(new File("./ccnu_dict/weights"));
				ps.print("w_1="+w_1+"\n"+"w_2="+w_2+"\n"+"ws_1="+ws_1+"\n"+
				"ws_2="+ws_2+"\n"+"w_idom="+w_3+"\n"+"neww="+neww);
				
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally{
				ps.close();
			}
		}

	}

}
