package cn.com.leadu.fms.original.service;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.pojo.original.entity.OrigFile;
import cn.com.leadu.fms.pojo.original.vo.origfile.OrigFileSortVo;
import cn.com.leadu.fms.pojo.original.vo.origfile.OrigFileVo;
import cn.com.leadu.fms.pojo.original.vo.origfiledetail.OrigFileDetailVo;
import cn.com.leadu.fms.pojo.original.vo.origfiledetail.OrigFileMailVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.original.validator.origfile.vo.OrigFileSaveVo;
import cn.com.leadu.fms.original.validator.origfile.vo.OrigFileModifyVo;
import cn.com.leadu.fms.original.validator.origfile.vo.OrigFileDeleteVo;
import cn.com.leadu.fms.original.validator.origfile.vo.OrigFileDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.system.vo.sysuser.SysUserVo;

import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: OrigFileService
 * @Description: 资料邮寄附件业务层
 * @date 2018-05-03
 */
public interface OrigFileService {

	/**
	 * @Title:
	 * @Description: 分页查询资料邮寄附件
	 * @param origFileVo
	 * @return PageInfoExtend<OrigFile>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-3 14:16:47
	 */
	PageInfoExtend<OrigFileVo> findOrigFilesByPage(OrigFileVo origFileVo, @AuthUserInfo SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 分页查询资料邮寄附件
	 * @param origFileVo
	 * @return PageInfoExtend<OrigFile>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-3 14:16:47
	 */
	OrigFileVo findOrigFileInfoByBizCodeAndBizCodeType(OrigFileVo origFileVo, @AuthUserInfo SysUser sysUser);
	/**
	 * @Title:
	 * @Description: 分页查询贷前原件归档
	 * @param origFileVo
	 * @return PageInfoExtend<OrigFileVo>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 14:16:47
	 */
	PageInfoExtend<OrigFileVo> findOrigFileListByPage(OrigFileVo origFileVo,SysUserVo sysUser);

    PageInfoExtend<OrigFileVo> findOrigFileInsListByPage(OrigFileVo origFileVo);

    /**
	 * @Title:
	 * @Description: 分页查询资料邮寄附件(原件归档)
	 * @param origFileVo
	 * @return PageInfoExtend<OrigFile>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 14:16:47
	 */
	PageInfoExtend<OrigFileVo> findOrigFilesByOrigFileStatus(OrigFileVo origFileVo);

    /**
	 * @Title:
	 * @Description: 分页查询资料邮寄附件(原件借阅)
	 * @param origFileVo
	 * @return PageInfoExtend<OrigFile>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 14:16:47
	 */
	PageInfoExtend<OrigFileVo> findBorrowOrigFilesByOrigFileStatus(OrigFileVo origFileVo);

    /**
	 * @Title:
	 * @Description: 分页查询资料邮寄附件(续保归档)
	 * @param origFileVo
	 * @return PageInfoExtend<OrigFile>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 14:16:47
	 */
	PageInfoExtend<OrigFileVo> findRenewalOrigFilesByOrigFileStatus(OrigFileVo origFileVo);

    /**
	 * @Title:
	 * @Description: 分页查询资料邮寄附件(贷前归档邮寄与上传)
	 * @param origFileVo
	 * @return PageInfoExtend<OrigFile>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 14:16:47
	 */
	PageInfoExtend<OrigFileVo> findPreOrigFilesByOrigFileStatus(OrigFileVo origFileVo,SysUserVo sysUser);

	/**
	 * @Title:
	 * @Description: 获取邮寄附件明细表信息（资料邮寄用）
	 * @param origFileVo
	 * @return List<OrigFileDetailVo>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 14:16:47
	 */
	List<OrigFileDetailVo> findOrigFileMailList(OrigFileVo origFileVo);

	/**
	 * @Title:
	 * @Description: 保存资料邮寄附件
	 * @param origFileSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-3 14:16:47
	 */
    void saveOrigFile(OrigFileSaveVo origFileSaveVo);

	/**
	 * @Title:
	 * @Description: 文件归档暂存
	 * @param origFileSortVo
	 * @return java.lang.String
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 14:16:47
	 */
    void temporarySave(OrigFileSortVo origFileSortVo);

	/**
	 * @Title:
	 * @Description: 确认收到
	 * @param origFileSortVo
	 * @return java.lang.String
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 14:16:47
	 */
    void ReceivedConfirm(OrigFileSortVo origFileSortVo);

	/**
	 * @Title:
	 * @Description: 归档
	 * @param origFileSortVo
	 * @return java.lang.String
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 14:16:47
	 */
    void origFileSort(OrigFileSortVo origFileSortVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 归档审核
	 * @param origFileSortVo
	 * @param sysUser
	 * @return java.lang.String
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 14:16:47
	 */
    void origFileSortExamine(OrigFileSortVo origFileSortVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 确认邮寄
	 * @param origFileMailVo
	 * @param sysUser
	 * @return java.lang.String
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 14:16:47
	 */
    void mailConfirm(OrigFileMailVo origFileMailVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 资料上传
	 * @param origFileMailVo
	 * @param sysUser
	 * @return java.lang.String
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 14:16:47
	 */
    void origFileUpload(OrigFileMailVo origFileMailVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 保单归档确认
	 * @param origFileSortVo
	 * @return java.lang.String
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 14:16:47
	 */
    void renewalSortConfirm(OrigFileSortVo origFileSortVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 归档审核退回
	 * @param origFileSortVo
	 * @param sysUser
	 * @return java.lang.String
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 14:16:47
	 */
    void origFileSortExamineBack(OrigFileSortVo origFileSortVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 修改资料邮寄附件
	 * @param origFileModifyVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-3 14:16:47
	 */
	void modifyOrigFile(OrigFileModifyVo origFileModifyVo);

	/**
	 * @Title:
	 * @Description:  通过origFileId删除资料邮寄附件
	 * @param origFileDeleteVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-3 14:16:47
	 */
	void deleteOrigFile(OrigFileDeleteVo origFileDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过origFileId集合删除资料邮寄附件
	 * @param origFileDeleteListVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-3 14:16:47
	 */
	void deleteOrigFilesByOrigFileIds(OrigFileDeleteListVo origFileDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据origFileId获取资料邮寄附件
	 * @param origFileId
	 * @return OrigFile
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-3 14:16:47
	 */
	OrigFile findOrigFileByOrigFileId(String origFileId);

	/**
	 * @Title:
	 * @Description:  确定归档
	 * @param origFileVo
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 14:16:47
	 */
	void confirmFile(OrigFileVo origFileVo);

	/**
	 * @Title:
	 * @Description:  退回
	 * @param origFileVo
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 14:16:47
	 */
	void cancelFile(OrigFileVo origFileVo);

	/**
	 * @Title:
	 * @Description:  归档完成确认
	 * @param origFileVo
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 14:16:47
	 */
	void fileFinishedConfirm(OrigFileVo origFileVo);

	/**
	 * @Title:
	 * @Description:  归档明细
	 * @param origFileVo
	 * @return PageInfoExtend<OrigFileVo>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-11 14:16:47
	 */
	 PageInfoExtend<OrigFileVo> findOrigArchiveDetailByPage(OrigFileVo origFileVo);

	/**
	 * @Title:
	 * @Description:  获取贷前归档明细一览画面数据
	 * @param origFileDetailVo
	 * @return OrigFileSortVo
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-11 14:16:47
	 */
	OrigFileSortVo findOrigFileSortDetailsByPage(OrigFileDetailVo origFileDetailVo);

	/**
	 * @Title:
	 * @Description:  获取贷前归档明细一览画面数据（资管复核）
	 * @param origFileDetailVo
	 * @return OrigFileSortVo
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-11 14:16:47
	 */
	OrigFileSortVo findOrigFileSortDetailsExamineByPage(OrigFileDetailVo origFileDetailVo);

	/**
	 * @Title:
	 * @Description:  获取保单归档明细一览画面数据
	 * @param origFileDetailVo
	 * @return OrigFileSortVo
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-11 14:16:47
	 */
	OrigFileSortVo selectOrigFileRenewalSortDetailsByPage(OrigFileDetailVo origFileDetailVo);

	/**
	 * @Title:
	 * @Description: 查询融保险资料邮寄附件信息
	 * @param
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-3 14:16:46
	 */
	List<OrigFileVo> findOrigFileVos();

	/**
	 * @Title:
	 * @Description: 查询邮寄文件信息
	 * @param
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-27 14:16:46
	 */
	OrigFile findOrigFileByContNo(String contNo);

	/**
	 * @Title:
	 * @Description: 续保归档附件上传
	 * @param origFileSortVo
	 * @return java.lang.String
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-3 14:16:47
	 */
	void uploadRenewalFile(OrigFileSortVo origFileSortVo);

}
