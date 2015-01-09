package cunha.constants;

import cunha.bean.IBean;
import cunha.date.DateAdd;
import cunha.date.DateSubtract;
import cunha.date.IDate;


public enum Operations {
	ADD( '+',  DateAdd.class ),
	MINUS('-', DateSubtract.class )
	;

	private char op;
	private Class<? extends IDate<? extends IBean>> date;
	
	Operations(char op, Class<? extends IDate<? extends IBean >>  date ) {
		this.setOp(op);
		this.setDate(date);
	}

	public void setOp(char op) {
		this.op = op;
	}

	public char getOp() {
		return op;
	}

	public void setDate(Class<? extends IDate<? extends IBean>> date) {
		this.date = date;
	}

	public Class<? extends IDate<? extends IBean>> getDate() {
		return date;
	}
	
	public static Operations getOperations( char op ) throws Exception {
		for( Operations o : Operations.values() ){
			if( o.getOp() == op ){
				return o;
			}
		}
		throw new Exception("Operator unidentified");
	}
}