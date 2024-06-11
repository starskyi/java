package com.star.dao;

import com.star.domain.Commodity;
import com.star.mapper.CommodityMapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

import static com.star.ui.MainInterface.sqlSession;

public class CommodityDao {


    CommodityMapper mapper = sqlSession.getMapper(CommodityMapper.class);;

    /**
     * 查询所有商品
     * @return 所有商品
     */
    public List<Commodity> findAll(int offset){
        List<Commodity> list = new ArrayList<Commodity>();
        try{
            list.addAll(mapper.findAll(offset));
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public List<Commodity> findAll1(){
        List<Commodity> list = new ArrayList<Commodity>();
        try{
            list.addAll(mapper.findAll1());
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 根据id 查找商品
     * @param id 商品id
     * @return 返回商品
     */
    public Commodity selectById(int id){
        return mapper.selectById(id);
    }

    /**
     * 根据销量获取商品
     * @return 排序后的商品
     */
    public List<Commodity> selectByCount(int offset){
        List<Commodity> list = new ArrayList<Commodity>();
        try{
            list.addAll(mapper.selectByCount(offset));
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }


    public List<Commodity> selectAllByKind(int kind){
        List<Commodity> list = new ArrayList<Commodity>();
        try{
            list.addAll(mapper.selectAllByKind(kind));
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 根据种类查询数据
     * @param kind 种类
     * @return 指定种类商品
     */
    public List<Commodity> selectByKind(int kind, int offset){
        List<Commodity> list = new ArrayList<Commodity>();
        try{
            list.addAll(mapper.selectByKind(kind, offset));
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public List<Commodity> findKindNotEight(){
        List<Commodity> list = new ArrayList<Commodity>();
        try{
            list.addAll(mapper.findKindNotEight());
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public void del(String image){
        mapper.del(image);
    }

    public void add(Commodity commodity){
        mapper.add(commodity);
    }

    public void updateCount(int count, int id){
        mapper.updateCount(count, id);
    }

    public List<Commodity> selectByTitle(String title){
        List<Commodity> list = new ArrayList<Commodity>();
        try{
            list.addAll(mapper.selectByTitle(title));
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
