package com.example.dell.myapplication.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: userinfom.java
 * @Package com.example.dell.myapplication.db
 * @Description: todo
 * @author: YFL
 * @date: 2018/5/8 23:40
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018/5/8 星期二
 * 注意：本内容仅限于学川教育有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Entity
public class userinfom {
    @Id(autoincrement = true)
    private Long id;
    private String name;
    private boolean isreight;
    private String date;
    @Generated(hash = 899396458)
    public userinfom(Long id, String name, boolean isreight, String date) {
        this.id = id;
        this.name = name;
        this.isreight = isreight;
        this.date = date;
    }
    @Generated(hash = 1704430872)
    public userinfom() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean getIsreight() {
        return this.isreight;
    }
    public void setIsreight(boolean isreight) {
        this.isreight = isreight;
    }
    public String getDate() {
        return this.date;
    }
    public void setDate(String date) {
        this.date = date;
    }

}
