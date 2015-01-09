
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import cunha.date.ChangeDate;

public class JUnitTest {

	@Test
	public void test() {
		final String  REFERENCE_DATE_TIME = "01/03/2010 23:00";
		final Integer MINUTES             = 4000;
		final String  FORMATTED_DATE_TIME = "dd/MM/yyyy HH:mm";

		try{
			SimpleDateFormat sdf = new SimpleDateFormat( FORMATTED_DATE_TIME );
			Calendar date = Calendar.getInstance();
			date.setTimeInMillis( sdf.parse( REFERENCE_DATE_TIME ).getTime() );
			date.add( Calendar.MINUTE, MINUTES );

			ChangeDate c = new ChangeDate();
			String data =  c.changeDate( REFERENCE_DATE_TIME, '+',  MINUTES );

			Assert.assertEquals( sdf.format( date.getTime() ) , data  );

		}catch( Exception e ){
			e.printStackTrace();
		}
	}

}
