import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

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

	protected List<String> allPrefixes(TrieNode root, String s, int i, List<String> l) {
		String strSoFar = s;
		if (i != 0)
			strSoFar += String.valueOf(root.getValue());
		if (root.isEnd()) {
			l.add(strSoFar);
			return l;
		}
		Stack<TrieNode> stack = new Stack<TrieNode>();
		Iterator<TrieNode> itr = root.getChildren().values().iterator();
		while (itr.hasNext()) {
			stack.add(itr.next());			
		}
		while (!stack.empty()) {
			TrieNode t = stack.pop();			
			allPrefixes(t, strSoFar, ++i, l);
		}		
		return l;
	}

}

public class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode((char) 0);
	}


	// Method to insert a new word to Trie
	public void insert(String word) throws Exception {

		// Find length of the given word
		int length = word.length();
		TrieNode crawl = root;

		// Traverse through all characters of given word
		for (int level = 0; level < length; level++) {
			HashMap<Character, TrieNode> child = crawl.getChildren();
			char ch = word.charAt(level);

			// If there is already a child for current character of given word
			if (child.containsKey(ch))
				crawl = child.get(ch);
			else // Else create a child
			{
				TrieNode temp = new TrieNode(ch);
				child.put(ch, temp);
				crawl = temp;
			}
		}

		// Set bIsEnd true for last character
		crawl.setIsEnd(true);
	}

	/// this is used to search elements in a trie
	public boolean search(String input) {
		boolean checkBool = true;
		int length = input.length();
		TrieNode crawl = root;

		// Iterate through all characters of input string 'str' and traverse
		// down the Trie
		int level = 0;
		boolean contains = false;
		for (level = 0; level < length; level++) {
			// Find current character of str
			char ch = input.charAt(level);

			// HashMap of current Trie node to traverse down
			HashMap<Character, TrieNode> child = crawl.getChildren();

			// See if there is a Trie edge for the current character
			if (child.containsKey(ch)) {
				crawl = child.get(ch);
				continue;
			} else {
				checkBool = false;
				System.out.println("IT SHOULD COME HERE");
				break;
			}
		}

		if (crawl.isEnd() && checkBool)
			contains = true;
		return contains;
	}

	public void printTrie(TrieNode node, String s) {
		String strSoFar = s;
		strSoFar += String.valueOf(node.getValue());
		if (node.isEnd()) {
			System.out.println(strSoFar);
			return;
		}

		Stack<TrieNode> stack = new Stack<TrieNode>();
		Iterator<TrieNode> itr = node.getChildren().values().iterator();
		while (itr.hasNext()) {
			stack.add(itr.next());
			// stack.push(itr.next());
		}
		while (!stack.empty()) {
			TrieNode t = stack.pop();
			printTrie(t, strSoFar);
		}

	}

	public String getMatchingPrefix(String input) {
		String result = ""; // Initialize resultant string
		int length = input.length(); // Find length of the input string

		// Initialize reference to traverse through Trie
		TrieNode crawl = root;

		// Iterate through all characters of input string 'str' and traverse
		// down the Trie
		int level, prevMatch = 0;
		for (level = 0; level < length; level++) {
			// Find current character of str
			char ch = input.charAt(level);

			// HashMap of current Trie node to traverse down
			HashMap<Character, TrieNode> child = crawl.getChildren();

			// See if there is a Trie edge for the current character
			if (child.containsKey(ch)) {
				result += ch; // Update result
				crawl = child.get(ch); // Update crawl to move down in Trie

				// If this is end of a word, then update prevMatch
				if (crawl.isEnd())
					prevMatch = level + 1;
			} else
				break;
		}

		// If the last processed character did not match end of a word,
		// return the previously matching prefix
		if (!crawl.isEnd())
			return result.substring(0, prevMatch);

		else
			return result;
	}
	//autocomplete with elements present in the trie
	public List<String> autoComplete(String prefix) {
		TrieNode crawl = root;
		int len = prefix.length();
		for (int i = 0; i < len; i++) {
			char ch = prefix.charAt(i);
			if (crawl.getChildren().containsKey(ch)) {
				crawl = crawl.getChildren().get(ch);

			} else {
				return Collections.emptyList();
			}
		}
		
		return crawl.allPrefixes(crawl, "", 0, new ArrayList<String>());
		

	}

	public static void main(String[] args) throws Exception {
		Trie dict = new Trie();
		dict.insert("abc");
		dict.insert("afgk");
		dict.insert("adk");
		dict.insert("lmn");
		String input = "abcklmn";		
		dict.printTrie(dict.root, "");
		List<String> ls = dict.autoComplete("a");
		System.out.println(ls);
	}

}
