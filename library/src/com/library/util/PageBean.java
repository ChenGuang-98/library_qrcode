package com.library.util;

import java.util.ArrayList;
import java.util.List;

import com.library.dao.bean.Book;

public class PageBean<T> {

	 private List<T> data; 					// ��ǰҳ����
	 private int firstPage = 1;				// ��ҳ
	 private int prePage; 						// ��һҳ
	 private int nextPage;					// ��һҳ
	 private int totalPage; 					// ĩҳ/��ҳ��
	 private int currentPage; 				// ��ǰҳ
	 private int totalCount; 					// �ܼ�¼��
	 private int pageSize; 					// ÿҳ��ʾ��¼��

	private List<Integer> pageList = new ArrayList();
	
	public PageBean(List<T> data, int totalCount, int currentPage, int pageSize) {
	       this.data = data;
	       this.currentPage = currentPage;
	       this.totalCount = totalCount;
	       this.pageSize = pageSize;
	       
	       this.nextPage = this.currentPage <= this.totalPage ? this.currentPage + 1 : this.totalPage;
	       this.prePage = this.currentPage >= this.firstPage ? this.currentPage - 1 : this.firstPage;
	       
	       this.totalPage = this.totalCount % this.pageSize == 0 ? this.totalCount / this.pageSize : this.totalCount / this.pageSize + 1;
       
	       int size = this.totalPage < 3 ? totalPage : 3;
	       
	       if(this.currentPage <= 2) {
	       	for (int i = 0; i < size; i++) {
	                     this.pageList.add(i+1);
                     }
	       } else if(this.currentPage >= this.totalPage - 1) {
	       	for (int i = 0; i < size; i++) {
	       		this.pageList.add(this.totalPage - 2 + i);
                     }
	       } else {
	       	for (int i = 0; i < size; i++) {
	                     this.pageList.add(this.currentPage - 1 + i);
                     }
	       }
	}
	
	public List<Integer> getPageList() {
       	return pageList;
       }

	public void setPageList(List<Integer> pageList) {
       	this.pageList = pageList;
       }

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	public int getPrePage() {
		return prePage;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
