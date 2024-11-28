package com.star.controller;

import com.star.pojo.Result;
import com.star.pojo.User;
import com.star.service.UserService;
import com.star.utils.JwtUtil;
import com.star.utils.Md5Util;
import com.star.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{3,16}$") String username,
                           @Pattern(regexp = "^\\S{5,16}$")String password) {

        User user = userService.findByUsername(username);
        if (user == null) {
            //未被占用，注册用户
            userService.register(username, password);
            return Result.success();
        }else {
             //占用
            return Result.error("用户名已被占用");
        }
    }

    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{3,16}$") String username,
                                @Pattern(regexp = "^\\S{5,16}$")String password){

        User user = userService.findByUsername(username);
        if(user == null){
            return Result.error("用户名错误");
        }

        if(Md5Util.getMD5String(password).equals(user.getPassword())){
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", user.getId());
            claims.put("username", user.getUsername());

            String token = JwtUtil.genToken(claims);

            return Result.success(token);
        }

        return Result.error("密码错误");
    }

    @GetMapping("/userInfo")
    public Result<User> userInfo(/*@RequestHeader(name = "Authorization") String token*/){
//        Map<String, Object> map = JwtUtil.parseToken(token);
//        String username = (String) map.get("username");
        Map<String, Object> claims = ThreadLocalUtil.get();
        String username = (String) claims.get("username");

        User user = userService.findByUsername(username);
        return Result.success(user);
    }

    @PutMapping("/update")
    public Result update(@RequestBody @Validated User user){
        userService.update(user);
        return Result.success();
    }

    @PatchMapping("/updateAvatar")
    public Result updateAvatar(@RequestParam String avatarUrl){
        System.out.println("haha" + " => " + avatarUrl);
        userService.updateAvatar(avatarUrl);
        return Result.success();
    }

    @PatchMapping("updatePwd")
    public Result updatePwd(@RequestBody Map<String,String> params){
        String oldPwd = params.get("old_pwd");
        String newPwd = params.get("new_pwd");
        String rePwd = params.get("re_pwd");

        //判断参数是否为空
        if(!StringUtils.hasLength(oldPwd) || !StringUtils.hasLength(newPwd) || !StringUtils.hasLength(rePwd)){
            return Result.error("参数不能为空");
        }

        //获取登录用户信息
        Map<String, Object> map = ThreadLocalUtil.get();
        String username = (String)map.get("username");
        User loginUser = userService.findByUsername(username);

        //判断旧密码是否正确
        if(!loginUser.getPassword().equals(Md5Util.getMD5String(oldPwd))){
            return Result.error("原密码错误");
        }

        //判断两次密码是否一致
        if(!newPwd.equals(rePwd)){
            return Result.error("两次密码不一致");
        }

        //完成密码更新
        userService.updatePwd(newPwd);
        return Result.success();
    }
}
