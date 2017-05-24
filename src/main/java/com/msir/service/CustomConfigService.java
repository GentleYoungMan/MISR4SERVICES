package com.msir.service;

import com.msir.entity.CustomConfig;

import java.util.List;

public interface CustomConfigService {
    List<CustomConfig> queryCustomConfig();

    int insertCustomConfig(CustomConfig customConfig);

    int deleteCustomConfig(int menuId);

    int updateCustomConfig(CustomConfig customConfig);
}
