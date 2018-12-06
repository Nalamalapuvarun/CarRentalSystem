package controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.transactionDAO;
import model.PaymentModel;
import model.SearchCar_errormsgs;
import model.Searchcar;
import model.payment_errormsgs;



/**
 * Servlet implementation class SearchFunction
 */
@WebServlet("/SearchFunction")
public class SearchFunction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchFunction() { 
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sub=request.getParameter("submit");
		//System.out.println(sub);
		if(sub.equalsIgnoreCase("Search")){
			String startdate = request.getParameter("startdate");
			String enddate = request.getParameter("enddate");
			String starttime = request.getParameter("starttime");
			String endtime =request.getParameter("endtime");
			String capacity =request.getParameter("capacity");
			///System.out.println(startdate + " " + enddate + " " + starttime + " " + endtime + " " + capacity);
			Searchcar sc = new Searchcar(startdate, enddate, starttime, endtime, capacity);
			SearchCar_errormsgs scerror = new SearchCar_errormsgs();
			try{
				sc.validatesearch(sc,scerror); 
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("the errormsgs we get here is "+scerror.getS_errorMsg());
			
			if(scerror.getS_errorMsg().equals(""))
			{
			transactionDAO aa = new transactionDAO();
			ArrayList<String> availableCar = aa.searchcar(startdate, enddate, starttime, endtime, capacity);
			request.setAttribute("startdate", startdate);
			request.setAttribute("enddate", enddate);
			request.setAttribute("starttime", starttime);
			request.setAttribute("endtime", endtime);
			request.setAttribute("capacity", capacity);
			ArrayList<String> bb = new ArrayList<>();
//			bb.add("SUV");
//			bb.add("Smart");
//			bb.add("Compact");
//			request.setAttribute("list", bb);
         
			System.out.println("the carlist is ");
			request.getRequestDispatcher("Display.jsp").forward(request, response);}
			
			else
			{                                         
				request.setAttribute("emsgs", scerror);
				request.setAttribute("mess" , "please correct the following errors");
				request.getRequestDispatcher("searchcarnew.jsp").forward(request, response);
				
			}
			
		}
		if(sub.equalsIgnoreCase("BookMyCar")){
			String startdate = request.getParameter("startdaten");
			String enddate = request.getParameter("enddaten");
			String starttime = request.getParameter("starttimen");
			String endtime =request.getParameter("endtimen");
			String capacity =request.getParameter("capacityn");
			String CarName = request.getParameter("database1");
			String Username = rentalcontrol.g_uname;
			System.out.println("Global username is "+Username);
			System.out.println(startdate + " " + enddate + " " + starttime + " " + endtime + " " + capacity + " " + CarName);
			transactionDAO aa = new transactionDAO();
			int a = aa.isBlackListed(Username) ;
			System.out.println("The value og a is " + a );
			String gps = request.getParameter("GPS");
			String onstar = request.getParameter("OnStar");
			String siriusXm = request.getParameter("siriusXm");
			
			int gp = 1 ; int os = 1 ; int sX = 1 ;
			if(gps == null) gp = 0 ;
			if(onstar == null) os = 0 ;
			if(siriusXm == null) sX = 0 ;
			String CardType = "SUV";  //request.getParameter("CardName");
			String CardNo = request.getParameter("cardno");
			String CardValid = request.getParameter("vt");
			String CardCVV = request.getParameter("cvv");
			PaymentModel payModel = new PaymentModel(CardType, CardNo, CardValid, CardCVV);
			payment_errormsgs payerr = new payment_errormsgs();
			payModel.validatePaymentModel(payModel, payerr);
			System.out.println("The message you get is **" + payerr.getP_errorMsg()+"**");
			if(!payerr.getP_errorMsg().equals("")){
				System.out.println("The message you get is **" + payerr.getP_errorMsg()+"**");
				request.setAttribute("errorMsg", "Please correct the following errors");
				request.setAttribute("emsgs", payerr);
				request.getRequestDispatcher("Display.jsp").forward(request, response);
					
			}
			else if(a==1){
				request.setAttribute("errorMsg", "You are blacklisted Please contact admin");
				request.getRequestDispatcher("Display.jsp").forward(request, response);
				
			}
			
			else{
			
			boolean status = aa.bookcar("SUV", "TusharNew", "09:00:00", "2018-11-30", "11:00:00", "2018-12-01");
			System.out.println(status);
			double price = 0 ;
			System.out.println("going to Booking Info");
			request.setAttribute("startdate", "2018-11-30");
			request.setAttribute("enddate", "2018-12-01");
			request.setAttribute("starttime", "09:00:00");
			request.setAttribute("endtime", "11:00:00");
			request.setAttribute("capacity", "2");
			request.setAttribute("CarName", "SUV");
			try {
			  price = aa.calPrice("2018-11-30", "2018-12-01", "SUV" , gp , os , sX);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("price", price);
			request.getRequestDispatcher("BookingInfo.jsp").forward(request, response);
			}
		}
	}

}
