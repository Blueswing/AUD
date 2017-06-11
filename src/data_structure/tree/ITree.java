package data_structure.tree;

public interface ITree<T> {

	public void insert(T value);

	public void remove(T value);

	public boolean contains(T value);

	public void empty();

	public int size();
}
