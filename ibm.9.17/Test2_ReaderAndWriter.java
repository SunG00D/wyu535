package cn.ibm.com_4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class ReaderAndWriter {
	public static void readerandwriter(String src) throws IOException {
		File f = new File(src);
		if (!f.exists() || f.isDirectory())
			throw new FileNotFoundException();
		BufferedReader br = new BufferedReader(new FileReader(f));
		String temp = null;
		StringBuffer sb = new StringBuffer();
		temp = br.readLine();
		while (temp != null) {
			sb.append(temp + " ");
			temp = br.readLine();
		}
		System.out.println("文件内容：" + sb);
		String addstr = "have traveled thus far";
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f, true)));
		bw.write(addstr.toString());
		br.close();
		bw.close();
	}

	public static void main(String[] args) throws IOException {
		String fileSrc = "C:\\Users\\Administrator\\Desktop\\myfile.txt";
		readerandwriter(fileSrc);
		System.out.println("文件夹文件读写成功");

	}
}
