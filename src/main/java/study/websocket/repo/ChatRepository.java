package study.websocket.repo;

import org.springframework.stereotype.Repository;

import study.websocket.model.ChatVo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ChatRepository extends JpaRepository<ChatVo, Long> {
	// 비워져 있어도 잘 작동함.
	// long이 아니라 Long으로 작성. ex) int => Integer 같이 primitive 형식 사용 못 한다.
	
	// findBy 뒤에 컬럼명을 붙여주면 이를 이용한 검색이 가능하다. ( SELECT 문 )
    public List<ChatVo> findById(String id);

    // like검색도 가능
    // public List<ChatVo> findByNameLike(String keyword);

}
