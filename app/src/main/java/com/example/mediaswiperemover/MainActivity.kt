package com.example.mediaswiperemover

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        //viewPager testing
        val viewPager = findViewById<View>(R.id.viewPager_MainMedia) as ViewPager
        val adapter = ImagePagerAdapter()
        viewPager.adapter = adapter
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
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
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_media_type -> {
                // Handle the media selection action
            }
            R.id.nav_folders -> {

            }
            R.id.nav_sorting_method -> {

            }
            R.id.nav_recently_deleted -> {

            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    //viewPager testing
    private inner class ImagePagerAdapter : PagerAdapter() {
        private val mImages =
            intArrayOf(
                R.drawable.chiang_mai,
                R.drawable.himeji,
                R.drawable.petronas_twin_tower,
                R.drawable.ulm,
                R.drawable.test_pic1,
                R.drawable.test_pic2,
                R.drawable.test_pic3,
                R.drawable.test_pic4,
                R.drawable.test_pic5)

        override fun getCount(): Int {
            return mImages.size
        }

        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view === `object`
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val context = this@MainActivity
            val imageView = ImageView(context)

            val padding = context.resources.getDimensionPixelSize(
                R.dimen.padding_medium
            )
            //viewPager_MainMedia.setPadding(padding, padding, padding, padding)
            imageView.setPadding(padding, padding, padding, padding)

            imageView.scaleType = ImageView.ScaleType.FIT_CENTER

            imageView.setImageResource(mImages[position])
            container.addView(imageView, 0)
            return imageView
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(`object` as ImageView)
        }
    }

}
