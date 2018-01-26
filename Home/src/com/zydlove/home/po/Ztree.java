package com.zydlove.home.po;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ztree")
public class Ztree {
    @Id
    private int zid;
    private String zname;
    private String zcolor;
    public int getZid() {
        return zid;
    }
    public void setZid(int zid) {
        this.zid = zid;
    }
    public String getZname() {
        return zname;
    }
    public void setZname(String zname) {
        this.zname = zname;
    }
    public String getZcolor() {
        return zcolor;
    }
    public void setZcolor(String zcolor) {
        this.zcolor = zcolor;
    }
}
