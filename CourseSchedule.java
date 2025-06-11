// TC: O(V+E)
// SC: O(V+E)
// Approach: Start drawing the given input 
// You will notice a graph structure with vertices and edges
// Find who doesn't have dependency i.e who doesn't have incoming course
// At any point the dependency becomes 0 then you can process that
// Reduces indegree of node who is 0 
// Create hashmap of dependent and independent 
// Sorting things based on dependency is called topological sort
// If there is a cycle we cannot process all courses in that case return false

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    int[] indegrees = new int[numCourses];
    HashMap<Integer, List<Integer>> map = new HashMap<>();

    for (int[] edge : prerequisites) {
      int out = edge[1];
      int in = edge[0];
      indegrees[in]++;
      if (!map.containsKey(out)) {
        map.put(out, new ArrayList<>());
      }
      map.get(out).add(in);
    }

    int count = 0;
    Queue<Integer> q = new LinkedList<>();

    for (int i = 0; i < numCourses; i++) {
      if (indegrees[i] == 0) {
        q.add(i);
        count++;
      }
    }
    while (!q.isEmpty()) {
      int curr = q.poll();
      List<Integer> children = map.get(curr);
      for (int child : children) {
        indegrees[child]--;
        if (indegrees[child] == 0) {
          q.add(child);
          count++;
          if (count == numCourses) {
            return true;
          }
        }
      }
    }
    return false;
  }
}
