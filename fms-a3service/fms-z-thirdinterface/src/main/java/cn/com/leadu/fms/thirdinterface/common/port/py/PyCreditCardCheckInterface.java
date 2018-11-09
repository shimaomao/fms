package cn.com.leadu.fms.thirdinterface.common.port.py;

import cn.com.leadu.fms.pojo.thirdinterface.PyCreditCardCheckInterfaceVo;

import java.util.Random;

/**
 * @author 杨刚
 * @ClassName: CardTransCheck
 * @Description: 鹏远征信 卡核查及交易
 * @date 2018-06-7
 */
public class PyCreditCardCheckInterface {
    public static PyCreditCardCheckInterfaceVo getTestData(){
        String testData [][] = {
                {"测试一",	"110000199001011112","6225768610373340"},
                {"测试三",	"110000199001031113"	,"6222088750761201,6222088751234567"}
        };

        PyCreditCardCheckInterfaceVo testVo = new PyCreditCardCheckInterfaceVo();
        Random rand = new Random();
        int index = rand.nextInt(1);
        testVo.setRefID("cs001");//业务流水号(自定义CHAR(30)，可以为空)
        testVo.setName(testData[index][0]);//姓名(可以为空)
        testVo.setDocumentNo(testData[index][1]);//证件号码(可以为空)
        testVo.setCardNos(testData[index][2]);//手机
        return testVo;
    }
//    public static void main(String[] args) {
//        try {
//            PyCreditCardCheckInterfaceVo cs= new PyCreditCardCheckInterfaceVo();
//            cs.setRefID("cs001");//业务流水号(自定义CHAR(30)，可以为空)
//            cs.setName("测试一");//姓名
//            cs.setDocumentNo("110000199001031113");//证件号码
//            cs.setCardNos("6222088750761201,6222088751234567");//银行账号
//            Map<String, String> resultMap = new PyInterface().requestUnzipApi(cs);
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
//    public static void main(String[] args) {
//
//
//        String refID="cs001";//业务流水号(自定义CHAR(30)，可以为空)
//        try {
//            CardTransCheck.requestUnzipApi(refID);
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
//    public static void requestUnzipApi(String refID) throws Exception {
//        String result = requestApi(PyConfig.HOST, PyConfig.PATH_UNZIP, refID);
//        System.out.println(result);
//    }
//
//    public static String requestApi(String host, String path,String refID) throws Exception {
//
//        // https双向认证使用,配合PySSLContextUtil中的DefaultSSLContext
////        System.setProperty("javax.net.debug", "all");
////        System.setProperty("javax.net.ssl.keyStore", PyConfig.KEYSTORE_FILE);
////        System.setProperty("javax.net.ssl.keyStorePassword", PyConfig.KEYSTORE_PASSWORD);
////        System.setProperty("javax.net.ssl.trustStore", PyConfig.TRUSTSTORE_FILE);
////        System.setProperty("javax.net.ssl.trustStorePassword", PyConfig.TRUSTSTORE_PASSWORD);
//
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
//        queryCondition.setQueryType("25136");//查询类型   互联网客户
//        // 查询类型
//        List<QueryCondition.Item> items = new ArrayList<QueryCondition.Item>();
//        // 收费子报告
//        items.add(new QueryCondition.Item("subreportIDs", "14501,14517"));//收费子报告
//        // 查询原因
//        items.add(new QueryCondition.Item("queryReasonID", "101"));//贷款审批查询原因ID
////        items.add(new QueryCondition.Item("queryReasonID", "102"));//贷款贷后管理查询原因ID
////        items.add(new QueryCondition.Item("queryReasonID", "103"));//贷款催收查询原因ID
//        // 业务流水号(自定义CHAR(30)，可以为空)
//        items.add(new QueryCondition.Item("refID", refID));
//        // 具体查询条件
//        items.add(new QueryCondition.Item("name", "测试三"));//姓名
//        items.add(new QueryCondition.Item("documentNo", "110000199001031113"));//证件号码
//        items.add(new QueryCondition.Item("cardNos", "6222088750761201,6222088751234567"));//银行卡号
//        queryCondition.setItems(items);
//        conditions.add(queryCondition);
//        queryConditions.setConditions(conditions);
//        return JSON.toJSONString(queryConditions);
//
//    }
}
//测试数据
//        测试一，	110000199001011112，	6225768610373340 （信用卡）
//        测试三，	110000199001031113	，"6222088750761201,6222088751234567" （借记卡）