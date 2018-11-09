package cn.com.leadu.fms.data.baseinfo.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasMsg;
import cn.com.leadu.fms.pojo.baseinfo.vo.basmsg.BasMsgVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: BasMsgDao
 * @Description: 短信发送管理表dao层
 * @date 2018-03-15
 */
public interface BasMsgDao extends BaseDao<BasMsg> {
    /**
     * @Title:
     * @Description: 关联sys_tpl_type表分页查询bas_msg表（主界面）
     * @param basMsgVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-22 22:06:58
     */
    List<BasMsgVo> selectBasMsgVoFromSysTplTypeVoByPage(@Param("basMsgVo")BasMsgVo basMsgVo);

    /**
     * @Title:
     * @Description: 通过msg_id关联sys_tpl_type表查询bas_msg表（详情界面）
     * @param msgId
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-22 22:06:58
     */
    BasMsgVo selectBasMsgVoFromSysTplTypeVoByMsgId(@Param("msgId")Object msgId);

}