import javax.swing.DefaultListModel;
import javax.swing.JList;

//TRIE
public class Trie {

	static final int SIZE = 36;

	// TRIE NODE
	static class TrieNode {
		TrieNode[] children = new TrieNode[SIZE];

		boolean isEndOfWord;
		int codeOfName;

		TrieNode() {
			isEndOfWord = false;
			for (int i = 0; i < SIZE; i++)
				children[i] = null;
		}
	}

	static TrieNode root;

	// INSERT
	static void insert(String key, int nameCode) {
		int level;
		int length = key.length();
		int index;

		TrieNode rootNode = root;

		for (level = 0; level < length; level++) {
			index = key.charAt(level) - 'a';
			if (index < 0)// if char is integer
				index = 26 + Integer.parseInt(key.charAt(level) + "");
			if (rootNode.children[index] == null)// if child is NULL
				rootNode.children[index] = new TrieNode();

			rootNode = rootNode.children[index];
		}

		rootNode.isEndOfWord = true;// set here is end of word
		rootNode.codeOfName = nameCode;
	}

	// SEARCH
	static boolean search(String key) {
		int level;
		int length = key.length();
		int index;
		TrieNode pCrawl = root;

		for (level = 0; level < length; level++) {
			index = key.charAt(level) - 'a';

			if (index < 0)// if this char is integer
				index = 26 + Integer.parseInt(key.charAt(level) + "");

			if (pCrawl.children[index] == null)
				return false;

			pCrawl = pCrawl.children[index];// next level
		}

		// if node is not null and here is the end of word
		return (pCrawl != null && pCrawl.isEndOfWord);
	}

	// GET CODE OF NAME
	static int getCode(String key) {
		int level;
		int length = key.length();
		int index;
		TrieNode pCrawl = root;

		for (level = 0; level < length; level++) {
			index = key.charAt(level) - 'a';

			if (index < 0)// if this char is integer
				index = 26 + Integer.parseInt(key.charAt(level) + "");

			if (pCrawl.children[index] == null)
				return -1;

			pCrawl = pCrawl.children[index];
		}

		// if node is not null and here is the end of word
		if (pCrawl != null && pCrawl.isEndOfWord)
			return pCrawl.codeOfName;

		else
			return -1;
	}

	// DELETE
	static boolean delete(String key) {

		int level;
		int length = key.length();
		int index;
		TrieNode pCrawl = root;

		for (level = 0; level < length; level++) {
			index = key.charAt(level) - 'a';

			if (index < 0)// if this char is integer
				index = 26 + Integer.parseInt(key.charAt(level) + "");

			if (pCrawl.children[index] == null)
				return false;

			pCrawl = pCrawl.children[index];
		}

		// set "isEndOfWord" false
		if (pCrawl != null && pCrawl.isEndOfWord)
			pCrawl.isEndOfWord = false;

		return true;

	}

	// print all word of trie tree
	static void getChild(String prefix, JList<String> list, DefaultListModel<String> model) {
		int level;
		int length = prefix.length();
		int index;
		TrieNode pCrawl = root;

		// like Search
		for (level = 0; level < length; level++) {
			index = prefix.charAt(level) - 'a';

			if (index < 0)// if this char is integer
				index = 26 + Integer.parseInt(prefix.charAt(level) + "");

			if (pCrawl.children[index] == null)
				return;

			pCrawl = pCrawl.children[index];// next level
		}

		// find word
		if (pCrawl.isEndOfWord)
			model.addElement(prefix);

		// call function one more time
		for (int i = 0; i < 36; i++) {
			if (i >= 26 && pCrawl.children[i] != null) {
				getChild(prefix + (i - 26 + ""), list, model);
			} else if (pCrawl.children[i] != null) {
				getChild(prefix + getCharOfInt(i), list, model);
			}
		}

		list.setModel(model);
	}

	// DELETE PREVIEW NODE AND INSERT NEW NODE
	static boolean edit(String pKey, String nKey, int nameCode) {

		if (delete(pKey)) {
			insert(nKey, nameCode);
			return true;
		} else
			return false;
	}

	// set the root
	public static void setRoot() {
		root = new TrieNode();
	}

	// return given int's char
	private static String getCharOfInt(int i) {
		String numbers[] = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "J", "k", "l", "m", "n", "o", "p", "q", "r",
				"s", "t", "u", "v", "w", "x", "y", "z" };

		return numbers[i];
	}

}
