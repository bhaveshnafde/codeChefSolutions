import java.io.*;
import java.util.*;

class Codechef{

    static boolean sorted(int arr[], int n)
    {
      // Array has one or no element
      if (n == 0 || n == 1)
          return true;

      for (int i = 1; i < n; i++)

          // Unsorted pair found
          if (arr[i - 1] > arr[i])
              return false;

      // No unsorted pair found
      return true;
    }

    public static void trplsort(int arr[], int n, int k){
      int a=-1,b=-1,c=-1;
      for(int i = 0; i < n; i++){
        if(arr[i] != i+1){
          if(a == -1){
            a = i;
          }else if(b == -1){
            b = i;
          }else if(c == -1){
            c = i;
          }else{
            System.out.println(-1);
            return;
          }
        }
      }
      System.out.println(a+" "+b+" "+c);
      String st = "";
      int m = 0;
      int trp[] = new int[3];
      trp[0] = arr[a];
      trp[1] = arr[b];
      trp[2] = arr[c];
      for(int j = 0; j < k; j++){
        int temp = trp[2];
        trp[2] = trp[1];
        trp[1] = trp[0];
        trp[0] = temp;
        for(int i = 0; i < 3; i++){
          st += trp[i];
          st += " ";
        }
        m++;
        if(sorted(trp, 3)){
          System.out.println(m);
          break;
        }
        st += "\n";
      }
      System.out.println(st);
    }

    public static void main(String[] args) {
      try{
        InputReader in = new InputReader(System.in);
        PrintWriter w = new PrintWriter(System.out);

        int t = in.nextInt();

        while (t-- > 0) {
            int arr[] = new int[2];
            arr = in.nextIntArray(2);
            int n = arr[0];
            int k = arr[1];
            int a[] = new int[n];
            a = in.nextIntArray(n);
            trplsort(a, n, k);
        }

        w.close();
      }catch(Exception E){
        System.out.println(E);
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
