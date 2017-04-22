package index;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Test2 {
	public static void main(String[] args) throws ParseException {
		String b1="2016-09-10";
		String b2="2016-09-11";
		DateFormat DF_YMDS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d1 = getCancelTime(b1,0);
		Date d2 = getCancelTime(b2,0);
		System.out.println(DF_YMDS.format(d1));
		System.out.println(DF_YMDS.format(d2));
	}



	public static Date getCancelTime(String beginTime,int timeType) throws ParseException{
		Calendar cal = new GregorianCalendar();
		//String str = DF_MS.format(cal.getTime());
		DateFormat DF_YMDS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DateFormat DF = new SimpleDateFormat("yyyy-MM-dd");
		Date beginDate = DF.parse(beginTime);
		if(beginDate.getTime()<cal.getTime().getTime()){
			beginDate = cal.getTime();
		}
		String nowYMD = DF.format(cal.getTime());
		int hour = cal.get(Calendar.HOUR_OF_DAY);

		if(/*(hour>=20||(hour>0&&hour<=4))&&*/nowYMD.equals(beginTime)){
			return new Date(beginDate.getTime()+2*60*60*1000);
		}else{
			if(timeType==0){
				return DF_YMDS.parse(DF.format(beginDate.getTime())+" "+"20:00:00");
			}else{
				return DF_YMDS.parse(DF.format(beginDate.getTime())+" "+"20:00:00");
			}
		}
	}
}