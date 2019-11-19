package buu.informatics.s59160624.daydiary


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import buu.informatics.s59160624.daydiary.database.DiaryDatabase
import buu.informatics.s59160624.daydiary.databinding.FragmentAdayBinding
import buu.informatics.s59160624.daydiary.databinding.FragmentWriteBinding
import kotlinx.android.synthetic.main.fragment_aday.*

/**
 * A simple [Fragment] subclass.
 */
class AdayFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentAdayBinding>(inflater, R.layout.fragment_aday,container,false)
        val database = Room.databaseBuilder(this.context!!, DiaryDatabase::class.java,"DiaryItem").allowMainThreadQueries().build()
        val args = AdayFragmentArgs.fromBundle(arguments!!)
//        val today = database.diaryDatabaseDao.getSameDate("${args.dateArgs}${args.monthArgs}")

        val adapter = TodayAdapter()
        binding.dayRecycle.adapter = adapter
        database.diaryDatabaseDao.getSameDate("${args.dateArgs}${args.monthArgs}").observe(viewLifecycleOwner,
            Observer { it?.let {
                adapter.data = it
            } })

        return binding.root
    }


}
