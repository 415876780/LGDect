package ccnu.com.org;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TestNet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileWriter fw= new FileWriter(new File("11.txt"),true);
			fw.write("hello world");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//new TestNet().init("http://news.163.com/16/0306/00/BHECTVP400014PRF.html");
	}
	public String init(String url ){
		HashMap<String , Integer> map= new HashMap<String, Integer>();
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
				String id = ee.parent().className();
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
			Elements es = doc.getElementsByClass(classTag);
			Elements ps = es.select("p");
			for (Element p : ps) {
				sb.append(p.text());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			 e.printStackTrace();
		}
		return sb.toString();
	
	}

}
