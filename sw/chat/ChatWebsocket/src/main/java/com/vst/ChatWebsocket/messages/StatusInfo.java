package com.vst.ChatWebsocket.messages;
class StatusInfo {

        private final String user;

        private final STATUS status;

        public StatusInfo(String user, STATUS status) {
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