package com.kartik.harshmodernpublicschool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.kartik.harshmodernpublicschool.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var homeBinding:ActivityHomeBinding
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(homeBinding.root)
        setUpDrawerLayout()

    }

    private fun setUpDrawerLayout() {
        setSupportActionBar(/* toolbar = */ homeBinding.includeToolbar.toolbar)

         toggle =  ActionBarDrawerToggle(
            this, homeBinding.homeDrawerLayout,  homeBinding.includeToolbar.toolbar, R.string.OpenDrawer, R.string.CloseDrawer
        )
        homeBinding.homeDrawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        loadFragment(HomeFragment())  // by default homeFragment shows on screen

        homeBinding.homeNavigationView.setNavigationItemSelectedListener {

            it.isChecked = true
            when(it.itemId){
                R.id.optProfile -> loadFragment(HomeFragment())
                R.id.optTimeTable -> loadFragment(TimeTableFragment())
            }

            true

        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

//    override fun onBackPressed() {
//        if(homeBinding.homeDrawerLayout.isDrawerOpen(GravityCompat.START)){
//            homeBinding.homeDrawerLayout.closeDrawer(GravityCompat.START)
//        }else{
//            super.onBackPressed()
//        }
//    }


    private fun loadFragment(fragment: Fragment){
        val fm = supportFragmentManager
        val fragmentTransaction = fm.beginTransaction()

        fragmentTransaction.add(R.id.homeContainer, fragment)
        fragmentTransaction.commit()
        homeBinding.homeDrawerLayout.closeDrawer(GravityCompat.START)
    }

}