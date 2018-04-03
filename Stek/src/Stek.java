import java.util.Collection;
import java.util.LinkedList;

public class Stek<T> {
	
	private LinkedList<T> elementi = new LinkedList<T>();
	
	public void push(T elem) {
		elementi.addFirst(item);	
	}

	public T pop() {
		return elementi.removeFirst();	
	}
	
	public boolean isEmpty() {
		return (elementi.size() == 0);	
	}
	
	public void addAll(Collection<? extends T> k) {
		
		for (T elem : k)
			push(elem);
			
	}
}
