package practiceJava.calendar;

import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class useCalendarAPI {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Calendar cal = Calendar.getInstance();
		int setYear, setMonth, offset, getMaxDays;
		boolean isValid = true;
		boolean isContinue = true;


			do {
				System.out.println("Enter a Year: ");
				String inputYear = input.nextLine();
				if (inputYear.isEmpty()) {
					System.out.println("Required Input, Please Enter a year !");
					isValid = false;
				} else if (inputYear.length() > 4 || inputYear.length() < 4) {
					System.out.println("Invalid Input , Please Enter a 4 Digit year!");
					isValid = false;
				} else {
					isValid = true;
					System.out.println("Enter a month: ");
					String inputMonth = input.nextLine();
					setYear = Integer.parseInt(inputYear);
					setMonth = Integer.parseInt(inputMonth);
					cal.set(setYear, setMonth - 1, 1);
					String getMonthName = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);
					System.out.printf("%5s", getMonthName + " ");
					System.out.println(inputYear);
					offset = cal.get(Calendar.DAY_OF_WEEK);
					getMaxDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
					displayDayOfWeekName();
					displayDaysInAMonth(setMonth, offset, getMaxDays);
				}
			} while (!isValid);

		input.close();
	}

	public static void displayDayOfWeekName() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, 1);
		do {
			System.out.printf("%4s", cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.ENGLISH));
			cal.add(Calendar.DAY_OF_WEEK, 1);
		} while (cal.get(Calendar.DAY_OF_WEEK) != cal.getActualMinimum(Calendar.DAY_OF_WEEK));
		System.out.println("");
	}

	public static void displayDaysInAMonth(int trgtMonth, int offset, int maxDays) {
		int date = 1;
		for (int start = 0; start < 6; start++) {// rows from top to bottom
			for (int x = 1; x <= 7; x++) {// column from left to right
				if (x < offset && start == 0) {
					System.out.printf("%4s", "");
				} else if (date <= maxDays) {
					System.out.printf("%4s", date++);
				}
			}
			System.out.println();
		}

	}

}
