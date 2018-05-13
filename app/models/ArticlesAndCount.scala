package models

case class ArticlesAndCount(
  articles: Seq[Article],
  totalCount: Int,
  totalPageNum: Int
) extends Jsonable
