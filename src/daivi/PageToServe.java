package daivi;

public class PageToServe {

	private String name;

	public PageToServe(String pageName) {
		name = pageName;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof PageToServe) {
			PageToServe that = (PageToServe) obj;
			return this.name.equals(that.name);
		}
		return false;
	}
}
