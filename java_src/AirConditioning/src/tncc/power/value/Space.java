package tncc.power.value;

import com.common.value.Member;
import java.io.Serializable;
import java.util.*;

import org.apache.commons.lang.builder.ToStringBuilder;
import tncc.wpc.value.Building;

import com.base.value.AppProperty;
import com.base.value.BaseObject;
import com.base.value.FunctionAuthority;



/** @author Hibernate CodeGenerator */
public class Space extends BaseObject implements Serializable {


    private static final long serialVersionUID = 1L;
    
	private Long id;
	
	
    /** persistent field */
    private String name;

    /** persistent field */
    private Date createdDate;

    /** persistent field */
    private Member createdUser;
    private Long createdUserId;

    /** persistent field */
    private Building building;
    private Long buildingId;
    
    private AppProperty readerType;
    private Long readerTypeId;
    

    /** nullable persistent field */
    private List reader;
    //private List<Reader> reader = new java.util.ArrayList<Reader>();

	/** full constructor */
    public Space(String name, Date createdDate, Member createdUser, Building building, List reader) {
        this.name = name;
        this.createdDate = createdDate;
        this.createdUser = createdUser;
        this.building = building;
        this.reader = reader;
    }

    /** Labor constructor */
    public Space() {
    }

    /** minimal constructor */
    public Space(String name, Date createdDate, Member createdUser, Building building) {
        this.name = name;
        this.createdDate = createdDate;
        this.createdUser = createdUser;
        this.building = building;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Member getCreatedUser() {
        return this.createdUser;
    }

    public void setCreatedUser(Member createdUser) {
        this.createdUser = createdUser;
    }

    public Long getCreatedUserId() {
        if (this.createdUser != null && this.createdUser.getId() != null)
            return createdUser.getId();
        return this.createdUserId;
    }

    public void setCreatedUserId(Long id) {
        this.createdUserId = id;
    }

    public Building getBuilding() {
        return this.building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Long getBuildingId() {
        if (this.building != null && this.building.getId() != null)
            return building.getId();
        return this.buildingId;
    }

    public void setBuildingId(Long id) {
        this.buildingId = id;
    }
    
    public List getReader() {
		return reader;
	}
/*
    public List getReader() {
    	ArrayList<Reader>  rs=new ArrayList();
    	List<Reader> reader=this.reader;
    	ArrayList<String>  al=new ArrayList();
    	try{
    	    for(int i=0;i<reader.size();i++){    		
    		  al.add(String.valueOf(reader.get(i)));
    	    }    	
    	   Collections.sort(al);
    	    for(int j=0;j<al.size();j++){    		
    		  Reader r= new Reader(al.get(j));
    		  rs.add( r );
    	    }   	
    	}catch(Exception e){
    		System.out.println(e.toString());
    	}
        return rs;
    }
    */

    public void setReader(List reader) {
        this.reader = reader;
    }
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public AppProperty getReaderType() {
        return this.readerType;
    }

    public void setReaderType(AppProperty readerType) {
        this.readerType = readerType;
    }

    public Long getReaderTypeId() {
        if (this.readerType != null && this.readerType.getId() != null)
            return readerType.getId();
        return this.readerTypeId;
    }

    public void setReaderTypeId(Long id) {
        this.readerTypeId = id;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("name", getName())
            .append("createdDate", getCreatedDate())
            .append("createdUser", getCreatedUser())
            .append("building", getBuilding())
            .append("reader", getReader())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
