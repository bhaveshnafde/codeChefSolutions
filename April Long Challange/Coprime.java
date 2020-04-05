// Java implementation of the approach
class Coprime
{

static int MAXN = 1000001;

// Stores smallest prime factor for every number
static int[] spf = new int[MAXN];

// Hash to store prime factors count
static int[] hash1 = new int[MAXN];

// Function to calculate SPF (Smallest Prime Factor)
// for every number till MAXN
static void sieve()
{
	spf[1] = 1;
	for (int i = 2; i < MAXN; i++)

		// Marking smallest prime factor for every
		// number to be itself
		spf[i] = i;

	// Separately marking spf for every even
	// number as 2
	for (int i = 4; i < MAXN; i += 2)
		spf[i] = 2;

	// Checking if i is prime
	for (int i = 3; i * i < MAXN; i++)
	{

		// Marking SPF for all numbers divisible by i
		if (spf[i] == i)
		{
			for (int j = i * i; j < MAXN; j += i)

				// Marking spf[j] if it is not
				// previously marked
				if (spf[j] == j)
					spf[j] = i;
		}
	}
}

// Function to store the prime factors after dividing
// by the smallest prime factor at every step
static void getFactorization(int x)
{
	int temp;
	while (x != 1)
	{
		temp = spf[x];
		if (x % temp == 0)
		{

			// Storing the count of
			// prime factors in hash
			hash1[spf[x]]++;
			x = x / spf[x];
		}
		while (x % temp == 0)
			x = x / temp;
	}
}

// Function that returns true if there are
// no common prime factors between x
// and other numbers of the array
static boolean check(int x)
{
	int temp;
	while (x != 1)
	{
		temp = spf[x];

		// Checking whether it common
		// prime factor with other numbers
		if (x % temp == 0 && hash1[temp] > 1)
			return false;
		while (x % temp == 0)
			x = x / temp;
	}
	return true;
}

// Function that returns true if there is
// an element in the array which is coprime
// with all the other elements of the array
static boolean hasValidNum(int []arr, int n)
{

	// Using sieve for generating prime factors
	sieve();

	for (int i = 0; i < n; i++)
		getFactorization(arr[i]);

	// Checking the common prime factors
	// with other numbers

	for (int i = 0; i < n; i++)
		if (check(arr[i])){
      System.out.println(arr[i]);
      //return true;
    }

	return false;
}


/* arr[]  ---> Input Array
data[] ---> Temporary array to store current combination
start & end ---> Staring and Ending indexes in arr[]
index  ---> Current index in data[]
r ---> Size of a combination to be printed */
static void combinationUtil(int arr[], int n, int r,
                      int index, int data[], int i)
{
    // Current combination is ready to be printed,
    // print it
    if (index == r) {
        for (int j = 0; j < r; j++)
            System.out.print(data[j] + " ");
        System.out.println("");
        return;
    }
    hasValidNum(arr, n)
    // When no more elements are there to put in data[]
    if (i >= n)
        return;

    // current is included, put next at next
    // location
    data[index] = arr[i];
    combinationUtil(arr, n, r, index + 1,
                           data, i + 1);

    // current is excluded, replace it with
    // next (Note that i+1 is passed, but
    // index is not changed)
    combinationUtil(arr, n, r, index, data, i + 1);
}

// The main function that prints all combinations
// of size r in arr[] of size n. This function
// mainly uses combinationUtil()
static void printCombination(int arr[], int n, int r)
{
    // A temporary array to store all combination
    // one by one
    int data[] = new int[r];

    // Print all combination using temprary
    // array 'data[]'
    combinationUtil(arr, n, r, 0, data, 0);
}

public static void main(String[] args)
{
    int arr[] = {1,2,3,4,5}; 
    int r = 3;
    int n = arr.length;
    printCombination(arr, n, r);
}

}

// This code is contributed by chandan_jnu
