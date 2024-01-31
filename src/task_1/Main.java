package task_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        List<Integer> intList = new ArrayList<>();

        for (int x : list) {
            if (x <= 0) continue;
            if (x % 2 == 0) intList.add(x);
        }

        intList.sort(Comparator.naturalOrder());
        System.out.println(intList);
    }
}