package org.zion.value;

import com.base.value.MiscCode;
import com.base.value.UploadedFile;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class PrayTW extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;

    Long id;

    /** persistent field */
    private String descriptionUrl;

    /** nullable persistent field */
    private UploadedFile map;
    private String mapFileName;
    private Long mapId;

    /** nullable persistent field */
    private UploadedFile photo1;
    private String photo1FileName;
    private Long photo1Id;

    /** nullable persistent field */
    private UploadedFile photo2;
    private String photo2FileName;
    private Long photo2Id;

    /** nullable persistent field */
    private UploadedFile photo3;
    private String photo3FileName;
    private Long photo3Id;

    /** persistent field */
    private MiscCode area;
    private Long areaId;

    String latitude,longitude;
    int zoom;

    /** full constructor */
    public PrayTW(String descriptionUrl, UploadedFile map, UploadedFile photo1,
	    UploadedFile photo2, UploadedFile photo3, MiscCode area) {
	this.descriptionUrl = descriptionUrl;
	this.map = map;
	this.photo1 = photo1;
	this.photo2 = photo2;
	this.photo3 = photo3;
	this.area = area;
    }

    /** default constructor */
    public PrayTW() {
    }

    /** minimal constructor */
    public PrayTW(String descriptionUrl, MiscCode area) {
	this.descriptionUrl = descriptionUrl;
	this.area = area;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getDescriptionUrl() {
	return this.descriptionUrl;
    }

    public void setDescriptionUrl(String descriptionUrl) {
	this.descriptionUrl = descriptionUrl;
    }

    public UploadedFile getMap() {
	return this.map;
    }

    public void setMap(UploadedFile map) {
	this.map = map;
    }

    public String getMapFileName() {
	return this.mapFileName;
    }

    public void setMapFileName(String val) {
	this.mapFileName = val;
    }

    public Long getMapId() {
	if (this.map != null && this.map.getId() != null)
	    return map.getId();
	return this.mapId;
    }

    public void setMapId(Long id) {
	this.mapId = id;
    }

    public UploadedFile getPhoto1() {
	return this.photo1;
    }

    public void setPhoto1(UploadedFile photo1) {
	this.photo1 = photo1;
    }

    public String getPhoto1FileName() {
	return this.photo1FileName;
    }

    public void setPhoto1FileName(String val) {
	this.photo1FileName = val;
    }

    public Long getPhoto1Id() {
	if (this.photo1 != null && this.photo1.getId() != null)
	    return photo1.getId();
	return this.photo1Id;
    }

    public void setPhoto1Id(Long id) {
	this.photo1Id = id;
    }

    public UploadedFile getPhoto2() {
	return this.photo2;
    }

    public void setPhoto2(UploadedFile photo2) {
	this.photo2 = photo2;
    }

    public String getPhoto2FileName() {
	return this.photo2FileName;
    }

    public void setPhoto2FileName(String val) {
	this.photo2FileName = val;
    }

    public Long getPhoto2Id() {
	if (this.photo2 != null && this.photo2.getId() != null)
	    return photo2.getId();
	return this.photo2Id;
    }

    public void setPhoto2Id(Long id) {
	this.photo2Id = id;
    }

    public UploadedFile getPhoto3() {
	return this.photo3;
    }

    public void setPhoto3(UploadedFile photo3) {
	this.photo3 = photo3;
    }

    public String getPhoto3FileName() {
	return this.photo3FileName;
    }

    public void setPhoto3FileName(String val) {
	this.photo3FileName = val;
    }

    public Long getPhoto3Id() {
	if (this.photo3 != null && this.photo3.getId() != null)
	    return photo3.getId();
	return this.photo3Id;
    }

    public void setPhoto3Id(Long id) {
	this.photo3Id = id;
    }

    public MiscCode getArea() {
	return this.area;
    }

    public void setArea(MiscCode area) {
	this.area = area;
    }

    public Long getAreaId() {
	if (this.area != null && this.area.getId() != null)
	    return area.getId();
	return this.areaId;
    }

    public void setAreaId(Long id) {
	this.areaId = id;
    }
    
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    
    public int getZoom() {
        return zoom;
    }

    public void setZoom(int zoom) {
        this.zoom = zoom;
    }

    public String toString() {
	return new ToStringBuilder(this)
		.append("descriptionUrl", getDescriptionUrl())
		.append("map", getMap()).append("photo1", getPhoto1())
		.append("photo2", getPhoto2()).append("photo3", getPhoto3())
		.append("area", getArea()).toString();
    }

    public String getCaption_() {
	return toString();
    }

}
