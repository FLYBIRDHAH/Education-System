package com.wdw.edu.controller;


import com.wdw.edu.common.R;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wangdaiwu
 * @since 2022-05-14
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @RequestMapping("/login")
    public R login() {
        return R.ok().data("token", "admin");
    }

    @RequestMapping("/info")
    public R info(@RequestParam String token) {
        return R.ok()
                .data("name", "wangdaiwu")
                .data("roles", "[admin]")
                .data("avatar","https://wangdaiwu.oss-cn-guangzhou.aliyuncs.com/%E7%8E%8B%E8%80%81%E8%8F%8A.jpg");
    }
}

