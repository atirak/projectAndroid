package buu.informatics.s59160624.daydiary


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import buu.informatics.s59160624.daydiary.databinding.FragmentHomeBinding
import android.widget.Toast
import androidx.navigation.ui.NavigationUI
import timber.log.Timber
import java.util.*


/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(inflater, R.layout.fragment_home,container,false)
        setHasOptionsMenu(true)
        Timber.plant(Timber.DebugTree())

        var yearArg = Calendar.getInstance().get(Calendar.YEAR)
        var dateArg = Calendar.getInstance().get(Calendar.DATE)
        var monthArg = Calendar.getInstance().get(Calendar.MONTH)

        binding.writeButton.setOnClickListener { view: View ->
            gotoWrite(view)


        }
        binding.todayButton.setOnClickListener { view: View ->
            gotoToday(view,dateArg,monthArg)
        }

        binding.mymoodButton.setOnClickListener { view: View ->
            gotoMood(view)

        }

        binding.calendarView.setOnDateChangeListener{ view, year, month, dayOfMonth ->
            yearArg = year
            dateArg = dayOfMonth
            monthArg = month
            Toast.makeText(activity, dateArg.toString()+" "+monthArg.toString()+" "+yearArg.toString(), Toast.LENGTH_SHORT).show()
        }



        return binding.root
    }

    fun gotoWrite(view: View){
        view.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToWriteFragment(
            Calendar.getInstance().get(Calendar.DATE).toString(),
            Calendar.getInstance().get(Calendar.MONTH).toString(),
            Calendar.getInstance().get(Calendar.YEAR).toString()
        ))
        Timber.i("gotoWrite Called")
    }
    fun gotoToday(view: View,dateArg: Int,monthArg: Int){
        view.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToAdayFragment(
            dateArg.toString(),
            monthArg.toString()
        ))
        Timber.i("gotoToday Called")
    }
    fun gotoMood(view: View){
        view.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToMoodFragment(
        ))
        Timber.i("gotoMood Called")
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.optionmenu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }
}
