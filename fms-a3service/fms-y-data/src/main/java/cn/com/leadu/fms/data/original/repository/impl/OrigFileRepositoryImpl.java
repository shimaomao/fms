package cn.com.leadu.fms.data.original.repository.impl;

import cn.com.leadu.fms.data.original.dao.OrigFileDao;
import cn.com.leadu.fms.data.original.repository.OrigFileRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.original.entity.OrigFile;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.original.vo.origfile.OrigFileSortVo;
import cn.com.leadu.fms.pojo.original.vo.origfile.OrigFileVo;
import cn.com.leadu.fms.pojo.original.vo.origfiledetail.OrigFileDetailVo;
import cn.com.leadu.fms.pojo.original.vo.origfiledetail.OrigFileStatusVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: OrigFileRepositoryImpl
 * @Description: 资料邮寄附件Repository 实现层
 * @date 2018-05-03
 */
@Repository
public class OrigFileRepositoryImpl extends AbstractBaseRepository<OrigFileDao, OrigFile> implements OrigFileRepository {

    /**
     * @Title:
     * @Description: 新增资料邮寄附件
     * @param origFile
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    @Override
    public int insertData(OrigFile origFile) {
        return super.insert(origFile);
    }

    /**
     * @Title:
     * @Description: 批量保存资料邮寄附件
     * @param origFiles
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    @Override
    public int insertDataList(List<OrigFile> origFiles){
        return super.insertListByJdbcTemplate(origFiles);
    }

    /**
     * @Title:
     * @Description: 修改资料邮寄附件
     * @param origFile
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    @Override
    public int updateByPrimaryKeyData(OrigFile origFile) {
        return super.updateByPrimaryKey(origFile);
    }

    /**
     * @Title:
     * @Description: 批量修改资料邮寄附件
     * @param origFiles
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    @Override
    public int updateByPrimaryKeyDataList(List<OrigFile> origFiles){
        return super.updateListByPrimaryKey(origFiles);
    }

    /**
     * @Title:
     * @Description: 动态修改资料邮寄附件
     * @param origFile
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    @Override
    public int updateByPrimaryKeySelectiveData(OrigFile origFile) {
        return super.updateByPrimaryKeySelective(origFile);
    }

    /**
     * @Title:
     * @Description: 批量动态修改资料邮寄附件
     * @param origFiles
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    public int updateByPrimaryKeySelectiveDataList(List<OrigFile> origFiles) {
        return super.updateListByPrimaryKeySelective(origFiles);
    }

    /**
     * @Title:
     * @Description: 根据条件修改资料邮寄附件
     * @param origFile
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    @Override
    public int updateByExampleData(OrigFile origFile, Example example) {
        return super.updateByExample(origFile,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改资料邮寄附件
     * @param origFile
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    @Override
    public int updateByExampleSelectiveData(OrigFile origFile, Example example){
        return super.updateByExampleSelective(origFile,example);
    }
    
    /**
     * @Title:
     * @Description: 根据origFileId删除资料邮寄附件
     * @param origFile
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    @Override
    public int deleteData(OrigFile origFile) {
        return super.delete(origFile);
    }

    /**
     * @Title:
     * @Description: 根据origFileId集合批量删除资料邮寄附件
     * @param origFile
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    public int deleteDataList(List origFileIds,OrigFile origFile){
        return super.deleteByIds(origFileIds,origFile);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除资料邮寄附件
     * @param example
     * @param origFile
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    public int deleteExampleData(Example example,OrigFile origFile){
        return super.deleteByExample(example,origFile);
    }

    /**
     * @Title:
     * @Description: 查询全部资料邮寄附件
     * @return List<OrigFile>
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    @Override
    public List<OrigFile> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个资料邮寄附件
     * @param example
     * @return OrigFile
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    @Override
    public OrigFile selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询资料邮寄附件
     * @param example
     * @return List<OrigFile>
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    @Override
    public List<OrigFile> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过origFileId查询资料邮寄附件
     * @param origFileId
     * @return OrigFile
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    @Override
    public OrigFile selectByPrimaryKey(Object origFileId) {
        return super.selectByPrimaryKey(origFileId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询资料邮寄附件
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<OrigFile>
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    @Override
    public PageInfoExtend<OrigFile> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询资料邮寄附件vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 查询资料归档附件信息
     * @param origFileVo
     * @return List<OrigFileVo>
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:47
     */
//    @Override
//    public List<OrigFileVo> selectOrigFileVosByOrigFileStatus(OrigFileVo origFileVo) {
//        return baseDao.selectOrigFileVosByOrigFileStatus(origFileVo);
//    }

    /**
     * @Title:
     * @Description: 根据归档状态查询资料邮件附件信息
     * @param origFileVo
     * @return OrigFileVo
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:47
     */
    @Override
    public OrigFileVo selectOrigFileInfoByBizCodeAndBizCodeType(OrigFileVo origFileVo) {
        return baseDao.selectOrigFileInfoByBizCodeAndBizCodeType(origFileVo);
    }

    /**
     * @Title:
     * @Description: 获取贷前归档明细一览画面数据
     * @param origFileDetailVo
     * @return OrigFileSortVo
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    @Override
    public OrigFileSortVo selectOrigFileSortDetailsByPage(OrigFileDetailVo origFileDetailVo) {
        return baseDao.selectOrigFileSortDetailsByPage(origFileDetailVo);
    }

    /**
     * @Title:
     * @Description: 获取保单归档明细一览画面数据
     * @param origFileDetailVo
     * @return OrigFileSortVo
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    @Override
    public OrigFileSortVo selectOrigFileRenewalSortDetailsByPage(OrigFileDetailVo origFileDetailVo) {
        return baseDao.selectOrigFileRenewalSortDetailsByPage(origFileDetailVo);
    }

    /**
     * @Title:
     * @Description: 获取邮寄附件明细表信息（资料邮寄用）
     * @param origFileVo
     * @return BorrowBackTaskVo
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    @Override
    public List<OrigFileDetailVo> selectOrigFileMailList(@Param("origFileVo") OrigFileVo origFileVo) {
        return baseDao.selectOrigFileMailList(origFileVo);
    }

    /**
     * @Title:
     * @Description: 查询融保险资料邮寄附件信息
     * @param
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:46
     */
    @Override
    public List<OrigFileVo> selectOrigFileVos(OrigFileVo origFileVo) {
        return baseDao.selectOrigFileVos(origFileVo);
    }

    /**
     * 根据合同号获取过户状态与收款状态
     */
    @Override
    public OrigFileStatusVo selectOrigFileStatusVoByContNo(String contNo) {
        return baseDao.selectOrigFileStatusVoByContNo(contNo);
    }

}
