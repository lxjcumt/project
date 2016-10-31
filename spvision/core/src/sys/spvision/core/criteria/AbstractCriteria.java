package sys.spvision.core.criteria;

public abstract class AbstractCriteria {
	private boolean paging;
	private int limit;
	private int offset;

	public boolean isPaging() {
		return paging;
	}

	public void setPaging(boolean paging) {
		this.paging = paging;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
		if (offset < 0) {
			this.offset = 0;
		}

	}

}
