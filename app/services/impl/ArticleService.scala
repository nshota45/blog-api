package services.impl

import dao.ArticleDao
import javax.inject.Inject
import models.Article

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class ArticleService @Inject()(
  dao: ArticleDao
) extends services.ArticleService {

  override def findAllArticles: Future[Seq[Article]] = {
    dao.findAllArticles.map { articles =>
      articles.map{ article =>
        Article(
          id = article.id,
          title = article.title,
          content = article.content.substring(0, 30) + "...", // 30文字目まで表示
          thumbnailUrl = article.thumbnailUrl,
          date = article.date,
          tags = article.tags
        )
      }
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
