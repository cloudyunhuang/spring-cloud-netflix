package org.springframework.cloud.netflix.eureka.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:TingLiu
 * @create 2018-01-25 下午4:29
 **/
public class RegisterMetadata {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterMetadata.class);
    public static final String CONTEXT_PATH_KEY = "##contextPath_key##";

    private Map<String, String> metadata;

    private static final String PROVIDER_PRE = "P_";
    private static final String CONSUMER_PRE = "C_";

    private static final String METHOD_PROVIDER_PRE = "M_P_";
    private static final String METHOD_CONSUMER_PRE = "M_C_";


    public RegisterMetadata() {
        metadata = new HashMap<>();
    }

    public RegisterMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    public String contextPathPut(String v) {
        return providerPut(CONTEXT_PATH_KEY, v);
    }

    public String contextPathGet() {
        return providerGet(CONTEXT_PATH_KEY);
    }


    public String providerPut(String k, String v) {
        return metadata.put(PROVIDER_PRE + k, v);
    }

    public String providerGet(String k) {
        return metadata.get(PROVIDER_PRE + k);
    }

    public String providerMethodGet(String k) {
        return metadata.get(METHOD_PROVIDER_PRE + k);
    }

    public boolean providerContainsKey(String k) {
        return metadata.containsKey(PROVIDER_PRE + k);
    }

    public String consumerPut(String k, String v) {
        return metadata.put(CONSUMER_PRE + k, v);
    }

    public String consumerGet(String k) {
        return metadata.get(CONSUMER_PRE + k);
    }

    public String consumerMethodGet(String k) {
        return metadata.get(METHOD_CONSUMER_PRE + k);
    }

    public Map<String, String> toMap() {
        return metadata;
    }


    public Map<String, String> toProviderMap() {
        return toMap(PROVIDER_PRE);
    }

    public Map<String, List<String>> toProviderMethodMap() {
        Map<String, String> map = toMap(METHOD_PROVIDER_PRE);
        return toMap2(map);
    }

    public Map<String, List<String>> toConsumerMethodMap() {
        Map<String, String> map = toMap(METHOD_CONSUMER_PRE);
        return toMap2(map);
    }

    private Map<String, List<String>> toMap2(Map<String, String> map) {
        Map<String, List<String>> result = null;
        if (map != null && !map.isEmpty()) {
            result = new HashMap<>(map.size());
            for (Map.Entry<String, String> e : map.entrySet()) {
                if (e.getKey() != null && !e.getKey().startsWith(CONTEXT_PATH_KEY)) {
                    String v = e.getValue();
                    if (v != null && v.length() != 0) {
                        String[] vArr = v.split(";");
                        if (vArr != null && vArr.length > 0) {
                            result.put(e.getKey(), Arrays.asList(vArr));
                        }
                    }
                }

            }
        }
        return result;
    }


    public Map<String, String> toConsumerMap() {
        return toMap(CONSUMER_PRE);
    }

    private Map<String, String> toMap(String pre) {
        Map<String, String> toMap = new HashMap<>();
        for (Map.Entry<String, String> entry : metadata.entrySet()) {
            if (entry.getKey() != null && entry.getKey().startsWith(pre)) {
                String key = entry.getKey().substring(pre.length(), entry.getKey().length());
                toMap.put(key, entry.getValue());
            }
        }
        return toMap;
    }


}
