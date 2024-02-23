package com.chunlin.cloud.common.constant;
/**
 * 通用常量
 */
public interface Constants {

    int KB = 1024;

    int MB = KB * 1024;

    int GB = MB * 1024;

    String HTTP = "http://";

    String HTTPS = "https://";
    /**
     * 资源映射路径前缀
     */
    String RESOURCE_PREFIX = "profile";

    interface Token {

        /**
         * 令牌前缀
         */
        String PREFIX = "Bearer ";

        /**
         * 令牌前缀
         */
        String LOGIN_USER_KEY = "login_user_key";

    }

    interface Captcha {

        /**
         * 验证码类型：数字
         */
        String MATH_TYPE = "math";

        /**
         * 验证码类型：字符
         */
        String CHAR_TYPE = "char";

    }

    interface UploadSubDir {

        String IMPORT_PATH = "import";

        String AVATAR_PATH = "avatar";

        String DOWNLOAD_PATH = "download";

        String UPLOAD_PATH = "upload";

    }

}
