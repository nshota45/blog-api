package actions

import javax.inject.{Inject, Singleton}
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class BaseAction @Inject()(parser: BodyParsers.Default)(implicit ec: ExecutionContext)
  extends ActionBuilderImpl(parser)
{

  override def invokeBlock[A](request: Request[A], block: (Request[A]) => Future[Result]) = {
    block(request).map{
      _.withHeaders("Access-Control-Allow-Origin" -> "*").as("application/json")
    }.recover {
      case e:Exception =>
        Results.InternalServerError(models.Error(errMsg = e.getMessage).toJson)
          .withHeaders("Access-Control-Allow-Origin" -> "*")
          .as("application/json")
    }
  }
}
