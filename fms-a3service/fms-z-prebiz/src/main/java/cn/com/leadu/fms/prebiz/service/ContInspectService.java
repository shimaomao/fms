package cn.com.leadu.fms.prebiz.service;

import cn.com.leadu.fms.pojo.prebiz.vo.continspect.ContInspectVo;

/**
 * @author liujinge
 * @ClassName: ContInspectService
 * @Description: 合同文件核查
 * @date 2018-03-23
 */
public interface ContInspectService {

	/**
	 * @Title:
	 * @Description: 合同生成前确认
	 * @param contInspectVo
	 * @return java.lang.String
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:48:00
	 */
    void approval(ContInspectVo contInspectVo);

	void sendBack(ContInspectVo contInspectVo);

	void sendBackTop(ContInspectVo contInspectVo);
}
