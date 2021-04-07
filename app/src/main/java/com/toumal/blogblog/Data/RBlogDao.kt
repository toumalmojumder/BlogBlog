package com.toumal.blogblog.Data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
@Dao
interface RBlogDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRBlog(rBlog: RBlog)

    @Query("SELECT * FROM blog_table ORDER BY title ASC")
    fun getAllRBlog(): LiveData<List<RBlog>>
}