import java.util.List;

import org.suntao.easyorm.annotation.SQL;

/**
 * 示例DAO接口
 * 
 * @author suntao
 *
 */
public interface CourseinfoMapper {
	@SQL(value = "select * from courseinfo")
	public List<Courseinfo> selectAll();

	@SQL(value = "select * from courseinfo where courseid = ?")
	public Courseinfo selectOne(int id);

	@SQL(value = "select * from courseinfo")
	public int count();

}
