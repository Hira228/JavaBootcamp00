import java.util.Scanner;

public class ex04 {
    public static void main(String[] args) {
        Scanner in_ = new Scanner(System.in);
        String str_ = in_.nextLine();
        String data_ = "";
        String counts_ = "";

        for (int i = 0; i < str_.length() - 2; ++i) {
            boolean found_ = false;

            for (int j = 0; j < data_.length(); ++j) {
                if (str_.toCharArray()[i] == data_.toCharArray()[j]) {
                    counts_ = updateCounts(counts_, j);
                    found_ = true;
                    break;
                }
            }

            if (!found_) {
                data_ += str_.toCharArray()[i];
                counts_ += '\u0001';
            }
        }

        int maxFrequency = getMaxFrequency(counts_);

        String temp_counts_ = counts_;
        String temp_data_ = data_;

        for (int i = 11; i > 0; --i) {
            for (int j = 0; j < temp_data_.length() && j < 10; ++j) {
                int index_max = findMaxFrequencyIndex(counts_.toCharArray());
                char symbol = data_.toCharArray()[index_max];
                int frequency = getMaxFrequency(counts_);
                double percentage = ((double) frequency / maxFrequency) * 100;
                char hash = (i <= Math.floor((float) (percentage / 100) * 10)) ? '#' : ' ';
                if(i - Math.floor((float) (percentage / 100) * 10) == 1) {
                    System.out.print(((int) counts_.toCharArray()[index_max] > 10 ? " " : "  ") + (int) counts_.toCharArray()[index_max] + ((int) counts_.toCharArray()[index_max] > 10 ? " " : "  "));
                }
                else System.out.print("  " + hash + "  ");
                counts_ = deleteMaxElement(counts_, index_max);
                data_ = deleteMaxElement(data_, index_max);
            }
            counts_ = temp_counts_;
            data_ = temp_data_;
            System.out.println();
        }

        for (int k = 0; k < data_.length() && k < 10; ++k) {
            int index_max = findMaxFrequencyIndex(counts_.toCharArray());
            char symbol = data_.toCharArray()[index_max];
            System.out.print("  " + symbol + "  ");
            counts_ = deleteMaxElement(counts_, index_max);
        }
    }
    public static int findMaxFrequencyIndex(char[] counts) {
        int maxIndex = 0;
        for (int i = 1; i < counts.length; i++) {
            if (counts[i] > counts[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static int getMaxFrequency(String counts) {
        int max = 0;
        for (char c : counts.toCharArray()) {
            int frequency = (int) c;
            if (frequency > max) {
                max = frequency;
            }
        }
        return max;
    }
    public static String updateCounts(String counts, int index) {
        char[] countsChars = counts.toCharArray();
        countsChars[index] = (char) (countsChars[index] + 1);
        return new String(countsChars);
    }

    public static String deleteMaxElement(String counts, int index) {
        char[] countsChars = counts.toCharArray();
        countsChars[index] = '\u0000';
        return new String(countsChars);
    }

}