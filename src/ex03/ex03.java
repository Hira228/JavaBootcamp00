import java.util.Scanner;

public class ex03 {
    public static void main(String[] args) {
        Scanner in_ = new Scanner(System.in);
        long progress_ = 0;
        int count_weeks_ = 0;

        while (in_.hasNext()){
            int min_ = in_.nextInt();
            if(min_ == 42) break;
            for(int i = 0; i < 4; ++i) min_ = Math.min(min_, in_.nextInt());
            progress_ = progress_ * 10 + min_;
            ++count_weeks_;
        }
        for(long i = (int) Math.pow(10, count_weeks_ - 1), c = 1; i != 0; i /= 10, ++c) {
            System.out.println("Week" + c + "=".repeat((int) (progress_ / i % 10)) + ">");
        }
    }
}
