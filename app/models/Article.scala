package models

case class Article(
  id: Long,
  title: String,
  content: String,
  thumbnailUrl: String,
  date: String,
  tags: String
) extends Jsonable
