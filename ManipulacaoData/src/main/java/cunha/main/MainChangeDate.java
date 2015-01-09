package cunha.main;

import cunha.date.ChangeDate;

/***
 * 
 * @author Leandro
 * Classe Principal do Projeto
 */
public class MainChangeDate {
	public static void main(String[] args) {
		ChangeDate c = new ChangeDate();
		System.out.println( c.changeDate("01/03/2010 23:00", '+',  10 ));
		System.out.println( c.changeDate("01/03/2010 23:00", '-',  10 ));
	}
}