import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Piyush Baderia
 * @project Examples
 * @date 12/7/2017
 */
public class BackendAssignment {
    int[] arrA;

    public BackendAssignment(int n) {
        arrA = new int[n];
    }
    public ArrayList<String> str=new ArrayList<String>();
    public void bitStrings(int n) {
        if (n <= 0) {
            str.add(Arrays.toString(arrA));
        } else {
            arrA[n - 1] = 0;
            bitStrings(n - 1);
            arrA[n - 1] = 1;
            bitStrings(n - 1);
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int w=0;w<t;w++) {
            int[] n = new int[t];
            for(int p=0;p<t;p++)
            {
                n[p]=sc.nextInt();
            }
            for(int r=0;r<t;r++) {
                BackendAssignment i = new BackendAssignment(n[r]);
                int j = 0;
                i.bitStrings(n[r]);
                ArrayList<String> arr = new ArrayList<String>();
                for (int k = 0; k < i.str.size(); k++) {
                    String z = i.str.get(k);
                    z = z.replaceAll("\\[", "");
                    z = z.replaceAll(", ", "");
                    z = z.replaceAll("]", "");
                    //System.out.println(z);
                    arr.add(z);
                }
                for (int k = 0; k < arr.size(); k++) {
                    if (!(arr.get(k).contains("00"))) {
                        j++;
                        j = j % 1000000007;
                    }
                }

                System.out.println(j);
            }
        }
    }

}
