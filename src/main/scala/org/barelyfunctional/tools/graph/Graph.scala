package org.barelyfunctional.tools.graph

import scala.reflect.runtime.universe._

//
//import scala.reflect.runtime.universe._

/**
 * Created by nathanmatthews on 04/01/2014.
 */

// Map[String,

trait Node {
//  val nodeType : Type
}

// return either unevaluated

case class Value[T](value : T) extends Node

case class Func[T](inputs : Map[String, Type], f : Map[String, () => Any] => T) extends Node

object Graph {

  case class Key(name : String, cls : Type)

  trait IncomingEdge {
    val vertex : Key
  }

  case class IncomingLazyEdge(vertex : Key) extends IncomingEdge

  case class IncomingEagerEdge(vertex : Key) extends IncomingEdge

  case class Unevaluated(incoming : List[IncomingEdge], f : List[Either[Any, () => Any]] => Any)

  type Evaluated = Any

  type Vertex = Either[Evaluated, Unevaluated]

  type Graph = Map[Key, Vertex]

  type Evaluator = (Key, Graph, Evaluator) => Evaluated

  def evaluateTo(key : Key, graph : Graph, evaluator : Evaluator = evaluateTo) : Graph =
    graph.get(key) match {
      case None =>
        val supers = graph.collect { case (Key(key.name, cls), vertex) if (cls < key.cls) => (cls, vertex) }

        if (sameName.isEmpty)
          throw new Exception

        graph
        // Ok, may need to do some type gymnastics
      case Some(Left(node)) => graph

      case Some(Right(Unevaluated(incoming, f))) =>



    }

//  type SourceVertex = Left
//  type ComputedVertex = Right

  type Node[T] = Either[T, (Map[Key, Type], Map[Key, Any] => T)]


  // A run of the graph is a linearization
  // graph execution is single threaded
  // a node execution returns a result.

  // can't cope with lazy evaluation. Can short circuit on incompatible types, bad values.

  def linearize(graph : Graph, key : String) : List[(Key, Node[Any])] = null

  // pass through an evaluator
  // can cope with lazy evaluation

  // transform code
  /**
   * When running
   * @param graph
   * @param key
   * @return
   */
  def run(graph : Graph, key : String) : Any = null
}
