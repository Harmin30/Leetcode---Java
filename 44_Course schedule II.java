import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> adjList = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        // Initialize adjacency list
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        // Build adjacency list and in-degree array
        for (int[] pre : prerequisites) {
            int course = pre[0], prereq = pre[1];
            adjList.get(prereq).add(course);
            inDegree[course]++;
        }

        // Queue for courses with no prerequisites (inDegree == 0)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Process courses using BFS (Kahn’s Algorithm)
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            result.add(curr);

            for (int neighbor : adjList.get(curr)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // If we processed all courses, return result; otherwise, return empty array (cycle detected)
        if (result.size() == numCourses) {
            return result.stream().mapToInt(i -> i).toArray();
        } else {
            return new int[0];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int numCourses = 4;
        int[][] prerequisites = { {1, 0}, {2, 0}, {3, 1}, {3, 2} };
        
        System.out.println(Arrays.toString(sol.findOrder(numCourses, prerequisites)));
    }
}
