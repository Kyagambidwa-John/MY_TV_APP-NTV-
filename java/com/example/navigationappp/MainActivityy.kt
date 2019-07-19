package com.example.navigationappp

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.support.v4.widget.DrawerLayout
import android.support.design.widget.NavigationView
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivityy : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    var website:WebView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        website = findViewById<WebView>(R.id.cview)
        website!!.webViewClient = object : WebViewClient()
        {
            //fun site(view: WebView?, url: String): Boolean {
              //  view?.loadUrl(url)

            //return true
            override fun shouldOverrideUrlLoading(view: WebView?, url:   String): Boolean {
                view?.loadUrl(url)
                return true

            }




        }

        website!!.loadUrl("https://www.ntv.co.ug/news/4522502-4522502-15fef7v/index.html")

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> {
                supportFragmentManager.beginTransaction().replace(R.id.linear, HOME()).commit()
                setTitle("HOME")
            }
            R.id.nav_gallery -> {
                supportFragmentManager.beginTransaction().replace(R.id.linear, WatchTv()).commit()
                setTitle("Watch Tv")


            }
            R.id.nav_slideshow -> {
                supportFragmentManager.beginTransaction().replace(R.id.linear, Shows()).commit()
                setTitle("Shows")

            }
            R.id.nav_tools -> {
                supportFragmentManager.beginTransaction().replace(R.id.linear, Schedule()).commit()
                setTitle("Schedule")
            }
            R.id.nav_share -> {
                supportFragmentManager.beginTransaction().replace(R.id.linear, AboutUS()).commit()
                setTitle("About Us")

            }

        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
