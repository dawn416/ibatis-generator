/**
 * Copyright(C) 2017 Zhejiang Fline Technology Co., Ltd. All rights reserved.
 *
 */
package com.fline.generator.core;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fline.generator.Generator;
import com.fline.generator.bean.TableItem;
import com.fline.generator.util.FreemarkerUtil;
import com.fline.generator.util.JavaFileUtil;
import com.fline.generator.util.StringUtil;

import freemarker.template.TemplateException;

/**
 * @since 2017年12月7日 下午5:54:00
 * @version 1.0.0
 * @author 黎明
 *
 */
public class TemplateManager {
    public static void createXml(TableItem tableItem, String templateName, String path, String finalFileName)
            throws IOException, TemplateException {
        System.out.println("生成" + finalFileName + "文件中。。。");
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("tableItem", tableItem);
        dataMap.put("modelPath", "");
        dataMap.put("alias", StringUtil.uncapitalize(tableItem.getBeanName()));
        if (Generator.customParams != null) {
            dataMap.putAll(Generator.customParams);
        }
        String result = FreemarkerUtil.createFile("", templateName, dataMap);
        JavaFileUtil.createJavaFile(path + File.separator + finalFileName, result);
        System.out.println("生成" + finalFileName + "文件成功");
    }

    private TemplateManager() {
    }
}
