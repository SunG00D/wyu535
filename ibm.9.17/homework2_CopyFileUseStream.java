package cn.ibm.com_4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileUseStream {
	/**
	 * 以文件流的方式复制文件
	 * 
	 * @param src  文件源目录
	 * @param dest 文件目的目录
	 * @throws IOException
	 */
	public static void copyFile(String src, String dest) throws IOException {
		FileInputStream in = new FileInputStream(src);
		File file = new File(dest);
		if (!file.exists())
			file.createNewFile();
		FileOutputStream out = new FileOutputStream(file);
		int c;
		byte buffer[] = new byte[1024];
		while ((c = in.read(buffer)) != -1) {
			for (int i = 0; i < c; i++)
				out.write(buffer[i]);
		}
		in.close();
		out.close();
	}

	public static void main(String[] args) throws IOException {
		String fileSrc = "C:\\Users\\Administrator\\Desktop\\myfile.txt";
		String fileDes = "C:\\Users\\Administrator\\Desktop\\myfile_cp.txt";
		copyFile(fileSrc, fileDes);
		System.out.println("文件夹文件复制成功");

	}
}
