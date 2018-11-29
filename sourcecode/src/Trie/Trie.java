package Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class TrieNode {
	private char value;
	private HashMap<Character, TrieNode> children;
	private boolean bIsEnd;
	public TrieNode(char ch) {
		value = ch;
		children = new HashMap<>();
		bIsEnd = false;
	}
	public HashMap<Character, TrieNode> getChildren() {
		return children;
	}
	public char getValue() {
		return value;
	}

	public void setIsEnd(boolean val) {
		bIsEnd = val;
	}
	public boolean isEnd() {
		return bIsEnd;
	}

}

public class Trie {
	private TrieNode root; 
	public Trie()   {    
		root = new TrieNode((char)0);      
		}
	
	public void print (){
		HashMap<Character, TrieNode> children = root.getChildren();
		Iterator iter = children.entrySet().iterator();
		List al = new ArrayList();
		while (iter.hasNext()) {
			// this starts
			while (true){
				StringBuffer s1 = new StringBuffer("");
				System.out.println("First time");
				Map.Entry me = (Entry) iter.next();
				Character c = (Character) me.getKey();
				TrieNode node = (TrieNode) me.getValue();
				s1.append(c);
				if (node.isEnd()) {
					al.add(s1.toString());
					break;
				}				
				
			} // this ends		
			
			
		}
		System.out.println("Printing the list "+al);
	}
	   
    // Method to insert a new word to Trie
    public void insert(String word) throws Exception  {
           
        // Find length of the given word
        int length = word.length();        
        TrieNode crawl = root;
           
        // Traverse through all characters of given word
        for( int level = 0; level < length; level++)
        {
            HashMap<Character,TrieNode> child = crawl.getChildren();            
            char ch = word.charAt(level);
      
               
            // If there is already a child for current character of given word 
            if( child.containsKey(ch))
                crawl = child.get(ch);
            else   // Else create a child
            {              
                TrieNode temp = new TrieNode(ch);
                child.put( ch, temp );
                crawl = temp;
            }
        }
           
        // Set bIsEnd true for last character
        crawl.setIsEnd(true);
    }
    public String getMatchingPrefix(String input)  {
        String result = ""; // Initialize resultant string
        int length = input.length();  // Find length of the input string       
           
        // Initialize reference to traverse through Trie
        TrieNode crawl = root;   
          
        // Iterate through all characters of input string 'str' and traverse 
        // down the Trie
        int level, prevMatch = 0; 
        for( level = 0 ; level < length; level++ )
        {    
            // Find current character of str
            char ch = input.charAt(level);    
              
            // HashMap of current Trie node to traverse down
            HashMap<Character,TrieNode> child = crawl.getChildren();                        
             
            // See if there is a Trie edge for the current character
            if( child.containsKey(ch) )
            {
               result += ch;          //Update result
               crawl = child.get(ch); //Update crawl to move down in Trie
                 
               // If this is end of a word, then update prevMatch
               if( crawl.isEnd() ) 
                    prevMatch = level + 1;
            }            
            else  break;
        }
          
        // If the last processed character did not match end of a word, 
        // return the previously matching prefix
        if( !crawl.isEnd() )
                return result.substring(0, prevMatch);        
         
        else return result;
    }
    public static void main(String[] args) throws Exception {
    	Trie dict = new Trie();        
        dict.insert("abc");
        dict.insert("afgk");
      
        String input = "abcklmn";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input)); 
        System.out.println((char)0);
	}

}  
