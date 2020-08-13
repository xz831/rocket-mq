package com.zx.rocketmq;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package: com.zx.rocketmq
 * @ClassName: Controller
 * @Author: xz
 * @Date: 2020/8/13 16:49
 * @Version: 1.0
 */
@RestController
@RequestMapping("/test")
public class Controller {

    @GetMapping("/run")
    public void run(){

    }
}
