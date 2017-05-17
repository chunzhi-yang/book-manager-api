# book-manager-api
使用gradle做依赖管理、代码生成、项目构建等功能。
使用Java的Spring、spring mvc、mybatis搭建环境，集成了shiro、ehcache做权限、缓存管理。
登录使用rsa加密，数据库密文存储，保证用户密码安全。
数据库使用mysql。

功能:
LoginCtroller:登录控制器；

FileReadController：下载管理；

BmRoleController：角色管理；

BmMenuController：菜单管理；

UserInfoCtroller:用户信息管理控制器；

BooksController：书籍管理控制器；

BookShelfController:书架管理；

BmUserAccountController：账户管理，余额；

BmOrderController：订单管理；

BmAccountLogController：消费记录；

Service接口定义：
/book-manager-api/src/main/java/com/gzhu/bm/service/*Service.java

Service接口实现类定义：
/book-manager-api/src/main/java/com/gzhu/bm/service/impl/*ServiceImpl.java

连接数据库：
/book-manager-api/src/main/java/com/gzhu/bm/repo/*.java，连接数据库接口；
book-manager-api/src/main/resources/mapper/*.xml，sql目录；

数据库分页工具类：
/book-manager-api/src/main/java/com/gzhu/bm/repo/util/PaginationBean.java

Spring AOP做时间自动写入：
/book-manager-api/src/main/java/com/gzhu/bm/aop/DealTimeAop.java
