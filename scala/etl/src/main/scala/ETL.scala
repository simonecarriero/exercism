object ETL {

  def transform(scores: Map[Int, Seq[String]]): Map[String, Int] = {
    for {
      (points, values) <- scores
      value <- values
    } yield (value.toLowerCase, points)
  }
}
