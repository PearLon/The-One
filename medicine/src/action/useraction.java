package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import dao.studentdao;
import dao.userdao;
import formbean.studentform;
import formbean.userform;

public class useraction extends DispatchAction{
	
	
//��½��֤
	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
			System.out.print("arg0");
			int ID=Integer.valueOf(request.getParameter("ID"));
			userdao dao=new userdao();
			userform user=dao.select(ID);
			if(user==null||user.equals("")){
				request.setAttribute("result", "�����ڴ˻�Ա�������µ�½");
			}else if(!user.getPASSWORD().equals(request.getParameter("PASSWORD").trim())){
				request.setAttribute("result", "������������µ�¼");
			}else{
				request.setAttribute("user", user);
			}
		return mapping.findForward("result");
	}
	
	
//��������
		public ActionForward test(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws Exception {
			System.out.print("000000000000000");
			return null;
		}
}
