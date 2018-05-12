import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/*public static <T> void remove(Collection<T> coll, Predicate<T> pred)
// Remove every object, obj, from coll for which
// pred.test(obj) is true.
public static <T> void retain(Collection<T> coll, Predicate<T> pred)
// Remove every object, obj, from coll for which
// pred.test(obj) is false. (That is, retain the
// objects for which the predicate is true.)
public static <T> List<T> collect(Collection<T> coll, Predicate<T> pred)
// Return a List that contains all the objects, obj,
// from the collection, coll, such that pred.test(obj)
// is true.
public static <T> int find(ArrayList<T> list, Predicate<T> pred)
// Return the index of the first item in list
// for which the predicate is true, if any.
// If there is no such item, return -1.
(In C++, methods similar to these are included as a standard*/

public class Predicates<T> {


	public static <T> void remove(Collection<T> coll, Predicate<T> pred) {

		Iterator<T> iter = coll.iterator();
		while(iter.hasNext()) {
			T item = iter.next();
			if(pred.test(item))
				iter.remove();
		}
	}

	public static <T> void retain(Collection<T> coll, Predicate<T> pred) {

		Iterator<T> iter = coll.iterator();
		while(iter.hasNext()){
			T item = iter.next();
			if(!pred.test(item))
				iter.remove();
		}
	}

	public static <T> List<T> collect(Collection<T> coll, Predicate<T> pred){

		List<T> lista = new ArrayList<T>(); 

		for (T item1 : coll) {
			if(pred.test(item1))
				lista.add(item1);
		}

		return lista;
	}

	public static <T> int find(ArrayList<T> lista, Predicate<T> pred) {

		for (int i = 0; i < lista.size(); i++) {
			T item = lista.get(i);
			if(pred.test(item))
				return i;		
		}
		return -1;
	}
 }
