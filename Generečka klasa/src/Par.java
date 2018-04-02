
public class Par<T> {
	
	private T prvi;
	private T drugi;
	
	public Par() {
		this.prvi = null;
		this.drugi = null;
	}
	
	public Par(T prvi, T drugi) {
		super();
		this.prvi = prvi;
		this.drugi = drugi;
	}

	public T getPrvi() {
		return prvi;
	}

	public void setPrvi(T prvi) {
		this.prvi = prvi;
	}

	public T getDrugi() {
		return drugi;
	}

	public void setDrugi(T drugi) {
		this.drugi = drugi;
	} 
	
	

}
