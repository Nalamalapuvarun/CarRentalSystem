package model;

public class ManagerModel {
	private String confirmationid;
	private String UTAID;
	private String Username ;
	private String curpassword ;
	private String newpassword ;
	private String conpassword ;
	private String fullName ;
	private String email ;
	private String PhoneNo ;
	private String addr ;
	private String startdate;
	private String enddate;
	private String Reservationid;
	private String CarName;
	private String StartTime;
	private String EndTime;
	private String Capacity;
	private String WeekDay;
	private String WeekEnd;
	private String Week;
	private String Gps;
	private String OnStar;
	private String SiriusXM;
	
	public String getCapacity() {
		return Capacity;
	}
	public void setCapacity(String Capacity) {
		this.Capacity = Capacity;
	}
	public String getWeekEnd() {
		return WeekEnd;
	}
	public void setWeekEnd(String WeekEnd) {
		this.WeekEnd = WeekEnd;
	}
	public String SiriusXM() {
		return SiriusXM;
	}
	public void setSiriusXM(String SiriusXM) {
		this.SiriusXM = SiriusXM;
	}
	public String OnStar() {
		return OnStar;
	}
	public void setOnStar(String OnStar) {
		this.OnStar = OnStar;
	}
	public String getGps() {
		return Gps;
	}
	public void setGps(String Gps) {
		this.Gps = Gps;
	}
	public String getWeek() {
		return Week;
	}
	public void setWeek(String Week) {
		this.Week = Week;
	}
	public String getWeekDay() {
		return WeekDay;
	}
	public void setWeekDay(String WeekDay) {
		this.WeekDay = WeekDay;
	}
	public String getstartdate() {
		return startdate;
	}
	public void setstartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getenddate() {
		return enddate;
	}
	public void setenddate(String enddate) {
		this.enddate = enddate;
	}
	public String getReservationid() {
		return Reservationid;
	}
	public void setReservationid(String Reservationid) {
		this.Reservationid = Reservationid;
	}
	public String getCarName() {
		return CarName;
	}
	public void setCarName(String CarName) {
		this.CarName = CarName;
	}
	public String getStartTime() {
		return StartTime;
	}
	public void setStartTime(String StartTime) {
		this.StartTime = StartTime;
	}
	public String getEndTime() {
		return EndTime;
	}
	public void setEndTime(String EndTime) {
		this.EndTime = EndTime;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getcurpassword() {
		return curpassword;
	}

	public void setcurpassword(String curpassword) {
		this.curpassword = curpassword;
	}
	
	public String getnewpassword() {
		return newpassword;
	}

	public void setnewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	
	public String getconpassword() {
		return conpassword;
	}

	public void setconpassword(String conpassword) {
		this.conpassword = conpassword;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
 
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return PhoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		PhoneNo = phoneNo;
	}

	public String getaddr() {
		return addr;
	}

	public void setaddr(String addr) {
		this.addr = addr;
	}
	
	public String setconfirmationid() {
		return confirmationid;
	}
	public void getconfirmationid(String confirmationid) {
		this.confirmationid = confirmationid;
	}
	public String setUTAID() {
		return UTAID;
	}
	public void getUTAID(String UTAID) {
		this.UTAID = UTAID;
	}
	
}
