import java.util.*;
import java.lang.*;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Number of initial problems
        int q = scanner.nextInt(); // Number of events

        ArrayList<Integer> stack = new ArrayList<Integer>();// Stack to store problems
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> moved = new ArrayList<>();

        // Read initial problems into stack and map
        for (int i = 0; i < n; i++) {
            int problemId = scanner.nextInt();
            stack.add(problemId);
            map.put(problemId, stack.size());
        }

        // Process each event
        for (int i = 0; i < q; i++) {
            String eventType = scanner.next();
            switch (eventType) {
                case "ToSolve":
                    int toSolveId = scanner.nextInt();
                    int index = map.get(toSolveId);
                    for(int a:moved){
                        if(index>a){
                            index--;
                        }
                    }
                    moved.add(i);
                    stack.remove((Integer) toSolveId); // Remove from its current position

                    stack.add(toSolveId); // Push it to the top
                    break;
                case "IdAt":
                    int k = scanner.nextInt();
                    // Output the id of k-th problem from the bottom of the stack
                    System.out.println(stack.get(k - 1));
                    break;
                case "Kof":
                    int kofId = scanner.nextInt();
                    // Output the position of the problem with id from the bottom of the stack
                    for (int j = 0; j < stack.size(); j++) {
                        if (stack.get(j) == kofId) {
                            System.out.println(j + 1);
                        }
                    }
                    break;
                case "Add":
                    int addId = scanner.nextInt();
                    stack.add(addId); // Add new problem on top
                    break;
                default:
                    break;
            }
        }
        scanner.close();
    }
}
