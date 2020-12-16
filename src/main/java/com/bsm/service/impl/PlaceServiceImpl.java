package com.bsm.service.impl;

import com.bsm.dao.TPlaceMapper;
import com.bsm.entity.TPlace;
import com.bsm.entity.TPlaceExample;
import com.bsm.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    TPlaceMapper tPlaceMapper;

    /**
     * 获取景点数量
     *
     * @param proId
     * @return
     */
    @Override
    public Long getPlaceCount(Integer proId) {
        TPlaceExample example = new TPlaceExample();
        TPlaceExample.Criteria criteria = example.createCriteria();
        criteria.andProvinceidEqualTo(proId);
        return tPlaceMapper.countByExample(example);
    }

    @Override
    public List<TPlace> getPlacesByProvinceId(Integer proId) {

        TPlaceExample example = new TPlaceExample();
        example.setOrderByClause("provinceid asc");
        TPlaceExample.Criteria criteria = example.createCriteria();
        criteria.andProvinceidEqualTo(proId);

        return tPlaceMapper.selectByExampleWithBLOBs(example);
    }


}
