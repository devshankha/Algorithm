
public class Petrol
{
// A petrol pump has petrol and distance to next petrol pump
	static class petrolPump {
		int petrol;
		int distance;

		// constructor
		public petrolPump(int petrol, int distance) {
			this.petrol = petrol;
			this.distance = distance;
		}

	}

	// The function returns starting point if there is a possible solution,
	// otherwise returns -1
	static int printTour(petrolPump arr[], int n) {
		int start = 0;
		int end = 1;
		int curr_petrol = arr[start].petrol - arr[start].distance;

		// If current amount of petrol in truck becomes less than 0, then
		// remove the starting petrol pump from tour
		while (end != start || curr_petrol < 0) {

			// If current amount of petrol in truck becomes less than 0, then
			// remove the starting petrol pump from tour
			while (curr_petrol < 0 && start != end) {
				// Remove starting petrol pump. Change start
				curr_petrol -= arr[start].petrol - arr[start].distance;
				//below line will not work
				//for example 5,4//4,8//54,7//2,1
				//curr_petrol = 0;
				
				start = (start + 1) % n;

				// If 0 is being considered as start again, then there is no
				// possible solution
				if (start == 0)
					return -1;
			}
			// Add a petrol pump to current tour
			curr_petrol += arr[end].petrol - arr[end].distance;

			end = (end + 1) % n;
		}
		return start;
	}

	// Driver program to test above functions
	public static void main(String[] args) {

		petrolPump[] arr = { new petrolPump(5,4), new petrolPump(4,8), new petrolPump(54,7), new petrolPump(2,1) };

		int start = printTour(arr, arr.length);

		System.out.println(start == -1 ? "No Solution" : "Start = " + start);
	   /* int a = 15;
	    int b = 2;
	    int c = 3;
	    a-=b-c;
	    System.out.println(a);*/
	    		

	}

}
