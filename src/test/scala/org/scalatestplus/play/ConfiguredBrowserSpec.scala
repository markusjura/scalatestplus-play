/*
 * Copyright 2001-2014 Artima, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.scalatestplus.play

import play.api.test._
import org.scalatest._
import events._
import play.api.{Play, Application}
import scala.collection.mutable.ListBuffer

class ConfiguredBrowserSpec extends UnitSpec with SequentialNestedSuiteExecution with OneServerPerSuite with OneBrowserPerSuite with HtmlUnitFactory {

  override def nestedSuites = Vector(new ConfiguredBrowserNestedSuite)

  implicit override lazy val app: FakeApplication = FakeApplication(additionalConfiguration = Map("foo" -> "bar", "ehcacheplugin" -> "disabled"),
      withRoutes = TestRoute)
  def getConfig(key: String)(implicit app: Application) = app.configuration.getString(key)
}

