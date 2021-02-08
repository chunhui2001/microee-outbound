package com.microee.ipserver.rmi;

import java.util.List;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.microee.plugin.response.R;

@FeignClient(name = "microee-ethdix-uniswapv2-sdk",
        url = "${micro.services.uniswap-dixx.listOfServers}",
        path = "/ip-discover",
        configuration = IPServerDiscoverClientConfiguration.class)
public interface IPServerDiscoverClient {

    // 根据传入的网段, 计算IP地址范围
    @RequestMapping(value = "/range", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public R<List<String>> range(@RequestParam("net") String chainId);
    
}
