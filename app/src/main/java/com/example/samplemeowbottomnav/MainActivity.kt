package com.example.samplemeowbottomnav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation


class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav: MeowBottomNavigation = findViewById(R.id.meow_bottom_nav)

        bottomNav.add(MeowBottomNavigation.Model(0, R.drawable.vector_home))
        bottomNav.add(MeowBottomNavigation.Model(1, R.drawable.vector_explore))
        bottomNav.add(MeowBottomNavigation.Model(2, R.drawable.vector_chat))
        bottomNav.add(MeowBottomNavigation.Model(3, R.drawable.vector_notifications))
        bottomNav.add(MeowBottomNavigation.Model(4, R.drawable.vector_person))

        bottomNav.setOnClickMenuListener {
            when(it.id)
            {
                0 -> {
                    Toast.makeText(this, "Home Fragment", Toast.LENGTH_SHORT).show()
                    fragment(HomeFragment.newInstance())
                }

                1 -> {
                    Toast.makeText(this, "Explore Fragment", Toast.LENGTH_SHORT).show()
                    fragment(ExploreFragment.newInstance())
                }

                2 -> {
                    Toast.makeText(this, "Chat Fragment", Toast.LENGTH_SHORT).show()
                    fragment(ChatFragment.newInstance())
                }

                3 -> {
                    Toast.makeText(this, "Notifications Fragment", Toast.LENGTH_SHORT).show()
                    fragment(NotificationsFragment.newInstance())
                }

                4 -> {
                    Toast.makeText(this, "User Fragment", Toast.LENGTH_SHORT).show()
                    fragment(UserFragment.newInstance())
                }

                else -> {
                    Toast.makeText(this, "Home Fragment", Toast.LENGTH_SHORT).show()
                    fragment(HomeFragment.newInstance())
                }
            }
        }

        //
        val homeFrag = HomeFragment()
//        val exploreFrag = ExploreFragment()
//        val chatFragment = ChatFragment()
//        val notificationFrag = NotificationsFragment()
//        val userFrag = UserFragment()

        //
        fragment(homeFrag)
    }

    private fun fragment(fragment: Fragment)
    {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.frame, fragment).addToBackStack(Fragment::class.java.simpleName)
        fragmentTransaction.commit()
    }
}