package priv.qcy.test.one;

import java.util.Scanner;

public class Date {

	public int year = 0;
	public int month = 0;
	public int day = 0;
	public boolean flag = false;// �����ж�ֵ
	public boolean legal = false;// �Ϸ���ֵ

	/*
	 * �ж��Ƿ�Ϊ����
	 * 
	 * ���� yearΪ��
	 * 
	 * ����ֵ��������Ϊ��
	 */
	public boolean isLeapYear(int year) {
		flag = false;
		if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
			flag = true;
		}
		return flag;
	}

	/*
	 * �����꣬�µõ�����µ�����
	 * 
	 * ����ֵΪint���ͣ�����
	 */
	public int getDayByMonth(int year, int month) {

		int day = 0;
		int[] dayInMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (month == 2) {
			if (isLeapYear(year)) {
				day = 29;
			} else {
				day = 28;
			}
		} else {
			day = dayInMonth[month];
		}
		return day;
	}
	/*
	 * �õ�ǰһ��
	 */

	public String getLastday(String date) {

		String dateString = null;
		String str1 = date.substring(0, 4);
		String str2 = date.substring(4, 6);
		String str3 = date.substring(6, 8);
		year = Integer.parseInt(str1);
		month = Integer.parseInt(str2);
		day = Integer.parseInt(str3);
		day = day - 1;
		if (day == 0) {
			month = month - 1;
			if (month == 0) {
				year = year - 1;
			}
		}
		if (month == 0) {
			month = 12;
		}
		if (day == 0) {
			day = getDayByMonth(year, month);
		}
		dateString = year + "��" + month + "��" + day + "��";
		return dateString;

	}

	/*
	 * �ж�����Ϸ���
	 * 
	 */
	public boolean isLegal(String str) {
		legal = false;
		if (str.length() >= 8) {
			legal = true;
			int year = 0;
			int month = 0;
			int day = 0;
			for (int i = 0; i < str.length(); i++) {
				// �ó����ж�ÿ���ַ��ǲ�������
				int c = str.charAt(i);
				if (c < 48 || c > 57) {
					System.out.println("��������������������ַ������������룡��");
					return false;
				}

			}
			year = Integer.parseInt(str.substring(0, 4));
			month = Integer.parseInt(str.substring(4, 6));
			day = Integer.parseInt(str.substring(6, 8));

			if (year < 1000 || year > 2019) {
				legal = false;

				System.out.println("���벻�Ϸ������Խ�磡��");
			}
			if (month < 1 || month > 12) {
				legal = false;
				System.out.println("���벻�Ϸ�����Խ�磡��");

			}
			if (day < 1 || day > 31) {
				legal = false;
				System.out.println("���벻�Ϸ�����Խ�磡��");

			}
			if (month == 2) {

				if (day == 29 && !isLeapYear(year)) {

					legal = false;
					System.out.println("ƽ��2��û��29��");

				}
				if (day == 30 || day == 31) {

					legal = false;
					System.out.println("2��û��������ڣ�");

				}

			}

		} else {
			System.out.println("����������������");

		}
		return legal;

	}

	public static void main(String[] args) {

		Date date = new Date();
		Scanner scanner = new Scanner(System.in);
		String datestr;
		while (true) {
			System.out.println("�����룺");
			datestr = scanner.nextLine();
			if (date.isLegal(datestr)) {
				System.out.println("ǰһ��" + date.getLastday(datestr));
			}
		}

	}

}
