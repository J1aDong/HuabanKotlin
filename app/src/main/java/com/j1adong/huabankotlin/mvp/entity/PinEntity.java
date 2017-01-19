package com.j1adong.huabankotlin.mvp.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by J1aDong on 2017/1/9.
 */
public class PinEntity implements Parcelable {
	/**
	 * pin_id : 986620977 user_id : 16747409 board_id : 30113080 file_id :
	 * 25881667 file :
	 * {"id":25881667,"farm":"farm1","bucket":"hbimg","key":"0c71c87e9b6b3cbd24424e39bbb40f2a13fb94ba4ba5a-QABsrN","type":"image/jpeg","width":600,"height":450,"frames":1,"theme":"130F1A"}
	 * media_type : 0 source : mt-bbs.com link :
	 * http://www.mt-bbs.com/forum.php?mod=viewthread&tid=214686&from=&attachpage=2#pid3611541
	 * raw_text : 【新提醒】国外儿童主题商场 - 商业空间 - MT-BBS text_meta : {} via : 95901286
	 * via_user_id : 7895409 original : 95901286 created_at : 1483935128
	 * like_count : 0 comment_count : 0 repin_count : 0 is_private : 0
	 * orig_source : null user :
	 * {"user_id":16747409,"username":"Linsay_007","urlname":"vft6gqahf4","created_at":1420952886,"avatar":{"id":66172167,"farm":"farm1","bucket":"hbimg","key":"3316893cb6e98ee0b534c267dca9ca45609207331146-Eyg56i","type":"image/jpeg","width":100,"height":100,"frames":1},"extra":null}
	 * board :
	 * {"board_id":30113080,"user_id":16747409,"title":"空间设计","description":"","category_id":"industrial_design","seq":2,"pin_count":168,"follow_count":13,"like_count":0,"created_at":1465092691,"updated_at":1483935128,"deleting":0,"is_private":0,"extra":null}
	 * via_user :
	 * {"user_id":7895409,"username":"彭猫","urlname":"k330f9egno","created_at":1369718327,"avatar":{"id":17438740,"farm":"farm1","bucket":"hbimg","key":"d5981facaf7e2bf2812792ebb79489d3b76baa1c348e-r3OCCE","type":"image/jpeg","width":160,"height":126,"frames":1},"extra":null}
	 */

	private int pin_id;
	private int user_id;
	private int board_id;
	private int file_id;
	private FileEntity file;
	private int media_type;
	private String source;
	private String link;
	private String raw_text;
	private int via;
	private int via_user_id;
	private int original;
	private int created_at;
	private int like_count;
	private int comment_count;
	private int repin_count;
	private int is_private;
	private UserEntity user;
	private BoardEntity board;
	private ViaUserEntity via_user;

	public int getPin_id()
	{
		return pin_id;
	}

	public void setPin_id(int pin_id)
	{
		this.pin_id = pin_id;
	}

	public int getUser_id()
	{
		return user_id;
	}

	public void setUser_id(int user_id)
	{
		this.user_id = user_id;
	}

	public int getBoard_id()
	{
		return board_id;
	}

	public void setBoard_id(int board_id)
	{
		this.board_id = board_id;
	}

	public int getFile_id()
	{
		return file_id;
	}

	public void setFile_id(int file_id)
	{
		this.file_id = file_id;
	}

	public FileEntity getFile()
	{
		return file;
	}

	public void setFile(FileEntity file)
	{
		this.file = file;
	}

	public int getMedia_type()
	{
		return media_type;
	}

	public void setMedia_type(int media_type)
	{
		this.media_type = media_type;
	}

	public String getSource()
	{
		return source;
	}

	public void setSource(String source)
	{
		this.source = source;
	}

	public String getLink()
	{
		return link;
	}

	public void setLink(String link)
	{
		this.link = link;
	}

	public String getRaw_text()
	{
		return raw_text;
	}

	public void setRaw_text(String raw_text)
	{
		this.raw_text = raw_text;
	}

	public int getVia()
	{
		return via;
	}

	public void setVia(int via)
	{
		this.via = via;
	}

	public int getVia_user_id()
	{
		return via_user_id;
	}

	public void setVia_user_id(int via_user_id)
	{
		this.via_user_id = via_user_id;
	}

	public int getOriginal()
	{
		return original;
	}

	public void setOriginal(int original)
	{
		this.original = original;
	}

	public int getCreated_at()
	{
		return created_at;
	}

	public void setCreated_at(int created_at)
	{
		this.created_at = created_at;
	}

	public int getLike_count()
	{
		return like_count;
	}

	public void setLike_count(int like_count)
	{
		this.like_count = like_count;
	}

	public int getComment_count()
	{
		return comment_count;
	}

	public void setComment_count(int comment_count)
	{
		this.comment_count = comment_count;
	}

	public int getRepin_count()
	{
		return repin_count;
	}

	public void setRepin_count(int repin_count)
	{
		this.repin_count = repin_count;
	}

	public int getIs_private()
	{
		return is_private;
	}

	public void setIs_private(int is_private)
	{
		this.is_private = is_private;
	}


	public UserEntity getUser()
	{
		return user;
	}

	public void setUser(UserEntity user)
	{
		this.user = user;
	}

	public BoardEntity getBoard()
	{
		return board;
	}

	public void setBoard(BoardEntity board)
	{
		this.board = board;
	}

	public ViaUserEntity getVia_user()
	{
		return via_user;
	}

	public void setVia_user(ViaUserEntity via_user)
	{
		this.via_user = via_user;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(this.pin_id);
		dest.writeInt(this.user_id);
		dest.writeInt(this.board_id);
		dest.writeInt(this.file_id);
		dest.writeParcelable(this.file, flags);
		dest.writeInt(this.media_type);
		dest.writeString(this.source);
		dest.writeString(this.link);
		dest.writeString(this.raw_text);
		dest.writeInt(this.via);
		dest.writeInt(this.via_user_id);
		dest.writeInt(this.original);
		dest.writeInt(this.created_at);
		dest.writeInt(this.like_count);
		dest.writeInt(this.comment_count);
		dest.writeInt(this.repin_count);
		dest.writeInt(this.is_private);
		dest.writeParcelable(this.user, flags);
		dest.writeParcelable(this.board, flags);
		dest.writeParcelable(this.via_user, flags);
	}

	public PinEntity() {
	}

	protected PinEntity(Parcel in) {
		this.pin_id = in.readInt();
		this.user_id = in.readInt();
		this.board_id = in.readInt();
		this.file_id = in.readInt();
		this.file = in.readParcelable(FileEntity.class.getClassLoader());
		this.media_type = in.readInt();
		this.source = in.readString();
		this.link = in.readString();
		this.raw_text = in.readString();
		this.via = in.readInt();
		this.via_user_id = in.readInt();
		this.original = in.readInt();
		this.created_at = in.readInt();
		this.like_count = in.readInt();
		this.comment_count = in.readInt();
		this.repin_count = in.readInt();
		this.is_private = in.readInt();
		this.user = in.readParcelable(UserEntity.class.getClassLoader());
		this.board = in.readParcelable(BoardEntity.class.getClassLoader());
		this.via_user = in.readParcelable(ViaUserEntity.class.getClassLoader());
	}

	public static final Parcelable.Creator<PinEntity> CREATOR = new Parcelable.Creator<PinEntity>() {
		@Override
		public PinEntity createFromParcel(Parcel source) {
			return new PinEntity(source);
		}

		@Override
		public PinEntity[] newArray(int size) {
			return new PinEntity[size];
		}
	};
}
