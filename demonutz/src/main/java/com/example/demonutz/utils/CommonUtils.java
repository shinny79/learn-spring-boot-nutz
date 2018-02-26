package com.example.demonutz.utils;/**
 * @(#)CommonUtils, 2018/2/26.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.UUID;

/**
 * @authoer hzdongxiani
 */
public class CommonUtils {

    /**
     * Random a fileid composed by number and letter(a-z,A-Z),
     * the length of the fileid string would be 10
     *
     * @return Random FileId
     */
    public static String generateFileId() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-", "").toUpperCase();
    }
}
