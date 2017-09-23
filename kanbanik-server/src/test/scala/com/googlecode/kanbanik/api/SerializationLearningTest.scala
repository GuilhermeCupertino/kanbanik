package com.googlecode.kanbanik.api

import net.liftweb.json._
import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.scalatest.junit.JUnitRunner

case class ClassWithOption(name: String, version: Option[Int])

@RunWith(classOf[JUnitRunner])
class SerializationLearningTest extends FlatSpec {
  implicit val formats = DefaultFormats // Brings in default date formats etc

  "serialization" should "work for simple case class" in {
    case class SomeClass(name: String, version: Int)

    val json = parse("""
         { "name": "Ignac",
           "version": 12
         }
    """)

    val extracted = json.extract[SomeClass]
    assert(extracted.name === "Ignac")
    assert(extracted.version === 12)
  }

  it should "work for list params" in {
    case class Param(name: String)
    case class SomeClass(params: List[Param])

    val json = parse("""
         { "params":
           [
             {
                "name": "name1"
             },
             {
                "name": "name2"
             }
           ]
         }
         """)

    val extracted = json.extract[SomeClass]
    assert(extracted.params.head.name === "name1")
    assert(extracted.params.tail.head.name === "name2")
  }


  it should "deal with incomplete arg list" in {
    val json = parse("""
         { "name": "Ignac"}
         """)

    val extracted = json.extract[ClassWithOption]
    assert(extracted.name === "Ignac")
    assert(extracted.version === None)
  }

  it should "be possible to query it using XPath" in {
    val json = parse("""
         { "name": "Ignac"}
                     """)

    val res = (json \ "name").extract[String]
    assert(res.toString === "Ignac")
  }

  it should "be possible to serialize an ampersand" in {
    val json = parse("""
         { "name": "Ig&nac"}
                     """)

    val res = (json \ "name").extract[String]
    assert(res.toString === "Ig&nac")
  }

  it should "work with completely arbitrary data" in {
    case class Arbitrary(x: Map[String, String])
    val json = parse("""
         {"x": {"a": "b"}}
         """)
    val res = json.\("x").extract[Map[String, String]]
    print("a")

  }

}
