package hw_API.service;

import hw_API.utils.ConfigProperties;

public class URI {

    public static final String BASE_URI = ConfigProperties.getProperties("URI");
    public static final String CHECK_TEXT = "/checkText";
    public static final String CHECK_TEXTS = "/checkTexts";
}

