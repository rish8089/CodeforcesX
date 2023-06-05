//package Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class RoundDance {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String []str=br.readLine().split(" ");
            int []a=new int[n];
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(str[i]);
            int loops=0;
            int nonloops=0;
            ArrayList<HashSet<Integer>> adj=new ArrayList<>();
            for(int i=0;i<n;i++)
                adj.add(new HashSet<>());
            for(int i=0;i<n;i++){
                int u=i;
                int v=a[i]-1;
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            boolean []visited=new boolean[n];
            for(int i=0;i<n;i++){
                if(!visited[i]) {
                    boolean res=isCycle(i, visited, -1, adj);
                    if(res)
                        loops+=1;
                    else
                        nonloops+=1;
                }
            }
            System.out.format("%d %d\n", loops+(nonloops>0?1:0), loops+nonloops);
            t--;
        }
    }
    private static boolean isCycle(int u, boolean []visited, int parent, ArrayList<HashSet<Integer>> adj){
        visited[u]=true;
        for(Integer v:adj.get(u)){
            if(!visited[v]){
                boolean res=isCycle(v,visited,u,adj);
                if(res)
                    return true;
            }else{
                if(v!=parent)
                    return true;
            }
        }
        return false;
    }
}
