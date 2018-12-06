package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import data.transactionDAO;

public class Searchcar {

	
	private String StartDate;
	private String EndDate;
	private String StartTime;
	private String EndTime;
	private String Passengers;

public String getStartDate() {
	return StartDate;
}
public void setStartDate(String startDate) {
	StartDate = startDate;
}
public String getEndDate() {
	return EndDate;
}
public void setEndDate(String endDate) {
	EndDate = endDate;
}
public String getStartTime() {
	return StartTime;
}
public void setStartTime(String startTime) {
	StartTime = startTime;
}
public String getEndTime() {
	return EndTime;
}
public void setEndTime(String endTime) {
	EndTime = endTime;
}
public String getPassengers() {
	return Passengers;
}
public void setPassengers(String passengers) {
	Passengers = passengers;
}
public Searchcar(String startdate, String enddate, String starttime , String endtime, String capacity) {
	super();
StartDate=startdate;
EndDate=enddate;
StartTime=starttime;
EndTime=endtime;
Passengers=capacity;

}
public Searchcar() {
	// TODO Auto-generated constructor stub
}
public void validatesearch(Searchcar search, SearchCar_errormsgs scerror) throws ParseException {
	
	scerror.setS_capacityError(validatecapacity(search.getPassengers()));
	scerror.setS_startdateError(validatestartdate(search.getStartDate()));
	scerror.setS_enddateError(validateenddate(search.getStartDate(),search.getEndDate()));
	scerror.setS_starttimeError(validatestarttime(search.getStartTime()));
	scerror.setS_endtimeError(validateendtime(search.getStartDate(),search.getEndDate(),search.getStartTime(),search.getEndTime()));
	scerror.setS_errorMsg();


}


public String validatecapacity(String cap)
{
	String result="";
	int capacity = Integer.parseInt(cap);
	
	 if(capacity <= 0)
	{
	result="Capacity Cannot be negative or Zero";
	}
	else if(capacity > 9)
	{
	result="Maximun capacity is 9";
	}
	
	else
	{
		result="";	
	}

	return result;
}


public String validatestartdate(String stdate )
{ String result="";
	
	{
		result="";
		
	}
	
	return result;
}

public String validateenddate(String stdate,String enddate ) throws ParseException
{ String result="";
transactionDAO tc = new transactionDAO();
	
	if(((tc.searchdates(stdate, enddate)) != 1))
	{
		result="The enddate ****** has to be after the start date";
		
	}
	else
	{
		result="";
	}
	System.out.println("the result for this is"+result);
	return result;
}
public String validatestarttime(String sttime )
{ String result="";
	
		result="";
		
	
	
	return result;
}

public String validateendtime(String stdate,String enddate,String sttime,String endtime) throws ParseException
{
	String result="";
	transactionDAO t = new transactionDAO();
	SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
	java.util.Date d1= sd.parse(StartDate);
	java.util.Date d2= sd.parse(EndDate);
	int compare = d2.compareTo(d1);
	System.out.println(StartDate);
	System.out.println(EndDate);
	SimpleDateFormat timefm = new SimpleDateFormat("hh:mm:ss");
	Date datetime1 = timefm.parse(StartTime);
	Date datetime2 = timefm.parse(EndTime);
	int compare1 = datetime2.compareTo(datetime1);
	
	 if(compare1 != 1){
		if(datetime2.compareTo(datetime1) != 1){
			result = "endtime should be greater than the start time";
		}
		
	}
	else
	{
		result="";	
	}
	return result;
	
}
}


