package pl.marcinstramowski.shoppinglist.screens.main

import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*
import pl.marcinstramowski.shoppinglist.R
import pl.marcinstramowski.shoppinglist.extensions.setGone
import pl.marcinstramowski.shoppinglist.extensions.showTextInputDialog
import pl.marcinstramowski.shoppinglist.screens.base.BaseActivity
import pl.marcinstramowski.shoppinglist.screens.main.fragmentLists.ShoppingListPagerAdapter
import pl.marcinstramowski.shoppinglist.screens.main.fragmentLists.ShoppingListPages
import javax.inject.Inject

class MainActivity : BaseActivity<MainContract.Presenter>(), MainContract.View {

    companion object { const val SELECTED_PAGE = "SELECTED_PAGE" }

    @Inject override lateinit var presenter: MainContract.Presenter

    override val contentViewId = R.layout.activity_main

    override fun onCreated(savedInstanceState: Bundle?) {
        configureViewPager()
        fab.setOnClickListener { presenter.onFabButtonClick() }
    }

    override fun showAddNewListDialog() {
        showTextInputDialog(R.string.add_list_insert_name, presenter::createNewList)
    }

    private fun configureViewPager() {
        viewPager.apply {
            adapter = ShoppingListPagerAdapter(supportFragmentManager, context)
            currentItem = intent.getIntExtra(SELECTED_PAGE, ShoppingListPages.CURRENT_LISTS.ordinal)
            addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
                override fun onPageSelected(position: Int) = when (ShoppingListPages.values()[position]) {
                    ShoppingListPages.CURRENT_LISTS -> { fab.show() }
                    ShoppingListPages.ARCHIVED_LISTS -> { fab.setGone() }
                }
            })
        }
        tabLayout.setupWithViewPager(viewPager)
    }
}
