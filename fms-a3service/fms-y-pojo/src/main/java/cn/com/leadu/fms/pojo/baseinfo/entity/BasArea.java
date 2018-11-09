package cn.com.leadu.fms.pojo.baseinfo.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author niehaibing
 * @ClassName: BasAreaDao
 * @Description: 省市县信息维护实体
 * @date 2018-03-15
 */
@Data
public class BasArea extends BaseEntity<BasArea> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 区域ID
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String areaId;

	/**
	 * @Fields  : 区域代码
	 */
	private String areaCode;

	/**
	 * @Fields  : 区域名称
	 */
	private String areaName;

	/**
	 * @Fields  : 区域级别
	 */
	private String areaLevel;

	/**
	 * @Fields  : 父区域代码
	 */
	private String parentAreaCode;

}