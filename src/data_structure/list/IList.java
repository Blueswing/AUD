package data_structure.list;

import data_structure.Collection;

public interface IList<T> extends Collection<T>{
	
	public void add(T value);
	
    public T remove(int index);
    
    public boolean remove(T value);
    
    public void clear();

    public boolean contains(T value);

    public int size();
}
