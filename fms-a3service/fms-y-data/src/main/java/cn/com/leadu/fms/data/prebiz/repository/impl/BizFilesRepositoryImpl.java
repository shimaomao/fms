package cn.com.leadu.fms.data.prebiz.repository.impl;

import cn.com.leadu.fms.data.prebiz.dao.BizFilesDao;
import cn.com.leadu.fms.data.prebiz.repository.BizFilesRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author huchenghao
 * @ClassName: BizFilesRepositoryImpl
 * @Description: 附件信息Repository 实现层
 * @date 2018-04-09
 */
@Repository
public class BizFilesRepositoryImpl extends AbstractBaseRepository<BizFilesDao, BizFiles> implements BizFilesRepository {

    /**
     * @Title:
     * @Description: 新增附件信息
     * @param bizFiles
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-4-9 14:55:49
     */
    @Override
    public int insertData(BizFiles bizFiles) {
        return super.insert(bizFiles);
    }

    /**
     * @Title:
     * @Description: 批量保存附件信息
     * @param bizFiless
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-4-9 14:55:49
     */
    @Override
    public int insertDataList(List<BizFiles> bizFiless){
        return super.insertListByJdbcTemplate(bizFiless);
    }

    /**
     * @Title:
     * @Description: 修改附件信息
     * @param bizFiles
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-4-9 14:55:49
     */
    @Override
    public int updateByPrimaryKeyData(BizFiles bizFiles) {
        return super.updateByPrimaryKey(bizFiles);
    }

    /**
     * @Title:
     * @Description: 批量修改附件信息
     * @param bizFiless
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-4-9 14:55:49
     */
    @Override
    public int updateByPrimaryKeyDataList(List<BizFiles> bizFiless){
        return super.updateListByPrimaryKey(bizFiless);
    }

    /**
     * @Title:
     * @Description: 动态修改附件信息
     * @param bizFiles
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-4-9 14:55:49
     */
    @Override
    public int updateByPrimaryKeySelectiveData(BizFiles bizFiles) {
        return super.updateByPrimaryKeySelective(bizFiles);
    }

    /**
     * @Title:
     * @Description: 批量动态修改附件信息
     * @param bizFiless
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-4-9 14:55:49
     */
    public int updateByPrimaryKeySelectiveDataList(List<BizFiles> bizFiless) {
        return super.updateListByPrimaryKeySelective(bizFiless);
    }

    /**
     * @Title:
     * @Description: 根据条件修改附件信息
     * @param bizFiles
     * @param example
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-4-9 14:55:49
     */
    @Override
    public int updateByExampleData(BizFiles bizFiles, Example example) {
        return super.updateByExample(bizFiles,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改附件信息
     * @param bizFiles
     * @param example
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-4-9 14:55:49
     */
    @Override
    public int updateByExampleSelectiveData(BizFiles bizFiles, Example example){
        return super.updateByExampleSelective(bizFiles,example);
    }
    
    /**
     * @Title:
     * @Description: 根据fileId删除附件信息
     * @param bizFiles
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-4-9 14:55:49
     */
    @Override
    public int deleteData(BizFiles bizFiles) {
        return super.delete(bizFiles);
    }

    /**
     * @Title:
     * @Description: 根据fileId集合批量删除附件信息
     * @param bizFiles
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-4-9 14:55:49
     */
    public int deleteDataList(List fileIds,BizFiles bizFiles){
        return super.deleteByIds(fileIds,bizFiles);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除附件信息
     * @param example
     * @param bizFiles
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-4-9 14:55:49
     */
    public int deleteExampleData(Example example,BizFiles bizFiles){
        return super.deleteByExample(example,bizFiles);
    }

    /**
     * @Title:
     * @Description: 查询全部附件信息
     * @return List<BizFiles>
     * @throws
     * @author huchenghao
     * @date 2018-4-9 14:55:49
     */
    @Override
    public List<BizFiles> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个附件信息
     * @param example
     * @return BizFiles
     * @throws
     * @author huchenghao
     * @date 2018-4-9 14:55:49
     */
    @Override
    public BizFiles selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询附件信息
     * @param example
     * @return List<BizFiles>
     * @throws
     * @author huchenghao
     * @date 2018-4-9 14:55:49
     */
    @Override
    public List<BizFiles> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过fileId查询附件信息
     * @param fileId
     * @return BizFiles
     * @throws
     * @author huchenghao
     * @date 2018-4-9 14:55:49
     */
    @Override
    public BizFiles selectByPrimaryKey(Object fileId) {
        return super.selectByPrimaryKey(fileId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询附件信息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<BizFiles>
     * @throws
     * @author huchenghao
     * @date 2018-4-9 14:55:49
     */
    @Override
    public PageInfoExtend<BizFiles> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询附件信息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<BizFiles>
     * @throws
     * @author huchenghao
     * @date 2018-4-9 14:55:49
     */
    public PageInfoExtend<BizFiles> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}
