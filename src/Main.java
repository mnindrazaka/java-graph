public class Main {
    public static void main(String[] args) {
        Graph<Integer> g = new Graph<>();

        g.addEdge(0, 1, true);
        g.addEdge(0, 4, true);
        g.addEdge(1, 2, true);
        g.addEdge(1, 3, true);
        g.addEdge(1, 4, true);
        g.addEdge(2, 3, true);
        g.addEdge(3, 4, true);

        System.out.println("Graph:\n" + g);

        System.out.println(g.getVertexCount());

        System.out.println(g.getEdgesCount(true));

        System.out.println(g.hasEdge(3, 4));

        System.out.println(g.hasVertex(5));
    }
}