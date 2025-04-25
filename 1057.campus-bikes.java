class WBP {
    int workerId;
    int bikeId;
    int distance;

    public WBP(int w, int b, int d) {
        this.workerId = w;
        this.bikeId = b;
        this.distance = d;
    }
}
class Solution {
    List<List<Pair<Integer, Integer>>> rank;
    int[] index = new int[1001];

    public void add(PriorityQueue<WBP> pq, int worker) {
        Pair<Integer, Integer> p = rank.get(worker).get(index[worker]);
        index[worker] += 1;
        pq.add(new WBP(worker, p.getValue(), p.getKey()));
    }

    public int cal(int[] w, int[] b) {
        return Math.abs(w[0] - b[0]) + Math.abs(w[1] - b[1]);
    }

    public int[] assignBikes(int[][] workers, int[][] bikes) {
        Comparator<WBP> c = new Comparator<WBP>(){
            @Override
            public int compare(WBP o1, WBP o2) {
                if (o1.distance != o2.distance) return o1.distance - o2.distance;
                else if (o1.workerId != o2.workerId) return o1.workerId - o2.workerId;
                else return o1.bikeId - o2.bikeId;
            }
        };

        rank = new ArrayList();
        PriorityQueue<WBP> pq = new PriorityQueue<WBP>(c);
        for (int i = 0; i < workers.length; i++) {
            List<Pair<Integer, Integer>> l = new ArrayList();
            for (int j = 0; j < bikes.length; j++) {
                l.add(new Pair(cal(workers[i], bikes[j]), j));
            }
            Collections.sort(l, Comparator.comparing(Pair::getKey));
            rank.add(l);
            index[i] = 0;
            add(pq, i);
        }

        boolean bikeStatus[] = new boolean[bikes.length];
        int[] workerStatus = new int[workers.length];
        Arrays.fill(workerStatus, -1);

        while (pq.isEmpty() == false) {
            WBP wbp = pq.poll();
            int b = wbp.bikeId;
            int w = wbp.workerId;

            if (bikeStatus[b] == false && workerStatus[w] == -1) {
                bikeStatus[b] = true;
                workerStatus[w] = b;
            } else {
                add(pq, w);
            }
        }
        return workerStatus;
    }
}