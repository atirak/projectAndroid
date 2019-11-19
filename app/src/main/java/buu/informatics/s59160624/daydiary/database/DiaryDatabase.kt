package buu.informatics.s59160624.daydiary.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities =  [Diary::class], version = 1)
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

//    abstract fun diaryDAO():DiaryDatabaseDAO
//
//    companion object {
//        fun getAppDatabase(context: Context): DiaryDatabase =
//            Room.databaseBuilder(context, DiaryDatabase::class.java, "DiaryItem").build()
//    }

//    companion object {
//        @Volatile private var instance: DiaryDatabase? = null
//        private val LOCK = Any()
//
//        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
//            instance ?: buildDatabase(context).also { instance = it}
//        }
//
//        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
//            DiaryDatabase::class.java, "todo-list.db")
//            .build()
//    }
}