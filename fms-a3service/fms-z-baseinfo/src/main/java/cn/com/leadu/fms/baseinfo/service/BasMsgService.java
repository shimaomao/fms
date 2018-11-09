package cn.com.leadu.fms.baseinfo.service;

import cn.com.leadu.fms.pojo.baseinfo.entity.BasMsg;
import cn.com.leadu.fms.pojo.baseinfo.vo.basmsg.BasMsgVo;
import cn.com.leadu.fms.baseinfo.validator.basmsg.vo.BasMsgSaveVo;
import cn.com.leadu.fms.baseinfo.validator.basmsg.vo.BasMsgModifyVo;
import cn.com.leadu.fms.baseinfo.validator.basmsg.vo.BasMsgDeleteVo;
import cn.com.leadu.fms.baseinfo.validator.basmsg.vo.BasMsgDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author yanfengbo
 * @ClassName: BasMsgService
 * @Description: 短信发送管理表业务层
 * @date 2018-03-15
 */
public interface BasMsgService {

	/**
	 * @Title:
	 * @Description: 分页查询短信发送管理表
	 * @param basMsgVo
	 * @return PageInfoExtend<BasMsg>
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-15 16:35:27
	 */
	PageInfoExtend<BasMsgVo> findBasMsgByPage(BasMsgVo basMsgVo);

	/**
	 * @Title:
	 * @Description: 保存短信发送管理表
	 * @param basMsgSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-15 16:35:27
	 */
    void saveBasMsg(BasMsgSaveVo basMsgSaveVo);


	/**
	 * @Title:
	 * @Description: 修改短信发送管理表
	 * @param basMsgModifyVo
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-15 16:35:27
	 */
	void modifyBasMsg(BasMsgModifyVo basMsgModifyVo);

	/**
	 * @Title:
	 * @Description:  通过msgId删除短信发送管理表
	 * @param basMsgDeleteVo
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-15 16:35:27
	 */
	void deleteBasMsg(BasMsgDeleteVo basMsgDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过msgId集合删除短信发送管理表
	 * @param basMsgDeleteListVo
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-15 16:35:27
	 */
	void deleteBasMsgsByMsgIds(BasMsgDeleteListVo basMsgDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据msgId获取短信发送管理表
	 * @param msgId
	 * @return BasMsg
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-15 16:35:27
	 */
	BasMsg findBasMsgByMsgId(String msgId);

	/**
	 * @Title:
	 * @Description:  通过msg_id关联sys_tpl_type表查询bas_msg表（详情界面）
	 * @param msgId
	 * @return BasMsg
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-15 16:35:27
	 */
	public  BasMsgVo findBasMsgVoFromSysTplTypeVoByMsgId(String msgId);

}
