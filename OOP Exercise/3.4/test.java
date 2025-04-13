
public class test {
	public static void main(String[] args) {
        MyTime time = new MyTime(23, 59, 59);
        System.out.println("Initial time: " + time);

        time.nextSecond();
        System.out.println("After nextSecond: " + time);

        time.previousSecond();
        System.out.println("After previousSecond: " + time);

        time.nextMinute();
        System.out.println("After nextMinute: " + time);

        time.previousMinute();
        System.out.println("After previousMinute: " + time);

        time.nextHour();
        System.out.println("After nextHour: " + time);

        time.previousHour();
        System.out.println("After previousHour: " + time);
    }
}
