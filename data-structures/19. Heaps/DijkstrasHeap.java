import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Nodes {
    int source;
    int target;
    int distance;

    public static Nodes builder() {
        return new Nodes();
    }

    public Nodes source(int source) {
        this.source = source;
        return this;
    }

    public Nodes target(int target) {
        this.target = target;
        return this;
    }

    public Nodes distance(int distance) {
        this.distance = distance;
        return this;
    }

    public Nodes build() {
        return this;
    }
}

class MinHeapNode implements Comparator<MinHeapNode> {

    public int node;
    public int cost;

    public MinHeapNode() {
    }

    public MinHeapNode(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compare(MinHeapNode node1, MinHeapNode node2) {
        if (node1.cost < node2.cost) {
            return -1;
        }
        if (node1.cost > node2.cost) {
            return 1;
        }
        return 0;
    }
}

public class DijkstrasHeap {

    private HashSet<Integer> visited;
    private PriorityQueue<MinHeapNode> heap;

    private int V;
    private int[] dist;

    private Map<Integer, List<Pair<Integer, Integer>>> adj = new HashMap<>();


    public DijkstrasHeap(int n) {
        this.V = n;
        this.dist = new int[V];
        this.visited = new HashSet<>();
        this.heap = new PriorityQueue<>(V, new MinHeapNode());
    }

    public void dijkstras(int s) {
        adjacency(routes());

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        heap.add(new MinHeapNode(s, 0));

        while (visited.size() != V) {
            int u = heap.remove().node;
            visited.add(u);

            for (int i = 0; i < adj.get(u).size(); i++) {
                Pair<Integer, Integer> pair = adj.get(u).get(i);
                int target = pair.first;

                if (!visited.contains(target)) {
                    int distance = pair.second;
                    if (dist[u] + distance < dist[target]) {
                        dist[target] = dist[u] + distance;
                    }
                    heap.add(new MinHeapNode(target, dist[target]));
                }
            }
        }

        System.out.println("The shorted path from node :");
        for (int i = 0; i < dist.length; i++) {
            System.out.println(s + " to " + i + " is " + dist[i]);
        }
    }

    private List<Nodes> routes() {
        List<Nodes> routes = new LinkedList<>();
        routes.add(build(0, 1, 4));
        routes.add(build(0, 2, 3));
        routes.add(build(0, 4, 7));

        routes.add(build(1, 0, 4));
        routes.add(build(1, 2, 6));
        routes.add(build(1, 3, 5));

        routes.add(build(2, 0, 3));
        routes.add(build(2, 1, 6));
        routes.add(build(2, 3, 11));
        routes.add(build(2, 4, 8));

        routes.add(build(3, 1, 5));
        routes.add(build(3, 2, 11));
        routes.add(build(3, 4, 2));
        routes.add(build(3, 6, 10));
        routes.add(build(3, 5, 2));

        routes.add(build(4, 0, 7));
        routes.add(build(4, 2, 8));
        routes.add(build(4, 3, 2));
        routes.add(build(4, 6, 5));

        routes.add(build(5, 3, 2));
        routes.add(build(5, 6, 3));

        routes.add(build(6, 4, 5));
        routes.add(build(6, 3, 10));
        routes.add(build(6, 5, 3));

        return routes;
    }

    private Nodes build(int s, int t, int distance) {
        return Nodes.builder().source(s).target(t).distance(distance).build();
    }

    private void adjacency(List<Nodes> routes) {
        routes.forEach(route -> {
            Pair<Integer, Integer> edge = Pair.of(route.target, route.distance);
            if (adj.containsKey(route.source)) {
                adj.get(route.source).add(edge);
                return;
            }
            List<Pair<Integer, Integer>> list = new ArrayList<>();
            list.add(edge);
            adj.put(route.source, list);
        });
    }
}

class DijkstrasHeapSolution {

    public static void main(String[] args) {
        DijkstrasHeap dijkstras = new DijkstrasHeap(7);
        dijkstras.dijkstras(5);
    }
}
