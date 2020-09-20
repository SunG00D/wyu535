package cn.ibm.com_5.test;

public class Card {
	public static void main(String[] args) {
		Enter enter = new Enter();
		new Thread(enter, "后门").start();
		new Thread(enter, "前门").start();
	}
}