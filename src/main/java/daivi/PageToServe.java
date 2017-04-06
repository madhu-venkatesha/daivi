package daivi;

public class PageToServe {

	private final String name;

	public PageToServe(String pageName) {
		name = pageName;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof PageToServe) {
			PageToServe that = (PageToServe) obj;
			return this.name.equals(that.name);
		}
		return false;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
