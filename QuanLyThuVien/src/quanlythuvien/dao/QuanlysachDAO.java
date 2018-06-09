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
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import quanlythuvien.model.Sach;
import quanlythuvien.model.ThongTinMuonTra;

/*
 *@author: nguyenkhue
 *@version 1.0 Nov 25, 2015
 */
@Repository("quanlysachDAO")
@Transactional
public class QuanlysachDAO {

	@Autowired
	private SessionFactory sessionFactory;

	// Lấy tất cả sách (id, tên, số lượng, giá)
	@SuppressWarnings("unchecked")
	public List<Sach> getListSach() {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Sach.class);
		ProjectionList projList = Projections.projectionList();
		projList.add(Projections.property("idSach"));
		projList.add(Projections.property("tenSach"));
		projList.add(Projections.property("soLuong"));
		projList.add(Projections.property("gia"));
		crit.setProjection(projList);
		List<Object> results = (List<Object>) crit.list();
		List<Sach> listSach = new ArrayList<Sach>();
		Iterator<Object> itr = results.iterator();
		Sach sach;
		while (itr.hasNext()) {
			sach = new Sach();
			Object[] obj = (Object[]) itr.next();
			sach.setIdSach(String.valueOf(obj[0]));
			sach.setTenSach(String.valueOf(obj[1]));
			sach.setSoLuong(Integer.parseInt(String.valueOf(obj[2])));
			sach.setGia(Integer.parseInt(String.valueOf(obj[3])));
			listSach.add(sach);
		}
		return listSach;
	}

	// Lấy tất cả sách trong bảng thông tin mượn trả
	@SuppressWarnings("unchecked")
	public List<Sach> getListThongTinMuonTraSach() {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(ThongTinMuonTra.class);
		ProjectionList projList = Projections.projectionList();
		projList.add(Projections.property("sach"));
		crit.setProjection(projList);
		crit.add(Restrictions.isNotNull("sach"));
		crit.add(Restrictions.isNull("ngayTra"));
		List<Sach> results = (List<Sach>) crit.list();
		return results;
	}

	// Lấy tất cả loại sách (có trùng nhau)
	@SuppressWarnings("unchecked")
	public List<String> getListLoaiSach() {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Sach.class);
		ProjectionList projList = Projections.projectionList();
		projList.add(Projections.property("loai"));
		crit.setProjection(projList);
		List<String> results = crit.list();
		return results;
	}

	// Get sách theo id
	public Sach getSach(String idSach) {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Sach.class);
		crit.add(Restrictions.eq("idSach", idSach));
		crit.setMaxResults(1);
		Sach sach = (Sach) crit.uniqueResult();
		return sach;
	}

	// Update sách theo id cũ (có thể update cả id)
	public void updateSach(Sach sach, String oldId) {
		Session session = sessionFactory.getCurrentSession();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String sql = "update sach set idsach=?, tensach=?, tacgia=?, gia=?, mota=?, ngaycapnhat=?,"
				+ "loai=? where idsach=? ";
		Query query = session.createSQLQuery(sql);
		query.setParameter(0, sach.getIdSach());
		query.setParameter(1, sach.getTenSach());
		query.setParameter(2, sach.getTacGia());
		query.setParameter(3, sach.getGia());
		query.setParameter(4, sach.getMoTa());
		query.setParameter(5, dateFormat.format(date));
		query.setParameter(6, sach.getLoai());
		query.setParameter(7, oldId);
		query.executeUpdate();
	}

	// Xóa sách
	public void deleteSach(Sach sach) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(sach);
		session.flush();
	}

	// Kiểm tra xem sách có đang mượn hay không (kiểm tra theo id, trả vá»� true
	// nếu đang được mượn)
	public boolean isDangMuon(Sach sach) {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(ThongTinMuonTra.class);
		crit.add(Restrictions.eq("sach", sach));
		crit.add(Restrictions.isNull("ngayTra"));
		crit.setMaxResults(1);
		ThongTinMuonTra sachMuon = (ThongTinMuonTra) crit.uniqueResult();
		if (sachMuon != null) {
			return true;
		} else {
			return false;
		}
	}

	// Thêm sách
	public void themSach(Sach sach) {
		Session session = sessionFactory.getCurrentSession();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		sach.setNgayThem(dateFormat.format(date));
		sach.setListThongTinMuonTra(null);
		session.saveOrUpdate(sach);
		session.flush();
	}
	
	//Khôi phục idSach trong bảng thông tin mượn trả
	public void restoredIdSach(String idSach, Integer idThongTinMuonTra){
		Session session = sessionFactory.getCurrentSession();
		String sql = "update thongtinmuontra set idsach=? where idthongtinmuontra=? ";
		Query query = session.createSQLQuery(sql);
		query.setParameter(0, idSach);
		query.setParameter(1, idThongTinMuonTra);
		query.executeUpdate();
	}

	// Kiểm tra xem id nhập vào có bị trùng hay không
	public boolean isIdTrung(String idSach) {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Sach.class);
		crit.add(Restrictions.eq("idSach", idSach));
		crit.setMaxResults(1);
		Sach sachMuon = (Sach) crit.uniqueResult();
		if (sachMuon != null) {
			return true;
		} else {
			return false;
		}
	}

	// Search sách theo id, tên, mô tả, tên tác giả, loại
	@SuppressWarnings("unchecked")
	public List<Sach> searchSach(String value) {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Sach.class);
		Criterion criterionIdSach = Restrictions.like("idSach", value, MatchMode.START);
		Criterion criterionTenSach = Restrictions.like("tenSach", value, MatchMode.ANYWHERE);
		Criterion criterionTacGia = Restrictions.like("tacGia", value, MatchMode.ANYWHERE);
		Criterion criterionLoai = Restrictions.like("loai", value, MatchMode.ANYWHERE);
		// Nếu chuỗi tìm kiếm có độ dài lớn hơn 10 thì mới tìm trong mô tả
		if (value.length() > 10) {
			Criterion criterionMoTa = Restrictions.like("moTa", value, MatchMode.ANYWHERE);
			Disjunction disExp = Restrictions.or(criterionIdSach, criterionTenSach, criterionMoTa,
					criterionTacGia, criterionLoai);
			crit.add(disExp);
		} else {
			Disjunction disExp = Restrictions.or(criterionIdSach, criterionTenSach, criterionTacGia,
					criterionLoai);
			crit.add(disExp);
		}
		List<Sach> results = crit.list();
		return results;
	}

	// Search id sách theo id, tên, mô tả, tên tác giả, loại
	@SuppressWarnings("unchecked")
	public List<String> searchIdSach(String value) {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Sach.class);
		ProjectionList projList = Projections.projectionList();
		projList.add(Projections.property("idSach"));
		crit.setProjection(projList);
		Criterion criterionIdSach = Restrictions.like("idSach", value, MatchMode.START);
		Criterion criterionTenSach = Restrictions.like("tenSach", value, MatchMode.ANYWHERE);
		Criterion criterionTacGia = Restrictions.like("tacGia", value, MatchMode.ANYWHERE);
		Criterion criterionLoai = Restrictions.like("loai", value, MatchMode.ANYWHERE);
		// Nếu chuỗi tìm kiếm có độ dài lớn hơn 10 thì mới tìm trong mô tả
		if (value.length() > 10) {
			Criterion criterionMoTa = Restrictions.like("moTa", value, MatchMode.ANYWHERE);
			Disjunction disExp = Restrictions.or(criterionIdSach, criterionTenSach, criterionMoTa,
					criterionTacGia, criterionLoai);
			crit.add(disExp);
		} else {
			Disjunction disExp = Restrictions.or(criterionIdSach, criterionTenSach, criterionTacGia,
					criterionLoai);
			crit.add(disExp);
		}
		List<String> results = crit.list();
		return results;
	}
	
	//Get id trong bảng thông tin mượn trả theo sách
	@SuppressWarnings("unchecked")
	public List<Integer> getIdThongTinMuonTra(Sach sach){
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(ThongTinMuonTra.class);
		ProjectionList projList = Projections.projectionList();
		projList.add(Projections.property("idThongTinMuonTra"));
		crit.add(Restrictions.eq("sach", sach));
		crit.setProjection(projList);
		List<Integer> results = crit.list();
		return results;
	}
	
	//Check xem id nhap vao co phai la id sach hay khong
	public boolean isIdSach(String idSach) {
		Session session = sessionFactory.getCurrentSession();
		String result = (String) session.createCriteria(Sach.class).add(Restrictions.eq("idSach", idSach))
				.setProjection(Projections.projectionList().add(Projections.property("idSach"))).uniqueResult();
		if(result != null)
			return true;
		return false;
	}
}