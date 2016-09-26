import java.util.Currency;
import java.util.Stack;

public class Traversals{
	
	static class Node{
		int data;
		Node leftChild;
		Node rightChild;
		
		Node(int data){
			this.data = data;
			this.leftChild = null;
			this.rightChild = null;
		}
		
		Node(int data, Node leftChild, Node rightChild){
			this.data = data;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}
	}
	public static void inOrderTraversalIterative(Node root){
			Node currentNode = root;
			Stack<Node> stack = new Stack<Node>();
			while(!stack.empty() || currentNode!=null){
				if(currentNode!=null){
					stack.push(currentNode);
					currentNode = currentNode.leftChild;
				}
				else{
					Node popNode = stack.pop();
					System.out.print(popNode.data);
					currentNode = popNode.rightChild;
				
				}
			}
	}
	
	public static void inOrderTraversalRecursion(Node node){
		if(node == null) return;
		inOrderTraversalRecursion(node.leftChild);
		System.out.print(node.data);
		inOrderTraversalRecursion(node.rightChild);
	}
	
	public static void preOrderTraversalRecursion(Node node){
		if(node == null) return;
		System.out.print(node.data);
		preOrderTraversalRecursion(node.leftChild);
		preOrderTraversalRecursion(node.rightChild);
	}
	
	public static void preOrderTraversalIterative(Node node){
		if(node == null) return;
		Stack<Node> stack = new Stack<Node>();
		stack.push(node);
		
		while(!stack.isEmpty()){
			Node currentNode = stack.pop();
			System.out.print(currentNode.data);
			
			if(node.rightChild!=null){
				stack.push(node.rightChild);
			}			
			
			if(node.leftChild!=null){
				stack.push(node.leftChild);
			}
		}
	}
	
	public static void main(String args[]){
		Node leftleftChild = new Node(4);
		Node leftrightChild = new Node(5);
		Node leftChild = new Node(2, leftleftChild, leftrightChild);
		Node rightChild = new Node(3);
		Node root = new Node(1, leftChild, rightChild);
		
		inOrderTraversalIterative(root);
		System.out.println("\n");
		inOrderTraversalRecursion(root);
		System.out.println("\n");
		preOrderTraversalRecursion(root);
	}

}