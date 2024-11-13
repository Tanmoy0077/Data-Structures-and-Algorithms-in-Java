package DSA;

import java.util.*;

public class DotaSenete {
    public static void solver(String s){
        Queue<Integer> rQueue = new LinkedList<>();
        Queue<Integer> dQueue = new LinkedList<>();
        int slen = s.length();
        for(int i=0;i<slen;i++){
            if(s.charAt(i) == 'R')
                rQueue.add(i);
            else
                dQueue.add(i);
        }

        while(!rQueue.isEmpty() && !dQueue.isEmpty()){
            int r = rQueue.poll();
            int d = dQueue.poll();

            if(r < d){
                rQueue.add(r+slen);
            }
            else
                dQueue.add(d+slen);
        }

        if(rQueue.isEmpty())
            System.out.println("Dire");
        else
            System.out.println("Radient");

    }
    public static void main(String[] args) {
        String s = "DDRRR";
        solver(s);
    }
}
