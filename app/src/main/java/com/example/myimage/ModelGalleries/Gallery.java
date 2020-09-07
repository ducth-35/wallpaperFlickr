package com.example.myimage.ModelGalleries;

import android.icu.text.CaseMap;
import android.util.EventLogTags;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Gallery extends PrimaryPhotoExtras {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("gallery_id")
    @Expose
    private String galleryId;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("owner")
    @Expose
    private String owner;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("iconserver")
    @Expose
    private Integer iconserver;
    @SerializedName("iconfarm")
    @Expose
    private Integer iconfarm;
    @SerializedName("primary_photo_id")
    @Expose
    private String primaryPhotoId;
    @SerializedName("date_create")
    @Expose
    private String dateCreate;
    @SerializedName("date_update")
    @Expose
    private String dateUpdate;
    @SerializedName("count_photos")
    @Expose
    private Integer countPhotos;
    @SerializedName("count_videos")
    @Expose
    private Integer countVideos;
    @SerializedName("count_total")
    @Expose
    private Integer countTotal;
    @SerializedName("count_views")
    @Expose
    private Integer countViews;
    @SerializedName("count_comments")
    @Expose
    private Integer countComments;
    @SerializedName("title")
    @Expose
    private Title title;
    @SerializedName("description")
    @Expose
    private Description description;
    @SerializedName("sort_group")
    @Expose
    private String sortGroup;
    @SerializedName("primary_photo_server")
    @Expose
    private String primaryPhotoServer;
    @SerializedName("primary_photo_farm")
    @Expose
    private Integer primaryPhotoFarm;
    @SerializedName("primary_photo_secret")
    @Expose
    private String primaryPhotoSecret;
    @SerializedName("primary_photo_extras")
    @Expose
    private PrimaryPhotoExtras primaryPhotoExtras;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGalleryId() {
        return galleryId;
    }

    public void setGalleryId(String galleryId) {
        this.galleryId = galleryId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getIconserver() {
        return iconserver;
    }

    public void setIconserver(Integer iconserver) {
        this.iconserver = iconserver;
    }

    public Integer getIconfarm() {
        return iconfarm;
    }

    public void setIconfarm(Integer iconfarm) {
        this.iconfarm = iconfarm;
    }

    public String getPrimaryPhotoId() {
        return primaryPhotoId;
    }

    public void setPrimaryPhotoId(String primaryPhotoId) {
        this.primaryPhotoId = primaryPhotoId;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(String dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public Integer getCountPhotos() {
        return countPhotos;
    }

    public void setCountPhotos(Integer countPhotos) {
        this.countPhotos = countPhotos;
    }

    public Integer getCountVideos() {
        return countVideos;
    }

    public void setCountVideos(Integer countVideos) {
        this.countVideos = countVideos;
    }

    public Integer getCountTotal() {
        return countTotal;
    }

    public void setCountTotal(Integer countTotal) {
        this.countTotal = countTotal;
    }

    public Integer getCountViews() {
        return countViews;
    }

    public void setCountViews(Integer countViews) {
        this.countViews = countViews;
    }

    public Integer getCountComments() {
        return countComments;
    }

    public void setCountComments(Integer countComments) {
        this.countComments = countComments;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public String getSortGroup() {
        return sortGroup;
    }

    public void setSortGroup(String sortGroup) {
        this.sortGroup = sortGroup;
    }

    public String getPrimaryPhotoServer() {
        return primaryPhotoServer;
    }

    public void setPrimaryPhotoServer(String primaryPhotoServer) {
        this.primaryPhotoServer = primaryPhotoServer;
    }

    public Integer getPrimaryPhotoFarm() {
        return primaryPhotoFarm;
    }

    public void setPrimaryPhotoFarm(Integer primaryPhotoFarm) {
        this.primaryPhotoFarm = primaryPhotoFarm;
    }

    public String getPrimaryPhotoSecret() {
        return primaryPhotoSecret;
    }

    public void setPrimaryPhotoSecret(String primaryPhotoSecret) {
        this.primaryPhotoSecret = primaryPhotoSecret;
    }

    public PrimaryPhotoExtras getPrimaryPhotoExtras() {
        return primaryPhotoExtras;
    }

    public void setPrimaryPhotoExtras(PrimaryPhotoExtras primaryPhotoExtras) {
        this.primaryPhotoExtras = primaryPhotoExtras;
    }

}
