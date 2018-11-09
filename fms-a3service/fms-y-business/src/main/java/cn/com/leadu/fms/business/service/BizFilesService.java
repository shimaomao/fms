package cn.com.leadu.fms.business.service;

import cn.com.leadu.fms.common.vo.FileVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.BizFilesListVo;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.BizFilesVo;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;

import java.util.List;

/**
 * @author huchenghao
 * @ClassName: BizFilesService
 * @Description: 附件信息业务层
 * @date 2018-04-09
 */
public interface BizFilesService {

	/**
	 * @Title:
	 * @Description: 分页查询附件信息
	 * @param bizFilesVo
	 * @return PageInfoExtend<BizFiles>
	 * @throws
	 * @author huchenghao
	 * @date 2018-4-9 14:55:49
	 */
	PageInfoExtend<BizFiles> findBizFilessByPage(BizFilesVo bizFilesVo);

	/**
	 * @Title:
	 * @Description: 根据bizCode和bizCodeType获取附件信息
	 * @param bizFilesVo
	 * @return CommonBizFilesVo
	 * @throws
	 * @author huchenghao
	 * @date 2018-4-9 14:55:49
	 */
	CommonBizFilesVo findBizFilesByBizInfo(BizFilesVo bizFilesVo);

	/**
	 * @Title:
	 * @Description: 保存附件信息
	 * @param bizFiles
	 * @return java.lang.String
	 * @throws
	 * @author huchenghao
	 * @date 2018-4-9 14:55:49
	 */
	void saveBizFilesByEntity(BizFiles bizFiles);

	/**
	 * @Title:
	 * @Description: 保存附件信息
	 * @param bizFilesList
	 * @return java.lang.String
	 * @throws
	 * @author huchenghao
	 * @date 2018-4-9 14:55:49
	 */
	void saveBizFilesList(List<BizFiles> bizFilesList);

	/**
	 * @Description: 根据所属业务代码和类型删除附件信息
	 * @param:
	 * @return:
	 * @Author: yangyiquan
	 * @Date: 2018/5/8 21:45
	 */
	void deleteBizFilesByBizCode(String bizCode,String bizCodeType);
	
	/** 
	* @Description: 根据所属业务代码和类型，附件类型删除附件信息
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/6/30 14:16
	*/ 
	void deleteBizFilesByBizCodeAndTypeAndFileType(String bizCode,String bizCodeType,String fileType);

	/**
	 * @Title:
	 * @Description:  根据fileId获取附件信息
	 * @param fileId
	 * @return BizFiles
	 * @throws
	 * @author huchenghao
	 * @date 2018-4-9 14:55:49
	 */
	BizFiles findBizFilesByFileId(String fileId);

	/**
	 * @Title:
	 * @Description: 根据业务编码和业务类型返回文件list
	 * @param: bizCode     业务编码
	 * @param: bizCodeType 业务类型
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/7/14 0014 9:54
	 */
	List<BizFiles> findBizFilesList(String bizCode, String bizCodeType);

	/**
	 * @Title:
	 * @Description:  根据业务代码取得附件信息
	 * @param bizCode
	 * @return BizFiles
	 * @throws
	 * @author huchenghao
	 * @date 2018-4-9 14:55:49
	 */
	CommonBizFilesVo findBizFilesByBizCode(String bizCode, String bizCodeType);

	/**
	 * @Title:
	 * @Description: 保存业务附件
	 * @param bizFilesListVos  附件信息
	 * @param bizCode   所属业务代码
	 * @param bizCoeType 代码类型
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/04/11 02:37:08
	 */
	List<BizFiles> saveBizFiles(List<BizFilesListVo> bizFilesListVos, String bizCode, String bizCoeType);
	/**
	 * @description: 更新业务附件
	 * @param bizFilesListVos
	 * @param bizCode
	 * @author ningyangyang
	 * @param bizCoeType
	 */
	void updateBizFiles(List<BizFilesListVo> bizFilesListVos, String bizCode, String bizCoeType);

	/**
	 * @Title:
	 * @Description: 根据业务编码和业务类型更新附件信息
	 * @param: bizFilesList 附件集合
	 * @param: bizCode  业务编码
	 * @param: bizCodeType 业务类型
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/7/18 0018 18:22
	 */
	void modifyBizFilesList(List<BizFiles> bizFilesList, String bizCode, String bizCodeType);

	/**
	 * @Title:
	 * @Description:   fileVos转换成bizFilesList
	 * @param fileVos
	 * @param bizCode
	 * @param bizCodeType
	 * @param fileType
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/06/06 06:08:42
	 */
	List<BizFiles> getBizFilesList(List<FileVo> fileVos, String bizCode, String bizCodeType, String fileType);

	/**
	 * @Title:
	 * @Description:   bizFilesList转换为fileVos
	 * @param bizFilesList
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/06/08 03:00:43
	 */
	List<FileVo> getFileVos(List<BizFiles> bizFilesList);

	/**
	 * @Title:
	 * @Description:   根据业务信息查询file集合
	 * @param bizCode
	 * @param bizCodeType
	 * @param fileType
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/06/08 02:47:57
	 */
	List<BizFiles> findBizFilesByBizInfo(String bizCode,String bizCodeType,String fileType);


	/**
	 * @Title:
	 * @Description:  根据业务id 业务类型 文件类型删除附件
	 * @param bizCodes
	 * @param bizCodeType
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/06/12 03:14:10
	 */
	void deleteBizFilesList(List<String> bizCodes,String bizCodeType);

	/**
	 * @Title:
	 * @Description:   返回业务附件集合
	 * @param bizFilesListVos
	 * @param bizCode
	 * @param bizCoeType
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/06/21 11:20:42
	 */
	List<BizFiles> getBizFiles(List<BizFilesListVo> bizFilesListVos , String bizCode, String bizCoeType);

	/**
	 * @Title:
	 * @Description:   返回业务附件集合
	 * @param bizFilesVos
	 * @param bizCode
	 * @param bizCoeType
	 * @param notKeepID
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/06/21 11:20:42
	 */
	public List<BizFiles> geBizFilesListByVos(List<BizFilesVo> bizFilesVos , String bizCode, String bizCoeType,boolean notKeepID);

}
