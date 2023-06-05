//package Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VladBuildingBeautifulArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = Integer.parseInt(str[i]);
            int min = -1;
            for (int i = 0; i < n; i++) {
                if (min == -1 || min > a[i])
                    min = a[i];
            }
            if (min % 2 != 0)
                System.out.println("YES");
            else {
                boolean allEven = true;
                for (int i = 0; i < n; i++) {
                    if (a[i] % 2 != 0) {
                        allEven = false;
                        break;
                    }
                }
                System.out.println(allEven ? "YES" : "NO");
            }
            t--;
        }
    }

}
