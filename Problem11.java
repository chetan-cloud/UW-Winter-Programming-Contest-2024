import java.util.*;

public class Problem11 {

    static class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Node implements Comparable<Node> {
        int id;
        int distance;

        Node(int id, int distance) {
            this.id = id;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    public static int[] dijkstra(List<List<Edge>> graph, int start) {
        int[] distances = new int[graph.size()];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int currentId = currentNode.id;
            int currentDistance = currentNode.distance;

            if (currentDistance > distances[currentId]) {
                continue; // Skip if we already found a better way
            }

            for (Edge edge : graph.get(currentId)) {
                int nextId = edge.to;
                int nextDistance = currentDistance + edge.weight;

                if (nextDistance < distances[nextId]) {
                    distances[nextId] = nextDistance;
                    pq.add(new Node(nextId, nextDistance));
                }
            }
        }

        return distances;
    }

    public static void main(String[] args) {
        // Example usage:
        // Create a graph with 5 nodes (0 through 4)
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges to the graph
        int A = toIndex('a');
        int B = toIndex('b');
        int C = toIndex('c');
        int D = toIndex('d');
        int E = toIndex('e');
        int F = toIndex('f');
        int G = toIndex('g');
        int H = toIndex('h');
        int I = toIndex('i');
        int J = toIndex('j');
        int K = toIndex('k');
        int L = toIndex('l');
        int M = toIndex('m');
        int N = toIndex('n');
        int O = toIndex('o');
        int P = toIndex('p');
        int Q = toIndex('q');
        int R = toIndex('r');
        int S = toIndex('s');
        int T = toIndex('t');
        int U = toIndex('u');
        int V = toIndex('v');
        int W = toIndex('w');
        int X = toIndex('x');
        int Y = toIndex('y');
        int Z = toIndex('z');
        System.out.println(E);
        graph.get(A).add(new Edge(B, 1));
        graph.get(B).add(new Edge(A, 1));

        graph.get(A).add(new Edge(C, 1));
        graph.get(C).add(new Edge(A, 1));

        graph.get(A).add(new Edge(X, 1));
        graph.get(X).add(new Edge(A, 1));

        graph.get(B).add(new Edge(D, 1));
        graph.get(D).add(new Edge(B, 1));

        graph.get(B).add(new Edge(Z, 1));
        graph.get(Z).add(new Edge(B, 1));

        graph.get(C).add(new Edge(G, 1));
        graph.get(G).add(new Edge(C, 1));

        graph.get(C).add(new Edge(E, 1));
        graph.get(E).add(new Edge(C, 1));

        graph.get(C).add(new Edge(D, 1));
        graph.get(D).add(new Edge(C, 1));

        graph.get(D).add(new Edge(H, 1));
        graph.get(H).add(new Edge(D, 1));

        graph.get(D).add(new Edge(E, 1));
        graph.get(E).add(new Edge(D, 1));

        graph.get(E).add(new Edge(I, 1));
        graph.get(I).add(new Edge(E, 1));

        graph.get(E).add(new Edge(W, 1));
        graph.get(W).add(new Edge(E, 1));

        graph.get(F).add(new Edge(K, 1));
        graph.get(K).add(new Edge(F, 1));

        graph.get(F).add(new Edge(G, 1));
        graph.get(G).add(new Edge(F, 1));

        graph.get(F).add(new Edge(J, 1));
        graph.get(J).add(new Edge(F, 1));

        graph.get(F).add(new Edge(P, 1));
        graph.get(P).add(new Edge(F, 1));

        graph.get(G).add(new Edge(L, 1));
        graph.get(L).add(new Edge(G, 1));

        graph.get(G).add(new Edge(H, 1));
        graph.get(H).add(new Edge(G, 1));

        graph.get(H).add(new Edge(M, 1));
        graph.get(M).add(new Edge(H, 1));

        graph.get(H).add(new Edge(I, 1));
        graph.get(I).add(new Edge(H, 1));

        graph.get(I).add(new Edge(N, 1));
        graph.get(N).add(new Edge(I, 1));

        graph.get(I).add(new Edge(J, 1));
        graph.get(J).add(new Edge(I, 1));

        graph.get(J).add(new Edge(O, 1));
        graph.get(O).add(new Edge(J, 1));

        graph.get(J).add(new Edge(T, 1));
        graph.get(T).add(new Edge(J, 1));

        graph.get(K).add(new Edge(P, 1));
        graph.get(P).add(new Edge(K, 1));

        graph.get(K).add(new Edge(L, 1));
        graph.get(L).add(new Edge(K, 1));

        graph.get(K).add(new Edge(O, 1));
        graph.get(O).add(new Edge(K, 1));

        graph.get(L).add(new Edge(Q, 1));
        graph.get(Q).add(new Edge(L, 1));

        graph.get(L).add(new Edge(M, 1));
        graph.get(M).add(new Edge(L, 1));

        graph.get(M).add(new Edge(R, 1));
        graph.get(R).add(new Edge(M, 1));

        graph.get(M).add(new Edge(N, 1));
        graph.get(N).add(new Edge(M, 1));

        graph.get(N).add(new Edge(S, 1));
        graph.get(S).add(new Edge(N, 1));

        graph.get(N).add(new Edge(O, 1));
        graph.get(O).add(new Edge(N, 1));

        graph.get(O).add(new Edge(T, 1));
        graph.get(T).add(new Edge(O, 1));

        graph.get(P).add(new Edge(T, 1));
        graph.get(T).add(new Edge(P, 1));

        graph.get(P).add(new Edge(Q, 1));
        graph.get(Q).add(new Edge(P, 1));

        graph.get(Q).add(new Edge(U, 1));
        graph.get(U).add(new Edge(Q, 1));

        graph.get(Q).add(new Edge(R, 1));
        graph.get(R).add(new Edge(Q, 1));

        graph.get(R).add(new Edge(V, 1));
        graph.get(V).add(new Edge(R, 1));

        graph.get(R).add(new Edge(S, 1));
        graph.get(S).add(new Edge(R, 1));

        graph.get(S).add(new Edge(W, 1));
        graph.get(W).add(new Edge(S, 1));

        graph.get(S).add(new Edge(T, 1));
        graph.get(T).add(new Edge(S, 1));

        graph.get(U).add(new Edge(V, 1));
        graph.get(V).add(new Edge(U, 1));

        graph.get(U).add(new Edge(X, 1));
        graph.get(X).add(new Edge(U, 1));

        graph.get(U).add(new Edge(W, 1));
        graph.get(W).add(new Edge(U, 1));

        graph.get(V).add(new Edge(Y, 1));
        graph.get(Y).add(new Edge(V, 1));

        graph.get(V).add(new Edge(W, 1));
        graph.get(W).add(new Edge(V, 1));

        graph.get(X).add(new Edge(Y, 1));
        graph.get(Y).add(new Edge(X, 1));

        graph.get(Y).add(new Edge(Z, 1));
        graph.get(Z).add(new Edge(Y, 1));

        // Compute shortest paths from node 0 to all other nodes

        // Print shortest distances
        for (int i = 0; i < 26; i++) {
            int[] distances = dijkstra(graph, i);
            for (int j = 0; j < distances.length; j++) {
                System.out.println("distances.put(\"" + fromIndex(i) + "" + fromIndex(j) + "\", " + Integer.toString(distances[j]) + ");");
            }
        }
    }

    public static int toIndex(char c) {
        return (int) c - 97;
    }
    public static char fromIndex(int i) {
        return (char) (i + 97);
    }
}
