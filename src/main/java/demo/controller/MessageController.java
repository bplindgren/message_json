package demo.controller;

import java.util.HashMap;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.models.Message;
import demo.models.MessageHolder;

@RestController
@RequestMapping("message")
public class MessageController {

	Message msg;
	MessageHolder messageHolder;
	
	public MessageController(Message message, MessageHolder messageHolder) {
		this.msg = message;
		this.messageHolder = messageHolder;
	}
	
	@PutMapping
	public String putMessage(@RequestBody Message incoming) {

		 System.out.println(incoming.getBody());
		 return incoming.getBody();
	}
	
	@GetMapping
	public Message getMessage() {
		return msg;
	}
	
	@GetMapping("/user/{username}")
	public String getFirstCharacterOfUserName(@PathVariable String username ) {
		return username.substring(0, 1);
	}
	
	@GetMapping("messageHolder")
	public MessageHolder getmsgh() {
		return messageHolder;
	}
	
	@PutMapping("/user/{username}")
	public void putDataToUser(@PathVariable String username, @RequestBody Message incoming) {
		messageHolder.addMessage(username, incoming);
	}
	
	@GetMapping("getmessages/{username}")
	public Set<Message> getUserMessages(@PathVariable String username) {
		return messageHolder.getMessageHolder().get(username);
	}
	
}
