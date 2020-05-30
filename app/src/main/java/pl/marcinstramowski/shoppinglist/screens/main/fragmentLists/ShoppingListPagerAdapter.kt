package pl.marcinstramowski.shoppinglist.screens.main.fragmentLists

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import pl.marcinstramowski.shoppinglist.screens.main.fragmentLists.archivedLists.ArchivedListsFragment
import pl.marcinstramowski.shoppinglist.screens.main.fragmentLists.currentLists.CurrentListsFragment

class ShoppingListPagerAdapter(fm: FragmentManager, private val context: Context) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment = when (ShoppingListPages.values()[position]) {
        ShoppingListPages.CURRENT_LISTS -> CurrentListsFragment()
        ShoppingListPages.ARCHIVED_LISTS -> ArchivedListsFragment()
    }

    override fun getPageTitle(position: Int): String {
        return context.getString(ShoppingListPages.values()[position].titleRes)
    }

    override fun getCount() = ShoppingListPages.values().size


}