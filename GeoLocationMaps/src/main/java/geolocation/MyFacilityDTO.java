package geolocation;

public class MyFacilityDTO {
	
	private String hp_name; //병원명
	private String hp_sido; //시도
	private String hp_gugun; //구군
	private String hp_addr; //주소
	private String hp_url; //참조URL
	private String hp_latitude;
	private String hp_longitude;
	private String disKM; //거리
	private String rNum;
	public MyFacilityDTO() {}
	public MyFacilityDTO(String hp_name, String hp_sido, String hp_gugun, String hp_addr, String hp_url,
			String hp_latitude, String hp_longitude, String disKM, String rNum) {
		super();
		this.hp_name = hp_name;
		this.hp_sido = hp_sido;
		this.hp_gugun = hp_gugun;
		this.hp_addr = hp_addr;
		this.hp_url = hp_url;
		this.hp_latitude = hp_latitude;
		this.hp_longitude = hp_longitude;
		this.disKM = disKM;
		this.rNum = rNum;
	}
	public String getHp_name() {
		return hp_name;
	}
	public void setHp_name(String hp_name) {
		this.hp_name = hp_name;
	}
	public String getHp_sido() {
		return hp_sido;
	}
	public void setHp_sido(String hp_sido) {
		this.hp_sido = hp_sido;
	}
	public String getHp_gugun() {
		return hp_gugun;
	}
	public void setHp_gugun(String hp_gugun) {
		this.hp_gugun = hp_gugun;
	}
	public String getHp_addr() {
		return hp_addr;
	}
	public void setHp_addr(String hp_addr) {
		this.hp_addr = hp_addr;
	}
	public String getHp_url() {
		return hp_url;
	}
	public void setHp_url(String hp_url) {
		this.hp_url = hp_url;
	}
	public String getHp_latitude() {
		return hp_latitude;
	}
	public void setHp_latitude(String hp_latitude) {
		this.hp_latitude = hp_latitude;
	}
	public String getHp_longitude() {
		return hp_longitude;
	}
	public void setHp_longitude(String hp_longitude) {
		this.hp_longitude = hp_longitude;
	}
	public String getDisKM() {
		return disKM;
	}
	public void setDisKM(String disKM) {
		this.disKM = disKM;
	}
	public String getrNum() {
		return rNum;
	}
	public void setrNum(String rNum) {
		this.rNum = rNum;
	}
	
	
	
}
