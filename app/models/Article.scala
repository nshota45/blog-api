package models

import org.json4s.NoTypeHints
import org.json4s.native.Serialization
import org.json4s.native.Serialization.write

case class Article(
  id: Long,
  title: String,
  content: String,
  thumbnailUrl: String,
  date: String,
  tags: String
) {
  private implicit val formats = Serialization.formats(NoTypeHints)

  def toJson: String = write(this)
}
