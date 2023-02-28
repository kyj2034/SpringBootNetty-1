package study.websocket;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class EchoServerHandler extends ChannelInboundHandlerAdapter {
	


	// 크라이언트에서 메시지가 날라오면 실행되는 이벤트 메소드이다.
	// 문자열을 전달받아서 채넣에 "Response:" 문자열과 "received\n 문자열을 앞뒤에 붙여서 다시 전달.
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
				
		
		String message = (String)msg;
		
		Channel channel = ctx.channel();
		
		channel.writeAndFlush("Response : '" + message + "' received\n"); // () 내의 데이터를 메시지를 보내준 상대에게 전송
		
		
		
		if("quit".equals(message)) { // quit 보냈을 경우, 소켓 서버 종료. 종료하는 법 다양함.
			ctx.close();
		}
	}

	public EchoServerHandler() {
		// TODO Auto-generated constructor stub
	}

}
