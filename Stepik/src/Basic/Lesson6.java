package Basic;

public class Lesson6 {
    public static void main(String[] args) {
        float[] y = new float[100];
        float k = 0.5f, b = 2.0f;
        for (int x = 0; x < 100; ++x) {
            y[x] = k * x + b;
            System.out.print(y[x] + " ");
        }
        System.out.println();
        
        int[] powers = {1, 2, 4, 6};  // То же что int[] powers = new int[] {1, 2, 4, 6}
        for (int i = 0; i < powers.length; i++) System.out.print(powers[i] + " ");
        System.out.println(powers[powers.length-1]);

        final int N = 10;
        int[][] squareMatrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if ( i == j) squareMatrix[i][j] = 1; else squareMatrix[i][j] = 0;
                System.out.print(squareMatrix[i][j] + " ");
            }
            System.out.print("\n");
        }

        short z[][] = new short[5][];
        z[0] = new short[3];
        z[1] = new short[4];
        z[2] = new short[2];
        z[3] = new short[3];
        z[4] = new short[1];
        short count = 1;
        for (int i = 0; i < z.length; i++) {
            for (int j = 0; j < z[i].length; j++) {
                z[i][j] = count++;
            }
        }
        for (int i = 0; i < z.length; i++) {
            for (short val : z[i]) System.out.print(val + " ");
            System.out.println();
        }

        final int M = 9;
        short a[] = new short[M];
        for (int i = 0; i < M; ++i) a[i] = (short) (i + 1);
        for (int i = 5; i < M-1; ++i) a[i] = a[i+1];
        for (short val : a) System.out.print(val + " ");
        System.out.println();

        short[] c = {1, 2, 3, 5, 6, 7, 8, 9, 9};
        for (int i = 8; i > 3; --i) c[i] = c[i-1];
        c[3] = 4;
        for (short val : c) System.out.print(val + " ");
        System.out.println();

        short d[] = {3, 5, 1, 6, 2, 4};
        for (short val : d) System.out.print(val + " ");
        System.out.println();
        for (int i = 0; i < d.length - 1; i++) {
            short min = d[i];
            int pos = i;

            for (int j = i+1; j < d.length; j++) {
                if (min < d[j]) {
                    pos = j;
                    min = d[j];
                }
            }

            short t = d[i];
            d[i] = d[pos];
            d[pos] = t;
        }
        for (short val : d) System.out.print(val + " ");
        System.out.println();
    }
}
