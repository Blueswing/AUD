package data_structure.tree;

import java.util.Comparator;

import exception.UnderflowException;

public class AVLTree<T> implements ITree<T> {

	private static class AVLNode<T> {

		T value;
		AVLNode<T> left;
		AVLNode<T> right;
		int height;

		AVLNode(T value) {
			this(value, null, null);
		}

		AVLNode(T value, AVLNode<T> left, AVLNode<T> right) {
			this.value = value;
			this.left = left;
			this.right = right;
			height = 0;
		}
	}

	private AVLNode<T> root;
	private Comparator<? super T> cmp;
	private int size;

	public AVLTree() {
		root = null;
		cmp = null;
		size=0;
	}

	public AVLTree(Comparator<? super T> cmp) {
		root = null;
		this.cmp = cmp;
		size=0;
	}

	@Override
	public void insert(T value) {
		root = insert(value,root);
		++size;
	}

	@Override
	public void remove(T value) {
		// TODO Auto-generated method stub
		--size;
	}

	@Override
	public void empty() {
		root=null;
	}

	@Override
	public boolean contains(T value) {
		return contains( value, root );
	}
	
	private boolean contains(T value, AVLNode<T> node) {
        while( node != null )
        {
            int compareResult = compare(value, node.value);
            
            if( compareResult < 0 )
                node = node.left;
            else if( compareResult > 0 )
                node = node.right;
            else
                return true;
        }
        return false;
	}

	public boolean isEmpty(){
		return root==null;
	}
	
	public T findMax() throws UnderflowException{
		if(isEmpty())
			throw new UnderflowException();
		return findMax(root).value;
	}
	
	public T findMin() throws UnderflowException{
		if(isEmpty())
			throw new UnderflowException();
		return findMin(root).value;
	}
	
	private AVLNode<T> findMax(AVLNode<T> node){
		if(node == null)
			return node;
		while(node.right!= null){
			node = node.right;
		}
		return node;
	}
	
	private AVLNode<T> findMin(AVLNode<T> node){
		if(node == null)
			return node;
		while(node.left != null){
			node = node.left;
		}
		return node;
	}

	@Override
	public int size() {
		return size;
	}

	private int height(AVLNode<T> node) {
		return node == null ? -1 : node.height;
	}

	private AVLNode<T> insert(T value, AVLNode<T> node) {
		if (node == null)
			return new AVLNode<T>(value, null, null);

		int compareResult = compare(value, node.value);

		if (compareResult < 0) {
			node.left = insert(value, node.left);
			if (height(node.left) - height(node.right) == 2) {
				if (compare(value, node.left.value) < 0)
					node = rotateWithLeftChild(node);
				else
					node = doubleWithLeftChild(node);
			}
		}else if (compareResult > 0) {
			node.right = insert(value, node.right);
			if (height(node.right) - height(node.left) == 2) {
				if (compare(value, node.right.value) > 0)
					node = rotateWithRightChild(node);
				else
					node = doubleWithRightChild(node);
			}

		}
		node.height = Math.max(height(node.left), height(node.right))+1;
		return node;
	}

	private AVLNode<T> doubleWithRightChild(AVLNode<T> k1) {
		k1.right = rotateWithLeftChild( k1.right );
        return rotateWithRightChild( k1 );
	}

	private AVLNode<T> rotateWithRightChild(AVLNode<T> k1) {
		AVLNode<T> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = Math.max( height( k1.left ), height( k1.right ) ) + 1;
        k2.height = Math.max( height( k2.right ), k1.height ) + 1;
        return k2;
	}

	private AVLNode<T> doubleWithLeftChild(AVLNode<T> k3) {
		k3.left = rotateWithRightChild( k3.left );
        return rotateWithLeftChild( k3 );
	}

	private AVLNode<T> rotateWithLeftChild(AVLNode<T> k2) {
		AVLNode<T> k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		k1.height = Math.max(height(k2.left), height(k2.right))+1;
		k2.height = Math.max(height(k1.left),k2.height)+1;
		return k1;
	}

	@SuppressWarnings("unchecked")
	private int compare(T lhs, T rhs) {
		if (cmp != null) {
			return cmp.compare(lhs, rhs);
		} else {
			return ((Comparable<T>) lhs).compareTo(rhs);
		}
	}
	
	@Override
	public String toString() {
		if (root == null)
			return "empty tree";
		StringBuilder sb = new StringBuilder();
		outputNode(0, root, sb);
		return sb.toString();
	}

	private static <T> void outputNode(int indent, AVLNode<T> node, StringBuilder sb) {
		outputIndentString(indent, sb);
		sb.append('(').append(node.value.toString()).append(")\n");
		if (node.left != null) {
			outputNode(indent + 1, node.left, sb);
		} else {
			outputIndentString(indent + 1, sb);
			sb.append("null\n");
		}

		if (node.right != null) {
			outputNode(indent + 1, node.right, sb);
		} else {
			outputIndentString(indent + 1, sb);
			sb.append("null\n");
		}
	}

	private static void outputIndentString(int indent, StringBuilder sb) {
		for (int i = 0; i < indent; ++i) {
			sb.append("|  ");
		}
		sb.append("+--");
	}

	public static void main(String[] args) {
		AVLTree<Integer> avl = new AVLTree<>();
		for (int i = 0; i < 20; ++i) {
			avl.insert(i);
		}
		avl.insert(-1);
		System.out.println(avl);
		System.out.println(avl.contains(1));
		System.out.println(avl.contains(-1));
	}
}
