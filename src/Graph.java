import java.util.*;

public class Graph<T> {
    protected Map<T, List<T>> map = new HashMap<>();

    protected void addVertex(T source) {
        map.put(source, new LinkedList<>());
    }

    protected void addEdge(T source, T destination, boolean bidirectional) {
        if (!map.containsKey(source))
            addVertex(source);

        if (!map.containsKey(destination))
            addVertex(destination);

        map.get(source).add(destination);
        if (bidirectional)
            map.get(destination).add(source);
    }

    protected int getVertexCount() {
        return map.keySet().size();
    }

    protected int getEdgesCount(boolean bidirectional) {
        int count = 0;
        for (T vertex : map.keySet()) {
            count += map.get(vertex).size();
        }

        if (bidirectional)
            count /= 2;

        return count;
    }

    protected boolean hasVertex(T source) {
        return map.containsKey(source);
    }

    protected boolean hasEdge(T source, T destination) {
        return map.get(source).contains(destination);
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (T v : map.keySet()) {
            builder.append(v.toString() + ": ");
            for (T w : map.get(v)) {
                builder.append(w.toString() + " ");
            }
            builder.append("\n");
        }

        return builder.toString();
    }
}
