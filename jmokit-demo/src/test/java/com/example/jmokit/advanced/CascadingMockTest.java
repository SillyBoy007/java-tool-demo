package com.example.jmokit.advanced;

import mockit.Mock;
import mockit.MockUp;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CascadingMockTest {
    @Test
    public void testCascading() {
        //下面以Mock  EntityManager.createNativeQuery的返回对象为例
        EntityManager entityManager = new MockUp<EntityManager>() {
            @Mock
            public Query createNativeQuery(String sqlString) {
                //返回一个自定义Query的匿名内部类就可以
                return new Query() {
                    @Override
                    public List getResultList() {
                        //在这里书写你的Mock逻辑，
                        // mock的返回数据
                        List<Object> mockResult = new ArrayList<Object>();
                        mockResult.add(new Object());
                        mockResult.add(new Object());
                        return mockResult;
                    }

                    @Override
                    public Object getSingleResult() {
                        // TODO Auto-generated method stub
                        return null;
                    }

                    @Override
                    public int executeUpdate() {
                        // TODO Auto-generated method stub
                        return 0;
                    }

                    @Override
                    public Query setMaxResults(int maxResult) {
                        // TODO Auto-generated method stub
                        return null;
                    }

                    @Override
                    public Query setFirstResult(int startPosition) {
                        // TODO Auto-generated method stub
                        return null;
                    }

                    @Override
                    public Query setHint(String hintName, Object value) {
                        // TODO Auto-generated method stub
                        return null;
                    }

                    @Override
                    public Query setParameter(String name, Object value) {
                        // TODO Auto-generated method stub
                        return null;
                    }

                    @Override
                    public Query setParameter(String name, Date value, TemporalType temporalType) {
                        // TODO Auto-generated method stub
                        return null;
                    }

                    @Override
                    public Query setParameter(String name, Calendar value, TemporalType temporalType) {
                        // TODO Auto-generated method stub
                        return null;
                    }

                    @Override
                    public Query setParameter(int position, Object value) {
                        // TODO Auto-generated method stub
                        return null;
                    }

                    @Override
                    public Query setParameter(int position, Date value, TemporalType temporalType) {
                        // TODO Auto-generated method stub
                        return null;
                    }

                    @Override
                    public Query setParameter(int position, Calendar value, TemporalType temporalType) {
                        // TODO Auto-generated method stub
                        return null;
                    }

                    @Override
                    public Query setFlushMode(FlushModeType flushMode) {
                        // TODO Auto-generated method stub
                        return null;
                    }

                };
            }

        }.getMockInstance();
        String yoursql = "";
        //可以发现，我们成功地对entityManager.createNativeQuery方法返回值进行了Mock
        Assert.assertTrue(entityManager.createNativeQuery(yoursql).getResultList().size() == 2);
}
}