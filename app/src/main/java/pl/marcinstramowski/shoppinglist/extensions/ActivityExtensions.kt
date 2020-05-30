package pl.marcinstramowski.shoppinglist.extensions

import android.app.Activity
import android.view.LayoutInflater
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatEditText
import pl.marcinstramowski.shoppinglist.R
//AlertDialog!!!!!
fun Activity.showTextInputDialog(@StringRes titleRes: Int, onTextProvided: (String) -> Unit) {
    AlertDialog.Builder(this)
        .setTitle(getString(titleRes))
        .setView(LayoutInflater.from(this).inflate(R.layout.dialog_add_list, null))
        .setPositiveButton(R.string.ok, { dialog, _ ->
            val listNameEditText = (dialog as AlertDialog).findViewById<AppCompatEditText>(R.id.listNameEditText)
            val text = listNameEditText?.text.toString()
            if (text.isNotBlank()) { onTextProvided(text) }
        })
        .setNegativeButton(R.string.cancel, null)
        .create()
        .show()
}