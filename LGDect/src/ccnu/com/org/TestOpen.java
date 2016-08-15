package ccnu.com.org;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.JEditorPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import   javax.swing.*;   
import   java.awt.*;   
import   java.awt.event.*;   
import   javax.swing.text.*;   
import   java.io.*;   
public class TestOpen extends JFrame {
	private JPanel contentPane;
	private JFileChooser chooser;
	private JTextPane textPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestOpen frame = new TestOpen();
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
	public TestOpen() {
		chooser = new JFileChooser();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textPane = new JTextPane();
		setDocs( "第一行的文字 ",Color.red,false,20);   
        setDocs( "第二行的文字 ",Color.BLACK,true,25);   
        setDocs( "第三行的文字 ",Color.BLUE,false,20); 
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(158, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(39, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	 public   void   setDocs(String   str,Color   col,boolean   bold,int   fontSize)   {   
	        SimpleAttributeSet   attrSet   =   new   SimpleAttributeSet();   
	        StyleConstants.setForeground(attrSet,   col);   
	        //颜色   
	        if(bold==true){   
	            StyleConstants.setBold(attrSet,   true);   
	        }//字体类型   
	        StyleConstants.setFontSize(attrSet,   fontSize);   
	        //字体大小   
	        insert(str,   attrSet);   
	    }  
	  public   void   insert(String   str,   AttributeSet   attrSet)   {   
	        Document   doc   =   textPane.getDocument();   
	       // str   = "\n"   +   str   ;   
	        try   {   
	        	System.out.println(doc.getText(0, doc.getLength())+doc.getLength());
	            doc.insertString(0,   str,   attrSet);   
	        }   
	        catch   (BadLocationException   e)   {   
	            System.out.println( "BadLocationException:   "   +   e);   
	        }   
	    }   
}
