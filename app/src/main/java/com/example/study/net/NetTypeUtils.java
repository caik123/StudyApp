package com.example.study.net;

/**
 * @author GhostKang
 * @description:
 * @date :2020/5/29 17:17
 */
public class NetTypeUtils {
    @NetType
    private String type;

    public void setType(@NetType String type) {
        this.type = type;
    }

    @NetType
    public String getType() {
        return this.type;
    }
}
