package com.gestion.pagination;

import org.springframework.data.domain.Page;
import java.util.List;

public class PageRender<T>{

    private String url;
    private Page<T> page;
    private int totalPage;
    private int numberOfElementPage;
    private int actualPage;
    private List<PageItem> pages;
}
