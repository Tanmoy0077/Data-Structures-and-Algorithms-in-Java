package DSA;

import java.util.*;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();

        queue.add(0);
        visited.add(0);

        while(!queue.isEmpty()){
            List<Integer> list = rooms.get(queue.poll());
            for(int node: list){
                if(!visited.contains(node)){
                    visited.add(node);
                    queue.add(node);
                }
            }
        }
        
        return visited.size() == rooms.size();
    }

    public static void main(String[] args) {
        
    }
}
