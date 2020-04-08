import java.io.*;
import java.util.*;
import java.math.BigInteger;

class Codechef{

    static boolean isGood(int n){
      //System.out.println(n);
        if(n%2 != 0){
          return true;
        }
        for (int i=1; i<=Math.sqrt(n); i++)
        {
            if (n%i==0)
            {
              double z = n + (i*i);
              double y = Math.sqrt(z);
              if(((y - Math.floor(y)) == 0)){
                int a = (int)y;
                //System.out.print("    "+i+" - "+z+" - "+a);
                if((a+i)*(a-i) == n){
                  return true;
                }
              }
            }
        }
        return false;
    }

    static int sqrdsub(int a[], int n){
        int count = 0;
        for (int i = 1; i <= n ; i++)
        {
            for (int j = 0; j < k; j++)
            {
                int sum = 1;
                for (int k=i; k<=j; k++){
                    sum *= a[k];
                }
                if(isGood(sum))
                      count++;

            }

        }
        return count;
    }

    public static void main(String[] args) {
      try{
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
      }catch(Exception e){

      }
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
