package models

import org.json4s.NoTypeHints
import org.json4s.native.Serialization
import org.json4s.native.Serialization.write

trait Jsonable {
  private implicit val formats = Serialization.formats(NoTypeHints)
  def toJson: String = write(this)
}
