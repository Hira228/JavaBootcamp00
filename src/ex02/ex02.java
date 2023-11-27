import java.util.Scanner;

public class ex02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number;
        int count_coffe = 0;
        while ((number = in.nextInt()) != 42) {
            number = SumDigitsOfNumber(number);
            if(SimpleNumber(number)) count_coffe++;
        }
        System.out.println("Count of coffee-request - " + count_coffe);
    }

    public static int SumDigitsOfNumber(int number) {
        int result = 0;
        while (number != 0) {
            result += number % 10;
            number /= 10;
        }
        return result;
    }

    public static boolean SimpleNumber(final int number) {
        for(int i = 2; i <= Math.sqrt(number); ++i) {
            if(!CheckNumber(number, i)) return false;
        }
        return true;
    }
    public static boolean CheckNumber (final int number, final int iteration){
        return number % iteration != 0;
    }

}
