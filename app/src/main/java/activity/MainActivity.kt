package activity

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.view.View
import android.widget.ImageView
import base.BaseActivity
import com.e.kotlinwanandroid.R
import com.luseen.spacenavigation.SpaceItem
import com.luseen.spacenavigation.SpaceNavigationView
import com.luseen.spacenavigation.SpaceOnClickListener
import fragment.home.HomeFragment
import fragment.mine.MineFragment
import fragment.project.ProjectFragment
import fragment.tree.TreeListFragment
import fragment.wechat.WeChatFragment
import untils.IntentUntils

class MainActivity : BaseActivity() {
   lateinit var homeFragment:HomeFragment
   lateinit var projectFragment: ProjectFragment
   lateinit var weChatFragment: WeChatFragment
   lateinit var treeListFragment: TreeListFragment
   lateinit var mineFragment: MineFragment
   lateinit var img_serach:ImageView
    override fun initData(bundle: Bundle?) {

    }

    override fun getLayoutId() = R.layout.activity_main

    override fun initView() {
       img_serach=findViewById(R.id.img_serach)
        img_serach.setOnClickListener { IntentUntils.startToSearch(this@MainActivity) }
        val spaceView=findViewById<SpaceNavigationView>(R.id.space)
        spaceView.addSpaceItem(SpaceItem("首页", R.mipmap.bottom_menu_home))
        spaceView.addSpaceItem(SpaceItem("项目", R.mipmap.bottom_menu_project))
        spaceView.addSpaceItem(SpaceItem("体系", R.mipmap.bottom_menu_system))
        spaceView.addSpaceItem(SpaceItem("我的", R.mipmap.bottom_menu_mine))
        spaceView.setCentreButtonIconColorFilterEnabled(false)
        spaceView.showTextOnly()
        spaceView.setSpaceOnClickListener(object : SpaceOnClickListener{
            override fun onCentreButtonClick() {
                showFragment(4)
            }

            override fun onItemClick(itemIndex: Int, itemName: String?) {
                showFragment(itemIndex)
            }

            override fun onItemReselected(itemIndex: Int, itemName: String?) {
                showFragment(itemIndex)
            }
        })
        showFragment(0)

    }
    fun showFragment(index:Int){
         val fragmentManager:FragmentManager=supportFragmentManager
         val fragmentTransaction:FragmentTransaction=fragmentManager.beginTransaction()
         hideFragment(fragmentTransaction)
         when(index){
             0-> if (::homeFragment.isInitialized){
                     fragmentTransaction.show(homeFragment)
                 }else{
                     homeFragment= HomeFragment()
                     fragmentTransaction.add(R.id.container,homeFragment)
                 }
             1-> if (::projectFragment.isInitialized){
                      fragmentTransaction.show(projectFragment)
                  }else{
                      projectFragment= ProjectFragment()
                      fragmentTransaction.add(R.id.container,projectFragment)
                  }
             2->  if (::treeListFragment.isInitialized){
                      fragmentTransaction.show(treeListFragment)
                   }else{
                       treeListFragment= TreeListFragment()
                       fragmentTransaction.add(R.id.container,treeListFragment)
                  }
             3-> if (::mineFragment.isInitialized){
                    fragmentTransaction.show(mineFragment)
                 }else{
                     mineFragment= MineFragment()
                     fragmentTransaction.add(R.id.container,mineFragment)

                }
             4-> if (::weChatFragment.isInitialized){
                      fragmentTransaction.show(weChatFragment)
                  }else{
                      weChatFragment= WeChatFragment()
                      fragmentTransaction.add(R.id.container,weChatFragment)
                  }
         }

        fragmentTransaction.commitAllowingStateLoss()

    }
    fun hideFragment(fragmentTransporation:FragmentTransaction){
        if (::homeFragment.isInitialized){
            fragmentTransporation.hide(homeFragment)
        }
        if (::projectFragment.isInitialized){
            fragmentTransporation.hide(projectFragment)
        }
        if (::weChatFragment.isInitialized){
            fragmentTransporation.hide(weChatFragment)
        }
        if (::treeListFragment.isInitialized){
            fragmentTransporation.hide(treeListFragment)
        }
        if (::mineFragment.isInitialized){
            fragmentTransporation.hide(mineFragment)
        }
    }

}
