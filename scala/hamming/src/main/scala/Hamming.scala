import scala.annotation.tailrec

object Hamming {

  def zipOpt[A, B](a: Seq[A], b: Seq[B]): Option[Seq[(A, B)]] = {

    @tailrec
    def go(a: Seq[A], b: Seq[B], acc: Seq[(A, B)]): Option[Seq[(A, B)]] = {
      (a, b) match {
        case (Nil, Nil) => Some(acc)
        case (Nil, _) => None
        case (_, Nil) => None
        case (a: Seq[A], b: Seq[B]) => go(a.tail, b.tail, acc :+ (a.head, b.head))
      }
    }

    go(a, b, Seq())
  }

  def compute(first: String, second: String) = {
    zipOpt(first, second).map(_.count(t => t._1 != t._2))
  }
}
