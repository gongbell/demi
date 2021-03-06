package akka.dispatch.verification

import akka.actor.Cell
import akka.actor.ActorSystem
import akka.actor.ActorRef
import akka.actor.Actor
import akka.actor.PoisonPill
import akka.actor.Props;

import akka.dispatch.Envelope
import akka.dispatch.MessageQueue
import akka.dispatch.MessageDispatcher

import scala.collection.concurrent.TrieMap
import scala.collection.mutable.Queue
import scala.collection.mutable.HashMap
import scala.collection.mutable.HashSet
import scala.collection.Iterator

import scala.collection.generic.GenericTraversableTemplate

// A scheduler that always forwards messages immediately.
class NullScheduler extends Scheduler {

  // Mechanism to forward messages immediately: mark everything as a "system message".
  def isSystemCommunication(sender: ActorRef, receiver: ActorRef): Boolean = {
    return true
  }
  
  def isSystemMessage(src: String, dst: String): Boolean = {
    return true
  }
  
  def start_trace() : Unit = {}
  
  def schedule_new_message(blockedActors: Set[String]) : Option[(Cell, Envelope)] = {
    return None
  }
  
  def next_event() : Event = {
    throw new Exception("no previously consumed events")
  }
  
  def event_consumed(event: Event) = {}
  def event_consumed(cell: Cell, envelope: Envelope) = {}
  def event_produced(event: Event) = {}
  def event_produced(cell: Cell, envelope: Envelope) = {}
  def before_receive(cell: Cell) {}
  def after_receive(cell: Cell) {}
  def notify_quiescence () {}
  def notify_timer_cancel(receiver: String, msg: Any) {}
  def enqueue_message(sender: Option[ActorRef], receiver: String, msg: Any) {
    throw new Exception("NYI")
  }
  def shutdown() {}
}
