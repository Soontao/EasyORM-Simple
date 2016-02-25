import java.util.List;

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
				"org.sqlite.JDBC", "jdbc:sqlite:data.db", null, null);
		// 打开一个sqlsession
		SqlSession sqlSession = sessionFactory.openSession();
		CourseinfoMapper courseinfoMapper = sqlSession
				.getMapper(CourseinfoMapper.class);
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
		// 删除一条数据
		sqlSession.deleteByPrimaryKey(courseinfo);
		// 关联查询(左关联)
		List<AssModel> assQuery = courseinfoMapper.assQueary();
		System.out.println("------------关联--查询-------------");
		for (AssModel a : assQuery) {
			System.out.println(a);
		}

	}
}
