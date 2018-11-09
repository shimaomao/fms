package cn.com.leadu.fms.data.baseinfo.repository.impl;

import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.baseinfo.dao.BasMsgDao;
import cn.com.leadu.fms.data.baseinfo.repository.BasMsgRepository;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasMsg;
import cn.com.leadu.fms.pojo.baseinfo.vo.basmsg.BasMsgVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: BasMsgRepositoryImpl
 * @Description: 短信发送管理表Repository 实现层
 * @date 2018-03-15
 */
@Repository
public class BasMsgRepositoryImpl extends AbstractBaseRepository<BasMsgDao, BasMsg> implements BasMsgRepository {

    /**
     * @Title:
     * @Description: 新增短信发送管理表
     * @param basMsg
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-3-15 16:35:27
     */
    @Override
    public int insertData(BasMsg basMsg) {
        return super.insert(basMsg);
    }

    /**
     * @Title:
     * @Description: 批量保存短信发送管理表
     * @param basMsgs
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-3-15 16:35:27
     */
    @Override
    public int insertDataList(List<BasMsg> basMsgs){
        return super.insertListByJdbcTemplate(basMsgs);
    }

    /**
     * @Title:
     * @Description: 修改短信发送管理表
     * @param basMsg
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-3-15 16:35:27
     */
    @Override
    public int updateByPrimaryKeyData(BasMsg basMsg) {
        return super.updateByPrimaryKey(basMsg);
    }

    /**
     * @Title:
     * @Description: 批量修改短信发送管理表
     * @param basMsgs
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-3-15 16:35:27
     */
    @Override
    public int updateByPrimaryKeyDataList(List<BasMsg> basMsgs){
        return super.updateListByPrimaryKey(basMsgs);
    }

    /**
     * @Title:
     * @Description: 动态修改短信发送管理表
     * @param basMsg
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-3-15 16:35:27
     */
    @Override
    public int updateByPrimaryKeySelectiveData(BasMsg basMsg) {
        return super.updateByPrimaryKeySelective(basMsg);
    }

    /**
     * @Title:
     * @Description: 批量动态修改短信发送管理表
     * @param basMsgs
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-3-15 16:35:27
     */
    public int updateByPrimaryKeySelectiveDataList(List<BasMsg> basMsgs) {
        return super.updateListByPrimaryKeySelective(basMsgs);
    }

    /**
     * @Title:
     * @Description: 根据条件修改短信发送管理表
     * @param basMsg
     * @param example
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-3-15 16:35:27
     */
    @Override
    public int updateByExampleData(BasMsg basMsg, Example example) {
        return super.updateByExample(basMsg,example);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改短信发送管理表
     * @param basMsg
     * @param example
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-3-15 16:35:27
     */
    @Override
    public int updateByExampleSelectiveData(BasMsg basMsg, Example example){
        return super.updateByExampleSelective(basMsg,example);
    }

    /**
     * @Title:
     * @Description: 根据msgId删除短信发送管理表
     * @param basMsg
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-3-15 16:35:27
     */
    @Override
    public int deleteData(BasMsg basMsg) {
        return super.delete(basMsg);
    }

    /**
     * @Title:
     * @Description: 根据msgId集合批量删除短信发送管理表
     * @param basMsg
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-3-15 16:35:27
     */
    public int deleteDataList(List msgIds,BasMsg basMsg){
        return super.deleteByIds(msgIds,basMsg);
    }

    /**
     * @Title:
     * @Description: 查询全部短信发送管理表
     * @return List<BasMsg>
     * @throws
     * @author yanfengbo
     * @date 2018-3-15 16:35:27
     */
    @Override
    public List<BasMsg> selectAll() {
        return super.selectAll();
    }

    /**
     * @Title:
     * @Description: 通过条件查询一个短信发送管理表
     * @param example
     * @return BasMsg
     * @throws
     * @author yanfengbo
     * @date 2018-3-15 16:35:27
     */
    @Override
    public BasMsg selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }

    /**
     * @Title:
     * @Description: 通过条件批量查询短信发送管理表
     * @param example
     * @return List<BasMsg>
     * @throws
     * @author yanfengbo
     * @date 2018-3-15 16:35:27
     */
    @Override
    public List<BasMsg> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }

    /**
     * @Title:
     * @Description: 通过msgId查询短信发送管理表
     * @param msgId
     * @return BasMsg
     * @throws
     * @author yanfengbo
     * @date 2018-3-15 16:35:27
     */
    @Override
    public BasMsg selectByPrimaryKey(Object msgId) {
        return super.selectByPrimaryKey(msgId);
    }

    /**
     * @Title:
     * @Description: 分页查询短信发送管理表
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<BasMsg>
     * @throws
     * @author yanfengbo
     * @date 2018-3-15 16:35:27
     */
    @Override
    public PageInfoExtend<BasMsg> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询短信发送管理表vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<BasMsg>
     * @throws
     * @author yanfengbo
     * @date 2018-3-15 16:35:27
     */
    public PageInfoExtend<BasMsgVo> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 通过msg_id关联sys_tpl_type表查询bas_msg表（详情界面）
     * @param msgId
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    @Override
    public BasMsgVo selectBasMsgVoFromSysTplTypeVoByMsgId(Object msgId){
        return baseDao.selectBasMsgVoFromSysTplTypeVoByMsgId(msgId);

    }


}
