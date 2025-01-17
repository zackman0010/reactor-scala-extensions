package reactor.core.scala.publisher

import reactor.core.publisher.{GroupedFlux => JGroupedFlux}

/**
  * Represents a sequence of events with an associated key.
  *
  * @tparam K the key type
  * @tparam V the value type
  */
class GroupedFlux[K, V]private(private val jGroupedFlux: JGroupedFlux[K, V]) extends SFlux[V] {

  /**
    * Return defined identifier
    * @return defined identifier
    */
  def key(): K = jGroupedFlux.key()

  override private[publisher] def coreFlux = jGroupedFlux
}

object GroupedFlux {
  def apply[K, V](jGroupFlux: JGroupedFlux[K, V]) = new GroupedFlux[K, V](jGroupFlux)
}
