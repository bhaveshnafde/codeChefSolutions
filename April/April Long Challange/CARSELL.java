/*

Sell All the Cars Problem Code: CARSELL
Submit
Tweet
Read problem statements in Hindi, Bengali, Mandarin Chinese, Russian, and Vietnamese as well.

Chef owns N
cars (numbered 1 through N). He wishes to sell all of them over N years by selling exactly one car per year. For each valid i, the initial price of the i-th car is Pi. Due to depreciation, the price of each car decreases by 1

unit per year until it is sold.

Note that the price of a car cannot drop below 0
no matter how many years have passed, i.e. when the price of a car reaches 0 in some year, it remains 0

in all subsequent years.

Find the maximum profit Chef can make if he sells his cars in an optimal way. Since this number may be large, compute it modulo 1,000,000,007
(109+7

).
Input

    The first line of the input contains a single integer T

denoting the number of test cases. The description of T
test cases follows.
The first line of each test case contains a single integer N
.
The second line contains N
space-separated integers P1,P2,…,PN

    .

Output

For each test case, print a single line containing one integer ― the maximum profit Chef can make, modulo 1,000,000,007

.
Constraints

    1≤T≤25

1≤N≤105
0≤Pi≤109
for each valid i

Subtasks

Subtask #1 (30 points): N≤2⋅103

Subtask #2 (70 points): original constraints
Example Input

2
3
6 6 6
3
0 1 0

Example Output

15
1

Explanation

Example case 1:

    During the first year, Chef's profit so far is 0

and the prices of the cars are [6,6,6]
. Chef sells one of these cars.
During the second year, Chef's profit so far is 6
and the prices of the remaining cars are [5,5]
. Again, Chef sells one of these cars.
During the third year, Chef's profit so far is 11
and there is one car with price 4
. Chef sells this car.
In the fourth year, Chef has sold all of his cars and his profit is 15

    . This is the maximum profit he can make.

Example case 2:

    During the first year, Chef's profit so far is 0

and the prices of the cars are [0,1,0]
. Chef sells the second car.
During the second year, Chef's profit so far is 1
and the prices of the remaining cars are [0,0]
. Chef sells one of these cars.
During the third year, Chef's profit so far is 1
and there is one car with price 0
. Chef sells this car.
During the fourth year, Chef has sold all his cars and his profit is 1
.
*/
import java.io.*;
import java.util.*;
class Codechef{



  public static void carSell(ArrayList<Long> arr, long n){
    Collections.sort(arr);
    long profit = 0;
    long cut = 0;
    while(n-->0){
      long pr = arr.remove(arr.size() - 1) - cut;
      if(pr >= 0){
        profit += pr;
      }
      cut++;
      profit %= 1000000007;
    }
    //System.out.println(arr);
    System.out.println(profit);
  }

  public static void main(String[] args) throws Exception{
    try{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long t = Long.parseLong(br.readLine());
    while(t-->0){
      int n = Integer.parseInt(br.readLine());
      ArrayList<Long> arr = new ArrayList<Long>(n);
      String s[] = br.readLine().split(" ");
      for(int i = 0 ; i < n; i++){
        arr.add(Long.parseLong(s[i]));
      }
      carSell(arr, n);
    }
  }catch(Exception e){

  }
  }
}
