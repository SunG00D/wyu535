package cn.ibm.com_4;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class AddNewcomer {
	private static String name;
	private static int age;
	private static String gender;

	public static void WriterAddNewcomer() throws IOException {
		File f = new File("C:\\Users\\Administrator\\Desktop\\emp.txt");
		OutputStream out = new FileOutputStream(f, true);// 如果文件不存在会自动创建
		String str = "\n" + name + "," + age + "," + gender + "," + "2008-12-22";
		byte[] b = str.getBytes();
		out.write(b);// 因为是字节流，所以要转化成字节数组进行输出
		out.close();
	}

	public static boolean check(String str) {
		char[] chars = str.toCharArray();
		boolean isPhontic = false;
		for (int i = 0; i < chars.length; i++) {
			isPhontic = (chars[i] >= 'a' && chars[i] <= 'z') || (chars[i] >= 'A' && chars[i] <= 'Z');
			if (!isPhontic) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		do {
			System.out.println("输入你的名字(长度1-20并且只能是英文):");
			Scanner scanner = new Scanner(System.in);
			name = scanner.nextLine();
		} while (name.length() < 1 || name.length() > 20 || check(name));
		do {
			System.out.println("输入你的年龄(0-100):");
			Scanner scanner = new Scanner(System.in);
			age = scanner.nextInt();
		} while (age > 100 && age < 0);
		do {
			System.out.println("输入你的性别(男/女):");
			Scanner scanner = new Scanner(System.in);
			gender = scanner.nextLine();
			scanner.close();
		} while (gender == "男" || gender == "女");
		WriterAddNewcomer();
	}
}
