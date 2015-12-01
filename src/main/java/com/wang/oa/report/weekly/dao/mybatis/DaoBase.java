package com.wang.oa.report.weekly.dao.mybatis;

import java.util.List;

public interface DaoBase<T> {

	public void insert(T t);

	public void delete(Integer id);

	public void update(T t);

	public void updateWithNullValue(T t);

	public T queryById(Long id);

	public List<T> queryByExample(T t);
}
