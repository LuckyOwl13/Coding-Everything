package horses_and_burros.v1;

/** This enum lists all the States covered under the Wild Horse and Burros Act in 1971 **/
public enum State {
	AZ,
	CA,
	CO,
	ID,
	MT,
	NV,
	NM,
	OR,
	UT,
	WY;

	public static State parseString(String input) {
		State state = null;
		switch(input){
		 case "AZ": state = State.AZ;
		 	break;
		 case "CA": state = State.CA;
		 	break;
		 case "CO": state = State.CO;
		 	break;
		 case "ID": state = State.ID;
		 	break;
		 case "MT": state = State.MT;
		 	break;
		 case "NV": state = State.NV;
		 	break;
		 case "NM": state = State.NM;
		 	break;
		 case "OR": state = State.OR;
		 	break;
		 case "UT": state = State.UT;
		 	break;
		 case "WY": state = State.WY;
		 	break;
	 	default: //nice
		 	break;
		}
		return state;
	}

}