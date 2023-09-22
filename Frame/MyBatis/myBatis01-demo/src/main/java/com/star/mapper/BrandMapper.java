package com.star.mapper;

import com.star.domain.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandMapper {
    List<Brand> findAll();

    List<Brand> selectByCondition(@Param("brandName")String brandName, @Param("companyName")String companyName);
}
