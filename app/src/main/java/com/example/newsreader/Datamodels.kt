package com.example.newsreader

import com.google.gson.annotations.SerializedName

data class CountryList(var countryCode:String, val countryName:String)

data class NewsData(
    @SerializedName("source")
    var sourceModel: SourceModel,
    @SerializedName("author")
    var author:String,
    @SerializedName("title")
    var title:String,
    @SerializedName("description")
    var des:String,
    @SerializedName("url")
    var fullUrl:String,
    @SerializedName("urlToImage")
    var urlToImage:String,
    @SerializedName("publishedAt")
    var NewsTimeStamp:String)

data class RemainsData(
    @SerializedName("status")
    var status:String,
    @SerializedName("totalResults")
    var totalResults:Int,
    @SerializedName("articles")
    var articles:List<NewsData>)

data class SourceModel(
    @SerializedName("id")
    var id:String,
    @SerializedName("name")
    var name:String)