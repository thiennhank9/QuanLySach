package quanlythuvien.dao;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import quanlythuvien.model.ThongTinMuonTra;

/**
 * @author: nguyenkhue
 * @version: 1.0 Dec 18, 2015
 */
@Repository("thongTinMuonTraDAO")
@Transactional
public class ThongTinMuonTraDAO {

	@Autowired
	SessionFactory sessionFactory;

	// Lấy tất cả các record từ bảng thonong tin mượn trả
	@SuppressWarnings("unchecked")
	public List<ThongTinMuonTra> getListThongTinMuonTra() {
		Session session = sessionFactory.getCurrentSession();
		List<ThongTinMuonTra> listThongTinMuonTra = (List<ThongTinMuonTra>) session
				.createCriteria(ThongTinMuonTra.class).list();
		return listThongTinMuonTra;
	}

	// Lấy thông tin mượn trả theo idThongTinMuonTra
	public ThongTinMuonTra getThongTinMuonTra(Integer idThongTinMuonTra) {
		Session session = sessionFactory.getCurrentSession();
		ThongTinMuonTra thongTinMuonTra = (ThongTinMuonTra) session.createCriteria(ThongTinMuonTra.class)
				.add(Restrictions.eq("idThongTinMuonTra", idThongTinMuonTra)).uniqueResult();
		return thongTinMuonTra;
	}

	public void traSach(String idThanhVien, String idSach, String phat) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "update thongtinmuontra set trangthai=?,ngaytra=?,phat=? where idsach=? and idthanhvien=? ";
		Query query = session.createSQLQuery(sql);
		Date date = new Date(new java.util.Date().getTime());
		query.setParameter(0, "Đã trả");
		query.setParameter(1, date);
		query.setParameter(2, phat);
		query.setParameter(3, idSach);
		query.setParameter(4, idThanhVien);
		query.executeUpdate();
	}

	public void muonSach(String idThanhVien, String idSach) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "insert into thongtinmuontra(ngaymuon,ngayhethan,trangthai,idsach,idthanhvien) "
				+ "values(?,?,?,?,?)";
		Query query = session.createSQLQuery(sql);
		Date ngayMuon = new Date(new java.util.Date().getTime());
		Date ngayHetHan = new Date(new java.util.Date().getTime());
		Calendar c = Calendar.getInstance();
		c.setTime(ngayHetHan); 
		c.add(Calendar.DATE, 30);
		query.setParameter(0, ngayMuon);
		query.setParameter(1, c.getTime());
		query.setParameter(2, "Đang Mượn");
		query.setParameter(3, idSach);
		query.setParameter(4, idThanhVien);
		query.executeUpdate();
	}

	public Date getNgayHetHan(String idSach, String idThanhVien) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "select ngayhethan from thongtinmuontra where idsach=? and idthanhvien=? ";
		Query query = session.createSQLQuery(sql);
		query.setParameter(0, idSach);
		query.setParameter(1, idThanhVien);
		Date result = (Date) query.uniqueResult();
		return result;
	}
}
