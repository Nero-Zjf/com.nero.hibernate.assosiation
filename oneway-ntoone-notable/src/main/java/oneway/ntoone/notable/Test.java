package oneway.ntoone.notable;

import org.hibernate.Session;
import org.hibernate.Transaction;
import oneway.ntoone.notable.po.Address;
import oneway.ntoone.notable.po.Person;
import oneway.ntoone.notable.util.HibernateUtil;

/**
 * 单向N-1 无关联表 测试(多个人住在同一个地址)
 */
public class Test {
    public static void main(String[] args) {
        //插入用户
        Person user = new Person();
        user.setAddress(new Address("A", "5566"));

        Session session1 = HibernateUtil.getSessionFactory().openSession();
        Transaction ts1 = session1.beginTransaction();
        int reId = (Integer) session1.save(user);
        ts1.commit();
        session1.close();

        //查询用户
        Session session2 = HibernateUtil.getSessionFactory().openSession();
        Transaction ts2 = session2.beginTransaction();
        user = (Person) session2.get(Person.class, reId);
        ts2.commit();
        System.out.println("查询用户：" + user);
        session2.close();

        HibernateUtil.getSessionFactory().close();
    }
}
