package northwest.common.web.action;

import northwest.common.value.*;
import northwest.common.service.BillManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

public class BillQAAction extends CommonActionSupport {

	private static final long serialVersionUID = 1L;
	private final Log log;
	private BillQA billQA;
	private Long[] selectedBillQAIds;
	Bill bill;

	public BillQAAction() {
		log = LogFactory.getLog(northwest.common.web.action.BillQAAction.class);
	}

	public Function getFunction() {
		return getGenericManager().getFunctionByKey("BILLQA");
	}

	public BillQA getBillQA() {
		return billQA;
	}

	public void setBillQA(BillQA val) {
		billQA = val;
	}

	public void setGenericManager(BillManager m) {
		super.setGenericManager(m);
	}

	public BillManager getGenericManager() {
		return (BillManager) super.getGenericManager();
	}

	public String delete() {		
		billQA=getGenericManager().getBillQAById(billQA.getId());
		appendXworkParam("bill.id="+billQA.getBill().getId());
		System.out.println("delete billQA.getBillId="+billQA.getBill().getId());
		getGenericManager().removeBillQA(billQA.getId());
		return DELETE;
	}

	public String edit() {
		if (billQA == null) {
			billQA = new BillQA();
			bill=getGenericManager().getBillById(bill.getId());
			billQA.setBill(bill);
		} else if (billQA.getId() != null) {
			billQA = getGenericManager().getBillQAById(billQA.getId());
			bill=billQA.getBill();
		} else { // TODO
		}
		beanToForm();

		return SUCCESS;
	}

	public String copy() {
		if (selectedBillQAIds != null && selectedBillQAIds.length > 0) {
			BillQA obj = getGenericManager().getBillQAById(selectedBillQAIds[0]);
			obj.setId(null);
			billQA = obj;
		}
		beanToForm();

		return SUCCESS;
	}

	public String execute() {
		log.info("entering 'execute' method");
		if (getDelete() != null) {
			return delete();
		} else {
			formToBean();
			if (inputValidation(billQA) == false)
				return INPUT;
		}
		return SUCCESS;
	}

	public boolean inputValidation(BillQA val) {
		return true;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public String save() {
		log.info("entering 'save' method");
		java.sql.Timestamp ts = Tools.getCurrentTimestamp();
		if (billQA.getId() == null) {
			billQA.setCreatedDate(ts);
		}
		billQA.setLastModifiedDate(ts);
		getGenericManager().saveBillQA(billQA);
		appendXworkParam("bill.id="+billQA.getBill().getId());
		return SUCCESS;
	}

	public String list() {
		try{
			System.out.println("list bill.getId()="+bill.getId());
			bill=getGenericManager().getBillById(bill.getId());
		}catch(Exception e){}
		return SUCCESS;
	}

	protected void beanToForm() {
		log.info("enter beanToForm()");
		log.info("exit beanToForm()");
	}

	protected void formToBean() {
		log.info("enter formToBean()");
		billQA.setBill(getGenericManager().getBillById(billQA.getBillId()));
		log.info("exit formToBean()");
	}

	public List<Bill> getBillList() {
		return getGenericManager().getBillList(); // TODO
	}

	public List<BillQA> getBillQAList() {
		bill = getGenericManager().getBillById(bill.getId());
		return getGenericManager().getBillQAList(bill);
	}

	public void setSelectedBillQAIds(Long[] val) {
		selectedBillQAIds = val;
	}

	public Long[] getSelectedBillQAIds() {
		return selectedBillQAIds;
	}
}
