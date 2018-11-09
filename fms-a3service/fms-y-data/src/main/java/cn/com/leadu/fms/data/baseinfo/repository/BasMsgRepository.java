package cn.com.leadu.fms.data.baseinfo.repository;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasMsg;
import cn.com.leadu.fms.pojo.baseinfo.vo.basmsg.BasMsgVo;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: BasMsgRepository
 * @Description: 短信发送管理表Repository层
 * @date 2018-03-15
 */
public interface BasMsgRepository {

	/**
	 * @Title:
	 * @Description: 新增短信发送管理表
	 * @param basMsg
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-15 16:35:27
	 */
	int insertData(BasMsg basMsg);

	/**
	 * @Title:
	 * @Description: 批量保存短信发送管理表
	 * @param basMsgs
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-15 16:35:27
	 */
	int insertDataList(List<BasMsg> basMsgs);

	/**
	 * @Title:
	 * @Description: 修改短信发送管理表
	 * @param basMsg
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-15 16:35:27
	 */
	int updateByPrimaryKeyData(BasMsg basMsg);

	/**
	 * @Title:
	 * @Description: 批量修改短信发送管理表
	 * @param basMsgs
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-15 16:35:27
	 */
	int updateByPrimaryKeyDataList(List<BasMsg> basMsgs);

	/**
	 * @Title:
	 * @Description: 动态修改短信发送管理表
	 * @param basMsg
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-15 16:35:27
	 */
	int updateByPrimaryKeySelectiveData(BasMsg basMsg);

	/**
	 * @Title:
	 * @Description: 批量动态修改短信发送管理表
	 * @param basMsgs
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-15 16:35:27
	 */
	int updateByPrimaryKeySelectiveDataList(List<BasMsg> basMsgs);

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
	int updateByExampleData(BasMsg basMsg, Example example);

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
	int updateByExampleSelectiveData(BasMsg basMsg, Example example);

	/**
	 * @Title:
	 * @Description: 根据msgId删除短信发送管理表
	 * @param basMsg
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-15 16:35:27
	 */
	int deleteData(BasMsg basMsg);

	/**
	 * @Title:
	 * @Description: 根据msgId集合批量删除短信发送管理表
	 * @param msgIds
	 * @param basMsg
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-15 16:35:27
	 */
	int deleteDataList(List msgIds, BasMsg basMsg);

	/**
	 * @Title:
	 * @Description: 查询全部短信发送管理表
	 * @return List<BasMsg>
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-15 16:35:27
	 */
	List<BasMsg> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个短信发送管理表
	 * @param example
	 * @return BasMsg
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-15 16:35:27
	 */
	BasMsg selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询短信发送管理表
	 * @param example
	 * @return List<BasMsg>
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-15 16:35:27
	 */
	List<BasMsg> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过msgId查询短信发送管理表
	 * @param msgId
	 * @return BasMsg
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-15 16:35:27
	 */
	BasMsg selectByPrimaryKey(Object msgId);

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
	PageInfoExtend<BasMsg> selectListByExamplePage(Example example, PageQuery pageQuery);

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
	PageInfoExtend<BasMsgVo> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 通过msg_id关联sys_tpl_type表查询bas_msg表（详情界面）
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-26 13:51:12
	 */
	BasMsgVo selectBasMsgVoFromSysTplTypeVoByMsgId(Object msgId);

}
