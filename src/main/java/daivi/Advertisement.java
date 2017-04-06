package daivi;

import java.text.MessageFormat;

public class Advertisement {

	private static String assistPageFor(String section) {
		return MessageFormat.format("{0}.adassist", section);
	}

	public PageToServe handleRequestToAdvertise(String section) {
		if (section == null) {
			return new PageToServe("error.html");
		}

		switch (section) {
		case "satsang":
			return new PageToServe(assistPageFor(section));
			
		default:
			return new PageToServe("error.html");
		}
	}

}
