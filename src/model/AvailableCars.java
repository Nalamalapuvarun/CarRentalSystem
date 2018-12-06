
package model;

public class AvailableCars {
private String CarName;
private String startDate;
private String EndDate;
private String Starttime;
private String Endtime;
private String capacity;

public AvailableCars()
{
  this.CarName="";
  this.startDate="";
  this.EndDate="";
  this.capacity="";

}

public String getStartDate() {
	return startDate;
}

public void setStartDate(String startDate) {
	this.startDate = startDate;
}

public String getEndDate() {
	return EndDate;
}

public void setEndDate(String endDate) {
	EndDate = endDate;
}

public String getStarttime() {
	return Starttime;
}

public void setStarttime(String starttime) {
	Starttime = starttime;
}

public String getEndtime() {
	return Endtime;
}

public void setEndtime(String endtime) {
	Endtime = endtime;
}

public String getCapacity() {
	return capacity;
}

public void setCapacity(String capacity) {
	this.capacity = capacity;
}

public String getCarName() {
	return CarName;
}

public void setCarName(String carName) {
	CarName = carName;
}


}