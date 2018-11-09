package cn.com.leadu.fms.baseinfo.service.impl;

import cn.com.leadu.fms.baseinfo.service.BasMsgService;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.baseinfo.repository.BasMsgRepository;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasMsg;
import cn.com.leadu.fms.pojo.baseinfo.vo.basmsg.BasMsgVo;
import cn.com.leadu.fms.baseinfo.validator.basmsg.vo.BasMsgSaveVo;
import cn.com.leadu.fms.baseinfo.validator.basmsg.vo.BasMsgModifyVo;
import cn.com.leadu.fms.baseinfo.validator.basmsg.vo.BasMsgDeleteVo;
import cn.com.leadu.fms.baseinfo.validator.basmsg.vo.BasMsgDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author yanfengbo
 * @ClassName: BasMsgService
 * @Description: 短信发送管理表业务实现层
 * @date 2018-03-15
 */
@Service
public class BasMsgServiceImpl implements BasMsgService {

    /**
     * @Fields  : 短信发送管理表repository
     */
    @Autowired
    private BasMsgRepository basMsgRepository;

    /**
     * @Title:
     * @Description: 分页查询短信发送管理表
     * @param basMsgVo
     * @return PageInfoExtend<BasMsg>
     * @throws
     * @author yanfengbo
     * @date 2018-3-15 16:35:27
     */
    public PageInfoExtend<BasMsgVo> findBasMsgByPage(BasMsgVo basMsgVo){
        //手机号码
        if(StringUtils.isTrimBlank(basMsgVo.getTelNo()))
            basMsgVo.setTelNo(null);
        else
            basMsgVo.setTelNo(basMsgVo.getTelNo());

        //短信发送状态
        if (StringUtils.isTrimBlank(basMsgVo.getMsgStatus()))
            basMsgVo.setMsgStatus(null);
        else
            basMsgVo.setMsgStatus(basMsgVo.getMsgStatus());

        //短信分类
        if (StringUtils.isTrimBlank(basMsgVo.getTplTypeName()))
            basMsgVo.setTplTypeName(null);
        else
            basMsgVo.setTplTypeName(SqlUtil.likePattern(basMsgVo.getTplTypeName()));

        PageInfoExtend<BasMsgVo> pageInfo = basMsgRepository.selectListVoByPage("selectBasMsgVoFromSysTplTypeVoByPage", basMsgVo, basMsgVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存短信发送管理表
     * @param basMsgSaveVo
     * @return java.lang.String
     * @throws
     * @author yanfengbo
     * @date 2018-3-15 16:35:27
     */
    public void saveBasMsg(BasMsgSaveVo basMsgSaveVo){
        basMsgRepository.insertData(basMsgSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改短信发送管理表
     * @param basMsgModifyVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-15 16:35:27
     */
    public void modifyBasMsg(BasMsgModifyVo basMsgModifyVo){
        basMsgRepository.updateByPrimaryKeySelectiveData(basMsgModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过msgId删除短信发送管理表
     * @param basMsgDeleteVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-15 16:35:27
     */
    public void deleteBasMsg(BasMsgDeleteVo basMsgDeleteVo){
        basMsgRepository.deleteData(basMsgDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过msgId集合删除短信发送管理表
     * @param basMsgDeleteListVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-15 16:35:27
     */
    public void deleteBasMsgsByMsgIds(BasMsgDeleteListVo basMsgDeleteListVo){
        basMsgRepository.deleteDataList(basMsgDeleteListVo.getMsgIds(),basMsgDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据msgId获取短信发送管理表
     * @param msgId
     * @return BasMsg
     * @throws
     * @author yanfengbo
     * @date 2018-3-15 16:35:27
     */

    public BasMsg findBasMsgByMsgId(String msgId){
        return basMsgRepository.selectByPrimaryKey(msgId);
    }

    /**
     * @Title:
     * @Description:   通过msg_id关联sys_tpl_type表查询bas_msg表（详情界面）
     * @param msgId
     * @return BasMsg
     * @throws
     * @author yanfengbo
     * @date 2018-3-15 16:35:27
     */
    public  BasMsgVo findBasMsgVoFromSysTplTypeVoByMsgId(String msgId){
        if(StringUtils.isTrimBlank(msgId))
            msgId = null;
        else
            msgId = msgId;
        return basMsgRepository.selectBasMsgVoFromSysTplTypeVoByMsgId(msgId);

    }

}
