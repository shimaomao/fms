package cn.com.leadu.fms.data.product.repository.impl;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.product.dao.ProdFileDao;
import cn.com.leadu.fms.data.product.repository.ProdFileRepository;
import cn.com.leadu.fms.pojo.product.entity.ProdFile;
import cn.com.leadu.fms.pojo.product.vo.prodfile.ProdFileVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: ProdFileRepositoryImpl
 * @Description: 产品附件管理Repository 实现层
 * @date 2018-04-05
 */
@Repository
public class ProdFileRepositoryImpl extends AbstractBaseRepository<ProdFileDao, ProdFile> implements ProdFileRepository {

    /**
     * @Title:
     * @Description: 新增产品附件管理
     * @param prodFile
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:54:11
     */
    @Override
    public int insertData(ProdFile prodFile) {
        return super.insert(prodFile);
    }

    /**
     * @Title:
     * @Description: 批量保存产品附件管理
     * @param prodFiles
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:54:11
     */
    @Override
    public int insertDataList(List<ProdFile> prodFiles){
        return super.insertListByJdbcTemplate(prodFiles);
    }

    /**
     * @Title:
     * @Description: 修改产品附件管理
     * @param prodFile
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:54:11
     */
    @Override
    public int updateByPrimaryKeyData(ProdFile prodFile) {
        return super.updateByPrimaryKey(prodFile);
    }

    /**
     * @Title:
     * @Description: 批量修改产品附件管理
     * @param prodFiles
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:54:11
     */
    @Override
    public int updateByPrimaryKeyDataList(List<ProdFile> prodFiles){
        return super.updateListByPrimaryKey(prodFiles);
    }

    /**
     * @Title:
     * @Description: 动态修改产品附件管理
     * @param prodFile
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:54:11
     */
    @Override
    public int updateByPrimaryKeySelectiveData(ProdFile prodFile) {
        return super.updateByPrimaryKeySelective(prodFile);
    }

    /**
     * @Title:
     * @Description: 批量动态修改产品附件管理
     * @param prodFiles
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:54:11
     */
    public int updateByPrimaryKeySelectiveDataList(List<ProdFile> prodFiles) {
        return super.updateListByPrimaryKeySelective(prodFiles);
    }

    /**
     * @Title:
     * @Description: 根据条件修改产品附件管理
     * @param prodFile
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:54:11
     */
    @Override
    public int updateByExampleData(ProdFile prodFile, Example example) {
        return super.updateByExample(prodFile,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改产品附件管理
     * @param prodFile
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:54:11
     */
    @Override
    public int updateByExampleSelectiveData(ProdFile prodFile, Example example){
        return super.updateByExampleSelective(prodFile,example);
    }
    
    /**
     * @Title:
     * @Description: 根据prodFileId删除产品附件管理
     * @param prodFile
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:54:11
     */
    @Override
    public int deleteData(ProdFile prodFile) {
        return super.delete(prodFile);
    }

    /**
     * @Title:
     * @Description: 根据prodFileId集合批量删除产品附件管理
     * @param prodFile
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:54:11
     */
    public int deleteDataList(List prodFileIds,ProdFile prodFile){
        return super.deleteByIds(prodFileIds,prodFile);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除产品附件管理
     * @param example
     * @param prodFile
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:54:11
     */
    public int deleteExampleData(Example example,ProdFile prodFile){
        return super.deleteByExample(example,prodFile);
    }

    /**
     * @Title:
     * @Description: 查询全部产品附件管理
     * @return List<ProdFile>
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:54:11
     */
    @Override
    public List<ProdFile> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个产品附件管理
     * @param example
     * @return ProdFile
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:54:11
     */
    @Override
    public ProdFile selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询产品附件管理
     * @param example
     * @return List<ProdFile>
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:54:11
     */
    @Override
    public List<ProdFile> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过prodFileId查询产品附件管理
     * @param prodFileId
     * @return ProdFile
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:54:11
     */
    @Override
    public ProdFile selectByPrimaryKey(Object prodFileId) {
        return super.selectByPrimaryKey(prodFileId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询产品附件管理
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<ProdFile>
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:54:11
     */
    @Override
    public PageInfoExtend<ProdFile> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询产品附件管理vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<ProdFile>
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:54:11
     */
    public PageInfoExtend<ProdFile> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 通过产品方案查询
     * @param product
     * @return List<ProdFileVo>
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:36:32
     */
    public List<ProdFileVo> selectProdFileVosByProduct(String product){
        return baseDao.selectProdFileVosByProduct(product);
    };

}
