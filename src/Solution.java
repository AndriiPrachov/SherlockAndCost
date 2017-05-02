import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        for (int testCaseNumber = 0; testCaseNumber < t; testCaseNumber++) {
            int n = in.nextInt();
            int[] arrayB = new int[n];
            for (int i = 0; i < n; i++) {
                arrayB[i] = in.nextInt();
            }

            System.out.println(solve(arrayB, n));
        }
    }

    private static int solve(int[] arrayB, int n) {
        int[] sums = new int[2];

        int[] arrayA1 = fillArrayA(arrayB, n, true);
        int[] arrayA2 = fillArrayA(arrayB, n, false);

        int sum1 = 0;
        for (int i = 1; i < n; i++) {
            sum1 += Math.abs(arrayA1[i] - arrayA1[i - 1]);
        }

        int sum2 = 0;
        for (int i = 1; i < n; i++) {
            sum2 += Math.abs(arrayA2[i] - arrayA2[i - 1]);
        }

        return Math.max(sum1, sum2);
    }

    private static int[] fillArrayA(int[] arrayB, int n, boolean biggest) {
        int[] arrayA = new int[n];

        for (int i = 0; i < n; i++) {
            if (biggest) {
                arrayA[i] = arrayB[i];
                biggest = false;
            } else {
                arrayA[i] = 1;
                biggest = true;
            }
        }

        return arrayA;
    }
}
