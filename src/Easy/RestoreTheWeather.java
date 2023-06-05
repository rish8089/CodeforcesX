//package Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class RestoreTheWeather {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            String []nk=br.readLine().split(" ");
            int n=Integer.parseInt(nk[0]);
            ArrayList<Node> A=new ArrayList<>();
            ArrayList<Node> B=new ArrayList<>();
            String []str=br.readLine().split(" ");
            for(int i=0;i<n;i++)
                A.add(new Node(Integer.parseInt(str[i]),i));
            str=br.readLine().split(" ");
            for(int i=0;i<n;i++)
                B.add(new Node(Integer.parseInt(str[i]),i));
            Collections.sort(A,(nd1,nd2)->Integer.compare(nd1.val,nd2.val));
            Collections.sort(B,(nd1,nd2)->Integer.compare(nd1.val,nd2.val));
            int []res=new int[n];
            for(int i=0;i<A.size();i++){
                res[A.get(i).idx]=B.get(i).val;
            }
            StringBuilder ans=new StringBuilder();
            for(int i=0;i<n;i++)
                ans.append(res[i]).append(" ");
            System.out.println(ans);
            t--;
        }
    }
    static class Node{
        int val;
        int idx;
        Node(int val, int idx){
            this.val=val;
            this.idx=idx;
        }
    }
}
