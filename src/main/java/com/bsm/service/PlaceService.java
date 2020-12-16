package com.bsm.service;

import com.bsm.entity.TPlace;

import java.util.List;

public interface PlaceService {

    public Long getPlaceCount(Integer proId);

    public List<TPlace> getPlacesByProvinceId(Integer proId);
}
