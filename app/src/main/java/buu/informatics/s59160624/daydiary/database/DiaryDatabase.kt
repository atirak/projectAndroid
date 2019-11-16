package buu.informatics.s59160624.daydiary.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Diary::class], version = 1,exportSchema = false)
abstract class DiaryDatabase : RoomDatabase(){
    abstract val diaryDatabaseDao : DiaryDatabaseDAO

    companion object{
        @Volatile
        private var INSTANCE : DiaryDatabase? = null

        fun getInstance(context: Context) : DiaryDatabase{
            synchronized(this){
                var instance = INSTANCE

                if(instance==null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DiaryDatabase::class.java,
                        "DiaryItem"

                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }
                return instance
            }
        }
    }
}