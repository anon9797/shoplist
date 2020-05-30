package pl.marcinstramowski.shoppinglist.extensions

import android.view.View
import com.google.android.material.floatingactionbutton.FloatingActionButton

fun FloatingActionButton.setGone() {
    if (!isShown) visibility = View.GONE else hide()
}