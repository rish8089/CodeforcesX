//package Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class KsyushaAndChinchilla {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            ArrayList<ArrayList<Edge>> adj=new ArrayList<>();
            for(int i=0;i<n;i++)
                adj.add(new ArrayList<>());
            for(int i=1;i<n;i++){
                String []uv=br.readLine().split(" ");
                int u=Integer.parseInt(uv[0]);
                int v=Integer.parseInt(uv[1]);
                u--;
                v--;
                adj.get(u).add(new Edge(v,i));
                adj.get(v).add(new Edge(u,i));
            }
            ArrayList<Integer> ans=new ArrayList<>();
            int res=solve(adj,1,new HashSet<>(),ans);
            if(res!=0)
                System.out.println(-1);
            else{
                System.out.println(ans.size());
                StringBuilder sb=new StringBuilder();
                for(int i=0;i<ans.size();i++)
                    sb.append(ans.get(i)).append(" ");
                System.out.println(sb);
            }
            t--;
        }
    }
    private static int solve(ArrayList<ArrayList<Edge>> adj, int u, HashSet<Integer> visited, ArrayList<Integer> ans){
        visited.add(u);
        int resSum=0;
        for(int i=0;i<adj.get(u).size();i++){
            Edge e=adj.get(u).get(i);
            if(!visited.contains(e.v)) {
                int res = solve(adj, e.v, visited,ans);
                if(res==-1)
                    return -1;
                else if(res==0)
                    ans.add(e.idx);
                else
                    resSum+=res;
            }
        }
        if(resSum>2)
            return -1;
        else
            return (resSum+1)%3;
    }
    static class Edge{
        int v;
        int idx;
        Edge(int v, int idx){
            this.v=v;
            this.idx=idx;
        }
    }
}
