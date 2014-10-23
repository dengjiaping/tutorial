/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) UserUploadType.java 2014-10-20 13:34
 */

package com.nonobank.user.domain.ext;

import com.google.common.base.MoreObjects;
import com.nonobank.data.domain.AbstractRecording;

/**
 * 用户上传类型信息实体
 *
 * @author Yichuan
 * @version $Id: UserUploadType.java 219 2014-10-20 06:48:31Z yichuan $
 * @since 2.0
 */
public class UserUploadType extends AbstractRecording<Long, UserUploadType> {

    public static final String PROP_SCORE_ALLOC_ID = "scoreAllocId";
    public static final String PROP_TYPE_NAME = "typeName";
    public static final String PROP_UPLOAD_NOTE = "uploadNote";
    public static final String PROP_UPLOAD_EXAMPLE = "uploadExample";

    private static final long serialVersionUID = 2091859939268599641L;

    private Long scoreAllocId;
    private String typeName;
    private String uploadNote;
    private String uploadExample;

    public UserUploadType() {
        super();
    }

    public Long getScoreAllocId() {
        return scoreAllocId;
    }

    public void setScoreAllocId(Long scoreAllocId) {
        this.scoreAllocId = scoreAllocId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getUploadNote() {
        return uploadNote;
    }

    public void setUploadNote(String uploadNote) {
        this.uploadNote = uploadNote;
    }

    public String getUploadExample() {
        return uploadExample;
    }

    public void setUploadExample(String uploadExample) {
        this.uploadExample = uploadExample;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add(PROP_SCORE_ALLOC_ID, getScoreAllocId())
                .add(PROP_TYPE_NAME, getTypeName())
                .add(PROP_UPLOAD_NOTE, getUploadNote())
                .add(PROP_UPLOAD_EXAMPLE, getUploadExample())
                .add(PROP_LAST_MODIFIED_DATE, getLastModifiedDate())
                .add(PROP_CREATED_DATE, getCreatedDate()).toString();
    }
}