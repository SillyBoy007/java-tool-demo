package com.wxy.demo.flow.product;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 引擎类
 *
 * @author wxy
 * @since 7/13/21
 */
public class FlowEngine {
    /**
     * 引擎入口
     */

    public void engine(FlowNode flowNode, RunData runData, Context context) throws Exception {
        //Map<String, List<String>> nodeGroup =

    }


    /**
     * 流程中的参数
     */
    public static class RunData {
        private String paramOne;
        private String paramTwo;

        public String getParamOne() {
            return paramOne;
        }

        public void setParamOne(String paramOne) {
            this.paramOne = paramOne;
        }

        public String getParamTwo() {
            return paramTwo;
        }

        public void setParamTwo(String paramTwo) {
            this.paramTwo = paramTwo;
        }
    }


    private Map<String, List<String>> groupByGroupName(FlowNode flowNode) {
        Map<String, List<String>> nodeGroup = new LinkedHashMap<String, List<String>>();

        for (String nodeKey : flowNode.gerNodeList()) {


        }
        return null;
    }


    private String getGroupName(String nodeKey) {
        String[] arr = nodeKey.split("_");
        return arr.length == 2 ? arr[0] : null;
    }

    private String getNodeName(String nodeKey) {
        String[] arr = nodeKey.split("_");
        return arr.length == 2 ? arr[1] : arr[0];
    }

    public static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 10, 60L, TimeUnit.MINUTES,
            new LinkedBlockingDeque<Runnable>(500), new ThreadFactory() {
                @Override
                public Thread newThread(Runnable r) {
                    return null;
            }
            }, new ThreadPoolExecutor.AbortPolicy() {
                @Override
                public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
                  // num.in
                }
             });
}
