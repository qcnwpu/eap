/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tzauto.octopus.common.rabbit.handlers;

import cn.tzauto.generalDriver.exceptions.*;
import cn.tzauto.octopus.biz.device.domain.DeviceInfo;
import cn.tzauto.octopus.biz.device.service.DeviceService;
import cn.tzauto.octopus.common.dataAccess.base.mybatisutil.MybatisSqlSession;
import cn.tzauto.octopus.common.globalConfig.GlobalConstants;
import cn.tzauto.octopus.common.util.tool.JsonMapper;
import cn.tzauto.octopus.secsLayer.exception.UploadRecipeErrorException;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author luosy
 */
public class SpecificDataTransferHandler implements MessageHandler {

    private static final Logger logger = Logger.getLogger(SpecificDataTransferHandler.class);
    private String deviceCode = "";
    private Map<String, String> dataIdMap = null;

    @Override
    public void handle(HashMap<String, String> msgMap) throws IOException, HsmsProtocolNotSelectedException, T6TimeOutException, BrokenProtocolException, T3TimeOutException, ItemIntegrityException, StreamFunctionNotSupportException, MessageDataException, InterruptedException {
        SqlSession sqlSession = MybatisSqlSession.getSqlSession();
        try {
            deviceCode = msgMap.get("deviceCode");
            String idList = msgMap.get("dataIdList");
            dataIdMap = (HashMap<String, String>) JsonMapper.fromJsonString(idList, HashMap.class);
            logger.info("服务端请求获取设备[" + deviceCode + "]的指定数据，数据ID:" + JsonMapper.toJsonString(dataIdMap));
            DeviceService deviceService = new DeviceService(sqlSession);
            DeviceInfo deviceInfo = deviceService.selectDeviceInfoByDeviceCode(deviceCode);
            Map resultMap = GlobalConstants.stage.hostManager.getSpecificData(deviceInfo.getDeviceCode(), dataIdMap);
            Map mqMap = new HashMap();
            String resultMapString = "";
            if (resultMap != null) {
                if (dataIdMap.size() > resultMap.size()) {
                    resultMapString = JsonMapper.toJsonString(resultMap);
                    logger.info("设备 " + deviceCode + " 部分数据ID无法取值,需要逐个测试");
                } else {
                    resultMapString = JsonMapper.toJsonString(resultMap);
                    mqMap.put("eventDesc", "获取到设备的数据");
                }
            } else {
                mqMap.put("eventDesc", "从设备数据失败，请重试！");
            }
            mqMap.put("SpecificData", resultMapString);

//            GlobalConstants.C2SSpecificDataQueue.sendMessage(mqMap);
            if (msgMap.containsKey("replyQ")) {
                GlobalConstants.C2SSpecificDataQueue.replyMessage(msgMap.get("replyQ"), msgMap.get("correlationId"), mqMap);
            }
            logger.info("向服务端发送获取到的数据:[" + resultMapString + "]");
        } catch (UploadRecipeErrorException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}