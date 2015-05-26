package lieberman.regEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailMatching {
	
	//the pattern should be a constant
	//pattern is a factory method
	
	private static final Pattern EMAIL_PATTERN	= Pattern.compile("\\S+?@\\S+?\\.\\S+"); // \S = anything but a space

	public static void main(String[] args) {
		
		
		
		String email = "my email is: ettieeel@gmail.com";
		Matcher m = EMAIL_PATTERN.matcher(email);
		boolean b = m.matches();

		System.out.println(b);

		while (m.find()) {
			String myEmail = email.substring(m.start(), m.end());
			System.out.println(myEmail);
		}
		

	}

}
