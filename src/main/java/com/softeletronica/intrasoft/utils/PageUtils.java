package com.softeletronica.intrasoft.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class PageUtils {
    public static Pageable adjustPageNumber(Pageable pageable) {
        int adjustedPageNumber = pageable.getPageNumber() + 1;
        return PageRequest.of(adjustedPageNumber - 1, pageable.getPageSize(), pageable.getSort());
    }
}
