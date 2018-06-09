package quanlythuvien.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import quanlythuvien.model.ThongTinMuonTra;
import quanlythuvien.service.ThongTinMuonTraService;

/**
 * @author: nguyenkhue
 * @version: 1.0 Dec 18, 2015
 */
@Controller
public class ThongTinMuonTraController {

	@Autowired
	ThongTinMuonTraService thongTinMuonTraService;

	// Request đến trang thông tin mượn trả (chuẩn bị bean List<ThongTinMuonTra>)
	@RequestMapping(value = "thongtinmuontra.html")
	String accessThongTinMuonTra(ModelMap model, @RequestParam(value = "d-16544-o", required = false) String d_o,
			@RequestParam(value = "d-16544-s", required = false) String ds) {
		List<ThongTinMuonTra> listThongTinMuonTra = thongTinMuonTraService.getListThongTinMuonTra();
		if (d_o != null && ds != null) {
			if (d_o.equals("1")) {
				if (ds.equals("tenthanhvien")) {
					Collections.sort(listThongTinMuonTra, ThongTinMuonTra.compareAscendingTenThanhVien);
				} else if (ds.equals("tensach")) {
					Collections.sort(listThongTinMuonTra, ThongTinMuonTra.compareAscendingTenSach);
				} else if (ds.equals("ngaymuon")) {
					Collections.sort(listThongTinMuonTra, ThongTinMuonTra.compareAscendingNgayMuon);
				} else if (ds.equals("ngayhethan")) {
					Collections.sort(listThongTinMuonTra, ThongTinMuonTra.compareAscendingNgayHetHan);
				} else if (ds.equals("trangthai")) {
					Collections.sort(listThongTinMuonTra, ThongTinMuonTra.compareAscendingTrangThai);
				}
			} else if (d_o.equals("2")) {
				if (ds.equals("tenthanhvien")) {
					Collections.sort(listThongTinMuonTra, ThongTinMuonTra.compareDecendingTenThanhVien);
				} else if (ds.equals("tensach")) {
					Collections.sort(listThongTinMuonTra, ThongTinMuonTra.compareDecendingTenSach);
				} else if (ds.equals("ngaymuon")) {
					Collections.sort(listThongTinMuonTra, ThongTinMuonTra.compareDecendingNgayMuon);
				} else if (ds.equals("ngayhethan")) {
					Collections.sort(listThongTinMuonTra, ThongTinMuonTra.compareDecendingNgayHetHan);
				} else if (ds.equals("trangthai")) {
					Collections.sort(listThongTinMuonTra, ThongTinMuonTra.compareDecendingTrangThai);
				}
			}
		}
		model.addAttribute("resultSize", listThongTinMuonTra.size());
		model.addAttribute("listThongTinMuonTra", listThongTinMuonTra);
		return "thongtinmuontra";
	}
	
	@RequestMapping(value="xemthongtinmuontra")
	String accessXemThongTinMuonTra(ModelMap model, @RequestParam("idThongTinMuonTra") String idThongTinMuonTra){
		ThongTinMuonTra thongTinMuonTra = thongTinMuonTraService.getThongTinMuonTra(idThongTinMuonTra);
		if(thongTinMuonTra == null)
			return "redirect:thongtinmuontra.html";
		model.addAttribute("thongTinMuonTra", thongTinMuonTra);
		return "xemthongtinmuontra";
	}
}
