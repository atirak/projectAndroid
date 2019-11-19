package buu.informatics.s59160624.daydiary.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface DiaryDatabaseDAO{


    @Insert
    fun insert(date: Diary)


    @Query("SELECT * from DiaryItem WHERE id = :key")
    fun get(key: Long): Diary?

    @Query("SELECT * FROM DiaryItem ORDER BY date DESC")
    fun getAll(): LiveData<List<Diary>>

    @Query("SELECT * FROM DiaryItem  WHERE date = :date ORDER BY date DESC")
    fun getSameDate(date:String): LiveData<List<Diary>>

    @Query("SELECT * FROM DiaryItem ORDER BY date DESC LIMIT 1")
    fun getDate(): Diary?

    @Query("SELECT COUNT(*) FROM DiaryItem WHERE mood = :key GROUP BY mood")
    fun getMood(key: String):Int?

}