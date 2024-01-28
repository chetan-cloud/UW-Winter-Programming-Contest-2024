import java.util.Arrays;
import java.util.Scanner;

class Problem7 {

    static class Item implements Comparable<Item> {
        int time;
        int value;
        double ratio;

        public Item(int time, int value) {
            this.time = time;
            this.value = value;
            this.ratio = (time % 2 == 0) ? (double) value / (time / 2) : 0;
        }

        @Override
        public int compareTo(Item other) {
            return Double.compare(other.ratio, this.ratio);
        }
    }

    static class ItemX implements Comparable<Item> {
        int time;
        int value;
        double ratio;

        public ItemX(int time, int value) {
            this.time = time;
            this.value = value;
            this.ratio = (time % 2 == 0) ? (double) value / (time) : 0;
        }

        @Override
        public int compareTo(Item other) {
            return Double.compare(other.ratio, this.ratio);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Number of items
        int T = scanner.nextInt(); // Total time available
        int k = scanner.nextInt(); // Number of TURBO BOOST uses

        Item[] items = new Item[n];
        ItemX[] itemsX = new ItemX[n];
        for (int i = 0; i < n; i++) {
            int t = scanner.nextInt();
            int v = scanner.nextInt();
            items[i] = new Item(t, v);
            itemsX[i] = new ItemX(t, v);
        }

        Arrays.sort(items); // Sort items by ratio

        int totalTime = 0;
        int totalValueWithBoost = 0;
        int totalValueWithoutBoost = 0;
        int boostUsed = 0;

        for (Item item : items) {
            // Calculate total credits and time with TURBO BOOST
            if (boostUsed < k && item.time % 2 == 0 && totalTime + item.time / 2 <= T) {
                totalTime += item.time / 2;
                totalValueWithBoost += item.value;
                boostUsed++;
            } else if (totalTime + item.time <= T) { // Without TURBO BOOST
                totalTime += item.time;
                totalValueWithBoost += item.value;
            }

            // Calculate total credits without TURBO BOOST
            if (totalTime > T) {
                break;
            }
        }
        totalTime = 0;
        for (ItemX item : itemsX) {
            if(totalTime + item.time <= T){
                totalValueWithoutBoost+=item.value;
                totalTime+=item.time;
            }

            if (totalTime > T) {
                break;
            }
        }

        System.out.println(totalValueWithBoost - totalValueWithoutBoost);
        scanner.close();
    }
}
