import org.suntao.easyorm.annotation.DataBaseModel;

/**
 * 实体示例
 * 
 * @author suntao
 *
 */
@DataBaseModel(autoincrease = false, primarykeyname = "courseid", tablename = "courseinfo")
public class Courseinfo {
	int courseid;
	String course;
	int classhour;
	float score;
	int teacherid;

	// 一定需要默认的构造方法 否则无法构造实例
	public Courseinfo() {
		super();
	}

	public Courseinfo(int courseid, String course, int classhour, float score,
			int teacherid) {
		super();
		this.courseid = courseid;
		this.course = course;
		this.classhour = classhour;
		this.score = score;
		this.teacherid = teacherid;
	}

	@Override
	public String toString() {
		return String.format("ID:%d 名称:%s \t学时:%d 学分:%.1f 教师号:%d", courseid,
				course, classhour, score, teacherid);
	}
}
