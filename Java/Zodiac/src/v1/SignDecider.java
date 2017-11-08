package v1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Calendar.Builder;
/***
 * This class stores the start/end dates for each of the twelve zodiac signs (Aries through Pisces)
 * and sets them through the use of two methods: setSignDate() and makeCalendar(). The largest use for
 * the class comes in getSignInt(), which takes in a Calendar object and returns the cooresponding int
 * value (0-11) for that Calendar's date's zodiac sign.
 * 
 * @author mcelweek3
 */
public class SignDecider {
	// the start- and end-dates for Aries
	private final Calendar ARIESSTART = setSignDate("3/21");
	private final Calendar ARIESFINISH = setSignDate("4/19");

	// the start- and end-dates for Taurus
	private final Calendar TAURUSSTART = setSignDate("4/20");
	private final Calendar TAURUSFINISH = setSignDate("5/20");

	// the start- and end-dates for Gemini
	private final Calendar GEMINISTART = setSignDate("5/21");
	private final Calendar GEMINIFINISH = setSignDate("6/20");

	// the start- and end-dates for Cancer
	private final Calendar CANCERSTART = setSignDate("6/21");
	private final Calendar CANCERFINISH = setSignDate("7/22");

	// the start- and end-dates for Leo
	private final Calendar LEOSTART = setSignDate("7/23");
	private final Calendar LEOFINISH = setSignDate("8/22");

	// the start- and end-dates for Virgo
	private final Calendar VIRGOSTART = setSignDate("8/23");
	private final Calendar VIRGOFINISH = setSignDate("9/22");

	// the start- and end-dates for Libra
	private final Calendar LIBRASTART = setSignDate("9/23");
	private final Calendar LIBRAFINISH = setSignDate("10/22");

	// the start- and end-dates for Scorpio
	private final Calendar SCORPIOSTART = setSignDate("10/23");
	private final Calendar SCORPIOFINISH = setSignDate("11/21");

	// the start- and end-dates for Sagittarius
	private final Calendar SAGITTARIUSSTART = setSignDate("11/22");
	private final Calendar SAGITTARIUSFINISH = setSignDate("12/21");

	// the start- and end-dates for Capricorn. Capricorn wraps around 
	//the end of the year (Dec - Jan) so it gets two sets of start-finish
	//fields
	private final Calendar CAPRICORNSTART1 = setSignDate("12/22");
	private final Calendar CAPRICORNFINISH1 = setSignDate("12/31");
	private final Calendar CAPRICORNSTART2 = setSignDate("1/01");
	private final Calendar CAPRICORNFINISH2 = setSignDate("1/19");

	// the start- and end-dates for Aquarius
	private final Calendar AQUARIUSSTART = setSignDate("1/20");
	private final Calendar AQUARIUSFINISH = setSignDate("2/18");

	// the start- and end-dates for Pisces
	private final Calendar PISCESSTART = setSignDate("2/19");
	private final Calendar PISCESFINISH = setSignDate("3/20");
	
	/**
	 * All fields for this class are final and initialised before the constructor,
	 * so the constructor does nothing.
	 */
	public SignDecider()
	{
		//also nice
	}
	
	/**
	 * returns the Calendar object stored in ARIESSTART
	 * @return ARIESSTART
	 */
	public Calendar getARIESSTART() {
		return ARIESSTART;
	}

	/**
	 * returns the Calendar object stored in ARIESFINISH
	 * @return ARIESFINISH
	 */
	public Calendar getARIESFINISH() {
		return ARIESFINISH;
	}

	/**
	 * returns the Calendar object stored in TAURUSSTART
	 * @return TAURUSSTART
	 */
	public Calendar getTAURUSSTART() {
		return TAURUSSTART;
	}

	/**
	 * returns the Calendar object stored in TAURUSFINISH
	 * @return TAURUSFINISH
	 */
	public Calendar getTAURUSFINISH() {
		return TAURUSFINISH;
	}

	/**
	 * returns the Calendar object stored in GEMINISTART
	 * @return GEMINISTART
	 */
	public Calendar getGEMINISTART() {
		return GEMINISTART;
	}

	/**
	 * returns the Calendar object stored in GEMINIFINISH
	 * @return GEMINIFINISH
	 */
	public Calendar getGEMINIFINISH() {
		return GEMINIFINISH;
	}

	/**
	 * returns the Calendar object stored in CANCERSTART
	 * @return CANCERSTART
	 */
	public Calendar getCANCERSTART() {
		return CANCERSTART;
	}

	/**
	 * returns the Calendar object stored in CANCERFINISH
	 * @return CANCERFINISH
	 */
	public Calendar getCANCERFINISH() {
		return CANCERFINISH;
	}

	/**
	 * returns the Calendar object stored in LEOSTART
	 * @return LEOSTART
	 */
	public Calendar getLEOSTART() {
		return LEOSTART;
	}

	/**
	 * returns the Calendar object stored in LEOFINISH
	 * @return LEOFINISH
	 */
	public Calendar getLEOFINISH() {
		return LEOFINISH;
	}

	/** 
	 * returns the Calendar object stored in VIRGOSTART
	 * @return VIRGOSTART
	 */
	public Calendar getVIRGOSTART() {
		return VIRGOSTART;
	}

	/**
	 *  returns the Calendar object stored in VIRGOFINISH
	 * @return VIRGOFINISH
	 */
	public Calendar getVIRGOFINISH() {
		return VIRGOFINISH;
	}

	/**
	 *  returns the Calendar object stored in LIBRASTART
	 * @return LIBRASTART
	 */
	public Calendar getLIBRASTART() {
		return LIBRASTART;
	}

	/**
	 *  returns the Calendar object stored in LIBRAFINISH
	 * @return LIBRAFINISH
	 */
	public Calendar getLIBRAFINISH() {
		return LIBRAFINISH;
	}

	/** 
	 * returns the Calendar object stored in SCORPIOSTART
	 * @return SCORPIOSTART
	 */
	public Calendar getSCORPIOSTART() {
		return SCORPIOSTART;
	}

	/**
	 * returns the Calendar object stored in SCORPIOFINISH
	 * @return SCORPIOFINISH
	 */
	public Calendar getSCORPIOFINISH() {
		return SCORPIOFINISH;
	}

	/**
	 *  returns the Calendar object stored in SAGITTARIUSSTART
	 * @return SAGITTARIUSSTART
	 */
	public Calendar getSAGITTARIUSSTART() {
		return SAGITTARIUSSTART;
	}

	/**
	 *  returns the Calendar object stored in SAGITTARIUSFINISH
	 * @return SAGITTARIUSFINISH
	 */
	public Calendar getSAGITTARIUSFINISH() {
		return SAGITTARIUSFINISH;
	}

	/**
	 *  returns the Calendar object stored in CAPRICORNSTART1
	 * @return CAPRICORNSTART1
	 */
	public Calendar getCAPRICORNSTART1() {
		return CAPRICORNSTART1;
	}

	/**
	 *  returns the Calendar object stored in getCAPRICORNFINISH1
	 * @return CAPRICORNFINISH1
	 */
	public Calendar getCAPRICORNFINISH1() {
		return CAPRICORNFINISH1;
	}

	/**
	 *  returns the Calendar object stored in CAPRICORNSTART2
	 * @return CAPRICORNSTART2
	 */
	public Calendar getCAPRICORNSTART2() {
		return CAPRICORNSTART2;
	}

	/**
	 *  returns the Calendar object stored in CAPRICORNFINISH2
	 * @return CAPRICORNFINISH2
	 */
	public Calendar getCAPRICORNFINISH2() {
		return CAPRICORNFINISH2;
	}

	/**
	 *  returns the Calendar object stored in AQUARIUSSTART
	 * @return AQUARIUSSTART
	 */
	public Calendar getAQUARIUSSTART() {
		return AQUARIUSSTART;
	}

	/**
	 *  returns the Calendar object stored in AQUARIUSFINISH
	 * @return AQUARIUSFINISH
	 */
	public Calendar getAQUARIUSFINISH() {
		return AQUARIUSFINISH;
	}

	/**
	 *  returns the Calendar object stored in PISCESSTART
	 * @return PISCESSTART
	 */
	public Calendar getPISCESSTART() {
		return PISCESSTART;
	}

	/**
	 *  returns the Calendar object stored in PISCESFINISH
	 * @return PISCESFINISH
	 */
	public Calendar getPISCESFINISH() {
		return PISCESFINISH;
	}
	
	/**
	 * Takes an input of a calendar and goes through an (admittedly large) if-elseif block that evaluates if the 
	 * calendar's date is after a sign's start date (compares to < 1) and after that sign's end date (compares to > -1);
	 * if both, then the date is within range of that sign, and signInt is set to that sign's int value which is returned
	 * at the end of the method.
	 * 
	 * @param calendar
	 * @return int value cooresponding with the appropriate zodiac sign (0-11); if it comes back as
	 * -1, there's been an error.
	 */
	public int getSignInt(Calendar calendar)
	{
		int signInt = -1;
		
		
		if(calendar.compareTo(ARIESSTART) > -1 && calendar.compareTo(ARIESFINISH) < 1)
		{
			signInt = 0;
		}
		else if(calendar.compareTo(TAURUSSTART) > -1 && calendar.compareTo(TAURUSFINISH) < 1)
		{
			signInt = 1;
		}
		else if(calendar.compareTo(GEMINISTART) > -1 && calendar.compareTo(GEMINIFINISH) < 1)
		{
			signInt = 2;
		}
		else if(calendar.compareTo(CANCERSTART) > -1 && calendar.compareTo(CANCERFINISH) < 1)
		{
			signInt = 3;
		}
		else if(calendar.compareTo(LEOSTART) > -1 && calendar.compareTo(LEOFINISH) < 1)
		{
			signInt = 4;
		}
		else if(calendar.compareTo(VIRGOSTART) > -1 && calendar.compareTo(VIRGOFINISH) < 1)
		{
			signInt = 5;
		}
		else if(calendar.compareTo(LIBRASTART) > -1 && calendar.compareTo(LIBRAFINISH) < 1)
		{
			signInt = 6;
		}
		else if(calendar.compareTo(SCORPIOSTART) > -1 && calendar.compareTo(SCORPIOFINISH) < 1)
		{
			signInt = 7;
		}
		else if(calendar.compareTo(SAGITTARIUSSTART) > -1 && calendar.compareTo(SAGITTARIUSFINISH) < 1)
		{
			signInt = 8;
		}
		else if(calendar.compareTo(CAPRICORNSTART1) > -1 && calendar.compareTo(CAPRICORNFINISH1) < 1)
		{
			signInt = 9;
		}
		else if(calendar.compareTo(CAPRICORNSTART2) > -1 && calendar.compareTo(CAPRICORNFINISH2) < 1)
		{
			signInt = 9;
		}
		else if(calendar.compareTo(AQUARIUSSTART) > -1 && calendar.compareTo(AQUARIUSFINISH) < 1)
		{
			signInt = 10;
		}
		else if(calendar.compareTo(PISCESSTART) > -1 && calendar.compareTo(PISCESFINISH) < 1)
		{
			signInt = 11;
		}
		
		return signInt;
	}
	
	/**
	 * This is a middle-man method because final fields do not work well with methods that throw ParseException,
	 * so instead this does not do that but instead calls a method that does.
	 * 
	 * @param string
	 * @return the Calendar object cooresponding to the input string.
	 */
	private Calendar setSignDate(String string)
	{
		Calendar calendar = null;
		try {
			calendar = makeCalendar(string);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return calendar;
	}
	
	/**
	 * The method that actually parses the input string into a Date object which is then converted into a 
	 * Calendar object that is returned. **Not sure if we need this anymore**
	 * 
	 * @param birthdateString
	 * @return the Calendar object corresponding to the input string.
	 * @throws ParseException
	 */
	private Calendar makeCalendar(String birthdateString) throws ParseException
	{
		DateFormat format = new SimpleDateFormat("MM/dd", Locale.ENGLISH);
		Date date = format.parse(birthdateString);
	
		Builder builder = new Calendar.Builder();
		builder = builder.setInstant(date);
		Calendar calendar = builder.build();
		
		return calendar;
	}
}