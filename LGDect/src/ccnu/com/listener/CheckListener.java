package ccnu.com.listener;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
/*
 * Ȩ������������
 * */
public class CheckListener extends FocusAdapter {
	private JTextField text;
	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		String str=text.getText().trim();
		if(!str.matches("[0-9]*(\\.)?[0-9]*"))
		{
			JOptionPane.showMessageDialog(null, "������Ϸ������ݣ�");
			text.setText("");
		}
		
	}
	public CheckListener(JTextField t){
		this.text=t;
	}
}
