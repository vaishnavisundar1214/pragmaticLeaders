import java.util.Scanner;
import java.util.Arrays;

public class Main {
    static int max_ref;

    static int _lis(int arr[], int n) {
        if (n == 1)
            return 1;
        int res, max_ending_here = 1;
        for (int i = 1; i < n; i++) {
            res = _lis(arr, i);
            if (arr[i - 1] < arr[n - 1] && res + 1 > max_ending_here)
                max_ending_here = res + 1;
        }
        if (max_ref < max_ending_here)
            max_ref = max_ending_here;

        return max_ending_here;
    }

    static int lis(int arr[], int n) {
        max_ref = 1;
        _lis(arr, n);

        return max_ref;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(
                lis(arr, n));
    }
}
