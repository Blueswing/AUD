package data_structure.hash_table;

import data_structure.list.IList;
import data_structure.list.LinkedList;

public class SeparateChainingHashTable<T> implements IHashTable<T> {

	private static final int DEFAULT_SIZE = 101;
	private int size;
	private IList<T>[] lists;
	public SeparateChainingHashTable() {
		this(DEFAULT_SIZE);
	}

	@SuppressWarnings("unchecked")
	public SeparateChainingHashTable(int size) {
		lists = new LinkedList[nextPrime(size)]; // object, type erase
		for(int i = 0 ; i < lists.length ; ++i){
			lists[i] = new LinkedList<>();
		}
		
	}

	@Override
	public void insert(T value) {
		IList<T> list = lists[myhash(value)];
		if(!list.contains(value)){
			list.add(value);
			if(++size>lists.length)
				rehash();
		}
	}

	@Override
	public void remove(T value) {
		IList<T> list = lists[myhash(value)];
		if(list.contains(value)){
			list.remove(value);
			--size;
		}
	}

	@Override
	public boolean contains(T value) {
		IList<T> list = lists[myhash(value)];
		return list.contains(value);
	}

	@Override
	public void empty() {
		for(int i = 0 ; i < lists.length ; ++i)
			lists[i].clear();
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	private void rehash(){
		
	}
	
	private int myhash(T value){
		int hashVal = value.hashCode()%lists.length;
		if(hashVal < 0)
			hashVal += lists.length;
		return hashVal;
	}
	
	private static int nextPrime(int n){
		return 0;
	}
	
	private static boolean isPrime(int n){
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
