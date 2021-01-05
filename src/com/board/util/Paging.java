package com.board.util;

public class Paging {
	
	public Paging() {
		this.page = 1;			// default
		this.displayRow = 10;   // default
		this.displayPage = 10;  // default
	}
	
	public Paging(int page, int displayRow, int displayPage) {
		this.page = page;
		this.displayRow = displayRow;
		this.displayPage = displayPage;
	}
	
	private void paging() {
		System.out.println("totalCount #########################################");
		System.out.println(totalCount);
		
		/*(1/10 -> 0.1) (9/10 -> 0.9) (12/10 -> 1.1) (25/10 -> 2.5) */
		double temp = page / (double) displayPage;

        /*(0.1 -> 1.0) (0.9 -> 1.0) (1.2 -> 2.0) (2.5 -> 3.0)*/
		temp = Math.ceil(temp);

        /*(1.0 -> 10) (1.0 -> 10) (2.0 0> 20) (3.0 -> 30)*/
		endPage = ((int) temp) * displayPage;

        /*(1.0 -> 10) (1.0 0> 10) (2.0 -> 20) (3.0 -> 30)*/
        beginPage = endPage - displayPage + 1;

        System.out.println("beginPage #########################################");
        System.out.println(beginPage);
        System.out.println("endPage #########################################");
        System.out.println(endPage);

        /*
            107 / 10 -> 10.7 -> 11
        */
        int totalPage = (int)Math.ceil(totalCount / (double)displayRow);
        
        if (totalPage < endPage) {
            endPage = totalPage;
            next = false;
        } else {
            next = true;
        }

        prev = (beginPage == 1) ? false : true;

        startNum = (page - 1) * displayRow + 1;
        endNum = page * displayRow;

        System.out.println("startNum #########################################");
        System.out.println(startNum);
        System.out.println("endNum #########################################");
        System.out.println(endNum);
	}
	
    private int page;        // 현재 페이지(get)
    private int totalCount;  // 게시물의 전체 수(get)
    private int beginPage;   // 표시될 시작페이지 번호
    private int endPage;     // 표시될 끝페이지
    private int displayRow;  // 한페이지에 몇개의 행을 표시할지
    private int displayPage; // 한페이지에 몇개의 페이지를 표시할지
    private int startNum;    // 현재 페이지의 시작 게시물 번호
    private int endNum;      // 현재 페이지의 끝 게시물 번호
    private boolean prev;    // 이전버튼 여부
    private boolean next;    // 다음버튼 여부
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		paging(); // paging() 메서드의 호출 - setTotalCount 메서드가 외부에서 호출되면 자동 실행
	}

	public int getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getDisplayRow() {
		return displayRow;
	}

	public void setDisplayRow(int displayRow) {
		this.displayRow = displayRow;
	}

	public int getDisplayPage() {
		return displayPage;
	}

	public void setDisplayPage(int displayPage) {
		this.displayPage = displayPage;
	}

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public int getEndNum() {
		return endNum;
	}

	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}
}
