package controllers

import javax.inject._
import play.api.mvc._
import scala.concurrent.ExecutionContext.Implicits.global
import org.json4s.NoTypeHints
import org.json4s.native.Serialization
import org.json4s.native.Serialization.write

import actions.BaseAction
import services.ArticleService


@Singleton
class ArticleController @Inject()(
  cc: ControllerComponents,
  baseAction: BaseAction,
  service: ArticleService
) extends AbstractController(cc) {

  private implicit val formats = Serialization.formats(NoTypeHints)
  private val perPage = 5

  def articles(page: Int) = baseAction.async { implicit request: Request[AnyContent] =>
    service.findArticles(page, perPage).map { articlesAndCount =>
      Ok(write(articlesAndCount))
    }
  }

  def article(id: Long) = baseAction.async { implicit request: Request[AnyContent] =>
    service.findArticle(id).map { article => Ok(article.toJson) }
  }

  def register = baseAction.async { implicit request: Request[AnyContent] =>
    service.registerArticle(article = null /* todo */).map { _ => Ok("{}")}
  }

}
