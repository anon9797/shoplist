package pl.marcinstramowski.shoppinglist.bindingAdapters

import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.text.DateFormat
import java.util.*

@BindingAdapter("formattedDate")
fun setImageUrl(textView: TextView, date: Date?) {
    textView.text = DateFormat.getDateTimeInstance(
        DateFormat.SHORT, DateFormat.SHORT, Locale.getDefault()
    ).format(date.toString())
}