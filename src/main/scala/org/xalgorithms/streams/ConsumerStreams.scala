// Copyright (C) 2018 Don Kelly <karfai@gmail.com>

// This file is part of Interlibr, a functional component of an
// Internet of Rules (IoR).

// ACKNOWLEDGEMENTS
// Funds: Xalgorithms Foundation
// Collaborators: Don Kelly, Joseph Potvin and Bill Olders.

// This program is free software: you can redistribute it and/or
// modify it under the terms of the GNU Affero General Public License
// as published by the Free Software Foundation, either version 3 of
// the License, or (at your option) any later version.

// This program is distributed in the hope that it will be useful, but
// WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Affero General Public License for more details.

// You should have received a copy of the GNU Affero General Public
// License along with this program. If not, see
// <http://www.gnu.org/licenses/>.
package org.xalgorithms.streams

import akka.actor.{ ActorSystem, ActorRef }
import akka.kafka.{ ConsumerMessage, ConsumerSettings, Subscriptions }
import akka.kafka.scaladsl.Consumer
import akka.stream.scaladsl.{ Sink }
import org.apache.kafka.common.serialization.{ StringDeserializer }

trait ConsumerStreams extends AkkaStreams {
  implicit val actor_system: ActorSystem

  def self: ActorRef

  def make_source(props: Map[String, String]) = {
    val settings = ConsumerSettings(actor_system, new StringDeserializer, new StringDeserializer)
      .withBootstrapServers(props("bootstrap_servers"))
      .withGroupId(props("groupId"))

    Consumer.committableSource(settings, Subscriptions.topics(props("topic")))
  }

  def make_sink(actor_ref: ActorRef) = {
    Sink.actorRefWithAck(actor_ref, "STREAM_INIT", "OK", "STREAM_DONE")
  }
}
