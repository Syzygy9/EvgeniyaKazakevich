package hw_API.service;

import static hw_API.utils.ConfigProperties.getProperties;

public class URI {

    public static final String CHECK_TEXT = "/checkText";
    public static final String CHECK_TEXTS = "/checkTexts";
    public static final String BASE_URI = getProperties().getProperty ("URI");
}

