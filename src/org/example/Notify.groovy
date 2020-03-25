package org.example
import org.example.Constants

class Notify {
  def exec(Map config=[:]) {
    if (config.type == "slack") {
    echo Constants.SLACK_MESSAGE
    echo config.message
  } else {
    echo Constants.EMAIL_MESSAGE
    echo config.message  
  }
}
