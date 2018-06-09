package quanlythuvien.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import quanlythuvien.model.ThanhVienForm;
import quanlythuvien.model.ThanhVien;
import quanlythuvien.service.QuanLyThanhVienService;

/*
 *@author: nguyenkhue
 *@version 1.0 Dec 15, 2015
 */
@Controller
@SessionAttributes({ "thanhVienForm" })
public class QuanLyThanhVienController {

	@Autowired
	QuanLyThanhVienService quanLyThanhVienService;

	// Create session attribute at fist time
	@ModelAttribute("thanhVienForm")
	public ThanhVienForm initAttributeThanhVienForm() {
		return new ThanhVienForm();
	}

	// Handle request đến trang quản lý thành viên (Chuẩn bị bean
	// List<ThanhVien>)
	@RequestMapping(value = "quanlythanhvien")
	String accessQuanLyThanhVien(ModelMap model, @RequestParam(value = "d-446797-o", required = false) String d_o,
			@RequestParam(value = "d-446797-s", required = false) String ds) {
		List<ThanhVien> listThanhVien = quanLyThanhVienService.getListThanhVien();
		if (d_o != null && ds != null) {
			if (d_o.equals("1")) {
				if (ds.equals("name")) {
					Collections.sort(listThanhVien, ThanhVien.compareAscendingName);
				} else if (ds.equals("gioitinh")) {
					Collections.sort(listThanhVien, ThanhVien.compareAscendingGioiTinh);
				} else if (ds.equals("tinhtrang")) {
					Collections.sort(listThanhVien, ThanhVien.compareAscendingTinhTrang);
				}
			} else if (d_o.equals("2")) {
				if (ds.equals("name")) {
					Collections.sort(listThanhVien, ThanhVien.compareDecendingName);
				} else if (ds.equals("gioitinh")) {
					Collections.sort(listThanhVien, ThanhVien.compareDecendingGioiTinh);
				} else if (ds.equals("tinhtrang")) {
					Collections.sort(listThanhVien, ThanhVien.compareDecendingTinhTrang);
				}
			}
		}
		model.addAttribute("resultSize", listThanhVien.size());
		model.addAttribute("listThanhVien", listThanhVien);
		return "quanlythanhvien";
	}

	// Handle request đến trang thêm thành viên
	@RequestMapping(value = ("themthanhvien"), method = RequestMethod.GET)
	String themThanhVien(ModelMap model) {
		return "themthanhvien";
	}

	// Handle request khi submit (ấn button thêm) trong trang thêm thành viên
	@RequestMapping(value = ("xacnhanthemthanhvien"), method = RequestMethod.POST)
	String xacNhanThemThanhVien(ModelMap model, @ModelAttribute("thanhVien") ThanhVien ThanhVien, BindingResult result,
			@RequestParam("ngaySinhTmp") String ngaySinhTmp) {
		System.out.println(ngaySinhTmp);
		SimpleDateFormat frm1 = new SimpleDateFormat("dd / MM / yyyy");
		Date ngaySinh;
		try {
			ngaySinh = frm1.parse(ngaySinhTmp);
			java.sql.Date dateSql = new java.sql.Date(ngaySinh.getTime());
			ThanhVien.setNgaySinh(dateSql);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (result.hasErrors()) {
			model.addAttribute("error", "*Dữ liệu nhập không hợp lệ!");
			return "themthanhvien";
		} else if (quanLyThanhVienService.isIdTrung(ThanhVien.getIdThanhVien())) {
			model.addAttribute("error", "*Id thành viên đã bị trùng!");
			return "themthanhvien";
		} else {
			quanLyThanhVienService.themThanhVien(ThanhVien);
			return "redirect:quanlythanhvien.html";
		}
	}

	// Handle request xóa thành viên theo idThanhVien
	@RequestMapping(value = ("xoathanhvien"), method = RequestMethod.GET)
	String xoaThanhVien(ModelMap model, @RequestParam(value = "idThanhVien", required = false) String idThanhVien,
			@ModelAttribute("thanhVienForm") ThanhVienForm thanhVienForm) {
		ThanhVien thanhVien = quanLyThanhVienService.getThanhVien(idThanhVien);
		if (thanhVien != null) {
			if (quanLyThanhVienService.isDangMuon(thanhVien)) {
				model.addAttribute("error", "*thành viên đang mượn sách không thể xóa!");
				return "forward:quanlythanhvien.html";
			} else {
				thanhVienForm.getListThanhVien().add(thanhVien);
				quanLyThanhVienService.deleteThanhVien(thanhVien, thanhVienForm.getListIdThongTinMuonTraThanhVien());
				return "redirect:quanlythanhvien.html";
			}
		} else {
			return "redirect:quanlythanhvien.html";
		}
	}

	// Handle request đến trang xem thành viên theo idThanhVien (Chuẩn bị bean
	// ThanhVien)
	@RequestMapping(value = ("xemthanhvien"), method = RequestMethod.GET)
	String xemThanhVien(ModelMap model, @RequestParam(value = "idThanhVien", required = false) String idThanhVien) {
		if (idThanhVien == null) {
			return "redirect:quanlythanhvien.html";
		} else {
			ThanhVien thanhVien = quanLyThanhVienService.getThanhVien(idThanhVien);
			if (thanhVien == null) {
				return "redirect:quanlythanhvien.html";
			} else {
				model.addAttribute("thanhVien", thanhVien);
				return "xemthanhvien";
			}
		}
	}

	// Handle request đến trang xem sách theo idThanhVien trong list sách vừa
	// xóa trong session (Chuẩn bị bean ThanhVien)
	@RequestMapping(value = ("xemthanhvienganday"), method = RequestMethod.GET)
	String xemThanhVienGanDay(ModelMap model, @RequestParam(value = "idThanhVien", required = false) String idThanhVien,
			@ModelAttribute("thanhVienForm") ThanhVienForm thanhVienForm) {
		if (idThanhVien == null) {
			return "redirect:thanhvienganday.html";
		} else {
			int i = 0;
			ThanhVien thanhVien = null;
			while (i < thanhVienForm.getListThanhVien().size()) {
				if (idThanhVien.equals(thanhVienForm.getListThanhVien().get(i).getIdThanhVien())) {
					thanhVien = thanhVienForm.getListThanhVien().get(i);
					i = thanhVienForm.getListThanhVien().size();
				}
				i++;
			}
			if (thanhVien == null) {
				return "redirect:thanhvienganday.html";
			} else {
				model.addAttribute("thanhVien", thanhVien);
				return "xemthanhvien";
			}
		}
	}

	// Handle request đến trang hoạt động xóa thành viên trong session (chuẩn bị
	// bean ThanhVienForm)
	@RequestMapping(value = "thanhvienganday.html")
	String thanhVienGanDay(ModelMap model, @RequestParam(value = "d-446797-o", required = false) String d_o,
			@RequestParam(value = "d-446797-s", required = false) String ds,
			@ModelAttribute("thanhVienForm") ThanhVienForm thanhVienForm) {
		List<ThanhVien> listThanhVien = thanhVienForm.getListThanhVien();
		if (d_o != null && ds != null) {
			if (d_o.equals("1")) {
				if (ds.equals("name")) {
					Collections.sort(listThanhVien, ThanhVien.compareAscendingName);
				} else if (ds.equals("gioitinh")) {
					Collections.sort(listThanhVien, ThanhVien.compareAscendingGioiTinh);
				} else if (ds.equals("tinhtrang")) {
					Collections.sort(listThanhVien, ThanhVien.compareAscendingTinhTrang);
				}
			} else if (d_o.equals("2")) {
				if (ds.equals("name")) {
					Collections.sort(listThanhVien, ThanhVien.compareDecendingName);
				} else if (ds.equals("gioitinh")) {
					Collections.sort(listThanhVien, ThanhVien.compareDecendingGioiTinh);
				} else if (ds.equals("tinhtrang")) {
					Collections.sort(listThanhVien, ThanhVien.compareDecendingTinhTrang);
				}
			}
		}
		if (listThanhVien.size() == 0) {
			return "redirect:quanlythanhvien.html";
		} else {
			return "thanhvienganday";
		}
	}

	// Handle request khôi phục sách từ list sách vừa xóa trong session
	@RequestMapping(value = ("khoiphucthanhvien"), method = RequestMethod.GET)
	String khoiphucThanhVien(ModelMap model, @RequestParam(value = "idThanhVien", required = false) String idThanhVien,
			@ModelAttribute("thanhVienForm") ThanhVienForm thanhVienForm) {
		if (idThanhVien != null && idThanhVien.trim() != "") {
			if (quanLyThanhVienService.isIdTrung(idThanhVien)) {
				model.addAttribute("error", "*Id Sách đã bị trùng, không thể khôi phục!");
			} else {
				int i = 0;
				ThanhVien thanhVien = null;
				List<Integer> listIdThongTinMuonTraThanhVien = new ArrayList<Integer>();
				while (i < thanhVienForm.getListThanhVien().size()) {
					if (idThanhVien.equals(thanhVienForm.getListThanhVien().get(i).getIdThanhVien())) {
						thanhVien = thanhVienForm.getListThanhVien().get(i);
						thanhVienForm.getListThanhVien().remove(i);
						// Lấy id của bảng thông tin mượn trả từ idSách từ
						// thanhVienForm.getListIdThongTinMuonTraThanhVien
						// HashMap<idThanhVien, idThongTinMuonTra> (get key from
						// value)
						for (Entry<Integer, String> entry : thanhVienForm.getListIdThongTinMuonTraThanhVien()
								.entrySet()) {
							if (Objects.equals(thanhVien.getIdThanhVien(), entry.getValue())) {
								listIdThongTinMuonTraThanhVien.add(entry.getKey());
							}
						}
						i = thanhVienForm.getListThanhVien().size() + 1;
					}
					i++;
				}
				if (thanhVien != null) {
					quanLyThanhVienService.themThanhVien(thanhVien, listIdThongTinMuonTraThanhVien);
				}
			}
		}
		return "thanhvienganday";
	}

	// Handle request sửa sách theo idSách (chuẩn bị bean ThanhVien)
	@RequestMapping(value = ("suathanhvien"), method = RequestMethod.GET)
	String suaThanhVien(ModelMap model, @RequestParam(value = "idThanhVien", required = false) String idThanhVien) {
		if (idThanhVien == null) {
			return "redirect:quanlythanhvien.html";
		} else {
			ThanhVien thanhVien = quanLyThanhVienService.getThanhVien(idThanhVien);
			if (thanhVien == null) {
				return "redirect:quanlythanhvien.html";
			} else {
				model.addAttribute("oldId", thanhVien.getIdThanhVien());
				model.addAttribute("thanhVien", thanhVien);
				return "suathanhvien";
			}
		}
	}

	// Handle request khi submit (ấn button sửa) trong trang sửa thành viên
	@RequestMapping(value = ("xacnhansuathanhvien"), method = RequestMethod.POST)
	String xacNhanSuaThanhVien(ModelMap model, @ModelAttribute ThanhVien thanhVien, BindingResult result,
			@RequestParam(value = "oldId") String oldId,@RequestParam("ngaySinhTmp") String ngaySinhTmp) {
		SimpleDateFormat frm1 = new SimpleDateFormat("dd / MM / yyyy");
		Date ngaySinh;
		try {
			ngaySinh = frm1.parse(ngaySinhTmp);
			java.sql.Date dateSql = new java.sql.Date(ngaySinh.getTime());
			thanhVien.setNgaySinh(dateSql);
			if (result.hasErrors()) {
				model.addAttribute("error", "*Dữ liệu nhập không hợp lệ!");
				model.addAttribute("oldId", oldId);
				return "suathanhvien";
			} else if (!thanhVien.getIdThanhVien().equals(oldId)) {
				if (quanLyThanhVienService.isIdTrung(thanhVien.getIdThanhVien())) {
					model.addAttribute("oldId", oldId);
					model.addAttribute("error", "*Id thành viên đã bị trùng!");
					return "suathanhvien";
				} else {
					quanLyThanhVienService.updateThanhVien(thanhVien, oldId);
					return "redirect:quanlythanhvien.html";
				}
			} else {
				quanLyThanhVienService.updateThanhVien(thanhVien, oldId);
				return "redirect:quanlythanhvien.html";
			}
		} catch (ParseException e) {
			model.addAttribute("error", "*Dữ liệu nhập không hợp lệ!");
			model.addAttribute("oldId", oldId);
			return "suathanhvien";
		}
	}
}
