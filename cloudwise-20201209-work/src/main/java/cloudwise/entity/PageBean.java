package cloudwise.entity;

/**
 * @author ：Teacher陈
 * @date ：Created in 2020/12/1 9:53
 * @description：分页实体类
 * @modified By：
 * @version: 1.0
 */
public class PageBean {
    /**
     * 当前第几页
     */
    private  int pageNo;
    /**
     * 一页显示多少航
     */
    private int pageSize;
    /**
     * 总条数
     */
    private  long  count;
    /**
     * 总页数
     */
    private  int pageTotal;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public int getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(int pageTotal) {
        this.pageTotal = pageTotal;
    }

    public PageBean(int pageNo, int pageSize, long count, int pageTotal) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.count = count;
        this.pageTotal = pageTotal;
    }

    public PageBean() {
    }
}
