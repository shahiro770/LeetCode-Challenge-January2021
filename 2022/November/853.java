/*
 * Car Fleet
 *
 * Top 75% (146ms) 
 * 
 * Sort the cars by position in descending order, then calculate the time each car takes to reach
 * the target. Starting with the car furthest up, if any car before it takes less time, it will join
 * this car's fleet. Should a car before it be slower, it marks the seperation of a fleet and then
 * repeat the logic for it. Easiest to model this idea with a stack.
 * 
 * Could view this problem as intersection of slopes
 * 
 * Time Complexity: O(nlgn) because sorting
 */

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Car[] cars = new Car[position.length];
        Deque<Car> stack = new LinkedList<Car>();

        for (int i = 0; i < position.length; i++) {
            cars[i] = new Car(position[i], speed[i], target);
        }
        Arrays.sort(cars);
        stack.push(cars[0]);

        for (int i = 1; i < cars.length; i++) {
            if (stack.peek().time < cars[i].time) {
                stack.push(cars[i]);
            }
        }

        return stack.size();
    }

    private class Car implements Comparable<Car> {
        int pos;
        int speed;
        double time;

        private Car(int pos, int speed, int target) {
            this.pos = pos;
            this.speed = speed;
            time = (target - pos) / (double)speed;
        }

        @Override
        public int compareTo(Car b) {
            return b.pos - this.pos;
        }
    }
}

/*

0   3   5   8   10 
1   3   1   4   2
*/