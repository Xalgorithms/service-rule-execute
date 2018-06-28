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
lazy val VERSION_MONGO_SCALA       = "2.3.0"
lazy val VERSION_SCALA             = "2.11.11"
lazy val VERSION_SCALA_TEST        = "3.1.2"
lazy val VERSION_CASSANDRA         = "3.5.0"
lazy val VERSION_AKKA_STREAM_KAFKA = "0.20"
lazy val VERSION_SCALA_MOCK        = "4.1.0"
lazy val VERSION_AVRO4S            = "1.9.0"
lazy val VERSION_JODA              = "2.10"
lazy val VERSION_JODA_CONVERT      = "2.1"
// for easy hexdigest generation
lazy val VERSION_PLAY              = "2.6.0"

lazy val VERSION_RULES_INTERPRETER = "0.0.1"

lazy val meta = Seq(
  name := """services-execute""",
  organization := "org.xalgorithms",
  version := "0.0.1-SNAPSHOT",
  scalaVersion := VERSION_SCALA,
)

lazy val lib_deps = Seq(
  // ours
  // FIXME: publish these to maven or github or something
  "org.xalgorithms"        %% "il-rules-interpreter"    % VERSION_RULES_INTERPRETER from "file://jars/il-rules-interpreter_2.11-0.0.1.jar",
  // outer
  "org.mongodb.scala"      %% "mongo-scala-driver"      % VERSION_MONGO_SCALA,
  "com.typesafe.akka"      %% "akka-stream-kafka"       % VERSION_AKKA_STREAM_KAFKA,
  "com.typesafe.play"      %% "play"                    % VERSION_PLAY,
  "com.datastax.cassandra" %  "cassandra-driver-core"   % VERSION_CASSANDRA,
  "com.sksamuel.avro4s"    %% "avro4s-core"             % VERSION_AVRO4S,
  "joda-time"              %  "joda-time"               % VERSION_JODA,
  "org.joda"               %  "joda-convert"            % VERSION_JODA_CONVERT,
  "org.scalamock"          %% "scalamock"               % VERSION_SCALA_MOCK % Test
)

lazy val root = (project in file("."))
  .settings(meta)
  .settings(libraryDependencies ++= lib_deps)
