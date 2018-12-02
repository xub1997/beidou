package business.services;

import business.netty.TcpServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NettyServices {

    @Autowired
    private TcpServer tcpServer;

    @Autowired
    public void startTcp(){
        tcpServer.run();
    }
}
