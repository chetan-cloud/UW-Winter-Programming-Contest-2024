import java.util.*;

public class Problem5 {
    public static class Name implements Comparable<Name> {
        String name;
        int baby;

        @Override
        public int compareTo(Name o) {
            return name.compareTo(o.name);
        }

        public Name(String n, int b) {
            name = n;
            baby = b;
        }
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int numNames = console.nextInt();
        Name[] names = new Name[numNames + 1];
        names[0] = new Name("", 0);

        for (int i = 1; i < numNames + 1; i++) {
            String c = console.next();
            int prevName = console.nextInt();
            console.nextLine();
            names[i] = new Name(c + names[prevName].name, i);
        }
        Arrays.sort(names);
        for (int i = 1; i < numNames + 1; i++) {
            System.out.print(names[i].baby);
            System.out.print(" ");
        }
    }
}
