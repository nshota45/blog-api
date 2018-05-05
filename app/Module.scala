import com.google.inject.AbstractModule

class Module extends AbstractModule {
  override def configure(): Unit = {
    bind(classOf[services.ArticleService]).to(classOf[services.impl.ArticleService])
  }
}
