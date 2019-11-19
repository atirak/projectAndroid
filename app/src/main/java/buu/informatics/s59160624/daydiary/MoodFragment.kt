package buu.informatics.s59160624.daydiary


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.room.Room
import buu.informatics.s59160624.daydiary.database.DiaryDatabase
import buu.informatics.s59160624.daydiary.databinding.FragmentMoodBinding

/**
 * A simple [Fragment] subclass.
 */
class MoodFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentMoodBinding>(inflater, R.layout.fragment_mood,container,false)
        val database = Room.databaseBuilder(this.context!!, DiaryDatabase::class.java,"DiaryItem").allowMainThreadQueries().build()
        binding.happyTotal.text = database.diaryDatabaseDao.getMood("happy").toString()
        binding.sadTotal.text = database.diaryDatabaseDao.getMood("sad").toString()
        binding.angryTotal.text = database.diaryDatabaseDao.getMood("angry").toString()
        binding.sickTotal.text = database.diaryDatabaseDao.getMood("sick").toString()
        binding.nothingTotal.text = database.diaryDatabaseDao.getMood("nothing").toString()
        return binding.root
    }


}
