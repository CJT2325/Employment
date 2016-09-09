package com.cjt.employment.bean;

import com.bigkoo.pickerview.model.IPickerViewData;

/**
 * 作者: 陈嘉桐 on 2016/9/9
 * 邮箱: 445263848@qq.com.
 */
public class PickerViewData implements IPickerViewData {
    private String content;

    public PickerViewData(String content) {
        this.content = content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String getPickerViewText() {
        return content;
    }
}
