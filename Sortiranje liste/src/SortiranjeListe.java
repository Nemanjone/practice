import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class SortiranjeListe {
	
	public static void mergeSort(List<Integer> l) {
		
		if(l.size() > 1) {
			List<Integer> l1 = new LinkedList<Integer>();
			List<Integer> l2 = new LinkedList<Integer>();
			
			ListIterator<Integer> it = l.listIterator();
			boolean dodajL1 = true;
			
			while (it.hasNext()) {
				Integer e = it.next();
				if (dodajL1)
					l1.add(e);
					else
						l2.add(e);
				dodajL1 =!dodajL1;
			}
			
			mergeSort(l1);
			mergeSort(l2);
			
			l.clear();
			
			ListIterator<Integer> it1 = l1.listIterator();
			ListIterator<Integer> it2 = l2.listIterator();
			
			Integer e1 = it1.next();
			Integer e2 = it2.next();
			
			while (true) {
				if(e1.compareTo(e2) <= 0) {
					l.add(e1);
					if(it1.hasNext())
						e1 = it1.next();
					else {
						l.add(e2);
					while (it2.hasNext())
						l.add(it2.next());
					break;		
				}
			}
			else {
				l.add(e2);
				if(it2.hasNext())
					e2 = it2.next();
				else {
					l.add(e1);
					while (it1.hasNext())
						l.add(it1.next());
					break;
						
					}
					
				  }
		        
			   }
				
		    }
		
		}
	
	 } 
	


