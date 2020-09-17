package cn.ibm.com_4;

import java.io.File;
import java.io.IOException;

public class ListFileName {
	private static void fileShow(File filename) {
		File[] listFiles = filename.listFiles();
		for(File filename2 : listFiles) {
			if(filename2.isDirectory()) {
				System.out.println(filename2.getParent() + "Ŀ¼�µ��ļ���" + filename2.getName());
				fileShow(filename2);
			}
			else if(filename2.isFile()) {
				System.out.println(filename2.getParentFile() + "\\" + filename2.getName());
			}
		}
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File file = new File("C:\\Users\\Administrator\\Desktop\\1");
		if(!file.exists()) {
			System.out.println("��ѯ�ļ�������");
			throw new IOException();
		}
		fileShow(file);
	}

}
