import java.io.*;
import java.util.*;
import java.math.*;

class Codechef{


		static int gcd(int a, int b)
    {
        // Everything divides 0
        if (a == 0 || b == 0)
            return 0;

        // base case
        if (a == b)
            return a;

        // a is greater
        if (a > b)
            return gcd(a-b, b);

        return gcd(a, b-a);
    }

		static boolean coprime(int a, int b) {

			if ( gcd(a, b) == 1)	return true;

			else	return false;
		}

		public static void pair(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> x){
			int n = arr.size();
			if(n == 1){
				x.add(arr);
				return;
			}
			for (int i = 0; i < n; i++)
			 {
					 for (int j = i+1; j < n; j++)
					 {

							 if(!coprime(arr.get(i),arr.get(j)))	return;
					 }
			 }
			 x.add(arr);
		}

    public static void unitgcd(int n) {
			ArrayList<Integer> arrli = new ArrayList<Integer>();
			for(int i = 1; i <= n; i++) {
				arrli.add(i);
			}
			int opsize = (int)Math.pow(2, n);
			ArrayList<Integer> arr = new ArrayList<Integer>();
			ArrayList<ArrayList<Integer>> x = new ArrayList<ArrayList<Integer>>();
			for (int counter = 1; counter < opsize; counter++)
			{
					arr.clear();
					for (int j = 0; j < n; j++)
					{
							if (BigInteger.valueOf(counter).testBit(j))
									arr.add(arrli.get(j));
					}
					pair(arr, x);
			}
			System.out.println(x);

    }

    public static void main(String[] args) {
      try{
        InputReader in = new InputReader(System.in);
        PrintWriter w = new PrintWriter(System.out);
        int t = in.nextInt();
        while (t-- > 0) {
					int n = in.nextInt();
					unitgcd(n);
					//System.out.println(x);
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
