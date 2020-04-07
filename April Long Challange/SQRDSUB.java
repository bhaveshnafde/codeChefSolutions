import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class SQRDSUB{



    static boolean isGood(ArrayList<Integer> arrli){
        int n = 1;
        //System.out.print("\n"+arrli);
        while(!arrli.isEmpty()){
          n *= arrli.remove(0);
        }
        //System.out.print(" : "+n);
        for (long i = 1; i <= n; i++)
          for (long j = 0; j < i; j++){
                //System.out.println(" "+i + "^2 - "+ j + "^2 = "+Math.abs(j * j - i * i));
                if (Math.abs(j * j - i * i) == n) {
                    //System.out.print(" "+i + "^2 - "+ j + "^2 = "+Math.abs(j * j - i * i));
                    return true;
                }
          }

        return false;
    }

    static int sqrdsub(int a[], int n){
        ArrayList<Integer> arrli = new ArrayList<Integer>();
        int count = 0;
        for (int i=0; i <n; i++)
        {
            for (int j=i; j<n; j++)
            {
                arrli.clear();
                for (int k=i; k<=j; k++){
                    arrli.add(a[k]);
                }
                if(isGood(arrli))
                      count++;

            }

        }
        return count;
    }

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter w = new PrintWriter(System.out);

        int t = in.nextInt();
        int res[] = new int[t];
        int i = 0;
        while (t-- > 0) {
            int n = in.nextInt();
            int a[] = new int[n];
            a = in.nextIntArray(n);
            res[i++] = sqrdsub(a, n);
        }
        for (int x : res) {
          w.println(x);
        }

        w.close();
    }

    static class InputReader {

        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int snext() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nextLong() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int[] nextIntArray(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        public String readString() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public String nextLine() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
}
