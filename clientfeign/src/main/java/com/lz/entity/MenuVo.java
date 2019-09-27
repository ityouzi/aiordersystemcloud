package com.lz.entity;

import lombok.Data;

import java.util.List;
@Data
public class MenuVo {
	private int code;
	private String msg;
	private int count;
	private List<Menu> data;
}
