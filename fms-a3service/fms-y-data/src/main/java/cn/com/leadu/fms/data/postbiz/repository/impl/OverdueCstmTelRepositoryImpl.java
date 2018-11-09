package cn.com.leadu.fms.data.postbiz.repository.impl;

import cn.com.leadu.fms.data.postbiz.dao.OverdueCstmTelDao;
import cn.com.leadu.fms.data.postbiz.repository.OverdueCstmTelRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueCstmTel;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: OverdueCstmTelRepositoryImpl
 * @Description: 逾期客户电话信息Repository 实现层
 * @date 2018-05-17
 */
@Repository
public class OverdueCstmTelRepositoryImpl extends AbstractBaseRepository<OverdueCstmTelDao, OverdueCstmTel> implements OverdueCstmTelRepository {

    /**
     * @Title:
     * @Description: 新增逾期客户电话信息
     * @param overdueCstmTel
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-17 10:37:53
     */
    @Override
    public int insertData(OverdueCstmTel overdueCstmTel) {
        return super.insert(overdueCstmTel);
    }

    /**
     * @Title:
     * @Description: 批量保存逾期客户电话信息
     * @param overdueCstmTels
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-17 10:37:53
     */
    @Override
    public int insertDataList(List<OverdueCstmTel> overdueCstmTels){
        return super.insertListByJdbcTemplate(overdueCstmTels);
    }

    /**
     * @Title:
     * @Description: 修改逾期客户电话信息
     * @param overdueCstmTel
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-17 10:37:53
     */
    @Override
    public int updateByPrimaryKeyData(OverdueCstmTel overdueCstmTel) {
        return super.updateByPrimaryKey(overdueCstmTel);
    }

    /**
     * @Title:
     * @Description: 批量修改逾期客户电话信息
     * @param overdueCstmTels
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-17 10:37:53
     */
    @Override
    public int updateByPrimaryKeyDataList(List<OverdueCstmTel> overdueCstmTels){
        return super.updateListByPrimaryKey(overdueCstmTels);
    }

    /**
     * @Title:
     * @Description: 动态修改逾期客户电话信息
     * @param overdueCstmTel
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-17 10:37:53
     */
    @Override
    public int updateByPrimaryKeySelectiveData(OverdueCstmTel overdueCstmTel) {
        return super.updateByPrimaryKeySelective(overdueCstmTel);
    }

    /**
     * @Title:
     * @Description: 批量动态修改逾期客户电话信息
     * @param overdueCstmTels
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-17 10:37:53
     */
    public int updateByPrimaryKeySelectiveDataList(List<OverdueCstmTel> overdueCstmTels) {
        return super.updateListByPrimaryKeySelective(overdueCstmTels);
    }

    /**
     * @Title:
     * @Description: 根据条件修改逾期客户电话信息
     * @param overdueCstmTel
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-17 10:37:53
     */
    @Override
    public int updateByExampleData(OverdueCstmTel overdueCstmTel, Example example) {
        return super.updateByExample(overdueCstmTel,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改逾期客户电话信息
     * @param overdueCstmTel
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-17 10:37:53
     */
    @Override
    public int updateByExampleSelectiveData(OverdueCstmTel overdueCstmTel, Example example){
        return super.updateByExampleSelective(overdueCstmTel,example);
    }
    
    /**
     * @Title:
     * @Description: 根据overdueCstmTelId删除逾期客户电话信息
     * @param overdueCstmTel
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-17 10:37:53
     */
    @Override
    public int deleteData(OverdueCstmTel overdueCstmTel) {
        return super.delete(overdueCstmTel);
    }

    /**
     * @Title:
     * @Description: 根据overdueCstmTelId集合批量删除逾期客户电话信息
     * @param overdueCstmTel
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-17 10:37:53
     */
    public int deleteDataList(List overdueCstmTelIds,OverdueCstmTel overdueCstmTel){
        return super.deleteByIds(overdueCstmTelIds,overdueCstmTel);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除逾期客户电话信息
     * @param example
     * @param overdueCstmTel
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-17 10:37:53
     */
    public int deleteExampleData(Example example,OverdueCstmTel overdueCstmTel){
        return super.deleteByExample(example,overdueCstmTel);
    }

    /**
     * @Title:
     * @Description: 查询全部逾期客户电话信息
     * @return List<OverdueCstmTel>
     * @throws
     * @author lijunjun
     * @date 2018-5-17 10:37:53
     */
    @Override
    public List<OverdueCstmTel> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个逾期客户电话信息
     * @param example
     * @return OverdueCstmTel
     * @throws
     * @author lijunjun
     * @date 2018-5-17 10:37:53
     */
    @Override
    public OverdueCstmTel selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询逾期客户电话信息
     * @param example
     * @return List<OverdueCstmTel>
     * @throws
     * @author lijunjun
     * @date 2018-5-17 10:37:53
     */
    @Override
    public List<OverdueCstmTel> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过overdueCstmTelId查询逾期客户电话信息
     * @param overdueCstmTelId
     * @return OverdueCstmTel
     * @throws
     * @author lijunjun
     * @date 2018-5-17 10:37:53
     */
    @Override
    public OverdueCstmTel selectByPrimaryKey(Object overdueCstmTelId) {
        return super.selectByPrimaryKey(overdueCstmTelId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询逾期客户电话信息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<OverdueCstmTel>
     * @throws
     * @author lijunjun
     * @date 2018-5-17 10:37:53
     */
    @Override
    public PageInfoExtend<OverdueCstmTel> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询逾期客户电话信息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author lijunjun
     * @date 2018-5-17 10:37:53
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}
