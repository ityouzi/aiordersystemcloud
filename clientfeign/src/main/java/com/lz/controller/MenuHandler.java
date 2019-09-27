package com.lz.controller;

import com.lz.entity.Menu;
import com.lz.entity.MenuVo;
import com.lz.feign.MenuFeign;
import com.lz.feign.OrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/menu")
public class MenuHandler {

	@Autowired
	private MenuFeign menuFeign;
	@Autowired
	private OrderFeign orderFeign;

	@GetMapping("/findAll")
	@ResponseBody
	public MenuVo findAll(@RequestParam("page") int page, @RequestParam("limit") int limit){
		return menuFeign.findAll(page, limit);
	}

	@GetMapping("/prepareSave")
	public String prepareSave(Model model){
		model.addAttribute("list",menuFeign.findAll());
		return "menu_add";
	}

	@PostMapping("/save")
	public String save(Menu menu){
		menuFeign.save(menu);
		return "redirect:/account/redirect/menu_manage";
	}

	@GetMapping("/findById/{id}")
	public String findById(@PathVariable("id") long id, Model model){
		model.addAttribute("list",menuFeign.findAll());
		model.addAttribute("menu",menuFeign.findById(id));
		return "menu_update";
	}

	@PostMapping("/update")
	public String update(Menu menu){
		menuFeign.update(menu);
		return "redirect:/account/redirect/menu_manage";
	}

	@GetMapping("/deleteById/{id}")
	public String deleteById(@PathVariable("id") long id){
		orderFeign.deleteByMid(id);
		menuFeign.deleteById(id);
		return "redirect:/account/redirect/menu_manage";
	}

}
