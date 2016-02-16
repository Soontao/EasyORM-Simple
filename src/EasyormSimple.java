import java.util.List;

import org.suntao.easyorm.session.SqlSession;
import org.suntao.easyorm.session.SqlSessionFactory;
import org.suntao.easyorm.session.defaults.DefaultSqlSessionFactory;
import org.suntao.easyorm.xmlparse.DatabaseConfig;
import org.suntao.easyorm.xmlparse.EasyormConfig;

/**
 * EasyORM项目实例
 * <p>
 * 如果不想看到低等级的log,将log4j.properties中的log4j.appender.stdout.Threshold从DEBUG改为WARN
 * 
 * @author suntao
 *
 */
public class EasyormSimple {

	public static void main(String[] args) {
		// 创建sqlsessionfactory,使用sqlite数据库,文件为data.db
		SqlSessionFactory sessionFactory = new DefaultSqlSessionFactory(
				"org.sqlite.JDBC", "jdbc:sqlite:data.db", null, null);
		// 打开一个sqlsession
		SqlSession sqlSession = sessionFactory.openSession();
		// 获取DAO接口代理
		CourseinfoMapper courseinfoMapper = sqlSession
				.getMapper(CourseinfoMapper.class);
		// 查询
		List<Courseinfo> courses = courseinfoMapper.selectAll();
		Courseinfo courseinfo = courseinfoMapper.selectOne(3);

		// 显示结果
		for (Courseinfo c : courses) {
			System.err.println(c);
		}

		System.err.println("id为3的课程信息为: " + courseinfo);

	}

}
