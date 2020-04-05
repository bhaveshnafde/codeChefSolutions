/*

Strange Number Problem Code: STRNO

When Varsha was travelling home, she saw a mysterious villa. Varsha is curious about this strange villa and wants to explore it. When she reached the entry gate, the guard gave her a problem to solve and said that he would allow her to enter the villa only if she solved it.

The guard gave Varsha two integers X
and K. Varsha needs to determine whether there is an integer A such that it has exactly X positive integer divisors and exactly K

of them are prime numbers.

Varsha found this problem really hard to solve. Can you help her?
Input

    The first line of the input contains a single integer T

denoting the number of test cases. The description of T
test cases follows.
The first and only line of each test case contains two space-separated integers X
and K

    .

Output

For each test case, print a single line containing one integer: 1
if a valid integer A exists or 0

if it does not exist.
Constraints

    1≤T≤103

1≤X,K≤109

Subtasks

Subtask #1 (15 points):

    T≤100

K≤2

Subtask #2 (85 points): original constraints
Example Input

1
4 2

Example Output

1

Explanation

Example case 1: A=6
has X=4 factors: 1, 2, 3 and 6. It also has exactly K=2 prime factors: 2 and 3.
\*/
import java.io.*;
import java.util.*;
class Codechef{


  bool IsPrime(int number)
  {
     int root = sqrt(number) ;
     for(int i=2; i<=root; i++)
     {
        if(number%i == 0)
            return false;
     }
     return true;
  }

  public static int count(int x, int k){
    int ct = 0;
    for(int i = 1;)
  }

  public static void main(String[] args) throws Exception{
    try{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    while(t-->0){
      String s[] = br.readLine().split(" ");
      int x = Integer.parseInt(s[0]);
      int k = Integer.parseInt(s[1]);
      System.out.println(count(x, k));
    }
  }catch(Exception E){

  }
  }
}
