package zpy.mybatis;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class Test {
	public static void main(String[] args) throws IOException {
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		SqlSessionFactory sessionFactory = builder.build(reader);
		SqlSession session = sessionFactory.openSession();

		User user = session.selectOne("zpy.mybatis.BaseDao.getUser", 1);
		System.out.println(user.getName());

		BaseDao dao = session.getMapper(BaseDao.class);
		System.out.println(dao.getUser(1).getName());

		session.close();
	}
}
