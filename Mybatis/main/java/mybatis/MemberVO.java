package mybatis;

/*
 VO(Value Oject) :
 DTO와 동일 개념으로 데이터 저장을 목적으로 생성하는 객체
 */

public class MemberVO {
	private String id;
	private String pass;
	private String name;
	private java.sql.Date regidate;
	/*
	public void MemberVO() {
		
	}
	*/
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public java.sql.Date getRegidate() {
		return regidate;
	}
	public void setRegidate(java.sql.Date regidate) {
		this.regidate = regidate;
	}
	
	
}
