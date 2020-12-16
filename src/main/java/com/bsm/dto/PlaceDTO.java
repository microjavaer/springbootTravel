package com.bsm.dto;

import com.bsm.entity.TPlace;
import com.bsm.entity.TProvince;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class PlaceDTO extends TPlace {

/*    @Override
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getHottime() {
        return super.getHottime();
    }*/

    @Override
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setHottime(Date hottime) {
        super.setHottime(hottime);
    }
}
