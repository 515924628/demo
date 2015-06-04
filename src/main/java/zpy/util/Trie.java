package zpy.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zpy on 2014/9/14.
 * trie树
 */
public class Trie {
    public class Node {
        public Node[] nodes = new Node[16];
        public Node parent = null;
        public boolean isWord = false;
        public Character character;

        private int size = 0;

        public Node(Node parent, Character character, boolean isWord) {
            this.parent = parent;
            this.character = character;
            this.isWord = isWord;
        }

        public void add(Node node){
            if (size >= nodes.length){
                nodes = Arrays.copyOf(nodes, nodes.length + 16);
            }
            nodes[size] = node;
            size++;
        }

        public boolean remove(int index){
            if (index <= 0 && index >= size) return false;
            nodes[index] = null;
            size--;
            System.arraycopy(nodes, index + 1, nodes, index, size - index);
            if (size >= 16 && size + 16 < nodes.length){
                nodes = Arrays.copyOf(nodes, nodes.length - 16);
            }
            return true;
        }

        public int indexOf(Character character){
            for (int i = 0; i < size; i++){
                if (nodes[i].character.equals(character)){
                    return i;
                }
            }
            return -1;
        }

        public Node get(int index){
            if (index >= 0 && index >= size) return null;
            return nodes[index];
        }

		public Node get(char ch){
			return get(indexOf(ch));
		}

        public int size(){
            return size;
        }

        @Override
        public String toString() {
            if (parent == null)
                return "";
            return parent.toString() + character;
        }

	}

	public interface INodeCreator {
		public Node createNode(Node parent, Character character, boolean isWord);
	}

    public void add(String str){
        if (root == null){
            root = iNodeCreator.createNode(null, null, false);
        }
        Node node = root;
        for (int i = 0; i != str.length(); i++){
            int index = node.indexOf(str.charAt(i));
            Node n;
            if (index == -1){
                n = iNodeCreator.createNode(node,str.charAt(i),false);
                node.add(n);
            } else {
                n = node.get(index);
            }
            node = n;
        }
        if (!node.isWord){
            node.isWord = true;
            size++;
        }
    }

    public boolean remove(String str){ //不好用
        if (root == null){
            return false;
        }
        Node node = root;
        for (int i = 0; i != str.length(); i++){
            int index = node.indexOf(str.charAt(i));
            if (index == -1){
                return false;
            } else {
                node = node.get(index);
            }
        }
        if (node.size() > 0){
            node.isWord = false;
        } else {
            node = node.parent;
            node.remove(node.indexOf(str.charAt(str.length() - 1)));
        }
        return true;
    }

	public String[] find(String str){
		Node node = root;
		for (int i = 0; i != str.length(); i++){
			node = node.get(str.charAt(i));
		}
		traversal(node);
		return getStrings();
	}

	public int size() {
		return size;
	}

	public void setNodeCreator(INodeCreator iNodeCreator) {
		this.iNodeCreator = iNodeCreator;
	}

	private void traversal(Node node){
        if (node.isWord){
			Algorithms(node);
        }
        if (node.size() == 0){
            return;
        }
        for (int i = 0; i != node.size(); i++){
            traversal(node.get(i));
        }
    }

	private void Algorithms(Node node) {
		list.add(node);
	}

	private String[] getStrings() {
		String[] strings = new String[list.size()];
		for (int i = 0; i != list.size(); i++){
			strings[i] = list.get(i).toString();
		}
		return strings;
	}

	private List<Node> list = new ArrayList<Node>();
    private int size = 0;
    private Node root = null;
	private INodeCreator iNodeCreator = new INodeCreator() {
		public Node createNode(Node parent, Character character, boolean isWord) {
			return new Node(parent, character, isWord);
		}
	};
}
