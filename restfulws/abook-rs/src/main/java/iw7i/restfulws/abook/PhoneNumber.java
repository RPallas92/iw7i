package iw7i.restfulws.abook;

import static iw7i.restfulws.abook.PhoneType.*;

/**
 * A phone number 
 *
 */
public class PhoneNumber {
	
	private String number;
	private PhoneType type = HOME;

	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public PhoneType getType() {
		return type;
	}
	public void setType(PhoneType type) {
		this.type = type;
	}

}
