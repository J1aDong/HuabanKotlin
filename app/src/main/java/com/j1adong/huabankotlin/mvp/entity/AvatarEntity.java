package com.j1adong.huabankotlin.mvp.entity;

/**
 * Created by J1aDong on 2017/1/9.
 */
public class AvatarEntity
{
	/**
	 * id : 66172167 farm : farm1 bucket : hbimg key :
	 * 3316893cb6e98ee0b534c267dca9ca45609207331146-Eyg56i type : image/jpeg
	 * width : 100 height : 100 frames : 1
	 */

	private int id;
	private String farm;
	private String bucket;
	private String key;
	private String type;
	private int width;
	private int height;
	private int frames;

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
}
