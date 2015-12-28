package formbean;


import java.util.Date;

import org.apache.struts.action.ActionForm;

public class totalform extends ActionForm {
	private int ID;
	private String NAME;
	private int ID1;
	private int ID2;
	private int NUMBER;
	private Date DATE;
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public int getID1() {
		return ID1;
	}
	public void setID1(int iD1) {
		ID1 = iD1;
	}
	public int getNUMBER() {
		return NUMBER;
	}
	public void setNUMBER(int nUMBER) {
		NUMBER = nUMBER;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getID2() {
		return ID2;
	}
	public void setID2(int iD2) {
		ID2 = iD2;
	}
	public Date getDATE() {
		return DATE;
	}
	public void setDATE(Date dATE) {
		DATE = dATE;
	}
}
