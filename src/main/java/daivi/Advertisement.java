package daivi;

import java.text.MessageFormat;

public class Advertisement {

	private static String assistPageFor(String section) {
		return MessageFormat.format("info/daivi/adassist/{0}.html", section);
	}

	public PageToServe handleRequestToAdvertise(String section) {
		if (section == null) {
			return new PageToServe(Constants.ERROR_HTML_CPATH);
		}

		switch (section) {
		case "satsang":
			return new PageToServe(assistPageFor(section));
			
		default:
			return new PageToServe(Constants.ERROR_HTML_CPATH);
		}
	}

}
