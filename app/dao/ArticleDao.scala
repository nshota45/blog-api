package dao

import dao.tables.ArticleTable
import slick.jdbc.MySQLProfile.api._
import slick.jdbc.JdbcProfile
import javax.inject.{Inject, Singleton}
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import play.db.NamedDatabase
import models.Article

import scala.concurrent.Future

@Singleton
class ArticleDao @Inject()(
  @NamedDatabase("blog_db") protected val dbConfigProvider: DatabaseConfigProvider
) extends HasDatabaseConfigProvider [JdbcProfile]{

  private val Articles = TableQuery[ArticleTable]

  /** id降順で記事全件取得
    *
    * @return
    */
  def findAllArticles: Future[Seq[Article]] = {
    db.run(Articles.sortBy(_.id.desc).result)
  }

  /** idをキーに記事取得
    *
    * @param id
    * @return
    */
  def findArticle(id: Long): Future[Option[Article]] = {
    db.run(Articles.filter(_.id === id).result.headOption)
  }

  /** 記事新規登録
    *
    * @param article
    * @return
    */
  def insertArticle(article: Article): Future[Int] = {
    db.run(Articles += article)
  }
}
