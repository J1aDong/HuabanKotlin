package com.j1adong.huabankotlin.adapter;

/**
 * Created by J1aDong on 2017/1/14.
 */

public class Footer
{
	public static final String LoadMore = "loadmore";

    public Footer(String type) {
        this.type = type;
    }

    private String type;

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}
}
