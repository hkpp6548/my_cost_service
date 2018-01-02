package com.skyhuang.hibernate.study.domain.moreToMore;

import java.util.HashSet;
import java.util.Set;

/** 多对多 课程实体
 * Created by hk on 2018/1/2.
 */
public class Course {
    private Integer cid;
    private String cname;
    // 一个课程被多个学生选择:
    private Set<Student> students = new HashSet<Student>();
    public Integer getCid() {
        return cid;
    }
    public void setCid(Integer cid) {
        this.cid = cid;
    }
    public String getCname() {
        return cname;
    }
    public void setCname(String cname) {
        this.cname = cname;
    }
    public Set<Student> getStudents() {
        return students;
    }
    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
