package com.autentia.tutorial.websockets.messages;


public class StatusInfo {

	  private final String user;

      private final STATUS status;

      public StatusInfo(String user, STATUS status) {
      	System.out.println("new StatusInfo user:"+user+" status:"+status);
          this.user = user;
          this.status = status;
      }

      public String getUser() {
          return user;
      }

      public STATUS getStatus() {
          return status;
      }
}
