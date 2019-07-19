package com.example.navigationappp


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient


class AboutUS : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_about_us, container, false)

        val mywebview:WebView = view.findViewById (R.id.about) as WebView
        mywebview.loadUrl("https://www.ntv.co.ug/meta/4522434-4522436-4egkms/index.html")

        val webSettings = mywebview.settings
        webSettings.javaScriptEnabled = true

        mywebview.webViewClient = WebViewClient()

        return view
    }


}
