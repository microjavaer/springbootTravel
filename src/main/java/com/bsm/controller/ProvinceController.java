package com.bsm.controller;

import com.bsm.constant.RedisKeyConstant;
import com.bsm.dao.TPlaceMapper;
import com.bsm.dao.TProvinceMapper;
import com.bsm.dto.ProvinceDTO;
import com.bsm.dto.ResultDTO;
import com.bsm.entity.TPlaceExample;
import com.bsm.entity.TProvince;
import com.bsm.exception.BussionException;
import com.bsm.exception.CustomizeCode;
import com.bsm.service.PlaceService;
import com.bsm.utils.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProvinceController {

    @Autowired
    TProvinceMapper tProvinceMapper;

    @Autowired
    TPlaceMapper tPlaceMapper;

    @Autowired
    PlaceService placeService;

    @Autowired
    RedisUtil redisUtil;

    @GetMapping("/provincelist")
    public String provinceList(Model model) {
        List<TProvince> tProvinces = tProvinceMapper.selectByExample(null);
        model.addAttribute("tProvinces", tProvinces);
        return "provincelist";
    }

    @GetMapping("/addProvince")
    public String addProvince() {
        return "provinceAdd";
    }

    @PostMapping("/addProvince")
    @ResponseBody
    public ResultDTO postAddProvince(ProvinceDTO provinceDTO) {
        TProvince tProvince = new TProvince();
        BeanUtils.copyProperties(provinceDTO, tProvince);

        if (StringUtils.isBlank(tProvince.getName())) {
            return ResultDTO.error(CustomizeCode.PARAME_ERROR);
        }

        long count = tPlaceMapper.countByExample(null);
        tProvince.setPlacecounts((int) count);

        if (tProvinceMapper.insert(tProvince) <= 0) {
            return ResultDTO.error(CustomizeCode.SAVE_FAIL);
        }

        return ResultDTO.success();
    }

    @GetMapping("/updateProvince")
    public String updateProvince(String proId, Model model) throws InterruptedException {

        Object provinceObj = redisUtil.get(RedisKeyConstant.PROVINCE_LIST);
        TProvince tProvince = null;
        if (provinceObj != null) {
            tProvince = (TProvince) provinceObj;
        } else {
            tProvince = tProvinceMapper.selectByPrimaryKey(Integer.valueOf(proId));
            redisUtil.set(RedisKeyConstant.PROVINCE_LIST, tProvince, 3600);
        }

        if (tProvince == null) {
            throw new BussionException(CustomizeCode.SEARCH_RESULT_NOT_FOUND);
        }

        model.addAttribute("tProvince", tProvince);
        return "provinceUpdate";
    }

/*    @GetMapping("/test")
    public String test()
    {
        int a = 1/0;
        throw new RuntimeException("test");
    }


    @GetMapping("/rest")
    @ResponseBody
    public String restful()
    {
        throw new BussionException(CustomizeCode.SAVE_FAIL);
    }*/

    @PostMapping("/updateProvince")
    @ResponseBody
    public ResultDTO postupdateProvince(ProvinceDTO provinceDTO) {
        TProvince tProvince = new TProvince();

        BeanUtils.copyProperties(provinceDTO, tProvince);
        if (StringUtils.isBlank(tProvince.getName())) {
            return ResultDTO.error(CustomizeCode.PARAME_ERROR);
        }

        long count = placeService.getPlaceCount(tProvince.getId());

        if (count > 0)
        {
            tProvince.setPlacecounts((int)count);
        }

        int num = tProvinceMapper.updateByPrimaryKeySelective(tProvince);
        System.out.println("返回值：" + num);
        if (num <= 0) {
            return ResultDTO.error(CustomizeCode.SAVE_FAIL);
        }

        redisUtil.set(RedisKeyConstant.PROVINCE_LIST, tProvince);
        return ResultDTO.success();
    }

}
