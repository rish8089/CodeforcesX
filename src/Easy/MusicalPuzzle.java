//package Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class MusicalPuzzle {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            String s=br.readLine();
            HashSet<String> set=new HashSet<>();
            for(int i=n-2;i>=0;i--){
                set.add(s.substring(i,i+2));
            }
            System.out.println(set.size());
            t--;
        }
    }
}
