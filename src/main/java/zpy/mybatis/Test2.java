package zpy.mybatis;


import org.apache.ibatis.session.SqlSessionFactory;
import zpy.util.Spring;

/**
 * 整合spring
 */
public class Test2 {
	public static void main(String[] args) {
		SqlSessionFactory factory = (SqlSessionFactory) Spring.get("mybatis.xml", "sqlSessionFactory");

	}
}
