package cn.ibm.com_5.test;
/**
 * ĳ�������������,���볡ʱÿλԱ�����ܻ�ȡһ�ſ�Ƭ,����༶��50��ѧ��,���ö��߳�ģ�������ҵĹ��̣����ֱ�ͳ��ÿ������볡������,�Լ�ÿ��ѧ���õ��Ŀ�Ƭ���롣�߳����к��ӡ��ʽ���£�
 ���Ϊ: 2 ��ѧ�� �Ӻ��� �볡! �õ��Ŀ�Ƭ������: [17, 24, 29, 30, 31, 32, 07]
 ���Ϊ: 1 ��ѧ�� �Ӻ��� �볡! �õ��Ŀ�Ƭ������: [06, 11, 14, 22, 29, 32, 15]
 �Ӻ����볡��ѧ���ܹ�: 13 λѧ��
 ��ǰ���볡��ѧ���ܹ�: 87 λѧ��
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Enter implements Runnable {
	private int studentNum = 50;// ѧ��������Ҳ�Ǳ��
	private int frontNum = 0;// ǰ������
	private int backNum = 0;// ��������
	List<Integer> studentNumList = new ArrayList<>();// �洢Ա�����
	List<String> cardList = new ArrayList<>();// �洢��Ƭ
	HashMap<Integer, String> map = new HashMap<>();

	public void run() {
		while (studentNum > 0) {
			synchronized (this) {
				count();
			}
		}
	}
	/**
	 * ����ѧ�������ʹ�ӡѧ���Ϳ�Ƭ���룬��ͳ����������ڵ�����
	 */

	public void count() {
		String card = card();
		try {
			Thread.sleep(50);
		} catch (Exception e) {
			System.out.println(e);
		}
		cardList.add(card);
		studentNumList.add(studentNum);

		if (studentNum == 0) {
			System.out.println("�Ӻ����볡��Ա���ܹ���" + backNum);
			System.out.println("��ǰ���볡��Ա���ܹ���" + frontNum);
			return;
		}
		String name = Thread.currentThread().getName();// ��ȡ�߳���
		if (name.equals("ǰ��")) {
			System.out.println("���Ϊ: " + studentNum + " ��ѧ�� ��" + name + " �볡���õ��Ŀ�Ƭ�����ǣ�[" + card + "]");
			map.put(studentNum, card);
			frontNum++;
		} else if (name.equals("����")) {
			System.out.println("���Ϊ: " + studentNum + " ��ѧ�� ��" + name + " �볡���õ��Ŀ�Ƭ�����ǣ�[" + card + "]");
			map.put(studentNum, card);
			backNum++;
		}
		studentNum--;
	}

	public String card() {
		String[] card = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15",
				"16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32",
				"33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49",
				"50" };
		int cnt = 0;// ѭ������
		String Card = "";
		while (cnt < 6) {
			// ѭ�������ȡ6���ɫ��
			Card += card[new Random().nextInt(card.length)] + ",";
			cnt++;
		}
		Card += card[new Random().nextInt(card.length)];
		return Card;
	}
}