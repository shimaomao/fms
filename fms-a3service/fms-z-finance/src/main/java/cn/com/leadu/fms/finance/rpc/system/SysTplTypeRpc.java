package cn.com.leadu.fms.finance.rpc.system;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.system.entity.SysTplType;
import cn.com.leadu.fms.pojo.system.vo.systpltype.SysTplTypeVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author
 * @ClassName: SysTplRpc
 * @Description: 模板管理rpc
 * @date 2018-03-12
 */
@FeignClient("${fms.feigns.serverNames.fmsSystem}")
public interface SysTplTypeRpc {
    /**
     * @Title:
     * @Description:  根据tplTypeKey获取模板管理
     * @param sysTplTypeVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-12 15:16:19
     */
    @RequestMapping(value = "sys_tpl_type/findSysTplTypeListByBasFileTypeList", method = RequestMethod.POST)
    ResponseEntity<RestResponse<List<SysTplType>>> findSysTplTypeListByBasFileTypeList(@RequestBody SysTplTypeVo sysTplTypeVo);

}
