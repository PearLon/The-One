package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import dao.medicinedao;
import dao.totaldao;

public class totalaction extends DispatchAction{
//≤È—Øœ˙ €
	  public ActionForward search(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		List list=null;
		totaldao dao=new totaldao();
		list=dao.salelist();
		int pagenumber=list.size();
		System.out.print(pagenumber);
		int maxpage=pagenumber;
		String number=request.getParameter("i");
		if(maxpage % 8==0){
			maxpage=maxpage/8;
		}else{
			maxpage=maxpage/8+1;
		}
		if(number==null){
			number="0";
		}
		request.setAttribute("number", String.valueOf(number));
		request.setAttribute("pagenumber", String.valueOf(pagenumber));
		request.setAttribute("maxpage", String.valueOf(maxpage));
		request.setAttribute("list", list);
		return mapping.findForward("search7");
		
	}
	  
}
