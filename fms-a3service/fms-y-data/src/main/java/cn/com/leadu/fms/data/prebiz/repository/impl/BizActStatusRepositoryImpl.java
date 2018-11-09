package cn.com.leadu.fms.data.prebiz.repository.impl;

import cn.com.leadu.fms.data.prebiz.dao.BizActStatusDao;
import cn.com.leadu.fms.data.prebiz.repository.BizActStatusRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.BizActStatus;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author niehaibing
 * @ClassName: BizActStatusRepositoryImpl
 * @Description: 业务状态管理Repository 实现层
 * @date 2018-03-27
 */
@Repository
public class BizActStatusRepositoryImpl extends AbstractBaseRepository<BizActStatusDao, BizActStatus> implements BizActStatusRepository {

    /**
     * @Title:
     * @Description: 新增业务状态管理
     * @param bizActStatus
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-27 16:21:22
     */
    @Override
    public int insertData(BizActStatus bizActStatus) {
        return super.insert(bizActStatus);
    }

    /**
     * @Title:
     * @Description: 批量保存业务状态管理
     * @param bizActStatuss
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-27 16:21:22
     */
    @Override
    public int insertDataList(List<BizActStatus> bizActStatuss){
        return super.insertListByJdbcTemplate(bizActStatuss);
    }

    /**
     * @Title:
     * @Description: 修改业务状态管理
     * @param bizActStatus
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-27 16:21:22
     */
    @Override
    public int updateByPrimaryKeyData(BizActStatus bizActStatus) {
        return super.updateByPrimaryKey(bizActStatus);
    }

    /**
     * @Title:
     * @Description: 批量修改业务状态管理
     * @param bizActStatuss
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-27 16:21:22
     */
    @Override
    public int updateByPrimaryKeyDataList(List<BizActStatus> bizActStatuss){
        return super.insertListByJdbcTemplate(bizActStatuss);
    }

    /**
     * @Title:
     * @Description: 动态修改业务状态管理
     * @param bizActStatus
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-27 16:21:22
     */
    @Override
    public int updateByPrimaryKeySelectiveData(BizActStatus bizActStatus) {
        return super.updateByPrimaryKeySelective(bizActStatus);
    }

    /**
     * @Title:
     * @Description: 批量动态修改业务状态管理
     * @param bizActStatuss
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-27 16:21:22
     */
    public int updateByPrimaryKeySelectiveDataList(List<BizActStatus> bizActStatuss) {
        return super.updateListByPrimaryKeySelective(bizActStatuss);
    }

    /**
     * @Title:
     * @Description: 根据条件修改业务状态管理
     * @param bizActStatus
     * @param example
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-27 16:21:22
     */
    @Override
    public int updateByExampleData(BizActStatus bizActStatus, Example example) {
        return super.updateByExample(bizActStatus,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改业务状态管理
     * @param bizActStatus
     * @param example
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-27 16:21:22
     */
    @Override
    public int updateByExampleSelectiveData(BizActStatus bizActStatus, Example example){
        return super.updateByExampleSelective(bizActStatus,example);
    }
    
    /**
     * @Title:
     * @Description: 根据actStsId删除业务状态管理
     * @param bizActStatus
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-27 16:21:22
     */
    @Override
    public int deleteData(BizActStatus bizActStatus) {
        return super.delete(bizActStatus);
    }

    /**
     * @Title:
     * @Description: 根据actStsId集合批量删除业务状态管理
     * @param bizActStatus
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-27 16:21:22
     */
    public int deleteDataList(List actStsIds,BizActStatus bizActStatus){
        return super.deleteByIds(actStsIds,bizActStatus);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除业务状态管理
     * @param example
     * @param bizActStatus
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-27 16:21:22
     */
    public int deleteExampleData(Example example,BizActStatus bizActStatus){
        return super.deleteByExample(example,bizActStatus);
    }

    /**
     * @Title:
     * @Description: 查询全部业务状态管理
     * @return List<BizActStatus>
     * @throws
     * @author niehaibing
     * @date 2018-3-27 16:21:22
     */
    @Override
    public List<BizActStatus> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个业务状态管理
     * @param example
     * @return BizActStatus
     * @throws
     * @author niehaibing
     * @date 2018-3-27 16:21:22
     */
    @Override
    public BizActStatus selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询业务状态管理
     * @param example
     * @return List<BizActStatus>
     * @throws
     * @author niehaibing
     * @date 2018-3-27 16:21:22
     */
    @Override
    public List<BizActStatus> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过actStsId查询业务状态管理
     * @param actStsId
     * @return BizActStatus
     * @throws
     * @author niehaibing
     * @date 2018-3-27 16:21:22
     */
    @Override
    public BizActStatus selectByPrimaryKey(Object actStsId) {
        return super.selectByPrimaryKey(actStsId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询业务状态管理
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<BizActStatus>
     * @throws
     * @author niehaibing
     * @date 2018-3-27 16:21:22
     */
    @Override
    public PageInfoExtend<BizActStatus> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询业务状态管理vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<BizActStatus>
     * @throws
     * @author niehaibing
     * @date 2018-3-27 16:21:22
     */
    public PageInfoExtend<BizActStatus> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}
