package com.aliergul.socialmedia.constant;

public class RestApiUrl {
    /**
     * Resp Api Servislerinizin versiyonlarını tutmak için kullanın.
     */
    public static final String VERSION = "/v1";

    /**
     * CONTOLLER kısımlarında ki map listesini ayrıca burada yazalım
     */
    public static final String PROFILE = "/profile";
    public static final String USER = "/user";
    public static final String FOLLOW = "/follow";
    public static final String POST = "/post";


    /**
     * GENEL olarak tanımlanan isteklerin burada tanımlayalım
     */
    public static final String SAVE= "/save";
    public static final String UPDATE= "/update";
    public static final String DELETE= "/delete";
    public static final String FINDALL= "/findall";
    public static final String GETALL= "/getall";
    public static final String FINDBYID= "/findbyid";
    public static final String FINDBYNAME= "/findbyname";
    public static final String IS_PROFILE_EXIST_BY_PROFILE_ID= "/isprofileexistbyprofileid";

    /**
     * CONTROLLER için özel olarak tanımladığınız istek url lerini burada tanımlayalım ayrıştırabilirsiniz.
     */

    public static final String FIND_BY_AUTH_ID= "/findbyauthid";
}
