package quanlythuvien.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Sach generated by hbm2java
 */
@Entity
@Table(name = "sach", catalog = "quanlythuvien")
public class Sach implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String idSach;
	private String tenSach;
	private String tacGia;
	private int soLuong;
	private int gia;
	private String moTa;
	private String ngayThem;
	private String ngayCapNhat;
	private String loai;
	private int thoiHanMuon;
	private Set<ThongTinMuonTra> listThongTinMuonTra = new HashSet<ThongTinMuonTra>();

	public Sach() {
	}

	public Sach(String idSach, String tenSach, String tacGia, int soLuong, int gia, String ngayThem,
			String loai, int thoiHanMuon) {
		this.idSach = idSach;
		this.tenSach = tenSach;
		this.tacGia = tacGia;
		this.soLuong = soLuong;
		this.gia = gia;
		this.ngayThem = ngayThem;
		this.loai = loai;
		this.thoiHanMuon = thoiHanMuon;
	}

	public Sach(String idSach, String tenSach, String tacGia, int soLuong, int gia, String moTa,
			String ngayThem, String ngayCapNhat, String loai, int thoiHanMuon,
			Set<ThongTinMuonTra> listThongTinMuonTra) {
		this.idSach = idSach;
		this.tenSach = tenSach;
		this.tacGia = tacGia;
		this.soLuong = soLuong;
		this.gia = gia;
		this.moTa = moTa;
		this.ngayThem = ngayThem;
		this.ngayCapNhat = ngayCapNhat;
		this.loai = loai;
		this.thoiHanMuon = thoiHanMuon;
		this.listThongTinMuonTra = listThongTinMuonTra;
	}

	@Id
	@Column(name = "idsach", unique = true, nullable = false, length = 45)
	public String getIdSach() {
		return this.idSach;
	}

	public void setIdSach(String idSach) {
		this.idSach = idSach;
	}

	@Column(name = "tensach", nullable = false, length = 450)
	public String getTenSach() {
		return this.tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	@Column(name = "tacgia", nullable = false, length = 450)
	public String getTacGia() {
		return this.tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	@Column(name = "soluong", nullable = false)
	public int getSoLuong() {
		return this.soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	@Column(name = "gia", nullable = false)
	public int getGia() {
		return this.gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	@Column(name = "mota", length = 5000)
	public String getMoTa() {
		return this.moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	@Column(name = "ngaythem", nullable = false, length = 45)
	public String getNgayThem() {
		return this.ngayThem;
	}

	public void setNgayThem(String ngayThem) {
		this.ngayThem = ngayThem;
	}

	@Column(name = "ngaycapnhat", length = 45)
	public String getNgayCapNhat() {
		return this.ngayCapNhat;
	}

	public void setNgayCapNhat(String ngayCapNhat) {
		this.ngayCapNhat = ngayCapNhat;
	}

	@Column(name = "loai", nullable = false, length = 45)
	public String getLoai() {
		return this.loai;
	}

	public void setLoai(String loai) {
		this.loai = loai;
	}

	@Column(name = "thoihanmuon", nullable = false)
	public int getThoiHanMuon() {
		return this.thoiHanMuon;
	}

	public void setThoiHanMuon(int thoiHanMuon) {
		this.thoiHanMuon = thoiHanMuon;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sach")
	public Set<ThongTinMuonTra> getListThongTinMuonTra() {
		return this.listThongTinMuonTra;
	}

	public void setListThongTinMuonTra(Set<ThongTinMuonTra> listThongTinMuonTra) {
		this.listThongTinMuonTra = listThongTinMuonTra;
	}

}
