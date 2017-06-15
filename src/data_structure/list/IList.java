package data_structure.list;

public interface IList<T> {
	
	public void add(T value);
	
    public boolean remove(T value);

    public void clear();

    public boolean contains(T value);

    public int size();
}
