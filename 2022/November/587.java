/*
 * Erect the Fence
 * 
 * Top 94% (19ms)
 * 
 * One of those questions that is tricky to code cause the algorithm and trickier cause java is
 * pass by value.
 * 
 * In order to make the smallest convex hull, we need to use an algorithm called the monotone chain.
 * In short:
 *  1) Scan the points from left to right
 *  2) For each point, from the one we're currently looking at, add to your solution
 *  only the point that is the "least counter-clockwise" past the current point
 *  2.1) To calculate "least counter-clockwise", use cross product (in 2d it gives us an area
 *  of a plane)
 *  2.2) Due to sorting, as long as the cross product is negative for our orientation,
 *  the candidate point will be the "least counter-clockwise". This will lead to the "monotone"-ness
 *  as the algorithm will only pick up points that are to the right of the current point and least
 *  counterclockwise.
 *  3) Repeat this process going from right to left. For the orietnation I used in my cross product,
 *  left to right gives the bottom half of the hull, and right to left gives the top half of the hull.
 *  4) Combine the chains of both scans
 *  5) Remove any duplicate points between both scans (there must be two to join both top and bottom)
 * 
 * Time complexity: O(nlogn), due to sorting (the montone chain algorithm is O(2n))
 */

class Solution {
    public int[][] outerTrees(int[][] trees) {
        // Step 1: Sort the 2d array and create a reversed list as well
        Arrays.sort(trees, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int[][] reversed = new int[trees.length][2];
        for (int i = trees.length - 1; i >= 0; i--) {
            reversed[trees.length - 1 - i] = trees[i];
        }
        // Step 2: Construct both halves of the hull
        Deque<int[]> leftToRight = constructHalfHull(trees);
        Deque<int[]> rightToLeft = constructHalfHull(reversed);
        
        // Step 3: Combine both halves of the hull and remove duplicates via the set property
        HashSet<SetItem> sol = new HashSet<>();
        /*
         * Stack size will decrease with each loop, and java will re-evaluate stack.size() each iteration.
         * It will incorrectly end the loop early unless you lock in the value at the start.
         */
        int leftToRightSize = leftToRight.size();   
        int rightToLeftSize = rightToLeft.size();
        for (int i = 0; i < leftToRightSize; i++) {
            int[] tree = leftToRight.pop();
            sol.add(new SetItem(tree[0], tree[1]));
        }
        for (int i = 0; i < rightToLeftSize; i++) {
            int[] tree = rightToLeft.pop();
            sol.add(new SetItem(tree[0], tree[1]));
        }

        // Step 4: Create solution array
        int[][] solArray = new int[sol.size()][2];
        int index = 0;
        for (SetItem s : sol) {
            solArray[index][0]= s.x;
            solArray[index][1]= s.y;
            index++;
        }

        return solArray;
    }  
    
    // Highschool maths
    private int crossProduct (int[] p1, int[] p2, int[] p3) {
        /*
            A x B = ad - bc
            A = [a,b]
            B = [c,d]
            A = (p2,p3)
            B = (p1,p2)
        */

        int a = p3[0] - p2[0];
        int b = p3[1] - p2[1];
        int c = p2[0] - p1[0];
        int d = p2[1] - p1[1];

        return a * d - b * c;
    }

    // Monotone chain algorithm
    private Deque<int[]> constructHalfHull(int[][] points) {
        Deque<int[]> stack = new ArrayDeque<int[]>();

        for (int i = 0; i < points.length; i++) {
            while (stack.size() >= 2) {
                int[] p1 = stack.pop();
                int[] p2 = stack.pop();
                /**
                 * "pop" the top of the stack if we get a positive cross product 
                 * which implies the candidate point is making the chain move clockwise
                 * rather than counterclockwise        
                 */
                if (crossProduct(p2, p1, points[i]) > 0) {   
                    stack.push(p2);
                }
                else {
                    stack.push(p2);
                    stack.push(p1);
                    break;
                }
            }
            stack.push(points[i]);
        }
        // Iterator<int[]> iteratorVals = stack.iterator();
        // while(iteratorVals.hasNext()) {
        //     int[] next = iteratorVals.next();
        //     System.out.println(next[0] + " " + next[1]);
        // }
        // System.out.println(" ");

        return stack;
    }

    /*
     * Since java sets use hashcode and equals to store elements,
     * we won't get the intended duplicate prevention with the defaults of a 2d array
     * and need to override to do a deep comparison
     */
    class SetItem {
        public int x;
        public int y;
        public SetItem(int x, int y) {
            this.x = x;
            this.y =y;
        }

        /*
         * hashcode and equals both need to be overriden.
         * If hashcode isn't overriden, values that are equal but have a different hash
         * will be treated as different. 
         * If equals isn't overriden, values that aren't equal but have the same hash will be
         * treated the same.
        */
        
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other == null || this.getClass() != other.getClass()){
                return false;
            }
            SetItem otherSetItem = (SetItem)other;
            return otherSetItem.x == this.x && otherSetItem.y == this.y;
        }
    }
}