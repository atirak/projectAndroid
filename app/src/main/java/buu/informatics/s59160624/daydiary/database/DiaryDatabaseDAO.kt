package buu.informatics.s59160624.daydiary.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DiaryDatabaseDAO{



    @Query("SELECT * FROM DiaryItem WHERE date LIKE :title")
    fun findByTitle(title: String): LiveData<List<Diary>>


    @Insert
    fun insert(diary: Diary)
}