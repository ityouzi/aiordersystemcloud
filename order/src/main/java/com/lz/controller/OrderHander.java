package com.lz.controller;

import com.lz.entity.Order;
import com.lz.entity.OrderVo;
import com.lz.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderHander {
	@Autowired
	private OrderRepository orderRepository;


	@PostMapping("/save")
	public void save(@RequestBody Order order){
		orderRepository.save(order);
	}

	@GetMapping("/findAllByUid/{uiid}/{page}/{limit}")
	public OrderVo findAllByUid(@PathVariable("uid") long uid,
								@PathVariable("page") int page,
								@PathVariable("limit") int limit){
		OrderVo orderVo = new OrderVo();
		orderVo.setCode(0);
		orderVo.setMsg("");
		orderVo.setCount(orderRepository.countByUid(uid));
		orderVo.setData(orderRepository.findAllByUid(uid,(page-1)*limit,limit));
		return orderVo;
	}

	@DeleteMapping("/deleteByMid/{mid}")
	public void deleteByMid(@PathVariable("mid") long mid){
		orderRepository.deleteByMid(mid);
	}

	@GetMapping("/findAllByState/{state}/{page}/{limit}")
	public OrderVo findAllByState(@PathVariable("state") int state,
								  @PathVariable("page") int page,
								  @PathVariable("limit") int limit){
		OrderVo orderVo = new OrderVo();
		orderVo.setCount(0);
		orderVo.setMsg("");
		orderVo.setCount(orderRepository.countByState(state));
		orderVo.setData(orderRepository.findAllByState(state,(page-1)*limit,limit));
		return orderVo;
	}

	@PutMapping("/updateState/{state}/{aid}")
	public void updateState(@PathVariable("id") long id,
							@PathVariable("state") int state,
							@PathVariable("aid") long aid){
		orderRepository.updateState(id,aid,state);
	}


}
