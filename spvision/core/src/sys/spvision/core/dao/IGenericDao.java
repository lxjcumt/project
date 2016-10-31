package sys.spvision.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import sys.spvision.core.criteria.AbstractCriteria;
public interface IGenericDao<T, PK> {
	public T getById(@Param("id")PK id, @Param("forUpdate")boolean forUpdate);
	public int queryCount(AbstractCriteria criteria);
	public List<T> query(AbstractCriteria criteria);
	public void insert(T t);
	public void update(T t);
	public void delete(PK id);
	public void deleteByCriteria(AbstractCriteria criteria);
}
