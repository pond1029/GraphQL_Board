/**
  * @Package : com.pond.graph_ql
  * @FileName : BoardController.java
  * @Date : 2021. 1. 14. 
  * @Author : "LeeJaeYeon"
  * @Version :
  * @Information :
  */

package com.pond.graph_ql;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
  * @Package : com.pond.graph_ql
  * @FileName : BoardController.java
  * @Date : 2021. 1. 14. 
  * @Author : "LeeJaeYeon"
  * @Version :
  * @Information :
  */
@Controller
public class BoardController {

	@GetMapping("/")
	public String home(Model model) {
		return "index";
	}
	
}
