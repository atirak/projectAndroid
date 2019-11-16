package buu.informatics.s59160624.daydiary.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "DiaryItem")
data class Diary(
    @PrimaryKey(autoGenerate = true) var id: Int,
    @ColumnInfo(name = "date") var date:String ,
    @ColumnInfo(name = "dateTime") var dateTime:String ,
    @ColumnInfo(name = "mood") var mood: String,
    @ColumnInfo(name = "content") var content: String
)

