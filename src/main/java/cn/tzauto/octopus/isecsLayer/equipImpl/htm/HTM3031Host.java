package cn.tzauto.octopus.isecsLayer.equipImpl.htm;

import cn.tzauto.octopus.biz.recipe.domain.Recipe;
import cn.tzauto.octopus.common.util.tool.JsonMapper;
import cn.tzauto.octopus.isecsLayer.domain.EquipModel;
import cn.tzauto.octopus.secsLayer.util.GlobalConstant;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HTM3031Host extends EquipModel {

    private Logger logger = Logger.getLogger(HTM3031Host.class.getName());

    public HTM3031Host(String devId, String remoteIpAddress, int remoteTcpPort, String deviceType, String iconPath, String equipRecipePath) {
        super(devId, remoteIpAddress, remoteTcpPort, deviceType, iconPath, equipRecipePath);
        MDC.put(GlobalConstant.WHICH_EQUIPHOST_CONTEXT, devId);
    }

    @Override
    public String getCurrentRecipeName() {
        synchronized (iSecsHost.iSecsConnection.getSocketClient()){
            try{
                List<String> result = iSecsHost.executeCommand("curscreen");
                if (!result.isEmpty()&& null != result){
                    if ("main".equals(result.get(0))){
                        ppExecName = iSecsHost.executeCommand("read recipename").get(0);
                    }
                }
            }catch (Exception e){
                logger.error("Get equip ExecName error:" + e.getMessage());
            }
        }
        Map map = new HashMap();
        map.put("PPExecName", ppExecName);
        changeEquipPanel(map);
        return ppExecName;
    }


    @Override
    public String startEquip() {
        return null;
    }

    @Override
    public String pauseEquip() {
        return null;
    }

    @Override
    public String stopEquip() {
        return null;
    }

    @Override
    public String lockEquip() {
        return null;
    }

    @Override
    public Map uploadRecipe(String recipeName) {
        return null;
    }

    @Override
    public String downloadRecipe(Recipe recipe) {
        return null;
    }

    @Override
    public String deleteRecipe(String recipeName) {
        return null;
    }

    @Override
    public String selectRecipe(String recipeName) {
        return null;
    }

    @Override
    public Map getEquipMonitorPara() {
        return null;
    }

    @Override
    public Map getEquipRecipeList() {
        return null;
    }

    @Override
    public String getEquipStatus() {
        synchronized (iSecsHost.iSecsConnection.getSocketClient()){
            try{
                List<String> result = iSecsHost.executeCommand("curscreen");
                if (!result.isEmpty()&&null!=result){
                    if ("main".equals(result.get(0))){
                        List<String> result1 = iSecsHost.executeCommand("readrectcolor 1022 190 1083 210");  //自动运行
                        logger.info("color read result : " + JsonMapper.toJsonString(result1));
                            if ("0x8000".equals(result1)){
                                equipStatus = "Run";
                            }else if ("0xff".equals(result1)){
                                equipStatus = "Idle";
                            }
                        }
                    }
            }catch (Exception e){
                logger.error("Get equip status error:" + e.getMessage());
            }
        }
        Map map = new HashMap();
        map.put("EquipStatus", equipStatus);
        changeEquipPanel(map);
        return equipStatus;
    }


    @Override
    public Object clone() {
        HTM3031Host newHost = new HTM3031Host(deviceId, remoteIPAddress,remoteTCPPort,deviceType,iconPath,equipRecipePath);
        newHost.startUp = startUp;
        this.clear();
        return  newHost;
    }

    @Override
    public List<String> getEquipAlarm() {
      return null;
    }

    @Override
    public boolean startCheck() {
        return true;
    }
}
