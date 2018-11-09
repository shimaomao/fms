package cn.com.leadu.fms.pojo.postbiz.vo.capitalasstes;

import lombok.Data;

/**
 * @author wangxue
 * @ClassName: VehicleDisposalVo
 * @Description: 转固定资产载体
 */
@Data
public class CapitalAssetsVo {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields : 工作流任务id
	 * @author wangxue
	 */
	private String taskId;

	/**
	 * @Fields  : 合同编号
	 * @author wangxue
	 */
	private String contNo;

	/**
	 * @Fields  : 转固定资产任务号
	 * @author wangxue
	 */
	private String capitalTaskNo;

    /**
     * @Fields  : 说明或备注
     * @author wangxue
     */
    private String remark;


}