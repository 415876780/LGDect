package ccnu.com.listener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ccnu.com.org.Calc;

public class InputURLListener implements ActionListener {

	private JTextField textField_17;
	private JTextComponent textPane1;
	private JLabel lblNewLabel_13;
	private JLabel label_j5;
	private JLabel label_j2;
	private JLabel label_j1;
	public InputURLListener(JTextField textField_17, JTextComponent textPane1,
			JLabel lblNewLabel_13, JLabel label_j5, JLabel label_j2,
			JLabel label_j1, JLabel label_j4, JLabel label_j3, Calc calc) {
		super();
		this.textField_17 = textField_17;
		this.textPane1 = textPane1;
		this.lblNewLabel_13 = lblNewLabel_13;
		this.label_j5 = label_j5;
		this.label_j2 = label_j2;
		this.label_j1 = label_j1;
		this.label_j4 = label_j4;
		this.label_j3 = label_j3;
		this.calc = calc;
	}


	private JLabel label_j4;
	private JLabel label_j3;
	private Calc calc;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String path = textField_17.getText().trim();
		if (!Pattern.matches("http://.*", path)) {
			JOptionPane.showMessageDialog(null, "请输入正确的网址");
			textField_17.setText("");
		} else {
			String contents = init(textField_17.getText());
			textPane1.setText(contents);
			net_evaluate(contents);
		}
	}
	
	public void net_evaluate(final String contents) {
		new SwingWorker<String, String>() {
			private int pos;
			private javax.swing.text.Document doc = null;
			@Override
			protected void process(List<String> chunks) {
				// TODO Auto-generated method stub
				StyleContext sc = new StyleContext();
				Style s = sc.addStyle(null, null);
				StyleConstants.setForeground(s, Color.RED);
				StyleConstants.setBackground(s, Color.WHITE);
				lblNewLabel_13.setText(chunks.get(0));
				for (int i = 1; i < chunks.size(); i++) {
					pos = contents.indexOf(chunks.get(i));
					while (-1 != pos) {
						try {
							doc.remove(pos, chunks.get(i).length());
							doc.insertString(pos, chunks.get(i), s);
						} catch (BadLocationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						pos = contents.indexOf(chunks.get(i), pos + 1);
					}
				}
				super.process(chunks);
			}

			@Override
			protected void done() {
				// TODO Auto-generated method stub
				try {
					String str = get();
					if (str == null)
						return;
					String arr[] = str.split("\t");
					label_j5.setText(arr[0]);
					label_j1.setText(arr[1]);
					label_j2.setText(arr[2]);
					label_j3.setText(arr[3]);
					label_j4.setText(arr[4]);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				super.done();
			}

			@Override
			protected String doInBackground() throws Exception {
				// TODO Auto-generated method stub
     			doc = textPane1.getDocument();
				calc.parserNew(contents);
				doc = textPane1.getDocument();
				publish(calc.getCulture_score() + "");
				Set<String> idiom = calc.getIdiom();
				for (String word : idiom) {
					publish(word);
				}
				// return 给done（），在done（）中可以调用get（）方法得到这里返回的值
				return calc.getSb().toString();

			}

		}.execute();
	}

	
	public String init(String url) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		StringBuffer sb = new StringBuffer();
		Document doc = null;
		try {
			doc = Jsoup
					.connect(url)
					.userAgent(
							"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.1.141.64 Safari/537.31")
					.timeout(100000).get();
			Elements e = doc.getElementsByTag("p");
			for (Element ee : e) {
				String id = ee.parent().id();
				if (map.containsKey(id)) {
					map.put(id, map.get(id) + 1);
				} else {
					map.put(id, 1);
				}
			}
			List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(
					map.entrySet());
			Collections.sort(list,
					new Comparator<Map.Entry<String, Integer>>() {

						@Override
						public int compare(Entry<String, Integer> o1,
								Entry<String, Integer> o2) {
							// TODO Auto-generated method stub
							return o2.getValue() - o1.getValue();
						}
					});

			String classTag = list.get(0).getKey();
			if ("".equals(classTag)) {
				classTag = list.get(1).getKey();
			}
			Elements es = doc.select("#" + classTag);
			Elements ps = es.select("p");
			for (Element p : ps) {
				sb.append(p.text() + "\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String content = sb.toString();
		if ("".equals(content)) {
			return "NULL";
		} else {
			return sb.toString();
		}

	}
}
