package com.j1adong.huabankotlin.mvp.entity;

/**
 * Created by J1aDong on 2017/1/9.
 */
public class ViaUserEntity
{
	/**
	 * user_id : 7895409 username : 彭猫 urlname : k330f9egno created_at :
	 * 1369718327 avatar :
	 * {"id":17438740,"farm":"farm1","bucket":"hbimg","key":"d5981facaf7e2bf2812792ebb79489d3b76baa1c348e-r3OCCE","type":"image/jpeg","width":160,"height":126,"frames":1}
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
