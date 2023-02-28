package study.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// encoder, decoder 따로 작성 가능... (송신 VO  -->  VO 수신)


@SpringBootApplication
public class SpringBootNetty1Application {

	public static void main(String[] args) throws Exception {
		//SpringApplication.run(SpringBootNetty1Application.class, args);
		new EchoServer().startServer();
	}

}
