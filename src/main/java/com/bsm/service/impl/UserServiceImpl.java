package com.bsm.service.impl;

import com.bsm.dao.TUserMapper;
import com.bsm.entity.TUser;
import com.bsm.entity.TUserExample;
import com.bsm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    TUserMapper tUserMapper;

    @Override
    public TUser findUserBynamePwd(TUser tUser) {
        TUserExample tUserExample = new TUserExample();
        tUserExample.createCriteria().andUsernameEqualTo(tUser.getUsername()).andPasswordEqualTo(tUser.getPassword());
        List<TUser> tUsers = tUserMapper.selectByExample(tUserExample);
        System.out.println(tUsers);
        return !tUsers.isEmpty() ? tUsers.get(0) : null;
    }
}
