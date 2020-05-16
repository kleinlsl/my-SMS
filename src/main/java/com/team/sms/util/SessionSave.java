package com.team.sms.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @project: my-SMS
 * @description: 全局的SessionSaver类，用来存储全局的SessionId静态变量：
 * @author: dell
 * @date: 2020/5/16 - 15:44
 * @version: 1.0
 * @website:
 */
public class SessionSave {
    private static Map<String, String> SessionIdSave = new HashMap<String,String>();

    public static Map<String, String> getSessionIdSave() {
        return SessionIdSave;
    }

    public static void setSessionIdSave(Map<String, String> sessionIdSave) {
        SessionIdSave = sessionIdSave;
    }

    public static void saveLoginSessionId(String userName,String sessionID){
        /**
         * @description: 保存用户最新的sessionId
         * @param: [userName, sessionID]
         * @date: 2020/5/16 - 16:06
         * @return: void
         */
        if (!SessionIdSave.containsKey(userName)) {
            SessionIdSave.put(userName, sessionID);
        }else if(SessionIdSave.containsKey(userName)&&!sessionID.equals(SessionIdSave.get(userName))){
            SessionIdSave.remove(userName);
            SessionIdSave.put(userName, sessionID);
        }
    }
    public static boolean isSessionIdAvailable(String userName,String sessionID){
        /**
         * @description: 判断用户sessionId是否一致
         * @param: [userName, sessionID]
         * @date: 2020/5/16 - 16:06
         * @return: boolean
         */
        return sessionID.equals(SessionIdSave.get(userName));
    }

}
