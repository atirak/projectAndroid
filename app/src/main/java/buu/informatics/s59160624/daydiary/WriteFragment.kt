package buu.informatics.s59160624.daydiary


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.room.Room
import buu.informatics.s59160624.daydiary.database.Diary
import buu.informatics.s59160624.daydiary.database.DiaryDatabase

import buu.informatics.s59160624.daydiary.databinding.FragmentWriteBinding
import kotlinx.android.synthetic.main.fragment_write.*
import java.util.*


/**
 * A simple [Fragment] subclass.
 */
class WriteFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentWriteBinding>(inflater, R.layout.fragment_write,container,false)
        val database = Room.databaseBuilder(this.context!!,DiaryDatabase::class.java,"DiaryItem").allowMainThreadQueries().build()
        val args = WriteFragmentArgs.fromBundle(arguments!!)
        Toast.makeText(context, "${args.dateArg}.${args.monthArg}.${args.yearArg}", Toast.LENGTH_LONG).show()
        binding.dateText.text = "${args.dateArg}.${args.monthArg}.${args.yearArg}"

//        val application = requireNotNull(this.activity).application
//        val dataSource = DiaryDatabase.getInstance(application).diaryDatabaseDao
//        val viewModelFactory = DiaryViewModelFactory(dataSource,application)
//        val diaryViewModel = ViewModelProviders.of(this, viewModelFactory).get(DiaryViewModel::class.java)
//        binding.setLifecycleOwner(this)
//        binding.diaryViewModel = diaryViewModel
        var mood = "nothing"
        binding.happyButton.setOnClickListener {
            mood = "happy"
        }
        binding.sadButton.setOnClickListener {
            mood = "sad"
        }
        binding.angryButton.setOnClickListener {
            mood = "angry"
        }
        binding.sickButton.setOnClickListener {
            mood = "sick"
        }

        binding.doneButton.setOnClickListener { view: View ->
            var emp = Diary()
            emp.date = "${args.dateArg}${args.monthArg}"
            emp.dateTime = Calendar.getInstance().time.toString()
            emp.mood = mood
            emp.content = binding.contentText.text.toString()
            database.diaryDatabaseDao.insert(emp)
            Toast.makeText(context, "${emp.date}*${emp.dateTime}*${emp.mood}*${emp.content}", Toast.LENGTH_LONG).show()
                view.findNavController().navigate(R.id.action_writeFragment_to_homeFragment)

            }




        return binding.root
    }


}
