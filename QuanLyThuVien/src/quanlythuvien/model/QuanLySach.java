package quanlythuvien.model;

import java.util.Comparator;

/*
 *@author: nguyenkhue
 *@version 1.0 Nov 25, 2015
 */
public class QuanLySach implements Comparable<QuanLySach> {
	private String idSach;
	private String tenSach;
	private int soLuong;
	private int gia;
	private int dangMuon;

	public String getIdSach() {
		return idSach;
	}

	public void setIdSach(String idSach) {
		this.idSach = idSach;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	public int getDangMuon() {
		return dangMuon;
	}

	public void setDangMuon(int dangMuon) {
		this.dangMuon = dangMuon;
	}

	@Override
	public int compareTo(QuanLySach arg0) {
		return 0;
	}
	
	public static Comparator<QuanLySach> compareAscendingSoLuong = new Comparator<QuanLySach>() {
		public int compare(QuanLySach db1, QuanLySach db2) {
			Integer dbName1 = db1.getSoLuong();
			Integer dbName2 = db2.getSoLuong();
			return dbName1.compareTo(dbName2);
		}
	};
	
	public static Comparator<QuanLySach> compareDecendingSoLuong = new Comparator<QuanLySach>() {
		public int compare(QuanLySach db1, QuanLySach db2) {
			Integer dbName1 = db1.getSoLuong();
			Integer dbName2 = db2.getSoLuong();
			return dbName2.compareTo(dbName1);
		}
	};
	
	public static Comparator<QuanLySach> compareAscendingGia = new Comparator<QuanLySach>() {
		public int compare(QuanLySach db1, QuanLySach db2) {
			Integer dbName1 = db1.getGia();
			Integer dbName2 = db2.getGia();
			return dbName1.compareTo(dbName2);
		}
	};
	
	public static Comparator<QuanLySach> compareDecendingGia = new Comparator<QuanLySach>() {
		public int compare(QuanLySach db1, QuanLySach db2) {
			Integer dbName1 = db1.getGia();
			Integer dbName2 = db2.getGia();
			return dbName2.compareTo(dbName1);
		}
	};
	
	public static Comparator<QuanLySach> compareAscendingDangMuon = new Comparator<QuanLySach>() {
		public int compare(QuanLySach db1, QuanLySach db2) {
			Integer dbName1 = db1.getDangMuon();
			Integer dbName2 = db2.getDangMuon();
			return dbName1.compareTo(dbName2);
		}
	};
	
	public static Comparator<QuanLySach> compareDecendingDangMuon = new Comparator<QuanLySach>() {
		public int compare(QuanLySach db1, QuanLySach db2) {
			Integer dbName1 = db1.getDangMuon();
			Integer dbName2 = db2.getDangMuon();
			return dbName2.compareTo(dbName1);
		}
	};
}
