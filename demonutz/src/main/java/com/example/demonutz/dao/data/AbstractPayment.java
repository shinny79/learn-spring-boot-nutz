package com.example.demonutz.dao.data;/**
 * @(#)AbstractPayment, 2018/2/26.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @authoer hzdongxiani
 */
public abstract class AbstractPayment {

    // statuses of the payment
    public static final int STATUS_CREATED = 1;
    public static final int STATUS_PAYED = 2;
    public static final int STATUS_REFUNDED = 3;
    public static final int STATUS_CANCELLED = 4;

    private static final String PARAM_API_VERSION = "av";

    protected String id;

    protected String userId;

    protected long orderTime;

    protected long payTime;

    protected long refundTime;

    protected long cancelTime;

    protected int status;

    protected int amount;

    protected double base;

    /**
     * {@link #serviceStartTime} and {@link #serviceEndTime} are calculated
     * after the {@link #status} changed to {@link #STATUS_PAYED}
     */
    protected long serviceStartTime;
    protected long serviceEndTime;

    /**
     * The platform of the payment. eg, EPay, iTune.
     * < 0 : 通过非购买渠道获得
     *   = -1: serverManager 后台设置
     *   = -2: vipActivity  vip活动
     *   = -3: vipCode  vip兑换码
     *   = -4: userPromption 用户推广活动
     *   = -5: vip 推广活动，7天免费试用
     *   = -6: ios 免费试用用户 14天试用
     *   = -7: 微博激励活动
     *   = -8: ios免费试用用户
     */
    protected int payPlatform;

    protected String properties;

    protected Map<String, String> prop = new HashMap<>();

    protected static ObjectMapper om = new ObjectMapper();

    public int getPayPlatform() {
        return payPlatform;
    }

    public void setPayPlatform(int payPlatform) {
        this.payPlatform = payPlatform;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getBase() {
        return base;
    }

    /**
     * NOTE: set base as the original price subtract offPrice
     */
    public void setBase(double base) {
        this.base = base;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public long getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(long orderTime) {
        this.orderTime = orderTime;
    }

    public long getPayTime() {
        return payTime;
    }

    public void setPayTime(long payTime) {
        this.payTime = payTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(long refundTime) {
        this.refundTime = refundTime;
    }

    public long getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(long cancelTime) {
        this.cancelTime = cancelTime;
    }

    public abstract double calculateTotalFee();

    public long getServiceStartTime() {
        return serviceStartTime;
    }

    public void setServiceStartTime(long serviceStartTime) {
        this.serviceStartTime = serviceStartTime;
    }

    public long getServiceEndTime() {
        return serviceEndTime;
    }

    public void setServiceEndTime(long serviceEndTime) {
        this.serviceEndTime = serviceEndTime;
    }

    public String getProperties() {
        if (prop.size() != 0) {
            try {
                properties = om.writeValueAsString(prop);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        properties = properties == null ? "" : properties;
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
        if (!StringUtils.isEmpty(properties)) {
            try {
                prop = om.readValue(properties,
                        new TypeReference<Map<String, String>>() {
                        });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getProperty(String key, String value) {
        return prop.getOrDefault(key, value);
    }

    public void setProperty(String key, String value) {
        this.prop.put(key, value);
    }

    public void setApiVersion(String apiVersion) {
        setProperty(PARAM_API_VERSION, apiVersion);
    }

    public String getApiVersion() {
        return getProperty(PARAM_API_VERSION, "");
    }
}
