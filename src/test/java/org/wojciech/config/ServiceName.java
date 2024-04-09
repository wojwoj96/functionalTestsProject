package org.wojciech.config;

import static java.lang.String.format;

public class ServiceName {

    public static final String POST_TOKEN_URL = "";
    public static final String APP_BASE_URL = "https://automationexercise.com/api/";
    public static final String GET_ALL_PRODUCT = format(APP_BASE_URL, "productsList");
    public static final String BRAND_LIST_URL = format(APP_BASE_URL, "brandsList");
}
