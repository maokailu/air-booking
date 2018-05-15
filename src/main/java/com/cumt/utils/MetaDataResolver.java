package com.cumt.utils;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2018-05-15.
 */
public class MetaDataResolver implements HandlerMethodArgumentResolver  {
    private static final String TRANSACTION_ID = "TRANSACTION-ID";
    private static final String ACCESS_KEY = "ACCESS-KEY";
    private List<String> metaDataHeaderNames = Arrays.asList(TRANSACTION_ID, ACCESS_KEY);

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(MetaData.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HashMap<String, String> map = new HashMap<>();
        metaDataHeaderNames.forEach(name -> {
            if (webRequest.getHeader(name) != null) {
                map.put(name, webRequest.getHeader(name));
            }
        });
        return new MetaData(map);
    }
}
