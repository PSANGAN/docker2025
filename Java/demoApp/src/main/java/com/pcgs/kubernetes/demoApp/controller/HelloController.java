package com.pcgs.kubernetes.demoApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HelloController {
    @GetMapping("/hello")
    String hello() throws java.net.UnknownHostException {
        return "Hello from pod " + java.net.InetAddress.getLocalHost().getHostName() + "\n";
    }
}
