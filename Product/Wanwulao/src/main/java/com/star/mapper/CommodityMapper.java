package com.star.mapper;

import com.star.domain.Commodity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CommodityMapper {

    @Select("select * from tb_commodity")
    List<Commodity> findAll();

    @Select("select * from tb_commodity where id = #{id}")
    Commodity selectById(int id);


    List<Commodity> selectByCount();

    @Select("select * from tb_commodity where kind = #{kind}")
    List<Commodity> selectByKind(int kind);

    @Select("select * from tb_commodity where kind != 8")
    List<Commodity> findKindNotEight();

    @Delete("delete from tb_commodity where image = #{image}")
    void del(String image);

    void add(Commodity commodity);

    @Update("update tb_commodity set count = #{count} where id = #{id}")
    void updateCount(@Param("count") int count, @Param("id") int id);

    @Select("select * from tb_commodity where title like #{title}")
    List<Commodity> selectByTitle(String title);
}
