package org.zion.web.action;

import org.zion.value.*;
import org.zion.service.PrayManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.*;

import java.sql.*;
import java.util.*;
import java.util.Date;

import javax.servlet.http.*;

import com.common.value.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.*;

public class PrayWebAction extends CommonActionSupport {

    PrayTW praytw;
    PrayStreet praystreet;
    Member member;
    int join;
    String content;
    PrayMe prayme;
    EveryBible everybible;  
    TodayBible todaybible;
    Bible bible;
    String myday;
    int classify;

    public String list() {
	return SUCCESS;
    }

    public String map() {
	praytw = getGenericManager().getPrayTWById(praytw.getId());
	try {
	    praystreet = getGenericManager().getPrayStreetById(
		    praystreet.getId());
	} catch (Exception e) {
	}
	return SUCCESS;
    }

    public List<PrayTWGlobal> getPrayTWGlobalList() {
	return getGenericManager().getPrayTWGlobalList();
    }
    
    public String getMyday() {
        return myday;
    }

    public void setMyday(String myday) {
        this.myday = myday;
    }

    public PrayTW getPraytw() {
	return praytw;
    }

    public void setPraytw(PrayTW praytw) {
	this.praytw = praytw;
    }

    public Member getMember() {
	return member;
    }

    public void setMember(Member member) {
	this.member = member;
    }

    public PrayStreet getPraystreet() {
	return praystreet;
    }

    public void setPraystreet(PrayStreet praystreet) {
	this.praystreet = praystreet;
    }

    public String getContent() {
	return content;
    }

    public void setContent(String content) {
	this.content = content;
    }

    public PrayMe getPrayme() {
	return prayme;
    }

    public void setPrayme(PrayMe prayme) {
	this.prayme = prayme;
    }

    public void setGenericManager(PrayManager m) {
	super.setGenericManager(m);
    }

    public PrayManager getGenericManager() {
	return (PrayManager) super.getGenericManager();
    }

    public List<MiscCode> getCountryList1() {
	return getGenericManager().getMiscCodeListByCodeName("county");
    }

    public List<MiscCode> getMiscCodeList(String codeName) {
	return getGenericManager().getMiscCodeListByCodeName(codeName);
    }

    public boolean isPrayStreetByPrayTW(String prayId) {
	MiscCode area = getGenericManager().getMiscCodeById(
		Long.parseLong(prayId));
	praytw = getGenericManager().getPrayTWByArea(area);
	return getGenericManager().isPrayStreetByPrayTW(praytw);
    }

    public List<PrayStreet> getPrayStreetListByPrayTW(String prayId) {
	MiscCode area = getGenericManager().getMiscCodeById(
		Long.parseLong(prayId));
	praytw = getGenericManager().getPrayTWByArea(area);
	return getGenericManager().getPrayStreetListByPrayTW(praytw);
    }

    public List<PrayTWClaim> getPrayTWClaimListByPrayTW() {
	praytw = getGenericManager().getPrayTWById(praytw.getId());
	System.out.println("getPrayTWClaimListByPrayTW praytw="
		+ praytw.getArea().getValueCh());
	return getGenericManager().getPrayTWClaimListByPrayTW(praytw);
    }

    public PrayTW getPrayTWById(String prayId) {
	return getGenericManager().getPrayTWById(Long.parseLong(prayId));
    }

    public Member getSessionUserMember() {
	SessionUser s = (SessionUser) getSession().getAttribute("user");
	return s.getMember();
    }

    public List<AppProperty> getClassifyList() {
	return super.getAppPropertyList("pray.classify");
    }

    public List<Pray> getPrayListByClassify(String classifyId) {
	AppProperty classify = getGenericManager().getAppPropertyById(
		Long.parseLong(classifyId));
	return getGenericManager().getPrayListByClassify(classify);
    }

    public List<PrayMe> getMyPrayList() {
	System.out.println("member.id=" + member.getId());
	member = getGenericManager().getMemberById(member.getId());
	return getGenericManager().getPrayMeListByMember(member);
    }

    public List<PrayMe> getPrayMeList() {
	return getGenericManager().getPrayMeList();
    }
    
    public Bible getBible() {
        return bible;
    }

    public void setBible(Bible bible) {
        this.bible = bible;
    }
    
    public int getClassify() {
        return classify;
    }

    public void setClassify(int classify) {
        this.classify = classify;
    }

    public List<PrayYou> getPrayYouListByPrayMe(String id) {
	System.out.println("getPrayYouListByPrayMe id=" + id);
	prayme = getGenericManager().getPrayMeById(Long.parseLong(id));
	return getGenericManager().getPrayYouListByPrayMe(prayme);
    }

    public List<SundayInfor> getSundayInforList() {
	return getGenericManager().getSundayInforList(20);
    }

    public int getTownShip(Long id) {
	praytw = getGenericManager().getPrayTWById(id);
	return getGenericManager().getTownShip(praytw);
    }

    public int getCounty(Long id) {
	MiscCode county = getGenericManager().getMiscCodeById(id);
	int j = 0;
	String code = county.getCodeName() + "." + county.getKeyName();
	List ls = getMiscCodeList(code);
	for (int i = 0; i < ls.size(); i++) {
	    MiscCode m = (MiscCode) ls.get(i);
	    // System.out.println(county.getValueCh()+"---"+m.getValueCh());
	    praytw = getGenericManager().getPrayTWByArea(m);
	    j += getGenericManager().getTownShip(praytw);
	}
	// System.out.println("id="+id+"---county="+county.getValueCh()+"--code="+code+"--j="+j);
	return j;
    }

    public JSONObject registerSave() throws JSONException {
	JSONObject p = new JSONObject();
	try {
	    System.out.println("nickname=" + member.getNickname() + "--name="
		    + member.getName() + "--cellphone=" + member.getCellphone()
		    + "--email=" + member.getEmail());
	    Member u = getGenericManager().getMemberByCellphone(
		    member.getCellphone());
	    if (u == null) {
		Member user = new Member();
		user.setName(member.getName());
		user.setNickname(member.getNickname());
		user.setCellphone(member.getCellphone());
		user.setEmail(member.getEmail());
		user.setCreatedDate(Tools.getCurrentTimestamp());
		user.setLastModifiedDate(Tools.getCurrentTimestamp());
		getGenericManager().saveMember(user);
		setMemberCookie(user);
		p.accumulate("returnValue", "1");
	    } else {
		p.accumulate("returnValue", "2");
	    }
	} catch (Exception e) {
	    p.accumulate("returnValue", "3");
	    System.out.println("registerSave=" + e.toString());
	}
	return p;
    }

    public JSONObject savePrayYou() throws JSONException {
	JSONObject p = new JSONObject();
	try {
	    p.accumulate("returnValue", "success");
	    System.out.println("content=" + content + "--member.id="
		    + member.getId() + "--prayme.id=" + prayme.getId());
	    prayme = getGenericManager().getPrayMeById(prayme.getId());
	    member = getGenericManager().getMemberById(member.getId());
	    PrayYou pray = new PrayYou();
	    pray.setMember(member);
	    pray.setContent(content);
	    pray.setPrayme(prayme);
	    pray.setApply(false);
	    pray.setCreatedDate(Tools.getCurrentTimestamp());
	    getGenericManager().savePrayYou(pray);

	} catch (Exception e) {
	    p.accumulate("returnValue", "fail");
	    System.out.println("savePrayYou=" + e.toString());
	}
	return p;
    }

    public JSONObject savePrayItem() throws JSONException {
	JSONObject p = new JSONObject();
	try {
	    p.accumulate("returnValue", "success");
	    System.out.println("content=" + content + "--member.id="
		    + member.getId());
	    member = getGenericManager().getMemberById(member.getId());
	    PrayMe pray = new PrayMe();
	    pray.setMember(member);
	    pray.setContent(content);
	    pray.setActive(true);
	    pray.setCreatedDate(Tools.getCurrentTimestamp());
	    getGenericManager().savePrayMe(pray);

	} catch (Exception e) {
	    p.accumulate("returnValue", "fail");
	    System.out.println("savePrayItem=" + e.toString());
	}
	return p;
    }

    public JSONObject userclaim() throws JSONException {
	JSONObject p = new JSONObject();
	try {
	    member = getGenericManager().getMemberById(member.getId());
	    praytw = getGenericManager().getPrayTWById(praytw.getId());
	    try {
		getGenericManager().savePrayTWClaim(praytw, member, join);
	    } catch (Exception e) {
		System.out.println(e.toString());
	    }
	    System.out.println("join=" + join + "--" + member.getName()
		    + "---praytw.id=" + praytw.getArea().getValueCh());

	    p.accumulate("returnValue", "success");
	    if (join == 1) {
		p.accumulate("claim", "1");
	    } else {
		p.accumulate("claim", "0");
	    }
	} catch (Exception e) {
	    p.accumulate("returnValue", "fail");
	    System.out.println("userTWClaim=" + e.toString());
	}
	return p;
    }

    public int getJoin() {
	return join;
    }

    public void setJoin(int join) {
	this.join = join;
    }

    public int getCountyCount1() {
	return 0;
    }
    
    public EveryBible getEverybible() {
        return everybible;
    }

    public void setEverybible(EveryBible everybible) {
        this.everybible = everybible;
    }

    public TodayBible getTodaybible() {
        return todaybible;
    }

    public void setTodaybible(TodayBible todaybible) {
        this.todaybible = todaybible;
    }

    public void updatesql(String county, String town, Long praytwid) {
	try {
	    String dbURL = "jdbc:sqlserver://203.71.172.251:1433;DatabaseName=zion";
	    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    Connection dbConn = DriverManager.getConnection(dbURL, "chongkai",
		    "2aixujxu");
	    Statement state = dbConn.createStatement(
		    ResultSet.TYPE_SCROLL_INSENSITIVE,
		    ResultSet.CONCUR_READ_ONLY);
	    String sql = "select Latitude,Longitude from Twgps where country like'%"
		    + county.substring(0, 2)
		    + "%' and name like'%"
		    + town.substring(0, 2) + "%'";
	    // String
	    // sql="select Latitude,Longitude from Twgps where country like'%台北%' and name like'%石門%'";
	    ResultSet rs = state.executeQuery(sql);
	    String Latitude = "";
	    String Longitude = "";
	    while (rs.next()) {
		Latitude = rs.getString("Latitude");
		Longitude = rs.getString("Longitude");
	    }
	    rs.close();
	    dbConn.close();

	    if (Latitude.equals("") && Longitude.equals("")) {
		System.out
			.println(county.substring(0, 2) + "-"
				+ town.substring(0, 2) + "---praytwid="
				+ praytwid + "--Latitude=" + Latitude
				+ "--Longitude=" + Longitude);
	    } else {
		praytw = getGenericManager().getPrayTWById(praytwid);
		praytw.setLatitude(Latitude);
		praytw.setLongitude(Longitude);
		getGenericManager().savePrayTW(praytw);

	    }

	} catch (Exception e) {
	    System.out.println("updatesql error=" + e.toString());
	}
    }
    
    public TodayBible getLivelyBible()
    {
	String code=Tools.getLivelyBibleDate();
	System.out.println("code="+code);
	
	TodayBible todaybible=new TodayBible();
	LivelyBible a=getGenericManager().getLivelyBible(code, classify);
	Bible bible=getGenericManager().getBibleById(a.getVolume());
	List<BibleLection> lection=getGenericManager().getBibleLection(a.getVolume(),a.getChapter());
	todaybible.setBible(bible);
	todaybible.setChapter(a.getChapter());
	todaybible.setLection(lection);	
	todaybible.setToday(Tools.getToday());	
	return todaybible;
    }
    
    public TodayBible getTodayBibleByMember()
    {
	TodayBible todaybible=new TodayBible();
	System.out.println("getTodayBibleByMember..");
	Vector v=new Vector();
	member=getGenericManager().getMemberById(member.getId());
	System.out.println(member.getName());
	everybible=getGenericManager().getEveryBibleByMember(member);
	
	Vector status=getTodayChapter(member);
	int volume=Integer.parseInt(String.valueOf(status.get(0)));
	int chapter=Integer.parseInt(String.valueOf(status.get(1)));
	
	System.out.println("***today status.get(0)="+status.get(0)+"--status.get(1)="+status.get(1));
	System.out.println("today volume="+volume+"--today chapter="+chapter);
	
	Bible bible=getGenericManager().getBibleById(volume);
	List<BibleLection> lection=getGenericManager().getBibleLection(volume,chapter);
	
	todaybible.setBible(bible);
	todaybible.setChapter(chapter);
	todaybible.setLection(lection);
	todaybible.setMember(member);
	todaybible.setToday(Tools.getToday());
	
	System.out.println("Volume="+everybible.getVolume()+"--Chapter="+everybible.getChapter());
	
	return todaybible;
    }
    
    
    public Vector<Integer> getTodayChapter(Member member)
    {
	    Vector<Integer> v=new Vector<Integer>();		
	    EveryBible bible=getGenericManager().getEveryBibleByMember(member);
	    System.out.println("Name="+bible.getName()+"--StartDate="+bible.getStartDate()+"--Volume="+bible.getVolume()+"--Chapter="+bible.getChapter());
	    
	    //myday
	    Date today=Tools.convertToDate(myday);
	    //Date today=Tools.getCurrentTimestamp();	    
	    
	    int day=Integer.parseInt(String.valueOf(( today.getTime()-bible.getStartDate().getTime() ) /(24*60*60*1000)));
            System.out.println("day="+day);   
            
            int bibleCount,bibleSN;
            int todayVolume=0,todayChapter=0;
            
            Bible b=getGenericManager().getBibleById(bible.getVolume());
            bibleSN=b.getSn();
            int chapterNumber=b.getChapterNumber();
            int k=(chapterNumber-bible.getChapter()+1)-day;
            
            System.out.println("day="+day+"--chapterNumber="+chapterNumber+"--bible.getChapter()="+bible.getChapter()+"--k="+k);  
            
            //無跨篇
            if(k >0)
            {
        	System.out.println("無跨篇");
        	todayVolume=bibleSN;
        	todayChapter=chapterNumber-(chapterNumber-day)+1;
        	System.out.println("todayVolume="+todayVolume+"--todayChapter="+todayChapter);
            }else{
        	System.out.println("迴圈扣除****");
        	
        	int bibleId,bibleChapter,chapterNum,volume,chapter;
        	bibleId=bibleSN+1;
        	do
        	{
        	    System.out.println("do fiist k="+k);
        	    if(bibleId>66){
        		bibleId=1;        		
        	    }        	   
        	    
        	    Bible be=getGenericManager().getBibleById(bibleId);
        	    chapterNum=be.getChapterNumber();        	    
        	    int r=k+chapterNum;
        	    todayVolume=be.getSn();
        	    todayChapter=chapterNum-r+1;
        	    bibleId+=1;
        	    
        	    System.out.println("k="+k+"--be="+be.getFullName()+"--"+be.getShortName()+"--todayChapter="+todayChapter);
        	    
        	    k=r;
        	    
        	}while(k<0);
        	 
        	//System.out.println("todayVolume="+todayVolume+"--todayChapter="+todayChapter+"--k="+k);
        	System.out.println("end*****");
            }   
            
            System.out.println("vector todayVolume="+todayVolume+"--todayChapter="+todayChapter);
    	
            v.add(todayVolume);
    	    v.add(todayChapter);
            
	
	return v;	 
    }
    
    public List<Vector> getEveryBibleList()
    {
	ArrayList<Vector> al=new ArrayList<Vector>();	
	List<EveryBible> ls=getGenericManager().getEveryBibleList();
	for(int i=0;i<ls.size();i++){
	    EveryBible bible=ls.get(i);
	    System.out.println("Name="+bible.getName()+"--StartDate="+bible.getStartDate()+"--Volume="+bible.getVolume()+"--Chapter="+bible.getChapter());
	    Date today=Tools.getCurrentTimestamp();	    
	    int day=Integer.parseInt(String.valueOf(( today.getTime()-bible.getStartDate().getTime() ) /(24*60*60*1000)));
            System.out.println("day="+day);   
            
            int bibleCount,bibleSN;
            int todayVolume=0,todayChapter=0;
            
            Bible b=getGenericManager().getBibleById(bible.getVolume());
            bibleSN=b.getSn();
            int chapterNumber=b.getChapterNumber();
            int k=(chapterNumber-bible.getChapter()+1)-day;
            
            System.out.println("day="+day+"--chapterNumber="+chapterNumber+"--bible.getChapter()="+bible.getChapter()+"--k="+k);  
            
            //無跨篇
            if(k==0 || k >0)
            {
        	System.out.println("無跨篇");
        	todayVolume=bibleSN;
        	todayChapter=chapterNumber-(chapterNumber-day);
        	System.out.println("todayVolume="+todayVolume+"--todayChapter="+todayChapter);
            }else{
        	System.out.println("迴圈扣除****");
        	
        	int bibleId,bibleChapter,chapterNum,volume,chapter;
        	bibleId=bibleSN+1;
        	do
        	{
        	    System.out.println("do fiist k="+k);
        	    if(bibleId>66){
        		bibleId=1;        		
        	    }        	   
        	    
        	    Bible be=getGenericManager().getBibleById(bibleId);
        	    chapterNum=be.getChapterNumber();        	    
        	    int r=k+chapterNum;
        	    todayVolume=be.getSn();
        	    todayChapter=chapterNum-r+1;
        	    bibleId+=1;
        	    
        	    System.out.println("k="+k+"--be="+be.getFullName()+"--"+be.getShortName()+"--todayChapter="+todayChapter);
        	    
        	    k=r;
        	    
        	}while(k<0);
        	 
        	//System.out.println("todayVolume="+todayVolume+"--todayChapter="+todayChapter+"--k="+k);
        	System.out.println("end*****");
        	
        	
            }
            
              
         
	    
	}
	
	return al;
	 
    }
    
    public List<Bible> getBibleList()
    {
	return getGenericManager().getBibleList();
    }
    
    
    public JSONObject chapterNumber() throws JSONException {
	JSONObject p = new JSONObject();
	try {
	    bible =getGenericManager().getBibleById(bible.getId());
	    p.accumulate("returnValue", bible.getChapterNumber());
	    

	} catch (Exception e) {
	    p.accumulate("returnValue", "fail");
	    System.out.println("savePrayItem=" + e.toString());
	}
	return p;
    }  
    
    
    public ArrayList<JSONObject> todayBibleByMemberByJSON() throws Exception{   
        ArrayList<JSONObject> al = new ArrayList<JSONObject>(); 
        System.out.println("todayBibleByMemberByJSON member.id="+member.getId());     
        try{   
            
        TodayBible todaybible=new TodayBible();    	
    	Vector v=new Vector();
    	member=getGenericManager().getMemberById(member.getId());
    	System.out.println(member.getName());
    	everybible=getGenericManager().getEveryBibleByMember(member);
    	
    	Vector status=getTodayChapter(member);
    	int volume=Integer.parseInt(String.valueOf(status.get(0)));
    	int chapter=Integer.parseInt(String.valueOf(status.get(1)));
    	
    	System.out.println("***today status.get(0)="+status.get(0)+"--status.get(1)="+status.get(1));
    	System.out.println("today volume="+volume+"--today chapter="+chapter);
    	
    	Bible bible=getGenericManager().getBibleById(volume);
    	List<BibleLection> lection=getGenericManager().getBibleLection(volume,chapter);
    	
    	
    	
    	for(int i=0;i<lection.size();i++){
    	  BibleLection a=lection.get(i);
	  JSONObject p = new JSONObject();
	  p.accumulate("verse",a.getVerse());
	  p.accumulate("lection",a.getLection());
	  al.add(p);
	}
    	
    	System.out.println("Volume="+everybible.getVolume()+"--Chapter="+everybible.getChapter());
    	
        	
        }catch(Exception e){
        	
        }
        return al;
    }    
          
    
    public ArrayList<JSONObject> todayBibleJSON() throws Exception{   
        ArrayList<JSONObject> al = new ArrayList<JSONObject>(); 
        System.out.println("todayBibleJSON member.id="+member.getId());     
        try{               
        TodayBible todaybible=new TodayBible();    	
    	Vector v=new Vector();
    	member=getGenericManager().getMemberById(member.getId());
    	System.out.println(member.getName());
    	everybible=getGenericManager().getEveryBibleByMember(member);
    	
    	Vector status=getTodayChapter(member);
    	int volume=Integer.parseInt(String.valueOf(status.get(0)));
    	int chapter=Integer.parseInt(String.valueOf(status.get(1)));
    	Bible bible=getGenericManager().getBibleById(volume);
    	System.out.println("***today status.get(0)="+status.get(0)+"--status.get(1)="+status.get(1));
    	System.out.println("today volume="+volume+"--today chapter="+chapter);
    	
    	Date d=Tools.convertToDate(myday);
    	
    	JSONObject p = new JSONObject();
    	p.accumulate("bibleFullName",bible.getFullName());
    	p.accumulate("chapter",chapter);
    	p.accumulate("myday",myday);
    	p.accumulate("week",d.getDay());
    	al.add(p);
    	
    	
    	 	
        }catch(Exception e){
        	
        }
        return al;
    }    
    
    
    
    public ArrayList<JSONObject> volumeByJSON() throws Exception{   
        ArrayList<JSONObject> al = new ArrayList<JSONObject>();       
        try{     
    	List<LivelyBible> ls=getGenericManager().getLivelyBibleList(Tools.getLivelyBibleDate());
    	for(int i=0;i<ls.size();i++){
    	  LivelyBible a=ls.get(i);
    	  bible=getGenericManager().getBibleById(a.getVolume());
    	  JSONObject p = new JSONObject();
    	  p.accumulate("bible",bible.getShortName());
    	  p.accumulate("volume",a.getVolume());
    	  p.accumulate("classify",a.getClassify());
    	  al.add(p);    	 
    	 }    	 	
        }catch(Exception e){
          System.out.println("volumeByJSON error="+e.toString());	
        }
        return al;
    }    
   

}
