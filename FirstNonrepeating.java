//code taken from with slight modification-- https://www.geeksforgeeks.org/given-a-string-find-its-first-non-repeating-character/
/*
 * Make a count array instead of hash_map of maximum number of characters(256). We can augment the count 
 * array by storing not just counts but also the index of the first time you encountered the character 
 * e.g. (3, 26) for ‘a’ meaning that ‘a’ got counted 3 times and the first time it was seen is at position 26. So when
 *  it comes to finding the first non-repeater, we just have to scan the count array, instead of the string.
 *   Thanks to Ben for suggesting this approach.
 * 
 * 
 */

/*
 * Given a string, find its first non-repeating character
Last Updated: 22-07-2020
Given a string, find the first non-repeating character in it. For example, if the input string is “GeeksforGeeks”, 
then the output should be ‘f’ and if the input string is “GeeksQuiz”, then the output should be ‘G’.
 * 
 * 
 * 
 */
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class CountIndex { 
    @Override
	public String toString() {
		return "CountIndex [count=" + count + ", index=" + index + "]";
	}

	int count, index; 
  
    // constructor for first occurrence 
    public CountIndex(int index) 
    { 
        this.count = 1; 
        this.index = index; 
    } 
  
    // method for updating count 
    public void incCount() 
    { 
        this.count++; 
    } 
} 
public class FirstNonrepeating {
	static final int NO_OF_CHARS = 26; 
	  
    static HashMap<Character, CountIndex> hm 
        = new HashMap<Character, CountIndex>(NO_OF_CHARS); 
  
    /* calculate count of characters  
       in the passed string */
    static void getCharCountArray(String str) 
    { 
        for (int i = 0; i < str.length(); i++) { 
            // If character already occurred, 
            if (hm.containsKey(str.charAt(i))) { 
                // updating count 
                hm.get(str.charAt(i)).incCount(); 
            } 
  
            // If it's first occurrence, then store 
            // the index and count = 1 
            else { 
                hm.put(str.charAt(i), new CountIndex(i)); 
            } 
        }
        System.out.println(hm);
    } 
    
    static int firstNonRepeating(String str) 
    { 
        getCharCountArray(str); 
        int result = -1;
        for (Map.Entry<Character, CountIndex> entry : hm.entrySet()) 
        { 
            int c=entry.getValue().count; 
            int ind=entry.getValue().index; 
            if(c==1 ) 
            { 
                return ind;
            } 
        } 
        
  
        return result; 
    } 
    public static void main(String[] args) {
        String str = "asgsadgtug"; 
        int index = firstNonRepeating(str); 
        if (index != -1)
        	System.out.println("First non repeating is "+str.charAt(index));
        else
        	System.out.println("NO");
      
  

}
}
