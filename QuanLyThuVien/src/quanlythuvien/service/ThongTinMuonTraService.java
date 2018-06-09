package quanlythuvien.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quanlythuvien.dao.ThongTinMuonTraDAO;
import quanlythuvien.model.ThongTinMuonTra;

/**
 * @author: nguyenkhue
 * @version: 1.0 Dec 18, 2015
 */
@Service("thongTinMuonTraService")
public class ThongTinMuonTraService {

	private static Log logger = LogFactory.getLog(ThongTinMuonTraService.class);
	
	@Autowired
	ThongTinMuonTraDAO thongTinMuonTraDAO;

	//Lấy tất cả các record từ bảng thông tin mượn trả
	public List<ThongTinMuonTra> getListThongTinMuonTra() {
		return thongTinMuonTraDAO.getListThongTinMuonTra();
	}
	
	//Lấy thông tin mượn trả theo idThongTinMuonTra
	public ThongTinMuonTra getThongTinMuonTra(String idThongTinMuonTra){
		try {
			Integer temp = Integer.parseInt(idThongTinMuonTra);
			return thongTinMuonTraDAO.getThongTinMuonTra(temp);
		} catch (NumberFormatException  e) {
			logger.error("Khong the parse!");
			return null;
		}
	}
}
