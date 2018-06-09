package quanlythuvien.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quanlythuvien.dao.QuanLyThanhVienDAO;
import quanlythuvien.dao.QuanlysachDAO;
import quanlythuvien.dao.ThongTinMuonTraDAO;

/**
 * @author: nguyenkhue
 * @version: 1.0 Dec 19, 2015
 */
@Service("traSachService")
public class MuonTraSachService {
	
	@Autowired
	QuanlysachDAO quanLySachDAO;
	@Autowired
	QuanLyThanhVienDAO quanLyThanhVienDAO;
	@Autowired
	ThongTinMuonTraDAO thongTinMuonTraDAO;
	
	public String kiemTraHopLeTraSach(String idThanhVien,String idSach){
		String result = null;
		if(!quanLySachDAO.isIdSach(idSach)){
			result = "Id sách sau không hợp lệ: " + idSach +"<br>";
		}
		if (!quanLyThanhVienDAO.isThanhVien(idThanhVien)) {
			if(result != null)
				result = result +"Thành viên có mã số: " + idThanhVien + " không tồn tại";
			result = "Thành viên có mã số: " + idThanhVien + " không tồn tại";
		}
		return result;
	}
	
	public String kiemTraHopLeMuonSach(String idThanhVien,String idSach){
		String result = null;
		if(!quanLySachDAO.isIdSach(idSach)){
			result = "Id sách sau không hợp lệ: " + idSach +"<br>";
		}
		if (!quanLyThanhVienDAO.isThanhVienHopLe(idThanhVien)) {
			if(result != null)
				result = result +"Thành viên có mã số: " + idThanhVien + " không thể mượn sách";
			result = "Thành viên có mã số: " + idThanhVien + " không thể mượn sách";
		}
		return result;
	}
	
	public long soNgayQuaHan(String idSach, String idThanhVien){
		Date ngayHetHan = thongTinMuonTraDAO.getNgayHetHan(idSach, idThanhVien);
		if(ngayHetHan == null)
			return -100000;
		long thoiGianHetHan = ngayHetHan.getTime();
		long thoiGianTra = new java.util.Date().getTime();
		long temp = thoiGianTra - thoiGianHetHan;
		long soNgayQuaHan = temp / (24 * 60 * 60 * 1000);
		return soNgayQuaHan;
	}
	
	public void traSach(String idSach, String idThanhVien, String phat){
		thongTinMuonTraDAO.traSach(idThanhVien, idSach, phat);
		quanLyThanhVienDAO.setTinhTrangTra(idThanhVien);
	}
	
	public void muonSach(String idSach, String idThanhVien){
		thongTinMuonTraDAO.muonSach(idThanhVien, idSach);
		quanLyThanhVienDAO.setTinhTrangMuon(idThanhVien);
	}
	
}
