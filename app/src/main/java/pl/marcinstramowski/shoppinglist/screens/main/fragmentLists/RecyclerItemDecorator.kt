package pl.marcinstramowski.shoppinglist.screens.main.fragmentLists

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.annotation.DimenRes
import androidx.recyclerview.widget.RecyclerView
import pl.marcinstramowski.shoppinglist.R

class RecyclerItemDecorator @JvmOverloads constructor(
    context: Context, @DimenRes sizeDimenRes: Int? = null
) : RecyclerView.ItemDecoration() {

    private val space: Int =
        context.resources.getDimensionPixelOffset(sizeDimenRes ?: R.dimen.margin_normal)

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        if (parent.getChildAdapterPosition(view) == state.itemCount - 1) {
            outRect.bottom = space
        }
        outRect.top = space
        outRect.left = space
        outRect.right = space
    }
}