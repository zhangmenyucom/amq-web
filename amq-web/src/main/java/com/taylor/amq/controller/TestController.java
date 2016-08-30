package com.taylor.amq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taylor.api.amq.service.MessageSenderService;

@Controller
@RequestMapping("/test/*")
public class TestController {
	@Autowired
	@Qualifier("queueMessageSenderService")
	private MessageSenderService sendMessageService;

	@RequestMapping(value = "/message/{message}")
	public String sendQueue(@PathVariable("message") String message) {
		sendMessageService.sendMessage(message);
		return "success";
	}
}
