package lieberman.regEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberMatching {

	public static void main(String args[]) {

		Pattern p = Pattern.compile("(1-?\\s*)?(\\d{3}-?\\s*){2}\\d{4}");
		// '?' = 0 or 1
		// '\s' = space
		
		String text = "This is my number, 1 718 868 0160";
		Matcher m = p.matcher(text);
		boolean b = m.matches();

		System.out.println(b);

		while (m.find()) {
			String number = text.substring(m.start(), m.end());
			String formattedNumber = number.replaceAll("\\s(2, )", " ");
			System.out.println(formattedNumber);
		}


		
	}

}
