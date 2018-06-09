package quanlythuvien.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import quanlythuvien.service.MuonTraSachService;

/**
 * @author: nguyenkhue
 * @version: 1.0 Dec 19, 2015
 */
@Controller
public class MuonTraSachController {
	
	//private static Log logger = LogFactory.getLog(TraSachController.class);	
	@Autowired
	MuonTraSachService muonTraSachService;

	@RequestMapping(value="trasach")
	String accessTraSach(){
		return "trasach";
	}
	
	@RequestMapping(value="muonsach")
	String accessMuonSach(){
		return "muonsach";
	}
	
	/*@RequestMapping(value="kiemtratrasachajax")
	@ResponseBody
	String kiemtraTraSach(@RequestParam(value = "idThanhVien", required = false) String idThanhVien,
			@RequestParam(value = "listIdSach", required = false) List<String> listIdSach){
		logger.info(idThanhVien);
		if(listIdSach != null)
			System.out.println(listIdSach.size());
		if(idThanhVien == null || listIdSach == null)
			return "error";
		return traSachService.kiemTraTraSach(idThanhVien, listIdSach);
	}*/
	
	@RequestMapping(value="xacnhantrasach" , method = RequestMethod.POST)
	String xacNhanTraSach(@RequestParam(value = "idThanhVien", required = false) String idThanhVien,
			ModelMap model, @RequestParam(value = "idSach", required = false) String idSach,
			@RequestParam(value = "phat", required = false) String phat) {
		String error = muonTraSachService.kiemTraHopLeTraSach(idThanhVien, idSach);
		if(error != null){
			model.addAttribute("error", error);
			return "trasach";
		}
		long soNgayQuaHan = muonTraSachService.soNgayQuaHan(idSach, idThanhVien);
		if(soNgayQuaHan > 0 && soNgayQuaHan != -100000 && phat.trim().length() == 0){
			error = "Trả Sách quá hạn: " + idSach+ " ngày.";
			model.addAttribute("error", error);
			return "trasach";
		}
		muonTraSachService.traSach(idSach, idThanhVien, phat);
		model.addAttribute("success", "Trả Sách Thành Công!");
		return "trasach";
	}
	
	@RequestMapping(value="xacnhanmuonsach" , method = RequestMethod.POST)
	String xacNhanMuonSach(@RequestParam(value = "idThanhVien", required = false) String idThanhVien,
			ModelMap model, @RequestParam(value = "idSach", required = false) String idSach) {
		String error = muonTraSachService.kiemTraHopLeMuonSach(idThanhVien, idSach);
		if(error != null){
			model.addAttribute("error", error);
			return "muonsach";
		}
		muonTraSachService.muonSach(idSach, idThanhVien);
		model.addAttribute("success", "Mượn Sách Thành Công!");
		return "muonsach";
	}
}
