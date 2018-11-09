package cn.com.leadu.fms.data.postbiz.repository.impl;

import cn.com.leadu.fms.data.postbiz.dao.SecHandInventoryDao;
import cn.com.leadu.fms.data.postbiz.repository.SecHandInventoryRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.SecHandInventory;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author huzongcheng
 * @ClassName: SecHandInventoryRepositoryImpl
 * @Description: 二手车库存Repository 实现层
 */
@Repository
public class SecHandInventoryRepositoryImpl extends AbstractBaseRepository<SecHandInventoryDao, SecHandInventory> implements SecHandInventoryRepository {

    /**
     * @Title:
     * @Description: 新增二手车库存
     * @param secHandInventory
     * @return int
     * @throws
     * @author huzongcheng
     * @date 2018-9-13 15:06:42
     */
    @Override
    public int insertData(SecHandInventory secHandInventory) {
        return super.insert(secHandInventory);
    }

    /**
     * @Title:
     * @Description: 批量保存二手车库存
     * @param secHandInventorys
     * @return int
     * @throws
     * @author huzongcheng
     * @date 2018-9-13 15:06:42
     */
    @Override
    public int insertDataList(List<SecHandInventory> secHandInventorys){
        return super.insertListByJdbcTemplate(secHandInventorys);
    }

    /**
     * @Title:
     * @Description: 修改二手车库存
     * @param secHandInventory
     * @return int
     * @throws
     * @author huzongcheng
     * @date 2018-9-13 15:06:42
     */
    @Override
    public int updateByPrimaryKeyData(SecHandInventory secHandInventory) {
        return super.updateByPrimaryKey(secHandInventory);
    }

    /**
     * @Title:
     * @Description: 批量修改二手车库存
     * @param secHandInventorys
     * @return int
     * @throws
     * @author huzongcheng
     * @date 2018-9-13 15:06:42
     */
    @Override
    public int updateByPrimaryKeyDataList(List<SecHandInventory> secHandInventorys){
        return super.updateListByPrimaryKey(secHandInventorys);
    }

    /**
     * @Title:
     * @Description: 动态修改二手车库存
     * @param secHandInventory
     * @return int
     * @throws
     * @author huzongcheng
     * @date 2018-9-13 15:06:42
     */
    @Override
    public int updateByPrimaryKeySelectiveData(SecHandInventory secHandInventory) {
        return super.updateByPrimaryKeySelective(secHandInventory);
    }

    /**
     * @Title:
     * @Description: 批量动态修改二手车库存
     * @param secHandInventorys
     * @return int
     * @throws
     * @author huzongcheng
     * @date 2018-9-13 15:06:42
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<SecHandInventory> secHandInventorys) {
        return super.updateListByPrimaryKeySelective(secHandInventorys);
    }

    /**
     * @Title:
     * @Description: 根据条件修改二手车库存
     * @param secHandInventory
     * @param example
     * @return int
     * @throws
     * @author huzongcheng
     * @date 2018-9-13 15:06:42
     */
    @Override
    public int updateByExampleData(SecHandInventory secHandInventory, Example example) {
        return super.updateByExample(secHandInventory,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改二手车库存
     * @param secHandInventory
     * @param example
     * @return int
     * @throws
     * @author huzongcheng
     * @date 2018-9-13 15:06:42
     */
    @Override
    public int updateByExampleSelectiveData(SecHandInventory secHandInventory, Example example){
        return super.updateByExampleSelective(secHandInventory,example);
    }
    
    /**
     * @Title:
     * @Description: 根据secHandId删除二手车库存
     * @param secHandInventory
     * @return int
     * @throws
     * @author huzongcheng
     * @date 2018-9-13 15:06:42
     */
    @Override
    public int deleteData(SecHandInventory secHandInventory) {
        return super.delete(secHandInventory);
    }

    /**
     * @Title:
     * @Description: 根据secHandId集合批量删除二手车库存
     * @param secHandInventory
     * @return int
     * @throws
     * @author huzongcheng
     * @date 2018-9-13 15:06:42
     */
    @Override
    public int deleteDataList(List secHandIds,SecHandInventory secHandInventory){
        return super.deleteByIds(secHandIds,secHandInventory);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除二手车库存
     * @param example
     * @param secHandInventory
     * @return int
     * @throws
     * @author huzongcheng
     * @date 2018-9-13 15:06:42
     */
    @Override
    public int deleteExampleData(Example example,SecHandInventory secHandInventory){
        return super.deleteByExample(example,secHandInventory);
    }

    /**
     * @Title:
     * @Description: 查询全部二手车库存
     * @return List<SecHandInventory>
     * @throws
     * @author huzongcheng
     * @date 2018-9-13 15:06:42
     */
    @Override
    public List<SecHandInventory> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个二手车库存
     * @param example
     * @return SecHandInventory
     * @throws
     * @author huzongcheng
     * @date 2018-9-13 15:06:42
     */
    @Override
    public SecHandInventory selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询二手车库存
     * @param example
     * @return List<SecHandInventory>
     * @throws
     * @author huzongcheng
     * @date 2018-9-13 15:06:42
     */
    @Override
    public List<SecHandInventory> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过secHandId查询二手车库存
     * @param secHandId
     * @return SecHandInventory
     * @throws
     * @author huzongcheng
     * @date 2018-9-13 15:06:42
     */
    @Override
    public SecHandInventory selectByPrimaryKey(Object secHandId) {
        return super.selectByPrimaryKey(secHandId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询二手车库存
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<SecHandInventory>
     * @throws
     * @author huzongcheng
     * @date 2018-9-13 15:06:42
     */
    @Override
    public PageInfoExtend<SecHandInventory> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询二手车库存vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author huzongcheng
     * @date 2018-9-13 15:06:42
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改二手车库存
     * @param secHandInventory,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author huzongcheng
     * @date 2018-9-13 15:06:42
     */
    @Override
    public int updateByPrimaryKeyData(SecHandInventory secHandInventory,boolean exclusive) {
        return super.updateByPrimaryKey(secHandInventory,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改二手车库存,并进行排他
     * @param secHandInventorys
     * @param exclusive
     * @return int
     * @throws
     * @author huzongcheng
     * @date 2018-9-13 15:06:42
     */
    @Override
    public int updateByPrimaryKeyDataList(List<SecHandInventory> secHandInventorys,boolean exclusive){
        return super.updateListByPrimaryKey(secHandInventorys,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改二手车库存,并进行排他
     * @param secHandInventory
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(SecHandInventory secHandInventory,boolean exclusive) {
        return super.updateByPrimaryKeySelective(secHandInventory,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改二手车库存,并进行排他
     * @param secHandInventorys
     * @param exclusive
     * @return int
     * @throws
     * @author huzongcheng
     * @date 2018-9-13 15:06:42
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<SecHandInventory> secHandInventorys,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(secHandInventorys,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改二手车库存,并进行排他
     * @param secHandInventory
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author huzongcheng
     * @date 2018-9-13 15:06:42
     */
    @Override
    public int updateByExampleData(SecHandInventory secHandInventory, Example example,boolean exclusive) {
        return super.updateByExample(secHandInventory,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改二手车库存,并进行排他
     * @param secHandInventory
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author huzongcheng
     * @date 2018-9-13 15:06:42
     */
    @Override
    public int updateByExampleSelectiveData(SecHandInventory secHandInventory, Example example,boolean exclusive){
        return super.updateByExampleSelective(secHandInventory,example,exclusive);
    }

}
