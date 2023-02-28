package study.websocket.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import study.websocket.model.ChatVo;
import study.websocket.repo.ChatRepository;

@Service
@AllArgsConstructor
public class ChatService {

	@NonNull
	private ChatRepository chatRepository;
	

    public List<ChatVo> findAll() {
        List<ChatVo> chatList = new ArrayList<>();
        chatRepository.findAll().forEach(e -> chatList.add(e));
        return chatList;
    }

    public Optional<ChatVo> findById(Long mbrNo) {
        Optional<ChatVo> chat = chatRepository.findById(mbrNo);
        return chat;
    }

    public void deleteById(Long mbrNo) {
    	chatRepository.deleteById(mbrNo);
    }

    public ChatVo save(String chat) {
    	ChatVo newChat = new ChatVo();
    	newChat.setMessage(chat);
    	chatRepository.save(newChat);
        return newChat;
    }

    public void updateById(Long mbrNo, ChatVo chat) {
        Optional<ChatVo> e = chatRepository.findById(mbrNo);

        if (e.isPresent()) {
            e.get().setMessage(chat.getMessage());
            e.get().setId(chat.getId());
            chatRepository.save(chat);
        }
    }
}
