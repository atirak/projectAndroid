package buu.informatics.s59160624.daydiary


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import buu.informatics.s59160624.daydiary.databinding.FragmentHomeBinding
import android.widget.Toast
import java.time.Month
import java.util.*


/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(inflater, R.layout.fragment_home,container,false)

        var yearArg = Calendar.getInstance().get(Calendar.YEAR)
        var dateArg = Calendar.getInstance().get(Calendar.DATE)
        var monthArg = Calendar.getInstance().get(Calendar.MONTH)

        binding.writeButton.setOnClickListener { view: View ->

            view.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToWriteFragment(
                Calendar.getInstance().get(Calendar.DATE).toString(),
                Calendar.getInstance().get(Calendar.MONTH).toString(),
                Calendar.getInstance().get(Calendar.YEAR).toString()))

        }



        binding.calendarView.setOnDateChangeListener{ view, year, month, dayOfMonth ->
            yearArg = year
            dateArg = dayOfMonth
            monthArg = month
            Toast.makeText(activity, dateArg.toString()+" "+monthArg.toString()+" "+yearArg.toString(), Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }



}
