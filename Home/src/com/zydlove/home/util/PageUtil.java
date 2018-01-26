package com.zydlove.home.util;

import java.util.List;
@SuppressWarnings("unchecked")
public class PageUtil {
	//当前第几页      
	private String currPageNumStr;
	//总共多少条数据   
	private int totalCount;
	//每页多少条     	 
	private int pageSize =10;
	//总共多少页
	private int totalPageNum;
	//每页数据起始序号
	private int perPageStartNum;
	//每页数据结束序号
	private int perPageEndNum;
	//每页多少个导航码  
	private int navSize=10;
	//首页		   1
	private int firstPageNum=1;
	//末页
	private int endPageNum;
	//上一页
	private int previousPageNum;
	//下一页
	private int nextPageNum;
	//每页导航的起始页码
	private int navPerPageStartNum;
	//每页导航的结束页码
	private int navPerPageEndNum;
	//数据集合 List
	private List list;
	/**
	 * 初始化PageUtil对象 ，并对其他数据进行运算
	 * @param currPageNumStr
	 * @param totalCount  总记录数  查询出来的
	 * @param pageSize
	 */
	public PageUtil(String currPageNumStr, int totalCount, int pageSize) {
		/**
		 * 数据部分属性赋值
		 */
		this.currPageNumStr =(currPageNumStr!=null&&!currPageNumStr.trim().equals(""))?currPageNumStr:"1";
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		//总共多少页
		this.totalPageNum=(totalCount+pageSize-1)/pageSize;
		//currPageNumStr 值从页面获取
		int currPageNum = (currPageNumStr!=null&&!currPageNumStr.trim().equals(""))?Integer.parseInt(currPageNumStr):1;
		//当前页码小与0 就赋值为1  
		currPageNum = (int)Math.max(1, currPageNum);
		//当前页码大于总页码数 取 小值
		currPageNum = (int)Math.min(totalPageNum, currPageNum);
		//每页数据起始序号
		this.perPageStartNum = (currPageNum-1)*pageSize+1;
		//每页数据结束序号
		this.perPageEndNum = perPageStartNum+pageSize-1;
		this.perPageEndNum =  (int)Math.min(totalCount, this.perPageEndNum);
		/**
		 * 导航部分属性赋值
		 */
		this.endPageNum=totalPageNum;
		//上一页
		this.previousPageNum =  (int)Math.max(1, currPageNum-1);
		//下一页
		this.nextPageNum = (int)Math.min(totalPageNum, currPageNum+1);
		if(totalPageNum<=navSize){
			this.navPerPageStartNum =1;
		}else{//11 页
			//每页导航的起始页码  10 5 14 9
			this.navPerPageStartNum = (currPageNum<=navSize/2+1)?1:currPageNum-navSize/2;
			if(totalPageNum-navPerPageStartNum<navSize-1){
				this.navPerPageStartNum = totalPageNum-navSize+1;
			}
		}
		//每页导航的结束页码
		this.navPerPageEndNum = navPerPageStartNum+navSize-1;
		this.navPerPageEndNum =  (int)Math.min(totalPageNum, this.navPerPageEndNum);
	}
	public int getNavPerPageStartNum() {
		return navPerPageStartNum;
	}

	public void setNavPerPageStartNum(int navPerPageStartNum) {
		this.navPerPageStartNum = navPerPageStartNum;
	}

	public int getNavPerPageEndNum() {
		return navPerPageEndNum;
	}

	public void setNavPerPageEndNum(int navPerPageEndNum) {
		this.navPerPageEndNum = navPerPageEndNum;
	}

	public String getCurrPageNumStr() {
		return currPageNumStr;
	}
	public void setCurrPageNumStr(String currPageNumStr) {
		this.currPageNumStr = currPageNumStr;
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
	public int getPerPageStartNum() {
		return perPageStartNum;
	}
	public void setPerPageStartNum(int perPageStartNum) {
		this.perPageStartNum = perPageStartNum;
	}
	public int getPerPageEndNum() {
		return perPageEndNum;
	}
	public void setPerPageEndNum(int perPageEndNum) {
		this.perPageEndNum = perPageEndNum;
	}
	public int getTotalPageNum() {
		return totalPageNum;
	}
	public void setTotalPageNum(int totalPageNum) {
		this.totalPageNum = totalPageNum;
	}
	public int getNavSize() {
		return navSize;
	}
	public void setNavSize(int navSize) {
		this.navSize = navSize;
	}
	public int getFirstPageNum() {
		return firstPageNum;
	}
	public void setFirstPageNum(int firstPageNum) {
		this.firstPageNum = firstPageNum;
	}
	public int getEndPageNum() {
		return endPageNum;
	}
	public void setEndPageNum(int endPageNum) {
		this.endPageNum = endPageNum;
	}
	public int getPreviousPageNum() {
		return previousPageNum;
	}
	public void setPreviousPageNum(int previousPageNum) {
		this.previousPageNum = previousPageNum;
	}
	public int getNextPageNum() {
		return nextPageNum;
	}
	public void setNextPageNum(int nextPageNum) {
		this.nextPageNum = nextPageNum;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
}
