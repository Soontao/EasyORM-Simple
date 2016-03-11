import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import org.suntao.easyorm.configuration.DatabaseConfig;
import org.suntao.easyorm.configuration.EasyormConfig;
import org.suntao.easyorm.session.SqlSession;
import org.suntao.easyorm.session.SqlSessionFactory;
import org.suntao.easyorm.session.defaults.DefaultSqlSessionFactory;


/**
 * EasyORM项目 示例
 * <p>
 * 如果不想看到低等级的log<BR>
 * 将log4j.properties中的log4j.appender.stdout.Threshold从DEBUG改为WARN
 * 
 * @author suntao
 *
 */
public class EasyormSimple {

	public static void main(String[] args) {
		// 创建sqlsessionfactory,使用sqlite数据库,文件为data.db
		SqlSessionFactory sessionFactory = new DefaultSqlSessionFactory(
				new EasyormConfig(new DatabaseConfig("org.sqlite.JDBC",
						"jdbc:sqlite:data.db", null, null), true, 15, null));
		// 打开一个sqlsession
		SqlSession sqlSession = sessionFactory.openSession();
		CourseinfoMapper courseinfoMapper = sqlSession
				.getMapper(CourseinfoMapper.class);
		try {
			// 查询所有信息
			List<Courseinfo> courses = sqlSession.selectALL(Courseinfo.class);
			System.out.println("------------SelectAll-------------");
			for (Courseinfo c : courses) {
				System.out.println(c);
			}
			// 新建一个实体
			Courseinfo courseinfo = new Courseinfo(9, "信息检索与利用", 64, 3.5f, 3003);
			// 插入新的实体
			sqlSession.insert(courseinfo);
			// 查询一条数据
			Courseinfo query = sqlSession.selectByPrimaryKey(courseinfo);
			System.out.println("------------SelectOne-------------\n" + query);
			// 删除刚插入的数据
			sqlSession.deleteByPrimaryKey(courseinfo);
			// 关联查询(左连接)
			List<AssModel> assQuery = courseinfoMapper.assQueary();
			System.out.println("------------关联--查询-------------");
			for (AssModel a : assQuery) {
				System.out.println(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			sqlSession.destroy();
		}

	}
}
