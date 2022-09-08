package task_3;
/*
        Task3
            Реализовать функцию нечеткого поиска

                    fuzzySearch("car", "ca6$$#_rtwheel"); // true
                    fuzzySearch("cwhl", "cartwheel"); // true
                    fuzzySearch("cwhee", "cartwheel"); // true
                    fuzzySearch("cartwheel", "cartwheel"); // true
                    fuzzySearch("cwheeel", "cartwheel"); // false
                    fuzzySearch("lw", "cartwheel"); // false
         */

public class Main {
    public static void main(String[] args) {
        System.out.println(fuzzySearch("car", "ca6$$#_rtwheel")); //true
        System.out.println(fuzzySearch("cwhl", "cartwheel"));// true
        System.out.println(fuzzySearch("cwhee", "cartwheel")); //true
        System.out.println(fuzzySearch("cartwheel", "cartwheel")); // true
        System.out.println(fuzzySearch("cwheeel", "cartwheel")); // false
        System.out.println(fuzzySearch("lw", "cartwheel")); // false
    }
    public static boolean fuzzySearch(String word, String example) {
        if(word == null || example == null) {
            System.out.println("Incorrect input data!");
            throw new NullPointerException();
        }

        boolean result = false;
        char [] wordChars = word.toCharArray();
        char [] exampleChars = example.toCharArray();
        int symbolsFounded = 0;
        int position = 0;
        for (int i = 0; i < wordChars.length; i++) {
            for (int j = position; j < exampleChars.length; j++) {
                if(wordChars[i] == exampleChars[j]) {
                    symbolsFounded++;
                    position++;
                    break;
                }
                position++;
            }
        }
        if (symbolsFounded == wordChars.length) result = true;
        return result;
    }
}
