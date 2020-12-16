package com.bsm.controller;

import com.bsm.constant.RedisKeyConstant;
import com.bsm.dao.TUserMapper;
import com.bsm.dto.ResultDTO;
import com.bsm.dto.UserDTO;
import com.bsm.entity.TUser;
import com.bsm.exception.CustomizeCode;
import com.bsm.service.UserService;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    TUserMapper tUserMapper;

    @GetMapping("/login")
    public String login()
    {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResultDTO postLogin(HttpServletRequest request, UserDTO userDTO, String verCode)
    {
        if (!CaptchaUtil.ver(verCode, request))
        {
            CaptchaUtil.clear(request);
            return ResultDTO.error(CustomizeCode.CAPTCHA_CHECK_FAIL);
        }

        TUser tUser = new TUser();
        BeanUtils.copyProperties(userDTO, tUser);
        if (userService.findUserBynamePwd(tUser) == null)
        {
            return ResultDTO.error(CustomizeCode.USER_PASSWROD_LOGIN_ERROR);
        }

        request.getSession().setAttribute(RedisKeyConstant.USER_LOGIN, tUser);

        return ResultDTO.success();
    }

    @GetMapping("/register")
    public String register() {

        return "register";
    }

    @PostMapping("/register")
    @ResponseBody
    public ResultDTO postRegister(HttpServletRequest request, UserDTO userDTO, String verCode) {

        if (!CaptchaUtil.ver(verCode, request))
        {
            CaptchaUtil.clear(request);
            return ResultDTO.error(CustomizeCode.CAPTCHA_CHECK_FAIL);
        }

        TUser tUser = new TUser();
        BeanUtils.copyProperties(userDTO, tUser);
        if (tUserMapper.insert(tUser) <= 0)
        {
            return  ResultDTO.error(CustomizeCode.USER_REGISTER_ERROR);
        }

        return ResultDTO.success();
    }
}
