package model;

public class CancelReservationModel {
	private String confirmationid;

	public String getConfirmationid() {
		return confirmationid;
	}

	//public void setConfirmationid(String confirmationid) {
		//this.confirmationid = confirmationid;
	//}
	public CancelReservationModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setCancelReservationModel(String confirmationid) {
		
		this.confirmationid= confirmationid;
	}
	public void validateCancelReservationModel(CancelReservationModel cancel, cancelreservation_errormsgs cancelerrorMsgs) {
		 cancelerrorMsgs.setC_confirmationidError(validateconfirmationid(cancel.getConfirmationid()));
		 cancelerrorMsgs.setC_errorMsg();
	 }
	 
	 private String validateconfirmationid(String confirmationid) {
		 String result="";
			if(confirmationid.length()!=6)
			{
				result="please enter the 6 digit  number";
			}
			else if(!isTextAnInteger(confirmationid))
			{
				result="you just have to enter numbers";
				
			}
			else
				result="";
			return result;
		}
	 
	 private boolean isTextAnInteger (String string) {
	        boolean result;
			try
	        {
	            Long.parseLong(string);
	            result=true;
	        } 
	        catch (NumberFormatException e) 
	        {
	            result=false;
	        }
			return result;
		}
}
