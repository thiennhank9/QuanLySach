package quanlythuvien.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quanlythuvien.dao.QuanLyThanhVienDAO;
import quanlythuvien.model.ThanhVien;

/*
 *@author: nguyenkhue
 *@version 1.0 Dec 15, 2015
 */
@Service("quanlyThanhVienService")
public class QuanLyThanhVienService {

	@Autowired
	QuanLyThanhVienDAO quanLyThanhVienDAO;

	// Lấy độc giả theo id, tên, giới tính, email, tình trạng
	public List<ThanhVien> getListThanhVien() {
		return quanLyThanhVienDAO.getListThanhVien();
	}

	// Nhập vào idThanhVien, trả về true nếu đã tồn tại idThanhVien trong bảng
	// thành viên
	public boolean isIdTrung(String idThanhVien) {
		return quanLyThanhVienDAO.isIdTrung(idThanhVien);
	}

	// Thêm thành viên
	public void themThanhVien(ThanhVien ThanhVien) {
		quanLyThanhVienDAO.themThanhVien(ThanhVien);
	}

	// Thêm thành viên đồng thời khôi phục idThanhVien trong bảng thông tim mượn
	// trả theo idThongTinMuonTra
	public void themThanhVien(ThanhVien thanhVien, List<Integer> listIdThongTinMuonTra) {
		quanLyThanhVienDAO.themThanhVien(thanhVien);
		int i = 0;
		while (i < listIdThongTinMuonTra.size()) {
			quanLyThanhVienDAO.restoredIdThanhVien(thanhVien.getIdThanhVien(), listIdThongTinMuonTra.get(i));
			i++;
		}
	}

	// Nhập vào idThanhVien trả về một object Thành Viên hoàn chỉnh
	public ThanhVien getThanhVien(String idThanhVien) {
		return quanLyThanhVienDAO.getThanhVien(idThanhVien);
	}

	// Nhập vào thành viên, kiểm tra thành viên đó có đang mượn thành viên hay
	// không
	public boolean isDangMuon(ThanhVien thanhVien) {
		return quanLyThanhVienDAO.isDangMuon(thanhVien);
	}

	// Xóa thành viên, đồng thời lưu thông tin idThongTinMuonTra(value) theo
	// idThanhVien(key) trong bảng thông tin mượn trả
	public void deleteThanhVien(ThanhVien thanhVien, HashMap<Integer, String> listIdThongTinMuonTraThanhVien) {
		List<Integer> listIdByThanhVien = quanLyThanhVienDAO.getIdThongTinMuonTra(thanhVien);
		int i = 0;
		while (i < listIdByThanhVien.size()) {
			Integer idThongTinMuonTra = listIdByThanhVien.get(i);
			String idThanhVien = thanhVien.getIdThanhVien();
			listIdThongTinMuonTraThanhVien.put(idThongTinMuonTra, idThanhVien);
			i++;
		}
		quanLyThanhVienDAO.deleteThanhVien(thanhVien);
	}

	// Update thành viên theo id cũ (có thể update id)
	public void updateThanhVien(ThanhVien thanhVien, String oldId) {
		quanLyThanhVienDAO.updateThanhVien(thanhVien, oldId);
	}
}
