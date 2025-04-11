package api;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Data
@Repository("api_dto")
public class api_dto {
	String midx;
	String pd1,pd2,pd3,pd4,pd5;
	String mid, mname;
	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public Integer getMage() {
		return mage;
	}

	public void setMage(Integer mage) {
		this.mage = mage;
	}

	Integer mage;

	public String getPd1() {
		return pd1;
	}

	public void setPd1(String pd1) {
		this.pd1 = pd1;
	}

	public String getPd2() {
		return pd2;
	}

	public void setPd2(String pd2) {
		this.pd2 = pd2;
	}

	public String getPd3() {
		return pd3;
	}

	public void setPd3(String pd3) {
		this.pd3 = pd3;
	}

	public String getPd4() {
		return pd4;
	}

	public void setPd4(String pd4) {
		this.pd4 = pd4;
	}

	public String getPd5() {
		return pd5;
	}

	public void setPd5(String pd5) {
		this.pd5 = pd5;
	}
}
