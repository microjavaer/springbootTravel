package com.bsm.controller;

import com.bsm.dao.TPlaceMapper;
import com.bsm.dao.TProvinceMapper;
import com.bsm.dto.PlaceDTO;
import com.bsm.dto.ResultDTO;
import com.bsm.entity.TPlace;
import com.bsm.entity.TProvince;
import com.bsm.exception.BussionException;
import com.bsm.exception.CustomizeCode;
import com.bsm.service.PlaceService;
import com.bsm.utils.FileUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class PlaceController {

    private static Logger log = LoggerFactory.getLogger(PlaceController.class);

    @Value("${upload.dir}")
    private String savePath;

    @Autowired
    TPlaceMapper tPlaceMapper;

    @Autowired
    PlaceService placeService;

    @Autowired
    TProvinceMapper tProvinceMapper;

    @GetMapping("/placelist")
    public String placeList(String proId, Model model) {

        if (proId == null) {
            throw new BussionException(CustomizeCode.PARAME_ERROR);
        }

        List<TPlace> tPlaces = placeService.getPlacesByProvinceId(Integer.valueOf(proId));

        if (tPlaces.isEmpty()) {
            throw new BussionException(CustomizeCode.SEARCH_RESULT_NOT_FOUND);
        }

        model.addAttribute("tPlaces", tPlaces);
        return "placelist";
    }

    @GetMapping("/addPlace")
    public String addPlace(Model model) {

        List<TProvince> tProvinces = tProvinceMapper.selectByExample(null);

        model.addAttribute("tProvinces", tProvinces);
        return "placeAdd";
    }

    @PostMapping("/addPlace")
    @ResponseBody
    public ResultDTO postAddPlace(MultipartFile file, PlaceDTO placeDTO) {

        if (file == null || file.isEmpty()) {
            return ResultDTO.error(CustomizeCode.UPLOAD_PARAME_EMPTY);
        }

        String originalFilename = file.getOriginalFilename();
        String fileSuffix = FileUtil.getFileSuffix(originalFilename);
        String randomFileName = FileUtil.getRandomFileName(fileSuffix);
        String filePath = savePath + "/" + randomFileName;
        File saveFile = new File(filePath);

        if (!saveFile.getParentFile().exists()) {
            saveFile.getParentFile().mkdirs();
        }

        try {
            file.transferTo(saveFile);
        } catch (IOException e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return ResultDTO.error(CustomizeCode.UPLOAD_FILE_FAIL);
        }

        TPlace tPlace = new TPlace();
        BeanUtils.copyProperties(placeDTO, tPlace);

        if (StringUtils.isBlank(tPlace.getName())) {
            //如果校验失败就删除文件
            saveFile.delete();
            return ResultDTO.error(CustomizeCode.PARAME_ERROR);
        }

        tPlace.setPicpath(filePath);

        if (tPlaceMapper.insert(tPlace) <= 0) {
            //如果校验失败就删除文件
            saveFile.delete();
            return ResultDTO.error(CustomizeCode.SAVE_FAIL);
        }

        return ResultDTO.success();
    }

    @GetMapping("/deletePlace")
    public ResultDTO deletePlace(Integer placeId) {
        return ResultDTO.success();
    }
}
