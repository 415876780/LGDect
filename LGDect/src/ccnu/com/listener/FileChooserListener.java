package ccnu.com.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

public class FileChooserListener implements ActionListener {

	private JTextField textField_7;
	private JTextComponent textPane;
	private JFrame frame;
	public FileChooserListener(JTextField textField_7, JTextComponent textPane,JFrame frame) {
		this.textField_7 = textField_7;
		this.textPane = textPane;
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 JFileChooser jfc=new JFileChooser();  
	        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  
	        File path=new File(System.getProperty("user.dir"));
	        jfc.setCurrentDirectory(path); 
	        
	        int i = jfc.showOpenDialog(frame.getContentPane());  //opendialog
	        if(i==JFileChooser.APPROVE_OPTION)  
	        {
	        	File file=jfc.getSelectedFile();  
	        	System.out.println(file.getAbsolutePath());
	        	textField_7.setText(file.getAbsolutePath());
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

}
