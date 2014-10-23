/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) QUserUploadItem.java 2014-10-20 15:47
 */

package com.nonobank.user.domain.ext;

import com.mysema.query.sql.PrimaryKey;
import com.mysema.query.sql.RelationalPathBase;
import com.mysema.query.types.Path;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.path.DateTimePath;
import com.mysema.query.types.path.NumberPath;
import com.mysema.query.types.path.StringPath;
import org.joda.time.DateTime;

import javax.annotation.Generated;

import static com.mysema.query.sql.ColumnMetadata.named;
import static com.mysema.query.types.PathMetadataFactory.forVariable;
import static com.nonobank.user.domain.ext.UserUploadItem.*;
import static java.sql.Types.*;

/**
 * QUserUploadItem is a Querydsl query type for UserUploadItem
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QUserUploadItem extends RelationalPathBase<UserUploadItem> {

    public static final String USER_UPLOAD_ITEM = "USER_UPLOAD_ITEM";

    public static final QUserUploadItem quui = new QUserUploadItem("uui");

    public final NumberPath<Long> id = createNumber(PROP_ID, Long.class);

    public final NumberPath<Long> uploadId = createNumber(PROP_UPLOAD_ID, Long.class);

    public final StringPath fileName = createString(PROP_FILE_NAME);

    public final StringPath fileType = createString(PROP_FILE_TYPE);

    public final StringPath fileUrl = createString(PROP_FILE_URL);

    public final NumberPath<Integer> fileSize = createNumber(PROP_FILE_SIZE, Integer.class);

    public final StringPath fileDesc = createString(PROP_FILE_DESC);

    public final DateTimePath<DateTime> createdDate = createDateTime(PROP_CREATED_DATE, DateTime.class);

    public final PrimaryKey<UserUploadItem> primary = createPrimaryKey(id);

    public QUserUploadItem(String variable) {
        super(UserUploadItem.class, forVariable(variable), "public", USER_UPLOAD_ITEM);
        addMetadatas();
    }

    public QUserUploadItem(Path<? extends UserUploadItem> path) {
        super((Class)path.getType(), path.getMetadata(), "public", USER_UPLOAD_ITEM);
        addMetadatas();
    }

    public QUserUploadItem(PathMetadata<?> metadata) {
        super(UserUploadItem.class, metadata, "public", USER_UPLOAD_ITEM);
        addMetadatas();
    }

    public QUserUploadItem(String variable, String schema, String table) {
        super(UserUploadItem.class, variable, schema, table);
    }

    public void addMetadatas() {
        addMetadata(id, named("ID").ofType(BIGINT));
        addMetadata(uploadId, named("UPLOAD_ID").ofType(BIGINT));
        addMetadata(fileName, named("FILE_NAME").ofType(VARCHAR).withSize(100));
        addMetadata(fileType, named("FILE_TYPE").ofType(VARCHAR).withSize(50));
        addMetadata(fileUrl, named("FILE_URL").ofType(VARCHAR).withSize(100));
        addMetadata(fileSize, named("FILE_SIZE").ofType(INTEGER));
        addMetadata(fileDesc, named("FILE_DESC").ofType(VARCHAR).withSize(200));
        addMetadata(createdDate, named("CREATED_DATE").ofType(TIMESTAMP));
    }
}