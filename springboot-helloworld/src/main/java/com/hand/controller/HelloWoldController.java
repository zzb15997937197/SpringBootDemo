
package com.hand.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWoldController {

	@RequestMapping("/index")
	public String index() {
		return "success";
	}
}
