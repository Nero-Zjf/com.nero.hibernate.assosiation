package bothway.oneton.withtable.po;

import javax.persistence.*;

@Entity//声明该类是一个Hibernate的持久化类
@Table(name = "address")//指定该类映射的表，name是表名
public class Address {
    @Id //指定该类的唯一标识，通常映射到数据表的主键
    //指定主键的生成策略，其中strategy属性指定了主键生成策略为IDENTITY策略，也就是采用MySQL自动增长的主键生成策略
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String street;
    private String num;
    // 声明Address与Person的关系是多对一
    @ManyToOne(targetEntity = Person.class)
    //指定Person与Address的关联表
    @JoinTable(name = "person_address", //指定关联表名
            joinColumns = {
                    @JoinColumn(name = "address_id", referencedColumnName = "id", unique = true), //指定关联表中用于关联Person表的外键
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "person_id", referencedColumnName = "id") //指定关联表中用于关联Address表的外键
            })
    private Person person;

    public Address() {
    }

    public Address(String street, String num, Person person) {
        this.street = street;
        this.num = num;
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"street\":\"" + street + '\"' +
                ", \"num\":\"" + num + '\"' +
                '}';
    }
}
