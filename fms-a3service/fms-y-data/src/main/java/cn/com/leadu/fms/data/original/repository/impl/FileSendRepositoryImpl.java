package cn.com.leadu.fms.data.original.repository.impl;

import cn.com.leadu.fms.data.original.dao.FileSendDao;
import cn.com.leadu.fms.data.original.repository.FileSendRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.original.entity.FileSend;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: FileSendRepositoryImpl
 * @Description: 资料邮寄Repository 实现层
 * @date 2018-05-04
 */
@Repository
public class FileSendRepositoryImpl extends AbstractBaseRepository<FileSendDao, FileSend> implements FileSendRepository {

    /**
     * @Title:
     * @Description: 新增资料邮寄
     * @param fileSend
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-4 16:51:02
     */
    @Override
    public int insertData(FileSend fileSend) {
        return super.insert(fileSend);
    }

    /**
     * @Title:
     * @Description: 批量保存资料邮寄
     * @param fileSends
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-4 16:51:02
     */
    @Override
    public int insertDataList(List<FileSend> fileSends){
        return super.insertListByJdbcTemplate(fileSends);
    }

    /**
     * @Title:
     * @Description: 修改资料邮寄
     * @param fileSend
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-4 16:51:02
     */
    @Override
    public int updateByPrimaryKeyData(FileSend fileSend) {
        return super.updateByPrimaryKey(fileSend);
    }

    /**
     * @Title:
     * @Description: 批量修改资料邮寄
     * @param fileSends
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-4 16:51:02
     */
    @Override
    public int updateByPrimaryKeyDataList(List<FileSend> fileSends){
        return super.updateListByPrimaryKey(fileSends);
    }

    /**
     * @Title:
     * @Description: 动态修改资料邮寄
     * @param fileSend
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-4 16:51:02
     */
    @Override
    public int updateByPrimaryKeySelectiveData(FileSend fileSend) {
        return super.updateByPrimaryKeySelective(fileSend);
    }

    /**
     * @Title:
     * @Description: 批量动态修改资料邮寄
     * @param fileSends
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-4 16:51:02
     */
    public int updateByPrimaryKeySelectiveDataList(List<FileSend> fileSends) {
        return super.updateListByPrimaryKeySelective(fileSends);
    }

    /**
     * @Title:
     * @Description: 根据条件修改资料邮寄
     * @param fileSend
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-4 16:51:02
     */
    @Override
    public int updateByExampleData(FileSend fileSend, Example example) {
        return super.updateByExample(fileSend,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改资料邮寄
     * @param fileSend
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-4 16:51:02
     */
    @Override
    public int updateByExampleSelectiveData(FileSend fileSend, Example example){
        return super.updateByExampleSelective(fileSend,example);
    }
    
    /**
     * @Title:
     * @Description: 根据filePostId删除资料邮寄
     * @param fileSend
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-4 16:51:02
     */
    @Override
    public int deleteData(FileSend fileSend) {
        return super.delete(fileSend);
    }

    /**
     * @Title:
     * @Description: 根据filePostId集合批量删除资料邮寄
     * @param fileSend
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-4 16:51:02
     */
    public int deleteDataList(List filePostIds,FileSend fileSend){
        return super.deleteByIds(filePostIds,fileSend);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除资料邮寄
     * @param example
     * @param fileSend
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-4 16:51:02
     */
    public int deleteExampleData(Example example,FileSend fileSend){
        return super.deleteByExample(example,fileSend);
    }

    /**
     * @Title:
     * @Description: 查询全部资料邮寄
     * @return List<FileSend>
     * @throws
     * @author ningyangyang
     * @date 2018-5-4 16:51:02
     */
    @Override
    public List<FileSend> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个资料邮寄
     * @param example
     * @return FileSend
     * @throws
     * @author ningyangyang
     * @date 2018-5-4 16:51:02
     */
    @Override
    public FileSend selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询资料邮寄
     * @param example
     * @return List<FileSend>
     * @throws
     * @author ningyangyang
     * @date 2018-5-4 16:51:02
     */
    @Override
    public List<FileSend> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过filePostId查询资料邮寄
     * @param filePostId
     * @return FileSend
     * @throws
     * @author ningyangyang
     * @date 2018-5-4 16:51:02
     */
    @Override
    public FileSend selectByPrimaryKey(Object filePostId) {
        return super.selectByPrimaryKey(filePostId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询资料邮寄
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<FileSend>
     * @throws
     * @author ningyangyang
     * @date 2018-5-4 16:51:02
     */
    @Override
    public PageInfoExtend<FileSend> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询资料邮寄vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author ningyangyang
     * @date 2018-5-4 16:51:02
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}
