package com.kepler.dao;
import org.hibernate.*;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class BaseDao {
    @Resource
    SessionFactory sessionFactory;

    public Session getSession(){
        return sessionFactory.openSession();
    }

    public int sqlUpdate(String sql){//三合一增删改使用sql的形式,返回一个int记录修改的行数
        Session session = getSession();

        SQLQuery sqlQuery = session.createSQLQuery(sql);
        int i = sqlQuery.executeUpdate();

        session.flush();
        session.close();

        return i;
    }

    public List sqlQuery(String sql){//使用sql的形式执行查询，自定义sql语句
        Session session = getSession();

        Query query = session.createSQLQuery(sql);

        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);//让返回回来的数据以map键值对的形式呈现

        List list = query.list();

        session.flush();

        session.close();

        return list;
    }

    public List hqlQuery(String hql){//使用hql的形式执行查询，自定义hql语句
        Session session = getSession();

        List list = (session.createQuery(hql)).list();
        session.flush();
        session.close();

        return list;
    }

    //根据ID获取对象
    public Object getObject(Class cla,Integer id){
        return getSession().get(cla,id);
    }


    public List findAll(String ClassName){//使用hql的形式执行查询，仅支持单表
        Session session = getSession();
        List list = (session.createQuery("from " + ClassName)).list();
        session.flush();
        session.close();

        return list;
    }

    public void save(Object o){//传一个vo，保存到数据库
        Session session = getSession();
        session.save(o);
        session.flush();

        session.close();
    }

    public void delete(Object o){//删除单个vo,据vo的id字段为主
        Session session = getSession();
        session.delete(o);

        session.flush();

        session.close();
    }

    public void update(Object o){//修改单个vo,据vo的id字段为主
        Session session = getSession();
        session.update(o);
        session.flush();

        session.close();
    }
    /**
     * 查int
     */
    public int executeIntSQL(String sql) {
        Session session =  getSession();
        Query sqlquery =session.createSQLQuery(sql);

        String result = sqlquery.list()+"";
        System.out.printf(result);

        result = result.substring(1,result.length()-1);
        int i = Integer.parseInt(result+"");

        session.flush();
        session.close();
        return i;
    }
    /**
     * 查String
     */
    public String executeStringSQL(String sql) {
        Session session =  getSession();
        Query sqlquery =session.createSQLQuery(sql);

        String result = sqlquery.list()+"";
        System.out.print(result);

        result = result.substring(1,result.length()-1);
        //String str = result;

        session.flush();
        session.close();
        return result;
    }
    /**
     * 查 float
     */
    public Float executeFloatSQL(String sql) {
        Session session =  getSession();
        Query sqlquery =session.createSQLQuery(sql);

        String result = sqlquery.list()+"";
        System.out.printf(result);

        result = result.substring(1,result.length()-1);
        float i = Float.parseFloat(result+"");

        session.flush();
        session.close();
        return i;
    }

}
