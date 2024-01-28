import java.util.HashMap;
import java.util.Scanner;

public class Problem10 {
    public static int minChanges(String string, int k) {
        if (k == 1) {
            return 0;
        }
        if (k == string.length()) {
            int needToChange = 0;
            for (int i = 0; i < string.length() / 2; i++) {
                if (string.charAt(i) != string.charAt(string.length() - i - 1)) {
                    needToChange += 1;
                }
            }
            return needToChange;
        }
        if (k % 2 == 0) {
            HashMap<Character, Integer> frequency = new HashMap<Character, Integer>();
            int highestFrequency = 0;
            for (int i = 0; i < string.length(); i++) {
                frequency.put(string.charAt(i), frequency.getOrDefault(string.charAt(i), 0) + 1);
                if (frequency.get(string.charAt(i)) > highestFrequency) {
                    highestFrequency = frequency.get(string.charAt(i));
                }
            }
            return string.length() - highestFrequency;
        }
        HashMap<Character, Integer> oddFrequency = new HashMap<Character, Integer>();
        HashMap<Character, Integer> evenFrequency = new HashMap<Character, Integer>();
        int highestOddFrequency = 0;
        int highestEvenFrequency = 0;
        for (int i = 0; i < string.length(); i++) {
            if (i % 2 == 0) {
                evenFrequency.put(string.charAt(i), evenFrequency.getOrDefault(string.charAt(i), 0) + 1);
                if (evenFrequency.get(string.charAt(i)) > highestEvenFrequency) {
                    highestEvenFrequency = evenFrequency.get(string.charAt(i));
                }
            }
            else {
                oddFrequency.put(string.charAt(i), oddFrequency.getOrDefault(string.charAt(i), 0) + 1);
                if (oddFrequency.get(string.charAt(i)) > highestOddFrequency) {
                    highestOddFrequency = oddFrequency.get(string.charAt(i));
                }
            }
        }
        return string.length() - highestOddFrequency - highestEvenFrequency;
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int numStrings = console.nextInt();
        console.nextLine();
        for (int i = 0; i < numStrings; i++) {
            String string = console.next();
            int k = console.nextInt();
            console.nextLine();
            System.out.println(minChanges(string, k));
        }
    }
}
