package study.websocket.initial;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import study.websocket.EchoServerHandler;

public class EchoServerInitializer extends ChannelInitializer<SocketChannel> {

	// 핵심이 InitChannel 이다. 
	// 이 메소드의 역할은 채널 파이프라인을 만들어주는 것이다.
	// TCP 연결이 accept 되었을 때 실행된다. 이전 Netty의 개요를 설명한 포스트에서 언급했던 파이프라인이
	// 바로 이 메소드에서 만들어진다.
	
	// 메소드에 Inbound 와 Outbound 가 섞여있다. 채널에 이벤트(메시지)가 발생하면 소켓 채널에서 읽어들이는
	// 것인지 소켓 채널로 쓰는 것인지에 따라서 파이프라인의 핸들러가 수행된다.
	
	
	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();
		
		pipeline.addLast(new LineBasedFrameDecoder(65536)); // default. 메시지를 라인 단위로 하나씩 끊어서 보내줌.
		pipeline.addLast(new StringDecoder()); // 받을 때 무조건 string으로 변환
		pipeline.addLast(new StringEncoder()); // 날릴 때 string -> byte 
		pipeline.addLast(new EchoServerHandler());  // 받은 메시지를 핸들러에서 처리
	}
}
