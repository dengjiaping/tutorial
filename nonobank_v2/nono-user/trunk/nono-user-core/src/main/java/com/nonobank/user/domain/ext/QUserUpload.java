/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) QUserUpload.java 2014-10-20 17:04
 */

package com.nonobank.user.domain.ext;

import com.mysema.query.sql.PrimaryKey;
import com.mysema.query.types.Path;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.PathMetadataFactory;
import com.mysema.query.types.path.DateTimePath;
import com.mysema.query.types.path.EnumPath;
import com.mysema.query.types.path.NumberPath;
import com.mysema.query.types.path.StringPath;
import com.nonobank.data.domain.QAbstractRecording;
import com.nonobank.user.domain.ext.common.UploadAuditStatus;
import org.joda.time.DateTime;

import javax.annotation.Generated;

import static com.mysema.query.sql.ColumnMetadata.named;
import static com.nonobank.user.domain.ext.UserUpload.*;
import static java.sql.Types.*;

/**
 * QUserUpload is a Querydsl query type for UserUpload
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QUserUpload extends QAbstractRecording<UserUpload> {

    public static final String USER_UPLOAD_TABLE = "USER_UPLOAD";

    public static final QUserUpload quu = new QUserUpload("uu");

    public final NumberPath<Long> id = createNumber(PROP_ID, Long.class);

    public final NumberPath<Long> userId = createNumber(PROP_USER_ID, Long.class);

    public final NumberPath<Long> uploadTypeId = createNumber(PROP_UPLOAD_TYPE_ID, Long.class);

    public final StringPath uploadTitle = createString(PROP_UPLOAD_TITLE);

    public final StringPath uploadContent = createString(PROP_UPLOAD_CONTENT);

    public final EnumPath<UploadAuditStatus> auditStatus = createEnum(PROP_AUDIT_STATUS, UploadAuditStatus.class);

    public final DateTimePath<DateTime> auditTime = createDateTime(PROP_AUDIT_TIME, DateTime.class);

    public final NumberPath<Long> operatorId = createNumber(PROP_OPERATOR_ID, Long.class);

    public final StringPath operatorName = createString(PROP_OPERATOR_NAME);

    public final NumberPath<Long> assignerId = createNumber(PROP_ASSIGNER_ID, Long.class);

    public final StringPath assignerName = createString(PROP_ASSIGNER_NAME);

    public final DateTimePath<DateTime> assignTime = createDateTime(PROP_ASSIGN_TIME, DateTime.class);

    public final StringPath remarks = createString(PROP_REMARKS);

    public final PrimaryKey<UserUpload> primary = createPrimaryKey(id);

    public QUserUpload(String variable) {
        super(UserUpload.class, PathMetadataFactory.forVariable(variable), "public", USER_UPLOAD_TABLE);
        addMetadatas();
    }

    public QUserUpload(Path<? extends UserUpload> path) {
        super((Class)path.getType(), path.getMetadata(), "public", USER_UPLOAD_TABLE);
        addMetadatas();
    }

    public QUserUpload(PathMetadata<?> metadata) {
        super(UserUpload.class, metadata, "public", USER_UPLOAD_TABLE);
        addMetadatas();
    }

    public QUserUpload(String variable, String schema, String table) {
        super(UserUpload.class, variable, schema, table);
    }

    public void addMetadatas() {
        addMetadata(id, named("ID").ofType(BIGINT));
        addMetadata(userId, named("USER_ID").ofType(BIGINT));
        addMetadata(uploadTypeId, named("UPLOAD_TYPE_ID").ofType(BIGINT));
        addMetadata(uploadTitle, named("UPLOAD_TITLE").ofType(VARCHAR).withSize(50));
        addMetadata(uploadContent, named("UPLOAD_CONTENT").ofType(VARCHAR).withSize(500));
        addMetadata(auditStatus, named("AUDIT_STATUS").ofType(TINYINT).withSize(2));
        addMetadata(auditTime, named("AUDIT_TIME").ofType(TIMESTAMP));
        addMetadata(operatorId, named("OPERATOR_ID").ofType(BIGINT));
        addMetadata(operatorName, named("OPERATOR_NAME").ofType(VARCHAR).withSize(50));
        addMetadata(assignerId, named("ASSIGNER_ID").ofType(BIGINT));
        addMetadata(assignerName, named("ASSIGNER_NAME").ofType(VARCHAR).withSize(50));
        addMetadata(assignTime, named("ASSIGN_TIME").ofType(TIMESTAMP));
        addMetadata(remarks, named("REMARKS").ofType(VARCHAR).withSize(500));

        addRecordingMetadata();
    }
}
