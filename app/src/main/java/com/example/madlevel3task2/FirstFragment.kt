package com.example.madlevel3task2

import android.R
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.madlevel3example.PortalAdapter
import kotlinx.android.synthetic.main.fragment_first.*


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment(), PortalAdapter.OnItemClickListener {

    private val portals = arrayListOf<Portal>()
    private val portalAdapter = PortalAdapter(portals, this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(com.example.madlevel3task2.R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    private fun initViews() {
        rvItems.layoutManager =
            StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        rvItems.adapter = portalAdapter
        //rvItems.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL))


//        portals.add(Portal("Testdata.nl", "Dit is de link naar testdata.nl"))
//        portals.add(Portal("nogeentest.nl", "Dit is de link naar nogeentest.nl"))
//        portals.add(Portal("kaas.nl", "Dit is de link naar kaas.nl"))
//        portals.add(Portal("sjag.nl", "Dit is de link naar sjag.nl"))
//        portalAdapter.notifyDataSetChanged()
        observeAddReminderResult()
    }

    private fun observeAddReminderResult() {
        setFragmentResultListener(REQ_REMINDER_KEY) { key, bundle ->

            var title = ""
            var url = ""

            bundle.getString(BUNDLE_REMINDER_KEY_TITLE)?.let {
                title = it
            } ?: Log.e("SecondFragment", "Request triggered, but empty title text!")

            bundle.getString(BUNDLE_REMINDER_KEY_URL)?.let {
                url = it
            } ?: Log.e("SecondFragment", "Request triggered, but empty url text!")

            portals.add(Portal(url, title))
            portalAdapter.notifyDataSetChanged()

//            println(bundle.getSerializable(BUNDLE_REMINDER_KEY_TITLE)<Portal>)


        }
    }

    override fun onItemClick(position: Int) {
        val clickedOn = portals[position].title
        Toast.makeText(activity, "Going to $clickedOn", Toast.LENGTH_SHORT).show()
        val clickedItemUrl = portals[position].url

        openCustomTab(clickedItemUrl)
    }

    fun openCustomTab(url: String?) {
        //@TODO requireActivity()??????? not this@FirstFragment??
        val builder = CustomTabsIntent.Builder()
        builder.setToolbarColor(ContextCompat.getColor(requireActivity(), R.color.black))
        builder.addDefaultShareMenuItem();
        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(requireActivity(), Uri.parse(url));
    }
}