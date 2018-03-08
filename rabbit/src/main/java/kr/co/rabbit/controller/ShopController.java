package kr.co.rabbit.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.rabbit.service.ShopCaService;
import kr.co.rabbit.service.ShopService;
import kr.co.rabbit.vo.ShopCaVO;
import kr.co.rabbit.vo.ShopVO;


@Controller
@RequestMapping("/shop")
public class ShopController {
	
	@Autowired
	private ShopService shs;
	@Autowired
	private ShopCaService scs;

	List<ShopCaVO> caList = new ArrayList<ShopCaVO>();
	@RequestMapping(value="/shopList", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> getMenuList(Map<String,Object> map){
		System.out.println("shop컨트롤러에요");
		List<ShopVO> shopList = shs.getShopList();
		map.put("shopList", shopList);
		System.out.println(map);
		return map;
	}
	
	@RequestMapping(value="/category", method=RequestMethod.GET)
	public @ResponseBody List<ShopCaVO> getCaList(){
		System.out.println("shop컨트롤러의 카테고리에요");
		caList = scs.getCaList();
		return caList;
	}
}
