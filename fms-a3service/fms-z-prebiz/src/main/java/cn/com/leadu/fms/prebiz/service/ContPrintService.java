package cn.com.leadu.fms.prebiz.service;

import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contprint.ContPrintVo;


/**
 * @author liujinge
 * @ClassName: ContInspectService
 * @Description: 合同文件核查
 * @date 2018-03-23
 */
public interface ContPrintService {

	/**
	 * @Title:
	 * @Description: 合同生成前确认
	 * @param contPrintVo
	 * @return java.lang.String
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:48:00
	 */
    void print(ContPrintVo contPrintVo);
	/**
	 * @Title:
	 * @Description: 获取合同打印附件列表
	 * @param contNo
	 * @return List<BizFilesListVo>
	 * @throws
	 * @author lijunjun
	 * @date 2018-3-23 18:48:00
	 */
	CommonBizFilesVo getContPrintFileList(String contNo);

	void sendBack(ContPrintVo contPrintVo);
}
