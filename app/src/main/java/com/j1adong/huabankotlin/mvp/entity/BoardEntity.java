package com.j1adong.huabankotlin.mvp.entity;

/**
 * Created by J1aDong on 2017/1/9.
 */
public class BoardEntity
{
	/**
	 * board_id : 30113080 user_id : 16747409 title : 空间设计 description :
	 * category_id : industrial_design seq : 2 pin_count : 168 follow_count : 13
	 * like_count : 0 created_at : 1465092691 updated_at : 1483935128 deleting :
	 * 0 is_private : 0 extra : null
	 */

	private int board_id;
	private int user_id;
	private String title;
	private String description;
	private String category_id;
	private int seq;
	private int pin_count;
	private int follow_count;
	private int like_count;
	private int created_at;
	private int updated_at;
	private int deleting;
	private int is_private;
	private Object extra;

	public int getBoard_id()
	{
		return board_id;
	}

	public void setBoard_id(int board_id)
	{
		this.board_id = board_id;
	}

	public int getUser_id()
	{
		return user_id;
	}

	public void setUser_id(int user_id)
	{
		this.user_id = user_id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getCategory_id()
	{
		return category_id;
	}

	public void setCategory_id(String category_id)
	{
		this.category_id = category_id;
	}

	public int getSeq()
	{
		return seq;
	}

	public void setSeq(int seq)
	{
		this.seq = seq;
	}

	public int getPin_count()
	{
		return pin_count;
	}

	public void setPin_count(int pin_count)
	{
		this.pin_count = pin_count;
	}

	public int getFollow_count()
	{
		return follow_count;
	}

	public void setFollow_count(int follow_count)
	{
		this.follow_count = follow_count;
	}

	public int getLike_count()
	{
		return like_count;
	}

	public void setLike_count(int like_count)
	{
		this.like_count = like_count;
	}

	public int getCreated_at()
	{
		return created_at;
	}

	public void setCreated_at(int created_at)
	{
		this.created_at = created_at;
	}

	public int getUpdated_at()
	{
		return updated_at;
	}

	public void setUpdated_at(int updated_at)
	{
		this.updated_at = updated_at;
	}

	public int getDeleting()
	{
		return deleting;
	}

	public void setDeleting(int deleting)
	{
		this.deleting = deleting;
	}

	public int getIs_private()
	{
		return is_private;
	}

	public void setIs_private(int is_private)
	{
		this.is_private = is_private;
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
