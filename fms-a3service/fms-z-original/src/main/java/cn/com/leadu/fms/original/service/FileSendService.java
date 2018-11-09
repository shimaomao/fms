package cn.com.leadu.fms.original.service;

import cn.com.leadu.fms.pojo.original.entity.FileSend;
import cn.com.leadu.fms.pojo.original.vo.filesend.FileSendVo;
import cn.com.leadu.fms.original.validator.filesend.vo.FileSendSaveVo;
import cn.com.leadu.fms.original.validator.filesend.vo.FileSendModifyVo;
import cn.com.leadu.fms.original.validator.filesend.vo.FileSendDeleteVo;
import cn.com.leadu.fms.original.validator.filesend.vo.FileSendDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author ningyangyang
 * @ClassName: FileSendService
 * @Description: 资料邮寄业务层
 * @date 2018-05-04
 */
public interface FileSendService {

	/**
	 * @Title:
	 * @Description: 分页查询资料邮寄
	 * @param fileSendVo
	 * @return PageInfoExtend<FileSend>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-4 16:51:03
	 */
	PageInfoExtend<FileSend> findFileSendsByPage(FileSendVo fileSendVo);

	/**
	 * @Title:
	 * @Description: 保存资料邮寄
	 * @param fileSendSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-4 16:51:03
	 */
    void saveFileSend(FileSendSaveVo fileSendSaveVo);


	/**
	 * @Title:
	 * @Description: 修改资料邮寄
	 * @param fileSendModifyVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-4 16:51:03
	 */
	void modifyFileSend(FileSendModifyVo fileSendModifyVo);

	/**
	 * @Title:
	 * @Description:  通过filePostId删除资料邮寄
	 * @param fileSendDeleteVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-4 16:51:03
	 */
	void deleteFileSend(FileSendDeleteVo fileSendDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过filePostId集合删除资料邮寄
	 * @param fileSendDeleteListVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-4 16:51:03
	 */
	void deleteFileSendsByFilePostIds(FileSendDeleteListVo fileSendDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据filePostId获取资料邮寄
	 * @param filePostId
	 * @return FileSend
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-4 16:51:03
	 */
	FileSend findFileSendByFilePostId(String filePostId);

}
