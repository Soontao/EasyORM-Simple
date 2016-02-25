import com.sun.org.apache.xml.internal.serializer.ToSAXHandler;

/**
 * 关联查询示例
 * 
 * @author suntao
 *
 */
public class AssModel {
	int courseid;
	String course;
	int classhour;
	float score;
	int teacherid;
	String teachername;

	@Override
	public String toString() {
		return String.format("ID:%d 名称:%s \t学时:%d 学分:%.1f 教师号:%d 教师名称:%s",
				courseid, course, classhour, score, teacherid, teachername);
	}
}
