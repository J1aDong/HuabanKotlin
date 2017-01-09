package com.j1adong.huabankotlin.mvp.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by J1aDong on 2017/1/9.
 */

public class HbData
{

	private List<PinsEntity> pins = new ArrayList<>();

	public List<PinsEntity> getPins()
	{
		return pins;
	}

	public void setPins(List<PinsEntity> pins)
	{
		pins.clear();
		this.pins.addAll(pins);
	}

}
