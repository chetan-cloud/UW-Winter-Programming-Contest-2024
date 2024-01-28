import java.util.*;


public class Problem3 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int rows = console.nextInt();
        int columns = console.nextInt();
        console.nextLine();
        int[][] land = new int[rows][columns];
        int num_free = 0;
        for (int i = 0; i < rows; i++) {
            String line = console.nextLine();
            for (int j = 0; j < columns; j++) {
                int free = line.charAt(j) == '.' ? 1 : 0;
                land[i][j] = free;
                num_free += free;
            }
        }
        if ((double) num_free / rows / columns > .5) {
            System.out.println("YARGHHH");
            return;
        }
        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < columns - 1; j++) {
                if (land[i][j] + land[i + 1][j] + land[i][j + 1] + land[i + 1][j + 1] >= 3) {
                    System.out.println("YARGHHH");
                    return;
                }
            }
        }
        System.out.println("FFFGHHH");
    }
}
