package cn.ibm.com_5.test;

public class Card {
	public static void main(String[] args) {
		Enter enter = new Enter();
		new Thread(enter, "����").start();
		new Thread(enter, "ǰ��").start();
	}
}