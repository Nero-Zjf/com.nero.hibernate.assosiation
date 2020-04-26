package oneway.onetoone.notable.po;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;

//Person与Address的关系是1对1
@Entity//声明该类是一个Hibernate的持久化类
@Table(name = "person")//指定该类映射的表，name是表名
public class Person {
    @Id //指定该类的唯一标识，通常映射到数据表的主键
    //指定主键的生成策略，其中strategy属性指定了主键生成策略为IDENTITY策略，也就是采用MySQL自动增长的主键生成策略
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //声明Person类型关联Address，关系为1-1
    @OneToOne(targetEntity = Address.class)
    //指定Person关联Address的外键
    @JoinColumn(name = "address_id", nullable = false)
    //指定级联操作策略，此处表示对Person实体的所有持久化操作都会级联到它关联的Address实体
    @Cascade(CascadeType.ALL)
    private Address address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"address\":" + address +
                '}';
    }
}
