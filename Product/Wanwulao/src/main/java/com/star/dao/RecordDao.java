package com.star.dao;

import com.star.domain.Commodity;
import com.star.domain.Record;
import com.star.mapper.RecordMapper;

import java.util.ArrayList;
import java.util.List;

import static com.star.ui.MainInterface.sqlSession;

public class RecordDao {

    RecordMapper mapper = sqlSession.getMapper(RecordMapper.class);;

    /**
     * 查找当前用户所有购买记录
     * @param uid 用户id
     * @return 当前用户所用记录
     */
    public List<Record> selectByUid(int uid){
        List<Record> list = new ArrayList<Record>();
        try{
            list.addAll(mapper.selectByUid(uid));
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 更新支付状态
     * @param record 当前购买记录
     */
    public int updateStatus(Record record){
        return mapper.updateStatus(record);
    }

    /**
     * 根据购买状态查找记录
     * @param uid 用户id
     * @param status 购买状态
     * @return 根据状态分类的所用记录
     */
    public List<Record> selectByStatus(int uid, int status){
        return mapper.selectByStatus(uid, status);
    }

    /**
     * 添加记录
     * @param record 购买记录
     * @return true | false
     */
    public boolean add(Record record){
        int flag = mapper.add(record);
        return flag == 1;
    }

}
