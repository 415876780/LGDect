package ccnu.com.org;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;

public class TestSwingworker extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestSwingworker frame = new TestSwingworker();
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
	public TestSwingworker() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("run");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				webRead();
			}
		});
		contentPane.add(btnNewButton, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}
	public void  webRead() {
		
		
		new SwingWorker<StringBuilder,String>(){

			@Override
			protected StringBuilder doInBackground() throws Exception {
				URL url = new URL("http://www.baidu.com");
				URLConnection connection = url.openConnection();
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(connection.getInputStream(),"utf-8"));
				String line;
				StringBuilder builder = new StringBuilder();
				while((line = reader.readLine())!=null){
					//publish(line);//调用process()方法
					builder.append(line).append("\n");
				}
				reader.close();
				return builder;
			}

			@Override
			protected void process(List<String> chunks) {
				for (String line:chunks) {
					textArea.append(line);
					textArea.append("\n");
				}
				super.process(chunks);
			}

			@Override
			protected void done() {
				try {
					//get得到的是doInBackground()返回值
					textArea.setText(get().toString());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				super.done();
			}
			
		}.execute();;
	}
}
