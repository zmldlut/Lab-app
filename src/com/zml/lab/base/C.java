package com.zml.lab.base;

public final class C {

    public static final class code {
        public static final int login               = 1000;

    }

    public static final class api {
        public static final String base             = "http://192.168.9.69:8080";
        public static final String login            = "/Lab-demo/pc_app/pc_app_login";
        public static final String operate          = "/Lab-demo/test/test_openDoor";

        
        public static final String notice           = "/Lab-demo/pc_app/pc_app_notice";
    }

    public static final class task {
        public static final int login               = 1000;
        public static final int operate             = 1001;
        
        public static final int notice              = 1004;
    }

    public static final class err {
        public static final String network          = "网络错误";
        public static final String message          = "消息错误";
        public static final String jsonFormat       = "消息格式错误";
    }
}

//.;%JAVA_HOME%\lib\tools.jar;%JAVA_HOME%\lib\dt.jar;%JAVA_HOME%\bin;