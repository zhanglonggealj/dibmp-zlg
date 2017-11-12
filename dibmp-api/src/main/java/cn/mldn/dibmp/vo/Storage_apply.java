package cn.mldn.dibmp.vo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Storage_apply implements Serializable {
	private Long said;
	private String title;
	private Long pid;
	private Long cid;
	private Long wiid;
	private Long wid;
	private String note;
	private Integer status;
	private String appmid;
	private String auname;
	private Date apptime;
	private Date autime;
	public Long getSaid() {
		return said;
	}
	public void setSaid(Long said) {
		this.said = said;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public Long getCid() {
		return cid;
	}
	public void setCid(Long cid) {
		this.cid = cid;
	}
	public Long getWiid() {
		return wiid;
	}
	public void setWiid(Long wiid) {
		this.wiid = wiid;
	}
	public Long getWid() {
		return wid;
	}
	public void setWid(Long wid) {
		this.wid = wid;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getAppmid() {
		return appmid;
	}
	public void setAppmid(String appmid) {
		this.appmid = appmid;
	}
	public String getAuname() {
		return auname;
	}
	public void setAuname(String auname) {
		this.auname = auname;
	}
	public Date getApptime() {
		return apptime;
	}
	public void setApptime(Date apptime) {
		this.apptime = apptime;
	}
	public Date getAutime() {
		return autime;
	}
	public void setAutime(Date autime) {
		this.autime = autime;
	}
	@Override
	public String toString() {
		return "Storage_apply [said=" + said + ", title=" + title + ", pid=" + pid + ", cid=" + cid + ", wiid=" + wiid
				+ ", wid=" + wid + ", note=" + note + ", status=" + status + ", appmid=" + appmid + ", auname=" + auname
				+ ", apptime=" + apptime + ", autime=" + autime + "]";
	}
	
}
