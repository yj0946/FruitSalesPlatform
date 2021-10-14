package com.fruitsalesplatform.entity;

public class PageEntity {
    private Integer mCurrentPage;
    private Integer mStartPage;
    private Integer mPageSize;

    public Integer getCurrentPage() {
        if (mCurrentPage == null) {
            mCurrentPage = 1;
        }
        return mCurrentPage;
    }

    public void setCurrentPage(Integer mCurrentPage) {
        this.mCurrentPage = mCurrentPage;
    }

    public Integer getStartPage() {
        if (mStartPage == null) {
            mStartPage = 0;
        }
        return mStartPage;
    }

    public void setStartPage(Integer mStartPage) {
        this.mStartPage = mStartPage;
    }

    public Integer getPageSize() {
        if (mPageSize == null) {
            mPageSize = 10;
        }
        return mPageSize;
    }

    public void setPageSize(Integer mPageSize) {
        this.mPageSize = mPageSize;
    }
}
