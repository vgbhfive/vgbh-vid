package cn.vgbhfive.vid.vid_service.provider.impl;

import cn.vgbhfive.vid.vid_service.provider.MachineIdProvider;
import cn.vgbhfive.vid.vid_service.util.IpUtils;
import com.sun.org.apache.xerces.internal.xs.ItemPSVI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @time:
 * @author: Vgbh
 */
@Component
@Qualifier("ip")
public class IpConfigurableMachineIdProvider implements MachineIdProvider {

    private static final Logger log = LoggerFactory.getLogger(IpConfigurableMachineIdProvider.class);

    private long machineId;

    //根据IP地址获取机器ID

    private Map<String, Long> ipsMap = new HashMap<String, Long>();

    public IpConfigurableMachineIdProvider () {
        log.info("\n IpConfigurableMachineIdProvider constructed! \n");
    }

    public IpConfigurableMachineIdProvider (String ips) {
        setIps(ips);
        init();
    }

    private void setIps(String ips) {
        log.info("\n IpConfigurableMachineIdProvider ips {} \n", ips);

        if (!StringUtils.isEmpty(ips)) {
            String[] ipArray = ips.split(" ");

            for (int i = 0; i < ipArray.length; i++) {
                ipsMap.put(ipArray[i], (long) i);
            }
        }
    }

    private void init() {
        String ip = IpUtils.getHostIp();//获取ip地址

        if (StringUtils.isEmpty(ip)) {
            String msg = "-----------Fail to get host IP address. Stop to initialize the IpConfigurableMachineIdProvider provider.-------------";
            log.error(msg);
            throw new IllegalStateException(msg);
        }

        if (!ipsMap.containsKey(ip)) {
            String msg = "-----------Fail to configure ID for host IP address %s. Stop to initialize the IpConfigurableMachineIdProvider provider.-------------";
            log.error(msg);
            throw new IllegalStateException(msg);
        }

        machineId = ipsMap.get(ip);

        log.info("\n IpConfigurableMachineIdProvider.init ip {} id {} \n", ip, machineId);
    }

    @Override
    public long getMachineId () {
        return machineId;
    }

    public void setMachineId (Long machineId) {
        this.machineId = machineId;
    }

}
