package com.bsm.advice;

import com.alibaba.fastjson.JSON;
import com.bsm.dto.ResultDTO;
import com.bsm.exception.BussionException;
import com.bsm.exception.CustomizeCode;
import com.bsm.utils.ExistsAjaxRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ModelAndView exceptionHandler(HttpServletRequest request, HttpServletResponse response, Model model, Exception e){
        log.error("统一Controller系统异常，异常信息:{}, 异常堆栈 {}", e.getMessage() , e.toString());
        if (ExistsAjaxRequest.isAjaxRequest(request))
        {
            ResultDTO resultDTO = new ResultDTO();
            log.info("异步的~~~~");

            if (e instanceof BussionException) {
                //这里需要强制转换，不然获取不到CustomizeCode的值
                BussionException bussionException = (BussionException) e;
                resultDTO.setMessage(bussionException.getCustomizeCode().getMessage());
                resultDTO.setCode(bussionException.getCustomizeCode().getCode());

            } else {
                resultDTO.setMessage(CustomizeCode.INTERNAL_ERROR.getMessage());
                resultDTO.setCode(CustomizeCode.INTERNAL_ERROR.getCode());
            }

            try{
                response.setContentType("application/json");
                response.setStatus(200);
                response.setCharacterEncoding("utf-8");
                PrintWriter writer = response.getWriter();
                writer.write(JSON.toJSONString(resultDTO));
                writer.close();
            }catch (IOException ioe) {
                ioe.printStackTrace();
            }

            return null;
        }
        else
        {
            if (e instanceof BussionException) {
                //这里需要强制转换，不然获取不到CustomizeCode的值
                BussionException bussionException = (BussionException) e;
                model.addAttribute("message", bussionException.getCustomizeCode().getMessage());
            } else {
                model.addAttribute("message", CustomizeCode.SYS_ERROE.getMessage());
            }

            log.info("我是同步的~~~~");
            return new ModelAndView("error/exception");
        }

    }
}
