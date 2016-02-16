/**
 * 实体示例
 * 
 * @author suntao
 *
 */
public class Courseinfo {
	int courseid;
	String course;
	int classhour;
	float score;
	int teacherid;

	public String toString() {
		return String.format("ID:%d 名称:%s \t学时:%d 学分:%.1f 教师号:%d", courseid,
				course, classhour, score, teacherid);
	}
}
