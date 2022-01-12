package com.data_request

case class BookData(
                     title: String,
                     authors: List[String],
                     publisher: String,
                     publishedDate: String,
                     pageCount: Int,
                     averageRating: Double,
                     ratingsCount: Int
                   )
