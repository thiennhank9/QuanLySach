package quanlythuvien.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import quanlythuvien.model.ThanhVien;
import quanlythuvien.model.ThongTinMuonTra;

/*
 *@author: nguyenkhue
 *@version 1.0 Dec 15, 2015
 */
@Repository("quanlyThanhVienDAO")
@Transactional
public class QuanLyThanhVienDAO {

	@Autowired
	private SessionFactory sessionFactory;

	// Lấy tất cả thành viên (id, tên, giới tính, email, tình trạng)
	@SuppressWarnings("unchecked")
	public List<ThanhVien> getListThanhVien() {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(ThanhVien.class);
		ProjectionList projList = Projections.projectionList();
		projList.add(Projections.property("idThanhVien"));
		projList.add(Projections.property("tenThanhVien"));
		projList.add(Projections.property("gioiTinh"));
		projList.add(Projections.property("email"));
		projList.add(Projections.property("tinhTrang"));
		crit.setProjection(projList);
		List<Object> results = (List<Object>) crit.list();
		List<ThanhVien> listThanhVien = new ArrayList<ThanhVien>();
		Iterator<Object> itr = results.iterator();
		ThanhVien thanhVien;
		while (itr.hasNext()) {
			thanhVien = new ThanhVien();
			Object[] obj = (Object[]) itr.next();
			thanhVien.setIdThanhVien(String.valueOf(obj[0]));
			thanhVien.setTenThanhVien(String.valueOf(obj[1]));
			thanhVien.setGioiTinh(String.valueOf(obj[2]));
			thanhVien.setEmail(String.valueOf(obj[3]));
			thanhVien.setTinhTrang(String.valueOf(obj[4]));
			listThanhVien.add(thanhVien);
		}
		return listThanhVien;
	}

	// Kiểm tra xem id nhập vào có bị trùng hay không
	public boolean isIdTrung(String idThanhVien) {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(ThanhVien.class);
		crit.add(Restrictions.eq("idThanhVien", idThanhVien));
		crit.setMaxResults(1);
		ThanhVien ThanhVienMuon = (ThanhVien) crit.uniqueResult();
		if (ThanhVienMuon != null) {
			return true;
		} else {
			return false;
		}
	}

	// Thêm độc giả
	public void themThanhVien(ThanhVien thanhVien) {
		Session session = sessionFactory.getCurrentSession();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		thanhVien.setNgayThem(dateFormat.format(date));
		thanhVien.setTinhTrang("Active");
		thanhVien.setListThongTinMuonTra(null);
		session.saveOrUpdate(thanhVien);
		session.flush();
	}

	// Khôi phục IdThanhVien trong bảng thông tin mượn trả
	public void restoredIdThanhVien(String idThanhVien, Integer idThongTinMuonTra) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "update thongtinmuontra set idthanhvien=? where idthongtinmuontra=? ";
		Query query = session.createSQLQuery(sql);
		query.setParameter(0, idThanhVien);
		query.setParameter(1, idThongTinMuonTra);
		query.executeUpdate();
	}

	// Get độc giả theo id
	public ThanhVien getThanhVien(String idThanhVien) {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(ThanhVien.class);
		crit.add(Restrictions.eq("idThanhVien", idThanhVien));
		crit.setMaxResults(1);
		ThanhVien thanhVien = (ThanhVien) crit.uniqueResult();
		return thanhVien;
	}

	// Kiểm tra xem độc giả có đang mượn thành viên hay không (kiểm tra theo id,
	// trả về true
	// nếu đang được mượn)
	public boolean isDangMuon(ThanhVien thanhVien) {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(ThongTinMuonTra.class);
		crit.add(Restrictions.eq("thanhVien", thanhVien));
		crit.add(Restrictions.isNull("ngayTra"));
		crit.setMaxResults(1);
		ThongTinMuonTra ThanhVienMuon = (ThongTinMuonTra) crit.uniqueResult();
		if (ThanhVienMuon != null) {
			return true;
		} else {
			return false;
		}
	}

	// Get id trong bảng thông tin mượn trả theo thành viên
	@SuppressWarnings("unchecked")
	public List<Integer> getIdThongTinMuonTra(ThanhVien thanhVien) {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(ThongTinMuonTra.class);
		ProjectionList projList = Projections.projectionList();
		projList.add(Projections.property("idThongTinMuonTra"));
		crit.add(Restrictions.eq("thanhVien", thanhVien));
		crit.setProjection(projList);
		List<Integer> results = crit.list();
		return results;
	}

	// Xóa thành viên
	public void deleteThanhVien(ThanhVien thanhVien) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(thanhVien);
		session.flush();
	}

	// Update thành viên theo id cũ (có thể update cả id)
	public void updateThanhVien(ThanhVien thanhVien, String oldId) {
		Session session = sessionFactory.getCurrentSession();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String sql = "update thanhvien set idthanhvien=?, tenthanhvien=?, email=?, ngaysinh=?"
				+ ",ngaycapnhat=?, gioitinh=? where idthanhvien=? ";
		Query query = session.createSQLQuery(sql);
		query.setParameter(0, thanhVien.getIdThanhVien());
		query.setParameter(1, thanhVien.getTenThanhVien());
		query.setParameter(2, thanhVien.getEmail());
		query.setParameter(3, thanhVien.getNgaySinh());
		query.setParameter(4, dateFormat.format(date));
		query.setParameter(5, thanhVien.getGioiTinh());
		query.setParameter(6, oldId);
		query.executeUpdate();
	}

	// Check xem id nhap vao co phai la id thanh vien hay khong
	public boolean isThanhVien(String idThanhVien) {
		Session session = sessionFactory.getCurrentSession();
		String result = (String) session.createCriteria(ThanhVien.class)
				.add(Restrictions.eq("idThanhVien", idThanhVien))
				.setProjection(Projections.projectionList().add(Projections.property("idThanhVien"))).uniqueResult();
		if (result != null)
			return true;
		return false;
	}

	// Check xem id nhap vao co phai la id thanh vien va co trang thai active hay khong
	public boolean isThanhVienHopLe(String idThanhVien) {
		Session session = sessionFactory.getCurrentSession();
		String result = (String) session.createCriteria(ThanhVien.class)
				.add(Restrictions.eq("idThanhVien", idThanhVien)).add(Restrictions.eq("tinhTrang", "Active"))
				.setProjection(Projections.projectionList().add(Projections.property("idThanhVien"))).uniqueResult();
		if (result != null)
			return true;
		return false;
	}
	
	public void setTinhTrangMuon(String idThanhVien){
		Session session = sessionFactory.getCurrentSession();
		String sql = "update thanhvien set tinhtrang=? where idthanhvien=? ";
		Query query = session.createSQLQuery(sql);
		query.setParameter(0, "Closed");
		query.setParameter(1, idThanhVien);
		query.executeUpdate();
	}
	
	public void setTinhTrangTra(String idThanhVien){
		Session session = sessionFactory.getCurrentSession();
		String sql = "update thanhvien set tinhtrang=? where idthanhvien=? ";
		Query query = session.createSQLQuery(sql);
		query.setParameter(0, "Active");
		query.setParameter(1, idThanhVien);
		query.executeUpdate();
	}
}
