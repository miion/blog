import ChatRoot from "@/features/chat/ChatRoot"
import PERMISSION from "@/infrastructure/constants/permission.constant"
import * as React from "react"

const Chat = () => {
  return <ChatRoot />
}

Chat.permission = PERMISSION.CHAT

export default Chat
