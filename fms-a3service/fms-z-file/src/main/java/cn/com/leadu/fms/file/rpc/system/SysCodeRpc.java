package cn.com.leadu.fms.file.rpc.system;

import cn.com.leadu.fms.common.vo.CommonCodeVo;
import cn.com.leadu.fms.extend.response.RestResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: SysCodeRpc
 * @Description: 数据字典rpc
 * @date 2018/4/20
 */
@FeignClient(name = "${fms.feigns.serverNames.fmsSystem}")
public interface SysCodeRpc {

    /**
     * @Title:
     * @Description:   获取所有数据字典,key以codeType_codeValue拼接
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/27 04:16:54
     */
    @RequestMapping(value = "sys_code/findCommonCodeValues", method = RequestMethod.GET)
    ResponseEntity<RestResponse<Map<String,CommonCodeVo>>> findCommonCodeValues();

    /**
     * @Title:
     * @Description:   获取所有的数据字典,key为codeType,值为该codeType下的集合
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/27 03:53:30
     */
    @RequestMapping(value = "sys_code/findCommonCodeValuesTree", method = RequestMethod.GET)
    ResponseEntity<RestResponse<Map<String,List<CommonCodeVo>>>> findCommonCodeValuesTree();

}
