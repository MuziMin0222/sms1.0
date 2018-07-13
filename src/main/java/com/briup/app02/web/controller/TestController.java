package com.briup.app02.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *路由器的命名空间
 *http：//127.0.0.1：8080可以访问到当前项目
 *http：//127.0.0.1：8080/test可以访问到当前项目TestController
 * author 李煌民：
 *
 */
@RestController
@RequestMapping("诸葛亮")
public class TestController {
	
	@GetMapping("星航指挥官")
	public String 星航指挥官(){
		return "哼哼~一切都在计算之中";
	}
	@GetMapping("黄金分割率")
	public String 黄金分割率(){
		return "完美的几何学者，以斐波那契数列分割战场";
	}
	@GetMapping("武陵仙君")
	public String 武陵仙君(){
		return "她在我心里种下一棵桃树，从此用心血灌养";
	}
}
