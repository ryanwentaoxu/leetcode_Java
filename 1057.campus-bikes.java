class WBP {
    int wId;
    int bId;
    int distance;

    public WBP(int wId, int bId, int distance) {
        this.wId = wId;
        this.bId = bId;
        this.distance = distance;
    }
}

class Solution {
    List<List<Pair<Integer, Integer>>> workerToBike;
    int[] bikeList;

    public void addtoPq(PriorityQueue<WBP> pq, int worker) {
        Pair<Integer, Integer> p = workerToBike.get(worker).get(bikeList[worker]);
        bikeList[worker] += 1;
        WBP wbp = new WBP(worker, p.getValue(), p.getKey());
        pq.add(wbp);
    }

    public int[] assignBikes(int[][] workers, int[][] bikes) {
        workerToBike = new ArrayList();
        bikeList = new int[1001];
        Comparator<WBP> c = new Comparator<WBP>(){
            @Override
            public int compare(WBP o1, WBP o2) {
                if (o1.distance != o2.distance) return o1.distance - o2.distance;
                else if (o1.wId != o2.wId) return o1.wId - o2.wId;
                else return o1.bId - o2.bId;
            }
        };
        PriorityQueue<WBP> pq = new PriorityQueue<WBP>(c);
        for (int i = 0; i < workers.length; i++) {
            List<Pair<Integer, Integer>> bl = new ArrayList();
            for (int j = 0; j < bikes.length; j++) {
                bl.add(new Pair(findDistance(workers[i], bikes[j]), j));
            }
            Collections.sort(bl, Comparator.comparing(Pair::getKey));
            workerToBike.add(bl);
            bikeList[i] = 0;
            addtoPq(pq, i);
        }
        boolean bikeStatus[] = new boolean[bikes.length];
        int[] workerStatus = new int[workers.length];
        Arrays.fill(workerStatus, -1);

        while (pq.isEmpty() != true) {
            WBP workerBikePair = pq.remove();
            
            int worker = workerBikePair.wId;
            int bike = workerBikePair.bId;
            if (workerStatus[worker] == -1 && !bikeStatus[bike]) {
                // If both worker and bike are free, assign them to each other
                bikeStatus[bike] = true;
                workerStatus[worker] = bike;
                
            } else {
                // Add the next closest bike for the current worker
                addtoPq(pq, worker);
            }
        }
        return workerStatus;
    }


    int findDistance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
}