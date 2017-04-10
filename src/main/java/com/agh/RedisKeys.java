package com.agh;

import java.text.MessageFormat;

/**
 * Created by mazh on 2017/2/27.
 */
public class RedisKeys {
    //session keys
    public  static final  String CAS_USER="casUser";

    //redis keys
    //参数顺序 token_uid(主账号ID)_corpId
    private static final String  RIGHTS_LIST_KEY="user_rights_{0}_{1,number,#}_{2,number,#}";

    public static String getRightsListKey(String token,long uid,int corpId){
        return MessageFormat.format(RIGHTS_LIST_KEY,token,uid,corpId);
    }
}
