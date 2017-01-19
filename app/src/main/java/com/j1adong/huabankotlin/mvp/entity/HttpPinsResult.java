package com.j1adong.huabankotlin.mvp.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by J1aDong on 2017/1/9.
 */

public class HttpPinsResult
{

	private List<PinEntity> pins = new ArrayList<>();

	public List<PinEntity> getPins()
	{
		return pins;
	}

	public void setPins(List<PinEntity> pins)
	{
		pins.clear();
		this.pins.addAll(pins);
	}

}
