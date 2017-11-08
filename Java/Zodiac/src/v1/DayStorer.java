package v1;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Calendar;
import java.util.Calendar.Builder;
import java.util.Date;
import java.util.Locale;

public class DayStorer {
	
	public Calendar collectDate() throws ParseException
	{
		String birthdateString;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your birthday (format like '11/25'): ");
		birthdateString = sc.nextLine();
		sc.close();
		
		
		DateFormat format = new SimpleDateFormat("MM/dd", Locale.ENGLISH);
		Date date = format.parse(birthdateString);
		
		Builder builder = new Calendar.Builder();
		builder = builder.setInstant(date);
		Calendar calendar = builder.build();
		
		return calendar;
	}
	
	
	
	
	
	
	
	
	
}
