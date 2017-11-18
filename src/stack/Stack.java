package stack;

import java.lang.reflect.Array;
import java.util.Iterator;
import node.node;
import stack.StackEmptyException;
import stack.StackFullException;
import node.node;

public class Stack  <T extends Comparable <T>> implements iStack <T>,Iterable <T>{
	private node<T> sentinel = null;
	private int count=0;
	private int size=10;

	public Stack() {

		sentinel = new node<T>();
		sentinel.setIndex(-1);
	}

	public Stack(T value) {
		this();
		node<T> tmp = new node(value);
		tmp.setIndex(0);
		sentinel.setNext(tmp);

	}
	
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {

			@Override
			public boolean hasNext() {
				node<T> sig = sentinel;
				sentinel = sentinel.getNext();
				return (sentinel != null) ? true : false;
			}

			@Override
			public T next() {
				return sentinel.getValue();
			}
		};
	}

	@Override
	public void push(T value) throws StackFullException {
		if(isFull()) throw new StackFullException("La pila esta vacia");
		node<T> tmp = sentinel.getNext();
		node<T> nuevo = new node<T>(value);
		nuevo.setNext(tmp);
		sentinel.setNext(nuevo);
		count++;
		
	}

	@Override
	public boolean isEmpty() {
		return count<=0;
	}

	@Override
	public boolean isFull() {
		return count == size ;
	}
	@Override
	public void clear() {
		node<T> tmp;
		while(sentinel.getNext()!=null) {
			tmp=sentinel.getNext();
			sentinel.setNext(null);
			sentinel=tmp;	
			System.gc();
		}
	}

	@Override
	public T peek() throws StackEmptyException {
		node<T> tmp=sentinel;
		while(tmp.getNext()!=null) {
			  tmp=tmp.getNext();
		}
		return tmp.getValue();
	}

	@Override
	public int size() {
		return count;
	}
	
	private node<T> Search(T value,node<T> list){
		if(list.getNext().getValue().equals(value)){
			return list.getNext();
		}
		if(list.getNext().equals(sentinel.getNext())){
			return null;
		}
		
		return Search(value,list.getNext());
	}
	
	public node<T> Search(T value)throws StackEmptyException{
		return (!isEmpty())?Search(value,sentinel.getNext()):null;
	}


@Override
	public T pop() throws StackEmptyException {
	node<T> tmp = sentinel.getNext();
	if(isEmpty()) {throw new StackEmptyException("La pila esta vacia")};
	else {
		tmp.setNext(tmp.getNext().getNext());
		count--;
	}
}

