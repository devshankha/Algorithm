//count the number of BST that can be formed with
//n distinct keys
// code is taken from https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/CountNumberOfTreesInBST.java
public class CountNumberOfTreesInBST {
	public static int countTrees(int n){
        int T[] = new int[n+1];
        T[0] = 1;
        T[1] = 1;
        for(int i=2; i <= n; i++){
            for(int j=0; j <i; j++){
                T[i] += T[j]*T[i-j-1];
            }
        }
        return T[n];
    }
	public static void main(String[] args) {
		System.out.println(CountNumberOfTreesInBST.countTrees(4));
	}

}
