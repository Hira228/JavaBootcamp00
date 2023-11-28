import java.util.Scanner;

public class ex03 {
    public static void main(String[] args) {
        Scanner in_ = new Scanner(System.in);
        long progress_ = 0;
        int count_weeks_ = 0;
        String tests_;

        while (!(tests_ = in_.nextLine()).contains("42")) {
            tests_ = tests_.replaceAll(" ", "");
            int min_ = 9;
            for(int i = 0; i < tests_.length(); ++i) {
                if(min_ > Character.getNumericValue(tests_.charAt(i))) min_ = Character.getNumericValue(tests_.charAt(i));
            }
            progress_ = progress_ * 10 + min_;
            ++count_weeks_;
        }
        for(long i = (int) Math.pow(10, count_weeks_ - 1), c = 1; i != 0; i /= 10, ++c) {
            System.out.println("Week" + c + "=".repeat((int) (progress_ / i % 10)) + ">");
        }
    }
}