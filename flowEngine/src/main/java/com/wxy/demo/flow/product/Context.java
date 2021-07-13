package com.wxy.demo.flow.product;

import java.util.HashMap;
import java.util.Map;

/**
 * 1.创建Context 上下文，作为我们的调用下游服务的返回结果
 * @author wxy
 * @since 7/13/21
 */
public class Context {

    /**
     * 结果缓存
     */
    private Map<String,Object> resultMap = new HashMap<String, Object>();

    public Map<String, Object> getAdaptorMap() {
        return resultMap;
    }

    public void setAdaptorMap(Map<String, Object> adaptorMap) {
        this.resultMap = adaptorMap;
    }
}
