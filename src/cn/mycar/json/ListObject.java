package cn.mycar.json;
import java.util.List;

/*
 * ����JSON������ListObject
 */
public class ListObject extends AbstractJSON {
 
    private List<?> data;

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}   
    
}

