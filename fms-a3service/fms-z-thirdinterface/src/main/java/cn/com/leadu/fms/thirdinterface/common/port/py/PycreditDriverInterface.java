package cn.com.leadu.fms.thirdinterface.common.port.py;

import cn.com.leadu.fms.pojo.thirdinterface.PycreditDriverInterfaceVo;

import java.util.Random;

/**
 * @author 杨刚
 * @ClassName: FraudAnalyze
 * @Description: 鹏远征信 反欺诈分析
 * @date 2018-06-7
 */
public class PycreditDriverInterface {
    public static PycreditDriverInterfaceVo getTestData(){
        String testData [][] = {
                {"测试一","110000199001011112","B2E","1999-07-04","450728823049"},
                {"测试二","110000199001021118","C1","1999-07-04","450728823049"},
                {"测试三","110000199001031113","B2E","1999-07-05","450728823049"},
                {"测试四","110000199001041119","B2E","1999-07-04","450728823048"},
                {"测试五","110000199001051114","B2E","1999-07-04","450728823049"},
                {"测试六","110000199001061128","B2E","1999-07-04","450728823049"},
                {"测试七","110000199001071115","B2E","1999-07-04","450728823049"},
                {"测试八","110000199001081129","B2E","1999-07-04","450728823049"},
                {"测试九","110000199001091116","B2E","1999-07-04","450728823049"},
                {"测试十","11000019900114111x","B2E","1999-07-04","450728823049"}
        };

        PycreditDriverInterfaceVo testVo = new PycreditDriverInterfaceVo();
        Random rand = new Random();
        int index = rand.nextInt(9);
        testVo.setRefID("cs001");//业务流水号(自定义CHAR(30)，可以为空)
        testVo.setName(testData[index][0]);//姓名(可以为空)
        testVo.setDocumentNo(testData[index][1]);//证件号码(可以为空)
        testVo.setCarModels(testData[index][2]);//手机
        testVo.setFirstGetDocDate(testData[index][3]);//地址
        testVo.setArchviesNo(testData[index][4]);//准驾车型
        testVo.setSubreportIDs("14901,14905");//准驾车型
        return testVo;
    }
//	public static void main(String[] args) {
//        try {
//            PycreditDriverInterfaceVo cs= new PycreditDriverInterfaceVo();
//            cs.setRefID("cs001");//业务流水号(自定义CHAR(30)，可以为空)
//            cs.setName("测试一");//姓名
//            cs.setDocumentNo("110000199001011112");//证件号码
//            cs.setCarModels("B2E");//准驾车型
//            cs.setFirstGetDocDate("1999-07-04");//初次领证日期
//            cs.setArchviesNo("450728823049");//准驾车型
//            cs.setSubreportIDs("14901,14902");//准驾车型
//            Map<String, String> resultMap = new PyInterface().requestUnzipApi(cs);
//            JSONObject jsonObject = new JSONObject(resultMap.get(CommonPropertyConstants.RESULT));
//            JSONObject returnValue = jsonObject.optJSONObject("returnValue");
//            JSONArray cisReport = returnValue.optJSONArray("cisReport");
//            for (int i = 0; i < cisReport.length(); i++) {           //解析对象且又嵌套着数组
//                String t = cisReport.getString(i);                   //遍历过程将cisReport数组元素赋给String型变量
//                JSONObject treatResult = new JSONObject(t);          //通过String又得到每个元素的对象
//                if (treatResult.has("driverBaseCheck")) {
//                    JSONObject driverBaseCheck= treatResult.optJSONObject("driverBaseCheck");
//                    System.out.print(driverBaseCheck.getString("treatResult"));        //核查状态
//                    if ("1".equals(driverBaseCheck.getString("treatResult"))) {//如果核查状态为1代表查得才继续插值
//                        JSONObject driverBaseCheck_item= driverBaseCheck.optJSONObject("item");
//                        System.out.print(driverBaseCheck_item.getString("nameCheckResult"));        //姓名核查结果
//                        System.out.print(driverBaseCheck_item.getString("documentNoCheckResult"));        //证件号码核查结果
//                    }
//                }
//                if (treatResult.has("driverLicenseStatusInfo")) {
//                    JSONObject driverLicenseStatusInfo= treatResult.optJSONObject("driverLicenseStatusInfo");
//                    if ("1".equals(driverLicenseStatusInfo.getString("treatResult"))) {//如果核查状态为1代表查得才继续插值
//                        System.out.print(driverLicenseStatusInfo.getString("treatResult"));        //核查状态
//                        System.out.print(driverLicenseStatusInfo.getString("driverLicenseStatusDesc"));        //驾驶证状态
//                    }
//                }
//                if (treatResult.has("driverCarModelsCheck")) {
//                    JSONObject driverCarModelsCheck= treatResult.optJSONObject("driverCarModelsCheck");
//                    if ("1".equals(driverCarModelsCheck.getString("treatResult"))) {//如果核查状态为1代表查得才继续插值
//                        System.out.print(driverCarModelsCheck.getString("treatResult"));        //核查状态
//                        System.out.print(driverCarModelsCheck.getString("checkResult"));        //驾驶证准驾车辆核查
//                    }
//                }
//                if (treatResult.has("driverFirstGetDocNoDateCheck")) {
//                    JSONObject driverFirstGetDocNoDateCheck= treatResult.optJSONObject("driverFirstGetDocNoDateCheck");
//                    if ("1".equals(driverFirstGetDocNoDateCheck.getString("treatResult"))) {//如果核查状态为1代表查得才继续插值
//                        System.out.print(driverFirstGetDocNoDateCheck.getString("treatResult"));        //核查状态
//                        System.out.print(driverFirstGetDocNoDateCheck.getString("checkResult"));        //驾驶证初次领证时间核查
//                    }
//                }
//                if (treatResult.has("driverArchviesNoCheck")) {
//                    JSONObject driverArchviesNoCheck= treatResult.optJSONObject("driverArchviesNoCheck");
//                    if ("1".equals(driverArchviesNoCheck.getString("treatResult"))) {//如果核查状态为1代表查得才继续插值
//                        System.out.print(driverArchviesNoCheck.getString("treatResult"));        //核查状态
//                        System.out.print(driverArchviesNoCheck.getString("checkResult"));        //驾驶证档案编号核查
//                    }
//                }
//            }
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//	}
//    public static void requestUnzipApi(String refID) throws Exception {
//        String result = requestApi(PyConfig.HOST, PyConfig.PATH_UNZIP, refID);
//        System.out.println(result);
//    }
//
//    public static String requestApi(String host, String path,String refID) throws Exception {
//        Map<String, String> headers = new HashMap<String, String>();
//        Map<String, String> querys = null;
//        Map<String, String> bodys = new HashMap<String, String>();
//        bodys.put("userID", PyConfig.USERID);
//        bodys.put("password", PyConfig.PASSWORD);
//        bodys.put("queryCondition", getQueryCondition(refID));
//        HttpResponse response = HttpUtils.doPost(host, path, "POST", headers, querys, bodys);
//        String result = EntityUtils.toString(response.getEntity());
//
//        return result;
//    }
//
//    private static String getQueryCondition(String refID) throws Exception {
//        QueryConditions queryConditions = new QueryConditions();
//        List<QueryCondition> conditions = new ArrayList<QueryCondition>();
//        QueryCondition queryCondition = new QueryCondition();
//        queryCondition.setQueryType("25212");//查询类型   互联网客户
//        // 查询类型
//        List<QueryCondition.Item> items = new ArrayList<QueryCondition.Item>();
//        // 收费子报告
//        items.add(new QueryCondition.Item("subreportIDs", "96040"));//收费子报告
//        // 查询原因
//        items.add(new QueryCondition.Item("queryReasonID", "101"));//贷款审批查询原因ID
//        items.add(new QueryCondition.Item("refID", refID));
//        // 具体查询条件
//        items.add(new QueryCondition.Item("name", "测试一"));//姓名
//        items.add(new QueryCondition.Item("documentNo", "110000199001011112"));//证件号码
//        items.add(new QueryCondition.Item("phone", "13712345670"));//手机
//        queryCondition.setItems(items);
//        conditions.add(queryCondition);
//        queryConditions.setConditions(conditions);
//        return JSON.toJSONString(queryConditions);
//
//    }
}
//测试数据
//测试一,110000199001011112,B2E,1999-07-04,450728823049
//        测试二,110000199001021118,C1,1999-07-04,450728823049
//        测试三,110000199001031113,B2E,1999-07-05,450728823049
//        测试四,110000199001041119,B2E,1999-07-04,450728823048
//        测试五,110000199001051114,B2E,1999-07-04,450728823049
//        测试六,110000199001061128,B2E,1999-07-04,450728823049
//        测试七,110000199001071115,B2E,1999-07-04,450728823049
//        测试八,110000199001081129,B2E,1999-07-04,450728823049
//        测试九,110000199001091116,B2E,1999-07-04,450728823049
//        测试十,11000019900114111x,B2E,1999-07-04,450728823049