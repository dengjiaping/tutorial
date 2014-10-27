/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) ImageProp.java 2014-10-27 16:41
 */

package com.nonobank.user.domain.ext.common;

import java.io.Serializable;

/**
 * @author Yichuan
 * @version $Id: ImageProp.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public class ImageProp implements Serializable {

    private static final long serialVersionUID = -6898626187348318036L;

    private String name;
    private String path;
    private Integer width;
    private Integer height;
    private boolean dynamic;

    public ImageProp() {
        super();
    }

    public ImageProp(String name, String path, Integer width,
                     Integer height, boolean dynamic) {
        this.name = name;
        this.path = path;
        this.width = width;
        this.height = height;
        this.dynamic = dynamic;
    }

    public static ImageProp create(String name, String path, Integer width,
                                         Integer height, boolean dynamic) {
        return new ImageProp(name, path, width, height, dynamic);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public boolean isDynamic() {
        return dynamic;
    }

    public void setDynamic(boolean dynamic) {
        this.dynamic = dynamic;
    }
}
