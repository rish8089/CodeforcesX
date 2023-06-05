//package Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Flipper {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String []str=br.readLine().split(" ");
            int []a=new int[n];
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(str[i]);
            if(n==1)
                System.out.println(1);
            else{
                int pivot;
                if(a[0]!=n){
                    pivot=n;
                }else
                    pivot=n-1;
                ArrayList<Integer> res=movePivotToStart(a,pivot);
                StringBuilder ans=new StringBuilder();
                for(int i=0;i<res.size();i++)
                    ans.append(res.get(i)).append(" ");
                System.out.println(ans);
            }
            t--;
        }
    }
    private static ArrayList<Integer> movePivotToStart(int []a, int pivot){
        ArrayList<Integer> res=new ArrayList<>();
        //find pivot pos
        int n=a.length;
        int pos=0;
        for(int i=0;i<n;i++){
            if(a[i]==pivot){
                pos=i;
                break;
            }
        }
        for(int i=pos;i<n;i++)
            res.add(a[i]);
        int i=0;
        int j;
        if(pos!=n-1) {
            res.add(a[pos - 1]);
            j=pos-2;
        }else
            j=pos-1;
        while(i<j && a[i]<a[j]){
            res.add(a[j]);
            j--;
        }
        while(i<=j){
            res.add(a[i]);
            i++;
        }
        return res;
    }
}
