package quanlythuvien.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import quanlythuvien.model.QuanLySach;
import quanlythuvien.model.QuanLySachForm;
import quanlythuvien.model.Sach;
import quanlythuvien.service.Listener;
import quanlythuvien.service.LoginService;
import quanlythuvien.service.QuanLySachService;

/*
 *@author: nguyenkhue
 *@version 1.0 Nov 22, 2015
 */
@Controller
@SessionAttributes({ "fullName", "countUserOnline", "quanLySachForm" })
public class QuanlysachController {

	@Autowired
	QuanLySachService quanLySachService;
	@Autowired
	LoginService loginService;
	@Autowired
	Listener listener;

	// Create session attribute at fist time
	@ModelAttribute("quanLySachForm")
	public QuanLySachForm initAttributeQuanLySachForm() {
		return new QuanLySachForm();
	}
	
	//Create session attribute at fist time
	 @ModelAttribute("fullName")
	 public String initAttributeFullName() {
		 return new String();
	 }

	// Handle request đến trang quản lý sách (Chuẩn bị bean List<QuanLySach>)
	@SuppressWarnings("static-access")
	@RequestMapping(value = ("quanlysach"), method = RequestMethod.GET)
	String listSach(ModelMap model, @RequestParam(value = "d-446797-o", required = false) String d_o,
			@RequestParam(value = "d-446797-s", required = false) String ds,
			@ModelAttribute("fullName") String fullName, Authentication activeUser) {
		if (fullName.equals("")) {
			fullName = loginService.getUserFullName(activeUser.getName());
			model.addAttribute("fullName", fullName);
			model.addAttribute("countUserOnline", listener.getCountUserOnline());
		}
		List<QuanLySach> listQuanLySach = quanLySachService.getListQuanLySach();
		if (d_o != null && ds != null) {
			if (d_o.equals("1")) {
				if (ds.equals("dangMuon")) {
					Collections.sort(listQuanLySach, QuanLySach.compareAscendingDangMuon);
				} else if (ds.equals("gia")) {
					Collections.sort(listQuanLySach, QuanLySach.compareAscendingGia);
				} else if (ds.equals("soLuong")) {
					Collections.sort(listQuanLySach, QuanLySach.compareAscendingSoLuong);
				}
			} else if (d_o.equals("2")) {
				if (ds.equals("dangMuon")) {
					Collections.sort(listQuanLySach, QuanLySach.compareDecendingDangMuon);
				} else if (ds.equals("gia")) {
					Collections.sort(listQuanLySach, QuanLySach.compareDecendingGia);
				} else if (ds.equals("soLuong")) {
					Collections.sort(listQuanLySach, QuanLySach.compareDecendingSoLuong);
				}
			}
		}
		model.addAttribute("resultSize", listQuanLySach.size());
		model.addAttribute("listQuanLySach", listQuanLySach);
		return "quanlysach";
	}

	// Handle request đến trang hoạt động xóa sách trong session (Chuẩn bị bean
	// QuanLySachForm từ session)
	@RequestMapping(value = ("sachganday"), method = RequestMethod.GET)
	String listSachGanDay(ModelMap model, @RequestParam(value = "d-446797-o", required = false) String d_o,
			@RequestParam(value = "d-446797-s", required = false) String ds,
			@ModelAttribute("quanLySachForm") QuanLySachForm quanLySachForm) {
		List<QuanLySach> listQuanLySach = quanLySachForm.getListQuanLySach();
		if (d_o != null && ds != null) {
			if (d_o.equals("1")) {
				if (ds.equals("dangMuon")) {
					Collections.sort(listQuanLySach, QuanLySach.compareAscendingDangMuon);
				} else if (ds.equals("gia")) {
					Collections.sort(listQuanLySach, QuanLySach.compareAscendingGia);
				} else if (ds.equals("soLuong")) {
					Collections.sort(listQuanLySach, QuanLySach.compareAscendingSoLuong);
				}
			} else if (d_o.equals("2")) {
				if (ds.equals("dangMuon")) {
					Collections.sort(listQuanLySach, QuanLySach.compareDecendingDangMuon);
				} else if (ds.equals("gia")) {
					Collections.sort(listQuanLySach, QuanLySach.compareDecendingGia);
				} else if (ds.equals("soLuong")) {
					Collections.sort(listQuanLySach, QuanLySach.compareDecendingSoLuong);
				}
			}
		}
		model.addAttribute("quanLySachForm", quanLySachForm);
		if (listQuanLySach.size() == 0) {
			return "redirect:quanlysach.html";
		} else {
			return "sachganday";
		}
	}

	// Handle request đến trang xem sách theo idSach (Chuẩn bị bean Sach)
	@RequestMapping(value = ("xemsach"), method = RequestMethod.GET)
	String xemSach(ModelMap model, @RequestParam(value = "idSach", required = false) String idSach) {
		if (idSach == null) {
			return "redirect:quanlysach.html";
		} else {
			Sach sach = quanLySachService.getSach(idSach);
			if (sach == null) {
				return "redirect:quanlysach.html";
			} else {
				model.addAttribute("sach", sach);
				return "xemsach";
			}
		}
	}

	// Handle request đến trang xem sách theo idSach trong list sách vừa xóa
	// trong session (Chuẩn bị bean Sach)
	@RequestMapping(value = ("xemsachganday"), method = RequestMethod.GET)
	String xemSachGanDay(ModelMap model, @RequestParam(value = "idSach", required = false) String idSach,
			@ModelAttribute("quanLySachForm") QuanLySachForm quanLySachForm) {
		if (idSach == null) {
			return "redirect:sachganday.html";
		} else {
			int i = 0;
			Sach sach = null;
			while (i < quanLySachForm.getListSach().size()) {
				if (idSach.equals(quanLySachForm.getListSach().get(i).getIdSach())) {
					sach = quanLySachForm.getListSach().get(i);
					i = quanLySachForm.getListSach().size();
				}
				i++;
			}
			if (sach == null) {
				return "redirect:sachganday.html";
			} else {
				model.addAttribute("sach", sach);
				return "xemsach";
			}
		}
	}

	// Handle request khôi phục sách từ list sách vừa xóa trong session
	@RequestMapping(value = ("khoiphucsach"), method = RequestMethod.GET)
	String khoiphucSach(ModelMap model, @RequestParam(value = "idSach", required = false) String idSach,
			@ModelAttribute("quanLySachForm") QuanLySachForm quanLySachForm) {

		if (idSach != null && idSach.trim() != "") {
			if (quanLySachService.isIdTrung(idSach)) {
				model.addAttribute("error", "*Id Sách đã bị trùng, không thể khôi phục!");
			} else {
				int i = 0;
				Sach sach = null;
				List<Integer> listIdThongTinMuonTraSach = new ArrayList<Integer>();
				while (i < quanLySachForm.getListSach().size()) {
					if (idSach.equals(quanLySachForm.getListSach().get(i).getIdSach())) {
						sach = quanLySachForm.getListSach().get(i);
						quanLySachForm.getListSach().remove(i);
						quanLySachForm.getListQuanLySach().remove(i);
						// Lấy id của bảng thông tin mượn trả từ idSách từ
						// quanLySachForm.getListIdThongTinMuonTraSach
						// HashMap<idSach, idThongTinMuonTra> (get key from
						// value)
						for (Entry<Integer, String> entry : quanLySachForm.getListIdThongTinMuonTraSach().entrySet()) {
							if (Objects.equals(sach.getIdSach(), entry.getValue())) {
								listIdThongTinMuonTraSach.add(entry.getKey());
							}
						}
						i = quanLySachForm.getListSach().size() + 1;
					}
					i++;
				}
				if (sach != null) {
					quanLySachService.themSach(sach, listIdThongTinMuonTraSach);
				}
			}
		}
		// model.addAttribute("quanLySachForm", quanLySachForm);
		return "sachganday";
	}

	// Handle request sửa sách theo idSách (chuẩn bị bean Sach)
	@RequestMapping(value = ("suasach"), method = RequestMethod.GET)
	String suaSach(ModelMap model, @RequestParam(value = "idSach", required = false) String idSach) {
		if (idSach == null) {
			return "redirect:quanlysach.html";
		} else {
			Sach sach = quanLySachService.getSach(idSach);
			if (sach == null) {
				return "redirect:quanlysach.html";
			} else {
				List<String> listLoaiSach = quanLySachService.getListLoaiSach();
				model.addAttribute("listLoaiSach", listLoaiSach);
				model.addAttribute("oldId", sach.getIdSach());
				model.addAttribute("sach", sach);
				return "suasach";
			}
		}
	}

	// Handle request khi submit (ấn button sửa) trong trang sửa sách
	@RequestMapping(value = ("xacnhansuasach"), method = RequestMethod.POST)
	String xacNhanSuaSach(ModelMap model, @ModelAttribute Sach sach, BindingResult result,
			@RequestParam(value = "oldId") String oldId,
			@RequestParam(value = "slLoai", required = false) String slLoai,
			@RequestParam(value = "ipLoai", required = false) String ipLoai) {
		if (ipLoai.trim() != "") {
			sach.setLoai(ipLoai);
		} else {
			sach.setLoai(slLoai);
		}
		if (result.hasErrors()) {
			List<String> listLoaiSach = quanLySachService.getListLoaiSach();
			model.addAttribute("listLoaiSach", listLoaiSach);
			model.addAttribute("error", "*Dữ liệu nhập không hợp lệ!");
			model.addAttribute("oldId", oldId);
			return "suasach";
		} else if (!sach.getIdSach().equals(oldId)) {
			if (quanLySachService.isIdTrung(sach.getIdSach())) {
				List<String> listLoaiSach = quanLySachService.getListLoaiSach();
				model.addAttribute("listLoaiSach", listLoaiSach);
				model.addAttribute("oldId", oldId);
				model.addAttribute("error", "*Id sách đã bị trùng!");
				return "suasach";
			} else {
				quanLySachService.updateSach(sach, oldId);
				return "redirect:quanlysach.html";
			}
		} else {
			quanLySachService.updateSach(sach, oldId);
			return "redirect:quanlysach.html";
		}
	}

	// Handle request đến trang thêm sách
	@RequestMapping(value = ("themsach"), method = RequestMethod.GET)
	String themSach(ModelMap model) {
		List<String> listLoaiSach = quanLySachService.getListLoaiSach();
		model.addAttribute("listLoaiSach", listLoaiSach);
		return "themsach";
	}

	// Handle request khi submit (ấn button thêm) trong trang thêm sách
	@RequestMapping(value = ("xacnhanthemsach"), method = RequestMethod.POST)
	String xacNhanThemSach(ModelMap model, @ModelAttribute Sach sach, BindingResult result,
			@RequestParam(value = "slLoai", required = false) String slLoai,
			@RequestParam(value = "ipLoai", required = false) String ipLoai) {
		if (ipLoai.trim() != "") {
			sach.setLoai(ipLoai);
		} else {
			sach.setLoai(slLoai);
		}
		if (result.hasErrors()) {
			List<String> listLoaiSach = quanLySachService.getListLoaiSach();
			model.addAttribute("listLoaiSach", listLoaiSach);
			model.addAttribute("error", "*Dữ liệu nhập không hợp lệ!");
			model.addAttribute("sach", sach);
			return "themsach";
		} else if (quanLySachService.isIdTrung(sach.getIdSach())) {
			List<String> listLoaiSach = quanLySachService.getListLoaiSach();
			model.addAttribute("listLoaiSach", listLoaiSach);
			model.addAttribute("error", "*Id sách đã bị trùng!");
			// model.addAttribute("sach", sach);
			return "themsach";
		} else {
			quanLySachService.themSach(sach);
			return "redirect:quanlysach.html";
		}
	}

	// Handle request xóa sách theo idSach
	@RequestMapping(value = ("xoasach"), method = RequestMethod.GET)
	String xoaSach(ModelMap model, @RequestParam(value = "idSach", required = false) String idSach,
			@ModelAttribute("quanLySachForm") QuanLySachForm quanLySachForm) {
		Sach sach = quanLySachService.getSach(idSach);
		if (sach != null) {
			if (quanLySachService.isDangMuon(sach)) {
				model.addAttribute("error", "*Sách đang được mượn không thể xóa!");
				return "forward:quanlysach.html";
			} else {
				quanLySachForm.getListSach().add(sach);
				quanLySachForm.getListQuanLySach().add(quanLySachService.getQuanLySach(idSach));
				quanLySachService.deleteSach(sach, quanLySachForm.getListIdThongTinMuonTraSach());
				// model.addAttribute("quanLySachForm", quanLySachForm);
				return "redirect:quanlysach.html";
			}
		} else {
			return "redirect:quanlysach.html";
		}
	}

	// Handle ajax request để search theo id, tên sách, mô tả (trả về data kiểu json)
	@RequestMapping(value = ("searchajax"), method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseBody
	String searchAjax(@RequestParam(value = "search", required = false) String search) throws JSONException {
		List<Sach> listSearchSach = quanLySachService.searchSach(search);
		JSONArray array = new JSONArray();
		JSONObject obj;
		int i = 0;
		while (i < listSearchSach.size()) {
			obj = new JSONObject();
			obj.put("id", listSearchSach.get(i).getIdSach());
			obj.put("tensach", listSearchSach.get(i).getTenSach());
			if (listSearchSach.get(i).getMoTa().length() > 90)
				obj.put("mota", listSearchSach.get(i).getMoTa().substring(0, 89) + "...");
			else
				obj.put("mota", listSearchSach.get(i).getMoTa());
			array.put(obj);
			i++;
		}
		return array.toString();
	}

	// Handle request search (khi nhấn enter tại search box)
	@RequestMapping(value = ("search"), method = RequestMethod.GET)
	String searchSach(@RequestParam(value = "search", required = false) String search, ModelMap model) {
		if (search == null || search.trim().length() < 3) {
			return "redirect:quanlysach.html";
		} else {
			List<String> listId = quanLySachService.searchIdSach(search);
			List<QuanLySach> listQuanLySach = new ArrayList<QuanLySach>();
			QuanLySach quanLySach;
			int i = 0;
			while (i < listId.size()) {
				quanLySach = quanLySachService.getQuanLySach(listId.get(i));
				listQuanLySach.add(quanLySach);
				i++;
			}
			model.addAttribute("listQuanLySach", listQuanLySach);
			model.addAttribute("resultSize", listQuanLySach.size());
			return "quanlysach";
		}
	}
}
