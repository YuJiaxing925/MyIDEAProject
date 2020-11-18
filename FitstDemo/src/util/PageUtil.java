package util;

import java.util.List;

/**
 * ʵ�ַ�ҳ��
 *
 */
public class PageUtil<T> {
	//�������
	private int  pageindex=1;//��ǰҳ/ҳ��
	private int  pagesize=10;//ҳ���С
	private int counts=0;//��¼����
	private int pagecount=0;//��ҳ��
	private List<T> lists;//���浱ǰҳ����ļ��� 
	//get set����
	public int getPageindex() {
		return pageindex;
	}
	public void setPageindex(int pageindex) {
		this.pageindex = pageindex;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getCounts() {
		return counts;
	}
	public void setCounts(int counts) {
		this.counts = counts;
		//�������ܼ�¼ʱ,һ��������ҳ��
		if(counts>0){
			if(counts%pagesize==0){//�ж��Ƿ�������
				pagecount = counts/pagesize;
			}else{
				pagecount = counts/pagesize+1;
			}
		}
	}
	public int getPagecount() {
		return pagecount;
	}
	public void setPagecounts(int pagecounts) {
		this.pagecount = pagecounts;
	}
	public List<T> getLists() {
		return lists;
	}
	public void setLists(List<T> lists) {
		this.lists = lists;
	}
}