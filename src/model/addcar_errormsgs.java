package model;

public class addcar_errormsgs {
	
	private String a_errorMsg; 
	private String a_CarNameError;
	private String a_CapacityError;
	private String a_WeekDayError;
	private String a_WeekEndError;
	private String a_WeekError;
	private String a_GpsError;
	private String a_OnStarError;
	private String a_SiriusXMError;


	public addcar_errormsgs() {
		super();
		this.a_errorMsg = "";
		this.a_CarNameError = "";
		this.a_CapacityError = "";
		this.a_WeekDayError = "";
		this.a_WeekEndError = "";
		this.a_WeekError = "";
		this.a_GpsError = "";
		this.a_OnStarError = "";
		this.a_SiriusXMError = "";
	}
	public String getA_CarNamError() {
		return a_CarNameError;
	}
	public void setA_CarNameError(String a_CarNameError) {
		this.a_CarNameError = a_CarNameError;
	}
	public String getA_CapacityError() {
		return a_CapacityError;
	}
	public void setA_CapacityError(String a_CapacityError) {
		this.a_CapacityError = a_CapacityError;
	}
	public String getA_WeekDayError() {
		return a_WeekDayError;
	}
	public void setA_WeekDayError(String a_WeekDayError) {
		this.a_WeekDayError = a_WeekDayError;
	}
	
	public String getA_WeekEndError() {
		return a_WeekEndError;
	}
	public void setA_WeekEndError(String a_WeekEndError) {
		this.a_WeekEndError = a_WeekEndError;
	}
	public String getA_WeekError() {
		return a_WeekError;
	}
	public void setA_WeekError(String a_WeekError) {
		this.a_WeekError = a_WeekError;
	}
	public String getA_GpsError() {
		return a_GpsError;
	}
	public void setA_GpsError(String a_GpsError) {
		this.a_GpsError = a_GpsError;
	}
	public String getA_OnStarError() {
		return a_OnStarError;
	}
	public void setA_OnStarError(String a_OnStarError) {
		this.a_OnStarError = a_OnStarError;
	}
	public String getA_SiriusXMError() {
		return a_SiriusXMError;
	}
	public void setA_SiriusXMError(String a_SiriusXMError) {
		this.a_SiriusXMError = a_SiriusXMError;
	}
	

	
	public String getA_errorMsg() {
		return a_errorMsg;
	}
	public void setA_errorMsg() {
		if (!a_CarNameError.equals("") || !a_WeekError.equals("") || !a_CapacityError.equals("")||!a_WeekDayError.equals("")
				||!a_WeekEndError.equals("") || !a_GpsError.equals("") || !a_OnStarError.equals("") || !a_SiriusXMError.equals(""))
			a_errorMsg="Please correct the following errors";
	}
	
}
