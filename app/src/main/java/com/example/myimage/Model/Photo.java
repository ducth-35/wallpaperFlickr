package com.example.myimage.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Photo implements Parcelable {
    public String views_format;

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("owner")
    @Expose
    private String owner;
    @SerializedName("secret")
    @Expose
    private String secret;
    @SerializedName("server")
    @Expose
    private String server;
    @SerializedName("farm")
    @Expose
    private Integer farm;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("ispublic")
    @Expose
    private Integer ispublic;
    @SerializedName("isfriend")
    @Expose
    private Integer isfriend;
    @SerializedName("isfamily")
    @Expose
    private Integer isfamily;
    @SerializedName("views")
    @Expose
    private String views;
    @SerializedName("date_faved")
    @Expose
    private String dateFaved;
    @SerializedName("media")
    @Expose
    private String media;
    @SerializedName("media_status")
    @Expose
    private String mediaStatus;
    @SerializedName("url_sq")
    @Expose
    private String urlSq;
    @SerializedName("height_sq")
    @Expose
    private Integer heightSq;
    @SerializedName("width_sq")
    @Expose
    private Integer widthSq;
    @SerializedName("url_t")
    @Expose
    private String urlT;
    @SerializedName("height_t")
    @Expose
    private String heightT;
    @SerializedName("width_t")
    @Expose
    private String widthT;
    @SerializedName("url_s")
    @Expose
    private String urlS;
    @SerializedName("height_s")
    @Expose
    private String heightS;
    @SerializedName("width_s")
    @Expose
    private String widthS;
    @SerializedName("url_q")
    @Expose
    private String urlQ;
    @SerializedName("height_q")
    @Expose
    private String heightQ;
    @SerializedName("width_q")
    @Expose
    private String widthQ;
    @SerializedName("url_m")
    @Expose
    private String urlM;
    @SerializedName("height_m")
    @Expose
    private String heightM;
    @SerializedName("width_m")
    @Expose
    private String widthM;
    @SerializedName("url_n")
    @Expose
    private String urlN;
    @SerializedName("height_n")
    @Expose
    private Integer heightN;
    @SerializedName("width_n")
    @Expose
    private String widthN;
    @SerializedName("url_z")
    @Expose
    private String urlZ;
    @SerializedName("height_z")
    @Expose
    private String heightZ;
    @SerializedName("width_z")
    @Expose
    private String widthZ;
    @SerializedName("url_c")
    @Expose
    private String urlC;
    @SerializedName("height_c")
    @Expose
    private Integer heightC;
    @SerializedName("width_c")
    @Expose
    private String widthC;
    @SerializedName("url_l")
    @Expose
    private String urlL;
    @SerializedName("height_l")
    @Expose
    private String heightL;
    @SerializedName("width_l")
    @Expose
    private String widthL;
    @SerializedName("url_o")
    @Expose
    private String urlO;
    @SerializedName("height_o")
    @Expose
    private String heightO;
    @SerializedName("width_o")
    @Expose
    private String widthO;
    @SerializedName("pathalias")
    @Expose
    private String pathalias;

    protected Photo(Parcel in) {
        views_format = in.readString();
        id = in.readString();
        owner = in.readString();
        secret = in.readString();
        server = in.readString();
        if (in.readByte() == 0) {
            farm = null;
        } else {
            farm = in.readInt();
        }
        title = in.readString();
        if (in.readByte() == 0) {
            ispublic = null;
        } else {
            ispublic = in.readInt();
        }
        if (in.readByte() == 0) {
            isfriend = null;
        } else {
            isfriend = in.readInt();
        }
        if (in.readByte() == 0) {
            isfamily = null;
        } else {
            isfamily = in.readInt();
        }
        views = in.readString();
        dateFaved = in.readString();
        media = in.readString();
        mediaStatus = in.readString();
        urlSq = in.readString();
        if (in.readByte() == 0) {
            heightSq = null;
        } else {
            heightSq = in.readInt();
        }
        if (in.readByte() == 0) {
            widthSq = null;
        } else {
            widthSq = in.readInt();
        }
        urlT = in.readString();
        heightT = in.readString();
        widthT = in.readString();
        urlS = in.readString();
        heightS = in.readString();
        widthS = in.readString();
        urlQ = in.readString();
        heightQ = in.readString();
        widthQ = in.readString();
        urlM = in.readString();
        heightM = in.readString();
        widthM = in.readString();
        urlN = in.readString();
        if (in.readByte() == 0) {
            heightN = null;
        } else {
            heightN = in.readInt();
        }
        widthN = in.readString();
        urlZ = in.readString();
        heightZ = in.readString();
        widthZ = in.readString();
        urlC = in.readString();
        if (in.readByte() == 0) {
            heightC = null;
        } else {
            heightC = in.readInt();
        }
        widthC = in.readString();
        urlL = in.readString();
        heightL = in.readString();
        widthL = in.readString();
        urlO = in.readString();
        heightO = in.readString();
        widthO = in.readString();
        pathalias = in.readString();
    }

    public Photo() {

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(views_format);
        dest.writeString(id);
        dest.writeString(owner);
        dest.writeString(secret);
        dest.writeString(server);
        if (farm == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(farm);
        }
        dest.writeString(title);
        if (ispublic == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(ispublic);
        }
        if (isfriend == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(isfriend);
        }
        if (isfamily == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(isfamily);
        }
        dest.writeString(views);
        dest.writeString(dateFaved);
        dest.writeString(media);
        dest.writeString(mediaStatus);
        dest.writeString(urlSq);
        if (heightSq == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(heightSq);
        }
        if (widthSq == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(widthSq);
        }
        dest.writeString(urlT);
        dest.writeString(heightT);
        dest.writeString(widthT);
        dest.writeString(urlS);
        dest.writeString(heightS);
        dest.writeString(widthS);
        dest.writeString(urlQ);
        dest.writeString(heightQ);
        dest.writeString(widthQ);
        dest.writeString(urlM);
        dest.writeString(heightM);
        dest.writeString(widthM);
        dest.writeString(urlN);
        if (heightN == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(heightN);
        }
        dest.writeString(widthN);
        dest.writeString(urlZ);
        dest.writeString(heightZ);
        dest.writeString(widthZ);
        dest.writeString(urlC);
        if (heightC == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(heightC);
        }
        dest.writeString(widthC);
        dest.writeString(urlL);
        dest.writeString(heightL);
        dest.writeString(widthL);
        dest.writeString(urlO);
        dest.writeString(heightO);
        dest.writeString(widthO);
        dest.writeString(pathalias);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Photo> CREATOR = new Creator<Photo>() {
        @Override
        public Photo createFromParcel(Parcel in) {
            return new Photo(in);
        }

        @Override
        public Photo[] newArray(int size) {
            return new Photo[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public Integer getFarm() {
        return farm;
    }

    public void setFarm(Integer farm) {
        this.farm = farm;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getIspublic() {
        return ispublic;
    }

    public void setIspublic(Integer ispublic) {
        this.ispublic = ispublic;
    }

    public Integer getIsfriend() {
        return isfriend;
    }

    public void setIsfriend(Integer isfriend) {
        this.isfriend = isfriend;
    }

    public Integer getIsfamily() {
        return isfamily;
    }

    public void setIsfamily(Integer isfamily) {
        this.isfamily = isfamily;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getDateFaved()    {
        return dateFaved;
    }

    public void setDateFaved(String dateFaved) {
        this.dateFaved = dateFaved;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getMediaStatus() {
        return mediaStatus;
    }

    public void setMediaStatus(String mediaStatus) {
        this.mediaStatus = mediaStatus;
    }

    public String getUrlSq() {
        return urlSq;
    }

    public void setUrlSq(String urlSq) {
        this.urlSq = urlSq;
    }

    public Integer getHeightSq() {
        return heightSq;
    }

    public void setHeightSq(Integer heightSq) {
        this.heightSq = heightSq;
    }

    public Integer getWidthSq() {
        return widthSq;
    }

    public void setWidthSq(Integer widthSq) {
        this.widthSq = widthSq;
    }

    public String getUrlT() {
        return urlT;
    }

    public void setUrlT(String urlT) {
        this.urlT = urlT;
    }

    public String getHeightT() {
        return heightT;
    }

    public void setHeightT(String heightT) {
        this.heightT = heightT;
    }

    public String getWidthT() {
        return widthT;
    }

    public void setWidthT(String widthT) {
        this.widthT = widthT;
    }

    public String getUrlS() {
        return urlS;
    }

    public void setUrlS(String urlS) {
        this.urlS = urlS;
    }

    public String getHeightS() {
        return heightS;
    }

    public void setHeightS(String heightS) {
        this.heightS = heightS;
    }

    public String getWidthS() {
        return widthS;
    }

    public void setWidthS(String widthS) {
        this.widthS = widthS;
    }

    public String getUrlQ() {
        return urlQ;
    }

    public void setUrlQ(String urlQ) {
        this.urlQ = urlQ;
    }

    public String getHeightQ() {
        return heightQ;
    }

    public void setHeightQ(String heightQ) {
        this.heightQ = heightQ;
    }

    public String getWidthQ() {
        return widthQ;
    }

    public void setWidthQ(String widthQ) {
        this.widthQ = widthQ;
    }

    public String getUrlM() {
        return urlM;
    }

    public void setUrlM(String urlM) {
        this.urlM = urlM;
    }

    public String getHeightM() {
        return heightM;
    }

    public void setHeightM(String heightM) {
        this.heightM = heightM;
    }

    public String getWidthM() {
        return widthM;
    }

    public void setWidthM(String widthM) {
        this.widthM = widthM;
    }

    public String getUrlN() {
        return urlN;
    }

    public void setUrlN(String urlN) {
        this.urlN = urlN;
    }

    public Integer getHeightN() {
        return heightN;
    }

    public void setHeightN(Integer heightN) {
        this.heightN = heightN;
    }

    public String getWidthN() {
        return widthN;
    }

    public void setWidthN(String widthN) {
        this.widthN = widthN;
    }

    public String getUrlZ() {
        return urlZ;
    }

    public void setUrlZ(String urlZ) {
        this.urlZ = urlZ;
    }

    public String getHeightZ() {
        return heightZ;
    }

    public void setHeightZ(String heightZ) {
        this.heightZ = heightZ;
    }

    public String getWidthZ() {
        return widthZ;
    }

    public void setWidthZ(String widthZ) {
        this.widthZ = widthZ;
    }

    public String getUrlC() {
        return urlC;
    }

    public void setUrlC(String urlC) {
        this.urlC = urlC;
    }

    public Integer getHeightC() {
        return heightC;
    }

    public void setHeightC(Integer heightC) {
        this.heightC = heightC;
    }

    public String getWidthC() {
        return widthC;
    }

    public void setWidthC(String widthC) {
        this.widthC = widthC;
    }

    public String getUrlL() {
        return urlL;
    }

    public void setUrlL(String urlL) {
        this.urlL = urlL;
    }

    public String getHeightL() {
        return heightL;
    }

    public void setHeightL(String heightL) {
        this.heightL = heightL;
    }

    public String getWidthL() {
        return widthL;
    }

    public void setWidthL(String widthL) {
        this.widthL = widthL;
    }

    public String getUrlO() {
        return urlO;
    }

    public void setUrlO(String urlO) {
        this.urlO = urlO;
    }

    public String getHeightO() {
        return heightO;
    }

    public void setHeightO(String heightO) {
        this.heightO = heightO;
    }

    public String getWidthO() {
        return widthO;
    }

    public void setWidthO(String widthO) {
        this.widthO = widthO;
    }

    public String getPathalias() {
        return pathalias;
    }

    public void setPathalias(String pathalias) {
        this.pathalias = pathalias;
    }
}
