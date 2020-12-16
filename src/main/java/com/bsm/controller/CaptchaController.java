package com.bsm.controller;

import com.bsm.dto.ResultDTO;
import com.bsm.exception.CustomizeCode;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class CaptchaController {
    @GetMapping("/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CaptchaUtil.out(request, response);
    }


    @GetMapping("/checkCaptcha")
    @ResponseBody
    public ResultDTO checkCaptcha(HttpServletRequest request, String verCode) throws IOException {
        if (!CaptchaUtil.ver(verCode, request))
        {
            CaptchaUtil.clear(request);
            return ResultDTO.error(CustomizeCode.CAPTCHA_CHECK_FAIL);
        }

        return ResultDTO.success();
    }
}
