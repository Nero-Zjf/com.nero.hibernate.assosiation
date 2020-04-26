# com.nero.hibernate.assosiation 
Hibernate 实体关联 demo
[TOC]
## 单向关联
### 单向 N-1关联
- oneway-ntoone-notable
单向 N-1 无关联表 演示demo
- oneway-ntoone-withtable
单向 N-1 有关联表 演示demo

### 单向 1-1关联
- oneway-onetoone-notable
单向 1-1 无关联表 演示demo
> 也可以实现有关联的映射，但是极少数会有这种情况，因此不提供demo

### 单向 1-N关联
- oneway-oneton-notable
单向 1-N 无关联表 演示demo
- oneway-oneton-withtable
单向 1-N 有关联表 演示demo

### 单向 N-N关联
此关联与单向有关联表的1-N关联(N-N关联必须有关联表)基本一致，只需将@OneToMany改为@ManyToMany

## 双向关联
### 双向 1-N关联
- bothway-oneton-notable
双向 1-N 无关联表 演示demo
- bothway-oneton-withtable
双向 1-N 有关联表 演示demo

### 双向 N-N关联
- bothway-nton-withtable
双向 1-N 有关联表（必须有） 演示demo

### 双向 1-1关联
>与其它关联类型 不在赘述

> 注意：在对一个存在关联关系的实体进行持久化时，如果关联的对象属性声明时没有使用@Cascade进行修饰，就必须手动对这个属性对象进行持久化。