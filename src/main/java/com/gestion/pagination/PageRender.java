package com.gestion.pagination;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class PageRender<T>{

    private String url;
    private Page<T> page;
    private int totalPage;
    private int numberOfElementPage;
    private int actualPage;
    private List<PageItem> pages;

    private PageRender(String url, Page<T> page) {
        this.url = url;
        this.page = page;
        this.pages = new ArrayList<PageItem>();

        numberOfElementPage = 5;
        totalPage = page.getTotalPages();
        actualPage = page.getNumber();

        int from, to;

        if (totalPage <= numberOfElementPage) {

            from = 1;
            to = totalPage;
        } else {
            if (actualPage <= numberOfElementPage/2) {

                from = 1;
                to = numberOfElementPage;
            } else if (actualPage >= totalPage - numberOfElementPage/2) {

                from = totalPage - numberOfElementPage + 1;
                to = numberOfElementPage;
            }
            else {
                from = actualPage - numberOfElementPage/2;
                to = numberOfElementPage;
            }
        }
        for (int i = 0; i < from; i++) {
            pages.add(new PageItem(from + 1, actualPage == from + i));
        }
    }
}