package cn.tzauto.octopus.common.ws;

import cn.tzauto.octopus.common.globalConfig.GlobalConstants;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.apache.axis.message.MessageElement;
import org.apache.axis.types.Schema;
import org.apache.log4j.Logger;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class AvaryAxisUtil {

    private static final Logger logger = Logger.getLogger(AvaryAxisUtil.class);
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private static DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyyMMdd");

    private static final String url = "http://szecpw014.eavarytech.com:8001/WebServiceForSZ/Service1.asmx";   //URL地址
    //    private static final String url = GlobalConstants.getProperty("AVARY_MES_WS_URL");   //URL地址
    private static final String namespace = "http://tempuri.org/";
//    private static final String namespace = GlobalConstants.getProperty("AVARY_MES_WS_NAMESPACE");

    public static String webServicesToCIM(String method, Object[] parms) {
//        downLoadRecipe
//        String endPoint ="szecpw014.eavarytech.com:8001/WebServiceForSZ/Service1.asmx";
        String endPoint = "http://localhost:9999/test/hello?wsdl";
        try {
            Service service = new Service();
            Call call = (Call) service.createCall();
            call.setTargetEndpointAddress(new java.net.URL(endPoint));
            call.setOperationName(method);
            String jsonResult = String.valueOf(call.invoke(parms));
            logger.info("调用CIM的接口中方法--》" + method + "：的结果：" + jsonResult);
            return jsonResult;
        } catch (Exception e) {
            logger.error("调用CIM的接口中方法--》" + method + "：方法异常：", e);
            return "Error";
        }
    }

    public static String downLoadRecipeFormCIM(String method, Object[] parms) {
//        downLoadRecipe  http://ip:port/services/recipeService?wsdl
//        String endPoint ="szecpw014.eavarytech.com:8001/WebServiceForSZ/Service1.asmx";
        String endPoint = "http://localhost:9999/test/hello?wsdl";
        try {
            Service service = new Service();
            Call call = (Call) service.createCall();
            call.setTargetEndpointAddress(new java.net.URL(endPoint));
            call.setOperationName(method);
            call.addParameter(new QName(namespace, "userId"), XMLType.XSD_STRING, ParameterMode.IN);   //设置请求参数及类型
            call.addParameter(new QName(namespace, "eqpId"), XMLType.XSD_STRING, ParameterMode.IN);   //设置请求参数及类型
            call.addParameter(new QName(namespace, "recipeName"), XMLType.XSD_STRING, ParameterMode.IN);   //设置请求参数及类型
            call.addParameter(new QName(namespace, "downloadingMode"), XMLType.XSD_STRING, ParameterMode.IN);   //设置请求参数及类型

            call.setReturnType(XMLType.XSD_STRING);
            String jsonResult = String.valueOf(call.invoke(parms));
            logger.info("调用CIM的接口中方法--》" + method + "：的结果：" + jsonResult);
            return jsonResult;
        } catch (Exception e) {
            logger.error("调用CIM的接口中方法--》" + method + "：方法异常：", e);
            return "Error";
        }
    }

    public static void main(String[] args) {
//    String temp = "&#x4E0A;&#x5D17;&#x8B49;&#x9A57;&#x8B49;&#x5931;&#x6557;";
        //1-1
//        System.out.println(workLicense("DEXP03000100", "G1483684www"));

        //1-2
//        try {
//            List list = getProductionCondition("DEXP03000100","FSAPMN7A2A135");
//            System.out.println(list);
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }

        //1-3
//        try {
//            boolean b = isInitialPart("FSAPMN7A2A135","DEXP03000100","3","0");
//            System.out.println(b);
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }

        //1-4
//        try {
//            List list = get21Exposure("qwe","DEXP03000100","DI#12","2");
//            System.out.println(list);
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }

        //1-5
//        try {
//           boolean b =  firstProductionIsOK("DEXP03000100","124","qwe24","er34");
//            System.out.println(b);
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }


//  1-6
//       String temp =  uploadMessageEveryPNL("DEXP03000100",Arrays.asList("1","1","1"),Arrays.asList("1","1","1"));
//        System.out.println(temp);

        //2-1
//        try {
//           String list = tableQuery("SFCZ4_ZD_DIExposure","PNLPG007#","0");
//            System.out.println(list);
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
        //2-2 S2019053100813
//        try {
//            String list = getOrderNum("0");
//            System.out.println(list);
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
        //2-3
//        try {
//            String temp =  insertMasterTable("1","1","1","1","1","1","1","1");
//            System.out.println(temp);
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }

//2-4
//        try {
//             getParmByLotNum("M905271721");
//            System.out.println();
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }

//        2-5
        try {
            Map list = getParmByLotNumAndLayer("M905271721","SFCZ4_ZD_DIExposure","0");
            System.out.println(list);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

//2-6
//        try {
//            String tep = insertTable("1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1");
//            System.out.println(tep);
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }

    }

    /**
     * //1.員工上崗證信息查詢（端口）
     * //回傳資料表欄位名：YZResult
     * para1 = "設備編號|工號";
     * uploadTime = System.DateTime.Now.ToString("yyyy/MM/dd HH:mm:ss");
     * ds = webServiceSZ.ws.wsGetFun("F0716614", "6614", "設備編號", "0010", "HR001", para1, uploadTime);
     */
    public static String workLicense(String equipID, String workID) {

        Call call = null;
        Schema result = null;
        try {
            call = getCallForGetDataFromSer();

            Object[] params = new Object[]{"F0716614", "6614", equipID, "0010", "HR001", createParm(equipID, workID), LocalDateTime.now().format(dtf)};
            result = (Schema) call.invoke(params); //方法执行后的返回值
        } catch (Exception e) {
            logger.error("上岗证验证发生错误", e);
            return "上岗证验证失败";
        }
        List<Map<String, String>> list = parseXml(result);
        String ok = null;
        if (list.size() > 0) {
            ok = list.get(0).get("YZRESULT");
            if ("OK".equals(ok)) {
                return "0";
            }
            return unicode2String(ok);
        }
        return "上岗证验证失败";
    }


    /**
     * 生產條件獲取接口
     * //4.根據料號跳出資料庫料號條件（制改維護）
     * //注意!料號請使用與製改維護的值完全相同，可能包含版本號等其他值
     * //回傳資料表欄位：EQU_ID,EQU_NAME,EQU_XH,PART_NAME,PARM_CODE,PARM_NAME,PARM_STANDARD,VERSION_NAME
     * para1 = "設備編號|料號";
     * uploadTime = System.DateTime.Now.ToString("yyyy/MM/dd HH:mm:ss");
     * ds = webServiceSZ.ws.wsGetFun("F0716614", "6614", "設備編號", "0005", "PA001", para1, uploadTime);
     */
    private static List getProductionCondition(String equipID, String partNum) throws RemoteException, ServiceException, MalformedURLException {

        Call call = getCallForGetDataFromSer();

        Object[] params = new Object[]{"F0716614", "6614", equipID, "0005", "PA001", createParm(equipID, partNum), LocalDateTime.now().format(dtf)};
        Schema result = (Schema) call.invoke(params); //方法执行后的返回值
        List list = parseXml(result);
        return list;
    }

    public static String getRecipeNameByPartNum(String equipID, String partNum) {
        try {
            List list = getProductionCondition(equipID, partNum);
        } catch (RemoteException e) {
            logger.error("Exception:", e);

        } catch (ServiceException e) {
            logger.error("Exception:", e);

        } catch (MalformedURLException e) {
            logger.error("Exception:", e);

        }

        return "";
    }

    /**
     * 1.判定是否要開初件方法:
     * /// <param name="partnum">料號</param>
     * /// <param name="equipID">機台號</param>   现场确认机台号和设备编号不一样 为machineNo
     * /// <param name="frequency">管制頻率,連續生產4張后第五張開初件,即 1,5,9模式</param>
     * /// <param name="opportunity">管制時機:0:開始前,1:完成前,2:完成后</param>
     * /// <returns>不需要選初件時返回0, 需要開初件時返回1</returns>
     * <p>
     * //第六個參數:料號|機台號|管制頻率|管制時機
     * ds = webServiceSZ.ws.wsGetFun("test", "test", "#01", "0004", "G0003", "FSAPJ60C2G|PNLFH001#|3|0", System.DateTime.Now.ToString("yyyy/MM/dd HH:mm:ss"));
     */

    public static boolean isInitialPart(String partNum, String deviceCode, String opportunity) throws
            RemoteException, ServiceException, MalformedURLException {

        Call call = getCallForGetDataFromSer();

        Object[] params = new Object[]{"test", "test", "#01", "0004", "G0003", createParm(partNum, deviceCode, GlobalConstants.getProperty("FREQUENCY"), opportunity), LocalDateTime.now().format(dtf)};
        Schema result = (Schema) call.invoke(params); //方法执行后的返回值
        List<Map<String, String>> list = parseXml(result);
        if (list.size() > 0) {
            Map<String, String> map = list.get(0);
            String yzResult = map.get("LASTVALUE");//实际测试返回值不是returns
            if ("1".equals(yzResult)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 曝光21節獲取接口
     * <p>
     * //第六個參數:表單名稱|機台號|天數
     * ds = webServiceSZ.ws.wsGetFun("test", "test", "#01", "0004", "0018", "防焊曝光21節記錄表|TEST|3", System.DateTime.Now.ToString("yyyy/MM/dd HH:mm:ss"));
     */

    public static boolean get21Exposure(String deviceCode) {
        Call call = null;
        Schema result = null;
        try {
            call = getCallForGetDataFromSer();

            Object[] params = new Object[]{"test", "test", "#01", "0004", "0018", createParm("SFCZ4_ZD_DIExposure", deviceCode, GlobalConstants.getProperty("SFCZ4_ZD_DIExposure_DAYS")), LocalDateTime.now().format(dtf)};
            result = (Schema) call.invoke(params); //方法执行后的返回值
        } catch (Exception e) {
            return false;
        }
        List list = parseXml(result);
        if (list != null && !list.isEmpty())
            return true;
        return false;
    }

    /**
     * //3.該批號印刷初件是否OK
     * //回傳資料表欄位：lastvalue
     * para1 = "批號|料號|主表單號";
     * uploadTime = System.DateTime.Now.ToString("yyyy/MM/dd HH:mm:ss");
     * ds = webServiceSZ.ws.wsGetFun("F0716614", "6614", "設備編號", "0004", "0009", para1, uploadTime);
     */

    public static boolean firstProductionIsOK(String deviceName, String lotNum, String partNum, String tableNum) {

        Call call = null;
        Schema result = null; //方法执行后的返回值try
        try {
            call = getCallForGetDataFromSer();
            Object[] params = new Object[]{"F0716614", "6614", deviceName, "0004", "0009", createParm(lotNum, partNum, tableNum), LocalDateTime.now().format(dtf)};
            result = (Schema) call.invoke(params);
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        List<Map<String, String>> list = parseXml(result);
        if (list.size() > 0) {
            Map<String, String> map = list.get(0);
            String value = map.get("LASTVALUE");
            if ("OK".equals(value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * //6.每PNL物料生產信息拋轉到數據庫
     * //para1與para2可填入多個項目，分隔符號是'|'，範例為上傳三組信息
     * //回傳值：OK或NG:原因
     * para1 = "生產信息名稱1|生產信息名稱2|生產信息名稱3";
     * para2 = "生產信息值1|生產信息值2|生產信息值3";
     * uploadTime = System.DateTime.Now.ToString("yyyy/MM/dd HH:mm:ss");
     * ret = webServiceSZ.ws.wsFun("F0716614", "6614", "設備編號",para1,para2,uploadTime);
     */

    public static String uploadMessageEveryPNL(String equipID, List paraName, List paraValue) {

        Call call = null;
        String result = null;
        try {
            call = getCallForSendDataToSer();
            Object[] params = new Object[]{"F0716614", "6614", equipID, createParm(paraName), createParm(paraValue), LocalDateTime.now().format(dtf)};
            result = (String) call.invoke(params); //方法执行后的返回值
            if ("OK".equals(result)) {
                return "";
            }

        } catch (Exception e) {
            logger.error("Exception:", e);
        }
        return result;
    }

    /**
     * //第一步: 已有表單單號查詢 ,獲取當天,當班,同一機台 單號,若有,則抓取該單號,執行第四步(跳過第二,第三步),若沒有 ,則執行第二步.
     * //第六個參數:表單編號|日期(系統日期-8小時)|機台號|班別(0:白班 ,1:夜班)
     * ds = webServiceSZ.ws.wsGetFun("test", "test", "#01", "0004", "G0001", "SFCZ4_ZDCVL|20181121|PNLAVI002#(E)|0", System.DateTime.Now.ToString("yyyy/MM/dd HH:mm:ss"));
     */
    public static String tableQuery(String tableNum, String machineNo, String classInfo) throws RemoteException, ServiceException, MalformedURLException {

        Call call = getCallForGetDataFromSer();
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime time = now.minusHours(8);

        Object[] params = new Object[]{"test", "test", "#01", "0004", "G0001", createParm(tableNum, time.format(dtf1), machineNo, classInfo), now.format(dtf)};
        Schema result = (Schema) call.invoke(params); //方法执行后的返回值
        List<Map<String, String>> list = parseXml(result);
        if (list.size() > 0) {
            Map<String, String> map = list.get(0);
            Set<String> strings = map.keySet();
            for (String string : strings) {
                return map.get(string);
            }
        }
        return null;
    }


    /**
     * //第二步:調用 系統生產單號 方法 ,獲取單號,之後執行第三步
     * //第六個參數: 日期(系統日期-8小時)|班別(0:白班 ,1:夜班)
     * ds = webServiceSZ.ws.wsGetFun("test", "test", "#01", "0004", "0002", "20180926|0", System.DateTime.Now.ToString("yyyy/MM/dd HH:mm:ss"));
     */


    public static String getOrderNum(String classInfo) throws RemoteException, ServiceException, MalformedURLException {

        Call call = getCallForGetDataFromSer();
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime time = now.minusHours(8);

        Object[] params = new Object[]{"test", "test", "#01", "0004", "0002", createParm(time.format(dtf1), classInfo), now.format(dtf)};
        Schema result = (Schema) call.invoke(params); //方法执行后的返回值
        List<Map<String, String>> list = parseXml(result);
        if (list.size() > 0) {
            Map<String, String> map = list.get(0);
            Set<String> strings = map.keySet();
            for (String string : strings) {
                return map.get(string);
            }
        }
        return null;
    }

    /**
     * //第三步: 插入主表數據 ,  執行第四步
     * //第7個參數: 表單號|狀態|日期(系統日期-8小時)|機台號|表單編號|班別(0 白班 1 夜班)|廠區(深圳:001 )|創建時間|創建工號
     * <p>
     * ret = webServiceSZ.ws.wsSendFun(
     * "test", "test", "#01", "0004", "0003",
     * "PaperNo|Status|Dodate|MachineNo|Report|ClassInfo|Factory|CreateTime|CreateEmpid",
     * "test2018030200343|1|20180302|TEST|SFCZ4_ZDCVL|0|001|" + System.DateTime.Now.ToString("yyyyMMddHHmmss") + "|G1479462",
     * System.DateTime.Now.ToString("yyyy/MM/dd HH:mm:ss"));
     */
    public static String insertMasterTable(String paperNo, String status, String deviceCode, String report, String classInfo, String factory, String createTime, String createEmpid) throws RemoteException, ServiceException, MalformedURLException {

        Call call = getCallForSendDataToSerGrp();
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime time = now.minusHours(8);

        Object[] params = new Object[]{"test", "test", "#01", "0004", "0003", "PaperNo|Status|Dodate|MachineNo|Report|ClassInfo|Factory|CreateTime|CreateEmpid"
                , createParm(paperNo, status, time.format(dtf1), deviceCode, "SFCZ4_ZD_DIExposure", classInfo, "001", now.format(dtf2), createEmpid), now.format(dtf)};
        String result = (String) call.invoke(params); //方法执行后的返回值
        if ("OK".equals(report)) {
            return "";
        }
        return result;
    }

    /**
     * //第四步: 批號獲料號,層別,數量 ,執行第五步 若不需要層別,數量,數據,請忽略第四步,第五步輸入批號,層別
     * //第6個參數: 批號
     * para1 = "MF87273521";
     * ds = webServiceSZ.ws.wsGetFun("test", "test", "#01", "0001", "0002", para1, System.DateTime.Now.ToString("yyyy/MM/dd HH:mm:ss"));
     */
    public static Map getParmByLotNum(String lotNum) throws RemoteException, ServiceException, MalformedURLException {
        Call call = getCallForGetDataFromSer();
        LocalDateTime now = LocalDateTime.now();

        Object[] params = new Object[]{"test", "test", "#01", "0001", "0002", lotNum, now.format(dtf)};
        Schema result = (Schema) call.invoke(params); //方法执行后的返回值
        List<Map<String,String>> list = parseXml(result);
        Map paraMap = new HashMap();
        if(list.size()==0){
            return  paraMap;
        }
        paraMap.put("PartNum", list.get(0).get("料號"));
        paraMap.put("Layer", list.get(0).get("層別"));
        paraMap.put("Qty", list.get(0).get("數量"));
        return paraMap;
    }

    public static String getLotQty(String lotNum) {
        try {
            return String.valueOf(getParmByLotNum(lotNum).get("Qty"));
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return "0";
    }

    /**
     * //第五步: 根據 批號,層別 帶出 料號,在製層,途程序,主途程序,制程,主配件,層別名稱,第幾次過站,工令,BOM資料 ; 若查詢結果沒有值,則卡住報錯:獲取途程信息失敗,若有值,則進行第六步(請先在生產日報表制程綁定裏面綁定對應制程)
     * //第6個參數: 批號|表單編號|層別
     * para1 = "MF88020361|SFCZ4_ZDCVL |0";
     * ds = webServiceSZ.ws.wsGetFun("test", "test", "#01", "0001", "0009", para1, System.DateTime.Now.ToString("yyyy/MM/dd HH:mm:ss"));
     */
    public static Map getParmByLotNumAndLayer(String lotNum, String paperNum, String layer) throws RemoteException, ServiceException, MalformedURLException {
        Call call = getCallForGetDataFromSer();
        LocalDateTime now = LocalDateTime.now();

        Object[] params = new Object[]{"test", "test", "#01", "0001", "0009", createParm(lotNum, paperNum, layer), now.format(dtf)};
        Schema result = (Schema) call.invoke(params); //方法执行后的返回值
        List<Map<String,String>> list = parseXml(result);
        Map<String,String> map = list.get(0);
        Map paraMap = new HashMap();
        paraMap.put("PartNum", map.get("料號"));
        paraMap.put("在製層", map.get("在製層"));
        paraMap.put("Serial", map.get("途程序"));
        paraMap.put("MainSerial", map.get("主途程序"));
        paraMap.put("PE", map.get("制程"));
        paraMap.put("主配件", map.get("主配件"));
        paraMap.put("LayerName", unicode2String(map.get("層別名稱")));
        paraMap.put("OrderId", map.get("第幾次過站"));
        paraMap.put("WorkNo", map.get("工令"));
        paraMap.put("BOM", "");
        return paraMap;
    }

    /**
     * //第六步: 明細表數據插入
     * para1 = "PaperNo|StartTime|lLot|Lotnum|Layer|sfclayer|LayerName|mainserial|serial|workno|FirstAcess|Item2|Item3|Item4|Item5|Item6|Item7|Item8|Item9|" +
     * "Item10|Qty|Item11|Item12|Item13|Item14|Item15|Item16|Item17|Item18";
     * para2 = "2018082400921|20181110014309|FSNW003A1A|M808172031|60|60|主要+CVL-ACVL-B|17|8|WN6-I80309|5|FSNW003A1ASTA|0|0|90|90|7|SG10046|FSNW003STAA1A|"+
     * "G1478673|12|5|G1478673|STA|0.225mm|16188052-A602222|STA|0.225mm|16188052-A602222";
     * ret = webServiceSZ.ws.wsSendFun("test", "test", "#01", "0004", "0006",para1,para2,System.DateTime.Now.ToString("yyyy/MM/dd HH:mm:ss"));
     */
    public static String insertTable(String paperNo, String startTime, String lLot, String lotnum, String layer, String sfclayer, String layerName, String mainserial, String serial
            , String workno, String firstAcess, String item2, String item3, String item4, String item5, String item6, String item7, String item8, String item9, String item10
            , String qty, String item11, String item12, String item13, String item14, String item15, String item16, String item17, String item18) throws RemoteException, ServiceException, MalformedURLException {

        Call call = getCallForSendDataToSerGrp();
        LocalDateTime now = LocalDateTime.now();

        Object[] params = new Object[]{"test", "test", "#01", "0004", "0006",
                "PaperNo|StartTime|lLot|Lotnum|Layer|sfclayer|LayerName|mainserial|serial|workno|FirstAcess|Item2|Item3|Item4|Item5|Item6|Item7|Item8|Item9|Item10|Qty|Item11|Item12|Item13|Item14|Item15|Item16|Item17|Item18"
                , createParm(paperNo, startTime, lLot, lotnum, layer, sfclayer, layerName, mainserial, serial, workno, firstAcess, item2, item3, item4, item5, item6, item7, item8, item9, item10, qty, item11, item12, item13, item14, item15, item16, item17, item18)
                , now.format(dtf)};
        String result = (String) call.invoke(params); //方法执行后的返回值
        if ("OK".equals(result)) {
            return "";
        }
        return result;
    }

    private static Call getCallForSendDataToSer() throws ServiceException, MalformedURLException {
        String actionUri = "sendDataToSer"; //Action路径
        String op = "sendDataToSer"; //要调用的方法名
        Service service = new Service();
        Call call = (Call) service.createCall();
        call.setTargetEndpointAddress(new java.net.URL(url));
        call.setUseSOAPAction(true);
        call.setSOAPActionURI(namespace + actionUri); // action uri
        call.setOperationName(new QName(namespace, op));// 设置要调用哪个方法
// 设置参数名称，具体参照从浏览器中看到的
        call.addParameter(new QName(namespace, "username"), XMLType.XSD_STRING, ParameterMode.IN);   //设置请求参数及类型
        call.addParameter(new QName(namespace, "password"), XMLType.XSD_STRING, ParameterMode.IN);   //设置请求参数及类型
        call.addParameter(new QName(namespace, "equid"), XMLType.XSD_STRING, ParameterMode.IN);   //设置请求参数及类型
        call.addParameter(new QName(namespace, "parameterName"), XMLType.XSD_STRING, ParameterMode.IN);   //设置请求参数及类型
        call.addParameter(new QName(namespace, "parameterValue"), XMLType.XSD_STRING, ParameterMode.IN);   //设置请求参数及类型
        call.addParameter(new QName(namespace, "createDate"), XMLType.XSD_STRING, ParameterMode.IN);   //设置请求参数及类型

        //call.setReturnType(new QName(namespace,"getinfo"),Model.class); //设置返回结果为是某个类
//        call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);//设置结果返回类型
        call.setReturnType(XMLType.XSD_STRING);//设置结果返回类型
        return call;
    }


    private static Call getCallForGetDataFromSer() throws ServiceException, MalformedURLException {
        String actionUri = "getDataFromSer"; //Action路径
        String op = "getDataFromSer"; //要调用的方法名
        Service service = new Service();
        Call call = (Call) service.createCall();
        call.setTargetEndpointAddress(new java.net.URL(url));
        call.setUseSOAPAction(true);
        call.setSOAPActionURI(namespace + actionUri); // action uri
        call.setOperationName(new QName(namespace, op));// 设置要调用哪个方法
// 设置参数名称，具体参照从浏览器中看到的
        call.addParameter(new QName(namespace, "username"), XMLType.XSD_STRING, ParameterMode.IN);   //设置请求参数及类型
        call.addParameter(new QName(namespace, "password"), XMLType.XSD_STRING, ParameterMode.IN);   //设置请求参数及类型
        call.addParameter(new QName(namespace, "equid"), XMLType.XSD_STRING, ParameterMode.IN);   //设置请求参数及类型
        call.addParameter(new QName(namespace, "groupid"), XMLType.XSD_STRING, ParameterMode.IN);   //设置请求参数及类型
        call.addParameter(new QName(namespace, "funid"), XMLType.XSD_STRING, ParameterMode.IN);   //设置请求参数及类型
        call.addParameter(new QName(namespace, "pValue"), XMLType.XSD_STRING, ParameterMode.IN);   //设置请求参数及类型
        call.addParameter(new QName(namespace, "createDate"), XMLType.XSD_STRING, ParameterMode.IN);   //设置请求参数及类型

        //call.setReturnType(new QName(namespace,"getinfo"),Model.class); //设置返回结果为是某个类
//        call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);//设置结果返回类型
        call.setReturnType(XMLType.XSD_SCHEMA);//设置结果返回类型
        return call;
    }

    private static Call getCallForSendDataToSerGrp() throws ServiceException, MalformedURLException {
        String actionUri = "sendDataToSerGrp"; //Action路径
        String op = "sendDataToSerGrp"; //要调用的方法名
        Service service = new Service();
        Call call = (Call) service.createCall();
        call.setTargetEndpointAddress(new java.net.URL(url));
        call.setUseSOAPAction(true);
        call.setSOAPActionURI(namespace + actionUri); // action uri
        call.setOperationName(new QName(namespace, op));// 设置要调用哪个方法
// 设置参数名称，具体参照从浏览器中看到的
        call.addParameter(new QName(namespace, "username"), XMLType.XSD_STRING, ParameterMode.IN);   //设置请求参数及类型
        call.addParameter(new QName(namespace, "password"), XMLType.XSD_STRING, ParameterMode.IN);   //设置请求参数及类型
        call.addParameter(new QName(namespace, "equid"), XMLType.XSD_STRING, ParameterMode.IN);   //设置请求参数及类型
        call.addParameter(new QName(namespace, "groupid"), XMLType.XSD_STRING, ParameterMode.IN);   //设置请求参数及类型
        call.addParameter(new QName(namespace, "funid"), XMLType.XSD_STRING, ParameterMode.IN);   //设置请求参数及类型
        call.addParameter(new QName(namespace, "parameterName"), XMLType.XSD_STRING, ParameterMode.IN);   //设置请求参数及类型
        call.addParameter(new QName(namespace, "parameterValue"), XMLType.XSD_STRING, ParameterMode.IN);   //设置请求参数及类型
        call.addParameter(new QName(namespace, "createDate"), XMLType.XSD_STRING, ParameterMode.IN);   //设置请求参数及类型

        //call.setReturnType(new QName(namespace,"getinfo"),Model.class); //设置返回结果为是某个类
//        call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);//设置结果返回类型
        call.setReturnType(XMLType.XSD_STRING);//设置结果返回类型
//        call.setReturnType(QName.valueOf(XMLType.NS_PREFIX_XML));//设置结果返回类型
        return call;
    }


    private static String createParm(String... parms) {
        StringBuilder sb = new StringBuilder();
        int length = parms.length;
        for (int i = 0; i < length - 1; i++) {
            sb.append(parms[i]).append("|");
        }
        sb.append(parms[length - 1]);
        return sb.toString();
    }

    private static String createParm(List parms) {
        StringBuilder sb = new StringBuilder();
        int length = parms.size();
        for (int i = 0; i < length - 1; i++) {
            sb.append(parms.get(i)).append("|");
        }
        sb.append(parms.size() - 1);
        return sb.toString();
    }

    private static List<Map<String, String>> parseXml(Schema schema) {
        List<Map<String, String>> list = new ArrayList<>();
        MessageElement[] elements = schema.get_any();
//        List elementHead = elements[0].getChildren();//消息头
        List elementBody = elements[1].getChildren();//消息体信息,DataSet对象
        if (elementBody == null || elementBody.size() == 0) {
            return list;
        }
        String text = elementBody.get(0).toString();//消息体的字符串形式
        createList(list, text);
        return list;

    }

    public static void createList(List list, String text) {
        if (text.contains("<Table")) {
            int i = text.indexOf("<Table");
            int j = text.indexOf("</Table>");
            if (j < 0) {
                return;
            }
            String sub1 = text.substring(i + 6, j);
            i = sub1.indexOf(">");
            sub1 = sub1.substring(i + 1);
            String sub2 = text.substring(j + 8);

            Map<String, String> map = new HashMap<>();
            createMap(map, sub1);
            list.add(map);
            createList(list, sub2);
        }
    }

    public static void createMap(Map<String, String> map, String text) {
        if (text.contains("<")) {
            int i = text.indexOf("<");
            int j = text.indexOf(">");
            String key = text.substring(i + 1, j);
            String sub1 = text.substring(j + 1);
            i = sub1.indexOf("<");
            j = sub1.indexOf(">");
            String value = sub1.substring(0, i);
            map.put(key, value);
            String sub2 = sub1.substring(j + 1);
            createMap(map, sub2);
        }
    }

    public static String unicode2String(String unicode) {
        StringBuffer string = new StringBuffer();
        String pre = "";
        if (unicode.contains("&#x")) {
            int index = unicode.indexOf("&#x");
            if (index > 0) {
                pre = unicode.substring(0, index);
                unicode = unicode.substring(index);
            }
            String[] split = unicode.split(";");
            for (int i = 0; i < split.length; i++) {
                String temp = split[i];
                if (temp.startsWith("&#x")) {
                    String replace = temp.replace("&#x", "");
                    int data = Integer.parseInt(replace, 16);
                    string.append((char) data);
                } else {
                    String[] split1 = temp.split("&#x");
                    string.append(split1[0]);
                    int data = Integer.parseInt(split1[1], 16);
                    string.append((char) data);
                }
            }
        } else if (unicode.contains("&#")) {
            int index = unicode.indexOf("&#");
            if (index > 0) {
                pre = unicode.substring(0, index);
                unicode = unicode.substring(index);
            }
            String[] split = unicode.split(";");
            for (int i = 0; i < split.length; i++) {
                String temp = split[i];
                if (temp.startsWith("&#")) {
                    String replace = temp.replace("&#", "");
                    int data = Integer.parseInt(replace, 10);
                    string.append((char) data);
                } else {
                    String[] split1 = temp.split("&#");
                    string.append(split1[0]);
                    int data = Integer.parseInt(split1[1], 10);
                    string.append((char) data);
                }
            }
        } else if (unicode.startsWith("\\u")) {
            String[] strs = unicode.split("\\\\u");
            for (int i = 0; i < strs.length; i++) {
                String temp = strs[i];
                if ("".equals(temp)) {
                    continue;
                }
                int data = Integer.parseInt(strs[i], 16);
                string.append((char) data);
            }
        } else {
            return unicode;
        }
        return pre + string.toString();
    }
}