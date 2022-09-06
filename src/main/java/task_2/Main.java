package task_2;

import java.util.Arrays;

/*Task2
         [3, 4, 2, 7], 10 -> [3, 7] - вывести пару менно в скобках, которые дают сумму - 10
         */
public class Main {
    static int [] array = new int[] {3, 4, 2, 7};
    static int number = 10;

    public static void main(String[] args) {
        int [] pair = new int[2];
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if ((array[i] + array[j]) == number) {
                    pair[0] = array[i];
                    pair[1] = array[j];
                    System.out.println(Arrays.toString(pair));
                }
            }
        }
    }
}
