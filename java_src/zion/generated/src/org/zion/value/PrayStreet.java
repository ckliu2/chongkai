package org.zion.value;

import com.base.value.UploadedFile;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class PrayStreet extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** persistent field */
    private String name;

    /** nullable persistent field */
    private String latitude;

    /** nullable persistent field */
    private String longitude;

    /** nullable persistent field */
    private Integer zoom;

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
    private org.zion.value.PrayTW praytw;
    private Long praytwId;

    /** full constructor */
    public PrayStreet(String name, String latitude, String longitude, Integer zoom, UploadedFile map, UploadedFile photo1, UploadedFile photo2, UploadedFile photo3, org.zion.value.PrayTW praytw) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.zoom = zoom;
        this.map = map;
        this.photo1 = photo1;
        this.photo2 = photo2;
        this.photo3 = photo3;
        this.praytw = praytw;
    }

    /** default constructor */
    public PrayStreet() {
    }

    /** minimal constructor */
    public PrayStreet(String name, org.zion.value.PrayTW praytw) {
        this.name = name;
        this.praytw = praytw;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Integer getZoom() {
        return this.zoom;
    }

    public void setZoom(Integer zoom) {
        this.zoom = zoom;
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

    public org.zion.value.PrayTW getPraytw() {
        return this.praytw;
    }

    public void setPraytw(org.zion.value.PrayTW praytw) {
        this.praytw = praytw;
    }

    public Long getPraytwId() {
        if (this.praytw != null && this.praytw.getId() != null)
            return praytw.getId();
        return this.praytwId;
    }

    public void setPraytwId(Long id) {
        this.praytwId = id;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("name", getName())
            .append("latitude", getLatitude())
            .append("longitude", getLongitude())
            .append("zoom", getZoom())
            .append("map", getMap())
            .append("photo1", getPhoto1())
            .append("photo2", getPhoto2())
            .append("photo3", getPhoto3())
            .append("praytw", getPraytw())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
