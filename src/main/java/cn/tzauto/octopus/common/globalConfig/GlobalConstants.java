/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tzauto.octopus.common.globalConfig;

import cn.tzauto.octopus.biz.device.domain.ClientInfo;
import cn.tzauto.octopus.biz.device.domain.DeviceInfo;
import cn.tzauto.octopus.biz.device.service.DeviceService;
import cn.tzauto.octopus.biz.sys.domain.SysUser;
import cn.tzauto.octopus.biz.sys.service.SysService;
import cn.tzauto.octopus.common.dataAccess.base.mybatisutil.MybatisSqlSession;
import cn.tzauto.octopus.common.rabbit.MessageUtils;
import cn.tzauto.octopus.gui.main.EapClient;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class GlobalConstants {
    private static final Logger logger = Logger.getLogger(GlobalConstants.class.getName());
    private static Properties prop;
    public static boolean SYNC_CONIFG = false;
    public static boolean MONITOR_CONIFG = false;
    public static boolean LOG_UPLOAD = false;
    public static boolean REQUEST_CONIFG = false;
    public static String SERVER_ID;
    public static final String SYNC_CONFIG_JOB_NAME = "SYNC_CONFIG_JOB";
    public static final String SCAN_HOST_JOB_NAME = "SCAN_HOST_JOB";
    public static final String SYNC_JOB_DATA_MAP = "SYNC_JOB_DATA_MAP";
    public static final String MONITOR_CONFIG_JOB_NAME = "MONITOR_CONFIG_JOB";
    public static final String MONITOR_EC_JOB_NAME = "MONITOR_EC_JOB";
    public static final String LOG_SAVE_JOB_NAME = "LOG_SAVE_JOB";
    public static final String NET_CHECK_JOB_NAME = "NET_CHECK_JOB";
    public static final String COMM_CHECK_JOB_NAME = "COMM_CHECK_JOB";
    public static final String SESSION_CONTROL_JOB_NAME = "SESSION_CONTROL_JOB";
    public static final String DATA_CLEAN_JOB_NAME = "DATA_CLEAN_JOB";
    public static final String MONITOR_ALARM_JOB_NAME = "MONITOR_ALARM_JOB";
    public static final String MONITOR_ALARM_LOCK_JOB_NAME = "MONITOR_ALARM_LOCK_JOB";
    public static final String UPLOAD_MTBA_JOB_NAME = "UPLOAD_MTBA_JOB";
    public static final String REFRESH_EQUIPSTATE_JOB_NAME = "REFRESH_EQUIPSTATE_JOB";
    public static String HOST_JSON_FILE;
    public static String CONFIG_FILE_PATH = "config.properties";
    //    public static cn.tzauto.octopus.common.mq.MessageUtils C2SRcpQueue = new cn.tzauto.octopus.common.mq.MessageUtils("C2S.Q.RECIPE_C");
//    public static cn.tzauto.octopus.common.mq.MessageUtils C2SRcpUpLoadQueue = new cn.tzauto.octopus.common.mq.MessageUtils("C2S.Q.RCPUPLOAD");
//    public static cn.tzauto.octopus.common.mq.MessageUtils C2SRcpDownLoadQueue = new cn.tzauto.octopus.common.mq.MessageUtils("C2S.Q.RCPDOWNLOAD");
//    public static cn.tzauto.octopus.common.mq.MessageUtils C2SCheckRcpNameQueue = new cn.tzauto.octopus.common.mq.MessageUtils("C2S.Q.CHECKRCPNAME");
//    public static cn.tzauto.octopus.common.mq.MessageUtils C2SRcpDeleteQueue = new cn.tzauto.octopus.common.mq.MessageUtils("C2S.Q.RCPDELETE");
//    public static cn.tzauto.octopus.common.mq.MessageUtils C2SRcpSelectQueue = new cn.tzauto.octopus.common.mq.MessageUtils("C2S.Q.PPSELECT");
//    public static cn.tzauto.octopus.common.mq.MessageUtils C2SAlarmQueue = new cn.tzauto.octopus.common.mq.MessageUtils("C2S.Q.ALARM_D");
//    public static cn.tzauto.octopus.common.mq.MessageUtils C2SAlarmQueueTest = new cn.tzauto.octopus.common.mq.MessageUtils("C2S.Q.ALARM_Dtest");
//    public static cn.tzauto.octopus.common.mq.MessageUtils C2SInitQueue = new cn.tzauto.octopus.common.mq.MessageUtils("C2S.Q.INITIAL_REQUEST");
//    public static cn.tzauto.octopus.common.mq.MessageUtils C2SLogQueue = new cn.tzauto.octopus.common.mq.MessageUtils("C2S.Q.LOG_D");
//    public static cn.tzauto.octopus.common.mq.MessageUtils C2SEqptLogQueue = new cn.tzauto.octopus.common.mq.MessageUtils("C2S.Q.EQPT_LOG_D");
//    public static cn.tzauto.octopus.common.mq.MessageUtils C2SEqptRemoteCommand = new cn.tzauto.octopus.common.mq.MessageUtils("C2S.Q.EQPT_RCMD");
//    public static cn.tzauto.octopus.common.mq.MessageUtils C2SSpecificDataQueue = new cn.tzauto.octopus.common.mq.MessageUtils("C2S.Q.SPECIFIC_DATA");
//    public static cn.tzauto.octopus.common.mq.MessageUtils C2SSvDataQueue = new cn.tzauto.octopus.common.mq.MessageUtils("C2S.Q.SV_DATA");
//    public static cn.tzauto.octopus.common.mq.MessageUtils C2SPlasma2DQueue = new cn.tzauto.octopus.common.mq.MessageUtils("C2S.Q.PLASMA_2D");
//    //public static MessageUtils S2CRcpQueue = new MessageUtils("S2C_Recipe_Queue");
//    public static cn.tzauto.octopus.common.mq.MessageUtils S2CRcpTopic = new cn.tzauto.octopus.common.mq.MessageUtils("S2C.T.RECIPE_C");
////    public static cn.tzauto.octopus.common.mq.MessageUtils S2CRcpTopicTest = new cn.tzauto.octopus.common.mq.MessageUtils("S2C.T.RECIPE_CTest");
//    public static cn.tzauto.octopus.common.mq.MessageUtils S2CDataTopic = new cn.tzauto.octopus.common.mq.MessageUtils("S2C.T.DATA_TRANSFER");
////    public static cn.tzauto.octopus.common.mq.MessageUtils S2CDataTopicTest = new cn.tzauto.octopus.common.mq.MessageUtils("S2C.T.DATA_TRANSFERTest");
//    public static cn.tzauto.octopus.common.mq.MessageUtils S2CEQPT_PARATopic = new cn.tzauto.octopus.common.mq.MessageUtils("S2C.T.EQPT_PARAMETER");
//
    public static MessageUtils C2SRcpQueue = new MessageUtils("C2S.Q.RECIPE_C", "", "1");
    public static MessageUtils C2SRcpUpLoadQueue = new MessageUtils("C2S.Q.RCPUPLOAD", "", "1");
    public static MessageUtils C2SRcpDownLoadQueue = new MessageUtils("C2S.Q.RCPDOWNLOAD", "", "1");
    public static MessageUtils C2SCheckRcpNameQueue = new MessageUtils("C2S.Q.CHECKRCPNAME", "", "1");
    public static MessageUtils C2SRcpDeleteQueue = new MessageUtils("C2S.Q.RCPDELETE", "", "1");
    public static MessageUtils C2SRcpSelectQueue = new MessageUtils("C2S.Q.PPSELECT", "", "1");
    public static MessageUtils C2SAlarmQueue = new MessageUtils("C2S.Q.ALARM_D", "", "1");
    public static MessageUtils C2SInitQueue = new MessageUtils("C2S.Q.INITIAL_REQUEST", "", "1");
    public static MessageUtils C2SLogQueue = new MessageUtils("C2S.Q.LOG_D", "", "1");
    public static MessageUtils C2SEqptLogQueue = new MessageUtils("C2S.Q.EQPT_LOG_D", "", "1");
    public static MessageUtils C2SEqptRemoteCommand = new MessageUtils("C2S.Q.EQPT_RCMD", "", "1");
    public static MessageUtils C2SSpecificDataQueue = new MessageUtils("C2S.Q.SPECIFIC_DATA", "", "1");
    public static MessageUtils C2SSvDataQueue = new MessageUtils("C2S.Q.SV_DATA", "", "1");
    public static MessageUtils C2SPlasma2DQueue = new MessageUtils("C2S.Q.PLASMA_2D", "", "1");//RPC关注点 rabbit

    public static MessageUtils S2CRcpTopic = new MessageUtils() ;//("S2C.T.RECIPE_C", "S2C.T.EXCHANGE", "2");
    public static MessageUtils S2CDataTopic = new MessageUtils();//("S2C.T.DATA_TRANSFER", "S2C.T.EXCHANGE", "2");
    public static MessageUtils S2CEQPT_PARATopic = new MessageUtils();//("S2C.T.EQPT_PARAMETER", "S2C.T.EXCHANGE", "2");


    public static SysUser sysUser;
    public static Logger sysLogger = Logger.getLogger(GlobalConstants.class.getName());
    public static String clientId;
    //    public static String clientFtpPath;
    public static ClientInfo clientInfo;
    public static String localRecipePath;
    //FTP Config信息
    public static String ftpIP;
    public static String ftpPort;
    public static String ftpUser;
    public static String ftpPwd;
    public static String ftpPath;
    //定时任务时间设置
    public static String monitorTaskCycle;
    public static String netCheckCycle;
    public static String sessionCtrlCycle;
    //数据配置信息
    public static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static int shownRows = 100;
    public static Map<String, Integer> netCheckTimeMap = new HashMap<>();
    public static Map<String, Boolean> restartMap = new HashMap<>();
    public static Date loginTime = null;
    public static boolean loginValid = false;
    //工控段开机获取数据
    public static String initService;
    public static Map sysProperties = new HashMap();
    public static Map holdLotMap = new HashMap();
    public static BlockingQueue commandTaskQueue = new PriorityBlockingQueue();
    public static boolean isLocalMode = false;
    //过期数据的保存时间
    public static String redundancyDataSavedDays = "2";
    //设备不回复消息时的等待时间 ms
    public static long msgWaitTime = 6000;
    //未连接次数与是否hold批标志，key均为deviceId
    public static Map<String, Integer> checkNotCommMap = new HashMap();
    public static Map<String, Boolean> hadHoldLotFlagMap = new HashMap();
    public static long MQ_MSG_WAIT_TIME = 30000;
    public static EapClient stage;
    // 配合isUpload  控制上传窗口只有一个
    public static boolean onlyOnePageUpload = false;
    // 配合isDownload  控制上传窗口只有一个
    public static boolean onlyOnePageDownload = false;
    // 配合isSvQuery  控制上传窗口只有一个
    public static boolean onlyOnePageSvQuery = false;

    public static Boolean isUpload = false;
    public static Boolean isDownload = false;
    public static TableView table;

    public static Boolean isSvQuery = false;
    public static Boolean userFlag = false;

    public static Stage loginStage;


    public static List<DeviceInfo> deviceInfos;
    public static Map<String,Map> mesInferfaceParaMap;

    public static boolean loadPropertyFromDB() {
        try {
            SqlSession sqlSession = MybatisSqlSession.getSqlSession();
            SysService sysService = new SysService(sqlSession);
            //从数据库加载配置信息
            List<Map> propertyList = sysService.searchAllSysProperty();
            if (propertyList != null && propertyList.size() > 0) {
                for (Map propertyMap : propertyList) {
                    String key = String.valueOf(propertyMap.get("PROPERTY_KEY"));
                    String value = String.valueOf(propertyMap.get("PROPERTY_VAL"));
                    sysProperties.put(key, value);
                }
            }
            sqlSession.close();
            return true;
        } catch (Exception e) {
            sysLogger.error("Exception:", e);
            return false;
        }
    }

    public static boolean initData() {
        clientId = getProperty("clientId");
        SqlSession sqlSession = MybatisSqlSession.getSqlSession();
        DeviceService deviceService = new DeviceService(sqlSession);
        ClientInfo currentClientInfo = deviceService.queryClientInfoByClientCode(clientId);
        if (currentClientInfo != null) {
            GlobalConstants.clientInfo = currentClientInfo;
        } else {
            sysLogger.info("客户端Client数据配置不正确，系统无法正常启动，请联系管理员修改数据");
            return false;
        }

        sqlSession.close();
//            GlobalConstants.clientFtpPath = clientInfo.getFtpPath();
        GlobalConstants.localRecipePath = getProperty("LocalRecipePath");

        //读取配置，判断是否是Local模式
        GlobalConstants.isLocalMode = "1".equals(getProperty("LOCAL_MODE"));
        //读取FTP配置
        GlobalConstants.ftpIP = getProperty("ftpIP");
        GlobalConstants.ftpPort = getProperty("ftpPort");
        GlobalConstants.ftpUser = getProperty("ftpUser");
        GlobalConstants.ftpPwd = getProperty("ftpPwd");
        GlobalConstants.ftpPath = getProperty("ftpPath");

        //读取Hold锁机标志
        // GlobalConstants. = prop.getProperty("HOLD_DEVICE");
        //工控段开机获取数据
        GlobalConstants.initService = getProperty("INIT_SERVICE");

        //定时任务时间设置
        GlobalConstants.monitorTaskCycle = getProperty("MonitorTaskCycle");
        GlobalConstants.netCheckCycle = getProperty("NetCheckCycle");
        GlobalConstants.sessionCtrlCycle = getProperty("SessionCtrlCycle");


        return true;
    }

    static {
        prop = new Properties();

        try {

            InputStream in = GlobalConstants.class.getClassLoader().getResourceAsStream(CONFIG_FILE_PATH);
            prop.load(in);

        } catch (Exception e) {
            sysLogger.error("Exception:", e);
        }
    }

    private static void loadFile() {
        try {
            InputStream in = GlobalConstants.class.getClassLoader().getResourceAsStream(CONFIG_FILE_PATH);
            prop.load(in);
        } catch (Exception e) {
            sysLogger.error("Exception:", e);
        }
    }

    public static String getProperty(String key) {
        String resultStr = "";
        //优先加载数据库保存的配置，如果没有，加载配置文件
        if (sysProperties.get(key) != null) {
            resultStr = String.valueOf(sysProperties.get(key));
        } else {
            if (prop == null) {
                loadFile();
            }
            try {
                resultStr = prop.getProperty(key);
                if (resultStr != null) {
                    resultStr = resultStr.trim();
                }
            } catch (Exception e) {
                sysLogger.error("Exception:", e);
            }
        }
        return resultStr;
    }

    public static void sendStartLog2Server(String deviceCode) {
        if ("1".equals(GlobalConstants.getProperty("REPORT_EQUIP_START_LOG"))) {
            if (deviceCode == null || "".equals(deviceCode)) {
                SqlSession sqlSession = MybatisSqlSession.getSqlSession();
                DeviceService deviceService = new DeviceService(sqlSession);
                List<DeviceInfo> deviceInfos = deviceService.getDeviceInfoByClientId(clientId);
                GlobalConstants.stage.deviceInfos = deviceInfos;
                sqlSession.close();
                String clientVersion = getProperty("CLIENT_VERSION") == null ? "" : GlobalConstants.getProperty("CLIENT_VERSION").toString();
                if (deviceInfos != null && !deviceInfos.isEmpty()) {
                    for (DeviceInfo deviceInfo : deviceInfos) {
                        Map mqMap = new HashMap();
                        mqMap.put("msgName", "MqSaveLog");
                        mqMap.put("userId", "System");
                        mqMap.put("eventName", "AppStart");
                        mqMap.put("eventDesc", "工控机软件于" + dateFormat.format(new Date()) + "启动, 工控机编号为" + clientId + " , 版本为" + clientVersion);
                        mqMap.put("deviceCode", deviceInfo.getDeviceCode());
                        C2SLogQueue.sendMessage(mqMap);
                        sysLogger.info("工控机软件启动上报服务端, 工控机编号为" + clientId + " ,设备编号为" + deviceInfo.getDeviceCode());
                    }
                }
            } else {
                Map mqMap = new HashMap();
                mqMap.put("msgName", "MqSaveLog");
                mqMap.put("userId", "System");
                mqMap.put("deviceCode", deviceCode);
                mqMap.put("eventName", "CommRestart");
                mqMap.put("eventDesc", "客户端设备于" + dateFormat.format(new Date()) + "自动重连");
                sysLogger.info("客户端设备自动重连上报服务端，设备编号为" + deviceCode);
                C2SLogQueue.sendMessage(mqMap);
            }
        }

    }
}
