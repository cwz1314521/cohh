package com.hema.newretail.backstage.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil {

    public static String getStringByDate(Date datetime){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(datetime);
    }

    public static String getStringByDateFormart(Date datetime,String formart){
        SimpleDateFormat dateFormat = new SimpleDateFormat(formart);
        return dateFormat.format(datetime);
    }

    public static Date stringToDate(String datetime,String formart) throws Exception{
        SimpleDateFormat formatter=new SimpleDateFormat(formart);
        return formatter.parse(datetime);
    }

    public static Date threeMonthAgo(Date datetime){
        Calendar c = Calendar.getInstance();
        c.setTime(datetime);
        c.add(Calendar.MONTH, -3);
        return c.getTime();
    }

    /**
     *
     * 功能描述: 时间段转化
     *
     * @param: long
     * @return: String
     * @author: cwz
     * @date: 2018/10/15 9:51
     */
    public static String timeQuantum(Long time){
        StringBuffer times = new StringBuffer();
        if(time !=null){
            Long days = time/(1000*60*60*24);
            Long hours = (time%(1000*60*60*24))/(60*60*1000);
            Long minutes = ((time%(1000*60*60*24))%(60*60*1000))/(60*1000);
            Long seconds = (((time%(1000*60*60*24))%(60*60*1000))%(60*1000))/1000;
            if(days > 0){
                times.append(days).append(" 天 ");
            }
            if(hours > 0){
                times.append(hours).append(" 时 ");
            }
            if(minutes > 0){
                times.append(minutes).append(" 分 ");
            }
            if(seconds > 0){
                times.append(seconds).append(" 秒 ");
            }
            return times.toString();

        }else{
            return null;
        }
    }
}
