package iw7i.messages.chat;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/chat2/{room}", encoders = ChatMessageEncoder.class, decoders = ChatMessageDecoder.class)
public class SimpleChatEndpoint {
	private final Logger log = Logger.getLogger(getClass().getName());
	static private final Set<Session> sessions = 
	          Collections.synchronizedSet(new HashSet<Session>());
	@OnOpen
	public void open(final Session session, @PathParam("room") final String room) {
		log.info("session openened and bound to room: " + room);
		session.getUserProperties().put("room", room);
		sessions.add(session);
	}

	@OnClose
	  public void onClose(final Session session) {
		String room = (String) session.getUserProperties().get("room");
		log.info("session clossed bound to room: " + room);
	    sessions.remove(session);
	  }

	@OnMessage
	public void onMessage(final Session session, final ChatMessage chatMessage) {
		String room = (String) session.getUserProperties().get("room");
		log.info("message bound to room: " + room);
		log.info("sessions available: " + sessions.size());
		try {
			for (Session s : sessions) {
				if (s.isOpen() && room.equals(s.getUserProperties().get("room"))) {
					s.getBasicRemote().sendObject(chatMessage);
				}
			}
		} catch (IOException | EncodeException e) {
			log.log(Level.WARNING, "onMessage failed", e);
		}
	}
}
