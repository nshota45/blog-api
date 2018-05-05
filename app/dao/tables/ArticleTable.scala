package dao.tables

import slick.jdbc.MySQLProfile.api._
import javax.inject.Singleton
import models.Article

@Singleton
class ArticleTable(tag: Tag) extends Table [Article](tag, "article") {
  def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
  def title = column[String]("title")
  def content = column[String]("content")
  def thumbnailUrl = column[String]("thumbnail_url")
  def date = column[String]("date")
  def tags = column[String]("tags")
  override def * = (id, title, content, thumbnailUrl, date, tags) <> (Article.tupled, Article.unapply)
}
