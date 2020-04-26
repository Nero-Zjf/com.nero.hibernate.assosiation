package bothway.nton.withtable.po;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//Person与Address的关系是N对N
@Entity//声明该类是一个Hibernate的持久化类
@Table(name = "person")//指定该类映射的表，name是表名
public class Person {
    @Id //指定该类的唯一标识，通常映射到数据表的主键
    //指定主键的生成策略，其中strategy属性指定了主键生成策略为IDENTITY策略，也就是采用MySQL自动增长的主键生成策略
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //声明Person类型关联Address，关系为N-N
    @ManyToMany(targetEntity = Address.class)
    //指定Person与Address的关联表
    @JoinTable(name = "person_address", //指定关联表名
            joinColumns = {
                    @JoinColumn(name = "person_id", referencedColumnName = "id"), //指定关联表中用于关联Address表的外键
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "address_id", referencedColumnName = "id")  //指定关联表中用于关联Person表的外键
            })
    //指定级联操作策略，此处表示对Person实体的所有持久化操作都会级联到它关联的Address实体
    @Cascade(CascadeType.ALL)
    private Set<Address> address = new HashSet<Address>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Address> getAddress() {
        return address;
    }

    public void setAddress(Set<Address> address) {
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
