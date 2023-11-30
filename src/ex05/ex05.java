import java.util.Scanner;

public class ex05 {
    public static void main(String[] args) {
        Scanner in_ = new Scanner(System.in);

        String[] days =  {
                "TU", "WE", "TH", "FR", "SA", "SU", "MO"
        };
        int[] dates_ = {1, 2, 3, 4, 5, 6, 7};

        int[] times_ = new int[10];
        String[] days_written_ = new String[10];
        String[] names_ = new String[10];
        String[] journal = new String[20];

        int count_jornal = 0;
        int count_times_days = 0;
        int count_names_ = 0;

        try {
            while (!in_.hasNext("[.]")) names_[count_names_++] = in_.nextLine();
            in_.nextLine();
            while (!in_.hasNext("[.]")) {
                times_[count_times_days] = in_.nextInt();
                days_written_[count_times_days++] = in_.nextLine();
            }
            in_.nextLine();
            while(!in_.hasNext("[.]")) journal[count_jornal++] = in_.nextLine();

        } finally { in_.close(); }

        for(int i = 0; i < count_times_days; ++i) {
            days_written_[i] = days_written_[i].replaceAll(" ", "");
        }

        int[] times_temp = new int[times_.length];
        for (int i = 0; i < times_.length; i++) {
            times_temp[i] = times_[i];
        }

        int index_printble = 0;
        for (int i = 0; i < count_names_ + 1; ++i) {
            boolean print_names = false;
            for (int j = 0; j < 30; ++j) {
                int dayOfWeekIndex = j % 7;
                for (int k = 0; k < CountClassesShall(days_written_, days[dayOfWeekIndex], count_times_days); ++k) {
                    int dayIndex = GetIndexString(days_written_, days[dayOfWeekIndex], count_times_days);
                    if (dayIndex != -1) {
                        if (i == 0) {
                            int timeIndex = GetMinIndexInt(days_written_, days[dayOfWeekIndex], times_, count_times_days);
                            System.out.print("  " + times_[timeIndex] +
                                    ":00 " + days_written_[dayIndex] +
                                    "  " + (j + 1) + "|");
                            if (j <= 10) index_printble = j;
                            times_[timeIndex] = Integer.MAX_VALUE;;
                        } else {
                            System.out.print((!print_names ? names_[i - 1] : "") +
                                    " ".repeat(12 - (!print_names ? names_[i - 1].length() : 0) +
                                            (j >= index_printble ? 1 : 0)) + "|");
                            print_names = true;
                        }
                    }
                }
                for (int l = 0; l < times_.length; l++) {
                    times_[l] = times_temp[l];
                }
            }
            System.out.println();
        }
    }

    private static int CountClassesShall(String[] where_find_, String find_str, int count) {
        int count_classes_shall_ = 0;
        for (int i = 0; i < count; ++i) if(where_find_[i].equals(find_str)) count_classes_shall_++;
        return count_classes_shall_;
    }

    private static int GetMinIndexInt(String[] where_find_str, String find_str, int[] where_find, int count) {
        int minIndex = -1;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < count; ++i) {
            if (where_find_str[i].equals(find_str) && where_find[i] < minValue) {
                minValue = where_find[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    private static int GetIndexString(String[] where_find_, String find_str, int count) {
        for (int i = 0; i < count; ++i) if(where_find_[i].equals(find_str)) return  i;
        return -1;
    }
}

