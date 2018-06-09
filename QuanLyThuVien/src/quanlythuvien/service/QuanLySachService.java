package quanlythuvien.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import quanlythuvien.model.QuanLySach;
import quanlythuvien.model.Sach;
import quanlythuvien.dao.QuanlysachDAO;

/*
 *@author: nguyenkhue
 *@version 1.0 Nov 25, 2015
 */
@Service("quanLySachService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class QuanLySachService {

	@Autowired
	QuanlysachDAO quanLySachDAO;

	// Lấy ra list quản lý sách (id, tên, giá, số lượng, số lượng đang đc mượn)
	public List<QuanLySach> getListQuanLySach() {
		List<QuanLySach> listQuanLySach = new ArrayList<QuanLySach>();
		List<Sach> listSach = quanLySachDAO.getListSach();
		List<Sach> listSachMuon = quanLySachDAO.getListThongTinMuonTraSach();
		int i = 0, count;
		QuanLySach quanLySach;
		while (i < listSach.size()) {
			count = 0;
			for (int j = 0; j < listSachMuon.size(); j++) {
				if (listSachMuon.get(j).getIdSach().equals(listSach.get(i).getIdSach())) {
					count++;
				}
			}
			quanLySach = new QuanLySach();
			quanLySach.setIdSach(listSach.get(i).getIdSach());
			quanLySach.setTenSach(listSach.get(i).getTenSach());
			quanLySach.setGia(listSach.get(i).getGia());
			quanLySach.setSoLuong(listSach.get(i).getSoLuong());
			quanLySach.setDangMuon(count);
			listQuanLySach.add(quanLySach);
			i++;
		}
		return listQuanLySach;
	}

	// Lấy ra một đối tượng quản lý sách (id, tên, giá, số lượng, số lượng đang đc mượn)
	public QuanLySach getQuanLySach(String idSach) {
		QuanLySach quanLySach = null;
		List<QuanLySach> listQuanLySach = getListQuanLySach();
		int i = 0;
		while (i < listQuanLySach.size()) {
			if (listQuanLySach.get(i).getIdSach().equals(idSach)) {
				quanLySach = listQuanLySach.get(i);
			}
			i++;
		}
		return quanLySach;
	}

	// Get sách theo id
	public Sach getSach(String idSach) {
		return quanLySachDAO.getSach(idSach);
	}

	// Update sách theo id cũ (có thể update id)
	public void updateSach(Sach sach, String oldId) {
		quanLySachDAO.updateSach(sach, oldId);
	}

	// Xóa sách, đồng thời lưu thông tin idThongTinMuonTra(value) theo idSach(key) trong bảng thông tin mượn trả
	public void deleteSach(Sach sach, HashMap<Integer, String> listIdThongTinMuonTraSach) {
		List<Integer> listIdBySach = quanLySachDAO.getIdThongTinMuonTra(sach);
		System.out.println(listIdBySach.size());
		int i = 0;
		while (i < listIdBySach.size()) {
			Integer idThongTinMuonTra = listIdBySach.get(i);
			String idSach = sach.getIdSach();
			listIdThongTinMuonTraSach.put(idThongTinMuonTra, idSach);
			i++;
		}
		quanLySachDAO.deleteSach(sach);
	}

	// Sách có đang được mượn hay không (kiểm tra theo id, trả về true nếu đang được mượn)
	public boolean isDangMuon(Sach sach) {
		return quanLySachDAO.isDangMuon(sach);
	}

	// id nhập vào có bị trùng hay không (trả về true nếu trùng)
	public boolean isIdTrung(String idSach) {
		return quanLySachDAO.isIdTrung(idSach);
	}

	// Chỉ thêm sách Thêm sách
	public void themSach(Sach sach) {
		quanLySachDAO.themSach(sach);
	}

	// Thêm sách đồng thời khôi phục idSach trong bảng thông tim mượn trả theo idThongTinMuonTra
	public void themSach(Sach sach, List<Integer> listIdThongTinMuonTra) {
		quanLySachDAO.themSach(sach);
		int i = 0;
		while (i < listIdThongTinMuonTra.size()) {
			quanLySachDAO.restoredIdSach(sach.getIdSach(), listIdThongTinMuonTra.get(i));
			i++;
		}
	}

	// Lấy tất cả các loại sách (không trùng nhau)
	public List<String> getListLoaiSach() {
		List<String> oldListLoaiSach = quanLySachDAO.getListLoaiSach();
		List<String> listLoaiSach = new ArrayList<String>();
		String fistString = new String();
		int i = 0;
		while (i < oldListLoaiSach.size()) {
			if (fistString.compareTo(oldListLoaiSach.get(i)) != 0) {
				fistString = oldListLoaiSach.get(i);
				listLoaiSach.add(fistString);
			}
			i++;
		}
		return listLoaiSach;
	}

	// Search sách theo id, tên, mô tả, tên tác giả, loại
	public List<Sach> searchSach(String value) {
		return quanLySachDAO.searchSach(value);
	}

	// Search id sách theo id, tên, mô tả, tên tác giả, loại
	public List<String> searchIdSach(String value) {
		return quanLySachDAO.searchIdSach(value);
	}
}
