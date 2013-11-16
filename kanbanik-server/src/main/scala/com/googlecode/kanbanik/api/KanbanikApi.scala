package com.googlecode.kanbanik.api

import javax.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse}
import net.liftweb.json._
import com.googlecode.kanbanik.dtos._
import net.liftweb.json.Serialization.write
import com.googlecode.kanbanik.commands.LoginCommand
import com.googlecode.kanbanik.dto.CommandNames._

class KanbanikApi extends HttpServlet {

  implicit val formats = DefaultFormats

  override def doGet(req : HttpServletRequest, resp : HttpServletResponse) = {
    process(req, resp)
  }

  override def doPost(req : HttpServletRequest, resp : HttpServletResponse) = {
    process(req, resp)
  }

  private def process(req : HttpServletRequest, resp : HttpServletResponse) {
    val commandJson = req.getParameter("command")
    if (commandJson == null) {
      resp.getWriter().print(write(ErrorDto("command has to be set!")))
      return
    } else {
      val json = parse(commandJson)
      val commandName = (json \ "commandName").extract[String]
      val command = commands.get(commandName)

      if (!command.isDefined) {
        resp.getWriter().print(write(ErrorDto("Incorrect command name: " + commandName)))
      } else {
        command.get.execute(json)
        match {
          case Left(x) => resp.getWriter().print(write(x))
          case Right(x) => resp.getWriter().print(write(x))
        }

      }
    }
  }

  val commands = Map[String, { def execute(parsedJson: JValue): Either[AnyRef, ErrorDto] }] (
    LOGIN.name -> new LoginCommand()
  )

}
