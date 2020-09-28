package com.example.madlevel3task2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.madlevel3example.PortalAdapter
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private val portals = arrayListOf<Portal>()
    private val portalAdapter = PortalAdapter(portals)

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    private fun initViews() {
        rvItems.layoutManager =
            StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)
        rvItems.adapter = portalAdapter
        //rvItems.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL))


        portals.add(Portal("Testdata.nl", "Dit is de link naar testdata.nl"))
        portals.add(Portal("nogeentest.nl", "Dit is de link naar nogeentest.nl"))
        portals.add(Portal("kaas.nl", "Dit is de link naar kaas.nl"))
        portals.add(Portal("sjag.nl", "Dit is de link naar sjag.nl"))
        portalAdapter.notifyDataSetChanged()
        // observeAddReminderResult()
    }

}