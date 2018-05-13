package services.impl

import dao.ArticleDao
import javax.inject.Inject
import models.{Article, ArticlesAndCount}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class ArticleService @Inject()(
  dao: ArticleDao
) extends services.ArticleService {

  override def findArticles(page: Int, perPage: Int): Future[ArticlesAndCount] = {
    dao.findAllArticles.map { articles =>
      require(page >= 1)

      articles.map{ article =>
        Article(
          id = article.id,
          title = article.title,
          content = if(article.content.length > 30) article.content.substring(0, 30) + "..." else article.content, // 30文字目まで表示
          thumbnailUrl = article.thumbnailUrl,
          date = article.date,
          tags = article.tags
        )
      }
    }.map{ articles =>
      val articlesPerPage = articles.slice(perPage * (page - 1), page * perPage)
      val totalArticlesCount = articles.size
      val totalPageNum = (totalArticlesCount / perPage) + 1
      ArticlesAndCount(articlesPerPage, totalArticlesCount, totalPageNum)
    }
  }

  override def findArticle(id: Long): Future[Article] = {
    dao.findArticle(id).map {
      case Some(article) => article
      case None          => throw new Exception(s"Failed to find article. id = $id")
    }
  }

  override def registerArticle(article: Article): Future[Int] = {
    dao.insertArticle(article)
  }
}
