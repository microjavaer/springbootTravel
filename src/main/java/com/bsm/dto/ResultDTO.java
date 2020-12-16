package com.bsm.dto;

import com.bsm.exception.CustomizeCode;
import lombok.Data;

@Data
public class ResultDTO<T> {
    private Integer code;
    private String message;
    private T data;

    public static ResultDTO success()
    {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage("success");

        return resultDTO;
    }

    public static <T> ResultDTO success(T t)
    {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage("success");
        resultDTO.setData(t);

        return resultDTO;
    }

    public static ResultDTO error()
    {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(500);
        resultDTO.setMessage("error");

        return resultDTO;
    }

    public static ResultDTO error(Integer code, String message)
    {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(code);
        resultDTO.setMessage(message);

        return resultDTO;
    }

    public static ResultDTO error(CustomizeCode errorCode){
        return error(errorCode.getCode(), errorCode.getMessage());
    }
}
