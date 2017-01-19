package com.j1adong.huabankotlin.mvp.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by J1aDong on 2017/1/9.
 */
public class FileEntity implements Parcelable {
	/**
	 * id : 25881667 farm : farm1 bucket : hbimg key :
	 * 0c71c87e9b6b3cbd24424e39bbb40f2a13fb94ba4ba5a-QABsrN type : image/jpeg
	 * width : 600 height : 450 frames : 1 theme : 130F1A
	 */

	private int id;
	private String farm;
	private String bucket;
	private String key;
	private String type;
	private int width;
	private int height;
	private int frames;
	private String theme;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getFarm()
	{
		return farm;
	}

	public void setFarm(String farm)
	{
		this.farm = farm;
	}

	public String getBucket()
	{
		return bucket;
	}

	public void setBucket(String bucket)
	{
		this.bucket = bucket;
	}

	public String getKey()
	{
		return key;
	}

	public void setKey(String key)
	{
		this.key = key;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public int getWidth()
	{
		return width;
	}

	public void setWidth(int width)
	{
		this.width = width;
	}

	public int getHeight()
	{
		return height;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}

	public int getFrames()
	{
		return frames;
	}

	public void setFrames(int frames)
	{
		this.frames = frames;
	}

	public String getTheme()
	{
		return theme;
	}

	public void setTheme(String theme)
	{
		this.theme = theme;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(this.id);
		dest.writeString(this.farm);
		dest.writeString(this.bucket);
		dest.writeString(this.key);
		dest.writeString(this.type);
		dest.writeInt(this.width);
		dest.writeInt(this.height);
		dest.writeInt(this.frames);
		dest.writeString(this.theme);
	}

	public FileEntity() {
	}

	protected FileEntity(Parcel in) {
		this.id = in.readInt();
		this.farm = in.readString();
		this.bucket = in.readString();
		this.key = in.readString();
		this.type = in.readString();
		this.width = in.readInt();
		this.height = in.readInt();
		this.frames = in.readInt();
		this.theme = in.readString();
	}

	public static final Parcelable.Creator<FileEntity> CREATOR = new Parcelable.Creator<FileEntity>() {
		@Override
		public FileEntity createFromParcel(Parcel source) {
			return new FileEntity(source);
		}

		@Override
		public FileEntity[] newArray(int size) {
			return new FileEntity[size];
		}
	};
}
