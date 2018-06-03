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
package org.xalgorithms.actors

import akka.actor.{ Actor, ActorRef }
import scala.collection.mutable.ArrayBuffer

import org.xalgorithms.actors.Actions._

class ActionStream extends Actor {
  implicit val actor_system = context.system

  def receive: Receive = {
    case "STREAM_INIT" => {
      println("> STREAM_INIT")
      sender() ! "OK"
    }

    case ExecuteOne(document_id, rule_id) => {
      println(s"> ${document_id} / ${rule_id}")
    }

    case other => {
      println("> other")
      println(other)
      sender() ! "OK"
    }
  }
}