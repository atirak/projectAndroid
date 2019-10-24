package buu.informatics.s59160624.daydiary


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import buu.informatics.s59160624.daydiary.databinding.FragmentWriteBinding

/**
 * A simple [Fragment] subclass.
 */
class WriteFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentWriteBinding>(inflater, R.layout.fragment_write,container,false)

        val args = WriteFragmentArgs.fromBundle(arguments!!)
        Toast.makeText(context, "${args.dateArg}.${args.monthArg}.${args.yearArg}", Toast.LENGTH_LONG).show()
        binding.dateText.text = "${args.dateArg}.${args.monthArg}.${args.yearArg}"

        return binding.root
    }


}
