package action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import dao.medicinedao;
import dao.needdao;
import formbean.medicineform;
import formbean.totalform;
import formbean.userform;


public class medicineaction extends DispatchAction{

//��⹺��
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		medicineform medicine=(medicineform)form;
		medicinedao dao=new medicinedao();
		HttpSession session=request.getSession();
		userform user=(userform)session.getAttribute("user");
		SimpleDateFormat date1=new SimpleDateFormat("yy-MM-dd");
		String date2=date1.format(new Date());
		dao.imp(medicine.getNAME(), medicine.getID(),user.getID(),medicine.getNUMBER(),date2);
		if(dao.check(medicine.getID())){
			medicineform medicine2=dao.select3(medicine.getID());
			medicine.setNUMBER(medicine.getNUMBER()+medicine2.getNUMBER());
			dao.update(medicine);
		}
		else{
			dao.insert(medicine);
			}
		request.setAttribute("result", "���ɹ���");
		return mapping.findForward("resultupdate");
	}
	

	
//��������	
	public ActionForward subtract(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
			medicinedao dao=new medicinedao();
			int ID=Integer.parseInt(request.getParameter("ID"));
			int number=Integer.parseInt(request.getParameter("NUMBER"));
			medicineform medicine=dao.select3(ID);
			
			if(medicine==null||medicine.equals(" ")){
				request.setAttribute("result", "�����ڴ�ҩƷ��");
			}else if((medicine.getNUMBER() - number) < 0){
				request.setAttribute("result", "��治��");
			}else{
			//dao.update();
			medicine.setNUMBER(medicine.getNUMBER()-number);
			request.setAttribute("result", "����ɹ���");
			HttpSession session=request.getSession();
			userform user=(userform)session.getAttribute("user");
			SimpleDateFormat date1=new SimpleDateFormat("yy-MM-dd");
			String date2=date1.format(new Date());
			System.out.print(date2);
			dao.sale(medicine.getNAME(), medicine.getID(),user.getID(),number,date2);
			dao.update(medicine);
			}
			
		return mapping.findForward("resultupdate");
	}
	
//��ҩƷ����Ϊ������ѯ
	public ActionForward searchname(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		List list=null;
		medicinedao dao=new medicinedao();
		String name=request.getParameter("NAME");
		list=dao.selectname(name);
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
		request.setAttribute("name", name);
		return mapping.findForward("searchresult");
		
	}
//����ҩΪ������ѯ
		public ActionForward search1(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws Exception {
			List list=null;
			medicinedao dao=new medicinedao();
			int i=1;
			list=dao.selectc(i);
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
			request.setAttribute("name", i);
			return mapping.findForward("search1");
			
		}
//����ҩΪ������ѯ
				public ActionForward search2(ActionMapping mapping, ActionForm form,
						HttpServletRequest request, HttpServletResponse response) throws Exception {
					List list=null;
					medicinedao dao=new medicinedao();
					int i=2;
					list=dao.selectw(i);
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
					request.setAttribute("name", i);
					return mapping.findForward("search2");
					
				}
//�Զ�ͯҩΪ������ѯ
				public ActionForward search3(ActionMapping mapping, ActionForm form,
						HttpServletRequest request, HttpServletResponse response) throws Exception {
					List list=null;
					medicinedao dao=new medicinedao();
					int i=1;
					list=dao.selectk(i);
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
					request.setAttribute("name", i);
					return mapping.findForward("search3");
					
				}
				
				
//�Ϳ����������
				public ActionForward searchn(ActionMapping mapping, ActionForm form,
						HttpServletRequest request, HttpServletResponse response) throws Exception {
					List list=null;
					medicinedao dao=new medicinedao();
					list=dao.selectn();
					int pagenumber=list.size();
					request.setAttribute("pagenumber", String.valueOf(pagenumber));
					return mapping.findForward("main");
}
				
				
				
//�Ϳ����ϸ��ѯ
				public ActionForward searchnd(ActionMapping mapping, ActionForm form,
						HttpServletRequest request, HttpServletResponse response) throws Exception {
					List list=null;
					medicinedao dao=new medicinedao();
					list=dao.selectn();
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
					return mapping.findForward("search4");
					
				}
				
				
				
//��ѯ�������ڵ�ҩƷ
				public ActionForward searchd1(ActionMapping mapping, ActionForm form,
						HttpServletRequest request, HttpServletResponse response) throws Exception {
					List list=null;
					medicinedao dao=new medicinedao();
					list=dao.selectd1();
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
					return mapping.findForward("search5");
					
				}
//��ѯ�Ѿ����ڵ�ҩƷ
				public ActionForward searchd2(ActionMapping mapping, ActionForm form,
						HttpServletRequest request, HttpServletResponse response) throws Exception {
					List list=null;
					medicinedao dao=new medicinedao();
					list=dao.selectd2();
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
					return mapping.findForward("search6");
					
				}
				


}
