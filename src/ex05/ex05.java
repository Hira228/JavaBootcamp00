import java.util.Scanner;

public class ex05 {
    public static void main(String[] args) {
        Scanner in_ = new Scanner(System.in);

        String[] attendance = {
                " HERE", " NOT_HERE"
        };

        String[] days =  {
                " TU", " WE", " TH", " FR", " SA", " SU", " MO"
        };
        int[] dates_ = {1, 2, 3, 4, 5, 6, 7};

        int[] times_ = new int[10];
        String[] days_written_ = new String[10];
        String[] names_ = new String[10];
        int[][] journal = new int[20][4];

        int count_journal = 0;
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
            while(!in_.hasNext("[.]")) {
                journal[count_journal][0] = GetIndexString(names_, in_.next(), count_names_);
                journal[count_journal][1] = in_.nextInt();
                journal[count_journal][2] = in_.nextInt();
                journal[count_journal++][3] = in_.nextLine().equals(attendance[0]) ? 1 : -1;
            }

        } finally { in_.close(); }


        int[] times_temp = new int[times_.length];
        for (int i = 0; i < times_.length; i++) times_temp[i] = times_[i];


        int index_printable = 0;
        for (int i = 0; i < count_names_ + 1; ++i) {
            boolean print_names = false;
            for (int j = 0; j < 30; ++j) {
                int dayOfWeekIndex = j % 7;
                for (int k = 0; k < CountClassesShall(days_written_, days[dayOfWeekIndex], count_times_days); ++k) {
                    int dayIndex = GetIndexString(days_written_, days[dayOfWeekIndex], count_times_days);
                    int timeIndex = GetMinIndexInt(days_written_, days[dayOfWeekIndex], times_, count_times_days);
                    if (dayIndex != -1) {
                        if (i == 0) {
                            System.out.print("  " + times_[timeIndex] +
                                    ":00 " + days_written_[dayIndex] +
                                    "  " + (j + 1) + "|");
                            if (j <= 10) index_printable = j;
                            times_[timeIndex] = Integer.MAX_VALUE;
                        } else {
                            int attendance_ = CheckAttendance(journal, count_journal, i - 1, times_[timeIndex], j + 1);
                            System.out.print((!print_names ? names_[i - 1] : "") +
                                    " ".repeat((attendance_ == -1 ? 11 : 12) - (!print_names ? names_[i - 1].length() : 0) +
                                            (j >= index_printable ? 1 : 0)) + (attendance_ != 0 ? attendance_ : " ")  + "|");
                            print_names = true;
                            times_[timeIndex] = Integer.MAX_VALUE;
                        }
                    }
                }
                for (int l = 0; l < times_.length; l++) times_[l] = times_temp[l];
            }
            System.out.println();
        }
    }

    private static int CheckAttendance(final int[][] journal, final int length_journal, final int name_, final int time_, final int day_) {
        for (int i = 0; i < length_journal; ++i) {
            if (journal[i][0] == name_ && journal[i][1] == time_ && journal[i][2] == day_) return journal[i][3];
        }
        return 0;
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

