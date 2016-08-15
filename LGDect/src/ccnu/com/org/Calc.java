package ccnu.com.org;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Calc {
	private static double w1 = 0.15;// 一级字或词的权重
	private static double ws_1 = 0.15;// 一级字或词的权重
	private static double w2 = 0.35;//二级字或词的权重
	private static double ws_2 = 0.35;//二级字或词的权重
	private static double w3 = 1;//成语词的权重
	public static double getWs_1() {
		return ws_1;
	}

	public static void setWs_1(double ws_1) {
		Calc.ws_1 = ws_1;
	}

	public static double getWs_2() {
		return ws_2;
	}

	public static void setWs_2(double ws_2) {
		Calc.ws_2 = ws_2;
	}

	public static double getNeww() {
		return neww;
	}

	public static void setNeww(double neww) {
		Calc.neww = neww;
	}

	private static double neww = 0;//成语词的权重
	private String culture_score;
	private int norm_score;
	private double maxcultureScore = 5;//最大得分
	private double maxnormScore = 0.3;//最大得分
	private  List<Set<String>> list = new ArrayList<Set<String>>();// 存放词表
	public List<Set<String>> getList() {
		return list;
	}

	public void setList(List<Set<String>> list) {
		this.list = list;
	}

	private StringBuffer  sb= null;
	private Set<String> idiom=new HashSet<String>();
	Set<String> idiom_words = null;// 成语
	private String content = null;
	public Set<String> getIdiom() {
		return idiom;
	}

	public void setIdiom(Set<String> idiom) {
		this.idiom = idiom;
	}

	public StringBuffer getSb() {
		return sb;
	}

	public void setSb(StringBuffer sb) {
		this.sb = sb;
	}

	public String getCulture_score() {
		return culture_score;
	}

	public void setCulture_score(String culture_score) {
		this.culture_score = culture_score;
	}

	public int getNorm_score() {
		return norm_score;
	}

	public void setNorm_score(int norm_score) {
		this.norm_score = norm_score;
	}
	
	public double getMaxcultureScore() {
		return maxcultureScore;
	}
	public void setMaxcultureScore(double maxcultureScore) {
		this.maxcultureScore = maxcultureScore;
	}
	public double getMaxnormScore() {
		return maxnormScore;
	}
	public void setMaxnormScore(double maxnormScore) {
		this.maxnormScore = maxnormScore;
	}
	public static double getW1() {
		return w1;
	}

	public static void setW1(double w1) {
		Calc.w1 = w1;
	}

	public static double getW2() {
		return w2;
	}

	public static void setW2(double w2) {
		Calc.w2 = w2;
	}

	public static double getW3() {
		return w3;
	}

	public static void setW3(double w3) {
		Calc.w3 = w3;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filename = "test.txt";
		Scanner s = null;
		String content = null;
		try {
			s = new Scanner(new File(filename), "utf-8");
			if (!s.hasNext()) {
				s = new Scanner(new File(filename), "Unicode");
			}
			if (!s.hasNext()) {
				s = new Scanner(new File(filename), "gbk");
			}
			while (s.hasNext()) {
				content = s.nextLine().trim();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calc test=new Calc(content);
		System.out.println(test.culture_score);
		System.out.println(test.norm_score);
	}

	public Calc(){
		initWordSet();
		//parserNew(content);
	}
	Calc(String content){
		initWordSet();
		parserNew(content);
	}
	 public  static void addWordToIdiom(String word){
		try {
			FileWriter fw= new FileWriter(new File("ccnu_dict/idiom_dict.txt"),true);
			fw.write(word+"\n");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void initWordSet() {
		
		idiom_words = ReadWords("ccnu_dict/idiom_dict.txt");// 成语
		Set<String> common_words_1 = ReadWords("./ccnu_dict/common_words_1");// 常用词一类
		Set<String> common_words_2 = ReadWords("./ccnu_dict/common_words_2");// 常用词二类
		Set<String> common_word_1 = ReadWords("./ccnu_dict/common_word_1");// 常用字一类
		Set<String> common_word_2 = ReadWords("./ccnu_dict/common_word_2");// 常用字二类
	
		list.add(idiom_words);
		list.add(common_words_1);
		list.add(common_words_2);
		list.add(common_word_1);
		list.add(common_word_2);
		try {
			Scanner sc = new Scanner(new File("./ccnu_dict/weights"),"utf-8");
			HashMap<String,Double> w = new HashMap<String,Double>();
			while(sc.hasNext()){
				String[] arr=sc.nextLine().split("=");
				w.put(arr[0], Double.parseDouble(arr[1]));
			}
			setW1(w.get("w_1"));
			setWs_1(w.get("ws_1"));
			setW2(w.get("w_2"));
			setWs_2(w.get("ws_2"));
			setW3(w.get("w_idom"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * 读取词典中的词
	 */
	public Set<String> ReadWords(String filename) {
		Set<String> wordsset = new HashSet<String>();
		Scanner s = null;
		try {
			s = new Scanner(new File(filename), "gbk");
			if (!s.hasNext()) {
				s = new Scanner(new File(filename), "utf-8");
			}
			if (!s.hasNext()) {
				s = new Scanner(new File(filename), "unicode");
			}
			while (s.hasNext()) {
				wordsset.add(s.nextLine().trim());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wordsset;
	}

	public void parserNew(String content ) {
		sb=new StringBuffer();
		List<Set<String>> wordset=this.getList();
		Set<String> idiom=new HashSet<String>();
		if (content == null || content.equals("")) {
			this.setCulture_score("D");
		}
		List<Integer> count = new ArrayList<Integer>();
		ArrayList<HashSet<String>> kind = new ArrayList<HashSet<String>>();
		for (int i = 0; i < wordset.size(); i++) {
			count.add(0);
			kind.add(new HashSet<String>());
		}
		HashSet<String> wordsSet = new HashSet<String>();
		for (int i = 0; i < wordset.size(); i++) {
			if (i < wordset.size() ) {
				Set<String> words= wordset.get(i);
				for (String word : words) {
					if (!wordsSet.contains(word)) {
						Pattern pattern = Pattern.compile(word);
						Matcher m = pattern.matcher(content);
						while (m.find()) {
							kind.get(i).add(word);
							count.set(i, count.get(i) + 1);
							if(i==0){
								idiom.add(word);
							}
						}
					}
					wordsSet.add(word);
				}
			}
		}
		this.setIdiom(idiom);
		sb.append((kind.get(0).size()+"\t"+kind.get(1).size()+"\t"+kind.get(2).size()+"\t"+kind.get(3).size()+"\t"+kind.get(4).size()+"\t"));
		int score = (int) ((getW1() * count.get(1)
				* Math.log10(kind.get(1).size() + 1) / (1 + count.get(1))
				+ getWs_2() * count.get(2) * Math.log10(kind.get(2).size() + 1)
				/ (1 + count.get(2)) + getWs_1()* count.get(3)
				* Math.log10(kind.get(3).size() + 1) / (1 + count.get(3))
				+ getW2()* count.get(4) * Math.log10(kind.get(4).size() + 1)
				/ (1 + count.get(4)) + getW3() * count.get(0)
				* Math.log10(1 + kind.get(0).size()) / (1 + count.get(0))) * (90.0 / maxcultureScore));
		if(score<10){
			this.setCulture_score("D");
		}else if (score<20){
			this.setCulture_score("C");
		}else if (score<30){
			this.setCulture_score("B");
		}else{
			this.setCulture_score("A");
		}
	}

}
