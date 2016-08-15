package ccnu.com.org;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Setting extends JFrame {
	private Calc calc=null;
	public Calc getCalc() {
		return calc;
	}

	public void setCalc(Calc calc) {
		this.calc = calc;
	}

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JPanel panel;
	private JTextField textField_6;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public Setting(Calc calc) {
		setTitle("\u914D\u7F6E");
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 704, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton button = new JButton("\u6DFB\u52A0");
		
		JSeparator separator = new JSeparator();
		
		comboBox = new JComboBox();
		comboBox.addItem("成语");
		comboBox.addItem("新词");
		
		if(calc!=null){
			this.setCalc(calc);
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println(comboBox.getSelectedItem().toString());
					if(comboBox.getSelectedIndex()==0){
						panel.setVisible(false);
						if (!textField.getText().trim().equals("")) {
							Calc.addWordToIdiom(
									comboBox.getSelectedItem().toString());
							getCalc().getList().get(0).add(comboBox.getSelectedItem().toString());
							JOptionPane.showMessageDialog(null, "添加成功");
						}
					}
					if(comboBox.getSelectedIndex()==1){
						panel.setVisible(true);
					}
				}
			});
		}else{
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(comboBox.getSelectedIndex()==0){
						panel.setVisible(false);
						if (!textField.getText().trim().equals("")) {
							Calc.addWordToIdiom(
									comboBox.getSelectedItem().toString());
							JOptionPane.showMessageDialog(null, "添加成功");
						}
					}
					if(comboBox.getSelectedIndex()==1){
						panel.setVisible(true);
					}
				}
			});
		}
		
		JSeparator separator_1 = new JSeparator();
		
		JLabel label = new JLabel("\u6DFB\u52A0\u8BCD\u8BED");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel lblNewLabel = new JLabel("\u4FEE\u6539\u6743\u91CD");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JSeparator separator_2 = new JSeparator();
		
		JLabel lblNewLabel_1 = new JLabel("\u5E38\u7528\u8BCD\u4E00\u7C7B\uFF1A");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5E38\u7528\u5B57\u4E8C\u7C7B\uFF1A");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u5E38\u7528\u5B57\u4E00\u7C7B\uFF1A");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel label_2 = new JLabel("\u5E38\u7528\u8BCD\u4E8C\u7C7B\uFF1A");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JLabel label_3 = new JLabel("    \u6210\u8BED\u8BCD\uFF1A");
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_1.setText(Calc.getW1()+"");
		textField_2.setText(Calc.getW1()+"");
		textField_3.setText(Calc.getW2()+"");
		textField_4.setText(Calc.getW2()+"");
		textField_5.setText(Calc.getW3()+"");
		JSeparator separator_3 = new JSeparator();
		
		JButton btnNewButton = new JButton("\u5E94\u7528");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField_1.getText().trim().equals("")){
					Calc.setW1(Double.parseDouble(textField_1.getText().trim()));
				}
				if(!textField_2.getText().trim().equals("")){
					Calc.setW1(Double.parseDouble(textField_2.getText().trim()));
				}
				if(!textField_3.getText().trim().equals("")){
					Calc.setW2(Double.parseDouble(textField_3.getText().trim()));
				}
				if(!textField_4.getText().trim().equals("")){
					Calc.setW2(Double.parseDouble(textField_4.getText().trim()));
				}
				if(!textField_5.getText().trim().equals("")){
					Calc.setW3(Double.parseDouble(textField_5.getText().trim()));
				}
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u786E\u5B9A");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField_1.getText().trim().equals("")){
					Calc.setW1(Double.parseDouble(textField_1.getText().trim()));
				}
				if(!textField_2.getText().trim().equals("")){
					Calc.setW1(Double.parseDouble(textField_2.getText().trim()));
				}
				if(!textField_3.getText().trim().equals("")){
					Calc.setW2(Double.parseDouble(textField_3.getText().trim()));
				}
				if(!textField_4.getText().trim().equals("")){
					Calc.setW2(Double.parseDouble(textField_4.getText().trim()));
				}
				if(!textField_5.getText().trim().equals("")){
					Calc.setW3(Double.parseDouble(textField_5.getText().trim()));
				}
				if (getCalc()==null){
					Calc.addWordToIdiom(
							comboBox.getSelectedItem().toString());
				}else{
					Calc.addWordToIdiom(
							comboBox.getSelectedItem().toString());
					getCalc().getList().get(0).add(comboBox.getSelectedItem().toString());
				}
				dispose();
			}
		});
		
		JButton button_1 = new JButton("\u53D6\u6D88");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton button_2 = new JButton("\u8FD8\u539F\u9ED8\u8BA4\u503C");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText(Calc.getW1()+"");
				textField_2.setText(Calc.getW1()+"");
				textField_3.setText(Calc.getW2()+"");
				textField_4.setText(Calc.getW2()+"");
				textField_5.setText(Calc.getW3()+"");
			}
		});
		
		panel = new JPanel();
		panel.setVisible(false);
		
		JLabel label_4 = new JLabel("   \u65B0\u8BCD\uFF1A");
		
		textField_6 = new JTextField();
		textField_6.setText("0");
		textField_6.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_4)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(63, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(label))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 694, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(button))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 694, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, 694, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(155)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(155)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(155)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(155)
					.addComponent(label_1)
					.addGap(4)
					.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(155)
					.addComponent(label_2)
					.addGap(4)
					.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(155)
					.addComponent(label_3)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(475)
					.addComponent(button_2)
					.addGap(18)
					.addComponent(btnNewButton))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(separator_3, GroupLayout.PREFERRED_SIZE, 684, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(521)
					.addComponent(button_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_1))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(label)
					.addGap(17)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(button))
					.addGap(18)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 3, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addComponent(lblNewLabel)
					.addGap(6)
					.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addGap(16)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(16)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(button_2))
					.addGap(10)
					.addComponent(separator_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(button_1)))
		);
		contentPane.setLayout(gl_contentPane);
		
		setLocation(700, 300);
	}
}
