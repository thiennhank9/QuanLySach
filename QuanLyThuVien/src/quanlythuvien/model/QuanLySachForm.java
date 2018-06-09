package quanlythuvien.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 *@author: nguyenkhue
 *@version 1.0 Nov 28, 2015
 */
public class QuanLySachForm {
	private List<QuanLySach> listQuanLySach;
	private List<Sach> listSach;
	private HashMap<Integer, String> listIdThongTinMuonTraSach;
	
	public QuanLySachForm(){
		listQuanLySach = new ArrayList<QuanLySach>();
		listSach = new ArrayList<Sach>();
		listIdThongTinMuonTraSach = new HashMap<Integer, String>();
	}
	
	public List<QuanLySach> getListQuanLySach() {
		return listQuanLySach;
	}

	public void setListQuanLySach(List<QuanLySach> listQuanLySach) {
		this.listQuanLySach = listQuanLySach;
	}

	public List<Sach> getListSach() {
		return listSach;
	}

	public void setListSach(List<Sach> listSach) {
		this.listSach = listSach;
	}

	public HashMap<Integer, String> getListIdThongTinMuonTraSach() {
		return listIdThongTinMuonTraSach;
	}

	public void setListIdThongTinMuonTraSach(HashMap<Integer, String> listIdThongTinMuonTraSach) {
		this.listIdThongTinMuonTraSach = listIdThongTinMuonTraSach;
	}
}
