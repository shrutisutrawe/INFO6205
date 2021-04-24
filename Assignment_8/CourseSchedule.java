package INFO6205.Assignment_8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
    static int[] inDegree;
    static HashMap<Integer,ArrayList<Integer>> adjacencyList = new HashMap<Integer, ArrayList<Integer>>();
    static int n;
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        n = numCourses;
        inDegree = new int[n];
        for(int[] pre : prerequisites){
            ArrayList<Integer> list = adjacencyList.getOrDefault(pre[1],new ArrayList<>());
            list.add(pre[0]);
            inDegree[pre[0]]++;
            adjacencyList.put(pre[1],list);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i =0; i < inDegree.length; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }
        int count = 0;
        while(!q.isEmpty()){
            int current = q.poll();
            if(inDegree[current] == 0){
                count++;
            }
            if(!adjacencyList.containsKey(current)){
                continue;
            }
            for(int neighbor : adjacencyList.get(current)){
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0){
                    q.add(neighbor);
                }
            }
        }
        return count == numCourses;
    }
    public static void main(String[] args){
        int[][] prerequisites = {{1,0}};
        System.out.println(canFinish(2,prerequisites));
    }
}
