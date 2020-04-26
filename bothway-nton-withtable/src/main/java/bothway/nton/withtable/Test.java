package bothway.nton.withtable;

import bothway.nton.withtable.po.Address;
import bothway.nton.withtable.po.Person;
import bothway.nton.withtable.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

/**
 * 双向N-N 有关联表(必须有) 测试(一个人住在多个地址，一个地址可以住多个人)  双向表示即可以从Person对象中获取Address,反相也成立
 */
public class Test {
    public static void main(String[] args) {
        //插入用户
        Person user = new Person();
        user.getAddress().add(new Address("A", "5566"));
        user.getAddress().add(new Address("B", "45666"));

        Session session1 = HibernateUtil.getSessionFactory().openSession();
        Transaction ts1 = session1.beginTransaction();
        int reId = (Integer) session1.save(user);//user持久化
        ts1.commit();
        session1.close();

        //查询用户
        Session session2 = HibernateUtil.getSessionFactory().openSession();
        Transaction ts2 = session2.beginTransaction();
        user = (Person) session2.get(Person.class, reId);
        ts2.commit();
        System.out.println("从用户获取地址：" + user.getAddress());
        for (Address ad :
                user.getAddress()) {
            System.out.println("从地址获取用户：" + ad.getPerson());
        }
        session2.close();

        HibernateUtil.getSessionFactory().close();
    }
}
