import java.io.*;
import java.util.*;

class Codechef{

    public static void main(String[] args) {
      try{
        InputReader in = new InputReader(System.in);
        PrintWriter w = new PrintWriter(System.out);

        int t = in.nextInt();

        while (t-- > 0) {
            int nm[] = in.nextIntArray(2);
            int n = nm[0];
            int S = nm[1];
            int arr[] = new int[n];
            int pl[] = new int[n];
            arr = in.nextIntArray(n);
            pl = in.nextIntArray(n);
            if(ffl(arr, pl, n, S)){
              w.println("yes");
            }else{
              w.println("no");
            }
        }
        w.close();
      }catch(Exception E){}
    }

    static boolean ffl(int arr[], int pl[], int n, int S){

      int dmin = -1;
      int fmin = -1;
      for(int i = 0; i < n; i++){
        if(pl[i] == 0){
          dmin = arr[i];
        }
        if(pl[i] == 1){
          fmin = arr[i];
        }
      }
      if(fmin == -1 || dmin == -1){
        return false;
      }

      for(int i = 0; i < n; i++){
        if(pl[i] == 0){
          dmin = Math.min(dmin, arr[i]);
        }else{
          fmin = Math.min(fmin, arr[i]);
        }
      }
      int sum = S + (fmin + dmin);
      //System.out.println(dmin+" "+fmin+" "+sum);

      if(sum <= 100){
        return true;
      }else{
        return false;
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
