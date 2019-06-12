package cn.mycar.json;
import java.util.Date;

/*
 * ����AbstractJSON(JSON���ݵ���Ӧ���� )
 */
public class AbstractJSON {
	private int code;                            //��Ӧ״̬�� 
	private String msg;                             //��Ӧ״̬����  
	private int count;
//	private Long time = new Date().getTime();       //ʱ���  
 
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}
 
	public void setMsg(String msg) {
		this.msg = msg;
	}
 
	/*public Long getTime() {
		return time;
	}
 
	public void setTime(Long time) {
		this.time = time;
	}*/
 
	public void setContent(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
 
//	public void setStatusObject(StatusObject statusObject) {
//		this.code = statusObject.getCode();
//		this.msg = statusObject.getMsg();
//	}
}

