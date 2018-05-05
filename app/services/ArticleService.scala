package services

import models.Article

import scala.concurrent.Future

trait ArticleService {

  /** 記事全件取得
    *
    * @return
    */
  def findAllArticles: Future[Seq[Article]]

  /** 記事取得
    *
    * @param id
    * @return
    */
  def findArticle(id: Long): Future[Article]

  /** 記事登録
    *
    * @param article
    * @return
    */
  def registerArticle(article: Article): Future[Int]
}
