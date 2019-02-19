

public class ActivitySelection {
	// Prints a maximum set of activities that can be done by a single
	// person, one at a time.
	// n --> Total number of activities
	// s[] --> An array that contains start time of all activities
	// f[] --> An array that contains finish time of all activities
	public static void printMaxActivities(int s[], int f[], int n) {
		int i, j;

		System.out.print("Following activities are selected : ");

		// The first activity always gets selected
		i = 0;
		System.out.print(i + " ");

		// Consider rest of the activities
		for (j = 1; j < n; j++) {
			// If this activity has start time greater than or
			// equal to the finish time of previously selected
			// activity, then select it
			if (s[j] >= f[i]) {
				System.out.print(j + " ");
				i = j;
			}
		}
	}

	// driver program to test above function
	public static void main(String[] args) {
		int s[]  =  {10, 12, 20};
	    int f[] =   {20, 25, 30};
		int n = s.length;

		printMaxActivities(s, f, n);
	}

}
