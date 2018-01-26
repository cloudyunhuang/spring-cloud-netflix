package org.springframework.cloud.netflix.eureka.server;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:TingLiu
 * @create 2018-01-25 下午4:29
 **/
public class RegisterMetadata {

    private Map<String, String> metadata;

    private static final String PROVIDER_PRE = "P_";
    private static final String CONSUMER_PRE = "C_";

    public RegisterMetadata() {
        metadata = new HashMap<>();
    }

    public RegisterMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    public String providerPut(String k, String v) {
        return metadata.put(PROVIDER_PRE + k, v);
    }

    public String providerGet(String k) {
        return metadata.get(PROVIDER_PRE + k);
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

    public Map<String, String> toMap() {
        return metadata;
    }


    public Map<String, String> toProviderMap() {
        return toMap(PROVIDER_PRE);
    }

    public Map<String, String> toConsumerMap() {
        return toMap(CONSUMER_PRE);
    }

    private Map<String, String> toMap(String pre) {
        Map<String, String> tMap = new HashMap<>();
        for (Map.Entry<String, String> entry : metadata.entrySet()) {
            if (entry.getKey() != null) {
                if (entry.getKey().startsWith(pre)) {
                    String key = entry.getKey().substring(pre.length(), entry.getKey().length());
                    tMap.put(key, entry.getValue());
                }

            }
        }
        return tMap;
    }


}
