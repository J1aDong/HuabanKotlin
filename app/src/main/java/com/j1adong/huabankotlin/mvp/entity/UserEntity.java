package com.j1adong.huabankotlin.mvp.entity;

/**
 * Created by J1aDong on 2017/1/9.
 */
public class UserEntity
{
	/**
	 * user_id : 16747409 username : Linsay_007 urlname : vft6gqahf4 created_at
	 * : 1420952886 avatar :
	 * {"id":66172167,"farm":"farm1","bucket":"hbimg","key":"3316893cb6e98ee0b534c267dca9ca45609207331146-Eyg56i","type":"image/jpeg","width":100,"height":100,"frames":1}
	 * extra : null
	 */

	private int user_id;
	private String username;
	private String urlname;
	private int created_at;
	private AvatarEntity avatar;
	private Object extra;

	public int getUser_id()
	{
		return user_id;
	}

	public void setUser_id(int user_id)
	{
		this.user_id = user_id;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getUrlname()
	{
		return urlname;
	}

	public void setUrlname(String urlname)
	{
		this.urlname = urlname;
	}

	public int getCreated_at()
	{
		return created_at;
	}

	public void setCreated_at(int created_at)
	{
		this.created_at = created_at;
	}

	public AvatarEntity getAvatar()
	{
		return avatar;
	}

	public void setAvatar(AvatarEntity avatar)
	{
		this.avatar = avatar;
	}

	public Object getExtra()
	{
		return extra;
	}

	public void setExtra(Object extra)
	{
		this.extra = extra;
	}

}
