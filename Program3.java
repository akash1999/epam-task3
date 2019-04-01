import java.util.*;
 
abstract class Node implements Comparable<Node> {
    public  int frequency; // the frequency of this tree
    public  char data;
    public  Node left, right; 
    public Node(int freq) { 
      frequency = freq; 
    }
 
    // compares on the frequency
    public int compareTo(Node tree) {
        return frequency - tree.frequency;
    }
}
 
class HuffmanLeaf extends Node {
    
 
    public HuffmanLeaf(int freq, char val) {
        super(freq);
        data = val;
    }
}
 
class HuffmanNode extends Node {
    
    public HuffmanNode(Node l, Node r) {
        super(l.frequency + r.frequency);
        left = l;
        right = r;
    }

}


class Decoding {

/*  
	class Node
		public  int frequency; // the frequency of this tree
    	public  char data;
    	public  Node left, right;
    
*/ 
    String output="";

	void decode(String s, Node root) {
        int idx = 0;
        while(idx < s.length()) {
            idx = find(s, root, idx);
        }

        System.out.println(output);
    }

    int find(String s, Node root, int idx) {
        if(root.left == null && root.right == null) {
            output += root.data;
            return idx;
        }

        if(idx >= s.length()) {
            return idx;
        }

        if(s.charAt(idx) == '0') {
            return find(s, root.left, idx + 1);
        } else {
            return find(s, root.right, idx + 1);
        }
    }

