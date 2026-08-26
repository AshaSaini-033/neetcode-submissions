class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // from -> {to, price}
        for (int[] flight : flights) {
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        // cost to reach each node
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;
        int ans = Integer.MAX_VALUE;

        // stops, vertex, cost
        PriorityQueue<Node> pq =
            new PriorityQueue<>((a, b) -> a.stops - b.stops);

        pq.add(new Node(src, 0, 0));

        while (!pq.isEmpty()) {

            Node curr = pq.poll();

            int vertex = curr.vertex;
            int stops = curr.stops;
            int cost = curr.cost;

            // maximum k stops = k+1 flights
            if (stops > k+1) {
                continue;
            }

            if (vertex == dst) {
            ans = Math.min(cost,ans);
            continue;
            }

            for (int[] edge : graph.get(vertex)) {

                int next = edge[0];
                int price = edge[1];

                int newCost = cost + price;

                if (newCost < dist[next]) {

                    dist[next] = newCost;

                    pq.add(new Node(
                        next,
                        stops + 1,
                        newCost
                    ));
                }
            }
        }

        return ans==Integer.MAX_VALUE?-1:ans;
    }
}

class Node {
    int vertex;
    int stops;
    int cost;

    Node(int vertex, int stops, int cost) {
        this.vertex = vertex;
        this.stops = stops;
        this.cost = cost;
    }
}