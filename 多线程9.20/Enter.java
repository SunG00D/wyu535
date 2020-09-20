package cn.ibm.com_5.test;
/**
 * 某教室有两个入口,在入场时每位员工都能获取一张卡片,假设班级有50个学生,利用多线程模拟进入教室的过程，并分别统计每个入口入场的人数,以及每个学生拿到的卡片号码。线程运行后打印格式如下：
 编号为: 2 的学生 从后门 入场! 拿到的卡片号码是: [17, 24, 29, 30, 31, 32, 07]
 编号为: 1 的学生 从后门 入场! 拿到的卡片号码是: [06, 11, 14, 22, 29, 32, 15]
 从后门入场的学生总共: 13 位学生
 从前门入场的学生总共: 87 位学生
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Enter implements Runnable {
	private int studentNum = 50;// 学生人数，也是编号
	private int frontNum = 0;// 前门人数
	private int backNum = 0;// 后门人数
	List<Integer> studentNumList = new ArrayList<>();// 存储员工编号
	List<String> cardList = new ArrayList<>();// 存储卡片
	HashMap<Integer, String> map = new HashMap<>();

	public void run() {
		while (studentNum > 0) {
			synchronized (this) {
				count();
			}
		}
	}
	/**
	 * 计算学生人数和打印学生和卡片号码，并统计最后各个入口的人数
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
			System.out.println("从后门入场的员工总共：" + backNum);
			System.out.println("从前门入场的员工总共：" + frontNum);
			return;
		}
		String name = Thread.currentThread().getName();// 获取线程名
		if (name.equals("前门")) {
			System.out.println("编号为: " + studentNum + " 的学生 从" + name + " 入场！拿到的卡片号码是：[" + card + "]");
			map.put(studentNum, card);
			frontNum++;
		} else if (name.equals("后门")) {
			System.out.println("编号为: " + studentNum + " 的学生 从" + name + " 入场！拿到的卡片号码是：[" + card + "]");
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
		int cnt = 0;// 循环次数
		String Card = "";
		while (cnt < 6) {
			// 循环随机卡片的号码
			Card += card[new Random().nextInt(card.length)] + ",";
			cnt++;
		}
		Card += card[new Random().nextInt(card.length)];
		return Card;
	}
}
