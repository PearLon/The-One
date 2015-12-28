package formbean;

import org.apache.struts.action.ActionForm;

public class userform extends ActionForm{

	private Integer ID;
	private String NAME;
	private String PASSWORD;
	private String SEX;
	private String PHONE;
	private String POST;
	private Integer CLASS;
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public String getSEX() {
		return SEX;
	}
	public void setSEX(String sEX) {
		SEX = sEX;
	}
	public String getPHONE() {
		return PHONE;
	}
	public void setPHONE(String pHONE) {
		PHONE = pHONE;
	}
	public String getPOST() {
		return POST;
	}
	public void setPOST(String pOST) {
		POST = pOST;
	}
	public Integer getCLASS() {
		return CLASS;
	}
	public void setCLASS(Integer cLASS) {
		CLASS = cLASS;
	}
	
}
