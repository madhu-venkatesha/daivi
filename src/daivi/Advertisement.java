package daivi;

import java.text.MessageFormat;

public class Advertisement {

	private static String assistPageFor(Section section) {
		return MessageFormat.format("{0}.adassist", section.name().toLowerCase());
	}

	public static PageToServe handleRequestToAdvertise(String section) {
		Section sectionEnum = Section.valueOf(section.toUpperCase());
		return new PageToServe(assistPageFor(sectionEnum));
	}

}
