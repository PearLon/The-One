package formbean;

import java.sql.Date;

import org.apache.struts.action.ActionForm;

public class medicineform extends ActionForm {

		private Integer ID;
		private String NAME;
		private Integer CLASS1;
		private Integer CLASS2;
		private Date DATE;
		private Integer DAYS;
		private Integer NUMBER;
		private String OTHERS;
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
		public Integer getCLASS1() {
			return CLASS1;
		}
		public void setCLASS1(Integer cLASS1) {
			CLASS1 = cLASS1;
		}
		public Integer getCLASS2() {
			return CLASS2;
		}
		public void setCLASS2(Integer cLASS2) {
			CLASS2 = cLASS2;
		}
		public Date getDATE() {
			return DATE;
		}
		public void setDATE(Date dATE) {
			DATE = dATE;
		}
		public Integer getDAYS() {
			return DAYS;
		}
		public void setDAYS(Integer dAYS) {
			DAYS = dAYS;
		}
		public Integer getNUMBER() {
			return NUMBER;
		}
		public void setNUMBER(Integer nUMBER) {
			NUMBER = nUMBER;
		}
		public String getOTHERS() {
			return OTHERS;
		}
		public void setOTHERS(String oTHERS) {
			OTHERS = oTHERS;
		}
		
}
