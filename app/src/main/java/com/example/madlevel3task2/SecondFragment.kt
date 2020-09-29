package com.example.madlevel3task2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_second.*

const val REQ_REMINDER_KEY = "req_portal"
const val BUNDLE_REMINDER_KEY_TITLE = "bundle_portal_title"
const val BUNDLE_REMINDER_KEY_URL = "bundle_portal_url"

class SecondFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_add.setOnClickListener {
            onAddPortal()
        }
    }

    private fun onAddPortal() {
        val urlTitle = input_title.text.toString()
        val Url = input_url.text.toString()

        if(urlTitle.isNotBlank() && Url.isNotBlank()) {

            setFragmentResult(REQ_REMINDER_KEY, bundleOf(
                BUNDLE_REMINDER_KEY_TITLE to urlTitle, BUNDLE_REMINDER_KEY_URL to Url
            ))

//            setFragmentResult(REQ_REMINDER_KEY, bundleOf(BUNDLE_REMINDER_KEY_TITLE to Portal(Url, urlTitle)))

            findNavController().popBackStack()
        } else {
            Toast.makeText(
                activity,
                R.string.not_valid_portal, Toast.LENGTH_SHORT
            ).show()
        }
    }
}