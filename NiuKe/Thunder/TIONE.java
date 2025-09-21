package Thunder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class TIONE {
    static ArrayList<Integer> ans = new ArrayList<>();

    public static void main(String[] args) {
         int n=3;
         int s=0;
         int t=2;
         int[] nodes_band = {20,15,25};
         int[][] eds={{0,1,15,10},{1,2,15,10},{0,2,15,5}};
         int d=10;
         find_min_delay_path(n,s,t,nodes_band,eds,d);
    }
    public static int find_min_delay_path(int n, int s, int t, int[] node_bandwidths, int[][] edges, int d) {
        // write code here
        HashMap<Integer, ArrayList<Edge>> map = new HashMap<Integer, ArrayList<Edge>>();
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            if (edge[2] > d) {
                Edge temp=new Edge();
                temp.visited=false;
                temp.des=edge[1];
                temp.value=edge[3];
                int source=edge[0];
                if(map.containsKey(source)){
                    ArrayList<Edge> templist=map.get(source);
                    templist.add(temp);
                }else
                {
                    ArrayList<Edge> templist=new ArrayList<>();
                    templist.add(temp);
                    map.put(source, templist);
                }
            }
        }

        DFS(s,0,t,map,d,node_bandwidths);
        if(ans.size()==0)
        {
           return -1;
        }else
        {
            Collections.sort(ans);
            return ans.get(0);
        }

    }

    static class Edge
    {
        int des;
        int value;
        boolean visited;
    }

    public static void DFS(int curNode,int curDelay,int des,HashMap<Integer, ArrayList<Edge>> map,int d,int[] node_bandwidths)
    {
        if(curNode== des&&node_bandwidths[curNode]>=d)
        {
            ans.add(curDelay);

            return;
        }
        if(node_bandwidths[curNode]<d)
        {

            return;
        }


        ArrayList<Edge> edges = map.get(curNode);
        for(int i=0;i<edges.size();i++)
        {
            Edge e=edges.get(i);
            if(e.visited==false&&e.value>=d)
            {
                e.visited=true;
                DFS(e.des,curDelay+e.value,des,map,d,node_bandwidths);
                e.visited=false;
            }

        }

    }
}
