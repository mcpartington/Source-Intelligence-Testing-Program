/**
 * @author Maxwell
 */
import org.junit.runner.JUnitCore;
import sitest.SItest;

import Email.GoogleMail;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.joda.time.Interval;
//import org.joda.time.

public class Main 
{
  
  public static void main(String[] args) throws AddressException, MessagingException 
  {
    Calendar cal = Calendar.getInstance();
    cal.getTime();
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    
    DateTime StartTime = new DateTime(2013,7,10,13,20,0,0);
    DateTime EndTime = new DateTime(2013,7,10,13,30,00);
            
    DateTime time = new org.joda.time.DateTime();
    
    LocalTime STime = new LocalTime(04,55,00);
    LocalTime ETime = new LocalTime(05,00,00);
    
    //Interval inclusiveTime = new Interval(STime,ETime);
    
    System.out.println(StartTime);
    System.out.println(EndTime);
    System.out.println(time);
    
    Result result = JUnitCore.runClasses(SItest.class);//.newInstance(baseUrl);
    for (Failure failure : result.getFailures()) 
    {
      System.out.println(failure.toString());
      GoogleMail.Send("mcpartington", "examplepassword","mcpartington@gmail.com","ERROR", "The following error has occurred:\n\n" + failure.toString());
      return;
    }
    
//    if (inclusiveTime.contains(time))//((sdf.format(cal.getTime())).equals("05:00:00") || (sdf.format(cal.getTime())).equals("18:00:00"))
//    {
//            System.out.println("Sending email...");
//            GoogleMail.Send("mcpartington", "examplepassword","mcpartington@gmail.com","Complete.", "Your test has completed successfully. Website is functional.");
//    }
  }
}