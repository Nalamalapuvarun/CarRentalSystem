package model;

public class PaymentModel {
	private String cardtype;
	private String cardno;
	private String expirationdate;
	private String cvvno;
	
	public String getCardtype() {
		return cardtype;
	}
	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}
	public String getCardno() {
		return cardno;
	}
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	public String getExpirationdate() {
		return expirationdate;
	}
	public void setExpirationdate(String expirationdate) {
		this.expirationdate = expirationdate;
	}
	public String getCvvno() {
		return cvvno;
	}
	public void setCvvno(String cvvno) {
		this.cvvno = cvvno;
	}
	public PaymentModel(String cardtype, String cardno, String expirationdate, String cvvno ) {
		super();
		this.cardtype=cardtype;
		this.cardno=cardno;
		this.expirationdate=expirationdate;
		this.cvvno=cvvno;
	}
	public PaymentModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void validatePaymentModel(PaymentModel payment, payment_errormsgs paymenterrorMsgs)
	{
		
		paymenterrorMsgs.setP_cardnoError(validatecardno(payment.getCardno()));
		paymenterrorMsgs.setP_expirationdateError(validateexpirationdate(payment.getExpirationdate()));
		paymenterrorMsgs.setP_cvvnoError(validatecvvno(payment.getCvvno()));
		paymenterrorMsgs.setP_errorMsg();
	}
	
//	private boolean stringSize(String string, int min, int max) {
//		return string.length()>=min && string.length()<=max;
//	}

	private String validatecardno(String cardno) {
		String result="";
		if(cardno.isEmpty())
		{
			result="card number cant be empty";
		}

		else if(!isTextAnInteger(cardno))
		{
			result="you just have to enter numbers";
		}
		else if(!(cardno.length()==16))
		{
			result="Card number should be 16 digits";
		}
		else
		{
			result="";
		}
		return result;
	}
	private String validatecvvno(String cvvno) {
		String result="";
		if(cvvno.isEmpty())
		{
			result="cvv number cant be empty";
		}

		else if(!isTextAnInteger(cvvno))
		{
			result="you just have to enter numbers";
		}
		else if(!(cvvno.length()== 3))
		{  
			
			result="cvv number should be 3 digits";
		}
		else
		{
			result="";
		}
		return result;
	}
	
	private String validateexpirationdate(String expirationdate)
	{
		String result="";
		if(expirationdate.isEmpty())
		{
			result="Expiration date cannot be empty";
		}
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
