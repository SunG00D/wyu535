package cn.ibm.com_4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFileUseBuffer {
	/**
	 * 以缓冲流的方式复制文件
	 * 
	 * @param src  文件源目录
	 * @param dest 文件目的目录
	 * @throws IOException
	 */
	public static void copyFile(String src, String dest) throws IOException {
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
		File file = new File(dest);
		if (!file.exists())
			file.createNewFile();
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

	public static void main(String[] args) throws IOException {
		String fileSrc = "C:\\Users\\Administrator\\Desktop\\myfile.txt";
		String fileDes = "C:\\Users\\Administrator\\Desktop\\myfile_cp2.txt";
		copyFile(fileSrc, fileDes);
		System.out.println("文件夹文件复制成功");

	}
}
