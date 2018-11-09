package cn.com.leadu.fms.thirdinterface.service.impl;

import cn.com.leadu.fms.common.constant.PyConfigConstants;
import cn.com.leadu.fms.thirdinterface.common.port.py.*;
import cn.com.leadu.fms.thirdinterface.common.port.py.util.PyInterface;
import cn.com.leadu.fms.thirdinterface.service.PyInterfaceService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author yanggang
 * @ClassName: ApplyInterfaceService
 * @Description: 调用接口
 * @date 2018-6-13 9:18:12
 */
@Service
public class PyInterfaceServiceImpl implements PyInterfaceService {

    @Autowired
    private PyInterface pyInterface;

    /**
     * @Title:
     * @Description: 调用接口
     * @param obj 接口所需要的实体类
     * @return ApplyInputVo
     * @throws
     * @author wangxue
     * @date 2018-6-13 9:18:12
     */
    @Override
    public Map<String, String> requestUnzipApi(Object obj)throws Exception {
        //testMode
        if(PyConfigConstants.config.getTest()){
            Map<String,Object> map = JSON.parseObject(JSON.toJSONString(obj)) ;
            if(map.get("queryType").equals(PyConfigConstants.config.getAddrQueryType())){
                obj = PyAddrInterface.getTestData();
            }
            if(map.get("queryType").equals(PyConfigConstants.config.getAntiQueryType())){
                obj = PyCreditAntiInterface.getTestData();
            }
            if(map.get("queryType").equals(PyConfigConstants.config.getCardCheckQueryType())){
                obj = PyCreditCardCheckInterface.getTestData();
            }
            if(map.get("queryType").equals(PyConfigConstants.config.getCorpBkcheckQueryType())){
                obj = PyCreditCorpBkcheckInterface.getTestData();
            }
            if(map.get("queryType").equals(PyConfigConstants.config.getCorpDebtQueryType())){
                obj = PyCreditCorpDebtInterface.getTestData();
            }
            if(map.get("queryType").equals(PyConfigConstants.config.getCorpRiskQueryType())){
                obj = PyCreditCorpRiskInterface.getTestData();
            }
            if(map.get("queryType").equals(PyConfigConstants.config.getDriverQueryType())){
                obj = PycreditDriverInterface.getTestData();
            }
            if(map.get("queryType").equals(PyConfigConstants.config.getPersonBkCheckQueryType())){
                obj = PyCreditPersonBkcheckInterface.getTestData();
            }

        }
        return pyInterface.requestUnzipApi(obj);
    }
}
