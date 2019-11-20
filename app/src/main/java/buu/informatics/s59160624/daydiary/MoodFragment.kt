package buu.informatics.s59160624.daydiary


import android.content.Intent
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
//        setHasOptionsMenu(true)
        val binding = DataBindingUtil.inflate<FragmentMoodBinding>(inflater, R.layout.fragment_mood,container,false)
        val database = Room.databaseBuilder(this.context!!, DiaryDatabase::class.java,"DiaryItem").allowMainThreadQueries().build()
        binding.happyTotal.text = "Happy Total is \n"+database.diaryDatabaseDao.getMood("happy").toString()+" times"
        binding.sadTotal.text = "Sad Total is \n"+database.diaryDatabaseDao.getMood("sad").toString()+" times"
        binding.angryTotal.text = "Angry Total is \n"+database.diaryDatabaseDao.getMood("angry").toString()+" times"
        binding.sickTotal.text = "Sick Total is \n"+database.diaryDatabaseDao.getMood("sick").toString()+" times"
        binding.nothingTotal.text = "Nothing Total is \n"+database.diaryDatabaseDao.getMood("nothing").toString()+" times"
        return binding.root
    }

//    private fun getShareIntent() : Intent {
//        val args = GameWonFragmentArgs.fromBundle(arguments!!)
//        val shareIntent = Intent(Intent.ACTION_SEND)
//        shareIntent.setType("text/plain")
//            .putExtra(Intent.EXTRA_TEXT, getString(R.string.share_success_text, args.numCorrect, args.numQuestions))
//        return shareIntent
//    }
//    private fun shareSuccess() {
//        startActivity(getShareIntent())
//    }
}
