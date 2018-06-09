package quanlythuvien.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/*
 *@author: nguyenkhue
 *@version 1.0 Dec 17, 2015
 */
public class ThanhVienForm {
	private List<ThanhVien> listThanhVien = new ArrayList<ThanhVien>();
	private HashMap<Integer, String> listIdThongTinMuonTraThanhVien = new HashMap<Integer, String>();

	public List<ThanhVien> getListThanhVien() {
		return listThanhVien;
	}

	public void setListThanhVien(List<ThanhVien> listThanhVien) {
		this.listThanhVien = listThanhVien;
	}

	public HashMap<Integer, String> getListIdThongTinMuonTraThanhVien() {
		return listIdThongTinMuonTraThanhVien;
	}

	public void setListIdThongTinMuonTraThanhVien(HashMap<Integer, String> listIdThongTinMuonTraThanhVien) {
		this.listIdThongTinMuonTraThanhVien = listIdThongTinMuonTraThanhVien;
	}
}
