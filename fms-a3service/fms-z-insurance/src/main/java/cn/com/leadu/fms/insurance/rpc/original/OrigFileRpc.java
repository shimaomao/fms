package cn.com.leadu.fms.insurance.rpc.original;/**
 * Created by ningyangyang on 2018/6/15.
 */

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.original.entity.OrigFile;
import cn.com.leadu.fms.pojo.original.vo.origfile.OrigFileVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Title: fms
 * @Description:  归档信息
 * @author: ningyangyang
 * @date 2018/6/15 14:48
 */
@FeignClient("${fms.feigns.serverNames.fmsOriginal}")
public interface OrigFileRpc {

    /**
     * @Title:
     * @Description: 取得融保险的归档信息
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-4-12 13:35:32
     */
    @RequestMapping(value = "orig_file/findOrigFileVos", method = RequestMethod.GET)
    ResponseEntity<RestResponse<List<OrigFileVo>>> findOrigFileVos();

    /**
     * @Title:
     * @Description: 取得原件归档信息
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-27 13:35:32
     */
    @RequestMapping(value = "orig_file/findOrigFileByContNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse<OrigFile>> findOrigFileByContNo(@RequestParam("contNo") String contNo);
}
