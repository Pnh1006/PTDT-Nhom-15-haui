package com.haui.ptda.response;

public class PageElement {
    int pageIndex;
    boolean currentPage;

    public PageElement(){}

    public PageElement(int pageIndex, boolean currentPage) {
        this.pageIndex = pageIndex;
        this.currentPage = currentPage;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public boolean isCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(boolean currentPage) {
        this.currentPage = currentPage;
    }
}
