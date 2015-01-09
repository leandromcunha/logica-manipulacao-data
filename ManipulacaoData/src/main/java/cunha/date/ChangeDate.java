package cunha.date;

import java.lang.reflect.Constructor;

import cunha.bean.DateBean;
import cunha.bean.IBean;
import cunha.constants.Operations;

/****
 * 
 * @author Leandro
 *
 */
public class ChangeDate {

	@SuppressWarnings("rawtypes")
	public String changeDate(String date , char operator , int minute ){
		
		String result = "";
		try{
			DateBean bean = DateBean.getDateBean( date );

			Class<? extends IDate<? extends IBean>> kChangeDate = Operations.getOperations( operator ).getDate();
			Constructor[] constructors = kChangeDate.getConstructors();
			Constructor constructor = kChangeDate.getConstructor( constructors[0].getParameterTypes() );
			AbstractDate cDate = (AbstractDate)constructor.newInstance(bean,minute);
			result = cDate.getDate();
		}catch( Exception e ){
			System.out.println( e.getMessage() );
			e.printStackTrace();
		}
		return result;
	}
}
