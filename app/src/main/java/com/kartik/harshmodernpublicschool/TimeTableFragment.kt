
package com.kartik.harshmodernpublicschool

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.kartik.harshmodernpublicschool.databinding.FragmentTimeTableBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class TimeTableFragment : Fragment() {

    private var _timeTableBinding : FragmentTimeTableBinding? = null
    private val timeTableBinding get() = _timeTableBinding!!

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _timeTableBinding = FragmentTimeTableBinding.inflate(inflater, container, false)

        val timeTableItem = listOf("Class 1st", "Class 2nd", "Class 3rd", "Class 4th", "Class 5th", "Class 6th", "Class 7th", "Class 8th", "Class 9th", "Class 10th")

        val timeTableAdapter = ArrayAdapter(requireActivity(), R.layout.time_table_list_item, timeTableItem)

        timeTableBinding.timeTableAutoCompleteTextView.setAdapter(timeTableAdapter)

        return timeTableBinding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TimeTableFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TimeTableFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}