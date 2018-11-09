package cn.com.leadu.fms.postbiz.service;

import cn.com.leadu.fms.common.vo.FileVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.postbiz.vo.collectiontask.CollectionTaskVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.CollectionLetterVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.OverdueCstmVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;

import java.util.List;

/**
 * @author lijunjun
 * @ClassName: CollectionTaskService
 * @Description: 催收任务业务层
 */
public interface CollectionTaskService {

	/**
	 * @Title:
	 * @Description: 分页查询催收任务
	 * @param collectionTaskVo
	 * @return PageInfoExtend<CollectionTask>
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 17:46:36
	 */
	PageInfoExtend<CollectionTaskVo> findCollectionTasksByPage(CollectionTaskVo collectionTaskVo);

	/**
	 * @Title:
	 * @Description: 保存催收任务
	 * @param collectionTaskVo
	 * @param sysUser
	 * @return java.lang.String
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 17:46:36
	 */
    void saveCollectionTask(CollectionTaskVo collectionTaskVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description:  获取承租人逾期信息
	 * @param overdueCstmVo
	 * @return PageInfoExtend<OverdueCstmVo>
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 17:46:36
	 */
	PageInfoExtend<OverdueCstmVo> findCstmInfosByPage(OverdueCstmVo overdueCstmVo);

	/**
	 * 根据overdueCstmId获取客户地址信息
	 * @param overdueCstmId
	 * @return
	 */
	CollectionTaskVo findCstmAddrInfosByOverdueCstmId(String overdueCstmId);

	/**
	 * 根据collectionTaskNo获取上门催收任务信息
	 * @param collectionTaskNo
	 * @return
	 */
	CollectionTaskVo findCollectionTasksByTaskNo(String collectionTaskNo);

	/**
	 * 上门催收同意
	 * @param collectionTaskVo
	 * @param sysUser
	 * @return
	 */
	void collectionApprovalAgree(CollectionTaskVo collectionTaskVo, SysUser sysUser);

	/**
	 * 上门催收派单提交
	 * @param collectionTaskVo
	 * @param sysUser
	 * @return
	 */
	void collectionDispatchAgree(CollectionTaskVo collectionTaskVo, SysUser sysUser);

	/**
	 * 上门催收拒绝
	 * @param collectionTaskVo
	 * @param sysUser
	 * @return
	 */
	void collectionRefuse(CollectionTaskVo collectionTaskVo, SysUser sysUser);

	/**
	 * 上门催收审核通过
	 * @param collectionTaskVo
	 * @param sysUser
	 * @return
	 */
	void collectionAgree(CollectionTaskVo collectionTaskVo, SysUser sysUser);

	/**
	 * 上门催收审核退回
	 * @param collectionTaskVo
	 * @param sysUser
	 * @return
	 */
	void collectionBack(CollectionTaskVo collectionTaskVo, SysUser sysUser);

	/**
	 * 上门催收登记暂存
	 * @param collectionTaskVo
	 * @param sysUser
	 * @return
	 */
	void collectionRegisterTemporary(CollectionTaskVo collectionTaskVo, SysUser sysUser);

	/**
	 * 校验是否存在未完成的任务
	 * @param overdueCstmId
	 * @return
	 */
	String isCollectionTaskExit(String overdueCstmId);

	/**
	 * @Title:
	 * @Description: 催收函下载
	 * @param collectionTaskNo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 17:46:35
	 */
	FileVo collectionLetterDownload(String collectionTaskNo);

	/**
	 * @Title:
	 * @Description: 委托书下载
	 * @param collectionTaskNo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 17:46:35
	 */
	FileVo proxyDownload(String collectionTaskNo);

	/**
	 * 律师函下载
	 * @param collectionTaskNo
	 * @return
	 */
	FileVo lawyerLetterDownload(String collectionTaskNo);

	/**
	 * 构建需要生成的文件List
	 * @param collectionLetterVoList
	 * @param files
	 */
	String getFiles(List<CollectionLetterVo> collectionLetterVoList, List<FileVo> files);

}
