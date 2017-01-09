package com.j1adong.huabankotlin.mvp.entity;

/**
 * Created by J1aDong on 2017/1/9.
 */
public class FileEntity
{
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
}
