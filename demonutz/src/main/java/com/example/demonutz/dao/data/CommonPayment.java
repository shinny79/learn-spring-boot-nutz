/**
 * @(#)CommonPaymentWritable, 2018/2/26.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.demonutz.dao.data;

import com.example.demonutz.utils.CommonUtils;

/**
 * @authoer hzdongxiani
 */
public class CommonPayment extends AbstractPayment {

    public static final int PLATFORM_EPAY = 1; /*银联 走的网易宝接口*/
    public static final int PLATFORM_ITUNE = 2; /*ios支付*/
    public static final int PLATFORM_WECHAT = 3; /*微信支付*/
    public static final int PLATFROM_ALI_EPAY = 4; /*支付宝 走的网易宝接口*/

    private String authority;
    private String serviceType;
    private double discount;

    /**
     * 直减金额
     */
    private double offPrice;

    /**
     * 发票id
     */
    private String invoiceId;

    /**
     * 经销商id
     */
    private long businessId;
    private static String PARAM_TEAM_GROUP_PROMOTION = "teamGroupCode";
    public static String PARAM_VENDOR_USER = "vendorUser";
    public static String PARAM_VERNDOR_SUFFIX_ID = "vendorSuffixId";

    public CommonPayment(String userId, String authority) {
        this.userId = userId;
        this.authority = authority;
        this.id = CommonUtils.generateFileId();
    }

    public CommonPayment() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setOffPrice(double offPrice) {
        this.offPrice = offPrice;
    }

    public double getOffPrice() {
        return offPrice;
    }

    public void setInvoiceId(long invoiceId) {
        this.invoiceId = String.valueOf(invoiceId);
    }

    public long getInvoiceId() {
        return Long.parseLong(invoiceId);
    }

    @Override
    public double calculateTotalFee() {
        return getBase() * amount * discount - offPrice;
    }


    public long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(long businessId) {
        this.businessId = businessId;
    }

    public String getTGCode() {
        return getProperty(PARAM_TEAM_GROUP_PROMOTION, "");
    }

    public void setTGCode(String code) {
        setProperty(PARAM_TEAM_GROUP_PROMOTION, code);
    }

    public void setBusinessSuffixId(String suffixId) {
        setProperty(PARAM_VERNDOR_SUFFIX_ID, suffixId);
    }

    public String getBusinessSuffixId() {
        return getProperty(PARAM_VERNDOR_SUFFIX_ID, "");
    }
}
