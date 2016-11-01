package demo.models;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class MessageHolder {
	
	private HashMap<String, Set<Message>> messageHolder = new HashMap<>();

	public MessageHolder(HashMap<String, Set<Message>> messageHolder) {
		super();
		this.messageHolder = messageHolder;
	}

	public MessageHolder() {
		super();
	}
	
	public HashMap<String, Set<Message>> getMessageHolder() {
		return messageHolder;
	}

	public void setMessageHolder(HashMap<String, Set<Message>> messageHolder) {
		this.messageHolder = messageHolder;
	}
	
	public void addMessage(String username, Message messageToAdd) {
		if (messageHolder.containsKey(username)) {
			Set<Message> msgSet = messageHolder.get(username);
			msgSet.add(messageToAdd);
		} else {
			Set<Message> msgSet = new HashSet<Message>();
			msgSet.add(messageToAdd);
			messageHolder.put(username, msgSet);
		}
	}
	
	public Set<Message> getUserMessages(String username) {
		return messageHolder.get(username);
	}
}
