package com.star.mapper;

import com.star.domain.Record;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface RecordMapper {

    @Select("select * from tb_record where uid = #{uid}")
    public List<Record> selectByUid(int uid);

    @Update("update tb_record set status = #{status} where id = #{id}")
    public  void updateStatus(Record record);

    @Select("select * from tb_record where uid = #{uid} and status = #{status}")
    public List<Record> selectByStatus(@Param("uid")int uid, @Param("status")int status );

    public int add(Record record);
}
