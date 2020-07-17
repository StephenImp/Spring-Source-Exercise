package com.cn.source.ioc.service.impl;

import com.cn.source.ioc.service.IOCService;
import org.springframework.stereotype.Service;

@Service
public class IOCServiceImpl implements IOCService {
    @Override
    public String hello() {
        return "Hello,IOC";
    }
}
