package jp.shts.android.navigationsample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_animal_list.*


class AnimalListFragment : Fragment(), OnClickAnimalListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_animal_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        animalList.adapter = AnimalListAdapter().also {
            it.listener = this
            it.add(animalData)
            it.notifyDataSetChanged()
        }
    }

    override fun onClick(name: String) {
        findNavController().navigate(
                AnimalListFragmentDirections
                        .action_animalListFragment_to_animalDetailFragment(name)
        )
    }
}
