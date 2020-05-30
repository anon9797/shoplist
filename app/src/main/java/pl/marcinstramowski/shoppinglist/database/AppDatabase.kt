package pl.marcinstramowski.shoppinglist.database

import androidx.room.Database
import androidx.room.RoomDatabase
import pl.marcinstramowski.shoppinglist.database.dao.ShoppingListDao
import pl.marcinstramowski.shoppinglist.database.model.ShoppingItem
import pl.marcinstramowski.shoppinglist.database.model.ShoppingList

@Database(entities = [ShoppingList::class, ShoppingItem::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun shoppingListDao(): ShoppingListDao

}