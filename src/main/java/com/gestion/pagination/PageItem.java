package com.gestion.pagination;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PageItem pageItem = (PageItem) o;
        return number == pageItem.number && actually == pageItem.actually;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, actually);
    }

    @Override
    public String toString() {
        return "PageItem{" +
                "number=" + number +
                ", actually=" + actually +
                '}';
    }
}
