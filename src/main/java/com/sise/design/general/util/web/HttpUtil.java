package com.sise.design.general.util.web;

import com.sise.design.general.util.content.CharsetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @author:   Chen xuexin
 * @Time:     2019/7/17 22:33
 * @Class:    http
 * @Descript: TODO
 * @Version:  1.0
 */
public class HttpUtil {

    @Autowired
    private static SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
    @Autowired
    private static RestTemplate RestTemplate;
    @Autowired
    private static HttpHeaders  Readers      = new HttpHeaders();

    static {
        // 设置超时
        requestFactory.setConnectTimeout(2000);
        requestFactory.setReadTimeout(2000);
        RestTemplate = new RestTemplate(requestFactory);
    }

    public static String httpGet(String url)  {
        try {
            Readers.setContentType(MediaType.parseMediaType("application/x-www-form-urlencoded; charset=UTF-8"));
            Readers.add("Accept", MediaType.APPLICATION_FORM_URLENCODED.toString());
            HttpEntity<String> formEntity = new HttpEntity<String>(" ", Readers);
            String str = RestTemplate.getForObject(url, String.class,formEntity);
            Readers.clear();
            return CharsetUtil.getString(str, String.valueOf(StandardCharsets.ISO_8859_1));
        }catch (HttpClientErrorException e){
            e.printStackTrace();
            return "404";
        }

    }

    public static String httpPost(String url, Map<String, Object> param) {
        try {
            Readers.setContentType(MediaType.parseMediaType(MediaType.APPLICATION_FORM_URLENCODED.toString() +"; charset=UTF-8"));
            Readers.add("Accept", MediaType.APPLICATION_FORM_URLENCODED.toString());
            HttpEntity<String> formEntity = new HttpEntity<String>("", Readers);
            String str = RestTemplate.postForObject(url, toMultiValueMap(param), String.class,formEntity);
            Readers.clear();
            return CharsetUtil.getString(str,"ISO8859-1");
        }catch (HttpClientErrorException e){
            e.printStackTrace();
            return "404";
        }
    }

    public static String httpPostFileData(String url, String file) {
        try {
            Readers.setContentType(MediaType.parseMediaType(MediaType.APPLICATION_FORM_URLENCODED_VALUE +"; charset=UTF-8"));
            Readers.add("Accept", MediaType.APPLICATION_FORM_URLENCODED_VALUE);
            HttpEntity<String> formEntity = new HttpEntity<String>("", Readers);
            file = new String(file.getBytes(StandardCharsets.UTF_8), "ISO8859-1");
            String str = RestTemplate.postForObject(url, file, String.class,formEntity);
            Readers.clear();
            return CharsetUtil.getString(str,"ISO8859-1");
        }catch (HttpClientErrorException | UnsupportedEncodingException e){
            e.printStackTrace();
            return "";
        }
    }

    private static MultiValueMap toMultiValueMap(Map<String, Object> map) {
        MultiValueMap<String,Object> multiValueMap = new LinkedMultiValueMap();
        if (map != null) {
            map.forEach((k, v) -> {
                multiValueMap.add(k, v instanceof File ? new FileSystemResource((File)v) : v);
            });
        }
        return multiValueMap;
    }
}
