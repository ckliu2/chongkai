package org.zion.value;

import java.util.Date;
import java.util.List;

import com.common.value.Member;

public class TodayBible {
    
    Bible bible;
    Integer chapter; 
    Date today;
    Member member;
    List<BibleLection> lection;
    
    public Bible getBible() {
        return bible;
    }
    public void setBible(Bible bible) {
        this.bible = bible;
    }
    public Integer getChapter() {
        return chapter;
    } 
    public void setChapter(Integer chapter) {
        this.chapter = chapter;
    }
    public Date getToday() {
        return today;
    }
    public void setToday(Date today) {
        this.today = today;
    }
    public Member getMember() {
        return member;
    }
    public void setMember(Member member) {
        this.member = member;
    }
    public List<BibleLection> getLection() {
        return lection;
    }
    public void setLection(List<BibleLection> lection) {
        this.lection = lection;
    }

}
