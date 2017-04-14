package me.myProjects.microservice.core.constant;

/**
 * Created by chendong on 2016/12/21.
 * <p>
 * metric data type
 */
public interface MetricDataType {

    String[] dataTypes = new String[]{"0000", "0100", "0200", "0500", "0600", "1000", "1100","1200", "1300",
            "1400", "2000", "2100", "2200", "2300", "2400"};
}

/**
 *
 BROWSER_CONNECT("0000", "BrowserConnect", Platform.PC, "web会话请求"),
 BROWSER_RESOURCE("0100", "BrowserResource", Platform.PC, "web http资源"),
 BROWSER_PAGE_LOAD("0200", "BrowserPageLoad", Platform.PC, "web 页面性能"),
 BROWSER_XHR("0500", "BrowserXHR", Platform.PC),
 BROWSER_ERROR("0600", "BrowserError", Platform.PC),
 ANDROID_CONNECT("1000", "AndroidConnect", Platform.ANDROID),
 ANDROID_PERFORMANCE("1100", "AndroidPerformance", Platform.ANDROID),
 ANDROID_EXCEPTION("1200", "AndroidException", Platform.ANDROID),
 ANDROID_ANR("1300", "AndroidANR", Platform.ANDROID),
 ANDROID_CRASH("1400", "AndroidCrash", Platform.ANDROID),
 IOS_CONNECT("2000", "IOSConnect", Platform.IOS),
 IOS_PERFORMANCE("2100", "IOSPerformance", Platform.IOS),
 IOS_EXCEPTION("2200", "IOSException", Platform.IOS),
 IOS_ANR("2300", "IOSANR", Platform.IOS),
 IOS_CRASH("2400", "IOSCrash", Platform.IOS),
 *
 */