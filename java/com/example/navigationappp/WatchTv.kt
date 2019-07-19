package com.example.navigationappp


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient


class WatchTv : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_watch_tv, container, false)

        val mywebview:WebView = view.findViewById (R.id.webvieww) as WebView
        mywebview.loadUrl("https://www.youtube.com/watch?v=pQotKyhige8")

        val webSettings = mywebview.settings
        webSettings.javaScriptEnabled = true

        mywebview.webViewClient = WebViewClient()

        return view
    }


}
