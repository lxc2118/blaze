package com.blaze.common.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class BaseCtrl<Param> implements ICtrl<Param> {

	@Override
	public String execute(Param param) {
		return null;
	}

}
