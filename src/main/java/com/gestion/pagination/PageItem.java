package com.gestion.pagination;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PageItem {

    private int number;

    private boolean actually;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isActually() {
        return actually;
    }

    public void setActually(boolean actually) {
        this.actually = actually;
    }

    public PageItem(int number, boolean actually) {
        this.number = number;
        this.actually = actually;
    }

    public PageItem() {
    }
}
