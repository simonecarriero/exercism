object ETL {

  def transform(scores: Map[Int, Seq[String]]): Map[String, Int] = {
    for {
      score <- scores
      value <- score._2
    } yield (value.toLowerCase, score._1)
  }
}
