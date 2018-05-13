package services

import models.{Article, ArticlesAndCount}

import scala.concurrent.Future

trait ArticleService {

  /** 記事一覧表示
    *
    * @param page 現在のページ
    * @param perPage 1ページに表示する記事の件数
    * @return
    */
  def findArticles(page: Int, perPage: Int): Future[ArticlesAndCount]

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
