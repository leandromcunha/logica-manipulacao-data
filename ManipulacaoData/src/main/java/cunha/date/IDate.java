package cunha.date;

import java.io.Serializable;

import cunha.bean.IBean;

public interface IDate <T extends IBean > extends Serializable {
	public String getDate() throws Exception;
}