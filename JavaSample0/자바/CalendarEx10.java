import java.util.*;

class CalendarEx10 {
	public static void main(String[] args) {
		System.out.println("2004. 5. 31 :" + getDayOfWeek(2004, 5, 31)); // �� ����
																			// ��
																			// ����
																			// ���
																			// °
																			// ������
																			// ��Ÿ����
																			// �޼ҵ�
		System.out.println("2002. 6. 1 :" + getDayOfWeek(2002, 6, 1)); // �� ���� ��
																		// ���� ���
																		// ° ������
																		// ��Ÿ����
																		// �޼ҵ�
		System.out.println("2004. 5. 1 - 2004.4.28 :" + dayDiff(2004, 5, 1, 2004, 4, 28)); // 4/28��
																							// 5/1��
																							// ���̸�
																							// ���ϴ�
																							// �޼ҵ�
		System.out.println("2005. 6. 29 : " + convertDateToDay(2005, 6, 29)); // �������
																				// �Է¹޾Ƽ�
																				// �ϴ�����
																				// ��ȯ�ϴ�
																				// �Լ�(ó���ý��۽ð����κ�����
																				// ��
																				// ��)
		System.out.println("732126 : " + convertDayToDate(732126)); // �� ����
																	// �Է¹޾Ƽ�
																	// ����Ϸ� ��ȯ�ϴ�
																	// �Լ�
	}

	// �� ���� ������ ���� �迭�� �־���� ->index�� 1���� 0�� �ش�~ 12���� 11
	public static int[] endOfMonth = { 31/* 1�� */, 28/* 2�� */, 31/* 3�� */, 30/* 4�� */, 31/* 5�� */, 30/* 6�� */,
			31/* 7�� */, 31/* 8�� */, 30/* 9�� */, 31/* 10�� */, 30/* 11�� */, 31/* 12�� */ };

	// �������� ������� ���ϴ� �� (*���� 2/29�� �ִ� ��)
	public static boolean isLeapYear(int year) {// ����Ǽ��� 2���� ���̴ϱ� boolean Ÿ��
		/*
		 * ������� �� ���� ��� ������ 4�� ������ �������� �ش� �켱 �������� �ϰ�, �� �� �߿��� 100���� ������ ��������
		 * �ش� ������� �ϸ�, �� �ٸ� 400���� ������ �������� �ش� �ٽ� �������� ���Ͽ���.
		 */
		return ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));
	}

	// ��¥ ���̸� ����Ѵ� �޼ҵ�
	public static int dayDiff(int y1, int m1, int d1, int y2, int m2, int d2) {
		return convertDateToDay(y1, m1, d1) - convertDateToDay(y2, m2, d2);

	}

	// ��,��,���� �޾� �� ���� ��� ° ������ ����ϴ� �޼ҵ�
	public static int getDayOfWeek(int year, int month, int day) {

		return convertDateToDay(year, month, day) % 7 + 1;
	}

	// �� �ϼ��� �Է¹޾� �� �⵵ �� �� ��ĥ ���� ���س��� �޼ҵ� (�����ǽý��۽ð��� �������� �ϼ��� ���)
	public static String convertDayToDate(int day) {
		int year = 1;
		int month = 0;

		int numOfLeapYear = 0;
		while (true) {// �� ������ ���ϱ� ���� �ݺ���
			int aYear = isLeapYear(year) ? 366 : 365; // booleanŸ���̾����ϱ� �����̸� ��,
														// ����̸� ������ ���� ����.
			// 1���� �� ��, ��366 or 365�� ��Ÿ���� �Է¹޴� �� �� �߿��� 1�⿡ �ش��ϴ� �� �� �� ���� �⿡
			// 1�����Ѵ�.
			if (day > aYear) {
				day -= aYear;
				year++;// 1�� ������ year�� ���� ���� isLeapYear �޼ҵ忡�� �ݺ��ؼ� �������� �������
						// ������.
			} else {// �����ִ� day�� ���� 366 or 365���� ������ ���� ���� ����ϱ� ���� while����
					// break; ���ش�.
				break;
			}
		}

		while (true) {// �� ������ ���ϱ� ���� �ݺ���
			int endDay = endOfMonth[month];// endOfMonth[0]���� endDay�� �ʱ�ȭ ��Ų��.
											// ->0���� �ƴ϶� 1������ ����!

			// (month==1 ->2��) 2���̸鼭 �����̸�, �� �� ���� 28���� 29�� �������Ѿ���.
			if (isLeapYear(year) && month == 1)
				endDay++;// 2���� �� �� �� �� default�� 28�̾��µ� 1�������Ѽ� 29�� �� ��.

			// (���� ������ if��) �� �������� ���� ���� ���������� �ʱ�ȭ�� month�� ������ ������ day���� �� ũ�ٸ�
			// ���� 1���� ��Ŵ
			if (day > endDay) {
				day -= endDay;
				month++;
			} else {// day<=endDay ��� while���� ���� -> ���� day�� ���� ���� ��ĥ������ �� �� ����.
				break;
			}
		}
		// convertDayToDate()�޼ҵ�� ���-���-��ĥ�� ���ϰ����� ������
		return year + "-" + (month + 1) + "-" + day;
	}

	// convertDayToDate()�޼ҵ�� �ݴ�� ��� ��� ��ĥ�� �Է¹����� �ý��۽ð����κ����� �� ���� ��Ÿ���� �޼ҵ�
	public static int convertDateToDay(int year, int month, int day) {
		int numOfLeapYear = 0;// ������ 0������ �ʱ�ȭ�س��� ����

		for (int i = 1; i < year; i++) {// i<=year������ �ƴ� ������?? �������� �� �� ������ ���ϴ�
										// ���̱� ������ ���� �ش��ϴ� �ش� �������� ����ϸ� �ȵ�. �Ʒ�����
										// �����̾��� Ƚ����ŭ �����ְԵǴµ� ���⼭ ������ �߻���
			if (isLeapYear(i))// i�⵵�� �����̸� 1������Ű�� ��.
				numOfLeapYear++;
		}

		// (year-1)�� ������ ? 2014.7.31�̸� 2013*365�� ���ϰ� �� ���� �� ���� ����ؼ� ���ؾ� �� �� ���� ��
		// �� ����.
		int toLastYearDaySum = (year - 1) * 365 + numOfLeapYear;// �����̾��� Ƚ����ŭ
																// �����ָ� 366���̾���
																// �ص� ��Ȯ�� �� �� ��
																// ������ �� �ִ�.

		int thisYearDaySum = 0;// �� ���� �ϼ��� 0���� �ʱ�ȭ�س��� ����

		for (int i = 0; i < month - 1; i++) {// month�� �ε����� 0~11�����ε� ��
												// month-1���� ������������ �ݺ��ϴ�
												// ������..?������
												// month�� �� month�� �ƴ�! �츮�� �Է���
												// month��. �� ���� ������ ���� �־���� �迭��
												// �̿��Ϸ��� month-1�� �Ǿ�� �ϴ� ���ε�
												// ���⿡�ٰ� �߰��� �ش��ϴ� ���� �� ���� ������
												// �������� ���������ϱ⶧���� �ᱹ i����
												// month-2������ �����ϴ� ��.

			thisYearDaySum += endOfMonth[i];
		}

		// �ش��ϴ� ��¥�� ���⿡ �ش��ϸ鼭 2���� ���� �����̶�� +1�� ����� �ϴ� ��. (������ �����ش��ϴ� �� �������� ����
		// ����� ���־��� ���� ->���� �ش��ϴ� �⵵�� �����̴��� 1,2���̶�� 1�� ������ �ʿ䰡 ���⶧��
		if (month > 2 && isLeapYear(year)) {
			thisYearDaySum++;
		}

		thisYearDaySum += day;

		//convertDateToDay()�޼ҵ�� �����ر����� �� ���� �̹� �ذ� ���۵ǰ� ���� �� ���� ���� ��, �� �� �ϼ��� �����Ѵ�.
		return toLastYearDaySum + thisYearDaySum;
	}
}