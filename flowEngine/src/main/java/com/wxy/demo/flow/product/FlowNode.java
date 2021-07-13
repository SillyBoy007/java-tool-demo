package com.wxy.demo.flow.product;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 2.创建流程节点
 * 保存我们整个流程中需要执行下游服务的节点
 * 以Map作为保存数据，NodeConf 节点设置参数，自定义请求服务超时时间（因为并行我们是用的线程池或者通过get设置时间get返回值结果）
 * @author wxy
 * @since 7/13/21
 */
public class FlowNode {

    private Map<String, NodeConf> nodeMap = new LinkedHashMap<String, NodeConf>();

    public void add(String groupName, Class nodeName, NodeConf nodeConf) {
        String key = null;
        if (groupName != null && groupName.length() != 0){
            key = groupName + "_" + nodeName.getName();
        }else {
            key = nodeName.getName();
        }

        if (nodeMap.containsKey(key)){
            return;
        }

        nodeMap.put(key,nodeConf);
    }

    public void add(Class nodeName,NodeConf nodeConf){
        add(nodeName.getName(),nodeName,nodeConf);
    }


    public void replace(String groupName,Class nodeName,NodeConf nodeConf){
        String key = null;
        if (groupName != null && groupName.length() != 0){
            key = groupName + "_" + nodeName.getName();
        }else {
            key = nodeName.getName();
        }
        nodeMap.put(key,nodeConf);

    }


    public void replace(Class nodeName,NodeConf nodeConf){
        replace(nodeName.getName(),nodeName,nodeConf);
    }


    public void remove(String groupName,Class nodeName){
        String key = null;
        if (groupName != null && groupName.length() != 0){
            key = groupName + "_" + nodeName.getName();
        }else {
            key = nodeName.getName();
        }
        nodeMap.remove(key);
    }


    public void remove(Class nodeName){
        remove(nodeName.getName(),nodeName);
    }


    public Set<String> gerNodeList(){
        return nodeMap.keySet();
    }

    public Map<String,NodeConf> getNodeMap(){
        return nodeMap;
    }

    public void setNodeMap(Map<String,NodeConf> map){
        this.nodeMap = map;
    }



    public static class NodeConf {

        private int timeout = 100;

        public NodeConf() {
        }

        public NodeConf(int timeout) {
            this.timeout = timeout;
        }

        public int getTimeout() {
            return timeout;
        }

        public void setTimeout(int timeout) {
            this.timeout = timeout;
        }
    }
}
