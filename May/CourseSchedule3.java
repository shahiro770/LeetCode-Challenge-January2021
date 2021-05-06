/**
 * May 2021 Day 2
 * Top 99%
 * 
 * Sort the courses by end dates in ascending order (this way if there's ever a swap made between a course
 * we've taken and a new course, it will be guaranteed to work)
 * 
 * Maintain a max heap (priority queue) that keeps the longest duration course at the head
 * From there we have two operations as iterate through the sorted course list:
 *      1) Add the current course if it can be fitted into current course list without exceeding the duration
 *      2) If it can't be added, swap it with the max duration course if it takes less time
 * 
 * Time complexity: O(nlogn) cause sort is nlogn and heap property takes logn
 */

public class CourseSchedule3 {
    public int scheduleCourse(int[][] courses) {
        int currentTotalTime = 0;
        
        PriorityQueue<int[]> addedCourses = new PriorityQueue<int[]>(new DurationComparator());
        Arrays.sort(courses, new ArrayComparator());
        
        for (int i = 0; i < courses.length; i++) {
            if (currentTotalTime + courses[i][0] <= courses[i][1]) {
                currentTotalTime += courses[i][0];
                addedCourses.add(courses[i]);
            }
            else if (addedCourses.size() > 0 && addedCourses.peek()[0] > courses[i][0]) {
                currentTotalTime -= addedCourses.poll()[0];
                currentTotalTime += courses[i][0];
                addedCourses.add(courses[i]);
            }     
        }
        
        return addedCourses.size();
    }
    
    class ArrayComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return a[1] - b[1];
        }
    }
    
    class DurationComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return b[0] - a[0];
        }
    }
}
