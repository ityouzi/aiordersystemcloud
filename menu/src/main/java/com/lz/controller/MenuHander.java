package com.lz.controller;

import com.lz.entity.Menu;
import com.lz.entity.MenuVo;
import com.lz.entity.Type;
import com.lz.repository.MenuRepository;
import com.lz.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuHander {
	@Autowired
	private MenuRepository menuRepository;
	@Autowired
	private TypeRepository typeRepository;


	@GetMapping("/findAll/{page}/{limit}")
	public MenuVo findAll(@PathVariable("page") int page,
						  @PathVariable("limit") int limit){
		MenuVo menuVo = new MenuVo();
		menuVo.setCode(0);
		menuVo.setMsg("");
		menuVo.setCount(menuRepository.count());
		menuVo.setData(menuRepository.findAll((page-1)*limit,limit));
		return menuVo;
	}

	@GetMapping("/findAll")
	public List<Type> findAll(){
		return typeRepository.findAll();
	}

	@PostMapping("save")
	public void save(@RequestBody Menu menu){
		menuRepository.save(menu);
	}

	@GetMapping("/findById/{id}")
	public Menu findById(@PathVariable("id") long id){
		return menuRepository.findById(id);
	}

	@PutMapping("/update")
	public void update(@RequestBody Menu menu){
		menuRepository.update(menu);
	}

	@DeleteMapping("/deleteById/{id}")
	public void deleteById(@PathVariable("id") long id){
		menuRepository.deleteById(id);
	}



}
