package com.sample.product.entity;

public class Songs_name {
	private int album_id;
	private int song_order;
	private String songs_name;
	private int songs_idcol;

	public int getAlbum_id() {
		return album_id;
	}

	public void setAlbum_id(int album_id) {
		this.album_id = album_id;
	}

	public int getSong_order() {
		return song_order;
	}

	public void setSong_order(int song_order) {
		this.song_order = song_order;
	}

	public String getSongs_name() {
		return songs_name;
	}

	public void setSongs_name(String songs_name) {
		this.songs_name = songs_name;
	}

	public int getSongs_idcol() {
		return songs_idcol;
	}

	public void setSongs_idcol(int songs_idcol) {
		this.songs_idcol = songs_idcol;
	}

}
