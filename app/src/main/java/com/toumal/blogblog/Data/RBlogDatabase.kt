package com.toumal.blogblog.Data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RBlog::class],version = 1,exportSchema = false)
abstract class RBlogDatabase:RoomDatabase() {

    abstract val rBlogDao:RBlogDao

    companion object{
        @Volatile
        private var INSTANCE: RBlogDatabase? = null

        fun getDatabase(context: Context):RBlogDatabase{
            synchronized(this){
                var instance:RBlogDatabase? = INSTANCE
                if (instance==null){
                    instance = Room.databaseBuilder(
                            context.applicationContext,
                            RBlogDatabase::class.java,
                            "blog_database"
                    ).build()
                }
                INSTANCE = instance
                return instance
            }
        }
    }

}