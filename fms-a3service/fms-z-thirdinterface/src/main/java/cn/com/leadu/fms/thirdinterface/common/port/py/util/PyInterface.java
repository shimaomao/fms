package cn.com.leadu.fms.thirdinterface.common.port.py.util;

import cn.com.leadu.fms.common.constant.CommonPropertyConstants;
import cn.com.leadu.fms.common.constant.PyConfigConstants;
import cn.com.leadu.fms.common.constant.enums.file.FileTypePathEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.*;
import cn.com.leadu.fms.thirdinterface.common.port.py.bean.QueryCondition;
import cn.com.leadu.fms.thirdinterface.common.port.py.bean.QueryConditions;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author 杨刚
 * @ClassName: PyInterface
 * @Description: 鹏远征信
 * @date 2018-06-7
 */
@Slf4j
@Component
public class PyInterface {

    public Map<String, String> requestUnzipApi(Object obj) throws Exception {
        Map<String, String> resultMap = requestApi(PyConfigConstants.config.getUrl(), PyConfigConstants.config.getPathUnzip(), convertToMap(obj));
        if(resultMap != null)
            LogUtils.infoLine(log,"鹏元接口返回信息：" + JSON.toJSONString(resultMap));
        return resultMap;
    }
    public Map<String, String> requestApi(String host, String path,Map<String, Object> map) throws Exception {
        // https双向认证使用,配合PySSLContextUtil中的DefaultSSLContext
//        System.setProperty("javax.net.debug", "all");
//        System.setProperty("javax.net.ssl.keyStore", PyConfig.KEYSTORE_FILE);
//        System.setProperty("javax.net.ssl.keyStorePassword", PyConfig.KEYSTORE_PASSWORD);
//        System.setProperty("javax.net.ssl.trustStore", PyConfig.TRUSTSTORE_FILE);
//        System.setProperty("javax.net.ssl.trustStorePassword", PyConfig.TRUSTSTORE_PASSWORD);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String getQueryCondition=getQueryCondition(map);
        Map<String, String> headers = new HashMap<String, String>();
        Map<String, String> querys = null;
        Map<String, String> bodys = new HashMap<String, String>();
        bodys.put("userID", PyConfigConstants.config.getUserId());
        bodys.put("password", PyConfigConstants.config.getPassWord());
        bodys.put("queryCondition", getQueryCondition);
        HttpResponse response = HttpUtils.doPost(host, path, "POST", headers, querys, bodys);
        String result = EntityUtils.toString(response.getEntity());
        //保存json到本地
        String filePath= CommonFileUtils.joinFilePath(CommonFileUtils.getFileRootPath(), FileTypePathEnums.PY_FILES.getType(),DateUtils.dateToStr(new Date(),DateUtils.formatStr_yyyyMMd_NO));//附件下载路径
        String fileNameConditionsXml = (map.get("refID")+"_"+map.get("subreportIDs")+"_"+ sdf.format(new Date())+"_conditionsXml").replace(StringUtils.COMMA, "") + TxtUtils.TXT_SUFFIX;//接口请求附件名称
        String fileNameCisReportsXml = (map.get("refID")+"_"+map.get("subreportIDs")+"_"+ sdf.format(new Date())+"_cisReportsXml").replace(StringUtils.COMMA, "") + TxtUtils.TXT_SUFFIX;//接口返回附件名称
        //保存接口请求json
        saveDataToFile(filePath,fileNameConditionsXml,getQueryCondition);
        //保存接口返回json
        saveDataToFile(filePath,fileNameCisReportsXml,result);
        Map<String, String> resultMap = new HashMap<>();
        if(StringUtils.isTrimBlank(result)){
            throw new FmsServiceException("未获取到鹏远接口返回数据数据");
        }
        resultMap.put(CommonPropertyConstants.RESULT, result);
        if(StringUtils.isNotTrimBlank(fileNameConditionsXml))
            resultMap.put(CommonPropertyConstants.CONDITIONS_XML, CommonFileUtils.joinFilePath(filePath,fileNameConditionsXml));
        if(StringUtils.isNotTrimBlank(fileNameCisReportsXml))
            resultMap.put(CommonPropertyConstants.CIS_REPORTS_XML, CommonFileUtils.joinFilePath(filePath,fileNameCisReportsXml));
        return resultMap;
    }
    /**生成本地文件
     * FilePath 文件路径
     * fileName 文件名称
     * data 文件内容
    */
    public void saveDataToFile(String filePath,String fileName,String data) {
        if(StringUtils.isNotTrimBlank(filePath,fileName,data)) {
            fileName = fileName.replace(StringUtils.COMMA, "");
            CommonFileUtils.writeFile(filePath, fileName, data);
        }
    }

    private String getQueryCondition(Map<String, Object> map) throws Exception {
        QueryConditions queryConditions = new QueryConditions();
        List<QueryCondition> conditions = new ArrayList<QueryCondition>();
        QueryCondition queryCondition = new QueryCondition();
        queryCondition.setQueryType(map.get("queryType")+"");//查询类型   互联网客户
        // 查询类型
        List<QueryCondition.Item> items = new ArrayList<QueryCondition.Item>();
        // 查询原因
        items.add(new QueryCondition.Item("queryReasonID", PyConfigConstants.config.getQueryReasonID()));//贷款审批查询原因ID
        // 具体查询条件
        for(String key : map.keySet()){
            items.add(new QueryCondition.Item(key, map.get(key)+""));
        }
        queryCondition.setItems(items);
        conditions.add(queryCondition);
        queryConditions.setConditions(conditions);
        return JSON.toJSONString(queryConditions);
    }

    //将对象转化为map
    public Map<String, Object> convertToMap(Object obj)
            throws Exception {
        Map<String,Object> map = JSON.parseObject(JSON.toJSONString(obj)) ;
        return map;
    }
}