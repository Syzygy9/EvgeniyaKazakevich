package hw_API.service;

import com.google.gson.Gson;
import hw_API.builder.InputParameters;
import hw_API.dto.DTO;

import java.util.HashMap;
import java.util.Map;

import static hw_API.enums.YandexSpellerParams.*;
import static hw_API.service.URI.*;

public class YandexSpellerMethods {

    public DTO[] getCheckText(InputParameters request) {
        Map<String, Object> params = new HashMap<>();
        params.put(PARAM_TEXT, request.getText());
        params.put(PARAM_LANG, request.getLang());
        params.put(PARAM_OPTIONS, request.getOptions());

        return new Gson().fromJson(new YandexSpellerService()
                .getWithParams(CHECK_TEXT, params)
                .getBody().asString(), DTO[].class);
    }

    public DTO[][] getCheckTexts(String[] texts) {
        Map<String, Object> params = new HashMap<>();
        params.put(PARAM_TEXT, texts);

        return new Gson().fromJson(new YandexSpellerService()
                .getWithParams(CHECK_TEXTS, params)
                .getBody().asString(), DTO[][].class);
    }
}