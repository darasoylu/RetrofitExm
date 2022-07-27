package com.darasoylu.retrofitexm.api

import com.darasoylu.retrofitexm.model.Post
import retrofit2.Response
import retrofit2.http.*

interface PostApi {

    @GET("/posts/1")
    suspend fun getPost(): Response<Post>

    @GET("/posts/{postNumber}")
    suspend fun getPost2(
        @Path("postNumber") number: Int
    ): Response<Post>

    @GET("/posts")
    suspend fun getCustomPosts(
        @Query("userId") userId: Int
    ): Response<List<Post>>

    @GET("/posts")
    suspend fun getCustomPosts2(
        @Query("userId") userId: Int,
        @QueryMap options: Map<String, String>
    ): Response<List<Post>>

    @POST("posts")
    suspend fun pushPost(
        @Body post: Post
    ): Response<Post>

    //FormUrlEncoded-> Default data type is json format but this annotation
    // format -> key and value separated by &
    // userId=1&id=1&title=Test_title&body=Test_body
    @FormUrlEncoded()
    @POST("posts")
    suspend fun pushPost2(
        @Field("userId") userId: Int,
        @Field("id") id: Int,
        @Field("title") title: String,
        @Field("body") body: String,
    ): Response<Post>
}