package com.example.chatdb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ChatDB extends SQLiteOpenHelper{
	public ChatDB(Context context){
		super(context, "chat",null,1);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE Messages(id INT PRIMARY KEY,time LONG,text_msg TEXT, sender_id INT, room_id INT);");
		
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int old, int newVer) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS Messages;");
		onCreate(db);
		
	}
	public void insertMessage(int id,String msg, int room_id,int sender_id){
		SQLiteDatabase db = getWritableDatabase();
		db.execSQL("INSERT INTO Messages(id, time, text_msg, sender_id, room_id) " +
		"VALUES("+id+", "+System.currentTimeMillis()+",\""+msg+"\","+sender_id+","+room_id+");");
	}

}
