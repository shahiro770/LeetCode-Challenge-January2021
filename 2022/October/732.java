/**
 * My Calendar III
 * 
 * October 2022
 * Top 100% (0ms)  
 * 
 * Learned about a segment tree (structure used for intervals)
 * Basically you can use two nodes in the tree to mark the start and end of an interval,
 * with nodes above encompassing those intervals. You can use that fact to make parent nodes
 * store "intersections".
 * 
 * Time complexity: O(nlogn)?
 * */

class MyCalendarThree {
    /**
     *                                    [0,64]
     *               
     *                  [0,32]                             [33,64]
     *
     *          [0,16]          [17,32]           [33,48]             [49,64]
     *
     *      [0,8]   [9,16]   [17,24]  [25,32]  [33,40]   [41,48]   [49,56]  [57,64]
     *
     *          .......................
     *   [0,0] [1,1] ........................                                   [63,63] [64,64]
     */
    private SegmentTreeNode root;
    
    public MyCalendarThree() {
        // root's end needs to be larger than the largest number inputted into the segmented tree
        // for this question that value is 1000000000
        root = new SegmentTreeNode(0, 100);
    }
    
    public int book(int start, int end) {
        addValue(start, end - 1, 1, root);
        return root.max;
    }
    
    private void addValue(int start, int end, int val, SegmentTreeNode node) {
        // if the current node is between the interval, we can use it to mark a fourth of the interval's booking
        // (i.e. its a timestamp marking either the start or the end of the current interval,
        // but as we shrink the window we may end up with a node right after/before
        // e.g. [5,6] may result in [5,5] and [6,6]
        if (start <= node.start && node.end <= end) {
            // += in the event two intervals are the same
            node.booked += val;
            node.max += val;
            return;
        }
        /*
        We need to binary search our way down to find where to put the new interval's
        start and end, eventually creating two nodes that completely span the new interval
        e.g. [10,20] will result in the nodes [10,12] and [13,19] being created
        Nodes above the current node "contain" these intervals
        e.g. [10,12] ⊆ [7,12] ⊆ [0,12] ⊆ [0,25] ⊆ [0,50] ⊆ [0, 100]...
        */
        int mid = node.start + (node.end - node.start) / 2;
        if (start <= mid) {
            if (node.left == null) {
                node.left = new SegmentTreeNode(node.start, mid);
            } 
            addValue(start, end, val, node.left);
        }
        if (end >= mid + 1) {
            if (node.right == null) {
                node.right = new SegmentTreeNode(mid + 1, node.end);
            }
            addValue(start, end, val, node.right);
        }
        /*
        Nodes update themselves after the new intervals have been added on the number of nodes with bookings
        underneath them (i.e. an intersection)
        */
        int leftMax = node.left == null ? 0 : node.left.max;
        int rightMax = node.right == null ? 0 : node.right.max;
        node.max = Math.max(leftMax, rightMax) + node.booked;
    }

    class SegmentTreeNode {
        int start;
        int end;
        int booked = 0; // number of bookings that interesct
        int max = 0;    // largest booked between this node and its children

        SegmentTreeNode left;
        SegmentTreeNode right;

        public SegmentTreeNode(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}

/* Original Solution (Top 21% (241ms))

class MyCalendarThree {
    // PriorityQueue<TimePoint> pq;
    ArrayList<TimePoint> tpa;
    int largestK = 0;

    public MyCalendarThree() {
        // pq = new PriorityQueue<TimePoint>(new TimePointComparator()); 
        tpa = new ArrayList<TimePoint>(400);
    }
    
    public int book(int start, int end) {
        tpa.add(new TimePoint(start, true));
        tpa.add(new TimePoint(end, false));

        return getKIntersections();
    }

    public int getKIntersections() {
        int kCount = 0;
        int maxK = 0;

        Collections.sort(tpa, new TimePointComparator());
        // System.out.println("counting");
        for (int i = 0; i < tpa.size(); i++) {
            
            if (tpa.get(i).isStart == true) {
                kCount++;
            }
            else {
                kCount--;
            }
            // System.out.println(tpa.get(i).time + " " + tpa.get(i).isStart + " " + kCount);
            if (kCount > maxK) {
                maxK = kCount;
            }
        }

        return maxK;
    }

    private class TimePoint {
        int time;
        boolean isStart;

        private TimePoint(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }
    }

    class TimePointComparator implements Comparator<TimePoint> {
        public int compare(TimePoint a, TimePoint b) {
            if (a.time == b.time) {
                if (a.isStart == false) {
                    return -1;
                }
                else {
                    return 1;
                }
            }
            return a.time - b.time;
        }
    }
}
*/

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */

 /**
    10 20       
                 50      60
    10      40
5       15
5   10
          25        55
  */