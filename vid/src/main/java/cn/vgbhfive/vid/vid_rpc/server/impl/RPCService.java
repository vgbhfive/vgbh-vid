package cn.vgbhfive.vid.vid_rpc.server.impl;

import cn.vgbhfive.vid.vid_intf.intf.IdService;
import cn.vgbhfive.vid.vid_rpc.api.Service;
import cn.vgbhfive.vid.vid_rpc.server.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @time: 2018/11/7
 * @author: Vgbh
 */
@Component
public class RPCService implements Service {

    private static final Logger log = LoggerFactory.getLogger(RPCService.class);

    @Autowired
    private Server server;

    @Autowired
    private IdService idService;

    @Override
    public long genId() {
        try {
            server.server();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long id = idService.genId();
        log.info("RPC Server return Id:" + id);
        return id;
    }
}
