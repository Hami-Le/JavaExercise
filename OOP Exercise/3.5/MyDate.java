
public class MyDate {
	private int year;
    private int month;
    private int day;

    private static final String[] MONTHS = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private static final String[] DAYS = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private static final int[] DAY_IN_MONTHS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public MyDate(int year, int month, int day) {
        setDate(year, month, day);
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static boolean isValidDate(int year, int month, int day) {
        if (year < 1 || year > 9999 || month < 1 || month > 12) {
            return false;
        }
        int dayMax = DAY_IN_MONTHS[month - 1];
        if (month == 2 && isLeapYear(year)) {
            dayMax = 29;
        }
        return day >= 1 && day <= dayMax;
    }

    public void setDate(int year, int month, int day) {
        if (!isValidDate(year, month, day)) {
            throw new IllegalArgumentException("Invalid year, month, or day!");
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() { return year; }
    public int getMonth() { return month; }
    public int getDay() { return day; }

    public String toString() {
        return DAYS[getDayOfWeek(year, month, day)] + " " + day + " " + MONTHS[month - 1] + " " + year;
    }

    public static int getDayOfWeek(int year, int month, int day) {
        int[] centuryTable = {4, 2, 0, 6};
        int[] monthTable = {0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5};

        if (month == 1 || month == 2) {
            if (isLeapYear(year)) {
                monthTable[month - 1] -= 1; 
            }
            year--;
        }

        int century = (year / 100) % 4;
        int yearPart = year % 100;
        return (centuryTable[century] + yearPart + yearPart / 4 + monthTable[month - 1] + day) % 7;
    }

    public MyDate nextDay() {
        int dayMax = DAY_IN_MONTHS[month - 1];
        if (month == 2 && isLeapYear(year)) {
            dayMax = 29;
        }
        if (day < dayMax) {
            day++;
        } else {
            day = 1;
            if (month < 12) {
                month++;
            } else {
                month = 1;
                if (year < 9999) {
                    year++;
                } else {
                    throw new IllegalStateException("Year out of range!");
                }
            }
        }
        return this;
    }

    public MyDate nextMonth() {
        if (month == 12) {
            if (year == 9999) throw new IllegalStateException("Year out of range!");
            year++;
            month = 1;
        } else {
            month++;
        }
        int dayMax = DAY_IN_MONTHS[month - 1];
        if (month == 2 && isLeapYear(year)) {
            dayMax = 29;
        }
        day = Math.min(day, dayMax);
        return this;
    }

    public MyDate nextYear() {
        if (year == 9999) throw new IllegalStateException("Year out of range!");
        year++;
        if (month == 2 && day == 29 && !isLeapYear(year)) {
            day = 28;
        }
        return this;
    }

    public MyDate previousDay() {
        if (day > 1) {
            day--;
        } else {
            if (month > 1) {
                month--;
            } else {
                if (year == 1) throw new IllegalStateException("Year out of range!");
                year--;
                month = 12;
            }
            day = DAY_IN_MONTHS[month - 1];
            if (month == 2 && isLeapYear(year)) {
                day = 29;
            }
        }
        return this;
    }

    public MyDate previousMonth() {
        if (month == 1) {
            if (year == 1) throw new IllegalStateException("Year out of range!");
            year--;
            month = 12;
        } else {
            month--;
        }
        int dayMax = DAY_IN_MONTHS[month - 1];
        if (month == 2 && isLeapYear(year)) {
            dayMax = 29;
        }
        day = Math.min(day, dayMax);
        return this;
    }

    public MyDate previousYear() {
        if (year == 1) throw new IllegalStateException("Year out of range!");
        year--;
        if (month == 2 && day == 29 && !isLeapYear(year)) {
            day = 28;
        }
        return this;
    }
}
