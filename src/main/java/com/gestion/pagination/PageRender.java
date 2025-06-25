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

    public PageRender(String url, Page<T> page) {
        this.url = url;
        this.page = page;
        this.pages = new ArrayList<>();

        this.numberOfElementPage = 5;
        this.totalPage = page.getTotalPages();
        this.actualPage = page.getNumber() + 1; // Ajuste: ahora es 1-based

        int from, to;

        if (totalPage <= numberOfElementPage) {
            from = 1;
            to = totalPage;
        } else {
            if (actualPage <= numberOfElementPage / 2) {
                from = 1;
                to = numberOfElementPage;
            } else if (actualPage >= totalPage - numberOfElementPage / 2) {
                from = totalPage - numberOfElementPage + 1;
                to = totalPage;
            } else {
                from = actualPage - numberOfElementPage / 2;
                to = actualPage + numberOfElementPage / 2;
            }
        }

        // Generar los números de página correctamente
        for (int i = from; i <= to; i++) {
            boolean isActual = (i == actualPage);
            pages.add(new PageItem(i, isActual));
        }
    }
    public boolean isLast() {
        return page.isLast();
    }

    public boolean isHasNext() {
        return page.hasNext();
    }

    public boolean isHasPrevious() {
        return page.hasPrevious();
    }

    public boolean isFirst() {
        return page.isFirst();
    }
}