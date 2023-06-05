//package Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class IraAndFlamenco {
    static int MOD=(int)1e9+7;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            String []nm=br.readLine().split(" ");
            int n=Integer.parseInt(nm[0]);
            int m=Integer.parseInt(nm[1]);
            String []str=br.readLine().split(" ");
            ArrayList<Integer> a=new ArrayList<>();
            for(int i=0;i<n;i++)
                a.add(Integer.parseInt(str[i]));
            HashMap<Integer,Integer> mp=new HashMap<>();
            for(int i=0;i<n;i++){
                if(!mp.containsKey(a.get(i)))
                    mp.put(a.get(i),1);
                else
                    mp.put(a.get(i),mp.get(a.get(i))+1);
            }
            ArrayList<Node> list=new ArrayList<>();
            for(Integer key:mp.keySet()){
                list.add(new Node(key,mp.get(key)));
            }
            Collections.sort(list,(nd1,nd2)->Integer.compare(nd1.val, nd2.val));
            int []pp=new int[list.size()];
            for(int i=0;i<list.size();i++)
                pp[i]=(int)(((long)list.get(i).duplicates*(i-1>=0?pp[i-1]:1))%MOD);

            //final traversal
            long ans=0;
            for(int i=0;i<list.size();i++){
                if(i+m-1<list.size() && list.get(i+m-1).val-list.get(i).val<m){
                    int prod=(int)((pp[i+m-1]*(i-1>=0?mypow(pp[i-1],MOD-2):1))%MOD);
                    ans=(ans+prod)%MOD;
                }
            }
            System.out.println(ans);
            t--;
        }
    }
    private static long mypow(long a, int b){
        long res=1;
        while(b>0){
            if(b%2!=0)
                res=(res*a)%MOD;
            b=b/2;
            if(b>0)
                a=(a*a)%MOD;
        }
        return res;
    }
    static class Node{
        int val;
        int duplicates;
        Node(int val, int duplicates){
            this.val=val;
            this.duplicates=duplicates;
        }
    }
}
