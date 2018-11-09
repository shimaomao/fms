package cn.com.leadu.fms.pojo.baseinfo.vo.basarea;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasArea;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author niehaibing
 * @ClassName: BasAreaVo
 * @Description: 省市县信息维护载体
 * @date 2018-03-15
 */
@Data
public class BasAreaTreeVo extends PageQuery<BasArea> {

	private static final long serialVersionUID = 1L;
	//省份list
	private List<BasArea> provinceList;
	//城市list
	private Map<String,List<BasArea>> cityMapList;
    //区县list
	private Map<String,List<BasArea>> areaMapList;

	private Map<String,String> areaMap;

}