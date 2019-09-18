package yuanhao.test.one;

import java.util.Calendar;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String dateString = "20180301";
		int year, month, day;

		while (dateString != "\0") {
			if (dateString.length() != 8 || !StringUtil.isNumer(dateString)) {
				new Exception("���ڸ�ʽ���Ϸ�").printStackTrace();
			} else {
				year = Integer.parseInt(StringUtil.substring(dateString, 0, 4));
				month = Integer.parseInt(StringUtil.substring(dateString, 4, 6));
				day = Integer.parseInt(StringUtil.substring(dateString, 6, 8));

				if (DateUtil.isYearPresenced(year) && DateUtil.isMonthPresenced(month)
						&& DateUtil.isDayPresenced(year, month, day)) {

					System.out.println(year + " " + month + " " + day);
					Calendar calendar = DateUtil.setCalendar(year, month, day);
					today(calendar);
					PreDay(calendar);
				} else {
					new Exception("���ڸ�ʽ���Ϸ�").printStackTrace();
				}

			}
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			dateString = scanner.next();

		}
	}

	/**
	 * ��ǰʱ��
	 */
	private static void today(Calendar calendar) {
		System.out.print("��ǰʱ��:\t");
		DateUtil.printCalendar(calendar);
	}

	/**
	 * ǰһ��
	 */
	private static void PreDay(Calendar calendar) {
		calendar = DateUtil.PreDate(calendar);
		System.out.print("ǰһ��:\t");
		DateUtil.printCalendar(calendar);
	}

}
