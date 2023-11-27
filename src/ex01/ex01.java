import java.util.Scanner;

public class ex01 {
    public static void main(String[] args) {
        System.out.print("-> ");
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        if(number <= 1) {
            System.err.println("IllegalArgument");
            return;
        }
        int i = 2;
        for(; i <= Math.sqrt(number); i++) {
            if(!SimpleNumber(number, i)) {
                System.err.print("false " +  (i - 1));
                return;
            }
        }
        System.out.print("true " + (i - 1));
    }

    public static boolean SimpleNumber(final int number, final int iteration)  {
        return number % iteration != 0;
    }
}
